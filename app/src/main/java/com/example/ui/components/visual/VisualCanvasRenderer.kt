package com.example.ui.components.visual

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.CubicElement
import com.example.domain.model.FocusMarkerElement
import com.example.domain.model.HatchElement
import com.example.domain.model.LabelElement
import com.example.domain.model.LineElement
import com.example.domain.model.OvalElement
import com.example.domain.model.PolylineElement
import com.example.domain.model.Pt
import com.example.domain.model.QuadElement
import com.example.domain.model.ShadedSphereElement
import com.example.domain.model.SphereToneMode
import com.example.domain.model.StippleElement
import com.example.domain.model.StrokeRole
import com.example.domain.model.ToneRectElement
import com.example.domain.model.VisualElement
import com.example.domain.model.VisualLayer
import com.example.domain.model.VisualScaffoldLevel
import com.example.ui.theme.AtelierSage
import com.example.ui.theme.BlueprintCobalt
import com.example.ui.theme.CreamPaper
import com.example.ui.theme.DustyCrimson
import com.example.ui.theme.GraphiteSlate
import com.example.ui.theme.IndiaInk
import com.example.ui.theme.OchreGold
import com.example.ui.theme.SketchRule
import com.example.ui.theme.TerracottaFlame
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun VisualStageCanvas(
    elements: List<VisualElement>,
    activeStageIndex: Int,
    activeStageProgress: Float,
    scaffoldLevel: VisualScaffoldLevel,
    isCleanupStage: Boolean = false,
    showGuidesOverlay: Boolean = true,
    showGrid: Boolean = true,
    borderColor: Color = SketchRule,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()
    val pathMeasure = remember { PathMeasure() }

    val visibleElements = remember(elements, activeStageIndex, scaffoldLevel, showGuidesOverlay) {
        elements.filter { el ->
            el.stageIndex <= activeStageIndex && shouldShowElement(el.layer, scaffoldLevel, showGuidesOverlay)
        }
    }

    val activeStageElements = remember(visibleElements, activeStageIndex) {
        visibleElements.filter { it.stageIndex == activeStageIndex }
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(CreamPaper)
            .border(1.2.dp, borderColor, RoundedCornerShape(14.dp))
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            if (showGrid) {
                drawSketchbookGrid()
            }

            visibleElements.forEach { element ->
                val rawProgress = if (element.stageIndex < activeStageIndex) {
                    1f
                } else {
                    val idx = activeStageElements.indexOf(element).coerceAtLeast(0)
                    val total = activeStageElements.size.coerceAtLeast(1)
                    staggeredProgress(activeStageProgress, idx, total)
                }
                if (rawProgress <= 0.001f) return@forEach

                val guideFadeAlpha = if (isCleanupStage && element.layer == VisualLayer.GUIDE) 0.28f else 1f
                drawVisualElement(
                    element = element,
                    progress = rawProgress,
                    alphaMultiplier = guideFadeAlpha,
                    pathMeasure = pathMeasure,
                    textMeasurer = textMeasurer
                )
            }
        }
    }
}

private fun shouldShowElement(
    layer: VisualLayer,
    scaffold: VisualScaffoldLevel,
    showGuidesOverlay: Boolean
): Boolean {
    if (!showGuidesOverlay && (layer == VisualLayer.GUIDE || layer == VisualLayer.ANNOTATION)) {
        return false
    }
    return when (scaffold) {
        VisualScaffoldLevel.FULL_GUIDANCE -> true
        VisualScaffoldLevel.PARTIAL_GUIDANCE -> layer != VisualLayer.GUIDE && layer != VisualLayer.ANNOTATION
        VisualScaffoldLevel.REFERENCE_ONLY -> layer == VisualLayer.CONTOUR || layer == VisualLayer.SHADING
        VisualScaffoldLevel.MEMORY_PROMPT -> layer == VisualLayer.CONTOUR || layer == VisualLayer.SHADING
    }
}

private fun staggeredProgress(stageProgress: Float, index: Int, count: Int): Float {
    if (stageProgress >= 0.999f) return 1f
    if (count <= 1) return stageProgress.coerceIn(0f, 1f)
    // Gentle sequential stagger so construction strokes appear one after another smoothly
    val span = (1f / count.toFloat()).coerceAtLeast(0.18f)
    val start = (index.toFloat() / count.toFloat()) * (1f - span * 0.55f)
    return ((stageProgress - start) / (span * 0.85f)).coerceIn(0f, 1f)
}

private fun DrawScope.drawSketchbookGrid() {
    val stepX = size.width / 8f
    val stepY = size.height / 6f
    val minorColor = SketchRule.copy(alpha = 0.36f)
    val axisColor = SketchRule.copy(alpha = 0.62f)
    for (i in 1 until 8) {
        val x = stepX * i
        drawLine(
            color = if (i == 4) axisColor else minorColor,
            start = Offset(x, 0f),
            end = Offset(x, size.height),
            strokeWidth = if (i == 4) 1.dp.toPx() else 0.7.dp.toPx()
        )
    }
    for (j in 1 until 6) {
        val y = stepY * j
        drawLine(
            color = if (j == 3) axisColor else minorColor,
            start = Offset(0f, y),
            end = Offset(size.width, y),
            strokeWidth = if (j == 3) 1.dp.toPx() else 0.7.dp.toPx()
        )
    }
}

private fun DrawScope.toPx(pt: Pt): Offset = Offset(pt.x * size.width, pt.y * size.height)

private fun strokeColorFor(role: StrokeRole): Color = when (role) {
    StrokeRole.CONSTRUCTION_GUIDE -> BlueprintCobalt.copy(alpha = 0.72f)
    StrokeRole.AXIS_AND_PLUMB -> BlueprintCobalt
    StrokeRole.LIGHT_RAY -> OchreGold
    StrokeRole.PRIMARY_CONTOUR -> IndiaInk
    StrokeRole.LINE_WEIGHT_ACCENT -> IndiaInk
    StrokeRole.SHADING_TONE -> GraphiteSlate.copy(alpha = 0.86f)
    StrokeRole.HIGHLIGHT_ACCENT -> CreamPaper
    StrokeRole.ANNOTATION_ARROW -> TerracottaFlame
    StrokeRole.MISTAKE_HIGHLIGHT -> DustyCrimson
    StrokeRole.CORRECTION_HIGHLIGHT -> AtelierSage
}

private fun DrawScope.drawVisualElement(
    element: VisualElement,
    progress: Float,
    alphaMultiplier: Float,
    pathMeasure: PathMeasure,
    textMeasurer: TextMeasurer
) {
    when (element) {
        is LineElement -> {
            val baseColor = strokeColorFor(element.role)
            val color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier)
            val effect = if (element.dashed) {
                PathEffect.dashPathEffect(floatArrayOf(6.dp.toPx(), 4.dp.toPx()), 0f)
            } else null
            val p1 = toPx(element.p1)
            val p2 = toPx(element.p2)
            val currentEnd = Offset(
                x = p1.x + (p2.x - p1.x) * progress,
                y = p1.y + (p2.y - p1.y) * progress
            )
            drawLine(
                color = color,
                start = p1,
                end = currentEnd,
                strokeWidth = element.strokeWidth.dp.toPx() * 0.75f,
                cap = StrokeCap.Round,
                pathEffect = effect
            )
            if (element.arrowEnd && progress > 0.8f) {
                val arrowAlpha = ((progress - 0.8f) / 0.2f).coerceIn(0f, 1f) * alphaMultiplier
                drawArrowHead(
                    tip = currentEnd,
                    from = p1,
                    color = baseColor.copy(alpha = baseColor.alpha * arrowAlpha),
                    strokePx = element.strokeWidth.dp.toPx() * 0.75f
                )
            }
        }

        is PolylineElement -> {
            if (element.points.size < 2) return
            val path = Path().apply {
                val first = toPx(element.points.first())
                moveTo(first.x, first.y)
                element.points.drop(1).forEach { pt ->
                    val px = toPx(pt)
                    lineTo(px.x, px.y)
                }
                if (element.closed) close()
            }
            val baseColor = strokeColorFor(element.role)
            if (element.fillAlpha > 0f && element.closed) {
                drawPath(
                    path = path,
                    color = baseColor.copy(alpha = element.fillAlpha * progress * alphaMultiplier)
                )
            }
            drawProgressivePath(
                fullPath = path,
                progress = progress,
                color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier),
                strokeWidthPx = element.strokeWidth.dp.toPx() * 0.75f,
                dashed = element.dashed,
                pathMeasure = pathMeasure
            )
        }

        is CubicElement -> {
            val start = toPx(element.start)
            val c1 = toPx(element.c1)
            val c2 = toPx(element.c2)
            val end = toPx(element.end)
            val path = Path().apply {
                moveTo(start.x, start.y)
                cubicTo(c1.x, c1.y, c2.x, c2.y, end.x, end.y)
            }
            val baseColor = strokeColorFor(element.role)
            drawProgressivePath(
                fullPath = path,
                progress = progress,
                color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier),
                strokeWidthPx = element.strokeWidth.dp.toPx() * 0.75f,
                dashed = element.dashed,
                pathMeasure = pathMeasure
            )
            if (element.arrowEnd && progress > 0.85f) {
                drawArrowHead(
                    tip = end,
                    from = c2,
                    color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier),
                    strokePx = element.strokeWidth.dp.toPx() * 0.75f
                )
            }
        }

        is QuadElement -> {
            val start = toPx(element.start)
            val ctrl = toPx(element.ctrl)
            val end = toPx(element.end)
            val path = Path().apply {
                moveTo(start.x, start.y)
                quadraticTo(ctrl.x, ctrl.y, end.x, end.y)
            }
            val baseColor = strokeColorFor(element.role)
            drawProgressivePath(
                fullPath = path,
                progress = progress,
                color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier),
                strokeWidthPx = element.strokeWidth.dp.toPx() * 0.75f,
                dashed = element.dashed,
                pathMeasure = pathMeasure
            )
            if (element.arrowEnd && progress > 0.85f) {
                drawArrowHead(
                    tip = end,
                    from = ctrl,
                    color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier),
                    strokePx = element.strokeWidth.dp.toPx() * 0.75f
                )
            }
        }

        is OvalElement -> {
            val rect = Rect(
                left = (element.cx - element.rx) * size.width,
                top = (element.cy - element.ry) * size.height,
                right = (element.cx + element.rx) * size.width,
                bottom = (element.cy + element.ry) * size.height
            )
            val baseColor = strokeColorFor(element.role)
            val color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier)
            if (element.fillAlpha > 0f && element.sweepAngle >= 359f) {
                drawOval(
                    color = baseColor.copy(alpha = element.fillAlpha * progress * alphaMultiplier),
                    topLeft = rect.topLeft,
                    size = rect.size
                )
            }
            val path = Path().apply {
                val sweep = element.sweepAngle * progress
                if (sweep >= 359.5f) {
                    addOval(rect)
                } else {
                    addArc(rect, element.startAngle, sweep)
                }
            }
            val effect = if (element.dashed) {
                PathEffect.dashPathEffect(floatArrayOf(5.dp.toPx(), 4.dp.toPx()), 0f)
            } else null
            drawPath(
                path = path,
                color = color,
                style = Stroke(
                    width = element.strokeWidth.dp.toPx() * 0.75f,
                    cap = StrokeCap.Round,
                    pathEffect = effect
                )
            )
        }

        is HatchElement -> {
            if (element.lines.isEmpty()) return
            val baseColor = strokeColorFor(element.role)
            val color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier)
            val strokePx = element.strokeWidth.dp.toPx() * 0.72f
            val total = element.lines.size
            val exactCount = progress * total
            element.lines.forEachIndexed { idx, pair ->
                val lineProg = (exactCount - idx).coerceIn(0f, 1f)
                if (lineProg > 0f) {
                    val s = toPx(pair.first)
                    val e = toPx(pair.second)
                    drawLine(
                        color = color,
                        start = s,
                        end = Offset(s.x + (e.x - s.x) * lineProg, s.y + (e.y - s.y) * lineProg),
                        strokeWidth = strokePx,
                        cap = StrokeCap.Round
                    )
                }
            }
        }

        is StippleElement -> {
            if (element.dots.isEmpty()) return
            val baseColor = strokeColorFor(element.role)
            val color = baseColor.copy(alpha = baseColor.alpha * alphaMultiplier)
            val dotR = element.radius.dp.toPx() * 0.65f
            val visibleCount = (element.dots.size * progress).toInt().coerceIn(0, element.dots.size)
            for (i in 0 until visibleCount) {
                drawCircle(
                    color = color,
                    radius = dotR,
                    center = toPx(element.dots[i])
                )
            }
        }

        is ShadedSphereElement -> {
            val center = Offset(element.cx * size.width, element.cy * size.height)
            val radius = element.r * minOf(size.width, size.height)
            when (element.mode) {
                SphereToneMode.CAST_SHADOW -> {
                    val shadowLeft = center.x - radius * 0.25f
                    val shadowTop = center.y + radius * 0.74f
                    val shadowWidth = radius * 2.15f
                    val shadowHeight = radius * 0.56f
                    drawOval(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                IndiaInk.copy(alpha = 0.62f * progress * alphaMultiplier),
                                GraphiteSlate.copy(alpha = 0.30f * progress * alphaMultiplier),
                                Color.Transparent
                            ),
                            center = Offset(shadowLeft + shadowWidth * 0.42f, shadowTop + shadowHeight * 0.5f),
                            radius = shadowWidth * 0.55f
                        ),
                        topLeft = Offset(shadowLeft, shadowTop),
                        size = Size(shadowWidth, shadowHeight)
                    )
                }

                SphereToneMode.FORM_BASE_AND_CORE -> {
                    val focal = Offset(
                        center.x + radius * element.lightOffsetX,
                        center.y + radius * element.lightOffsetY
                    )
                    drawCircle(
                        brush = Brush.radialGradient(
                            colorStops = arrayOf(
                                0.0f to CreamPaper.copy(alpha = 0.92f * progress * alphaMultiplier),
                                0.38f to GraphiteSlate.copy(alpha = 0.16f * progress * alphaMultiplier),
                                0.74f to IndiaInk.copy(alpha = 0.62f * progress * alphaMultiplier),
                                0.90f to GraphiteSlate.copy(alpha = 0.45f * progress * alphaMultiplier),
                                1.0f to IndiaInk.copy(alpha = 0.42f * progress * alphaMultiplier)
                            ),
                            center = focal,
                            radius = radius * 1.48f
                        ),
                        radius = radius,
                        center = center
                    )
                }

                SphereToneMode.REFLECTED_LIGHT_AND_HIGHLIGHT -> {
                    // Subtle bounce light rim on bottom-right + bright highlight dot on top-left
                    val bounceCenter = Offset(center.x + radius * 0.48f, center.y + radius * 0.48f)
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                CreamPaper.copy(alpha = 0.28f * progress * alphaMultiplier),
                                Color.Transparent
                            ),
                            center = bounceCenter,
                            radius = radius * 0.45f
                        ),
                        radius = radius * 0.96f,
                        center = center
                    )
                    val hiCenter = Offset(
                        center.x + radius * element.lightOffsetX * 0.95f,
                        center.y + radius * element.lightOffsetY * 0.95f
                    )
                    drawCircle(
                        color = Color.White.copy(alpha = 0.92f * progress * alphaMultiplier),
                        radius = radius * 0.14f,
                        center = hiCenter
                    )
                }
            }
        }

        is ToneRectElement -> {
            val topLeft = Offset(element.x * size.width, element.y * size.height)
            val rectSize = Size(element.w * size.width * progress.coerceAtLeast(0.15f), element.h * size.height)
            drawRect(
                color = IndiaInk.copy(alpha = element.fillAlpha * progress * alphaMultiplier),
                topLeft = topLeft,
                size = rectSize
            )
            drawRect(
                color = strokeColorFor(element.borderRole).copy(alpha = 0.7f * alphaMultiplier),
                topLeft = topLeft,
                size = Size(element.w * size.width, element.h * size.height),
                style = Stroke(width = 1.2.dp.toPx())
            )
        }

        is FocusMarkerElement -> {
            val baseColor = strokeColorFor(element.role)
            val radius = element.r * minOf(size.width, size.height) * (0.65f + 0.35f * progress)
            drawCircle(
                color = baseColor.copy(alpha = 0.14f * progress * alphaMultiplier),
                radius = radius * 1.3f,
                center = Offset(element.cx * size.width, element.cy * size.height)
            )
            drawCircle(
                color = baseColor.copy(alpha = 0.88f * progress * alphaMultiplier),
                radius = radius,
                center = Offset(element.cx * size.width, element.cy * size.height),
                style = Stroke(
                    width = 1.8.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(4.dp.toPx(), 3.dp.toPx()), 0f)
                )
            )
        }

        is LabelElement -> {
            if (progress < 0.25f) return
            val labelAlpha = ((progress - 0.25f) / 0.45f).coerceIn(0f, 1f) * alphaMultiplier
            val roleColor = strokeColorFor(element.role)
            val measured = textMeasurer.measure(
                text = element.text,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = roleColor.copy(alpha = labelAlpha)
                )
            )
            val padX = 5.dp.toPx()
            val padY = 2.dp.toPx()
            val pillW = measured.size.width + padX * 2f
            val pillH = measured.size.height + padY * 2f
            val x = (element.x * size.width).coerceIn(2f, (size.width - pillW - 2f).coerceAtLeast(2f))
            val y = (element.y * size.height).coerceIn(2f, (size.height - pillH - 2f).coerceAtLeast(2f))

            drawRoundRect(
                color = CreamPaper.copy(alpha = 0.92f * labelAlpha),
                topLeft = Offset(x, y),
                size = Size(pillW, pillH),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx(), 6.dp.toPx())
            )
            drawRoundRect(
                color = roleColor.copy(alpha = 0.38f * labelAlpha),
                topLeft = Offset(x, y),
                size = Size(pillW, pillH),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx(), 6.dp.toPx()),
                style = Stroke(width = 0.9.dp.toPx())
            )
            drawText(
                textLayoutResult = measured,
                topLeft = Offset(x + padX, y + padY)
            )
        }
    }
}

private fun DrawScope.drawProgressivePath(
    fullPath: Path,
    progress: Float,
    color: Color,
    strokeWidthPx: Float,
    dashed: Boolean,
    pathMeasure: PathMeasure
) {
    val effect = if (dashed) {
        PathEffect.dashPathEffect(floatArrayOf(6.dp.toPx(), 4.dp.toPx()), 0f)
    } else null
    val style = Stroke(
        width = strokeWidthPx,
        cap = StrokeCap.Round,
        join = StrokeJoin.Round,
        pathEffect = effect
    )
    if (progress >= 0.999f) {
        drawPath(path = fullPath, color = color, style = style)
        return
    }
    pathMeasure.setPath(fullPath, false)
    val totalLength = pathMeasure.length
    if (totalLength <= 0.1f) {
        drawPath(path = fullPath, color = color, style = style)
        return
    }
    val partial = Path()
    pathMeasure.getSegment(0f, totalLength * progress.coerceIn(0f, 1f), partial, true)
    drawPath(path = partial, color = color, style = style)
}

private fun DrawScope.drawArrowHead(
    tip: Offset,
    from: Offset,
    color: Color,
    strokePx: Float
) {
    val dx = tip.x - from.x
    val dy = tip.y - from.y
    if (dx * dx + dy * dy < 4f) return
    val angle = atan2(dy.toDouble(), dx.toDouble())
    val headLen = 8.dp.toPx()
    val spread = PI / 6.5
    val pLeft = Offset(
        x = (tip.x - headLen * cos(angle - spread)).toFloat(),
        y = (tip.y - headLen * sin(angle - spread)).toFloat()
    )
    val pRight = Offset(
        x = (tip.x - headLen * cos(angle + spread)).toFloat(),
        y = (tip.y - headLen * sin(angle + spread)).toFloat()
    )
    drawLine(color = color, start = pLeft, end = tip, strokeWidth = strokePx, cap = StrokeCap.Round)
    drawLine(color = color, start = pRight, end = tip, strokeWidth = strokePx, cap = StrokeCap.Round)
}
