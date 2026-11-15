package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.model.WorldProgressSummary
import com.example.ui.components.AtelierCard
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.OchreGold
import com.example.ui.theme.TerracottaFlame
import com.example.viewmodel.AcademyUiState

@Composable
fun LearnScreen(
    state: AcademyUiState,
    onOpenLesson: (String) -> Unit,
    onOpenMilestone: (Int) -> Unit,
    onOpenPracticeLibrary: () -> Unit,
    onOpenObservations: () -> Unit,
    onOpenCurriculumMap: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expandedWorldNumber by rememberSaveable {
        mutableIntStateOf(state.currentWorldSummary?.world?.number ?: 1)
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 640.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Learning Path",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "12 Progressive Worlds • 48 Units • 144 Lessons",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    OutlinedButton(
                        onClick = onOpenCurriculumMap,
                        modifier = Modifier
                            .heightIn(min = 48.dp)
                            .testTag("learn_map_button")
                    ) {
                        Icon(Icons.Filled.Map, contentDescription = "Curriculum map", modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Map")
                    }
                }
            }

            // Practice Library & Observation Challenges quick bar
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onOpenPracticeLibrary,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(min = 48.dp)
                            .testTag("practice_library_button")
                    ) {
                        Icon(Icons.Filled.FitnessCenter, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Drill Library")
                    }
                    OutlinedButton(
                        onClick = onOpenObservations,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(min = 48.dp)
                            .testTag("observation_challenges_button")
                    ) {
                        Icon(Icons.Filled.Explore, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Observations")
                    }
                }
            }

            items(state.worldSummaries, key = { it.world.id }) { summary ->
                WorldPathCard(
                    summary = summary,
                    expanded = expandedWorldNumber == summary.world.number,
                    nextLessonId = state.nextLesson.id,
                    lessonProgressMap = state.lessonProgressMap,
                    onToggleExpand = {
                        expandedWorldNumber = if (expandedWorldNumber == summary.world.number) -1 else summary.world.number
                    },
                    onOpenLesson = onOpenLesson,
                    onOpenMilestone = { onOpenMilestone(summary.world.number) }
                )
            }
        }
    }
}

@Composable
private fun WorldPathCard(
    summary: WorldProgressSummary,
    expanded: Boolean,
    nextLessonId: String,
    lessonProgressMap: Map<String, com.example.data.local.LessonProgressEntity>,
    onToggleExpand: () -> Unit,
    onOpenLesson: (String) -> Unit,
    onOpenMilestone: () -> Unit
) {
    val world = summary.world
    val progressRatio = if (summary.totalLessons == 0) 0f else {
        summary.completedLessons.toFloat() / summary.totalLessons.toFloat()
    }
    val headerBorder = if (summary.isUnlocked) BlueprintCobalt.copy(alpha = 0.45f) else MaterialTheme.colorScheme.outline

    AtelierCard(
        borderColor = headerBorder
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onToggleExpand() }
                .testTag("world_card_${world.number}"),
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
                            when {
                                summary.milestoneCompleted && summary.completedLessons == summary.totalLessons -> AtelierSage
                                summary.isUnlocked -> BlueprintCobalt
                                else -> MaterialTheme.colorScheme.surfaceVariant
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (summary.isUnlocked) {
                        Text(
                            text = "${world.number}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "World locked",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Column {
                    Text(
                        text = world.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${summary.completedLessons}/${summary.totalLessons} lessons • ${summary.masteredSkillsCount}/${summary.totalSkillsCount} mastered",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) "Collapse world" else "Expand world"
            )
        }

        Spacer(Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { progressRatio.coerceIn(0f, 1f) },
            modifier = Modifier
                .fillMaxWidth()
                .height(7.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = if (summary.isUnlocked) AtelierSage else MaterialTheme.colorScheme.outline,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )

        if (!summary.isUnlocked && summary.lockReason != null) {
            Spacer(Modifier.height(8.dp))
            Text(
                text = "${summary.lockReason} (${summary.gateProgressPercent}% ready)",
                style = MaterialTheme.typography.labelMedium,
                color = TerracottaFlame
            )
        }

        AnimatedVisibility(visible = expanded) {
            Column(
                modifier = Modifier.padding(top = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = world.focusSummary,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                world.units.forEach { unit ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f))
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Unit ${unit.orderInWorld}: ${unit.title}",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = BlueprintCobalt
                        )
                        Text(
                            text = unit.summary,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        unit.lessons.forEachIndexed { idx, lesson ->
                            val done = (lessonProgressMap[lesson.id]?.completedCount ?: 0) > 0
                            val isNext = lesson.id == nextLessonId
                            val prevLessonDone = if (idx == 0) true else {
                                (lessonProgressMap[unit.lessons[idx - 1].id]?.completedCount ?: 0) > 0
                            }
                            val nodeEnabled = summary.isUnlocked && (done || isNext || prevLessonDone)

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(min = 52.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(
                                        when {
                                            isNext -> MaterialTheme.colorScheme.primaryContainer
                                            done -> MaterialTheme.colorScheme.surface
                                            else -> MaterialTheme.colorScheme.surface.copy(alpha = 0.7f)
                                        }
                                    )
                                    .border(
                                        width = if (isNext) 1.5.dp else 1.dp,
                                        color = if (isNext) BlueprintCobalt else MaterialTheme.colorScheme.outline.copy(alpha = 0.6f),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clickable(enabled = nodeEnabled) { onOpenLesson(lesson.id) }
                                    .padding(horizontal = 12.dp, vertical = 10.dp)
                                    .testTag("lesson_node_${lesson.id}"),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Icon(
                                    imageVector = when {
                                        done -> Icons.Filled.CheckCircle
                                        nodeEnabled -> Icons.Filled.PlayArrow
                                        else -> Icons.Filled.Lock
                                    },
                                    contentDescription = if (done) "Completed" else if (nodeEnabled) "Available" else "Locked",
                                    tint = when {
                                        done -> AtelierSage
                                        isNext -> BlueprintCobalt
                                        nodeEnabled -> MaterialTheme.colorScheme.primary
                                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                                    }
                                )
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = lesson.title,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = if (isNext || done) FontWeight.Bold else FontWeight.Medium
                                    )
                                    Text(
                                        text = "${lesson.exercises.size} drills + challenge • ~${lesson.estimatedMinutes}m • +${lesson.xpReward} XP",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }

                // End-of-World Milestone Card
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 56.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(OchreGold.copy(alpha = 0.14f))
                        .border(1.dp, OchreGold.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
                        .clickable(enabled = summary.isUnlocked) { onOpenMilestone() }
                        .padding(14.dp)
                        .testTag("milestone_card_world_${world.number}"),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = if (summary.milestoneCompleted) Icons.Filled.CheckCircle else Icons.Filled.EmojiEvents,
                        contentDescription = "World milestone",
                        tint = if (summary.milestoneCompleted) AtelierSage else OchreGold
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "World ${world.number} Milestone Project",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = OchreGold
                        )
                        Text(
                            text = world.milestoneProject.title,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}
