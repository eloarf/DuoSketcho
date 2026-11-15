package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.PracticeCompletionResult
import com.example.domain.model.DifficultyRating
import com.example.domain.model.MasteryLevel
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.DustyCrimson
import com.example.ui.theme.OchreGold
import com.example.ui.theme.TerracottaFlame

@Composable
fun AtelierCard(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    borderColor: Color = MaterialTheme.colorScheme.outline,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(containerColor)
            .border(1.dp, borderColor, RoundedCornerShape(18.dp))
            .padding(16.dp),
        content = content
    )
}

@Composable
fun TactilePrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    containerColor: Color = BlueprintCobalt,
    testTag: String = "primary_action_button"
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 14.dp),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 50.dp)
            .testTag(testTag)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StreakBadge(
    streakDays: Int,
    practicedToday: Boolean,
    modifier: Modifier = Modifier
) {
    val bg = if (practicedToday) {
        MaterialTheme.colorScheme.tertiaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }
    val fg = if (practicedToday) TerracottaFlame else MaterialTheme.colorScheme.onSurfaceVariant

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(bg)
            .border(1.dp, fg.copy(alpha = 0.35f), RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.LocalFireDepartment,
            contentDescription = "Current streak",
            tint = fg,
            modifier = Modifier.size(18.dp)
        )
        Text(
            text = "$streakDays d",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = fg
        )
    }
}

@Composable
fun XpBadge(
    xp: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(OchreGold.copy(alpha = 0.16f))
            .border(1.dp, OchreGold.copy(alpha = 0.4f), RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "XP earned",
            tint = OchreGold,
            modifier = Modifier.size(17.dp)
        )
        Text(
            text = "$xp XP",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = OchreGold
        )
    }
}

@Composable
fun MasteryPill(
    tier: MasteryLevel,
    modifier: Modifier = Modifier
) {
    val color = when (tier) {
        MasteryLevel.NOT_STARTED -> MaterialTheme.colorScheme.onSurfaceVariant
        MasteryLevel.INTRODUCED -> Color(0xFF607080)
        MasteryLevel.PRACTICING -> TerracottaFlame
        MasteryLevel.DEVELOPING -> OchreGold
        MasteryLevel.PROFICIENT -> BlueprintCobalt
        MasteryLevel.MASTERED -> AtelierSage
    }
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .background(color.copy(alpha = 0.14f))
            .border(1.dp, color.copy(alpha = 0.4f), RoundedCornerShape(50))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = tier.displayName,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}

@Composable
fun DailyGoalRing(
    todayMinutes: Int,
    goalMinutes: Int,
    modifier: Modifier = Modifier
) {
    val progress = (todayMinutes.toFloat() / goalMinutes.coerceAtLeast(1).toFloat()).coerceIn(0f, 1f)
    val ringColor = if (todayMinutes >= goalMinutes) AtelierSage else BlueprintCobalt

    Box(
        modifier = modifier.size(72.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            progress = { 1f },
            modifier = Modifier.size(72.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            strokeWidth = 7.dp
        )
        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier.size(72.dp),
            color = ringColor,
            strokeWidth = 7.dp,
            strokeCap = StrokeCap.Round
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "${todayMinutes}m",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "/${goalMinutes}m",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun SketchbookTimerBar(
    seconds: Int,
    running: Boolean,
    onToggle: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    val mins = seconds / 60
    val secs = seconds % 60
    val formatted = String.format("%02d:%02d", mins, secs)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.65f))
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "SKETCHBOOK TIMER",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = formatted,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
            OutlinedButton(
                onClick = onToggle,
                modifier = Modifier
                    .heightIn(min = 48.dp)
                    .testTag("timer_toggle_button")
            ) {
                Icon(
                    imageVector = if (running) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                    contentDescription = if (running) "Pause timer" else "Start timer"
                )
                Spacer(Modifier.width(4.dp))
                Text(if (running) "Pause" else "Start")
            }
            IconButton(
                onClick = onReset,
                modifier = Modifier
                    .size(48.dp)
                    .testTag("timer_reset_button")
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "Reset timer"
                )
            }
        }
    }
}

@Composable
fun SelfAssessmentSection(
    checklist: List<String>,
    checkedStates: List<Boolean>,
    onToggleCheck: (Int) -> Unit,
    selectedRating: DifficultyRating,
    onSelectRating: (DifficultyRating) -> Unit,
    modifier: Modifier = Modifier
) {
    AtelierCard(modifier = modifier) {
        Text(
            text = "Self-Assessment Checklist",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = "Inspect your physical sketchbook drawing honestly against each criterion:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(10.dp))

        checklist.forEachIndexed { idx, item ->
            val checked = checkedStates.getOrElse(idx) { false }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { onToggleCheck(idx) }
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { onToggleCheck(idx) },
                    modifier = Modifier.testTag("checklist_item_$idx")
                )
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }

        Spacer(Modifier.height(12.dp))
        Text(
            text = "How did this feel in your sketchbook?",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DifficultyRating.entries.forEach { rating ->
                val selected = selectedRating == rating
                val chipColor = when (rating) {
                    DifficultyRating.DIFFICULT -> DustyCrimson
                    DifficultyRating.OKAY -> BlueprintCobalt
                    DifficultyRating.EASY -> AtelierSage
                }
                FilterChip(
                    selected = selected,
                    onClick = { onSelectRating(rating) },
                    label = { Text(rating.label) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = chipColor.copy(alpha = 0.18f),
                        selectedLabelColor = chipColor
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = 48.dp)
                        .testTag("rating_chip_${rating.name.lowercase()}")
                )
            }
        }
    }
}

@Composable
fun CompletionCelebrationDialog(
    result: PracticeCompletionResult,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(AtelierSage.copy(alpha = 0.16f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "Practice completed",
                    tint = AtelierSage,
                    modifier = Modifier.size(32.dp)
                )
            }
        },
        title = {
            Text(
                text = "Sketchbook Practice Logged!",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "+${result.xpEarned} XP  •  ${result.minutesAdded} min added to today's log",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = BlueprintCobalt
                )
                if (result.goalJustMet) {
                    Text(
                        text = "Daily drawing goal reached! Your consecutive streak is locked in for today.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = AtelierSage,
                        fontWeight = FontWeight.Medium
                    )
                }
                if (result.earnedFreeze) {
                    Text(
                        text = "Bonus: Earned +1 Streak Freeze for your 7-day consistency!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = OchreGold,
                        fontWeight = FontWeight.Medium
                    )
                }
                if (result.newAchievements.isNotEmpty()) {
                    Spacer(Modifier.height(4.dp))
                    result.newAchievements.forEach { ach ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.EmojiEvents,
                                contentDescription = null,
                                tint = OchreGold,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Unlocked: ${ach.title} (+${ach.xpBonus} XP)",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                modifier = Modifier.testTag("dismiss_celebration_button")
            ) {
                Text("Keep Sketching")
            }
        }
    )
}
