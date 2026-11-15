package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.model.DiagramType
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.OchreGold
import com.example.ui.theme.TerracottaFlame

@Composable
fun LessonDiagramCard(
    diagramType: DiagramType,
    caption: String,
    modifier: Modifier = Modifier
) {
    val ink = MaterialTheme.colorScheme.onSurface
    val muted = MaterialTheme.colorScheme.onSurfaceVariant
    val ruleColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.55f)
    val surfaceBg = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(surfaceBg)
            .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(18.dp))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "STUDY DIAGRAM",
                style = MaterialTheme.typography.labelSmall,
                color = BlueprintCobalt,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Draw in your notebook",
                style = MaterialTheme.typography.labelSmall,
                color = muted
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(172.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surface)
                .border(1.dp, ruleColor, RoundedCornerShape(12.dp))
        ) {
            Canvas(modifier = Modifier.fillMaxSize().padding(14.dp)) {
                drawDiagramGrid(ruleColor)
                when (diagramType) {
                    DiagramType.OBSERVATION_CONTOUR -> drawObservationContour(ink, BlueprintCobalt, TerracottaFlame)
                    DiagramType.NEGATIVE_SPACE -> drawNegativeSpace(ink, BlueprintCobalt, AtelierSage)
                    DiagramType.BASIC_FORMS_3D -> drawBasicForms3D(ink, BlueprintCobalt, TerracottaFlame)
                    DiagramType.CROSS_CONTOUR -> drawCrossContour(ink, BlueprintCobalt)
                    DiagramType.LINE_CONTROL_GHOSTING -> drawLineControlGhosting(ink, BlueprintCobalt, TerracottaFlame)
                    DiagramType.HATCHING_AND_STIPPLING -> drawHatchingAndStippling(ink, BlueprintCobalt)
                    DiagramType.VALUE_SCALE_AND_SPHERE -> drawValueScaleAndSphere(ink, BlueprintCobalt, OchreGold)
                    DiagramType.CAST_SHADOW_LOGIC -> drawCastShadowLogic(ink, BlueprintCobalt, OchreGold)
                    DiagramType.PERSPECTIVE_1_2_3_POINT -> drawPerspective2Point(ink, BlueprintCobalt, TerracottaFlame)
                    DiagramType.STILL_LIFE_SIGHTING -> drawStillLifeSighting(ink, BlueprintCobalt, AtelierSage)
                    DiagramType.TEXTURE_STUDIES -> drawTextureStudies(ink, BlueprintCobalt)
                    DiagramType.BOTANICAL_AND_ANIMAL -> drawBotanicalAndAnimal(ink, AtelierSage, BlueprintCobalt)
                    DiagramType.HUMAN_GESTURE_MANNEQUIN -> drawHumanGestureMannequin(ink, TerracottaFlame, BlueprintCobalt)
                    DiagramType.LOOMIS_HEAD_PROPORTIONS -> drawLoomisHead(ink, BlueprintCobalt, TerracottaFlame)
                    DiagramType.COMPOSITION_THIRDS -> drawCompositionThirds(ink, BlueprintCobalt, OchreGold)
                    DiagramType.IMAGINATION_SYNTHESIS -> drawImaginationSynthesis(ink, BlueprintCobalt, AtelierSage)
                }
            }
        }

        Text(
            text = caption,
            style = MaterialTheme.typography.bodySmall,
            color = muted
        )
    }
}

private fun DrawScope.drawDiagramGrid(ruleColor: Color) {
    val step = 24.dp.toPx()
    var x = step
    while (x < size.width) {
        drawLine(ruleColor.copy(alpha = 0.25f), Offset(x, 0f), Offset(x, size.height), strokeWidth = 1f)
        x += step
    }
    var y = step
    while (y < size.height) {
        drawLine(ruleColor.copy(alpha = 0.25f), Offset(0f, y), Offset(size.width, y), strokeWidth = 1f)
        y += step
    }
}

private fun DrawScope.drawObservationContour(ink: Color, guide: Color, accent: Color) {
    val w = size.width
    val h = size.height
    val dash = PathEffect.dashPathEffect(floatArrayOf(10f, 8f))
    // Plumb vertical line & horizontal check
    drawLine(guide, Offset(w * 0.35f, 4f), Offset(w * 0.35f, h - 4f), strokeWidth = 2f, pathEffect = dash)
    drawLine(guide, Offset(w * 0.1f, h * 0.42f), Offset(w * 0.65f, h * 0.42f), strokeWidth = 2f, pathEffect = dash)

    // Contour vase silhouette
    val vase = Path().apply {
        moveTo(w * 0.28f, h * 0.15f)
        lineTo(w * 0.42f, h * 0.15f)
        cubicTo(w * 0.40f, h * 0.34f, w * 0.52f, h * 0.48f, w * 0.47f, h * 0.86f)
        lineTo(w * 0.23f, h * 0.86f)
        cubicTo(w * 0.18f, h * 0.48f, w * 0.30f, h * 0.34f, w * 0.28f, h * 0.15f)
        close()
    }
    drawPath(vase, ink, style = Stroke(width = 4f))

    // Angle sighting reference on right
    val p1 = Offset(w * 0.68f, h * 0.78f)
    val p2 = Offset(w * 0.90f, h * 0.24f)
    drawLine(accent, p1, p2, strokeWidth = 4f, cap = StrokeCap.Round)
    drawLine(guide.copy(alpha = 0.6f), p1, Offset(w * 0.90f, h * 0.78f), strokeWidth = 2f, pathEffect = dash)
    drawCircle(accent, 6f, p1)
    drawCircle(accent, 6f, p2)
}

private fun DrawScope.drawNegativeSpace(ink: Color, guide: Color, fillAccent: Color) {
    val w = size.width
    val h = size.height
    // Bounding frame
    drawRect(ink.copy(alpha = 0.5f), Offset(w * 0.14f, h * 0.1f), Size(w * 0.72f, h * 0.8f), style = Stroke(2.5f))
    // Chair silhouette + highlighted negative space polygons
    val negPocket1 = Path().apply {
        moveTo(w * 0.14f, h * 0.1f)
        lineTo(w * 0.42f, h * 0.1f)
        lineTo(w * 0.42f, h * 0.52f)
        lineTo(w * 0.24f, h * 0.52f)
        lineTo(w * 0.14f, h * 0.9f)
        close()
    }
    drawPath(negPocket1, fillAccent.copy(alpha = 0.28f))
    val negPocket2 = Path().apply {
        moveTo(w * 0.48f, h * 0.62f)
        lineTo(w * 0.68f, h * 0.62f)
        lineTo(w * 0.68f, h * 0.9f)
        lineTo(w * 0.48f, h * 0.9f)
        close()
    }
    drawPath(negPocket2, guide.copy(alpha = 0.24f))
    // Chair bars
    drawLine(ink, Offset(w * 0.44f, h * 0.15f), Offset(w * 0.44f, h * 0.9f), strokeWidth = 6f, cap = StrokeCap.Round)
    drawLine(ink, Offset(w * 0.44f, h * 0.56f), Offset(w * 0.72f, h * 0.56f), strokeWidth = 6f, cap = StrokeCap.Round)
    drawLine(ink, Offset(w * 0.72f, h * 0.56f), Offset(w * 0.72f, h * 0.9f), strokeWidth = 6f, cap = StrokeCap.Round)
}

private fun DrawScope.drawBasicForms3D(ink: Color, guide: Color, accent: Color) {
    val w = size.width
    val h = size.height
    // Left: 3D Cube constructed from Y
    val cy = Offset(w * 0.24f, h * 0.52f)
    val top = Offset(w * 0.24f, h * 0.24f)
    val left = Offset(w * 0.08f, h * 0.40f)
    val right = Offset(w * 0.39f, h * 0.42f)
    val bot = Offset(w * 0.24f, h * 0.84f)
    val botL = Offset(w * 0.09f, h * 0.70f)
    val botR = Offset(w * 0.38f, h * 0.72f)
    val backTop = Offset(w * 0.23f, h * 0.14f)

    drawLine(accent, cy, top, 3.5f)
    drawLine(accent, cy, left, 3.5f)
    drawLine(accent, cy, right, 3.5f)
    drawLine(ink, left, botL, 3.5f)
    drawLine(ink, botL, bot, 3.5f)
    drawLine(ink, bot, botR, 3.5f)
    drawLine(ink, botR, right, 3.5f)
    drawLine(ink, cy, bot, 3.5f)
    drawLine(ink, left, backTop, 3f)
    drawLine(ink, backTop, right, 3f)

    // Middle: Cylinder with minor axis
    val cylCenterX = w * 0.58f
    drawLine(guide, Offset(cylCenterX, h * 0.1f), Offset(cylCenterX, h * 0.9f), 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 6f)))
    drawOval(ink, Offset(cylCenterX - 38f, h * 0.16f), Size(76f, 26f), style = Stroke(3.5f))
    drawOval(ink, Offset(cylCenterX - 38f, h * 0.72f), Size(76f, 28f), style = Stroke(3.5f))
    drawLine(ink, Offset(cylCenterX - 38f, h * 0.16f + 13f), Offset(cylCenterX - 38f, h * 0.72f + 14f), 3.5f)
    drawLine(ink, Offset(cylCenterX + 38f, h * 0.16f + 13f), Offset(cylCenterX + 38f, h * 0.72f + 14f), 3.5f)

    // Right: Sphere with equator ellipse
    val spCenter = Offset(w * 0.84f, h * 0.52f)
    val r = h * 0.28f
    drawCircle(ink, r, spCenter, style = Stroke(3.5f))
    drawOval(guide, Offset(spCenter.x - r, spCenter.y - r * 0.34f), Size(r * 2, r * 0.68f), style = Stroke(2.5f))
}

private fun DrawScope.drawCrossContour(ink: Color, guide: Color) {
    val w = size.width
    val h = size.height
    val bean = Path().apply {
        moveTo(w * 0.18f, h * 0.62f)
        cubicTo(w * 0.15f, h * 0.24f, w * 0.44f, h * 0.16f, w * 0.62f, h * 0.36f)
        cubicTo(w * 0.80f, h * 0.56f, w * 0.88f, h * 0.26f, w * 0.86f, h * 0.64f)
        cubicTo(w * 0.84f, h * 0.86f, w * 0.56f, h * 0.84f, w * 0.42f, h * 0.72f)
        cubicTo(w * 0.30f, h * 0.62f, w * 0.20f, h * 0.80f, w * 0.18f, h * 0.62f)
        close()
    }
    drawPath(bean, ink, style = Stroke(4f))

    // Wrapping contour arcs hooking at silhouette edges
    for (i in 1..6) {
        val xFrac = 0.22f + i * 0.09f
        val topY = h * (0.28f + (i % 2) * 0.06f)
        val botY = h * (0.72f - (i % 2) * 0.04f)
        val arc = Path().apply {
            moveTo(w * xFrac, topY)
            quadraticTo(w * (xFrac + 0.07f), (topY + botY) * 0.5f, w * xFrac, botY)
        }
        drawPath(arc, guide, style = Stroke(2.8f, cap = StrokeCap.Round))
    }
}

private fun DrawScope.drawLineControlGhosting(ink: Color, guide: Color, accent: Color) {
    val w = size.width
    val h = size.height
    val dash = PathEffect.dashPathEffect(floatArrayOf(10f, 8f))
    val rows = listOf(0.22f, 0.44f, 0.66f, 0.84f)
    rows.forEachIndexed { idx, yFrac ->
        val y = h * yFrac
        val pStart = Offset(w * 0.10f, y)
        val pEnd = Offset(w * 0.88f, y)
        drawCircle(accent, 6f, pStart)
        drawCircle(accent, 6f, pEnd)
        if (idx == 0) {
            drawLine(guide, pStart, pEnd, strokeWidth = 2f, pathEffect = dash)
        } else {
            val weight = 2f + idx * 1.8f
            drawLine(ink, pStart, pEnd, strokeWidth = weight, cap = StrokeCap.Round)
        }
    }
}

private fun DrawScope.drawHatchingAndStippling(ink: Color, guide: Color) {
    val w = size.width
    val h = size.height
    val boxW = w * 0.20f
    val boxH = h * 0.64f
    val top = h * 0.18f
    val starts = listOf(0.05f, 0.28f, 0.51f, 0.74f)
    starts.forEachIndexed { idx, xFrac ->
        val left = w * xFrac
        drawRect(ink.copy(alpha = 0.6f), Offset(left, top), Size(boxW, boxH), style = Stroke(2f))
        when (idx) {
            0 -> {
                for (i in 1..6) {
                    val x = left + i * (boxW / 7f)
                    drawLine(ink, Offset(x, top + 6f), Offset(x - 10f, top + boxH - 6f), 2f)
                }
            }
            1 -> {
                for (i in 1..7) {
                    val x = left + i * (boxW / 8f)
                    drawLine(ink, Offset(x, top + 6f), Offset(x - 10f, top + boxH - 6f), 2f)
                    drawLine(guide, Offset(left + 6f, top + i * (boxH / 8f)), Offset(left + boxW - 6f, top + i * (boxH / 8f) - 8f), 2f)
                }
            }
            2 -> {
                for (i in 1..6) {
                    val y = top + i * (boxH / 7f)
                    val path = Path().apply {
                        moveTo(left + 4f, y)
                        quadraticTo(left + boxW * 0.5f, y + 14f, left + boxW - 4f, y)
                    }
                    drawPath(path, ink, style = Stroke(2.2f))
                }
            }
            3 -> {
                for (row in 1..7) {
                    for (col in 1..6) {
                        val densitySkip = if (row < 3 && (row + col) % 2 == 0) true else false
                        if (!densitySkip) {
                            drawCircle(
                                ink,
                                radius = 2.2f,
                                center = Offset(left + col * (boxW / 7f), top + row * (boxH / 8f))
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun DrawScope.drawValueScaleAndSphere(ink: Color, guide: Color, lightColor: Color) {
    val w = size.width
    val h = size.height
    // Left 5-step value scale
    val barW = w * 0.28f
    val stepH = (h * 0.74f) / 5f
    val values = listOf(0.06f, 0.25f, 0.48f, 0.72f, 0.92f)
    values.forEachIndexed { idx, alpha ->
        val y = h * 0.13f + idx * stepH
        drawRect(ink.copy(alpha = alpha), Offset(w * 0.07f, y), Size(barW, stepH))
        drawRect(ink, Offset(w * 0.07f, y), Size(barW, stepH), style = Stroke(1.5f))
    }

    // Light arrow
    drawCircle(lightColor, 8f, Offset(w * 0.48f, h * 0.20f))
    drawLine(lightColor, Offset(w * 0.51f, h * 0.24f), Offset(w * 0.60f, h * 0.34f), 2.5f)

    // Cast shadow ellipse
    drawOval(ink.copy(alpha = 0.72f), Offset(w * 0.60f, h * 0.74f), Size(w * 0.32f, h * 0.14f))

    // 5-zone lit sphere
    val c = Offset(w * 0.68f, h * 0.52f)
    val r = h * 0.28f
    drawCircle(
        brush = Brush.radialGradient(
            colors = listOf(Color.White, ink.copy(alpha = 0.22f), ink.copy(alpha = 0.85f), ink.copy(alpha = 0.55f)),
            center = Offset(c.x - r * 0.35f, c.y - r * 0.35f),
            radius = r * 1.45f
        ),
        radius = r,
        center = c
    )
    drawCircle(ink, r, c, style = Stroke(2.5f))
    // Terminator guide arc
    drawArc(
        guide,
        startAngle = -35f,
        sweepAngle = 155f,
        useCenter = false,
        topLeft = Offset(c.x - r * 0.5f, c.y - r * 0.85f),
        size = Size(r, r * 1.7f),
        style = Stroke(2.5f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f)))
    )
}

private fun DrawScope.drawCastShadowLogic(ink: Color, guide: Color, lightColor: Color) {
    val w = size.width
    val h = size.height
    val sun = Offset(w * 0.16f, h * 0.16f)
    drawCircle(lightColor, 10f, sun)
    // Box front
    val boxTopLeft = Offset(w * 0.34f, h * 0.42f)
    val boxSize = Size(w * 0.18f, h * 0.40f)
    // Cast shadow polygon
    val shadow = Path().apply {
        moveTo(boxTopLeft.x + boxSize.width, boxTopLeft.y + boxSize.height)
        lineTo(w * 0.84f, h * 0.82f)
        lineTo(w * 0.74f, h * 0.68f)
        lineTo(boxTopLeft.x + boxSize.width, boxTopLeft.y + boxSize.height * 0.55f)
        close()
    }
    drawPath(shadow, ink.copy(alpha = 0.65f))
    drawRect(ink.copy(alpha = 0.18f), boxTopLeft, boxSize)
    drawRect(ink, boxTopLeft, boxSize, style = Stroke(3f))
    // Light rays
    drawLine(lightColor, sun, Offset(w * 0.84f, h * 0.82f), 2f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 6f)))
    drawLine(guide, sun, Offset(boxTopLeft.x + boxSize.width, boxTopLeft.y), 2f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 6f)))
}

private fun DrawScope.drawPerspective2Point(ink: Color, guide: Color, accent: Color) {
    val w = size.width
    val h = size.height
    val hlY = h * 0.36f
    val vp1 = Offset(w * 0.05f, hlY)
    val vp2 = Offset(w * 0.95f, hlY)

    // Horizon line & VPs
    drawLine(guide, Offset(0f, hlY), Offset(w, hlY), 2.5f)
    drawCircle(accent, 7f, vp1)
    drawCircle(accent, 7f, vp2)

    val frontTop = Offset(w * 0.48f, h * 0.42f)
    val frontBot = Offset(w * 0.48f, h * 0.84f)
    val leftTop = Offset(w * 0.28f, h * 0.40f)
    val leftBot = Offset(w * 0.28f, h * 0.68f)
    val rightTop = Offset(w * 0.70f, h * 0.40f)
    val rightBot = Offset(w * 0.70f, h * 0.66f)

    val dash = PathEffect.dashPathEffect(floatArrayOf(7f, 6f))
    drawLine(guide.copy(alpha = 0.55f), vp1, frontTop, 1.5f, pathEffect = dash)
    drawLine(guide.copy(alpha = 0.55f), vp1, frontBot, 1.5f, pathEffect = dash)
    drawLine(guide.copy(alpha = 0.55f), vp2, frontTop, 1.5f, pathEffect = dash)
    drawLine(guide.copy(alpha = 0.55f), vp2, frontBot, 1.5f, pathEffect = dash)

    // Solid front box edges
    drawLine(ink, frontTop, frontBot, 4f)
    drawLine(ink, leftTop, leftBot, 3.5f)
    drawLine(ink, rightTop, rightBot, 3.5f)
    drawLine(ink, frontTop, leftTop, 3.5f)
    drawLine(ink, frontBot, leftBot, 3.5f)
    drawLine(ink, frontTop, rightTop, 3.5f)
    drawLine(ink, frontBot, rightBot, 3.5f)
}

private fun DrawScope.drawStillLifeSighting(ink: Color, guide: Color, accent: Color) {
    val w = size.width
    val h = size.height
    // Table plane
    drawLine(ink.copy(alpha = 0.5f), Offset(0f, h * 0.66f), Offset(w, h * 0.66f), 2.5f)
    // Tall bottle centerline + symmetrical contour
    val cx = w * 0.36f
    drawLine(guide, Offset(cx, h * 0.08f), Offset(cx, h * 0.88f), 2f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 6f)))
    drawOval(ink, Offset(cx - 18f, h * 0.14f), Size(36f, 12f), style = Stroke(3f))
    drawOval(ink, Offset(cx - 38f, h * 0.72f), Size(76f, 22f), style = Stroke(3f))
    drawLine(ink, Offset(cx - 18f, h * 0.20f), Offset(cx - 38f, h * 0.42f), 3f)
    drawLine(ink, Offset(cx + 18f, h * 0.20f), Offset(cx + 38f, h * 0.42f), 3f)
    drawLine(ink, Offset(cx - 38f, h * 0.42f), Offset(cx - 38f, h * 0.83f), 3f)
    drawLine(ink, Offset(cx + 38f, h * 0.42f), Offset(cx + 38f, h * 0.83f), 3f)

    // Overlapping front bowl
    drawOval(accent.copy(alpha = 0.2f), Offset(w * 0.44f, h * 0.56f), Size(w * 0.34f, h * 0.30f))
    drawOval(ink, Offset(w * 0.44f, h * 0.56f), Size(w * 0.34f, h * 0.12f), style = Stroke(3.5f))
    drawArc(ink, 0f, 180f, false, Offset(w * 0.44f, h * 0.56f), Size(w * 0.34f, h * 0.32f), style = Stroke(3.5f))
}

private fun DrawScope.drawTextureStudies(ink: Color, guide: Color) {
    val w = size.width
    val h = size.height
    // 3 swatches: Wood grain, Chrome band, Fabric pipe fold
    val swW = w * 0.26f
    val swH = h * 0.72f
    val top = h * 0.14f
    // Wood
    drawRect(ink, Offset(w * 0.05f, top), Size(swW, swH), style = Stroke(2.5f))
    for (i in 1..4) {
        val x = w * 0.05f + i * (swW / 5f)
        val p = Path().apply {
            moveTo(x, top + 6f)
            cubicTo(x + 8f, top + swH * 0.35f, x - 8f, top + swH * 0.65f, x, top + swH - 6f)
        }
        drawPath(p, ink, style = Stroke(2.2f))
    }
    // Chrome
    drawRect(
        brush = Brush.verticalGradient(listOf(ink.copy(alpha = 0.85f), Color.White, ink, ink.copy(alpha = 0.15f))),
        topLeft = Offset(w * 0.37f, top),
        size = Size(swW, swH)
    )
    drawRect(ink, Offset(w * 0.37f, top), Size(swW, swH), style = Stroke(2.5f))
    // Drapery fold
    val fold = Path().apply {
        moveTo(w * 0.72f, top + 8f)
        quadraticTo(w * 0.68f, top + swH * 0.5f, w * 0.70f, top + swH - 8f)
        quadraticTo(w * 0.78f, top + swH - 2f, w * 0.82f, top + swH - 14f)
        quadraticTo(w * 0.86f, top + swH * 0.5f, w * 0.79f, top + 8f)
        close()
    }
    drawPath(fold, guide.copy(alpha = 0.25f))
    drawPath(fold, ink, style = Stroke(3f))
}

private fun DrawScope.drawBotanicalAndAnimal(ink: Color, sage: Color, guide: Color) {
    val w = size.width
    val h = size.height
    // Leaf midrib ribbon
    val stem = Path().apply {
        moveTo(w * 0.12f, h * 0.82f)
        cubicTo(w * 0.22f, h * 0.45f, w * 0.30f, h * 0.20f, w * 0.42f, h * 0.18f)
    }
    drawPath(stem, sage, style = Stroke(3.5f, cap = StrokeCap.Round))
    val leaf = Path().apply {
        moveTo(w * 0.18f, h * 0.65f)
        quadraticTo(w * 0.14f, h * 0.26f, w * 0.42f, h * 0.18f)
        quadraticTo(w * 0.42f, h * 0.54f, w * 0.18f, h * 0.65f)
    }
    drawPath(leaf, sage.copy(alpha = 0.2f))
    drawPath(leaf, ink, style = Stroke(3f))

    // Animal ribcage + pelvis construction ovals
    drawOval(guide, Offset(w * 0.52f, h * 0.34f), Size(w * 0.22f, h * 0.28f), style = Stroke(3f))
    drawOval(guide, Offset(w * 0.72f, h * 0.40f), Size(w * 0.16f, h * 0.22f), style = Stroke(3f))
    drawLine(ink, Offset(w * 0.58f, h * 0.34f), Offset(w * 0.84f, h * 0.42f), 3.5f)
    drawLine(ink, Offset(w * 0.56f, h * 0.58f), Offset(w * 0.52f, h * 0.86f), 3f)
    drawLine(ink, Offset(w * 0.82f, h * 0.58f), Offset(w * 0.86f, h * 0.86f), 3f)
}

private fun DrawScope.drawHumanGestureMannequin(ink: Color, accent: Color, guide: Color) {
    val w = size.width
    val h = size.height
    // Sweeping Line of Action
    val loa = Path().apply {
        moveTo(w * 0.34f, h * 0.12f)
        cubicTo(w * 0.22f, h * 0.38f, w * 0.44f, h * 0.62f, w * 0.28f, h * 0.90f)
    }
    drawPath(loa, accent, style = Stroke(4f, cap = StrokeCap.Round))
    drawCircle(ink, 14f, Offset(w * 0.34f, h * 0.16f), style = Stroke(3f))
    // Tilted shoulder & hip cross-angles
    drawLine(guide, Offset(w * 0.22f, h * 0.26f), Offset(w * 0.44f, h * 0.32f), 4f)
    drawLine(guide, Offset(w * 0.24f, h * 0.56f), Offset(w * 0.42f, h * 0.50f), 4f)

    // Right side: Mannequin cylinders
    val mx = w * 0.72f
    drawCircle(ink, 14f, Offset(mx, h * 0.16f), style = Stroke(3f))
    drawRect(guide, Offset(mx - 24f, h * 0.28f), Size(48f, 34f), style = Stroke(3f))
    drawRect(guide, Offset(mx - 18f, h * 0.50f), Size(36f, 24f), style = Stroke(3f))
    drawLine(ink, Offset(mx - 14f, h * 0.62f), Offset(mx - 20f, h * 0.90f), 3.5f)
    drawLine(ink, Offset(mx + 14f, h * 0.62f), Offset(mx + 20f, h * 0.90f), 3.5f)
}

private fun DrawScope.drawLoomisHead(ink: Color, guide: Color, accent: Color) {
    val w = size.width
    val h = size.height
    val c = Offset(w * 0.50f, h * 0.44f)
    val r = h * 0.32f
    // Cranium sphere
    drawCircle(ink, r, c, style = Stroke(3.5f))
    // Temporal flat side slice
    drawOval(guide, Offset(c.x - r * 0.22f, c.y - r * 0.65f), Size(r * 0.95f, r * 1.30f), style = Stroke(2.5f))
    // Browline & Vertical Centerline
    drawLine(accent, Offset(c.x - r, c.y), Offset(c.x + r, c.y), 2.5f)
    drawLine(accent, Offset(c.x - r * 0.35f, c.y - r), Offset(c.x - r * 0.35f, h * 0.88f), 2.5f)
    // Chin jaw extension
    val jaw = Path().apply {
        moveTo(c.x - r * 0.78f, c.y + r * 0.4f)
        lineTo(c.x - r * 0.35f, h * 0.88f)
        lineTo(c.x + r * 0.35f, h * 0.82f)
        lineTo(c.x + r * 0.45f, c.y + r * 0.35f)
    }
    drawPath(jaw, ink, style = Stroke(3.5f))
}

private fun DrawScope.drawCompositionThirds(ink: Color, guide: Color, accent: Color) {
    val w = size.width
    val h = size.height
    // Frame
    drawRect(ink, Offset(w * 0.08f, h * 0.08f), Size(w * 0.84f, h * 0.84f), style = Stroke(3f))
    // Rule of thirds lines
    val x1 = w * (0.08f + 0.28f)
    val x2 = w * (0.08f + 0.56f)
    val y1 = h * (0.08f + 0.28f)
    val y2 = h * (0.08f + 0.56f)
    val dash = PathEffect.dashPathEffect(floatArrayOf(8f, 6f))
    drawLine(guide, Offset(x1, h * 0.08f), Offset(x1, h * 0.92f), 2f, pathEffect = dash)
    drawLine(guide, Offset(x2, h * 0.08f), Offset(x2, h * 0.92f), 2f, pathEffect = dash)
    drawLine(guide, Offset(w * 0.08f, y1), Offset(w * 0.92f, y1), 2f, pathEffect = dash)
    drawLine(guide, Offset(w * 0.08f, y2), Offset(w * 0.92f, y2), 2f, pathEffect = dash)
    // Focal point highlight
    drawCircle(accent, 11f, Offset(x2, y1))
    // Horizon hill silhouette
    val hill = Path().apply {
        moveTo(w * 0.08f, h * 0.76f)
        quadraticTo(w * 0.45f, h * 0.56f, w * 0.92f, h * 0.72f)
        lineTo(w * 0.92f, h * 0.92f)
        lineTo(w * 0.08f, h * 0.92f)
        close()
    }
    drawPath(hill, ink.copy(alpha = 0.20f))
}

private fun DrawScope.drawImaginationSynthesis(ink: Color, guide: Color, sage: Color) {
    val w = size.width
    val h = size.height
    // 3 rotational views of a simple invented prop
    val centers = listOf(w * 0.20f, w * 0.50f, w * 0.80f)
    centers.forEachIndexed { idx, cx ->
        val cy = h * 0.52f
        val r = 24f + idx * 3f
        drawCircle(guide, r, Offset(cx, cy), style = Stroke(3f))
        drawOval(sage, Offset(cx - r, cy - r * 0.35f), Size(r * 2, r * 0.7f), style = Stroke(2.5f))
        drawLine(ink, Offset(cx - 10f + idx * 8f, cy - r), Offset(cx - 10f + idx * 8f, cy + r), 2.5f)
    }
}
