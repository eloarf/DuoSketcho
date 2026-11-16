package com.example

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.core.app.ApplicationProvider
import com.example.data.AcademyRepository
import com.example.data.backup.BackupManager
import com.example.data.curriculum.CurriculumCatalog
import com.example.data.local.DailyActivityEntity
import com.example.data.local.DrawingAcademyDatabase
import com.example.data.local.JournalEntryEntity
import com.example.data.local.LessonProgressEntity
import com.example.data.local.SkillMasteryEntity
import com.example.data.local.UserPreferencesRepository
import com.example.domain.engine.DateTimeUtils
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.model.ConfidenceLevel
import com.example.domain.model.DifficultyRating
import com.example.notifications.NotificationHelper
import com.example.notifications.ReminderReceiver
import com.example.notifications.ReminderScheduler
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class PersistenceAndNotificationRobolectricTest {

    private lateinit var context: Context
    private lateinit var db: DrawingAcademyDatabase
    private lateinit var prefsRepo: UserPreferencesRepository

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(context, DrawingAcademyDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        prefsRepo = UserPreferencesRepository(context)
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun `app declares zero internet permission for strictly offline guarantee`() {
        val pkgInfo = context.packageManager.getPackageInfo(
            context.packageName,
            PackageManager.GET_PERMISSIONS
        )
        val permissions = pkgInfo.requestedPermissions?.toList().orEmpty()
        assertFalse(Manifest.permission.INTERNET in permissions)
        assertTrue(Manifest.permission.POST_NOTIFICATIONS in permissions)
        assertTrue(Manifest.permission.RECEIVE_BOOT_COMPLETED in permissions)
    }

    @Test
    fun `room migration 1 to 2 preserves existing skill mastery records with clean defaults`() {
        val dbName = "migration_test.db"
        context.deleteDatabase(dbName)
        val helper = FrameworkSQLiteOpenHelperFactory().create(
            SupportSQLiteOpenHelper.Configuration.builder(context)
                .name(dbName)
                .callback(object : SupportSQLiteOpenHelper.Callback(1) {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        db.execSQL(
                            """
                            CREATE TABLE IF NOT EXISTS skill_mastery (
                                skillId TEXT NOT NULL PRIMARY KEY,
                                masteryTierIndex INTEGER NOT NULL,
                                practiceCount INTEGER NOT NULL,
                                distinctDaysPracticed INTEGER NOT NULL,
                                consecutiveSuccesses INTEGER NOT NULL,
                                bestChecklistRatio REAL NOT NULL,
                                easeFactor REAL NOT NULL,
                                intervalDays INTEGER NOT NULL,
                                nextReviewEpochDay INTEGER NOT NULL,
                                lastPracticedEpochDay INTEGER NOT NULL,
                                isWeak INTEGER NOT NULL
                            )
                            """.trimIndent()
                        )
                        db.execSQL(
                            "INSERT INTO skill_mastery VALUES ('sk_eye_hand', 2, 4, 3, 2, 0.85, 2.1, 4, 150, 146, 0)"
                        )
                    }

                    override fun onUpgrade(db: SupportSQLiteDatabase, oldVersion: Int, newVersion: Int) {}
                })
                .build()
        )
        val rawDb = helper.writableDatabase
        DrawingAcademyDatabase.MIGRATION_1_2.migrate(rawDb)

        rawDb.query("SELECT skillId, practiceCount, lastConfidenceIndex, delayedCheckPending, firstPracticedEpochDay FROM skill_mastery WHERE skillId = 'sk_eye_hand'").use { cursor ->
            assertTrue(cursor.moveToFirst())
            assertEquals("sk_eye_hand", cursor.getString(0))
            assertEquals(4, cursor.getInt(1))
            assertEquals(1, cursor.getInt(2))
            assertEquals(0, cursor.getInt(3))
            assertEquals(0L, cursor.getLong(4))
        }
        rawDb.close()
        context.deleteDatabase(dbName)
    }

    @Test
    fun `room persistence and json backup export import round trip accurately`() = runBlocking {
        db.lessonProgressDao().upsert(LessonProgressEntity("w1_u1_l1", 1, completedCount = 2, bestChecklistRatio = 0.9f))
        db.skillMasteryDao().upsert(
            SkillMasteryEntity(
                skillId = "sk_eye_hand",
                masteryTierIndex = 2,
                practiceCount = 3,
                distinctDaysPracticed = 2,
                lastConfidenceIndex = ConfidenceLevel.HIGH.index,
                delayedCheckPending = true,
                firstPracticedEpochDay = 190L
            )
        )
        db.dailyActivityDao().upsert(DailyActivityEntity(epochDay = 200L, minutesPracticed = 25, xpEarned = 65, sessionsCompleted = 1, exercisesCompleted = 3, goalMet = true))
        db.journalEntryDao().insert(JournalEntryEntity(timestampMillis = 12345L, epochDay = 200L, lessonId = "w1_u1_l1", title = "Blind Contour", durationMinutes = 25, difficulty = "Okay", reflection = "Much steadier hand.", needsImprovement = "Slow down edges"))
        prefsRepo.setDailyGoalMinutes(20)

        val json = BackupManager.exportToJson(db, prefsRepo)

        db.lessonProgressDao().clearAll()
        db.skillMasteryDao().clearAll()
        db.dailyActivityDao().clearAll()
        db.journalEntryDao().clearAll()
        prefsRepo.resetDefaults()

        val result = BackupManager.importFromJson(json, db, prefsRepo)
        assertTrue(result.isSuccess)
        assertEquals(20, prefsRepo.getPreferencesOnce().dailyGoalMinutes)
        assertEquals(2, db.lessonProgressDao().getById("w1_u1_l1")?.completedCount)
        val restoredSkill = db.skillMasteryDao().getById("sk_eye_hand")
        assertEquals(3, restoredSkill?.practiceCount)
        assertEquals(ConfidenceLevel.HIGH.index, restoredSkill?.lastConfidenceIndex)
        assertEquals(true, restoredSkill?.delayedCheckPending)
        assertEquals(190L, restoredSkill?.firstPracticedEpochDay)
        assertEquals(1, db.journalEntryDao().getAllOnce().size)
    }

    @Test
    fun `end to end repository lesson and confidence review adapts tutor recommendations`() = runBlocking {
        val repo = AcademyRepository(context, db, prefsRepo)
        val lesson = CurriculumCatalog.allLessons.first()

        val lessonResult = repo.completeLesson(
            lesson = lesson,
            rating = DifficultyRating.DIFFICULT,
            checklistRatio = 0.5f,
            minutesPracticed = 14,
            includeChallenge = false,
            confidence = ConfidenceLevel.LOW
        )
        assertTrue(lessonResult.xpEarned > 0)

        val skillAfterLesson = db.skillMasteryDao().getById(lesson.primarySkillId)
        assertNotNull(skillAfterLesson)
        assertTrue(skillAfterLesson!!.isWeak)
        assertEquals(ConfidenceLevel.LOW.index, skillAfterLesson.lastConfidenceIndex)

        val summaries = SpacedRepetitionEngine.computeWorldSummaries(
            worlds = CurriculumCatalog.worlds,
            lessonProgressMap = db.lessonProgressDao().getAllOnce().associateBy { it.lessonId },
            skillMasteryMap = db.skillMasteryDao().getAllOnce().associateBy { it.skillId },
            milestoneMap = emptyMap()
        )
        val recBeforeReview = SpacedRepetitionEngine.recommendNextTutorAction(
            worldSummaries = summaries,
            lessonProgressMap = db.lessonProgressDao().getAllOnce().associateBy { it.lessonId },
            skillMasteryMap = db.skillMasteryDao().getAllOnce().associateBy { it.skillId },
            todayEpochDay = DateTimeUtils.currentEpochDay()
        )
        assertTrue(recBeforeReview.isWeakSkillReview || recBeforeReview.isPrerequisiteRemediation)

        // Now complete spaced review with High confidence and Easy rating
        repo.completeSkillReview(
            skillId = lesson.primarySkillId,
            rating = DifficultyRating.EASY,
            checklistRatio = 1.0f,
            minutesPracticed = 6,
            confidence = ConfidenceLevel.HIGH
        )
        val skillAfterReview = db.skillMasteryDao().getById(lesson.primarySkillId)!!
        assertEquals(ConfidenceLevel.HIGH.index, skillAfterReview.lastConfidenceIndex)
        assertTrue(skillAfterReview.intervalDays >= 3)
    }

    @Test
    fun `notification channels are registered and daily reminder respects suppression when goal met`() = runBlocking {
        NotificationHelper.createChannels(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            assertNotNull(nm.getNotificationChannel(NotificationHelper.CHANNEL_DAILY))
            assertNotNull(nm.getNotificationChannel(NotificationHelper.CHANNEL_STREAK))
            assertNotNull(nm.getNotificationChannel(NotificationHelper.CHANNEL_REVIEW))
            assertNotNull(nm.getNotificationChannel(NotificationHelper.CHANNEL_WEEKLY))
            assertNotNull(nm.getNotificationChannel(NotificationHelper.CHANNEL_ACHIEVEMENT))
        }

        val appDb = DrawingAcademyDatabase.getInstance(context)
        val today = DateTimeUtils.currentEpochDay()
        appDb.dailyActivityDao().upsert(
            DailyActivityEntity(
                epochDay = today,
                minutesPracticed = 20,
                xpEarned = 40,
                sessionsCompleted = 1,
                exercisesCompleted = 3,
                goalMinutesTarget = 15,
                goalMet = true
            )
        )
        ReminderReceiver.handleReminder(context, ReminderScheduler.TYPE_DAILY)
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val shadowNm = shadowOf(nm)
        assertTrue(shadowNm.getNotification(NotificationHelper.NOTIF_ID_DAILY) == null)
        assertEquals(0, shadowNm.size())
    }
}
