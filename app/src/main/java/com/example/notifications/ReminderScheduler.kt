package com.example.notifications

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.data.local.UserPreferences
import java.util.Calendar

object ReminderScheduler {

    const val EXTRA_REMINDER_TYPE = "extra_reminder_type"
    const val TYPE_DAILY = "daily"
    const val TYPE_STREAK = "streak"
    const val TYPE_REVIEW = "review"
    const val TYPE_WEEKLY = "weekly"

    private const val REQ_DAILY = 4001
    private const val REQ_STREAK = 4002
    private const val REQ_REVIEW = 4003
    private const val REQ_WEEKLY = 4004

    fun scheduleAll(context: Context, prefs: UserPreferences) {
        NotificationHelper.createChannels(context)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager ?: return

        if (prefs.dailyReminderEnabled) {
            val trigger = nextTimeMillis(prefs.dailyReminderHour, prefs.dailyReminderMinute)
            scheduleOneShot(context, alarmManager, TYPE_DAILY, REQ_DAILY, trigger)
        } else {
            cancel(context, alarmManager, TYPE_DAILY, REQ_DAILY)
        }

        if (prefs.streakReminderEnabled) {
            // Evening streak check ~2 hours after daily reminder, capped cleanly in evening (default 21:00)
            val streakHour = (prefs.dailyReminderHour + 2).coerceIn(19, 22)
            val trigger = nextTimeMillis(streakHour, prefs.dailyReminderMinute)
            scheduleOneShot(context, alarmManager, TYPE_STREAK, REQ_STREAK, trigger)
        } else {
            cancel(context, alarmManager, TYPE_STREAK, REQ_STREAK)
        }

        if (prefs.reviewReminderEnabled) {
            val trigger = nextTimeMillis(10, 30)
            scheduleOneShot(context, alarmManager, TYPE_REVIEW, REQ_REVIEW, trigger)
        } else {
            cancel(context, alarmManager, TYPE_REVIEW, REQ_REVIEW)
        }

        if (prefs.weeklySummaryEnabled) {
            val trigger = nextSundayMillis(18, 0)
            scheduleOneShot(context, alarmManager, TYPE_WEEKLY, REQ_WEEKLY, trigger)
        } else {
            cancel(context, alarmManager, TYPE_WEEKLY, REQ_WEEKLY)
        }
    }

    fun scheduleNextOccurrence(context: Context, type: String, prefs: UserPreferences) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager ?: return
        when (type) {
            TYPE_DAILY -> if (prefs.dailyReminderEnabled) {
                scheduleOneShot(
                    context, alarmManager, TYPE_DAILY, REQ_DAILY,
                    nextTimeMillis(prefs.dailyReminderHour, prefs.dailyReminderMinute, forceTomorrow = true)
                )
            }
            TYPE_STREAK -> if (prefs.streakReminderEnabled) {
                val streakHour = (prefs.dailyReminderHour + 2).coerceIn(19, 22)
                scheduleOneShot(
                    context, alarmManager, TYPE_STREAK, REQ_STREAK,
                    nextTimeMillis(streakHour, prefs.dailyReminderMinute, forceTomorrow = true)
                )
            }
            TYPE_REVIEW -> if (prefs.reviewReminderEnabled) {
                scheduleOneShot(
                    context, alarmManager, TYPE_REVIEW, REQ_REVIEW,
                    nextTimeMillis(10, 30, forceTomorrow = true)
                )
            }
            TYPE_WEEKLY -> if (prefs.weeklySummaryEnabled) {
                scheduleOneShot(
                    context, alarmManager, TYPE_WEEKLY, REQ_WEEKLY,
                    nextSundayMillis(18, 0, forceNextWeek = true)
                )
            }
        }
    }

    private fun scheduleOneShot(
        context: Context,
        alarmManager: AlarmManager,
        type: String,
        requestCode: Int,
        triggerAtMillis: Long
    ) {
        val pending = buildPendingIntent(context, type, requestCode)
        alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, triggerAtMillis, pending)
    }

    private fun cancel(context: Context, alarmManager: AlarmManager, type: String, requestCode: Int) {
        val pending = buildPendingIntent(context, type, requestCode)
        alarmManager.cancel(pending)
    }

    private fun buildPendingIntent(context: Context, type: String, requestCode: Int): PendingIntent {
        val intent = Intent(context, ReminderReceiver::class.java).apply {
            action = "com.example.notifications.ACTION_REMINDER_$type"
            putExtra(EXTRA_REMINDER_TYPE, type)
        }
        return PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    fun nextTimeMillis(hour: Int, minute: Int, forceTomorrow: Boolean = false, nowMillis: Long = System.currentTimeMillis()): Long {
        val cal = Calendar.getInstance().apply {
            timeInMillis = nowMillis
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        if (forceTomorrow || cal.timeInMillis <= nowMillis + 1000L) {
            cal.add(Calendar.DAY_OF_YEAR, 1)
        }
        return cal.timeInMillis
    }

    fun nextSundayMillis(hour: Int, minute: Int, forceNextWeek: Boolean = false, nowMillis: Long = System.currentTimeMillis()): Long {
        val cal = Calendar.getInstance().apply {
            timeInMillis = nowMillis
            set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        if (forceNextWeek || cal.timeInMillis <= nowMillis + 1000L) {
            cal.add(Calendar.WEEK_OF_YEAR, 1)
        }
        return cal.timeInMillis
    }
}
