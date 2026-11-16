package com.example.ui.components.visual

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.model.MistakeComparisonSpec
import com.example.domain.model.VisualScaffoldLevel
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.DustyCrimson

@Composable
fun MistakeComparisonCard(
    comparison: MistakeComparisonSpec,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.7f), RoundedCornerShape(18.dp))
            .padding(14.dp)
            .testTag("mistake_comparison_card"),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "SIDE-BY-SIDE VISUAL DIAGNOSIS",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            color = BlueprintCobalt
        )
        Text(
            text = comparison.title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Incorrect Panel
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(14.dp))
                    .background(DustyCrimson.copy(alpha = 0.08f))
                    .border(1.dp, DustyCrimson.copy(alpha = 0.45f), RoundedCornerShape(14.dp))
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Incorrect example",
                        tint = DustyCrimson,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = comparison.wrongLabel,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = DustyCrimson,
                        maxLines = 2
                    )
                }
                VisualStageCanvas(
                    elements = comparison.wrongElements,
                    activeStageIndex = 10,
                    activeStageProgress = 1f,
                    scaffoldLevel = VisualScaffoldLevel.FULL_GUIDANCE,
                    showGrid = false,
                    borderColor = DustyCrimson.copy(alpha = 0.4f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(148.dp)
                        .testTag("comparison_wrong_canvas")
                )
            }

            // Correct Panel
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(14.dp))
                    .background(AtelierSage.copy(alpha = 0.08f))
                    .border(1.dp, AtelierSage.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Correct example",
                        tint = AtelierSage,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = comparison.rightLabel,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = AtelierSage,
                        maxLines = 2
                    )
                }
                VisualStageCanvas(
                    elements = comparison.rightElements,
                    activeStageIndex = 10,
                    activeStageProgress = 1f,
                    scaffoldLevel = VisualScaffoldLevel.FULL_GUIDANCE,
                    showGrid = false,
                    borderColor = AtelierSage.copy(alpha = 0.45f),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(148.dp)
                        .testTag("comparison_right_canvas")
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(DustyCrimson.copy(alpha = 0.07f))
                .padding(10.dp)
        ) {
            Column {
                Text(
                    text = "Why it happens",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = DustyCrimson
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = comparison.whyMistakeHappens,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(AtelierSage.copy(alpha = 0.10f))
                .padding(10.dp)
        ) {
            Column {
                Text(
                    text = "How to fix in your notebook",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = AtelierSage
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = comparison.howToFix,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
