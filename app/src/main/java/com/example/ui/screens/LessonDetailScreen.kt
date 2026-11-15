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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.ReportProblem
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.example.data.curriculum.CurriculumCatalog
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.model.DifficultyRating
import com.example.domain.model.Lesson
import com.example.ui.components.AtelierCard
import com.example.ui.components.LessonDiagramCard
import com.example.ui.components.MasteryPill
import com.example.ui.components.SelfAssessmentSection
import com.example.ui.components.SketchbookTimerBar
import com.example.ui.components.TactilePrimaryButton
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.DustyCrimson
import com.example.ui.theme.OchreGold
import com.example.viewmodel.AcademyUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonDetailScreen(
    lesson: Lesson,
    state: AcademyUiState,
    onBack: () -> Unit,
    onToggleTimer: () -> Unit,
    onResetTimer: () -> Unit,
    onCompleteLesson: (
        rating: DifficultyRating,
        checklistRatio: Float,
        includeChallenge: Boolean,
        reflection: String,
        needsImprovement: String
    ) -> Unit
) {
    var exerciseDone by remember(lesson.id) { mutableStateOf(List(lesson.exercises.size) { false }) }
    var includeChallenge by remember(lesson.id) { mutableStateOf(false) }
    var checklistChecked by remember(lesson.id) { mutableStateOf(List(lesson.selfAssessmentChecklist.size) { false }) }
    var selectedRating by remember(lesson.id) { mutableStateOf(DifficultyRating.OKAY) }
    var reflectionNote by remember(lesson.id) { mutableStateOf("") }
    var needsImprovementNote by remember(lesson.id) { mutableStateOf("") }

    val skillMastery = state.skillMasteryMap[lesson.primarySkillId]
    val skillTier = SpacedRepetitionEngine.masteryLevelFromIndex(skillMastery?.masteryTierIndex ?: 0)
    val skillName = CurriculumCatalog.getSkillById(lesson.primarySkillId)?.name ?: lesson.primarySkillId

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "World ${lesson.worldNumber} • ~${lesson.estimatedMinutes} min",
                            style = MaterialTheme.typography.labelSmall,
                            color = BlueprintCobalt
                        )
                        Text(
                            text = lesson.title,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .size(48.dp)
                            .testTag("lesson_back_button")
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
                // Header + Mastery Badge
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = lesson.subtitle,
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = "Primary Skill: $skillName",
                                style = MaterialTheme.typography.labelMedium,
                                color = BlueprintCobalt,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        MasteryPill(tier = skillTier)
                    }
                }

                // Timer
                item {
                    SketchbookTimerBar(
                        seconds = state.timerSeconds,
                        running = state.timerRunning,
                        onToggle = onToggleTimer,
                        onReset = onResetTimer
                    )
                }

                // 1. Learning Objective & 2. Explanation & 3. Why It Matters
                item {
                    AtelierCard {
                        Text(
                            text = "Learning Objective",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(text = lesson.learningObjective, style = MaterialTheme.typography.bodyMedium)

                        Spacer(Modifier.height(12.dp))
                        Text(
                            text = "Technique Explanation",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(text = lesson.explanation, style = MaterialTheme.typography.bodyMedium)

                        Spacer(Modifier.height(12.dp))
                        Text(
                            text = "Why This Skill Matters",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = AtelierSage
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(text = lesson.whyItMatters, style = MaterialTheme.typography.bodyMedium)
                    }
                }

                // Educational Vector Diagram
                item {
                    LessonDiagramCard(
                        diagramType = lesson.diagramType,
                        caption = lesson.learningObjective
                    )
                }

                // 4. Required Materials & 5. Step-by-step Instructions
                item {
                    AtelierCard {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Filled.Build, contentDescription = null, tint = BlueprintCobalt, modifier = Modifier.size(18.dp))
                            Text(
                                text = "Required Physical Materials",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(Modifier.height(6.dp))
                        lesson.requiredMaterials.forEach { mat ->
                            Text(
                                text = "• $mat",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 1.dp)
                            )
                        }

                        Spacer(Modifier.height(14.dp))
                        Text(
                            text = "Step-by-Step Instructions",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(6.dp))
                        lesson.steps.forEachIndexed { idx, step ->
                            Text(
                                text = "${idx + 1}. $step",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 3.dp)
                            )
                        }
                    }
                }

                // 6. Detailed Practical Exercises with Repetition Counts
                item {
                    AtelierCard {
                        Text(
                            text = "Practical Sketchbook Exercises",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(8.dp))
                        lesson.exercises.forEachIndexed { idx, ex ->
                            val done = exerciseDone[idx]
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 6.dp),
                                verticalAlignment = Alignment.Top
                            ) {
                                Checkbox(
                                    checked = done,
                                    onCheckedChange = {
                                        exerciseDone = exerciseDone.toMutableList().also { list -> list[idx] = !list[idx] }
                                    },
                                    modifier = Modifier.testTag("exercise_checkbox_$idx")
                                )
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "${idx + 1}. ${ex.title}",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "${ex.repetitions} • ~${ex.estimatedMinutes} min",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = BlueprintCobalt,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                    Spacer(Modifier.height(3.dp))
                                    Text(
                                        text = ex.instructions,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }

                // 7. Optional Harder Challenge
                item {
                    val ch = lesson.optionalChallenge
                    AtelierCard(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "OPTIONAL HARDER CHALLENGE (+15 XP)",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = OchreGold
                                )
                                Text(
                                    text = ch.title,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Switch(
                                checked = includeChallenge,
                                onCheckedChange = { includeChallenge = it },
                                modifier = Modifier.testTag("challenge_toggle")
                            )
                        }
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "${ch.repetitions} (~${ch.estimatedMinutes} min)",
                            style = MaterialTheme.typography.labelMedium,
                            color = BlueprintCobalt
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(text = ch.instructions, style = MaterialTheme.typography.bodyMedium)
                    }
                }

                // 8. Common Mistakes & Corrections
                item {
                    AtelierCard {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Filled.ReportProblem, contentDescription = null, tint = DustyCrimson, modifier = Modifier.size(18.dp))
                            Text(
                                text = "Common Mistakes & Fixes",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        lesson.commonMistakes.forEach { mc ->
                            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                                Text(
                                    text = "Mistake: ${mc.mistake}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = DustyCrimson
                                )
                                Text(
                                    text = "Fix: ${mc.correction}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }

                // 9. Self-Assessment Checklist & Rating & 10. Completion Criteria
                item {
                    AtelierCard {
                        Text(
                            text = "Completion Criteria",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = lesson.completionCriteria,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                item {
                    SelfAssessmentSection(
                        checklist = lesson.selfAssessmentChecklist,
                        checkedStates = checklistChecked,
                        onToggleCheck = { idx ->
                            checklistChecked = checklistChecked.toMutableList().also { it[idx] = !it[idx] }
                        },
                        selectedRating = selectedRating,
                        onSelectRating = { selectedRating = it }
                    )
                }

                // Optional Journal Reflection
                item {
                    AtelierCard {
                        Text(
                            text = "Optional Sketchbook Reflection",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(8.dp))
                        OutlinedTextField(
                            value = reflectionNote,
                            onValueChange = { reflectionNote = it },
                            label = { Text("What improved in your sketchbook today?") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("lesson_reflection_input"),
                            minLines = 2
                        )
                        Spacer(Modifier.height(8.dp))
                        OutlinedTextField(
                            value = needsImprovementNote,
                            onValueChange = { needsImprovementNote = it },
                            label = { Text("What needs focus next time?") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("lesson_improvement_input"),
                            minLines = 1
                        )
                    }
                }

                item {
                    val ratio = if (checklistChecked.isEmpty()) 1f else {
                        checklistChecked.count { it }.toFloat() / checklistChecked.size.toFloat()
                    }
                    TactilePrimaryButton(
                        text = "Complete Lesson & Log Practice",
                        onClick = {
                            onCompleteLesson(
                                selectedRating,
                                ratio,
                                includeChallenge,
                                reflectionNote.trim(),
                                needsImprovementNote.trim()
                            )
                        },
                        containerColor = AtelierSage,
                        testTag = "complete_lesson_button"
                    )
                    Spacer(Modifier.height(24.dp))
                }
            }
        }
    }
}
