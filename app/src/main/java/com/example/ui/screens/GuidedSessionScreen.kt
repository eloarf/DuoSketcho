package com.example.ui.screens

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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.activity.compose.BackHandler
import com.example.data.curriculum.CurriculumCatalog
import com.example.domain.model.ConfidenceLevel
import com.example.domain.model.DifficultyRating
import com.example.domain.model.GuidedSessionPlan
import com.example.ui.components.AtelierCard
import com.example.ui.components.LessonDiagramCard
import com.example.ui.components.SelfAssessmentSection
import com.example.ui.components.SketchbookTimerBar
import com.example.ui.components.TactilePrimaryButton
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.viewmodel.AcademyUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuidedSessionScreen(
    plan: GuidedSessionPlan,
    state: AcademyUiState,
    onBack: () -> Unit,
    onToggleTimer: () -> Unit,
    onResetTimer: () -> Unit,
    onCompleteSession: (
        rating: DifficultyRating,
        checklistRatio: Float,
        reflection: String,
        needsImprovement: String,
        confidence: ConfidenceLevel
    ) -> Unit
) {
    var currentStepIdx by remember(plan) { mutableIntStateOf(0) }
    val steps = plan.steps
    val isSummaryStage = currentStepIdx >= steps.size

    BackHandler(enabled = currentStepIdx > 0) {
        currentStepIdx -= 1
    }

    val mainLesson = steps.firstNotNullOfOrNull { it.lessonId }?.let { CurriculumCatalog.getLessonById(it) }
    val checklist = mainLesson?.selfAssessmentChecklist ?: listOf(
        "Completed warm-up strokes smoothly from the shoulder.",
        "Applied today's new concept consciously in my sketchbook.",
        "Practiced spaced review skill without rushing."
    )
    var checklistChecked by remember(plan) { mutableStateOf(List(checklist.size) { false }) }
    var rating by remember(plan) { mutableStateOf(DifficultyRating.OKAY) }
    var confidence by remember(plan) { mutableStateOf(ConfidenceLevel.MODERATE) }
    var reflection by remember(plan) { mutableStateOf("") }
    var needsImprovement by remember(plan) { mutableStateOf("") }

    val progress = ((currentStepIdx + 1).toFloat() / (steps.size + 1).toFloat()).coerceIn(0f, 1f)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = plan.mode.label,
                            style = MaterialTheme.typography.labelSmall,
                            color = BlueprintCobalt
                        )
                        Text(
                            text = if (isSummaryStage) "Session Assessment" else "Step ${currentStepIdx + 1} of ${steps.size}",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .size(48.dp)
                            .testTag("session_back_button")
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .widthIn(max = 640.dp),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    LinearProgressIndicator(
                        progress = { progress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = AtelierSage,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }

                item {
                    SketchbookTimerBar(
                        seconds = state.timerSeconds,
                        running = state.timerRunning,
                        onToggle = onToggleTimer,
                        onReset = onResetTimer
                    )
                }

                if (!isSummaryStage) {
                    val step = steps[currentStepIdx]
                    val stepLesson = step.lessonId?.let { CurriculumCatalog.getLessonById(it) }

                    item {
                        AtelierCard(
                            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                            borderColor = BlueprintCobalt.copy(alpha = 0.45f)
                        ) {
                            Text(
                                text = step.phaseLabel.uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = BlueprintCobalt
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = step.title,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = step.subtitle,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(
                                text = "Target: ${step.repetitions} • ~${step.durationMinutes} min",
                                style = MaterialTheme.typography.labelLarge,
                                color = AtelierSage,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    if (stepLesson != null) {
                        item {
                            LessonDiagramCard(
                                diagramType = stepLesson.diagramType,
                                caption = stepLesson.learningObjective
                            )
                        }
                    }

                    item {
                        AtelierCard {
                            Text(
                                text = "Sketchbook Instructions",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                text = step.instructions,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            if (currentStepIdx > 0) {
                                OutlinedButton(
                                    onClick = { currentStepIdx-- },
                                    modifier = Modifier
                                        .weight(1f)
                                        .heightIn(min = 50.dp)
                                        .testTag("session_prev_step_button")
                                ) {
                                    Text("Previous")
                                }
                            }
                            TactilePrimaryButton(
                                text = if (currentStepIdx == steps.lastIndex) "Finish Drills -> Assess" else "Next Stage",
                                onClick = { currentStepIdx++ },
                                modifier = Modifier.weight(1.4f),
                                testTag = "session_next_step_button"
                            )
                        }
                    }
                } else {
                    item {
                        SelfAssessmentSection(
                            checklist = checklist,
                            checkedStates = checklistChecked,
                            onToggleCheck = { idx ->
                                checklistChecked = checklistChecked.toMutableList().also { it[idx] = !it[idx] }
                            },
                            selectedRating = rating,
                            onSelectRating = { rating = it },
                            selectedConfidence = confidence,
                            onSelectConfidence = { confidence = it }
                        )
                    }

                    item {
                        AtelierCard {
                            Text(
                                text = "Session Reflection (Optional)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(8.dp))
                            OutlinedTextField(
                                value = reflection,
                                onValueChange = { reflection = it },
                                label = { Text("Observations from your sketchbook") },
                                modifier = Modifier.fillMaxWidth(),
                                minLines = 2
                            )
                            Spacer(Modifier.height(8.dp))
                            OutlinedTextField(
                                value = needsImprovement,
                                onValueChange = { needsImprovement = it },
                                label = { Text("What needs refinement next session?") },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    item {
                        val ratio = if (checklistChecked.isEmpty()) 1f else {
                            checklistChecked.count { it }.toFloat() / checklistChecked.size.toFloat()
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            OutlinedButton(
                                onClick = { currentStepIdx = steps.lastIndex },
                                modifier = Modifier
                                    .weight(1f)
                                    .heightIn(min = 50.dp)
                            ) {
                                Text("Back")
                            }
                            TactilePrimaryButton(
                                text = "Log Session (+${plan.estimatedXp} XP)",
                                onClick = {
                                    onCompleteSession(
                                        rating,
                                        ratio,
                                        reflection.trim(),
                                        needsImprovement.trim(),
                                        confidence
                                    )
                                },
                                containerColor = AtelierSage,
                                modifier = Modifier.weight(1.6f),
                                testTag = "complete_guided_session_button"
                            )
                        }
                    }
                }
            }
        }
    }
}
