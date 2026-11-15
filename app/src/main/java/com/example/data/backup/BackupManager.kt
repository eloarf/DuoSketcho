package com.example.data.backup

import android.content.Context
import android.net.Uri
import androidx.room.withTransaction
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
import com.example.ui.theme.ThemePreference
import org.json.JSONArray
import org.json.JSONObject

object BackupManager {

    private const val SCHEMA_VERSION = 1

    suspend fun exportToJson(
        db: DrawingAcademyDatabase,
        prefsRepo: UserPreferencesRepository
    ): String {
        val prefs = prefsRepo.getPreferencesOnce()
        val lessons = db.lessonProgressDao().getAllOnce()
        val skills = db.skillMasteryDao().getAllOnce()
        val logs = db.exerciseLogDao().getAllOnce()
        val milestones = db.milestoneProgressDao().getAllOnce()
        val activities = db.dailyActivityDao().getAllOnce()
        val journals = db.journalEntryDao().getAllOnce()
        val achievements = db.achievementDao().getAllOnce()
        val observations = db.observationCompletionDao().getAllOnce()

        val root = JSONObject().apply {
            put("schemaVersion", SCHEMA_VERSION)
            put("exportedAtMillis", System.currentTimeMillis())
            put("preferences", JSONObject().apply {
                put("dailyGoalMinutes", prefs.dailyGoalMinutes)
                put("weeklyGoalSessions", prefs.weeklyGoalSessions)
                put("themePreference", prefs.themePreference.name)
                put("streakFreezes", prefs.streakFreezes)
                put("lastFreezeAwardStreak", prefs.lastFreezeAwardStreak)
                put("dailyReminderEnabled", prefs.dailyReminderEnabled)
                put("dailyReminderHour", prefs.dailyReminderHour)
                put("dailyReminderMinute", prefs.dailyReminderMinute)
                put("streakReminderEnabled", prefs.streakReminderEnabled)
                put("reviewReminderEnabled", prefs.reviewReminderEnabled)
                put("weeklySummaryEnabled", prefs.weeklySummaryEnabled)
                put("achievementAlertsEnabled", prefs.achievementAlertsEnabled)
            })
            put("lessonProgress", JSONArray().apply {
                lessons.forEach {
                    put(JSONObject().apply {
                        put("lessonId", it.lessonId)
                        put("worldNumber", it.worldNumber)
                        put("completedCount", it.completedCount)
                        put("bestChecklistRatio", it.bestChecklistRatio.toDouble())
                        put("lastDifficulty", it.lastDifficulty)
                        put("lastCompletedEpochDay", it.lastCompletedEpochDay)
                        put("lastCompletedAtMillis", it.lastCompletedAtMillis)
                        put("challengeCompleted", it.challengeCompleted)
                    })
                }
            })
            put("skillMastery", JSONArray().apply {
                skills.forEach {
                    put(JSONObject().apply {
                        put("skillId", it.skillId)
                        put("masteryTierIndex", it.masteryTierIndex)
                        put("practiceCount", it.practiceCount)
                        put("distinctDaysPracticed", it.distinctDaysPracticed)
                        put("consecutiveSuccesses", it.consecutiveSuccesses)
                        put("bestChecklistRatio", it.bestChecklistRatio.toDouble())
                        put("easeFactor", it.easeFactor.toDouble())
                        put("intervalDays", it.intervalDays)
                        put("nextReviewEpochDay", it.nextReviewEpochDay)
                        put("lastPracticedEpochDay", it.lastPracticedEpochDay)
                        put("isWeak", it.isWeak)
                    })
                }
            })
            put("exerciseLogs", JSONArray().apply {
                logs.forEach {
                    put(JSONObject().apply {
                        put("id", it.id)
                        put("exerciseId", it.exerciseId)
                        put("lessonId", it.lessonId)
                        put("skillId", it.skillId)
                        put("difficulty", it.difficulty)
                        put("minutesSpent", it.minutesSpent)
                        put("xpEarned", it.xpEarned)
                        put("isReview", it.isReview)
                        put("epochDay", it.epochDay)
                        put("timestampMillis", it.timestampMillis)
                    })
                }
            })
            put("milestoneProgress", JSONArray().apply {
                milestones.forEach {
                    put(JSONObject().apply {
                        put("milestoneId", it.milestoneId)
                        put("worldNumber", it.worldNumber)
                        put("completed", it.completed)
                        put("completedAtMillis", it.completedAtMillis)
                        put("notes", it.notes)
                    })
                }
            })
            put("dailyActivity", JSONArray().apply {
                activities.forEach {
                    put(JSONObject().apply {
                        put("epochDay", it.epochDay)
                        put("minutesPracticed", it.minutesPracticed)
                        put("xpEarned", it.xpEarned)
                        put("sessionsCompleted", it.sessionsCompleted)
                        put("exercisesCompleted", it.exercisesCompleted)
                        put("reviewsCompleted", it.reviewsCompleted)
                        put("goalMinutesTarget", it.goalMinutesTarget)
                        put("goalMet", it.goalMet)
                        put("freezeUsed", it.freezeUsed)
                    })
                }
            })
            put("journalEntries", JSONArray().apply {
                journals.forEach {
                    put(JSONObject().apply {
                        put("id", it.id)
                        put("timestampMillis", it.timestampMillis)
                        put("epochDay", it.epochDay)
                        put("lessonId", it.lessonId ?: JSONObject.NULL)
                        put("title", it.title)
                        put("durationMinutes", it.durationMinutes)
                        put("difficulty", it.difficulty)
                        put("reflection", it.reflection)
                        put("needsImprovement", it.needsImprovement)
                    })
                }
            })
            put("achievements", JSONArray().apply {
                achievements.forEach {
                    put(JSONObject().apply {
                        put("achievementId", it.achievementId)
                        put("unlockedAtMillis", it.unlockedAtMillis)
                    })
                }
            })
            put("observationCompletions", JSONArray().apply {
                observations.forEach {
                    put(JSONObject().apply {
                        put("challengeId", it.challengeId)
                        put("completionCount", it.completionCount)
                        put("lastCompletedMillis", it.lastCompletedMillis)
                    })
                }
            })
        }
        return root.toString(2)
    }

    suspend fun importFromJson(
        jsonString: String,
        db: DrawingAcademyDatabase,
        prefsRepo: UserPreferencesRepository
    ): Result<Int> = runCatching {
        val root = JSONObject(jsonString)
        val version = root.optInt("schemaVersion", -1)
        require(version in 1..SCHEMA_VERSION) { "Unsupported backup schema version." }

        val prefsObj = root.getJSONObject("preferences")
        val restoredPrefs = UserPreferences(
            dailyGoalMinutes = prefsObj.optInt("dailyGoalMinutes", 15),
            weeklyGoalSessions = prefsObj.optInt("weeklyGoalSessions", 5),
            themePreference = runCatching {
                ThemePreference.valueOf(prefsObj.optString("themePreference", ThemePreference.SYSTEM.name))
            }.getOrDefault(ThemePreference.SYSTEM),
            streakFreezes = prefsObj.optInt("streakFreezes", 1),
            lastFreezeAwardStreak = prefsObj.optInt("lastFreezeAwardStreak", 0),
            dailyReminderEnabled = prefsObj.optBoolean("dailyReminderEnabled", true),
            dailyReminderHour = prefsObj.optInt("dailyReminderHour", 19),
            dailyReminderMinute = prefsObj.optInt("dailyReminderMinute", 0),
            streakReminderEnabled = prefsObj.optBoolean("streakReminderEnabled", true),
            reviewReminderEnabled = prefsObj.optBoolean("reviewReminderEnabled", true),
            weeklySummaryEnabled = prefsObj.optBoolean("weeklySummaryEnabled", true),
            achievementAlertsEnabled = prefsObj.optBoolean("achievementAlertsEnabled", true)
        )

        val lessons = mutableListOf<LessonProgressEntity>()
        root.optJSONArray("lessonProgress")?.let { arr ->
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                lessons.add(
                    LessonProgressEntity(
                        lessonId = o.getString("lessonId"),
                        worldNumber = o.getInt("worldNumber"),
                        completedCount = o.getInt("completedCount"),
                        bestChecklistRatio = o.getDouble("bestChecklistRatio").toFloat(),
                        lastDifficulty = o.getString("lastDifficulty"),
                        lastCompletedEpochDay = o.getLong("lastCompletedEpochDay"),
                        lastCompletedAtMillis = o.getLong("lastCompletedAtMillis"),
                        challengeCompleted = o.optBoolean("challengeCompleted", false)
                    )
                )
            }
        }

        val skills = mutableListOf<SkillMasteryEntity>()
        root.optJSONArray("skillMastery")?.let { arr ->
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                skills.add(
                    SkillMasteryEntity(
                        skillId = o.getString("skillId"),
                        masteryTierIndex = o.getInt("masteryTierIndex"),
                        practiceCount = o.getInt("practiceCount"),
                        distinctDaysPracticed = o.getInt("distinctDaysPracticed"),
                        consecutiveSuccesses = o.getInt("consecutiveSuccesses"),
                        bestChecklistRatio = o.getDouble("bestChecklistRatio").toFloat(),
                        easeFactor = o.getDouble("easeFactor").toFloat(),
                        intervalDays = o.getInt("intervalDays"),
                        nextReviewEpochDay = o.getLong("nextReviewEpochDay"),
                        lastPracticedEpochDay = o.getLong("lastPracticedEpochDay"),
                        isWeak = o.optBoolean("isWeak", false)
                    )
                )
            }
        }

        val logs = mutableListOf<ExerciseLogEntity>()
        root.optJSONArray("exerciseLogs")?.let { arr ->
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                logs.add(
                    ExerciseLogEntity(
                        id = o.optLong("id", 0L),
                        exerciseId = o.getString("exerciseId"),
                        lessonId = o.getString("lessonId"),
                        skillId = o.getString("skillId"),
                        difficulty = o.getString("difficulty"),
                        minutesSpent = o.getInt("minutesSpent"),
                        xpEarned = o.getInt("xpEarned"),
                        isReview = o.getBoolean("isReview"),
                        epochDay = o.getLong("epochDay"),
                        timestampMillis = o.getLong("timestampMillis")
                    )
                )
            }
        }

        val milestones = mutableListOf<MilestoneProgressEntity>()
        root.optJSONArray("milestoneProgress")?.let { arr ->
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                milestones.add(
                    MilestoneProgressEntity(
                        milestoneId = o.getString("milestoneId"),
                        worldNumber = o.getInt("worldNumber"),
                        completed = o.getBoolean("completed"),
                        completedAtMillis = o.getLong("completedAtMillis"),
                        notes = o.optString("notes", "")
                    )
                )
            }
        }

        val activities = mutableListOf<DailyActivityEntity>()
        root.optJSONArray("dailyActivity")?.let { arr ->
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                activities.add(
                    DailyActivityEntity(
                        epochDay = o.getLong("epochDay"),
                        minutesPracticed = o.getInt("minutesPracticed"),
                        xpEarned = o.getInt("xpEarned"),
                        sessionsCompleted = o.getInt("sessionsCompleted"),
                        exercisesCompleted = o.getInt("exercisesCompleted"),
                        reviewsCompleted = o.getInt("reviewsCompleted"),
                        goalMinutesTarget = o.getInt("goalMinutesTarget"),
                        goalMet = o.getBoolean("goalMet"),
                        freezeUsed = o.optBoolean("freezeUsed", false)
                    )
                )
            }
        }

        val journals = mutableListOf<JournalEntryEntity>()
        root.optJSONArray("journalEntries")?.let { arr ->
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                val lessonIdVal = if (o.isNull("lessonId")) null else o.optString("lessonId")
                journals.add(
                    JournalEntryEntity(
                        id = o.optLong("id", 0L),
                        timestampMillis = o.getLong("timestampMillis"),
                        epochDay = o.getLong("epochDay"),
                        lessonId = lessonIdVal,
                        title = o.getString("title"),
                        durationMinutes = o.getInt("durationMinutes"),
                        difficulty = o.getString("difficulty"),
                        reflection = o.getString("reflection"),
                        needsImprovement = o.optString("needsImprovement", "")
                    )
                )
            }
        }

        val achievements = mutableListOf<AchievementEntity>()
        root.optJSONArray("achievements")?.let { arr ->
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                achievements.add(
                    AchievementEntity(
                        achievementId = o.getString("achievementId"),
                        unlockedAtMillis = o.getLong("unlockedAtMillis")
                    )
                )
            }
        }

        val observations = mutableListOf<ObservationCompletionEntity>()
        root.optJSONArray("observationCompletions")?.let { arr ->
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                observations.add(
                    ObservationCompletionEntity(
                        challengeId = o.getString("challengeId"),
                        completionCount = o.getInt("completionCount"),
                        lastCompletedMillis = o.getLong("lastCompletedMillis")
                    )
                )
            }
        }

        db.withTransaction {
            db.lessonProgressDao().clearAll()
            db.skillMasteryDao().clearAll()
            db.exerciseLogDao().clearAll()
            db.milestoneProgressDao().clearAll()
            db.dailyActivityDao().clearAll()
            db.journalEntryDao().clearAll()
            db.achievementDao().clearAll()
            db.observationCompletionDao().clearAll()

            if (lessons.isNotEmpty()) db.lessonProgressDao().upsertAll(lessons)
            if (skills.isNotEmpty()) db.skillMasteryDao().upsertAll(skills)
            if (logs.isNotEmpty()) db.exerciseLogDao().insertAll(logs)
            if (milestones.isNotEmpty()) db.milestoneProgressDao().upsertAll(milestones)
            if (activities.isNotEmpty()) db.dailyActivityDao().upsertAll(activities)
            if (journals.isNotEmpty()) db.journalEntryDao().insertAll(journals)
            if (achievements.isNotEmpty()) db.achievementDao().insertAll(achievements)
            if (observations.isNotEmpty()) db.observationCompletionDao().upsertAll(observations)
        }

        prefsRepo.restorePreferences(restoredPrefs)
        lessons.size + skills.size + journals.size + activities.size
    }

    suspend fun writeToUri(
        context: Context,
        uri: Uri,
        db: DrawingAcademyDatabase,
        prefsRepo: UserPreferencesRepository
    ): Result<Unit> = runCatching {
        val json = exportToJson(db, prefsRepo)
        context.contentResolver.openOutputStream(uri)?.use { stream ->
            stream.write(json.toByteArray(Charsets.UTF_8))
        } ?: error("Unable to open destination file.")
    }

    suspend fun readFromUri(
        context: Context,
        uri: Uri,
        db: DrawingAcademyDatabase,
        prefsRepo: UserPreferencesRepository
    ): Result<Int> = runCatching {
        val json = context.contentResolver.openInputStream(uri)?.use { stream ->
            stream.bufferedReader(Charsets.UTF_8).readText()
        } ?: error("Unable to read selected backup file.")
        importFromJson(json, db, prefsRepo).getOrThrow()
    }
}
