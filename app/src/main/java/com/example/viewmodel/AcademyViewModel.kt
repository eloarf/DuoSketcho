package com.example.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AcademyRepository
import com.example.data.AcademySnapshot
import com.example.data.PracticeCompletionResult
import com.example.data.curriculum.CurriculumCatalog
import com.example.data.curriculum.ReferenceLibraryData
import com.example.data.local.DailyActivityEntity
import com.example.data.local.JournalEntryEntity
import com.example.data.local.LessonProgressEntity
import com.example.data.local.MilestoneProgressEntity
import com.example.data.local.ObservationCompletionEntity
import com.example.data.local.SkillMasteryEntity
import com.example.data.local.UserPreferences
import com.example.domain.engine.DateTimeUtils
import com.example.domain.engine.SessionBuilderEngine
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.engine.StreakAndXpEngine
import com.example.domain.engine.StreakSummary
import com.example.domain.engine.WeeklyReportEngine
import com.example.domain.model.AchievementDefinition
import com.example.domain.model.DifficultyRating
import com.example.domain.model.GuidedSessionPlan
import com.example.domain.model.LearnerLevel
import com.example.domain.model.Lesson
import com.example.domain.model.MasteryLevel
import com.example.domain.model.MilestoneProject
import com.example.domain.model.ObservationChallenge
import com.example.domain.model.SessionMode
import com.example.domain.model.SkillDefinition
import com.example.domain.model.WeeklyReport
import com.example.domain.model.WorldProgressSummary
import com.example.ui.theme.ThemePreference
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class DueSkillItem(
    val skill: SkillDefinition,
    val mastery: SkillMasteryEntity,
    val recommendedLesson: Lesson?
)

data class UnlockedAchievementItem(
    val definition: AchievementDefinition,
    val unlockedAtMillis: Long
)

data class AcademyUiState(
    val isLoading: Boolean = true,
    val todayEpochDay: Long = DateTimeUtils.currentEpochDay(),
    val preferences: UserPreferences = UserPreferences(),
    val streakSummary: StreakSummary = StreakSummary(0, 0, 0, 0, false, emptySet(), 1, false),
    val learnerLevel: LearnerLevel = StreakAndXpEngine.computeLearnerLevel(0),
    val totalXp: Int = 0,
    val totalMinutes: Int = 0,
    val totalSessions: Int = 0,
    val totalExercises: Int = 0,
    val totalReviews: Int = 0,
    val worldSummaries: List<WorldProgressSummary> = emptyList(),
    val currentWorldSummary: WorldProgressSummary? = null,
    val nextLesson: Lesson = CurriculumCatalog.allLessons.first(),
    val lessonProgressMap: Map<String, LessonProgressEntity> = emptyMap(),
    val skillMasteryMap: Map<String, SkillMasteryEntity> = emptyMap(),
    val milestoneMap: Map<String, MilestoneProgressEntity> = emptyMap(),
    val observationMap: Map<String, ObservationCompletionEntity> = emptyMap(),
    val dueSkills: List<DueSkillItem> = emptyList(),
    val weakSkills: List<DueSkillItem> = emptyList(),
    val weeklyReport: WeeklyReport = WeeklyReport(0, 0, 0, 0, 0, emptyList(), emptyList(), 0),
    val dailyActivityMap: Map<Long, DailyActivityEntity> = emptyMap(),
    val masteryDistribution: Map<MasteryLevel, Int> = emptyMap(),
    val skillsIntroducedCount: Int = 0,
    val skillsMasteredCount: Int = 0,
    val lessonsCompletedCount: Int = 0,
    val totalLessonsCount: Int = CurriculumCatalog.allLessons.size,
    val totalCurriculumExercises: Int = CurriculumCatalog.totalExerciseCount(),
    val journalEntries: List<JournalEntryEntity> = emptyList(),
    val unlockedAchievements: List<UnlockedAchievementItem> = emptyList(),
    val quickSessionPlan: GuidedSessionPlan? = null,
    val deepSessionPlan: GuidedSessionPlan? = null,
    val timerRunning: Boolean = false,
    val timerSeconds: Int = 0,
    val lastCompletionResult: PracticeCompletionResult? = null,
    val statusMessage: String? = null
)

class AcademyViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = AcademyRepository(application.applicationContext)

    private val timerRunningFlow = MutableStateFlow(false)
    private val timerSecondsFlow = MutableStateFlow(0)
    private val lastCompletionFlow = MutableStateFlow<PracticeCompletionResult?>(null)
    private val statusMessageFlow = MutableStateFlow<String?>(null)
    private var timerJob: Job? = null

    val uiState: StateFlow<AcademyUiState> = combine(
        repository.snapshotFlow,
        timerRunningFlow,
        timerSecondsFlow,
        lastCompletionFlow,
        statusMessageFlow
    ) { snapshot, timerRunning, timerSeconds, completion, status ->
        mapSnapshotToState(snapshot, timerRunning, timerSeconds, completion, status)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = AcademyUiState()
    )

    private fun mapSnapshotToState(
        snapshot: AcademySnapshot,
        timerRunning: Boolean,
        timerSeconds: Int,
        completion: PracticeCompletionResult?,
        statusMessage: String?
    ): AcademyUiState {
        val today = DateTimeUtils.currentEpochDay()
        val lessonProgressMap = snapshot.lessonProgress.associateBy { it.lessonId }
        val skillMasteryMap = snapshot.skillMasteries.associateBy { it.skillId }
        val milestoneMap = snapshot.milestones.associateBy { it.milestoneId }
        val observationMap = snapshot.observationCompletions.associateBy { it.challengeId }
        val dailyMap = snapshot.dailyActivities.associateBy { it.epochDay }

        val worldSummaries = SpacedRepetitionEngine.computeWorldSummaries(
            worlds = CurriculumCatalog.worlds,
            lessonProgressMap = lessonProgressMap,
            skillMasteryMap = skillMasteryMap,
            milestoneMap = milestoneMap
        )

        val nextLesson = SessionBuilderEngine.selectNextLesson(worldSummaries, lessonProgressMap)
        val currentWorldSummary = worldSummaries.firstOrNull { it.world.number == nextLesson.worldNumber }
            ?: worldSummaries.firstOrNull()

        val streakSummary = StreakAndXpEngine.computeStreak(
            activities = snapshot.dailyActivities,
            todayEpochDay = today,
            availableFreezes = snapshot.preferences.streakFreezes,
            lastFreezeAwardStreak = snapshot.preferences.lastFreezeAwardStreak
        )

        val totalXp = snapshot.dailyActivities.sumOf { it.xpEarned }
        val totalMinutes = snapshot.dailyActivities.sumOf { it.minutesPracticed }
        val totalSessions = snapshot.dailyActivities.sumOf { it.sessionsCompleted }
        val totalExercises = snapshot.dailyActivities.sumOf { it.exercisesCompleted }
        val totalReviews = snapshot.dailyActivities.sumOf { it.reviewsCompleted }
        val learnerLevel = StreakAndXpEngine.computeLearnerLevel(totalXp)

        val allSkillItems = CurriculumCatalog.skills.map { sk ->
            val entity = skillMasteryMap[sk.id] ?: SkillMasteryEntity(skillId = sk.id)
            val lesson = CurriculumCatalog.allLessons.firstOrNull { it.primarySkillId == sk.id }
            DueSkillItem(sk, entity, lesson)
        }

        val dueSkills = allSkillItems
            .filter { SpacedRepetitionEngine.isSkillDue(it.mastery, today) }
            .sortedWith(compareByDescending<DueSkillItem> { it.mastery.isWeak }.thenBy { it.mastery.nextReviewEpochDay })

        val weakSkills = allSkillItems
            .filter { it.mastery.practiceCount > 0 && (it.mastery.isWeak || it.mastery.masteryTierIndex <= 2) }
            .sortedWith(compareByDescending<DueSkillItem> { it.mastery.isWeak }.thenBy { it.mastery.masteryTierIndex })

        val distribution = MasteryLevel.entries.associateWith { tier ->
            CurriculumCatalog.skills.count { sk ->
                (skillMasteryMap[sk.id]?.masteryTierIndex ?: 0) == tier.tierIndex
            }
        }

        val introducedCount = CurriculumCatalog.skills.count { sk ->
            (skillMasteryMap[sk.id]?.masteryTierIndex ?: 0) >= MasteryLevel.INTRODUCED.tierIndex
        }
        val masteredCount = CurriculumCatalog.skills.count { sk ->
            (skillMasteryMap[sk.id]?.masteryTierIndex ?: 0) >= MasteryLevel.MASTERED.tierIndex
        }

        val weeklyReport = WeeklyReportEngine.buildReport(
            activities = snapshot.dailyActivities,
            skillMasteries = snapshot.skillMasteries,
            todayEpochDay = today,
            weeklyGoalSessions = snapshot.preferences.weeklyGoalSessions
        )

        val achievementDefMap = ReferenceLibraryData.achievements.associateBy { it.id }
        val unlockedAchievements = snapshot.achievements.mapNotNull { entity ->
            achievementDefMap[entity.achievementId]?.let { def ->
                UnlockedAchievementItem(def, entity.unlockedAtMillis)
            }
        }

        val quickPlan = SessionBuilderEngine.buildSessionPlan(
            mode = SessionMode.QUICK_10_15,
            nextLesson = nextLesson,
            skillMasteries = snapshot.skillMasteries,
            todayEpochDay = today
        )
        val deepPlan = SessionBuilderEngine.buildSessionPlan(
            mode = SessionMode.DEEP_20_30,
            nextLesson = nextLesson,
            skillMasteries = snapshot.skillMasteries,
            todayEpochDay = today
        )

        return AcademyUiState(
            isLoading = false,
            todayEpochDay = today,
            preferences = snapshot.preferences,
            streakSummary = streakSummary,
            learnerLevel = learnerLevel,
            totalXp = totalXp,
            totalMinutes = totalMinutes,
            totalSessions = totalSessions,
            totalExercises = totalExercises,
            totalReviews = totalReviews,
            worldSummaries = worldSummaries,
            currentWorldSummary = currentWorldSummary,
            nextLesson = nextLesson,
            lessonProgressMap = lessonProgressMap,
            skillMasteryMap = skillMasteryMap,
            milestoneMap = milestoneMap,
            observationMap = observationMap,
            dueSkills = dueSkills,
            weakSkills = weakSkills,
            weeklyReport = weeklyReport,
            dailyActivityMap = dailyMap,
            masteryDistribution = distribution,
            skillsIntroducedCount = introducedCount,
            skillsMasteredCount = masteredCount,
            lessonsCompletedCount = lessonProgressMap.values.count { it.completedCount > 0 },
            journalEntries = snapshot.journalEntries,
            unlockedAchievements = unlockedAchievements,
            quickSessionPlan = quickPlan,
            deepSessionPlan = deepPlan,
            timerRunning = timerRunning,
            timerSeconds = timerSeconds,
            lastCompletionResult = completion,
            statusMessage = statusMessage
        )
    }

    fun startTimer() {
        if (timerRunningFlow.value) return
        timerRunningFlow.value = true
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (timerRunningFlow.value) {
                delay(1000L)
                timerSecondsFlow.value += 1
            }
        }
    }

    fun pauseTimer() {
        timerRunningFlow.value = false
        timerJob?.cancel()
    }

    fun resetTimer() {
        pauseTimer()
        timerSecondsFlow.value = 0
    }

    fun completeLesson(
        lesson: Lesson,
        rating: DifficultyRating,
        checklistRatio: Float,
        includeChallenge: Boolean,
        reflectionNote: String = "",
        needsImprovementNote: String = ""
    ) {
        viewModelScope.launch {
            val timerMinutes = (timerSecondsFlow.value / 60).coerceAtLeast(0)
            val minutes = if (timerMinutes >= 3) timerMinutes else lesson.estimatedMinutes
            val result = repository.completeLesson(
                lesson = lesson,
                rating = rating,
                checklistRatio = checklistRatio,
                minutesPracticed = minutes,
                includeChallenge = includeChallenge,
                reflectionNote = reflectionNote,
                needsImprovementNote = needsImprovementNote
            )
            resetTimer()
            lastCompletionFlow.value = result
        }
    }

    fun completeGuidedSession(
        plan: GuidedSessionPlan,
        rating: DifficultyRating,
        checklistRatio: Float,
        reflectionNote: String = "",
        needsImprovementNote: String = ""
    ) {
        viewModelScope.launch {
            val timerMinutes = (timerSecondsFlow.value / 60).coerceAtLeast(0)
            val minutes = if (timerMinutes >= 5) timerMinutes else plan.totalEstimatedMinutes
            val result = repository.completeGuidedSession(
                plan = plan,
                rating = rating,
                checklistRatio = checklistRatio,
                minutesPracticed = minutes,
                reflectionNote = reflectionNote,
                needsImprovementNote = needsImprovementNote
            )
            resetTimer()
            lastCompletionFlow.value = result
        }
    }

    fun completeSkillReview(
        skillId: String,
        rating: DifficultyRating,
        checklistRatio: Float,
        minutesPracticed: Int = 5
    ) {
        viewModelScope.launch {
            val timerMinutes = (timerSecondsFlow.value / 60).coerceAtLeast(0)
            val minutes = if (timerMinutes >= 2) timerMinutes else minutesPracticed
            val result = repository.completeSkillReview(
                skillId = skillId,
                rating = rating,
                checklistRatio = checklistRatio,
                minutesPracticed = minutes
            )
            resetTimer()
            lastCompletionFlow.value = result
        }
    }

    fun completeMilestone(
        project: MilestoneProject,
        minutesPracticed: Int,
        notes: String
    ) {
        viewModelScope.launch {
            val timerMinutes = (timerSecondsFlow.value / 60).coerceAtLeast(0)
            val minutes = if (timerMinutes >= 10) timerMinutes else minutesPracticed
            val result = repository.completeMilestone(project, minutes, notes)
            resetTimer()
            lastCompletionFlow.value = result
        }
    }

    fun completeObservationChallenge(
        challenge: ObservationChallenge,
        minutesPracticed: Int,
        reflection: String
    ) {
        viewModelScope.launch {
            val timerMinutes = (timerSecondsFlow.value / 60).coerceAtLeast(0)
            val minutes = if (timerMinutes >= 5) timerMinutes else minutesPracticed
            val result = repository.completeObservationChallenge(challenge, minutes, reflection)
            resetTimer()
            lastCompletionFlow.value = result
        }
    }

    fun addJournalEntry(
        title: String,
        durationMinutes: Int,
        difficulty: String,
        reflection: String,
        needsImprovement: String,
        lessonId: String? = null
    ) {
        viewModelScope.launch {
            repository.addJournalEntry(title, durationMinutes, difficulty, reflection, needsImprovement, lessonId)
            statusMessageFlow.value = "Sketchbook reflection saved."
        }
    }

    fun deleteJournalEntry(id: Long) {
        viewModelScope.launch {
            repository.deleteJournalEntry(id)
        }
    }

    fun setDailyGoalMinutes(minutes: Int) {
        viewModelScope.launch {
            repository.setDailyGoalMinutes(minutes)
            statusMessageFlow.value = "Daily goal set to $minutes min."
        }
    }

    fun setWeeklyGoalSessions(sessions: Int) {
        viewModelScope.launch {
            repository.setWeeklyGoalSessions(sessions)
        }
    }

    fun setThemePreference(theme: ThemePreference) {
        viewModelScope.launch {
            repository.setThemePreference(theme)
        }
    }

    fun updateNotificationSettings(
        dailyEnabled: Boolean? = null,
        hour: Int? = null,
        minute: Int? = null,
        streakEnabled: Boolean? = null,
        reviewEnabled: Boolean? = null,
        weeklyEnabled: Boolean? = null,
        achievementEnabled: Boolean? = null
    ) {
        viewModelScope.launch {
            repository.updateNotificationSettings(
                dailyEnabled = dailyEnabled,
                hour = hour,
                minute = minute,
                streakEnabled = streakEnabled,
                reviewEnabled = reviewEnabled,
                weeklyEnabled = weeklyEnabled,
                achievementEnabled = achievementEnabled
            )
        }
    }

    fun exportBackup(uri: Uri) {
        viewModelScope.launch {
            val result = repository.exportBackup(uri)
            statusMessageFlow.value = if (result.isSuccess) {
                "Progress exported cleanly to local JSON backup."
            } else {
                "Backup export failed: ${result.exceptionOrNull()?.message ?: "Unknown error"}"
            }
        }
    }

    fun importBackup(uri: Uri) {
        viewModelScope.launch {
            val result = repository.importBackup(uri)
            statusMessageFlow.value = if (result.isSuccess) {
                "Backup restored (${result.getOrDefault(0)} records imported)."
            } else {
                "Backup import failed: ${result.exceptionOrNull()?.message ?: "Invalid file"}"
            }
        }
    }

    fun resetAllProgress() {
        viewModelScope.launch {
            repository.resetAllProgress()
            statusMessageFlow.value = "All local progress has been reset."
        }
    }

    fun dismissCompletionResult() {
        lastCompletionFlow.value = null
    }

    fun clearStatusMessage() {
        statusMessageFlow.value = null
    }
}
