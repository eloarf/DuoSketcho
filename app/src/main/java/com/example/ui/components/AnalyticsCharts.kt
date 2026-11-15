package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.local.DailyActivityEntity
import com.example.domain.engine.DateTimeUtils
import com.example.domain.engine.StreakAndXpEngine
import com.example.domain.model.MasteryLevel
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.OchreGold
import com.example.ui.theme.TerracottaFlame

@Composable
fun PracticeHeatmapCard(
    dailyActivityMap: Map<Long, DailyActivityEntity>,
    todayEpochDay: Long,
    modifier: Modifier = Modifier
) {
    val weeks = 10
    val totalDays = weeks * 7
    val startDay = todayEpochDay - (totalDays - 1)
    val emptyColor = MaterialTheme.colorScheme.surfaceVariant
    val freezeColor = BlueprintCobalt.copy(alpha = 0.45f)
    val lightPractice = AtelierSage.copy(alpha = 0.45f)
    val goalMetColor = AtelierSage

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(18.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "10-Week Practice Calendar",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${DateTimeUtils.formatShortDate(startDay)} – Today",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(124.dp)
        ) {
            val gap = 6.dp.toPx()
            val cols = weeks
            val rows = 7
            val cellW = (size.width - gap * (cols - 1)) / cols
            val cellH = (size.height - gap * (rows - 1)) / rows
            val cellSize = minOf(cellW, cellH)
            val totalGridW = cols * cellSize + (cols - 1) * gap
            val xOffset = (size.width - totalGridW) / 2f

            for (col in 0 until cols) {
                for (row in 0 until rows) {
                    val dayIndex = col * 7 + row
                    val epochDay = startDay + dayIndex
                    val act = dailyActivityMap[epochDay]
                    val color = when {
                        act == null -> emptyColor
                        act.goalMet -> goalMetColor
                        StreakAndXpEngine.isMeaningfulPracticeDay(act) -> lightPractice
                        act.freezeUsed -> freezeColor
                        else -> emptyColor
                    }
                    val left = xOffset + col * (cellSize + gap)
                    val top = row * (cellSize + gap)
                    drawRoundRect(
                        color = color,
                        topLeft = Offset(left, top),
                        size = Size(cellSize, cellSize),
                        cornerRadius = CornerRadius(4.dp.toPx(), 4.dp.toPx())
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LegendDot(color = emptyColor, label = "Rest")
            LegendDot(color = freezeColor, label = "Freeze")
            LegendDot(color = lightPractice, label = "Practiced")
            LegendDot(color = goalMetColor, label = "Goal Met")
        }
    }
}

@Composable
private fun LegendDot(color: Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(color)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun WeeklyMinutesBarChart(
    dailyActivityMap: Map<Long, DailyActivityEntity>,
    todayEpochDay: Long,
    dailyGoalMinutes: Int,
    modifier: Modifier = Modifier
) {
    val days = (0..6).map { offset ->
        val day = todayEpochDay - (6 - offset)
        day to (dailyActivityMap[day]?.minutesPracticed ?: 0)
    }
    val maxVal = maxOf(dailyGoalMinutes + 10, days.maxOfOrNull { it.second } ?: 20)
    val barBg = MaterialTheme.colorScheme.surfaceVariant
    val ruleColor = TerracottaFlame

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(18.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "7-Day Drawing Minutes",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Goal: ${dailyGoalMinutes}m/day",
                style = MaterialTheme.typography.labelSmall,
                color = TerracottaFlame
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            val count = days.size
            val slotW = size.width / count
            val barW = slotW * 0.52f
            val goalY = size.height * (1f - (dailyGoalMinutes.toFloat() / maxVal.toFloat()))

            days.forEachIndexed { idx, (_, mins) ->
                val left = idx * slotW + (slotW - barW) / 2f
                drawRoundRect(
                    color = barBg,
                    topLeft = Offset(left, 0f),
                    size = Size(barW, size.height),
                    cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
                )
                if (mins > 0) {
                    val ratio = (mins.toFloat() / maxVal.toFloat()).coerceIn(0.05f, 1f)
                    val barH = size.height * ratio
                    val color = if (mins >= dailyGoalMinutes) AtelierSage else BlueprintCobalt
                    drawRoundRect(
                        color = color,
                        topLeft = Offset(left, size.height - barH),
                        size = Size(barW, barH),
                        cornerRadius = CornerRadius(6.dp.toPx(), 6.dp.toPx())
                    )
                }
            }

            drawLine(
                color = ruleColor,
                start = Offset(0f, goalY),
                end = Offset(size.width, goalY),
                strokeWidth = 2.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 8f))
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            days.forEach { (day, mins) ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${mins}m",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = DateTimeUtils.dayOfMonthLabel(day),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun MasteryDistributionCard(
    distribution: Map<MasteryLevel, Int>,
    totalSkills: Int,
    modifier: Modifier = Modifier
) {
    val colors = mapOf(
        MasteryLevel.MASTERED to AtelierSage,
        MasteryLevel.PROFICIENT to BlueprintCobalt,
        MasteryLevel.DEVELOPING to OchreGold,
        MasteryLevel.PRACTICING to TerracottaFlame,
        MasteryLevel.INTRODUCED to Color(0xFF7B8898),
        MasteryLevel.NOT_STARTED to MaterialTheme.colorScheme.surfaceVariant
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(18.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Skill Mastery Breakdown ($totalSkills Core Skills)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Completing a lesson introduces a skill. Mastery requires repeated spaced reviews.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        val orderedTiers = listOf(
            MasteryLevel.MASTERED,
            MasteryLevel.PROFICIENT,
            MasteryLevel.DEVELOPING,
            MasteryLevel.PRACTICING,
            MasteryLevel.INTRODUCED,
            MasteryLevel.NOT_STARTED
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            val denom = totalSkills.coerceAtLeast(1).toFloat()
            var cursorX = 0f
            orderedTiers.forEach { tier ->
                val count = distribution[tier] ?: 0
                if (count > 0) {
                    val segW = (count / denom) * size.width
                    drawRect(
                        color = colors[tier] ?: Color.Gray,
                        topLeft = Offset(cursorX, 0f),
                        size = Size(segW, size.height)
                    )
                    cursorX += segW
                }
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            orderedTiers.chunked(2).forEach { pair ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    pair.forEach { tier ->
                        val count = distribution[tier] ?: 0
                        Row(
                            modifier = Modifier.weight(1f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .clip(RoundedCornerShape(3.dp))
                                    .background(colors[tier] ?: Color.Gray)
                            )
                            Text(
                                text = "${tier.displayName}: $count",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}
