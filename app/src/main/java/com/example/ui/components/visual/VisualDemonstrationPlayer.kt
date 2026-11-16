package com.example.ui.components.visual

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.NavigateBefore
import androidx.compose.material.icons.automirrored.filled.NavigateNext
import androidx.compose.material.icons.filled.Compare
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import com.example.domain.model.VisualDemoSpec
import com.example.domain.model.VisualScaffoldLevel
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.OchreGold
import com.example.ui.theme.TerracottaFlame
import kotlinx.coroutines.delay

private enum class DemoViewTab(val label: String) {
    STEP_BY_STEP("Step-by-Step"),
    MISTAKE_VS_FIX("Mistake vs. Fix"),
    FINISHED_TARGET("Finished Target")
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun VisualDemonstrationPlayer(
    demo: VisualDemoSpec,
    scaffoldLevel: VisualScaffoldLevel = VisualScaffoldLevel.FULL_GUIDANCE,
    compact: Boolean = false,
    modifier: Modifier = Modifier,
    headerOverride: String? = null,
    onPracticeLessonClick: (() -> Unit)? = null,
    practiceButtonLabel: String = "Open Related Lesson"
) {
    val stageCount = demo.stages.size.coerceAtLeast(1)
    val lastStageIdx = stageCount - 1

    var activeTab by remember(demo.id, scaffoldLevel) {
        mutableStateOf(
            when (scaffoldLevel) {
                VisualScaffoldLevel.REFERENCE_ONLY -> DemoViewTab.FINISHED_TARGET
                else -> DemoViewTab.STEP_BY_STEP
            }
        )
    }
    var activeStageIndex by remember(demo.id, scaffoldLevel) {
        mutableIntStateOf(
            if (scaffoldLevel == VisualScaffoldLevel.REFERENCE_ONLY) lastStageIdx else 0
        )
    }
    var isPlaying by remember(demo.id, scaffoldLevel) {
        mutableStateOf(scaffoldLevel == VisualScaffoldLevel.FULL_GUIDANCE && !compact)
    }
    var playbackSpeed by remember(demo.id) { mutableFloatStateOf(1f) }
    var showGuidesOverlay by remember(demo.id, scaffoldLevel) {
        mutableStateOf(scaffoldLevel == VisualScaffoldLevel.FULL_GUIDANCE)
    }
    var showMemoryReveal by remember(demo.id, scaffoldLevel) { mutableStateOf(false) }
    var replayNonce by remember(demo.id) { mutableIntStateOf(0) }

    val stageAnim = remember(demo.id) { Animatable(if (compact) 1f else 0f) }

    LaunchedEffect(demo.id, activeStageIndex, isPlaying, playbackSpeed, replayNonce, activeTab) {
        if (activeTab == DemoViewTab.FINISHED_TARGET) {
            stageAnim.snapTo(1f)
            return@LaunchedEffect
        }
        if (activeTab != DemoViewTab.STEP_BY_STEP) return@LaunchedEffect

        if (isPlaying) {
            if (stageAnim.value >= 0.99f) {
                stageAnim.snapTo(0f)
            }
            val durationMs = ((1750f / playbackSpeed).toInt()).coerceIn(650, 3200)
            stageAnim.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = durationMs, easing = LinearEasing)
            )
            delay((550f / playbackSpeed).toLong().coerceAtLeast(250L))
            if (activeStageIndex < lastStageIdx) {
                activeStageIndex += 1
                stageAnim.snapTo(0f)
            } else {
                isPlaying = false
            }
        } else {
            val durationMs = ((1100f / playbackSpeed).toInt()).coerceIn(450, 1800)
            if (stageAnim.value < 1f) {
                stageAnim.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = durationMs, easing = LinearEasing)
                )
            }
        }
    }

    val effectiveScaffold = when {
        scaffoldLevel == VisualScaffoldLevel.MEMORY_PROMPT && showMemoryReveal -> VisualScaffoldLevel.FULL_GUIDANCE
        scaffoldLevel == VisualScaffoldLevel.PARTIAL_GUIDANCE && showGuidesOverlay -> VisualScaffoldLevel.FULL_GUIDANCE
        activeTab == DemoViewTab.FINISHED_TARGET -> VisualScaffoldLevel.REFERENCE_ONLY
        else -> scaffoldLevel
    }

    val displayedStageIdx = if (activeTab == DemoViewTab.FINISHED_TARGET) lastStageIdx else activeStageIndex
    val activeStage = demo.stages.getOrNull(displayedStageIdx) ?: demo.stages.last()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.75f), RoundedCornerShape(18.dp))
            .padding(14.dp)
            .testTag("visual_demo_player_${demo.id}"),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Header Badge + Title + Visual Progression Concept Chips
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = headerOverride ?: "${demo.category.fullTitle.uppercase()} • ${scaffoldLevel.label.uppercase()}",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = BlueprintCobalt
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = demo.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            if (scaffoldLevel == VisualScaffoldLevel.PARTIAL_GUIDANCE) {
                FilledTonalButton(
                    onClick = { showGuidesOverlay = !showGuidesOverlay },
                    modifier = Modifier
                        .heightIn(min = 48.dp)
                        .testTag("toggle_guides_button")
                ) {
                    Icon(
                        imageVector = if (showGuidesOverlay) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = "Toggle construction guides",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(if (showGuidesOverlay) "Hide Guides" else "Guides", style = MaterialTheme.typography.labelSmall)
                }
            }
        }

        if (demo.revisitedConcepts.isNotEmpty() && !compact) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                demo.revisitedConcepts.forEach { concept ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(AtelierSage.copy(alpha = 0.12f))
                            .padding(horizontal = 9.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "Revisits: $concept",
                            style = MaterialTheme.typography.labelSmall,
                            color = AtelierSage,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        // Memory-first Curtain when scaffold == MEMORY_PROMPT and not yet revealed
        if (scaffoldLevel == VisualScaffoldLevel.MEMORY_PROMPT && !showMemoryReveal) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(OchreGold.copy(alpha = 0.11f))
                    .border(1.dp, OchreGold.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
                    .padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(Icons.Filled.Psychology, contentDescription = null, tint = OchreGold)
                    Text(
                        text = "Sketch From Memory First (${demo.stages.size} stages)",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "Construct '${demo.title}' in your physical notebook from mental model alone before peeking: ${demo.summary}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                FilledTonalButton(
                    onClick = {
                        showMemoryReveal = true
                        isPlaying = false
                        activeStageIndex = 0
                        replayNonce += 1
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 48.dp)
                        .testTag("reveal_memory_visual_button")
                ) {
                    Icon(Icons.Filled.Visibility, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Reveal Visual Construction & Target Check")
                }
            }
        } else {
            // Mode Switcher Tabs (Step-by-Step vs Mistake vs Fix vs Target)
            if (!compact) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    DemoViewTab.entries.forEach { tab ->
                        val selected = activeTab == tab
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 48.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    if (selected) BlueprintCobalt
                                    else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.65f)
                                )
                                .clickable {
                                    activeTab = tab
                                    if (tab == DemoViewTab.STEP_BY_STEP) {
                                        isPlaying = false
                                    }
                                }
                                .padding(horizontal = 6.dp, vertical = 8.dp)
                                .testTag("visual_tab_${tab.name.lowercase()}"),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                if (tab == DemoViewTab.MISTAKE_VS_FIX) {
                                    Icon(
                                        imageVector = Icons.Filled.Compare,
                                        contentDescription = null,
                                        tint = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                                Text(
                                    text = tab.label,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                                    color = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            }

            if (activeTab == DemoViewTab.MISTAKE_VS_FIX) {
                MistakeComparisonCard(comparison = demo.comparison)
            } else {
                // Main Archival Bristol Sketchbook Viewport
                val canvasHeight = if (compact) 216.dp else 268.dp
                VisualStageCanvas(
                    elements = demo.elements,
                    activeStageIndex = displayedStageIdx,
                    activeStageProgress = if (activeTab == DemoViewTab.FINISHED_TARGET) 1f else stageAnim.value,
                    scaffoldLevel = effectiveScaffold,
                    isCleanupStage = activeStage.isCleanupStage,
                    showGuidesOverlay = showGuidesOverlay,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(canvasHeight)
                        .testTag("visual_demo_canvas")
                )

                // Stage Progress + Playback Controls
                if (activeTab == DemoViewTab.STEP_BY_STEP) {
                    val stageRatio = ((displayedStageIdx + 1).toFloat() / stageCount.toFloat()).coerceIn(0f, 1f)
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Stage ${displayedStageIdx + 1} of $stageCount",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = BlueprintCobalt
                            )
                            Text(
                                text = "Replicate stage ${displayedStageIdx + 1} lightly on paper",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        LinearProgressIndicator(
                            progress = { stageRatio },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = BlueprintCobalt,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant
                        )

                        // Numbered Stage Pills
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            itemsIndexed(demo.stages) { idx, stage ->
                                val selected = idx == displayedStageIdx
                                val done = idx < displayedStageIdx
                                Box(
                                    modifier = Modifier
                                        .heightIn(min = 48.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(
                                            when {
                                                selected -> BlueprintCobalt
                                                done -> AtelierSage.copy(alpha = 0.16f)
                                                else -> MaterialTheme.colorScheme.surfaceVariant
                                            }
                                        )
                                        .clickable {
                                            isPlaying = false
                                            activeStageIndex = idx
                                            replayNonce += 1
                                        }
                                        .padding(horizontal = 12.dp, vertical = 10.dp)
                                        .testTag("visual_stage_pill_$idx"),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${stage.stageNumber}. ${stage.title}",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                                        color = when {
                                            selected -> MaterialTheme.colorScheme.onPrimary
                                            done -> AtelierSage
                                            else -> MaterialTheme.colorScheme.onSurfaceVariant
                                        }
                                    )
                                }
                            }
                        }

                        // Playback Controls Row (Play/Pause, Replay, Prev, Next, Speed, Guide Toggle)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(
                                    onClick = {
                                        isPlaying = false
                                        if (activeStageIndex > 0) {
                                            activeStageIndex -= 1
                                            replayNonce += 1
                                        }
                                    },
                                    enabled = activeStageIndex > 0,
                                    modifier = Modifier
                                        .size(48.dp)
                                        .testTag("visual_prev_button")
                                ) {
                                    Icon(Icons.AutoMirrored.Filled.NavigateBefore, contentDescription = "Previous stage")
                                }

                                Box(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .clip(CircleShape)
                                        .background(if (isPlaying) TerracottaFlame else BlueprintCobalt)
                                        .clickable {
                                            if (!isPlaying && activeStageIndex == lastStageIdx && stageAnim.value >= 0.99f) {
                                                activeStageIndex = 0
                                            }
                                            isPlaying = !isPlaying
                                        }
                                        .testTag("visual_play_pause_button"),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = if (isPlaying) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                                        contentDescription = if (isPlaying) "Pause demonstration" else "Play demonstration",
                                        tint = MaterialTheme.colorScheme.onPrimary
                                    )
                                }

                                IconButton(
                                    onClick = {
                                        isPlaying = false
                                        if (activeStageIndex < lastStageIdx) {
                                            activeStageIndex += 1
                                            replayNonce += 1
                                        }
                                    },
                                    enabled = activeStageIndex < lastStageIdx,
                                    modifier = Modifier
                                        .size(48.dp)
                                        .testTag("visual_next_button")
                                ) {
                                    Icon(Icons.AutoMirrored.Filled.NavigateNext, contentDescription = "Next stage")
                                }

                                IconButton(
                                    onClick = {
                                        activeStageIndex = 0
                                        isPlaying = true
                                        replayNonce += 1
                                    },
                                    modifier = Modifier
                                        .size(48.dp)
                                        .testTag("visual_replay_button")
                                ) {
                                    Icon(Icons.Filled.Replay, contentDescription = "Replay from stage 1")
                                }
                            }

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                OutlinedButton(
                                    onClick = {
                                        playbackSpeed = when (playbackSpeed) {
                                            0.75f -> 1f
                                            1f -> 1.5f
                                            else -> 0.75f
                                        }
                                    },
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(),
                                    modifier = Modifier
                                        .heightIn(min = 48.dp)
                                        .testTag("visual_speed_button")
                                ) {
                                    Icon(Icons.Filled.Speed, contentDescription = null, modifier = Modifier.size(15.dp))
                                    Spacer(Modifier.width(4.dp))
                                    Text(
                                        text = if (playbackSpeed == 0.75f) "0.75×" else if (playbackSpeed == 1f) "1×" else "1.5×",
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                }
                                IconButton(
                                    onClick = { showGuidesOverlay = !showGuidesOverlay },
                                    modifier = Modifier
                                        .size(48.dp)
                                        .testTag("visual_guides_eye_button")
                                ) {
                                    Icon(
                                        imageVector = if (showGuidesOverlay) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                        contentDescription = "Toggle blue guide lines",
                                        tint = if (showGuidesOverlay) BlueprintCobalt else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }

                // Active Stage Explanation & Visual Focus Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f))
                        .padding(12.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "Stage ${activeStage.stageNumber}: ${activeStage.title}",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = BlueprintCobalt
                        )
                        Text(
                            text = activeStage.explanation,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Watch for: ${activeStage.visualFocus}",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = AtelierSage
                        )
                    }
                }

                AnimatedVisibility(visible = scaffoldLevel == VisualScaffoldLevel.MEMORY_PROMPT && showMemoryReveal) {
                    OutlinedButton(
                        onClick = { showMemoryReveal = false },
                        modifier = Modifier.fillMaxWidth().heightIn(min = 48.dp)
                    ) {
                        Text("Hide Visual Reference Again")
                    }
                }
            }
        }

        if (onPracticeLessonClick != null) {
            FilledTonalButton(
                onClick = onPracticeLessonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 48.dp)
                    .testTag("visual_demo_practice_lesson_button")
            ) {
                Text(practiceButtonLabel, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}
