package com.example.ui.screens

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.ReportProblem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.curriculum.CurriculumCatalog
import com.example.data.curriculum.PedagogicalData
import com.example.data.visual.VisualCatalog
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.model.ConfidenceLevel
import com.example.domain.model.DifficultyRating
import com.example.domain.model.Lesson
import com.example.domain.model.VisualScaffoldLevel
import com.example.ui.components.AtelierCard
import com.example.ui.components.HonestTutorFeedbackCard
import com.example.ui.components.MasteryPill
import com.example.ui.components.RecallCheckCard
import com.example.ui.components.SelfAssessmentSection
import com.example.ui.components.SketchbookTimerBar
import com.example.ui.components.StructuredExerciseCard
import com.example.ui.components.TactilePrimaryButton
import com.example.ui.components.visual.MistakeComparisonCard
import com.example.ui.components.visual.VisualDemonstrationPlayer
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.DustyCrimson
import com.example.ui.theme.OchreGold
import com.example.viewmodel.AcademyUiState

private val teachingStageTitles = listOf(
    "1. Understand",
    "2. Observe",
    "3. Deconstruct",
    "4. Guided",
    "5. Repeat",
    "6. Apply",
    "7. Reflect"
)

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
        needsImprovement: String,
        confidence: ConfidenceLevel
    ) -> Unit
) {
    var currentStage by rememberSaveable(lesson.id) { mutableIntStateOf(0) }
    var materialsExpanded by remember(lesson.id) { mutableStateOf(false) }
    var mistakesExpanded by remember(lesson.id) { mutableStateOf(false) }
    var showUnguidedHints by remember(lesson.id) { mutableStateOf(false) }

    var exerciseDone by remember(lesson.id) { mutableStateOf(List(lesson.exercises.size) { false }) }
    var includeChallenge by remember(lesson.id) { mutableStateOf(false) }
    var recallSelectedIdx by remember(lesson.id) { mutableStateOf<Int?>(null) }
    var checklistChecked by remember(lesson.id) { mutableStateOf(List(lesson.selfAssessmentChecklist.size) { false }) }
    var selectedRating by remember(lesson.id) { mutableStateOf(DifficultyRating.OKAY) }
    var selectedConfidence by remember(lesson.id) { mutableStateOf(ConfidenceLevel.MODERATE) }
    var reflectionNote by remember(lesson.id) { mutableStateOf("") }
    var needsImprovementNote by remember(lesson.id) { mutableStateOf("") }

    BackHandler(enabled = currentStage > 0) {
        currentStage -= 1
    }

    val skillMastery = state.skillMasteryMap[lesson.primarySkillId]
    val skillTier = SpacedRepetitionEngine.masteryLevelFromIndex(skillMastery?.masteryTierIndex ?: 0)
    val skillName = CurriculumCatalog.getSkillById(lesson.primarySkillId)?.name ?: lesson.primarySkillId
    val weakPrereqNames = SpacedRepetitionEngine.findWeakPrerequisites(lesson.primarySkillId, state.skillMasteryMap)
        .map { it.name }
    val visualDemo = remember(lesson.id) { VisualCatalog.getDemoForLesson(lesson) }

    val progress = ((currentStage + 1).toFloat() / teachingStageTitles.size.toFloat()).coerceIn(0f, 1f)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Stage ${currentStage + 1} of 7 • ${teachingStageTitles[currentStage]}",
                            style = MaterialTheme.typography.labelSmall,
                            color = BlueprintCobalt,
                            fontWeight = FontWeight.Bold
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
                        onClick = {
                            if (currentStage > 0) currentStage -= 1 else onBack()
                        },
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
                // Stage progress indicator + compact jump pills
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        LinearProgressIndicator(
                            progress = { progress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = BlueprintCobalt,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            itemsIndexed(teachingStageTitles) { idx, label ->
                                val active = idx == currentStage
                                val visited = idx < currentStage
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(50))
                                        .background(
                                            when {
                                                active -> BlueprintCobalt
                                                visited -> AtelierSage.copy(alpha = 0.16f)
                                                else -> MaterialTheme.colorScheme.surfaceVariant
                                            }
                                        )
                                        .clickable { currentStage = idx }
                                        .padding(horizontal = 12.dp, vertical = 6.dp)
                                        .testTag("lesson_stage_pill_$idx")
                                ) {
                                    Text(
                                        text = label,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = if (active) FontWeight.Bold else FontWeight.Medium,
                                        color = when {
                                            active -> MaterialTheme.colorScheme.onPrimary
                                            visited -> AtelierSage
                                            else -> MaterialTheme.colorScheme.onSurfaceVariant
                                        }
                                    )
                                }
                            }
                        }
                    }
                }

                // Header context strip
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "World ${lesson.worldNumber} • $skillName",
                                style = MaterialTheme.typography.labelMedium,
                                color = BlueprintCobalt,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = lesson.subtitle,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        MasteryPill(tier = skillTier)
                    }
                }

                // Timer visible on active practice stages (4, 5, 6)
                if (currentStage in 3..5) {
                    item {
                        SketchbookTimerBar(
                            seconds = state.timerSeconds,
                            running = state.timerRunning,
                            onToggle = onToggleTimer,
                            onReset = onResetTimer
                        )
                    }
                }

                // Focused single-objective body per stage
                when (currentStage) {
                    // STAGE 1: UNDERSTAND
                    0 -> {
                        item {
                            AtelierCard {
                                Text(
                                    text = "1. UNDERSTAND THE GOAL",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = BlueprintCobalt
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = lesson.learningObjective,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.height(10.dp))
                                Text(
                                    text = lesson.explanation,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }

                        item {
                            VisualDemonstrationPlayer(
                                demo = visualDemo,
                                scaffoldLevel = VisualScaffoldLevel.REFERENCE_ONLY,
                                compact = true,
                                headerOverride = "GOAL VISUAL REFERENCE • STUDY ON PAPER"
                            )
                        }

                        item {
                            AtelierCard {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { materialsExpanded = !materialsExpanded }
                                        .testTag("expand_materials_why"),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Icon(Icons.Filled.Build, contentDescription = null, tint = BlueprintCobalt, modifier = Modifier.size(18.dp))
                                        Text(
                                            text = "Why It Matters & Physical Materials",
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Icon(
                                        imageVector = if (materialsExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                                        contentDescription = "Toggle materials"
                                    )
                                }
                                AnimatedVisibility(visible = materialsExpanded) {
                                    Column(modifier = Modifier.padding(top = 10.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                        Text(
                                            text = lesson.whyItMatters,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = AtelierSage
                                        )
                                        Text(
                                            text = "Materials needed: ${lesson.requiredMaterials.joinToString(" • ")}",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }
                        }
                    }

                    // STAGE 2: OBSERVE
                    1 -> {
                        item {
                            VisualDemonstrationPlayer(
                                demo = visualDemo,
                                scaffoldLevel = VisualScaffoldLevel.FULL_GUIDANCE,
                                compact = false,
                                headerOverride = "2. OBSERVE ANIMATED CONSTRUCTION"
                            )
                        }
                        if (lesson.cumulativeSkillsLabel.isNotBlank()) {
                            item {
                                AtelierCard(
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.35f)
                                ) {
                                    Text(
                                        text = "CUMULATIVE CONNECTION",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = BlueprintCobalt
                                    )
                                    Spacer(Modifier.height(4.dp))
                                    Text(
                                        text = lesson.cumulativeSkillsLabel,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    if (lesson.prerequisiteSkillIds.isNotEmpty()) {
                                        val prereqNames = lesson.prerequisiteSkillIds.mapNotNull {
                                            CurriculumCatalog.getSkillById(it)?.name
                                        }
                                        if (prereqNames.isNotEmpty()) {
                                            Spacer(Modifier.height(4.dp))
                                            Text(
                                                text = "Combines with: ${prereqNames.joinToString(", ")}",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // STAGE 3: DECONSTRUCT
                    2 -> {
                        item {
                            AtelierCard {
                                Text(
                                    text = "3. DECONSTRUCT INTO STEPS",
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold,
                                    color = BlueprintCobalt
                                )
                                Spacer(Modifier.height(6.dp))
                                Text(
                                    text = "Break the drawing down sequentially before touching full detail:",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(Modifier.height(10.dp))
                                lesson.steps.forEachIndexed { idx, step ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 5.dp),
                                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(26.dp)
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(BlueprintCobalt.copy(alpha = 0.14f)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "${idx + 1}",
                                                style = MaterialTheme.typography.labelMedium,
                                                fontWeight = FontWeight.Bold,
                                                color = BlueprintCobalt
                                            )
                                        }
                                        Text(
                                            text = step,
                                            style = MaterialTheme.typography.bodyMedium,
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }
                        }

                        item {
                            AtelierCard {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { mistakesExpanded = !mistakesExpanded }
                                        .testTag("expand_mistakes"),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Icon(Icons.Filled.ReportProblem, contentDescription = null, tint = DustyCrimson, modifier = Modifier.size(18.dp))
                                        Text(
                                            text = "Watch Out: Common Mistakes (${lesson.commonMistakes.size})",
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Icon(
                                        imageVector = if (mistakesExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                                        contentDescription = "Toggle mistakes"
                                    )
                                }
                                AnimatedVisibility(visible = mistakesExpanded) {
                                    Column(modifier = Modifier.padding(top = 8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                        lesson.commonMistakes.forEach { mc ->
                                            Column {
                                                Text(
                                                    text = "Mistake: ${mc.mistake}",
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = DustyCrimson
                                                )
                                                Text(
                                                    text = "Fix: ${mc.correction}",
                                                    style = MaterialTheme.typography.bodySmall
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        item {
                            MistakeComparisonCard(comparison = visualDemo.comparison)
                        }
                    }

                    // STAGE 4: GUIDED PRACTICE
                    3 -> {
                        item {
                            VisualDemonstrationPlayer(
                                demo = visualDemo,
                                scaffoldLevel = VisualScaffoldLevel.FULL_GUIDANCE,
                                compact = true,
                                headerOverride = "4. GUIDED VISUAL SCAFFOLD — FOLLOW STAGE BY STAGE"
                            )
                        }
                        val ex1 = lesson.exercises.getOrNull(0)
                        if (ex1 != null) {
                            item {
                                StructuredExerciseCard(
                                    exercise = ex1,
                                    checked = exerciseDone.getOrElse(0) { false },
                                    onToggleDone = {
                                        exerciseDone = exerciseDone.toMutableList().also { it[0] = !it[0] }
                                    },
                                    checkboxTag = "exercise_checkbox_0"
                                )
                            }
                        }
                    }

                    // STAGE 5: REPETITION
                    4 -> {
                        item {
                            VisualDemonstrationPlayer(
                                demo = visualDemo,
                                scaffoldLevel = VisualScaffoldLevel.PARTIAL_GUIDANCE,
                                compact = true,
                                headerOverride = "5. REPETITION — REDUCED GUIDES (VARY ANGLE OR SCALE)"
                            )
                        }
                        val ex2 = lesson.exercises.getOrNull(1)
                        if (ex2 != null) {
                            item {
                                StructuredExerciseCard(
                                    exercise = ex2,
                                    checked = exerciseDone.getOrElse(1) { false },
                                    onToggleDone = {
                                        exerciseDone = exerciseDone.toMutableList().also { it[1] = !it[1] }
                                    },
                                    checkboxTag = "exercise_checkbox_1"
                                )
                            }
                        }
                    }

                    // STAGE 6: INDEPENDENT APPLICATION + OPTIONAL CHALLENGE
                    5 -> {
                        val ex3 = lesson.exercises.getOrNull(2)
                        item {
                            VisualDemonstrationPlayer(
                                demo = visualDemo,
                                scaffoldLevel = if (ex3?.isUnguided == true) VisualScaffoldLevel.MEMORY_PROMPT else VisualScaffoldLevel.REFERENCE_ONLY,
                                compact = true,
                                headerOverride = "6. INDEPENDENT APPLICATION — CONSTRUCT ON PAPER FIRST"
                            )
                        }
                        if (ex3 != null) {
                            item {
                                StructuredExerciseCard(
                                    exercise = ex3,
                                    checked = exerciseDone.getOrElse(2) { false },
                                    onToggleDone = {
                                        exerciseDone = exerciseDone.toMutableList().also { it[2] = !it[2] }
                                    },
                                    showScaffoldHints = !ex3.isUnguided || showUnguidedHints,
                                    onToggleScaffoldHints = if (ex3.isUnguided) {
                                        { showUnguidedHints = !showUnguidedHints }
                                    } else null,
                                    checkboxTag = "exercise_checkbox_2"
                                )
                            }
                        }
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
                                            text = "OPTIONAL CUMULATIVE CHALLENGE (+15 XP)",
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
                                    text = "${ch.repetitions} • ~${ch.estimatedMinutes} min",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = BlueprintCobalt
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(text = ch.instructions, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }

                    // STAGE 7: REFLECTION & HONEST TUTOR FEEDBACK
                    6 -> {
                        item {
                            RecallCheckCard(
                                question = lesson.recallQuestion,
                                selectedIndex = recallSelectedIdx,
                                onSelectOption = { recallSelectedIdx = it }
                            )
                        }

                        item {
                            SelfAssessmentSection(
                                checklist = lesson.selfAssessmentChecklist,
                                checkedStates = checklistChecked,
                                onToggleCheck = { idx ->
                                    checklistChecked = checklistChecked.toMutableList().also { it[idx] = !it[idx] }
                                },
                                selectedRating = selectedRating,
                                onSelectRating = { selectedRating = it },
                                selectedConfidence = selectedConfidence,
                                onSelectConfidence = { selectedConfidence = it }
                            )
                        }

                        item {
                            val recallCorrect = recallSelectedIdx?.let { it == lesson.recallQuestion.correctIndex }
                            val honestFeedback = PedagogicalData.evaluateSelfAssessment(
                                lesson = lesson,
                                checkedStates = checklistChecked,
                                rating = selectedRating,
                                confidence = selectedConfidence,
                                recallAnsweredCorrectly = recallCorrect,
                                prerequisiteWeakNames = weakPrereqNames
                            )
                            HonestTutorFeedbackCard(feedback = honestFeedback)
                        }

                        item {
                            AtelierCard {
                                Text(
                                    text = "Sketchbook Reflection Note (Optional)",
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.height(8.dp))
                                OutlinedTextField(
                                    value = reflectionNote,
                                    onValueChange = { reflectionNote = it },
                                    label = { Text("What clicked on paper today?") },
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
                    }
                }

                // Bottom navigation / completion CTA
                item {
                    val ratio = if (checklistChecked.isEmpty()) 1f else {
                        checklistChecked.count { it }.toFloat() / checklistChecked.size.toFloat()
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        if (currentStage > 0) {
                            OutlinedButton(
                                onClick = { currentStage -= 1 },
                                modifier = Modifier
                                    .weight(1f)
                                    .heightIn(min = 50.dp)
                                    .testTag("lesson_prev_stage_button")
                            ) {
                                Text("Previous")
                            }
                        }
                        if (currentStage < teachingStageTitles.lastIndex) {
                            TactilePrimaryButton(
                                text = "Next: ${teachingStageTitles[currentStage + 1]}",
                                onClick = {
                                    if (currentStage in 3..5) {
                                        val exIdx = currentStage - 3
                                        if (!exerciseDone.getOrElse(exIdx) { true }) {
                                            exerciseDone = exerciseDone.toMutableList().also { it[exIdx] = true }
                                        }
                                    }
                                    currentStage += 1
                                },
                                modifier = Modifier.weight(1.5f),
                                testTag = "lesson_next_stage_button"
                            )
                        } else {
                            TactilePrimaryButton(
                                text = "Complete Lesson & Log Practice",
                                onClick = {
                                    onCompleteLesson(
                                        selectedRating,
                                        ratio,
                                        includeChallenge,
                                        reflectionNote.trim(),
                                        needsImprovementNote.trim(),
                                        selectedConfidence
                                    )
                                },
                                containerColor = AtelierSage,
                                modifier = Modifier.weight(1.6f),
                                testTag = "complete_lesson_button"
                            )
                        }
                    }
                    Spacer(Modifier.height(24.dp))
                }
            }
        }
    }
}
