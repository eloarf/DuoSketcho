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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.curriculum.CurriculumCatalog
import com.example.data.curriculum.ReferenceLibraryData
import com.example.domain.model.MilestoneProject
import com.example.domain.model.ObservationChallenge
import com.example.ui.components.AtelierCard
import com.example.ui.components.SketchbookTimerBar
import com.example.ui.components.TactilePrimaryButton
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.DustyCrimson
import com.example.ui.theme.OchreGold
import com.example.viewmodel.AcademyUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilestoneProjectScreen(
    project: MilestoneProject,
    state: AcademyUiState,
    onBack: () -> Unit,
    onToggleTimer: () -> Unit,
    onResetTimer: () -> Unit,
    onCompleteMilestone: (minutes: Int, notes: String) -> Unit
) {
    var checked by remember(project.id) { mutableStateOf(List(project.selfAssessmentChecklist.size) { false }) }
    var notes by remember(project.id) { mutableStateOf("") }
    val alreadyDone = state.milestoneMap[project.id]?.completed == true

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("World ${project.worldNumber} Milestone") },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.TopCenter) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().widthIn(max = 640.dp),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    AtelierCard(
                        containerColor = OchreGold.copy(alpha = 0.12f),
                        borderColor = OchreGold.copy(alpha = 0.5f)
                    ) {
                        Text(
                            text = if (alreadyDone) "MILESTONE COMPLETED" else "CAPSTONE PROJECT (+${project.xpReward} XP)",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = if (alreadyDone) AtelierSage else OchreGold
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(project.title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(6.dp))
                        Text(project.brief, style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "Estimated Time: ~${project.estimatedMinutes} min • Combines: ${project.combinedSkills.joinToString(", ")}",
                            style = MaterialTheme.typography.labelMedium,
                            color = BlueprintCobalt
                        )
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

                item {
                    AtelierCard {
                        Text("Required Materials", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(4.dp))
                        project.requiredMaterials.forEach { Text("• $it", style = MaterialTheme.typography.bodyMedium) }
                        Spacer(Modifier.height(12.dp))
                        Text("Project Phases", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(4.dp))
                        project.phases.forEachIndexed { idx, phase ->
                            Text("${idx + 1}. $phase", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(vertical = 3.dp))
                        }
                    }
                }

                item {
                    AtelierCard {
                        Text("Milestone Self-Audit", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(6.dp))
                        project.selfAssessmentChecklist.forEachIndexed { idx, crit ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = checked[idx],
                                    onCheckedChange = { checked = checked.toMutableList().also { l -> l[idx] = !l[idx] } }
                                )
                                Text(crit, style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                        Spacer(Modifier.height(8.dp))
                        OutlinedTextField(
                            value = notes,
                            onValueChange = { notes = it },
                            label = { Text("Capstone notes for your sketchbook log") },
                            modifier = Modifier.fillMaxWidth(),
                            minLines = 2
                        )
                    }
                }

                item {
                    TactilePrimaryButton(
                        text = if (alreadyDone) "Log Another Capstone Pass" else "Complete World ${project.worldNumber} Milestone",
                        onClick = { onCompleteMilestone(project.estimatedMinutes, notes.trim()) },
                        containerColor = AtelierSage,
                        testTag = "complete_milestone_button"
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeLibraryScreen(
    onBack: () -> Unit,
    onOpenLesson: (String) -> Unit
) {
    var selectedWorld by remember { mutableIntStateOf(0) }
    val filteredLessons = remember(selectedWorld) {
        if (selectedWorld == 0) CurriculumCatalog.allLessons
        else CurriculumCatalog.allLessons.filter { it.worldNumber == selectedWorld }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Practice Drill Library (${filteredLessons.size} Lessons)") },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.TopCenter) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().widthIn(max = 640.dp),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        item {
                            FilterChip(
                                selected = selectedWorld == 0,
                                onClick = { selectedWorld = 0 },
                                label = { Text("All 12 Worlds") }
                            )
                        }
                        items((1..12).toList()) { num ->
                            FilterChip(
                                selected = selectedWorld == num,
                                onClick = { selectedWorld = num },
                                label = { Text("W$num") }
                            )
                        }
                    }
                }

                items(filteredLessons, key = { it.id }) { lesson ->
                    AtelierCard(
                        modifier = Modifier.clickable { onOpenLesson(lesson.id) }
                    ) {
                        Text(
                            text = "World ${lesson.worldNumber} • ~${lesson.estimatedMinutes} min",
                            style = MaterialTheme.typography.labelSmall,
                            color = BlueprintCobalt,
                            fontWeight = FontWeight.Bold
                        )
                        Text(lesson.title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(4.dp))
                        lesson.exercises.forEach { ex ->
                            Text(
                                text = "• ${ex.title} (${ex.repetitions})",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ObservationChallengesScreen(
    state: AcademyUiState,
    onBack: () -> Unit,
    onToggleTimer: () -> Unit,
    onResetTimer: () -> Unit,
    onCompleteChallenge: (ObservationChallenge, Int, String) -> Unit
) {
    var activeChallenge by remember { mutableStateOf<ObservationChallenge?>(null) }
    var reflection by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Real-World Observation Challenges") },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.TopCenter) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().widthIn(max = 640.dp),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text(
                        text = "Draw real everyday objects around your desk, kitchen, and window—no photos or screens required.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                activeChallenge?.let { ch ->
                    item {
                        AtelierCard(
                            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                            borderColor = BlueprintCobalt
                        ) {
                            Text("ACTIVE OBSERVATION", style = MaterialTheme.typography.labelSmall, color = BlueprintCobalt, fontWeight = FontWeight.Bold)
                            Text(ch.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(6.dp))
                            Text(ch.subjectPrompt, style = MaterialTheme.typography.bodyMedium)
                            Spacer(Modifier.height(6.dp))
                            Text("Setup: ${ch.setupInstructions}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Spacer(Modifier.height(10.dp))
                            SketchbookTimerBar(
                                seconds = state.timerSeconds,
                                running = state.timerRunning,
                                onToggle = onToggleTimer,
                                onReset = onResetTimer
                            )
                            Spacer(Modifier.height(10.dp))
                            OutlinedTextField(
                                value = reflection,
                                onValueChange = { reflection = it },
                                label = { Text("Sketchbook observation note (optional)") },
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(10.dp))
                            TactilePrimaryButton(
                                text = "Log Observation (+${ch.xpReward} XP)",
                                onClick = {
                                    onCompleteChallenge(ch, ch.estimatedMinutes, reflection.trim())
                                    reflection = ""
                                    activeChallenge = null
                                },
                                containerColor = AtelierSage,
                                testTag = "complete_observation_button"
                            )
                        }
                    }
                }

                items(ReferenceLibraryData.observationChallenges, key = { it.id }) { ch ->
                    val count = state.observationMap[ch.id]?.completionCount ?: 0
                    AtelierCard(
                        modifier = Modifier.clickable {
                            onResetTimer()
                            activeChallenge = ch
                        }
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Recommended World ${ch.worldRecommended}+ • ~${ch.estimatedMinutes}m",
                                style = MaterialTheme.typography.labelSmall,
                                color = BlueprintCobalt,
                                fontWeight = FontWeight.Bold
                            )
                            if (count > 0) {
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    Icon(Icons.Filled.CheckCircle, contentDescription = "Completed", tint = AtelierSage, modifier = Modifier.size(16.dp))
                                    Text("${count}×", style = MaterialTheme.typography.labelSmall, color = AtelierSage, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(ch.title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(4.dp))
                        Text(ch.subjectPrompt, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "Focus: ${ch.techniqueFocus.joinToString(" • ")}",
                            style = MaterialTheme.typography.labelSmall,
                            color = AtelierSage
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MistakeLibraryScreen(
    onBack: () -> Unit,
    onOpenLesson: (String) -> Unit
) {
    var query by remember { mutableStateOf("") }
    val filtered = remember(query) {
        val q = query.trim().lowercase()
        if (q.isEmpty()) ReferenceLibraryData.mistakes
        else ReferenceLibraryData.mistakes.filter {
            it.title.lowercase().contains(q) ||
                it.symptom.lowercase().contains(q) ||
                it.correctiveDrill.lowercase().contains(q) ||
                it.worldTitle.lowercase().contains(q)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mistake Diagnosis Library") },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.TopCenter) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().widthIn(max = 640.dp),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    OutlinedTextField(
                        value = query,
                        onValueChange = { query = it },
                        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                        label = { Text("Search drawing issue (e.g. ellipses, shading, eyes)") },
                        modifier = Modifier.fillMaxWidth().testTag("mistake_search_input"),
                        singleLine = true
                    )
                }

                items(filtered, key = { it.id }) { item ->
                    AtelierCard(
                        modifier = Modifier.clickable { onOpenLesson(item.relatedLessonId) }
                    ) {
                        Text(
                            text = "World ${item.worldNumber}: ${item.worldTitle}",
                            style = MaterialTheme.typography.labelSmall,
                            color = BlueprintCobalt,
                            fontWeight = FontWeight.Bold
                        )
                        Text(item.title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = DustyCrimson)
                        Spacer(Modifier.height(4.dp))
                        Text("Symptom: ${item.symptom}", style = MaterialTheme.typography.bodySmall)
                        Text("Cause: ${item.rootCause}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Spacer(Modifier.height(6.dp))
                        Text("Corrective Drill: ${item.correctiveDrill}", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold, color = AtelierSage)
                    }
                }
            }
        }
    }
}
