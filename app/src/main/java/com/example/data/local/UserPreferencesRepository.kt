package com.example.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.ui.theme.ThemePreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "academy_prefs")

data class UserPreferences(
    val dailyGoalMinutes: Int = 15,
    val weeklyGoalSessions: Int = 5,
    val themePreference: ThemePreference = ThemePreference.SYSTEM,
    val streakFreezes: Int = 1,
    val lastFreezeAwardStreak: Int = 0,
    val dailyReminderEnabled: Boolean = true,
    val dailyReminderHour: Int = 19,
    val dailyReminderMinute: Int = 0,
    val streakReminderEnabled: Boolean = true,
    val reviewReminderEnabled: Boolean = true,
    val weeklySummaryEnabled: Boolean = true,
    val achievementAlertsEnabled: Boolean = true,
    val lastDailyNotifiedEpochDay: Long = -1L,
    val lastStreakNotifiedEpochDay: Long = -1L,
    val lastReviewNotifiedEpochDay: Long = -1L,
    val lastWeeklyNotifiedWeek: Long = -1L
)

class UserPreferencesRepository(private val context: Context) {

    private object Keys {
        val DAILY_GOAL_MINUTES = intPreferencesKey("daily_goal_minutes")
        val WEEKLY_GOAL_SESSIONS = intPreferencesKey("weekly_goal_sessions")
        val THEME_PREFERENCE = stringPreferencesKey("theme_preference")
        val STREAK_FREEZES = intPreferencesKey("streak_freezes")
        val LAST_FREEZE_AWARD_STREAK = intPreferencesKey("last_freeze_award_streak")
        val DAILY_REMINDER_ENABLED = booleanPreferencesKey("daily_reminder_enabled")
        val DAILY_REMINDER_HOUR = intPreferencesKey("daily_reminder_hour")
        val DAILY_REMINDER_MINUTE = intPreferencesKey("daily_reminder_minute")
        val STREAK_REMINDER_ENABLED = booleanPreferencesKey("streak_reminder_enabled")
        val REVIEW_REMINDER_ENABLED = booleanPreferencesKey("review_reminder_enabled")
        val WEEKLY_SUMMARY_ENABLED = booleanPreferencesKey("weekly_summary_enabled")
        val ACHIEVEMENT_ALERTS_ENABLED = booleanPreferencesKey("achievement_alerts_enabled")
        val LAST_DAILY_NOTIFIED_DAY = longPreferencesKey("last_daily_notified_day")
        val LAST_STREAK_NOTIFIED_DAY = longPreferencesKey("last_streak_notified_day")
        val LAST_REVIEW_NOTIFIED_DAY = longPreferencesKey("last_review_notified_day")
        val LAST_WEEKLY_NOTIFIED_WEEK = longPreferencesKey("last_weekly_notified_week")
    }

    val preferencesFlow: Flow<UserPreferences> = context.dataStore.data.map { prefs ->
        UserPreferences(
            dailyGoalMinutes = prefs[Keys.DAILY_GOAL_MINUTES] ?: 15,
            weeklyGoalSessions = prefs[Keys.WEEKLY_GOAL_SESSIONS] ?: 5,
            themePreference = runCatching {
                ThemePreference.valueOf(prefs[Keys.THEME_PREFERENCE] ?: ThemePreference.SYSTEM.name)
            }.getOrDefault(ThemePreference.SYSTEM),
            streakFreezes = prefs[Keys.STREAK_FREEZES] ?: 1,
            lastFreezeAwardStreak = prefs[Keys.LAST_FREEZE_AWARD_STREAK] ?: 0,
            dailyReminderEnabled = prefs[Keys.DAILY_REMINDER_ENABLED] ?: true,
            dailyReminderHour = prefs[Keys.DAILY_REMINDER_HOUR] ?: 19,
            dailyReminderMinute = prefs[Keys.DAILY_REMINDER_MINUTE] ?: 0,
            streakReminderEnabled = prefs[Keys.STREAK_REMINDER_ENABLED] ?: true,
            reviewReminderEnabled = prefs[Keys.REVIEW_REMINDER_ENABLED] ?: true,
            weeklySummaryEnabled = prefs[Keys.WEEKLY_SUMMARY_ENABLED] ?: true,
            achievementAlertsEnabled = prefs[Keys.ACHIEVEMENT_ALERTS_ENABLED] ?: true,
            lastDailyNotifiedEpochDay = prefs[Keys.LAST_DAILY_NOTIFIED_DAY] ?: -1L,
            lastStreakNotifiedEpochDay = prefs[Keys.LAST_STREAK_NOTIFIED_DAY] ?: -1L,
            lastReviewNotifiedEpochDay = prefs[Keys.LAST_REVIEW_NOTIFIED_DAY] ?: -1L,
            lastWeeklyNotifiedWeek = prefs[Keys.LAST_WEEKLY_NOTIFIED_WEEK] ?: -1L
        )
    }

    suspend fun getPreferencesOnce(): UserPreferences = preferencesFlow.first()

    suspend fun setDailyGoalMinutes(minutes: Int) {
        val valid = if (minutes in listOf(10, 15, 20, 30)) minutes else 15
        context.dataStore.edit { it[Keys.DAILY_GOAL_MINUTES] = valid }
    }

    suspend fun setWeeklyGoalSessions(sessions: Int) {
        context.dataStore.edit { it[Keys.WEEKLY_GOAL_SESSIONS] = sessions.coerceIn(1, 7) }
    }

    suspend fun setThemePreference(theme: ThemePreference) {
        context.dataStore.edit { it[Keys.THEME_PREFERENCE] = theme.name }
    }

    suspend fun setStreakFreezes(count: Int, lastAwardStreak: Int? = null) {
        context.dataStore.edit { prefs ->
            prefs[Keys.STREAK_FREEZES] = count.coerceIn(0, 3)
            if (lastAwardStreak != null) {
                prefs[Keys.LAST_FREEZE_AWARD_STREAK] = lastAwardStreak
            }
        }
    }

    suspend fun updateNotificationSettings(
        dailyEnabled: Boolean? = null,
        hour: Int? = null,
        minute: Int? = null,
        streakEnabled: Boolean? = null,
        reviewEnabled: Boolean? = null,
        weeklyEnabled: Boolean? = null,
        achievementEnabled: Boolean? = null
    ) {
        context.dataStore.edit { prefs ->
            dailyEnabled?.let { prefs[Keys.DAILY_REMINDER_ENABLED] = it }
            hour?.let { prefs[Keys.DAILY_REMINDER_HOUR] = it.coerceIn(0, 23) }
            minute?.let { prefs[Keys.DAILY_REMINDER_MINUTE] = it.coerceIn(0, 59) }
            streakEnabled?.let { prefs[Keys.STREAK_REMINDER_ENABLED] = it }
            reviewEnabled?.let { prefs[Keys.REVIEW_REMINDER_ENABLED] = it }
            weeklyEnabled?.let { prefs[Keys.WEEKLY_SUMMARY_ENABLED] = it }
            achievementEnabled?.let { prefs[Keys.ACHIEVEMENT_ALERTS_ENABLED] = it }
        }
    }

    suspend fun markNotified(type: String, marker: Long) {
        context.dataStore.edit { prefs ->
            when (type) {
                "daily" -> prefs[Keys.LAST_DAILY_NOTIFIED_DAY] = marker
                "streak" -> prefs[Keys.LAST_STREAK_NOTIFIED_DAY] = marker
                "review" -> prefs[Keys.LAST_REVIEW_NOTIFIED_DAY] = marker
                "weekly" -> prefs[Keys.LAST_WEEKLY_NOTIFIED_WEEK] = marker
            }
        }
    }

    suspend fun restorePreferences(prefs: UserPreferences) {
        context.dataStore.edit { editable ->
            editable[Keys.DAILY_GOAL_MINUTES] = prefs.dailyGoalMinutes
            editable[Keys.WEEKLY_GOAL_SESSIONS] = prefs.weeklyGoalSessions
            editable[Keys.THEME_PREFERENCE] = prefs.themePreference.name
            editable[Keys.STREAK_FREEZES] = prefs.streakFreezes
            editable[Keys.LAST_FREEZE_AWARD_STREAK] = prefs.lastFreezeAwardStreak
            editable[Keys.DAILY_REMINDER_ENABLED] = prefs.dailyReminderEnabled
            editable[Keys.DAILY_REMINDER_HOUR] = prefs.dailyReminderHour
            editable[Keys.DAILY_REMINDER_MINUTE] = prefs.dailyReminderMinute
            editable[Keys.STREAK_REMINDER_ENABLED] = prefs.streakReminderEnabled
            editable[Keys.REVIEW_REMINDER_ENABLED] = prefs.reviewReminderEnabled
            editable[Keys.WEEKLY_SUMMARY_ENABLED] = prefs.weeklySummaryEnabled
            editable[Keys.ACHIEVEMENT_ALERTS_ENABLED] = prefs.achievementAlertsEnabled
        }
    }

    suspend fun resetDefaults() {
        context.dataStore.edit { it.clear() }
    }
}
