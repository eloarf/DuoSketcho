package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

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
    version = 2,
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

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE skill_mastery ADD COLUMN lastConfidenceIndex INTEGER NOT NULL DEFAULT 1")
                db.execSQL("ALTER TABLE skill_mastery ADD COLUMN delayedCheckPending INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE skill_mastery ADD COLUMN firstPracticedEpochDay INTEGER NOT NULL DEFAULT 0")
            }
        }

        fun getInstance(context: Context): DrawingAcademyDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DrawingAcademyDatabase::class.java,
                    "drawing_academy.db"
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
