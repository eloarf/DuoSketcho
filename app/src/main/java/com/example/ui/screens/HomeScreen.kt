package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.domain.engine.StreakAndXpEngine
import com.example.domain.model.SessionMode
import com.example.ui.components.AtelierCard
import com.example.ui.components.DailyGoalRing
import com.example.ui.components.StreakBadge
import com.example.ui.components.TactilePrimaryButton
import com.example.ui.components.XpBadge
import com.example.viewmodel.AcademyUiState
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.OchreGold
import com.example.ui.theme.TerracottaFlame

@Composable
fun HomeScreen(
    state: AcademyUiState,
    onOpenLesson: (String) -> Unit,
    onStartGuidedSession: (SessionMode) -> Unit,
    onOpenReviewTab: () -> Unit,
    onOpenObservations: () -> Unit,
    onOpenCurriculumMap: () -> Unit,
    onOpenVisualLibrary: () -> Unit,
    modifier: Modifier = Modifier
) {
    val practicedToday = StreakAndXpEngine.isMeaningfulPracticeDay(state.dailyActivityMap[state.todayEpochDay])

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 640.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Top Status Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Drawing Academy",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Lv.${state.learnerLevel.level} ${state.learnerLevel.title}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        StreakBadge(
                            streakDays = state.streakSummary.currentStreak,
                            practicedToday = practicedToday
                        )
                        XpBadge(xp = state.streakSummary.todayXp)
                    }
                }
            }

            // Today's Physical Practice Goal Card
            item {
                AtelierCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        DailyGoalRing(
                            todayMinutes = state.streakSummary.todayMinutes,
                            goalMinutes = state.preferences.dailyGoalMinutes
                        )
                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = if (state.streakSummary.todayGoalMet) {
                                    "Daily Goal Complete!"
                                } else {
                                    "Today's Sketchbook Goal"
                                },
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = if (state.streakSummary.todayGoalMet) AtelierSage else MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = if (practicedToday) {
                                    "Meaningful paper practice logged today. Streak active!"
                                } else {
                                    "Complete a lesson or review drill in your physical notebook to count today's streak."
                                },
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.AcUnit,
                                    contentDescription = "Streak freezes",
                                    tint = BlueprintCobalt,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "${state.streakSummary.remainingFreezes} Streak Freeze${if (state.streakSummary.remainingFreezes == 1) "" else "s"} ready",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = BlueprintCobalt,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }

            // Personal Tutor Recommendation / Continue Learning Hero Card
            item {
                val rec = state.tutorRecommendation
                val world = state.currentWorldSummary?.world
                val unit = world?.units?.firstOrNull { it.id == state.nextLesson.unitId }
                val targetLessonId = rec?.targetLessonId ?: state.nextLesson.id
                val badgeText = when {
                    rec?.isPrerequisiteRemediation == true -> "PREREQUISITE FOCUS"
                    rec?.isDelayedMasteryCheck == true -> "DELAYED MASTERY CHECK"
                    rec?.isWeakSkillReview == true -> "REINFORCE WEAK SKILL"
                    else -> "RECOMMENDED NEXT STEP"
                }
                val accentColor = when {
                    rec?.isPrerequisiteRemediation == true || rec?.isWeakSkillReview == true -> TerracottaFlame
                    rec?.isDelayedMasteryCheck == true -> AtelierSage
                    else -> BlueprintCobalt
                }
                AtelierCard(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                    borderColor = accentColor.copy(alpha = 0.45f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = badgeText,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = accentColor
                        )
                        Text(
                            text = rec?.recommendedStage?.displayName ?: "World ${state.nextLesson.worldNumber}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = world?.title ?: "World ${state.nextLesson.worldNumber}",
                        style = MaterialTheme.typography.labelLarge,
                        color = BlueprintCobalt,
                        fontWeight = FontWeight.SemiBold
                    )
                    if (unit != null && rec?.isPrerequisiteRemediation != true) {
                        Text(
                            text = "Unit ${unit.orderInWorld}: ${unit.title}",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = rec?.title ?: state.nextLesson.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = rec?.reason ?: state.nextLesson.learningObjective,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(Modifier.height(14.dp))
                    TactilePrimaryButton(
                        text = rec?.actionLabel ?: "Open Next Lesson",
                        onClick = { onOpenLesson(targetLessonId) },
                        containerColor = accentColor,
                        testTag = "continue_next_lesson_button"
                    )
                }
            }

            // Guided Session Launcher (10-15m vs 20-30m)
            item {
                AtelierCard {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Timer,
                            contentDescription = null,
                            tint = TerracottaFlame
                        )
                        Text(
                            text = "Guided Sketchbook Sessions",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Combines warm-up, new lesson, guided drills, spaced review & optional challenge.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = { onStartGuidedSession(SessionMode.QUICK_10_15) },
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 52.dp)
                                .testTag("quick_session_button")
                        ) {
                            Icon(Icons.Filled.Bolt, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Quick\n10–15m", style = MaterialTheme.typography.labelLarge)
                        }
                        TactilePrimaryButton(
                            text = "Deep 20–30m",
                            onClick = { onStartGuidedSession(SessionMode.DEEP_20_30) },
                            containerColor = AtelierSage,
                            modifier = Modifier.weight(1f),
                            testTag = "deep_session_button"
                        )
                    }
                }
            }

            // Reviews Due Card
            item {
                val dueCount = state.dueSkills.size
                AtelierCard(
                    modifier = Modifier
                        .clickable { onOpenReviewTab() }
                        .testTag("home_reviews_due_card"),
                    containerColor = if (dueCount > 0) {
                        MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.45f)
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.weight(1f)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(CircleShape)
                                    .background(
                                        if (dueCount > 0) TerracottaFlame.copy(alpha = 0.16f)
                                        else AtelierSage.copy(alpha = 0.16f)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Replay,
                                    contentDescription = "Spaced repetition review",
                                    tint = if (dueCount > 0) TerracottaFlame else AtelierSage
                                )
                            }
                            Column {
                                Text(
                                    text = if (dueCount > 0) "$dueCount Skills Due for Review" else "All Spaced Reviews Caught Up",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = if (dueCount > 0) {
                                        "Sharpen older fundamentals before they fade"
                                    } else {
                                        "Keep practicing new lessons to build your review deck"
                                    },
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Open review queue",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            // Overall Academy Progress
            item {
                val ratio = state.lessonsCompletedCount.toFloat() / state.totalLessonsCount.coerceAtLeast(1).toFloat()
                AtelierCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Overall Curriculum Progress",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${state.lessonsCompletedCount}/${state.totalLessonsCount} lessons",
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.SemiBold,
                            color = BlueprintCobalt
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = { ratio.coerceIn(0f, 1f) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        color = BlueprintCobalt,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "${state.skillsMasteredCount} of 48 core skills Mastered • ${state.totalCurriculumExercises} total exercises",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            // Quick Exploration Shortcuts
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = onOpenObservations,
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.outlinedButtonColors(),
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 52.dp)
                                .testTag("home_observations_button")
                        ) {
                            Icon(Icons.Filled.Explore, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Life Challenges")
                        }
                        OutlinedButton(
                            onClick = onOpenCurriculumMap,
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 52.dp)
                                .testTag("home_curriculum_map_button")
                        ) {
                            Icon(Icons.Filled.MenuBook, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("12-World Map")
                        }
                    }
                    OutlinedButton(
                        onClick = onOpenVisualLibrary,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 52.dp)
                            .testTag("home_visual_library_button")
                    ) {
                        Icon(Icons.Filled.Brush, contentDescription = null, modifier = Modifier.size(18.dp), tint = BlueprintCobalt)
                        Spacer(Modifier.width(8.dp))
                        Text("Visual Study Library (33 Animated Construction Demos)")
                    }
                }
            }

            // Recent Achievements
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "Recent Achievements",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    if (state.unlockedAchievements.isEmpty()) {
                        AtelierCard {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Icon(Icons.Filled.Brush, contentDescription = null, tint = OchreGold)
                                Text(
                                    text = "Complete your first lesson or 3-day streak to earn atelier badges.",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    } else {
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            items(state.unlockedAchievements.take(6)) { item ->
                                Column(
                                    modifier = Modifier
                                        .width(170.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                        .background(MaterialTheme.colorScheme.surface)
                                        .border(1.dp, OchreGold.copy(alpha = 0.45f), RoundedCornerShape(16.dp))
                                        .padding(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.EmojiEvents,
                                        contentDescription = item.definition.title,
                                        tint = OchreGold
                                    )
                                    Text(
                                        text = item.definition.title,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = item.definition.description,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
