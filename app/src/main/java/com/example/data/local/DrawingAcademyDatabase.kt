package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        LessonProgressEntity::class,
        SkillMasteryEntity::class,
        ExerciseLogEntity::class,
        MilestoneProgressEntity::class,
        DailyActivityEntity::class,
        JournalEntryEntity::class,
        AchievementEntity::class,
        ObservationCompletionEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class DrawingAcademyDatabase : RoomDatabase() {
    abstract fun lessonProgressDao(): LessonProgressDao
    abstract fun skillMasteryDao(): SkillMasteryDao
    abstract fun exerciseLogDao(): ExerciseLogDao
    abstract fun milestoneProgressDao(): MilestoneProgressDao
    abstract fun dailyActivityDao(): DailyActivityDao
    abstract fun journalEntryDao(): JournalEntryDao
    abstract fun achievementDao(): AchievementDao
    abstract fun observationCompletionDao(): ObservationCompletionDao

    companion object {
        @Volatile
        private var INSTANCE: DrawingAcademyDatabase? = null

        fun getInstance(context: Context): DrawingAcademyDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DrawingAcademyDatabase::class.java,
                    "drawing_academy.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
