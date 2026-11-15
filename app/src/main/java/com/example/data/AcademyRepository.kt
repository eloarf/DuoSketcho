package com.example.data

import android.app.NotificationManager
import android.content.Context
import androidx.room.withTransaction
import com.example.data.backup.BackupManager
import com.example.data.curriculum.CurriculumCatalog
import com.example.data.local.AchievementEntity
import com.example.data.local.DailyActivityEntity
import com.example.data.local.DrawingAcademyDatabase
import com.example.data.local.ExerciseLogEntity
import com.example.data.local.JournalEntryEntity
import com.example.data.local.LessonProgressEntity
import com.example.data.local.MilestoneProgressEntity
import com.example.data.local.ObservationCompletionEntity
import com.example.data.local.SkillMasteryEntity
import com.example.data.local.UserPreferences
import com.example.data.local.UserPreferencesRepository
import com.example.domain.engine.AchievementEngine
import com.example.domain.engine.DateTimeUtils
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.engine.StreakAndXpEngine
import com.example.domain.model.AchievementDefinition
import com.example.domain.model.DifficultyRating
import com.example.domain.model.GuidedSessionPlan
import com.example.domain.model.Lesson
import com.example.domain.model.MilestoneProject
import com.example.domain.model.ObservationChallenge
import com.example.notifications.NotificationHelper
import com.example.notifications.ReminderScheduler
import com.example.ui.theme.ThemePreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlin.math.max

data class PracticeCompletionResult(
    val xpEarned: Int,
    val minutesAdded: Int,
    val newAchievements: List<AchievementDefinition>,
    val earnedFreeze: Boolean,
    val goalJustMet: Boolean
)

data class AcademySnapshot(
    val preferences: UserPreferences,
    val lessonProgress: List<LessonProgressEntity>,
    val skillMasteries: List<SkillMasteryEntity>,
    val exerciseLogs: List<ExerciseLogEntity>,
    val milestones: List<MilestoneProgressEntity>,
    val dailyActivities: List<DailyActivityEntity>,
    val journalEntries: List<JournalEntryEntity>,
    val achievements: List<AchievementEntity>,
    val observationCompletions: List<ObservationCompletionEntity>
)

class AcademyRepository(
    private val context: Context,
    private val db: DrawingAcademyDatabase = DrawingAcademyDatabase.getInstance(context),
    val prefsRepo: UserPreferencesRepository = UserPreferencesRepository(context)
) {

    @Suppress("UNCHECKED_CAST")
    val snapshotFlow: Flow<AcademySnapshot> = combine(
        prefsRepo.preferencesFlow,
        db.lessonProgressDao().observeAll(),
        db.skillMasteryDao().observeAll(),
        db.exerciseLogDao().observeAll(),
        db.milestoneProgressDao().observeAll(),
        db.dailyActivityDao().observeAll(),
        db.journalEntryDao().observeAll(),
        db.achievementDao().observeAll(),
        db.observationCompletionDao().observeAll()
    ) { values: Array<Any?> ->
        AcademySnapshot(
            preferences = values[0] as UserPreferences,
            lessonProgress = values[1] as List<LessonProgressEntity>,
            skillMasteries = values[2] as List<SkillMasteryEntity>,
            exerciseLogs = values[3] as List<ExerciseLogEntity>,
            milestones = values[4] as List<MilestoneProgressEntity>,
            dailyActivities = values[5] as List<DailyActivityEntity>,
            journalEntries = values[6] as List<JournalEntryEntity>,
            achievements = values[7] as List<AchievementEntity>,
            observationCompletions = values[8] as List<ObservationCompletionEntity>
        )
    }

    suspend fun completeLesson(
        lesson: Lesson,
        rating: DifficultyRating,
        checklistRatio: Float,
        minutesPracticed: Int,
        includeChallenge: Boolean,
        reflectionNote: String = "",
        needsImprovementNote: String = ""
    ): PracticeCompletionResult {
        val now = System.currentTimeMillis()
        val today = DateTimeUtils.currentEpochDay(now)
        val effectiveMinutes = minutesPracticed.coerceAtLeast(3)
        val prefs = prefsRepo.getPreferencesOnce()

        val existingLesson = db.lessonProgressDao().getById(lesson.id)
        val isFirst = (existingLesson?.completedCount ?: 0) == 0
        val isSameDayRepeat = existingLesson?.lastCompletedEpochDay == today

        val xpEarned = StreakAndXpEngine.calculateLessonXp(
            baseXp = lesson.xpReward,
            isFirstCompletion = isFirst,
            isSameDayRepeat = isSameDayRepeat,
            difficulty = rating,
            checklistRatio = checklistRatio,
            includeChallenge = includeChallenge
        )

        val skillsToUpdate = (listOf(lesson.primarySkillId) + lesson.reinforcedSkillIds).distinct()

        db.withTransaction {
            db.lessonProgressDao().upsert(
                LessonProgressEntity(
                    lessonId = lesson.id,
                    worldNumber = lesson.worldNumber,
                    completedCount = (existingLesson?.completedCount ?: 0) + 1,
                    bestChecklistRatio = max(existingLesson?.bestChecklistRatio ?: 0f, checklistRatio),
                    lastDifficulty = rating.name,
                    lastCompletedEpochDay = today,
                    lastCompletedAtMillis = now,
                    challengeCompleted = (existingLesson?.challengeCompleted == true) || includeChallenge
                )
            )

            skillsToUpdate.forEachIndexed { idx, skillId ->
                val existingSkill = db.skillMasteryDao().getById(skillId)
                val updated = SpacedRepetitionEngine.recordSkillPractice(
                    existing = existingSkill,
                    skillId = skillId,
                    rating = rating,
                    checklistRatio = if (idx == 0) checklistRatio else (checklistRatio * 0.95f),
                    todayEpochDay = today
                )
                db.skillMasteryDao().upsert(updated)
            }

            lesson.exercises.forEach { ex ->
                db.exerciseLogDao().insert(
                    ExerciseLogEntity(
                        exerciseId = ex.id,
                        lessonId = lesson.id,
                        skillId = ex.skillId,
                        difficulty = rating.name,
                        minutesSpent = (effectiveMinutes / 3).coerceAtLeast(1),
                        xpEarned = xpEarned / 3,
                        isReview = false,
                        epochDay = today,
                        timestampMillis = now
                    )
                )
            }
            if (includeChallenge) {
                db.exerciseLogDao().insert(
                    ExerciseLogEntity(
                        exerciseId = lesson.optionalChallenge.id,
                        lessonId = lesson.id,
                        skillId = lesson.optionalChallenge.skillId,
                        difficulty = rating.name,
                        minutesSpent = 5,
                        xpEarned = 15,
                        isReview = false,
                        epochDay = today,
                        timestampMillis = now
                    )
                )
            }

            if (reflectionNote.isNotBlank() || needsImprovementNote.isNotBlank()) {
                db.journalEntryDao().insert(
                    JournalEntryEntity(
                        timestampMillis = now,
                        epochDay = today,
                        lessonId = lesson.id,
                        title = lesson.title,
                        durationMinutes = effectiveMinutes,
                        difficulty = rating.label,
                        reflection = reflectionNote.ifBlank { "Completed lesson exercises in sketchbook." },
                        needsImprovement = needsImprovementNote
                    )
                )
            }
        }

        val exerciseCountDelta = lesson.exercises.size + if (includeChallenge) 1 else 0
        return finalizePracticeDay(
            today = today,
            now = now,
            minutesDelta = effectiveMinutes,
            xpBase = xpEarned,
            sessionsDelta = 1,
            exercisesDelta = exerciseCountDelta,
            reviewsDelta = 0,
            prefs = prefs
        )
    }

    suspend fun completeGuidedSession(
        plan: GuidedSessionPlan,
        rating: DifficultyRating,
        checklistRatio: Float,
        minutesPracticed: Int,
        reflectionNote: String = "",
        needsImprovementNote: String = ""
    ): PracticeCompletionResult {
        val now = System.currentTimeMillis()
        val today = DateTimeUtils.currentEpochDay(now)
        val effectiveMinutes = minutesPracticed.coerceAtLeast(5)
        val prefs = prefsRepo.getPreferencesOnce()

        val lessonIds = plan.steps.mapNotNull { it.lessonId }.distinct()
        val mainLesson = lessonIds.firstOrNull()?.let { CurriculumCatalog.getLessonById(it) }
        val isSameDayRepeat = mainLesson?.let {
            db.lessonProgressDao().getById(it.id)?.lastCompletedEpochDay == today
        } ?: false

        val xpBase = if (isSameDayRepeat) (plan.estimatedXp * 0.6f).toInt() else plan.estimatedXp

        db.withTransaction {
            if (mainLesson != null) {
                val existingLesson = db.lessonProgressDao().getById(mainLesson.id)
                val includedChallenge = plan.steps.any { it.isOptionalChallenge }
                db.lessonProgressDao().upsert(
                    LessonProgressEntity(
                        lessonId = mainLesson.id,
                        worldNumber = mainLesson.worldNumber,
                        completedCount = (existingLesson?.completedCount ?: 0) + 1,
                        bestChecklistRatio = max(existingLesson?.bestChecklistRatio ?: 0f, checklistRatio),
                        lastDifficulty = rating.name,
                        lastCompletedEpochDay = today,
                        lastCompletedAtMillis = now,
                        challengeCompleted = (existingLesson?.challengeCompleted == true) || includedChallenge
                    )
                )
            }

            val updatedSkills = mutableSetOf<String>()
            var reviewStepsCount = 0
            plan.steps.forEach { step ->
                if (step.isReview) reviewStepsCount++
                if (updatedSkills.add(step.skillId)) {
                    val existingSkill = db.skillMasteryDao().getById(step.skillId)
                    val updated = SpacedRepetitionEngine.recordSkillPractice(
                        existing = existingSkill,
                        skillId = step.skillId,
                        rating = rating,
                        checklistRatio = checklistRatio,
                        todayEpochDay = today
                    )
                    db.skillMasteryDao().upsert(updated)
                }
                db.exerciseLogDao().insert(
                    ExerciseLogEntity(
                        exerciseId = "session_${plan.mode.name}_${step.stepIndex}",
                        lessonId = step.lessonId ?: "warmup",
                        skillId = step.skillId,
                        difficulty = rating.name,
                        minutesSpent = step.durationMinutes,
                        xpEarned = xpBase / plan.steps.size.coerceAtLeast(1),
                        isReview = step.isReview,
                        epochDay = today,
                        timestampMillis = now
                    )
                )
            }

            if (reflectionNote.isNotBlank() || needsImprovementNote.isNotBlank()) {
                db.journalEntryDao().insert(
                    JournalEntryEntity(
                        timestampMillis = now,
                        epochDay = today,
                        lessonId = mainLesson?.id,
                        title = "${plan.mode.label} • ${mainLesson?.title ?: "Atelier Practice"}",
                        durationMinutes = effectiveMinutes,
                        difficulty = rating.label,
                        reflection = reflectionNote.ifBlank { "Completed guided multi-stage session." },
                        needsImprovement = needsImprovementNote
                    )
                )
            }
        }

        val reviewCount = plan.steps.count { it.isReview }
        val exerciseCount = plan.steps.count { !it.isReview }
        return finalizePracticeDay(
            today = today,
            now = now,
            minutesDelta = effectiveMinutes,
            xpBase = xpBase,
            sessionsDelta = 1,
            exercisesDelta = exerciseCount,
            reviewsDelta = reviewCount,
            prefs = prefs
        )
    }

    suspend fun completeSkillReview(
        skillId: String,
        rating: DifficultyRating,
        checklistRatio: Float,
        minutesPracticed: Int
    ): PracticeCompletionResult {
        val now = System.currentTimeMillis()
        val today = DateTimeUtils.currentEpochDay(now)
        val effectiveMinutes = minutesPracticed.coerceAtLeast(2)
        val prefs = prefsRepo.getPreferencesOnce()

        val existingSkill = db.skillMasteryDao().getById(skillId)
        val isDue = existingSkill == null || SpacedRepetitionEngine.isSkillDue(existingSkill, today)
        val xpBase = StreakAndXpEngine.calculateReviewXp(rating, checklistRatio, isDue)

        db.withTransaction {
            val updated = SpacedRepetitionEngine.recordSkillPractice(
                existing = existingSkill,
                skillId = skillId,
                rating = rating,
                checklistRatio = checklistRatio,
                todayEpochDay = today
            )
            db.skillMasteryDao().upsert(updated)
            db.exerciseLogDao().insert(
                ExerciseLogEntity(
                    exerciseId = "review_$skillId",
                    lessonId = "review_queue",
                    skillId = skillId,
                    difficulty = rating.name,
                    minutesSpent = effectiveMinutes,
                    xpEarned = xpBase,
                    isReview = true,
                    epochDay = today,
                    timestampMillis = now
                )
            )
        }

        return finalizePracticeDay(
            today = today,
            now = now,
            minutesDelta = effectiveMinutes,
            xpBase = xpBase,
            sessionsDelta = 1,
            exercisesDelta = 0,
            reviewsDelta = 1,
            prefs = prefs
        )
    }

    suspend fun completeMilestone(
        project: MilestoneProject,
        minutesPracticed: Int,
        notes: String
    ): PracticeCompletionResult {
        val now = System.currentTimeMillis()
        val today = DateTimeUtils.currentEpochDay(now)
        val effectiveMinutes = minutesPracticed.coerceAtLeast(10)
        val prefs = prefsRepo.getPreferencesOnce()

        val existing = db.milestoneProgressDao().getAllOnce().find { it.milestoneId == project.id }
        val xpBase = if (existing?.completed == true) project.xpReward / 3 else project.xpReward

        db.withTransaction {
            db.milestoneProgressDao().upsert(
                MilestoneProgressEntity(
                    milestoneId = project.id,
                    worldNumber = project.worldNumber,
                    completed = true,
                    completedAtMillis = now,
                    notes = notes
                )
            )
            val worldSkills = CurriculumCatalog.skills.filter { it.worldNumber == project.worldNumber }
            worldSkills.forEach { sk ->
                val cur = db.skillMasteryDao().getById(sk.id)
                val updated = SpacedRepetitionEngine.recordSkillPractice(
                    existing = cur,
                    skillId = sk.id,
                    rating = DifficultyRating.OKAY,
                    checklistRatio = 0.9f,
                    todayEpochDay = today
                )
                db.skillMasteryDao().upsert(updated)
            }
            if (notes.isNotBlank()) {
                db.journalEntryDao().insert(
                    JournalEntryEntity(
                        timestampMillis = now,
                        epochDay = today,
                        lessonId = project.id,
                        title = "World ${project.worldNumber} Milestone: ${project.title}",
                        durationMinutes = effectiveMinutes,
                        difficulty = "Milestone",
                        reflection = notes,
                        needsImprovement = ""
                    )
                )
            }
        }

        return finalizePracticeDay(
            today = today,
            now = now,
            minutesDelta = effectiveMinutes,
            xpBase = xpBase,
            sessionsDelta = 1,
            exercisesDelta = 1,
            reviewsDelta = 0,
            prefs = prefs
        )
    }

    suspend fun completeObservationChallenge(
        challenge: ObservationChallenge,
        minutesPracticed: Int,
        reflection: String
    ): PracticeCompletionResult {
        val now = System.currentTimeMillis()
        val today = DateTimeUtils.currentEpochDay(now)
        val effectiveMinutes = minutesPracticed.coerceAtLeast(5)
        val prefs = prefsRepo.getPreferencesOnce()

        val existing = db.observationCompletionDao().getAllOnce().find { it.challengeId == challenge.id }
        val xpBase = if ((existing?.completionCount ?: 0) > 0) challenge.xpReward / 2 else challenge.xpReward

        db.withTransaction {
            db.observationCompletionDao().upsert(
                ObservationCompletionEntity(
                    challengeId = challenge.id,
                    completionCount = (existing?.completionCount ?: 0) + 1,
                    lastCompletedMillis = now
                )
            )
            if (reflection.isNotBlank()) {
                db.journalEntryDao().insert(
                    JournalEntryEntity(
                        timestampMillis = now,
                        epochDay = today,
                        lessonId = challenge.id,
                        title = "Observation: ${challenge.title}",
                        durationMinutes = effectiveMinutes,
                        difficulty = "Observation",
                        reflection = reflection,
                        needsImprovement = ""
                    )
                )
            }
        }

        return finalizePracticeDay(
            today = today,
            now = now,
            minutesDelta = effectiveMinutes,
            xpBase = xpBase,
            sessionsDelta = 1,
            exercisesDelta = 1,
            reviewsDelta = 0,
            prefs = prefs
        )
    }

    suspend fun addJournalEntry(
        title: String,
        durationMinutes: Int,
        difficulty: String,
        reflection: String,
        needsImprovement: String,
        lessonId: String? = null
    ) {
        val now = System.currentTimeMillis()
        val today = DateTimeUtils.currentEpochDay(now)
        db.journalEntryDao().insert(
            JournalEntryEntity(
                timestampMillis = now,
                epochDay = today,
                lessonId = lessonId,
                title = title,
                durationMinutes = durationMinutes.coerceAtLeast(1),
                difficulty = difficulty,
                reflection = reflection,
                needsImprovement = needsImprovement
            )
        )
        evaluateAndUnlockAchievements(now, today)
    }

    suspend fun deleteJournalEntry(id: Long) {
        db.journalEntryDao().deleteById(id)
    }

    private suspend fun finalizePracticeDay(
        today: Long,
        now: Long,
        minutesDelta: Int,
        xpBase: Int,
        sessionsDelta: Int,
        exercisesDelta: Int,
        reviewsDelta: Int,
        prefs: UserPreferences
    ): PracticeCompletionResult {
        val currentDay = db.dailyActivityDao().getByDay(today)
        val wasGoalMet = currentDay?.goalMet == true
        val updatedMinutes = (currentDay?.minutesPracticed ?: 0) + minutesDelta
        val updatedGoalMet = updatedMinutes >= prefs.dailyGoalMinutes

        db.dailyActivityDao().upsert(
            DailyActivityEntity(
                epochDay = today,
                minutesPracticed = updatedMinutes,
                xpEarned = (currentDay?.xpEarned ?: 0) + xpBase,
                sessionsCompleted = (currentDay?.sessionsCompleted ?: 0) + sessionsDelta,
                exercisesCompleted = (currentDay?.exercisesCompleted ?: 0) + exercisesDelta,
                reviewsCompleted = (currentDay?.reviewsCompleted ?: 0) + reviewsDelta,
                goalMinutesTarget = prefs.dailyGoalMinutes,
                goalMet = updatedGoalMet,
                freezeUsed = currentDay?.freezeUsed ?: false
            )
        )

        val allDays = db.dailyActivityDao().getAllOnce()
        val streak = StreakAndXpEngine.computeStreak(
            activities = allDays,
            todayEpochDay = today,
            availableFreezes = prefs.streakFreezes,
            lastFreezeAwardStreak = prefs.lastFreezeAwardStreak
        )

        // Persist any freeze consumed on missed intermediate days
        streak.freezeUsedDays.forEach { frozenDay ->
            val existing = db.dailyActivityDao().getByDay(frozenDay)
            if (existing == null) {
                db.dailyActivityDao().upsert(
                    DailyActivityEntity(
                        epochDay = frozenDay,
                        goalMinutesTarget = prefs.dailyGoalMinutes,
                        freezeUsed = true
                    )
                )
            } else if (!existing.freezeUsed) {
                db.dailyActivityDao().upsert(existing.copy(freezeUsed = true))
            }
        }

        if (streak.remainingFreezes != prefs.streakFreezes || streak.newFreezeEarned) {
            prefsRepo.setStreakFreezes(
                count = streak.remainingFreezes,
                lastAwardStreak = if (streak.newFreezeEarned) streak.currentStreak else null
            )
        }

        val unlocked = evaluateAndUnlockAchievements(now, today)
        val bonusXp = unlocked.sumOf { it.xpBonus }
        if (bonusXp > 0) {
            val latestToday = db.dailyActivityDao().getByDay(today)
            if (latestToday != null) {
                db.dailyActivityDao().upsert(latestToday.copy(xpEarned = latestToday.xpEarned + bonusXp))
            }
        }

        // Cancel daily & streak notifications for today since meaningful practice happened
        val notifMgr = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
        notifMgr?.cancel(NotificationHelper.NOTIF_ID_DAILY)
        notifMgr?.cancel(NotificationHelper.NOTIF_ID_STREAK)

        if (prefs.achievementAlertsEnabled && unlocked.isNotEmpty()) {
            unlocked.forEachIndexed { idx, ach ->
                NotificationHelper.showNotification(
                    context = context,
                    channelId = NotificationHelper.CHANNEL_ACHIEVEMENT,
                    notificationId = NotificationHelper.NOTIF_ID_ACHIEVEMENT_BASE + idx + ach.id.hashCode(),
                    title = "Achievement Unlocked: ${ach.title}",
                    body = "${ach.description} (+${ach.xpBonus} XP)"
                )
            }
        }

        return PracticeCompletionResult(
            xpEarned = xpBase + bonusXp,
            minutesAdded = minutesDelta,
            newAchievements = unlocked,
            earnedFreeze = streak.newFreezeEarned,
            goalJustMet = !wasGoalMet && updatedGoalMet
        )
    }

    private suspend fun evaluateAndUnlockAchievements(now: Long, today: Long): List<AchievementDefinition> {
        val prefs = prefsRepo.getPreferencesOnce()
        val activities = db.dailyActivityDao().getAllOnce()
        val streak = StreakAndXpEngine.computeStreak(
            activities = activities,
            todayEpochDay = today,
            availableFreezes = prefs.streakFreezes,
            lastFreezeAwardStreak = prefs.lastFreezeAwardStreak
        )
        val alreadyIds = db.achievementDao().getAllOnce().map { it.achievementId }.toSet()
        val logs = db.exerciseLogDao().getAllOnce()
        val totalReviews = logs.count { it.isReview } + activities.sumOf { it.reviewsCompleted }
        val totalExercises = activities.sumOf { it.exercisesCompleted }

        val newlyUnlocked = AchievementEngine.evaluateNewAchievements(
            AchievementEngine.EvaluationInput(
                currentStreak = streak.currentStreak,
                longestStreak = streak.longestStreak,
                lessonProgress = db.lessonProgressDao().getAllOnce(),
                skillMasteries = db.skillMasteryDao().getAllOnce(),
                dailyActivities = activities,
                milestones = db.milestoneProgressDao().getAllOnce(),
                totalJournalEntries = db.journalEntryDao().getAllOnce().size,
                totalObservationCompletions = db.observationCompletionDao().getAllOnce().sumOf { it.completionCount },
                totalReviewsCompleted = max(totalReviews / 2, activities.sumOf { it.reviewsCompleted }),
                totalExercisesCompleted = totalExercises,
                alreadyUnlockedIds = alreadyIds
            )
        )

        if (newlyUnlocked.isNotEmpty()) {
            db.achievementDao().insertAll(
                newlyUnlocked.map { AchievementEntity(it.id, now) }
            )
        }
        return newlyUnlocked
    }

    suspend fun setDailyGoalMinutes(minutes: Int) {
        prefsRepo.setDailyGoalMinutes(minutes)
        val today = DateTimeUtils.currentEpochDay()
        val day = db.dailyActivityDao().getByDay(today)
        if (day != null) {
            db.dailyActivityDao().upsert(
                day.copy(
                    goalMinutesTarget = minutes,
                    goalMet = day.minutesPracticed >= minutes
                )
            )
        }
    }

    suspend fun setWeeklyGoalSessions(sessions: Int) {
        prefsRepo.setWeeklyGoalSessions(sessions)
    }

    suspend fun setThemePreference(theme: ThemePreference) {
        prefsRepo.setThemePreference(theme)
    }

    suspend fun updateNotificationSettings(
        dailyEnabled: Boolean? = null,
        hour: Int? = null,
        minute: Int? = null,
        streakEnabled: Boolean? = null,
        reviewEnabled: Boolean? = null,
        weeklyEnabled: Boolean? = null,
        achievementEnabled: Boolean? = null
    ) {
        prefsRepo.updateNotificationSettings(
            dailyEnabled = dailyEnabled,
            hour = hour,
            minute = minute,
            streakEnabled = streakEnabled,
            reviewEnabled = reviewEnabled,
            weeklyEnabled = weeklyEnabled,
            achievementEnabled = achievementEnabled
        )
        val updated = prefsRepo.getPreferencesOnce()
        ReminderScheduler.scheduleAll(context, updated)
    }

    suspend fun exportBackup(uri: android.net.Uri): Result<Unit> =
        BackupManager.writeToUri(context, uri, db, prefsRepo)

    suspend fun importBackup(uri: android.net.Uri): Result<Int> {
        val result = BackupManager.readFromUri(context, uri, db, prefsRepo)
        if (result.isSuccess) {
            val prefs = prefsRepo.getPreferencesOnce()
            ReminderScheduler.scheduleAll(context, prefs)
        }
        return result
    }

    suspend fun resetAllProgress() {
        db.withTransaction {
            db.lessonProgressDao().clearAll()
            db.skillMasteryDao().clearAll()
            db.exerciseLogDao().clearAll()
            db.milestoneProgressDao().clearAll()
            db.dailyActivityDao().clearAll()
            db.journalEntryDao().clearAll()
            db.achievementDao().clearAll()
            db.observationCompletionDao().clearAll()
        }
        prefsRepo.resetDefaults()
        val prefs = prefsRepo.getPreferencesOnce()
        ReminderScheduler.scheduleAll(context, prefs)
    }
}
