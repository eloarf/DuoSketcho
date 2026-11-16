package com.example.data.local

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "lesson_progress")
data class LessonProgressEntity(
    @PrimaryKey val lessonId: String,
    val worldNumber: Int,
    val completedCount: Int = 0,
    val bestChecklistRatio: Float = 0f,
    val lastDifficulty: String = "OKAY",
    val lastCompletedEpochDay: Long = 0L,
    val lastCompletedAtMillis: Long = 0L,
    val challengeCompleted: Boolean = false
)

@Entity(tableName = "skill_mastery")
data class SkillMasteryEntity(
    @PrimaryKey val skillId: String,
    val masteryTierIndex: Int = 0, // 0..5 matching MasteryLevel
    val practiceCount: Int = 0,
    val distinctDaysPracticed: Int = 0,
    val consecutiveSuccesses: Int = 0,
    val bestChecklistRatio: Float = 0f,
    val easeFactor: Float = 2.0f,
    val intervalDays: Int = 1,
    val nextReviewEpochDay: Long = 0L,
    val lastPracticedEpochDay: Long = 0L,
    val isWeak: Boolean = false,
    val lastConfidenceIndex: Int = 1, // 0=LOW, 1=MODERATE, 2=HIGH
    val delayedCheckPending: Boolean = false,
    val firstPracticedEpochDay: Long = 0L
)

@Entity(tableName = "exercise_logs")
data class ExerciseLogEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val exerciseId: String,
    val lessonId: String,
    val skillId: String,
    val difficulty: String,
    val minutesSpent: Int,
    val xpEarned: Int,
    val isReview: Boolean,
    val epochDay: Long,
    val timestampMillis: Long
)

@Entity(tableName = "milestone_progress")
data class MilestoneProgressEntity(
    @PrimaryKey val milestoneId: String,
    val worldNumber: Int,
    val completed: Boolean = false,
    val completedAtMillis: Long = 0L,
    val notes: String = ""
)

@Entity(tableName = "daily_activity")
data class DailyActivityEntity(
    @PrimaryKey val epochDay: Long,
    val minutesPracticed: Int = 0,
    val xpEarned: Int = 0,
    val sessionsCompleted: Int = 0,
    val exercisesCompleted: Int = 0,
    val reviewsCompleted: Int = 0,
    val goalMinutesTarget: Int = 15,
    val goalMet: Boolean = false,
    val freezeUsed: Boolean = false
)

@Entity(tableName = "journal_entries")
data class JournalEntryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val timestampMillis: Long,
    val epochDay: Long,
    val lessonId: String?,
    val title: String,
    val durationMinutes: Int,
    val difficulty: String,
    val reflection: String,
    val needsImprovement: String
)

@Entity(tableName = "achievements")
data class AchievementEntity(
    @PrimaryKey val achievementId: String,
    val unlockedAtMillis: Long
)

@Entity(tableName = "observation_completions")
data class ObservationCompletionEntity(
    @PrimaryKey val challengeId: String,
    val completionCount: Int = 0,
    val lastCompletedMillis: Long = 0L
)

@Dao
interface LessonProgressDao {
    @Query("SELECT * FROM lesson_progress")
    fun observeAll(): Flow<List<LessonProgressEntity>>

    @Query("SELECT * FROM lesson_progress")
    suspend fun getAllOnce(): List<LessonProgressEntity>

    @Query("SELECT * FROM lesson_progress WHERE lessonId = :lessonId")
    suspend fun getById(lessonId: String): LessonProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(entity: LessonProgressEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(entities: List<LessonProgressEntity>)

    @Query("DELETE FROM lesson_progress")
    suspend fun clearAll()
}

@Dao
interface SkillMasteryDao {
    @Query("SELECT * FROM skill_mastery")
    fun observeAll(): Flow<List<SkillMasteryEntity>>

    @Query("SELECT * FROM skill_mastery")
    suspend fun getAllOnce(): List<SkillMasteryEntity>

    @Query("SELECT * FROM skill_mastery WHERE skillId = :skillId")
    suspend fun getById(skillId: String): SkillMasteryEntity?

    @Query("SELECT * FROM skill_mastery WHERE practiceCount > 0 AND (nextReviewEpochDay <= :todayEpochDay OR isWeak = 1) ORDER BY isWeak DESC, nextReviewEpochDay ASC")
    suspend fun getDueSkillsOnce(todayEpochDay: Long): List<SkillMasteryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(entity: SkillMasteryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(entities: List<SkillMasteryEntity>)

    @Query("DELETE FROM skill_mastery")
    suspend fun clearAll()
}

@Dao
interface ExerciseLogDao {
    @Query("SELECT * FROM exercise_logs ORDER BY timestampMillis DESC")
    fun observeAll(): Flow<List<ExerciseLogEntity>>

    @Query("SELECT * FROM exercise_logs ORDER BY timestampMillis DESC")
    suspend fun getAllOnce(): List<ExerciseLogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: ExerciseLogEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<ExerciseLogEntity>)

    @Query("DELETE FROM exercise_logs")
    suspend fun clearAll()
}

@Dao
interface MilestoneProgressDao {
    @Query("SELECT * FROM milestone_progress")
    fun observeAll(): Flow<List<MilestoneProgressEntity>>

    @Query("SELECT * FROM milestone_progress")
    suspend fun getAllOnce(): List<MilestoneProgressEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(entity: MilestoneProgressEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(entities: List<MilestoneProgressEntity>)

    @Query("DELETE FROM milestone_progress")
    suspend fun clearAll()
}

@Dao
interface DailyActivityDao {
    @Query("SELECT * FROM daily_activity ORDER BY epochDay ASC")
    fun observeAll(): Flow<List<DailyActivityEntity>>

    @Query("SELECT * FROM daily_activity ORDER BY epochDay ASC")
    suspend fun getAllOnce(): List<DailyActivityEntity>

    @Query("SELECT * FROM daily_activity WHERE epochDay = :epochDay")
    suspend fun getByDay(epochDay: Long): DailyActivityEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(entity: DailyActivityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(entities: List<DailyActivityEntity>)

    @Query("DELETE FROM daily_activity")
    suspend fun clearAll()
}

@Dao
interface JournalEntryDao {
    @Query("SELECT * FROM journal_entries ORDER BY timestampMillis DESC")
    fun observeAll(): Flow<List<JournalEntryEntity>>

    @Query("SELECT * FROM journal_entries ORDER BY timestampMillis DESC")
    suspend fun getAllOnce(): List<JournalEntryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: JournalEntryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<JournalEntryEntity>)

    @Query("DELETE FROM journal_entries WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM journal_entries")
    suspend fun clearAll()
}

@Dao
interface AchievementDao {
    @Query("SELECT * FROM achievements ORDER BY unlockedAtMillis DESC")
    fun observeAll(): Flow<List<AchievementEntity>>

    @Query("SELECT * FROM achievements ORDER BY unlockedAtMillis DESC")
    suspend fun getAllOnce(): List<AchievementEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(entities: List<AchievementEntity>)

    @Query("DELETE FROM achievements")
    suspend fun clearAll()
}

@Dao
interface ObservationCompletionDao {
    @Query("SELECT * FROM observation_completions")
    fun observeAll(): Flow<List<ObservationCompletionEntity>>

    @Query("SELECT * FROM observation_completions")
    suspend fun getAllOnce(): List<ObservationCompletionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(entity: ObservationCompletionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(entities: List<ObservationCompletionEntity>)

    @Query("DELETE FROM observation_completions")
    suspend fun clearAll()
}
