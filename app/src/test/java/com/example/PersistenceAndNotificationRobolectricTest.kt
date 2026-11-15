package com.example

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.data.backup.BackupManager
import com.example.data.local.DailyActivityEntity
import com.example.data.local.DrawingAcademyDatabase
import com.example.data.local.JournalEntryEntity
import com.example.data.local.LessonProgressEntity
import com.example.data.local.SkillMasteryEntity
import com.example.data.local.UserPreferencesRepository
import com.example.domain.engine.DateTimeUtils
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
    fun `room persistence and json backup export import round trip accurately`() = runBlocking {
        db.lessonProgressDao().upsert(LessonProgressEntity("w1_u1_l1", 1, completedCount = 2, bestChecklistRatio = 0.9f))
        db.skillMasteryDao().upsert(SkillMasteryEntity("sk_eye_hand", masteryTierIndex = 2, practiceCount = 3, distinctDaysPracticed = 2))
        db.dailyActivityDao().upsert(DailyActivityEntity(epochDay = 200L, minutesPracticed = 25, xpEarned = 65, sessionsCompleted = 1, exercisesCompleted = 3, goalMet = true))
        db.journalEntryDao().insert(JournalEntryEntity(timestampMillis = 12345L, epochDay = 200L, lessonId = "w1_u1_l1", title = "Blind Contour", durationMinutes = 25, difficulty = "Okay", reflection = "Much steadier hand.", needsImprovement = "Slow down edges"))
        prefsRepo.setDailyGoalMinutes(20)

        val json = BackupManager.exportToJson(db, prefsRepo)

        // Wipe DB & reset prefs, then restore
        db.lessonProgressDao().clearAll()
        db.skillMasteryDao().clearAll()
        db.dailyActivityDao().clearAll()
        db.journalEntryDao().clearAll()
        prefsRepo.resetDefaults()

        val result = BackupManager.importFromJson(json, db, prefsRepo)
        assertTrue(result.isSuccess)
        assertEquals(20, prefsRepo.getPreferencesOnce().dailyGoalMinutes)
        assertEquals(2, db.lessonProgressDao().getById("w1_u1_l1")?.completedCount)
        assertEquals(3, db.skillMasteryDao().getById("sk_eye_hand")?.practiceCount)
        assertEquals(1, db.journalEntryDao().getAllOnce().size)
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

        // Verify reminder suppression logic when today's goal is already met
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
        // Daily reminder should NOT be posted because goal is already met today
        assertTrue(shadowNm.getNotification(NotificationHelper.NOTIF_ID_DAILY) == null)
        assertEquals(0, shadowNm.size())
    }
}
