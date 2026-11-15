package com.example.ui.screens

import android.Manifest
import android.app.TimePickerDialog
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.engine.DateTimeUtils
import com.example.notifications.NotificationHelper
import com.example.ui.components.AtelierCard
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.DustyCrimson
import com.example.ui.theme.ThemePreference
import com.example.viewmodel.AcademyUiState

@Composable
fun ProfileScreen(
    state: AcademyUiState,
    onSetDailyGoal: (Int) -> Unit,
    onSetWeeklyGoal: (Int) -> Unit,
    onSetTheme: (ThemePreference) -> Unit,
    onUpdateNotifications: (
        dailyEnabled: Boolean?,
        hour: Int?,
        minute: Int?,
        streakEnabled: Boolean?,
        reviewEnabled: Boolean?,
        weeklyEnabled: Boolean?,
        achievementEnabled: Boolean?
    ) -> Unit,
    onExportBackup: (android.net.Uri) -> Unit,
    onImportBackup: (android.net.Uri) -> Unit,
    onResetProgress: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var hasNotifPermission by remember {
        mutableStateOf(NotificationHelper.hasNotificationPermission(context))
    }
    var showResetConfirm by remember { mutableStateOf(false) }

    val notifPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasNotifPermission = granted || NotificationHelper.hasNotificationPermission(context)
    }

    val exportLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("application/json")
    ) { uri ->
        if (uri != null) onExportBackup(uri)
    }

    val importLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri != null) onImportBackup(uri)
    }

    val prefs = state.preferences

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 640.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Text(
                    text = "Atelier Settings & Profile",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "100% offline • Local device storage • Physical sketchbook companion",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Learner Level Card
            item {
                val lv = state.learnerLevel
                val levelRatio = (lv.currentLevelXp.toFloat() / lv.nextLevelXp.coerceAtLeast(1).toFloat()).coerceIn(0f, 1f)
                AtelierCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Level ${lv.level} • ${lv.title}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "${lv.currentLevelXp} / ${lv.nextLevelXp} XP to next level",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Text(
                            text = "${state.streakSummary.remainingFreezes} Freezes",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            color = BlueprintCobalt
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    LinearProgressIndicator(
                        progress = { levelRatio },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = AtelierSage,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }

            // Daily & Weekly Goals
            item {
                AtelierCard {
                    Text(
                        text = "Practice Goals",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Daily sketchbook minutes target",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listOf(10, 15, 20, 30).forEach { mins ->
                            FilterChip(
                                selected = prefs.dailyGoalMinutes == mins,
                                onClick = { onSetDailyGoal(mins) },
                                label = { Text("${mins}m") },
                                modifier = Modifier
                                    .weight(1f)
                                    .heightIn(min = 48.dp)
                                    .testTag("daily_goal_chip_$mins")
                            )
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "Weekly active days target",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listOf(3, 5, 6, 7).forEach { days ->
                            FilterChip(
                                selected = prefs.weeklyGoalSessions == days,
                                onClick = { onSetWeeklyGoal(days) },
                                label = { Text("${days}d") },
                                modifier = Modifier
                                    .weight(1f)
                                    .heightIn(min = 48.dp)
                                    .testTag("weekly_goal_chip_$days")
                            )
                        }
                    }
                }
            }

            // Theme Settings
            item {
                AtelierCard {
                    Text(
                        text = "Appearance",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        ThemePreference.entries.forEach { option ->
                            val label = when (option) {
                                ThemePreference.SYSTEM -> "System"
                                ThemePreference.LIGHT -> "Light Paper"
                                ThemePreference.DARK -> "Charcoal"
                            }
                            FilterChip(
                                selected = prefs.themePreference == option,
                                onClick = { onSetTheme(option) },
                                label = { Text(label) },
                                modifier = Modifier
                                    .weight(1f)
                                    .heightIn(min = 48.dp)
                                    .testTag("theme_chip_${option.name.lowercase()}")
                            )
                        }
                    }
                }
            }

            // Local Notifications
            item {
                AtelierCard {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Filled.NotificationsActive, contentDescription = null, tint = BlueprintCobalt)
                        Text(
                            text = "Local Reminders & Alerts",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(6.dp))

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !hasNotifPermission) {
                        Button(
                            onClick = { notifPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 48.dp)
                                .testTag("grant_notifications_button")
                        ) {
                            Text("Enable Android Notification Permission")
                        }
                        Spacer(Modifier.height(8.dp))
                    }

                    NotificationSwitchRow(
                        title = "Daily Practice Reminder",
                        subtitle = "Suppressed automatically once today's goal is met",
                        checked = prefs.dailyReminderEnabled,
                        onCheckedChange = { onUpdateNotifications(it, null, null, null, null, null, null) },
                        testTag = "switch_daily_reminder"
                    )

                    if (prefs.dailyReminderEnabled) {
                        OutlinedButton(
                            onClick = {
                                TimePickerDialog(
                                    context,
                                    { _, h, m ->
                                        onUpdateNotifications(null, h, m, null, null, null, null)
                                    },
                                    prefs.dailyReminderHour,
                                    prefs.dailyReminderMinute,
                                    false
                                ).show()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 48.dp)
                                .testTag("pick_reminder_time_button")
                        ) {
                            Icon(Icons.Filled.AccessTime, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text("Daily Reminder Time: ${DateTimeUtils.formatTimeOfDay(prefs.dailyReminderHour, prefs.dailyReminderMinute)}")
                        }
                        Spacer(Modifier.height(6.dp))
                    }

                    NotificationSwitchRow(
                        title = "Evening Streak Protection",
                        subtitle = "Alerts if your streak is still unprotected in the evening",
                        checked = prefs.streakReminderEnabled,
                        onCheckedChange = { onUpdateNotifications(null, null, null, it, null, null, null) },
                        testTag = "switch_streak_reminder"
                    )
                    NotificationSwitchRow(
                        title = "Review Queue Reminder",
                        subtitle = "Morning check when spaced-repetition skills are due",
                        checked = prefs.reviewReminderEnabled,
                        onCheckedChange = { onUpdateNotifications(null, null, null, null, it, null, null) },
                        testTag = "switch_review_reminder"
                    )
                    NotificationSwitchRow(
                        title = "Weekly Progress Summary",
                        subtitle = "Sunday evening recap of minutes, XP & consistency",
                        checked = prefs.weeklySummaryEnabled,
                        onCheckedChange = { onUpdateNotifications(null, null, null, null, null, it, null) },
                        testTag = "switch_weekly_summary"
                    )
                    NotificationSwitchRow(
                        title = "Achievement Notifications",
                        subtitle = "Instant alert when unlocking new academy badges",
                        checked = prefs.achievementAlertsEnabled,
                        onCheckedChange = { onUpdateNotifications(null, null, null, null, null, null, it) },
                        testTag = "switch_achievement_alerts"
                    )
                }
            }

            // Local Backup & Reset
            item {
                AtelierCard {
                    Text(
                        text = "Local Data & JSON Backup",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "No cloud accounts required. Export or restore your entire sketchbook history as a local JSON file.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = { exportLauncher.launch("drawing_academy_backup.json") },
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 48.dp)
                                .testTag("export_backup_button")
                        ) {
                            Icon(Icons.Filled.Upload, contentDescription = null)
                            Spacer(Modifier.width(6.dp))
                            Text("Export")
                        }
                        OutlinedButton(
                            onClick = { importLauncher.launch(arrayOf("application/json", "*/*")) },
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 48.dp)
                                .testTag("import_backup_button")
                        ) {
                            Icon(Icons.Filled.Download, contentDescription = null)
                            Spacer(Modifier.width(6.dp))
                            Text("Import")
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedButton(
                        onClick = { showResetConfirm = true },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = DustyCrimson),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 48.dp)
                            .testTag("reset_progress_button")
                    ) {
                        Icon(Icons.Filled.RestartAlt, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text("Reset All Local Progress")
                    }
                }
            }
        }
    }

    if (showResetConfirm) {
        AlertDialog(
            onDismissRequest = { showResetConfirm = false },
            title = { Text("Reset All Progress?") },
            text = {
                Text("This permanently clears all local lessons, skill mastery, streaks, journal entries, and achievements. Export a JSON backup first if you want to keep a copy.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        showResetConfirm = false
                        onResetProgress()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = DustyCrimson),
                    modifier = Modifier.testTag("confirm_reset_button")
                ) {
                    Text("Reset Everything")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetConfirm = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun NotificationSwitchRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    testTag: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f).padding(end = 12.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.testTag(testTag)
        )
    }
}
