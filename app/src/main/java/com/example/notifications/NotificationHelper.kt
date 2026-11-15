package com.example.notifications

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.MainActivity
import com.example.R

object NotificationHelper {
    const val CHANNEL_DAILY = "daily_practice"
    const val CHANNEL_STREAK = "streak_alert"
    const val CHANNEL_REVIEW = "review_queue"
    const val CHANNEL_WEEKLY = "weekly_summary"
    const val CHANNEL_ACHIEVEMENT = "achievements"

    const val NOTIF_ID_DAILY = 1001
    const val NOTIF_ID_STREAK = 1002
    const val NOTIF_ID_REVIEW = 1003
    const val NOTIF_ID_WEEKLY = 1004
    const val NOTIF_ID_ACHIEVEMENT_BASE = 2000

    fun createChannels(context: Context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager ?: return

        val channels = listOf(
            NotificationChannel(
                CHANNEL_DAILY,
                "Daily Practice Reminders",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Gentle daily reminders to open your physical sketchbook and draw."
            },
            NotificationChannel(
                CHANNEL_STREAK,
                "Streak Protection Alerts",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Evening reminders when your drawing streak is at risk today."
            },
            NotificationChannel(
                CHANNEL_REVIEW,
                "Spaced-Repetition Reviews",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Alerts when past drawing skills are due for spaced practice."
            },
            NotificationChannel(
                CHANNEL_WEEKLY,
                "Weekly Progress Summaries",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Weekly recap of your sketchbook minutes, sessions, and mastery."
            },
            NotificationChannel(
                CHANNEL_ACHIEVEMENT,
                "Milestone & Achievement Badges",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Celebratory alerts when you unlock new drawing academy badges."
            }
        )
        manager.createNotificationChannels(channels)
    }

    fun hasNotificationPermission(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    fun showNotification(
        context: Context,
        channelId: String,
        notificationId: Int,
        title: String,
        body: String
    ) {
        if (!hasNotificationPermission(context)) return
        createChannels(context)

        val launchIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val contentIntent = PendingIntent.getActivity(
            context,
            notificationId,
            launchIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(body)
            .setStyle(NotificationCompat.BigTextStyle().bigText(body))
            .setContentIntent(contentIntent)
            .setAutoCancel(true)
            .setPriority(
                if (channelId == CHANNEL_STREAK) NotificationCompat.PRIORITY_HIGH
                else NotificationCompat.PRIORITY_DEFAULT
            )

        try {
            NotificationManagerCompat.from(context).notify(notificationId, builder.build())
        } catch (_: SecurityException) {
            // Ignored gracefully if permission was revoked at runtime
        }
    }
}
