package com.example.ui.screens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.ReportProblem
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.model.DifficultyRating
import com.example.ui.components.AtelierCard
import com.example.ui.components.LessonDiagramCard
import com.example.ui.components.MasteryPill
import com.example.ui.components.SelfAssessmentSection
import com.example.ui.components.SketchbookTimerBar
import com.example.ui.components.TactilePrimaryButton
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.DustyCrimson
import com.example.ui.theme.TerracottaFlame
import com.example.viewmodel.AcademyUiState
import com.example.viewmodel.DueSkillItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewScreen(
    state: AcademyUiState,
    onCompleteReview: (skillId: String, rating: DifficultyRating, checklistRatio: Float, minutes: Int) -> Unit,
    onToggleTimer: () -> Unit,
    onResetTimer: () -> Unit,
    onOpenMistakeLibrary: () -> Unit,
    onOpenGlossary: () -> Unit,
    modifier: Modifier = Modifier
) {
    var activeDrill by remember { mutableStateOf<DueSkillItem?>(null) }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 640.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Spaced Review & Mastery",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Skills return automatically over widening intervals. Rate difficulty honestly after drawing in your notebook.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Reference tools row
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onOpenMistakeLibrary,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(min = 48.dp)
                            .testTag("open_mistake_library_button")
                    ) {
                        Icon(Icons.Filled.ReportProblem, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Mistake Fixes")
                    }
                    OutlinedButton(
                        onClick = onOpenGlossary,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .weight(1f)
                            .heightIn(min = 48.dp)
                            .testTag("open_glossary_button")
                    ) {
                        Icon(Icons.Filled.MenuBook, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Art Glossary")
                    }
                }
            }

            // Daily Review Queue
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Daily Review Queue (${state.dueSkills.size})",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    if (state.dueSkills.isNotEmpty()) {
                        Text(
                            text = "Prioritized by urgency",
                            style = MaterialTheme.typography.labelSmall,
                            color = TerracottaFlame
                        )
                    }
                }
            }

            if (state.dueSkills.isEmpty()) {
                item {
                    AtelierCard {
                        Text(
                            text = "No reviews overdue right now!",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = AtelierSage
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = "As you complete lessons across the 12 Worlds, introduced skills will automatically appear here for spaced reinforcement.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                items(state.dueSkills, key = { it.skill.id }) { item ->
                    DueSkillCard(
                        item = item,
                        todayEpochDay = state.todayEpochDay,
                        onStartDrill = {
                            onResetTimer()
                            activeDrill = item
                        }
                    )
                }
            }

            // Weak-Skill Identification Section
            if (state.weakSkills.isNotEmpty()) {
                item {
                    Spacer(Modifier.height(6.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(Icons.Filled.Warning, contentDescription = null, tint = DustyCrimson, modifier = Modifier.size(20.dp))
                        Text(
                            text = "Skills Needing Extra Attention",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                items(state.weakSkills.take(6), key = { "weak_${it.skill.id}" }) { item ->
                    DueSkillCard(
                        item = item,
                        todayEpochDay = state.todayEpochDay,
                        onStartDrill = {
                            onResetTimer()
                            activeDrill = item
                        }
                    )
                }
            }
        }
    }

    // Active Review Drill Runner Modal Sheet
    activeDrill?.let { drill ->
        val lesson = drill.recommendedLesson
        val exercise = lesson?.exercises?.firstOrNull()
        val checklist = lesson?.selfAssessmentChecklist ?: listOf(
            "Observed proportions and angles carefully before committing.",
            "Used deliberate, controlled pencil strokes without chicken-scratching.",
            "Checked values, edges, or perspective convergence honestly."
        )
        var checkedStates by remember(drill.skill.id) { mutableStateOf(List(checklist.size) { true }) }
        var rating by remember(drill.skill.id) { mutableStateOf(DifficultyRating.OKAY) }

        ModalBottomSheet(
            onDismissRequest = {
                onResetTimer()
                activeDrill = null
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "SPACED REVIEW DRILL",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = BlueprintCobalt
                            )
                            Text(
                                text = drill.skill.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        MasteryPill(tier = SpacedRepetitionEngine.masteryLevelFromIndex(drill.mastery.masteryTierIndex))
                    }
                }

                item {
                    SketchbookTimerBar(
                        seconds = state.timerSeconds,
                        running = state.timerRunning,
                        onToggle = onToggleTimer,
                        onReset = onResetTimer
                    )
                }

                if (lesson != null) {
                    item {
                        LessonDiagramCard(
                            diagramType = lesson.diagramType,
                            caption = lesson.learningObjective
                        )
                    }
                }

                item {
                    AtelierCard {
                        Text(
                            text = exercise?.title ?: "Recall Plate: ${drill.skill.name}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = exercise?.instructions ?: drill.skill.description,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "Target: ${exercise?.repetitions ?: "1 focused study plate"} • ~${exercise?.estimatedMinutes ?: 5} min",
                            style = MaterialTheme.typography.labelMedium,
                            color = BlueprintCobalt,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                item {
                    SelfAssessmentSection(
                        checklist = checklist,
                        checkedStates = checkedStates,
                        onToggleCheck = { idx ->
                            checkedStates = checkedStates.toMutableList().also { it[idx] = !it[idx] }
                        },
                        selectedRating = rating,
                        onSelectRating = { rating = it }
                    )
                }

                item {
                    val ratio = if (checkedStates.isEmpty()) 1f else checkedStates.count { it }.toFloat() / checkedStates.size
                    TactilePrimaryButton(
                        text = "Complete Review Drill",
                        onClick = {
                            onCompleteReview(drill.skill.id, rating, ratio, exercise?.estimatedMinutes ?: 5)
                            activeDrill = null
                        },
                        containerColor = AtelierSage,
                        testTag = "complete_review_drill_button"
                    )
                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
private fun DueSkillCard(
    item: DueSkillItem,
    todayEpochDay: Long,
    onStartDrill: () -> Unit
) {
    val tier = SpacedRepetitionEngine.masteryLevelFromIndex(item.mastery.masteryTierIndex)
    val daysDiff = item.mastery.nextReviewEpochDay - todayEpochDay
    val dueLabel = when {
        item.mastery.isWeak -> "Weak skill • Needs reinforcement"
        daysDiff < 0 -> "Overdue by ${-daysDiff}d"
        daysDiff == 0L -> "Due today"
        else -> "Review in ${daysDiff}d"
    }

    AtelierCard(
        modifier = Modifier
            .clickable { onStartDrill() }
            .testTag("due_skill_card_${item.skill.id}")
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "World ${item.skill.worldNumber}",
                        style = MaterialTheme.typography.labelSmall,
                        color = BlueprintCobalt,
                        fontWeight = FontWeight.Bold
                    )
                    MasteryPill(tier = tier)
                }
                Text(
                    text = item.skill.name,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$dueLabel • Practiced ${item.mastery.practiceCount}× (${item.mastery.distinctDaysPracticed} days)",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (item.mastery.isWeak) DustyCrimson else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = onStartDrill,
                modifier = Modifier
                    .heightIn(min = 48.dp)
                    .testTag("drill_button_${item.skill.id}")
            ) {
                Icon(Icons.Filled.Replay, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(4.dp))
                Text("Drill")
            }
        }
    }
}
