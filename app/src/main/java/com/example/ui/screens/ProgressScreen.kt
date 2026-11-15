package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.curriculum.ReferenceLibraryData
import com.example.ui.components.AtelierCard
import com.example.ui.components.MasteryDistributionCard
import com.example.ui.components.PracticeHeatmapCard
import com.example.ui.components.WeeklyMinutesBarChart
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.OchreGold
import com.example.ui.theme.TerracottaFlame
import com.example.viewmodel.AcademyUiState

@Composable
fun ProgressScreen(
    state: AcademyUiState,
    onOpenJournal: () -> Unit,
    modifier: Modifier = Modifier
) {
    val unlockedIds = state.unlockedAchievements.map { it.definition.id }.toSet()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 640.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Progress & Analytics",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Honest sketchbook metrics & spaced skill mastery",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    OutlinedButton(
                        onClick = onOpenJournal,
                        modifier = Modifier
                            .heightIn(min = 48.dp)
                            .testTag("open_journal_button")
                    ) {
                        Icon(Icons.Filled.Book, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Journal (${state.journalEntries.size})")
                    }
                }
            }

            // KPI Grid (2x3)
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        KpiBox(
                            label = "Current / Best Streak",
                            value = "${state.streakSummary.currentStreak}d / ${state.streakSummary.longestStreak}d",
                            accent = TerracottaFlame,
                            modifier = Modifier.weight(1f)
                        )
                        KpiBox(
                            label = "Total Time Drawn",
                            value = "${state.totalMinutes} min",
                            accent = BlueprintCobalt,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        KpiBox(
                            label = "Sessions / Drills",
                            value = "${state.totalSessions} / ${state.totalExercises}",
                            accent = AtelierSage,
                            modifier = Modifier.weight(1f)
                        )
                        KpiBox(
                            label = "Total XP (Lv.${state.learnerLevel.level})",
                            value = "${state.totalXp} XP",
                            accent = OchreGold,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        KpiBox(
                            label = "Lessons Completed",
                            value = "${state.lessonsCompletedCount}/${state.totalLessonsCount}",
                            accent = BlueprintCobalt,
                            modifier = Modifier.weight(1f)
                        )
                        KpiBox(
                            label = "Introduced / Mastered",
                            value = "${state.skillsIntroducedCount} / ${state.skillsMasteredCount} skills",
                            accent = AtelierSage,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            // Weekly Report Card
            item {
                val report = state.weeklyReport
                AtelierCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Weekly Progress Report",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${report.consistencyPercent}% goal consistency",
                            style = MaterialTheme.typography.labelMedium,
                            color = AtelierSage,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Last 7 days: ${report.sessionsLast7Days} sessions • ${report.minutesLast7Days} min • ${report.xpLast7Days} XP • ${report.goalDaysMet} active days",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(10.dp))
                    if (report.strongestSkills.isNotEmpty()) {
                        Text(
                            text = "Strongest: ${report.strongestSkills.joinToString(", ")}",
                            style = MaterialTheme.typography.bodySmall,
                            color = AtelierSage,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    if (report.weakestSkills.isNotEmpty()) {
                        Text(
                            text = "Needs Review: ${report.weakestSkills.joinToString(", ")}",
                            style = MaterialTheme.typography.bodySmall,
                            color = TerracottaFlame,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Text(
                        text = "Upcoming reviews (next 7 days): ${report.upcomingReviewsCount}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // 10-Week Heatmap Calendar
            item {
                PracticeHeatmapCard(
                    dailyActivityMap = state.dailyActivityMap,
                    todayEpochDay = state.todayEpochDay
                )
            }

            // 7-Day Minutes Bar Chart
            item {
                WeeklyMinutesBarChart(
                    dailyActivityMap = state.dailyActivityMap,
                    todayEpochDay = state.todayEpochDay,
                    dailyGoalMinutes = state.preferences.dailyGoalMinutes
                )
            }

            // Skill Mastery Distribution
            item {
                MasteryDistributionCard(
                    distribution = state.masteryDistribution,
                    totalSkills = 48
                )
            }

            // 12-World Breakdown
            item {
                AtelierCard {
                    Text(
                        text = "12-World Curriculum Breakdown",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(10.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        state.worldSummaries.forEach { summary ->
                            val ratio = if (summary.totalLessons == 0) 0f else {
                                summary.completedLessons.toFloat() / summary.totalLessons.toFloat()
                            }
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "${summary.world.number}. ${summary.world.title}",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Text(
                                        text = "${summary.completedLessons}/${summary.totalLessons}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                                LinearProgressIndicator(
                                    progress = { ratio.coerceIn(0f, 1f) },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(6.dp)
                                        .clip(RoundedCornerShape(3.dp)),
                                    color = if (summary.milestoneCompleted) AtelierSage else BlueprintCobalt,
                                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                                )
                            }
                        }
                    }
                }
            }

            // Achievements Gallery Header
            item {
                Text(
                    text = "Achievements (${unlockedIds.size}/${ReferenceLibraryData.achievements.size})",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            items(ReferenceLibraryData.achievements, key = { it.id }) { ach ->
                val unlocked = ach.id in unlockedIds
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(
                            if (unlocked) OchreGold.copy(alpha = 0.12f)
                            else MaterialTheme.colorScheme.surface
                        )
                        .border(
                            1.dp,
                            if (unlocked) OchreGold.copy(alpha = 0.5f) else MaterialTheme.colorScheme.outline,
                            RoundedCornerShape(14.dp)
                        )
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = if (unlocked) Icons.Filled.EmojiEvents else Icons.Filled.Lock,
                        contentDescription = if (unlocked) "Unlocked achievement" else "Locked achievement",
                        tint = if (unlocked) OchreGold else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = ach.title,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = ach.description,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Text(
                        text = "+${ach.xpBonus} XP",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (unlocked) OchreGold else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun KpiBox(
    label: String,
    value: String,
    accent: androidx.compose.ui.graphics.Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(16.dp))
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = accent
        )
    }
}
