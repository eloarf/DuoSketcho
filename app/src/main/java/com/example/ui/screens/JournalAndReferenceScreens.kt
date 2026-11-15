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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.data.curriculum.ReferenceLibraryData
import com.example.domain.engine.DateTimeUtils
import com.example.ui.components.AtelierCard
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.TerracottaFlame
import com.example.viewmodel.AcademyUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtGlossaryScreen(
    onBack: () -> Unit
) {
    var query by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    val categories = remember {
        listOf("All") + ReferenceLibraryData.glossary.map { it.category }.distinct()
    }
    val filtered = remember(query, selectedCategory) {
        val q = query.trim().lowercase()
        ReferenceLibraryData.glossary.filter { term ->
            val catMatch = selectedCategory == "All" || term.category == selectedCategory
            val qMatch = q.isEmpty() || term.term.lowercase().contains(q) || term.definition.lowercase().contains(q)
            catMatch && qMatch
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Art & Drawing Glossary (${filtered.size})") },
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
                        label = { Text("Search art term (e.g. Terminator, Loomis, Chiaroscuro)") },
                        modifier = Modifier.fillMaxWidth().testTag("glossary_search_input"),
                        singleLine = true
                    )
                }

                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(categories) { cat ->
                            FilterChip(
                                selected = selectedCategory == cat,
                                onClick = { selectedCategory = cat },
                                label = { Text(cat) }
                            )
                        }
                    }
                }

                items(filtered, key = { it.id }) { term ->
                    AtelierCard {
                        Text(term.category.uppercase(), style = MaterialTheme.typography.labelSmall, color = BlueprintCobalt, fontWeight = FontWeight.Bold)
                        Text(term.term, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(4.dp))
                        Text(term.definition, style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(6.dp))
                        Text("Tip: ${term.practicalTip}", style = MaterialTheme.typography.bodySmall, color = AtelierSage, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SketchbookJournalScreen(
    state: AcademyUiState,
    onBack: () -> Unit,
    onAddEntry: (title: String, minutes: Int, difficulty: String, reflection: String, needsImprovement: String) -> Unit,
    onDeleteEntry: (Long) -> Unit
) {
    var showAddDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sketchbook Journal") },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.size(48.dp)) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                modifier = Modifier.testTag("add_journal_fab")
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add journal entry")
            }
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.TopCenter) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().widthIn(max = 640.dp),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (state.journalEntries.isEmpty()) {
                    item {
                        AtelierCard {
                            Text("Your Sketchbook Log is Empty", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "Record what you drew in your physical notebook, how long it took, what felt challenging, and what to refine next time.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                } else {
                    items(state.journalEntries, key = { it.id }) { entry ->
                        AtelierCard {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "${DateTimeUtils.formatFullDateTime(entry.timestampMillis)} • ${entry.durationMinutes} min • ${entry.difficulty}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = BlueprintCobalt
                                    )
                                    Text(entry.title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                                }
                                IconButton(
                                    onClick = { onDeleteEntry(entry.id) },
                                    modifier = Modifier.size(48.dp)
                                ) {
                                    Icon(Icons.Filled.Delete, contentDescription = "Delete entry")
                                }
                            }
                            Spacer(Modifier.height(6.dp))
                            Text(entry.reflection, style = MaterialTheme.typography.bodyMedium)
                            if (entry.needsImprovement.isNotBlank()) {
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "Next focus: ${entry.needsImprovement}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = TerracottaFlame,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    if (showAddDialog) {
        var title by remember { mutableStateOf("") }
        var minutesText by remember { mutableStateOf("20") }
        var difficulty by remember { mutableStateOf("Okay") }
        var reflection by remember { mutableStateOf("") }
        var needsImprovement by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = { showAddDialog = false },
            title = { Text("New Sketchbook Reflection") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Subject / Lesson Title") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().testTag("journal_title_input")
                    )
                    OutlinedTextField(
                        value = minutesText,
                        onValueChange = { minutesText = it.filter { ch -> ch.isDigit() } },
                        label = { Text("Minutes Drawn") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        listOf("Difficult", "Okay", "Easy").forEach { d ->
                            FilterChip(
                                selected = difficulty == d,
                                onClick = { difficulty = d },
                                label = { Text(d) }
                            )
                        }
                    }
                    OutlinedTextField(
                        value = reflection,
                        onValueChange = { reflection = it },
                        label = { Text("What went well or felt challenging?") },
                        minLines = 2,
                        modifier = Modifier.fillMaxWidth().testTag("journal_reflection_input")
                    )
                    OutlinedTextField(
                        value = needsImprovement,
                        onValueChange = { needsImprovement = it },
                        label = { Text("What needs improvement next?") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (title.isNotBlank() && reflection.isNotBlank()) {
                            onAddEntry(
                                title.trim(),
                                minutesText.toIntOrNull() ?: 15,
                                difficulty,
                                reflection.trim(),
                                needsImprovement.trim()
                            )
                            showAddDialog = false
                        }
                    },
                    modifier = Modifier.testTag("save_journal_entry_button")
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = { showAddDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurriculumMapScreen(
    state: AcademyUiState,
    onBack: () -> Unit,
    onOpenWorldMilestone: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("12-World Curriculum Map") },
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
                        text = "A 12-month foundational sequence from pure observation to independent imaginative illustration (${state.totalCurriculumExercises} total exercises).",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                items(state.worldSummaries, key = { it.world.id }) { summary ->
                    val ratio = if (summary.totalLessons == 0) 0f else {
                        summary.completedLessons.toFloat() / summary.totalLessons.toFloat()
                    }
                    AtelierCard(
                        modifier = Modifier.clickable(enabled = summary.isUnlocked) {
                            onOpenWorldMilestone(summary.world.number)
                        }
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "World ${summary.world.number}: ${summary.world.title}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = if (summary.isUnlocked) "Unlocked" else "${summary.gateProgressPercent}% gate",
                                style = MaterialTheme.typography.labelMedium,
                                color = if (summary.isUnlocked) AtelierSage else TerracottaFlame,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(summary.world.tagline, style = MaterialTheme.typography.bodySmall, color = BlueprintCobalt)
                        Spacer(Modifier.height(4.dp))
                        Text(summary.world.focusSummary, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Spacer(Modifier.height(8.dp))
                        LinearProgressIndicator(
                            progress = { ratio.coerceIn(0f, 1f) },
                            modifier = Modifier.fillMaxWidth().height(7.dp),
                            color = AtelierSage,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "Units: ${summary.world.units.joinToString(" • ") { it.title }}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
