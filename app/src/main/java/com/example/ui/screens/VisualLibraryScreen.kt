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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.visual.VisualCatalog
import com.example.domain.model.VisualCategory
import com.example.domain.model.VisualDemoSpec
import com.example.domain.model.VisualScaffoldLevel
import com.example.ui.components.AtelierCard
import com.example.ui.components.visual.VisualDemonstrationPlayer
import com.example.ui.components.visual.VisualStageCanvas
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualLibraryScreen(
    onBack: () -> Unit,
    onOpenLesson: (String) -> Unit
) {
    var selectedCategory by remember { mutableStateOf<VisualCategory?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedDemo by remember { mutableStateOf<VisualDemoSpec?>(null) }
    var activeScaffold by remember { mutableStateOf(VisualScaffoldLevel.FULL_GUIDANCE) }

    val filteredDemos = remember(selectedCategory, searchQuery) {
        val q = searchQuery.trim().lowercase()
        VisualCatalog.allDemos.filter { demo ->
            val catMatch = selectedCategory == null || demo.category == selectedCategory
            val qMatch = q.isEmpty() ||
                demo.title.lowercase().contains(q) ||
                demo.summary.lowercase().contains(q) ||
                demo.category.fullTitle.lowercase().contains(q) ||
                demo.revisitedConcepts.any { it.lowercase().contains(q) }
            catMatch && qMatch
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Visual Study Library", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Text(
                            text = "${VisualCatalog.allDemos.size} Step-by-Step Illustrated Demos (Offline)",
                            style = MaterialTheme.typography.labelSmall,
                            color = BlueprintCobalt
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .size(48.dp)
                            .testTag("visual_library_back_button")
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
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                        label = { Text("Search demos (e.g. cube, sphere, loomis, mug, perspective)") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("visual_library_search_input")
                    )
                }

                item {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        item {
                            FilterChip(
                                selected = selectedCategory == null,
                                onClick = { selectedCategory = null },
                                label = { Text("All (${VisualCatalog.allDemos.size})") },
                                modifier = Modifier.heightIn(min = 48.dp)
                            )
                        }
                        items(VisualCategory.entries) { cat ->
                            val count = remember(cat) { VisualCatalog.getByCategory(cat).size }
                            FilterChip(
                                selected = selectedCategory == cat,
                                onClick = { selectedCategory = if (selectedCategory == cat) null else cat },
                                label = { Text("${cat.code}. ${cat.shortTitle} ($count)") },
                                modifier = Modifier
                                    .heightIn(min = 48.dp)
                                    .testTag("visual_cat_chip_${cat.code}")
                            )
                        }
                    }
                }

                items(filteredDemos, key = { it.id }) { demo ->
                    AtelierCard(
                        modifier = Modifier
                            .clickable {
                                activeScaffold = VisualScaffoldLevel.FULL_GUIDANCE
                                selectedDemo = demo
                            }
                            .testTag("visual_library_card_${demo.id}")
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            VisualStageCanvas(
                                elements = demo.elements,
                                activeStageIndex = demo.stages.lastIndex,
                                activeStageProgress = 1f,
                                scaffoldLevel = VisualScaffoldLevel.FULL_GUIDANCE,
                                isCleanupStage = true,
                                showGrid = false,
                                modifier = Modifier.size(width = 112.dp, height = 88.dp)
                            )

                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "${demo.category.fullTitle} • ${demo.stages.size} stages",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = BlueprintCobalt,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = demo.title,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = demo.summary,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.PlayCircle,
                                        contentDescription = null,
                                        tint = AtelierSage,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = "Animate & compare mistakes",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = AtelierSage,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    selectedDemo?.let { demo ->
        val matchingLesson = remember(demo.id) { VisualCatalog.getLessonForDemo(demo) }
        ModalBottomSheet(
            onDismissRequest = { selectedDemo = null }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    Text(
                        text = "Guidance Mode",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = BlueprintCobalt
                    )
                    Spacer(Modifier.height(4.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        items(VisualScaffoldLevel.entries) { level ->
                            FilterChip(
                                selected = activeScaffold == level,
                                onClick = { activeScaffold = level },
                                label = { Text(level.label) },
                                modifier = Modifier.heightIn(min = 48.dp)
                            )
                        }
                    }
                }

                item {
                    VisualDemonstrationPlayer(
                        demo = demo,
                        scaffoldLevel = activeScaffold,
                        onPracticeLessonClick = matchingLesson?.let { lesson ->
                            {
                                selectedDemo = null
                                onOpenLesson(lesson.id)
                            }
                        },
                        practiceButtonLabel = matchingLesson?.let { "Practice in Lesson: ${it.title}" }
                            ?: "Practice Related Lesson"
                    )
                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    }
}
