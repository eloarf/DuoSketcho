package com.example.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.data.local.DrawingAcademyDatabase
import com.example.data.local.UserPreferencesRepository
import com.example.domain.engine.DateTimeUtils
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.engine.StreakAndXpEngine
import com.example.domain.engine.WeeklyReportEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val type = intent.getStringExtra(ReminderScheduler.EXTRA_REMINDER_TYPE) ?: return
        val pendingResult = goAsync()
        val appContext = context.applicationContext

        CoroutineScope(Dispatchers.IO).launch {
            try {
                handleReminder(appContext, type)
            } finally {
                pendingResult.finish()
            }
        }
    }

    companion object {
        suspend fun handleReminder(context: Context, type: String) {
            val prefsRepo = UserPreferencesRepository(context)
            val prefs = prefsRepo.getPreferencesOnce()
            val db = DrawingAcademyDatabase.getInstance(context)
            val today = DateTimeUtils.currentEpochDay()
            val todayActivity = db.dailyActivityDao().getByDay(today)
            val practicedToday = StreakAndXpEngine.isMeaningfulPracticeDay(todayActivity)

            when (type) {
                ReminderScheduler.TYPE_DAILY -> {
                    val goalMet = todayActivity?.goalMet == true
                    if (prefs.dailyReminderEnabled && !goalMet && !practicedToday &&
                        prefs.lastDailyNotifiedEpochDay != today
                    ) {
                        NotificationHelper.showNotification(
                            context = context,
                            channelId = NotificationHelper.CHANNEL_DAILY,
                            notificationId = NotificationHelper.NOTIF_ID_DAILY,
                            title = "Time for Your Sketchbook",
                            body = "Your ${prefs.dailyGoalMinutes}-minute physical drawing session is waiting. Grab your pencil and sharpen your eye!"
                        )
                        prefsRepo.markNotified("daily", today)
                    }
                }

                ReminderScheduler.TYPE_STREAK -> {
                    if (prefs.streakReminderEnabled && !practicedToday &&
                        prefs.lastStreakNotifiedEpochDay != today
                    ) {
                        val allDays = db.dailyActivityDao().getAllOnce()
                        val streak = StreakAndXpEngine.computeStreak(
                            activities = allDays,
                            todayEpochDay = today,
                            availableFreezes = prefs.streakFreezes,
                            lastFreezeAwardStreak = prefs.lastFreezeAwardStreak
                        )
                        if (streak.currentStreak > 0) {
                            NotificationHelper.showNotification(
                                context = context,
                                channelId = NotificationHelper.CHANNEL_STREAK,
                                notificationId = NotificationHelper.NOTIF_ID_STREAK,
                                title = "Protect Your ${streak.currentStreak}-Day Streak",
                                body = "Complete one quick drawing drill in your notebook before midnight to keep your streak alive!"
                            )
                            prefsRepo.markNotified("streak", today)
                        }
                    }
                }

                ReminderScheduler.TYPE_REVIEW -> {
                    if (prefs.reviewReminderEnabled && prefs.lastReviewNotifiedEpochDay != today) {
                        val dueSkills = db.skillMasteryDao().getDueSkillsOnce(today)
                        val dueCount = dueSkills.count { SpacedRepetitionEngine.isSkillDue(it, today) }
                        if (dueCount > 0) {
                            NotificationHelper.showNotification(
                                context = context,
                                channelId = NotificationHelper.CHANNEL_REVIEW,
                                notificationId = NotificationHelper.NOTIF_ID_REVIEW,
                                title = "$dueCount Drawing Skills Due for Review",
                                body = "Keep your muscle memory sharp—run a quick spaced-repetition drill in your sketchbook today."
                            )
                            prefsRepo.markNotified("review", today)
                        }
                    }
                }

                ReminderScheduler.TYPE_WEEKLY -> {
                    val currentWeek = DateTimeUtils.weekIndex(today)
                    if (prefs.weeklySummaryEnabled && prefs.lastWeeklyNotifiedWeek != currentWeek) {
                        val activities = db.dailyActivityDao().getAllOnce()
                        val skills = db.skillMasteryDao().getAllOnce()
                        val report = WeeklyReportEngine.buildReport(
                            activities = activities,
                            skillMasteries = skills,
                            todayEpochDay = today,
                            weeklyGoalSessions = prefs.weeklyGoalSessions
                        )
                        NotificationHelper.showNotification(
                            context = context,
                            channelId = NotificationHelper.CHANNEL_WEEKLY,
                            notificationId = NotificationHelper.NOTIF_ID_WEEKLY,
                            title = "Your Weekly Atelier Report",
                            body = "${report.sessionsLast7Days} sessions • ${report.minutesLast7Days} min • ${report.xpLast7Days} XP this week (${report.consistencyPercent}% consistency)."
                        )
                        prefsRepo.markNotified("weekly", currentWeek)
                    }
                }
            }

            ReminderScheduler.scheduleNextOccurrence(context, type, prefs)
        }
    }
}
