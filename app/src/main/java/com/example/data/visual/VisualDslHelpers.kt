package com.example.data.visual

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

internal fun p(x: Float, y: Float) = Pt(x, y)

internal fun guideLine(
    x1: Float, y1: Float, x2: Float, y2: Float,
    stage: Int,
    dashed: Boolean = true,
    arrowEnd: Boolean = false,
    role: StrokeRole = StrokeRole.CONSTRUCTION_GUIDE,
    width: Float = 1.8f
) = LineElement(Pt(x1, y1), Pt(x2, y2), role, width, dashed, arrowEnd, stage, VisualLayer.GUIDE)

internal fun axisLine(
    x1: Float, y1: Float, x2: Float, y2: Float,
    stage: Int,
    dashed: Boolean = true,
    arrowEnd: Boolean = false,
    width: Float = 2.0f
) = LineElement(Pt(x1, y1), Pt(x2, y2), StrokeRole.AXIS_AND_PLUMB, width, dashed, arrowEnd, stage, VisualLayer.STRUCTURE)

internal fun lightRay(
    x1: Float, y1: Float, x2: Float, y2: Float,
    stage: Int,
    dashed: Boolean = true,
    arrowEnd: Boolean = true
) = LineElement(Pt(x1, y1), Pt(x2, y2), StrokeRole.LIGHT_RAY, 2.0f, dashed, arrowEnd, stage, VisualLayer.GUIDE)

internal fun inkLine(
    x1: Float, y1: Float, x2: Float, y2: Float,
    stage: Int,
    width: Float = 2.6f,
    dashed: Boolean = false,
    role: StrokeRole = StrokeRole.PRIMARY_CONTOUR,
    layer: VisualLayer = VisualLayer.CONTOUR
) = LineElement(Pt(x1, y1), Pt(x2, y2), role, width, dashed, false, stage, layer)

internal fun boldLine(
    x1: Float, y1: Float, x2: Float, y2: Float,
    stage: Int,
    width: Float = 4.0f
) = LineElement(Pt(x1, y1), Pt(x2, y2), StrokeRole.LINE_WEIGHT_ACCENT, width, false, false, stage, VisualLayer.CONTOUR)

internal fun arrowLine(
    x1: Float, y1: Float, x2: Float, y2: Float,
    stage: Int,
    role: StrokeRole = StrokeRole.ANNOTATION_ARROW,
    width: Float = 2.2f
) = LineElement(Pt(x1, y1), Pt(x2, y2), role, width, false, true, stage, VisualLayer.ANNOTATION)

internal fun poly(
    vararg pts: Pt,
    closed: Boolean = false,
    role: StrokeRole = StrokeRole.PRIMARY_CONTOUR,
    width: Float = 2.5f,
    fillAlpha: Float = 0f,
    dashed: Boolean = false,
    stage: Int,
    layer: VisualLayer = VisualLayer.CONTOUR
) = PolylineElement(pts.toList(), closed, role, width, fillAlpha, dashed, stage, layer)

internal fun cubic(
    start: Pt, c1: Pt, c2: Pt, end: Pt,
    stage: Int,
    role: StrokeRole = StrokeRole.PRIMARY_CONTOUR,
    width: Float = 2.5f,
    dashed: Boolean = false,
    arrowEnd: Boolean = false,
    layer: VisualLayer = VisualLayer.CONTOUR
) = CubicElement(start, c1, c2, end, role, width, dashed, arrowEnd, stage, layer)

internal fun quad(
    start: Pt, ctrl: Pt, end: Pt,
    stage: Int,
    role: StrokeRole = StrokeRole.PRIMARY_CONTOUR,
    width: Float = 2.5f,
    dashed: Boolean = false,
    arrowEnd: Boolean = false,
    layer: VisualLayer = VisualLayer.CONTOUR
) = QuadElement(start, ctrl, end, role, width, dashed, arrowEnd, stage, layer)

internal fun oval(
    cx: Float, cy: Float, rx: Float, ry: Float,
    stage: Int,
    role: StrokeRole = StrokeRole.PRIMARY_CONTOUR,
    width: Float = 2.5f,
    fillAlpha: Float = 0f,
    dashed: Boolean = false,
    startAngle: Float = 0f,
    sweepAngle: Float = 360f,
    layer: VisualLayer = VisualLayer.CONTOUR
) = OvalElement(cx, cy, rx, ry, role, width, fillAlpha, dashed, startAngle, sweepAngle, stage, layer)

internal fun hatch(
    lines: List<Pair<Pt, Pt>>,
    stage: Int,
    role: StrokeRole = StrokeRole.SHADING_TONE,
    width: Float = 1.5f
) = HatchElement(lines, role, width, stage, VisualLayer.SHADING)

internal fun buildParallelHatch(
    x: Float, y: Float, w: Float, h: Float,
    count: Int, skewX: Float = -0.04f
): List<Pair<Pt, Pt>> {
    return (1..count).map { i ->
        val px = x + (w * i) / (count + 1)
        Pt(px, y) to Pt(px + skewX, y + h)
    }
}

internal fun buildCrossHatch(
    x: Float, y: Float, w: Float, h: Float,
    count: Int
): List<Pair<Pt, Pt>> {
    return (1..count).map { i ->
        val py = y + (h * i) / (count + 1)
        Pt(x, py + 0.02f) to Pt(x + w, py - 0.02f)
    }
}

internal fun stippleGrid(
    x: Float, y: Float, w: Float, h: Float,
    cols: Int, rows: Int, gradientRight: Boolean = true
): List<Pt> {
    val pts = mutableListOf<Pt>()
    for (r in 1..rows) {
        for (c in 1..cols) {
            val frac = c.toFloat() / cols.toFloat()
            val keep = if (!gradientRight) true else (frac > 0.6f || (r + c) % 2 == 0 || frac > 0.3f && r % 2 == 1)
            if (keep) {
                val jitter = if ((r + c) % 2 == 0) 0.004f else -0.004f
                pts += Pt(x + (w * c) / (cols + 1) + jitter, y + (h * r) / (rows + 1) - jitter)
            }
        }
    }
    return pts
}

internal fun label(
    x: Float, y: Float, text: String,
    stage: Int,
    role: StrokeRole = StrokeRole.AXIS_AND_PLUMB
) = LabelElement(x, y, text, role, stage, VisualLayer.ANNOTATION)

internal fun focusRing(
    cx: Float, cy: Float,
    stage: Int,
    r: Float = 0.032f,
    role: StrokeRole = StrokeRole.ANNOTATION_ARROW
) = FocusMarkerElement(cx, cy, r, role, stage, VisualLayer.ANNOTATION)

internal fun toneRect(
    x: Float, y: Float, w: Float, h: Float,
    fillAlpha: Float,
    stage: Int,
    borderRole: StrokeRole = StrokeRole.PRIMARY_CONTOUR
) = ToneRectElement(x, y, w, h, fillAlpha, borderRole, stage, VisualLayer.SHADING)

internal fun sphereTone(
    cx: Float, cy: Float, r: Float,
    mode: SphereToneMode,
    stage: Int,
    lightX: Float = -0.35f,
    lightY: Float = -0.35f
) = ShadedSphereElement(cx, cy, r, lightX, lightY, mode, stage, VisualLayer.SHADING)

internal fun stipple(
    dots: List<Pt>,
    stage: Int,
    radius: Float = 2.3f,
    role: StrokeRole = StrokeRole.SHADING_TONE
) = StippleElement(dots, radius, role, stage, VisualLayer.SHADING)

internal fun wrongNote(text: String, x: Float = 0.06f, y: Float = 0.86f) =
    LabelElement(x, y, text, StrokeRole.MISTAKE_HIGHLIGHT, 0, VisualLayer.ANNOTATION)

internal fun rightNote(text: String, x: Float = 0.06f, y: Float = 0.86f) =
    LabelElement(x, y, text, StrokeRole.CORRECTION_HIGHLIGHT, 0, VisualLayer.ANNOTATION)
