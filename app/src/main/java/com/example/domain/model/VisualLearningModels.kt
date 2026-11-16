package com.example.domain.model

enum class VisualCategory(
    val shortTitle: String,
    val fullTitle: String,
    val code: String
) {
    BASIC_MARK_MAKING("Mark-Making", "A. Basic Mark-Making", "A"),
    SHAPES_AND_FORMS("Shapes & Forms", "B. Shapes & Forms", "B"),
    LIGHT_AND_SHADOW("Light & Shadow", "C. Light & Shadow", "C"),
    PERSPECTIVE("Perspective", "D. Perspective", "D"),
    OBJECT_DRAWING("Objects", "E. Object Drawing", "E"),
    HUMAN_FIGURE("Human Figure", "F. Human Figure & Animals", "F"),
    PORTRAITS("Portraits", "G. Portraits", "G"),
    COMPOSITION_ENVIRONMENTS("Composition", "H. Composition & Environments", "H")
}

enum class VisualScaffoldLevel(
    val label: String,
    val description: String
) {
    FULL_GUIDANCE(
        label = "Full Visual Guidance",
        description = "Watch every construction line, axis, arrow, and shadow zone step by step."
    ),
    PARTIAL_GUIDANCE(
        label = "Partial Construction Cues",
        description = "Heavy guide lines hidden — use structural anchors and vary angle or scale on paper."
    ),
    REFERENCE_ONLY(
        label = "Finished Reference Only",
        description = "Study the completed result and construct the underlying geometry yourself on paper."
    ),
    MEMORY_PROMPT(
        label = "Draw From Memory",
        description = "Sketch the construction sequence from memory in your notebook, then tap Reveal to check."
    )
}

enum class StrokeRole {
    CONSTRUCTION_GUIDE,
    AXIS_AND_PLUMB,
    LIGHT_RAY,
    PRIMARY_CONTOUR,
    LINE_WEIGHT_ACCENT,
    SHADING_TONE,
    HIGHLIGHT_ACCENT,
    ANNOTATION_ARROW,
    MISTAKE_HIGHLIGHT,
    CORRECTION_HIGHLIGHT
}

enum class VisualLayer {
    GUIDE,
    STRUCTURE,
    CONTOUR,
    SHADING,
    ANNOTATION
}

data class Pt(val x: Float, val y: Float)

sealed interface VisualElement {
    val stageIndex: Int
    val layer: VisualLayer
}

data class LineElement(
    val p1: Pt,
    val p2: Pt,
    val role: StrokeRole,
    val strokeWidth: Float = 2.4f,
    val dashed: Boolean = false,
    val arrowEnd: Boolean = false,
    override val stageIndex: Int,
    override val layer: VisualLayer
) : VisualElement

data class PolylineElement(
    val points: List<Pt>,
    val closed: Boolean = false,
    val role: StrokeRole,
    val strokeWidth: Float = 2.4f,
    val fillAlpha: Float = 0f,
    val dashed: Boolean = false,
    override val stageIndex: Int,
    override val layer: VisualLayer
) : VisualElement

data class CubicElement(
    val start: Pt,
    val c1: Pt,
    val c2: Pt,
    val end: Pt,
    val role: StrokeRole,
    val strokeWidth: Float = 2.4f,
    val dashed: Boolean = false,
    val arrowEnd: Boolean = false,
    override val stageIndex: Int,
    override val layer: VisualLayer
) : VisualElement

data class QuadElement(
    val start: Pt,
    val ctrl: Pt,
    val end: Pt,
    val role: StrokeRole,
    val strokeWidth: Float = 2.4f,
    val dashed: Boolean = false,
    val arrowEnd: Boolean = false,
    override val stageIndex: Int,
    override val layer: VisualLayer
) : VisualElement

data class OvalElement(
    val cx: Float,
    val cy: Float,
    val rx: Float,
    val ry: Float,
    val role: StrokeRole,
    val strokeWidth: Float = 2.4f,
    val fillAlpha: Float = 0f,
    val dashed: Boolean = false,
    val startAngle: Float = 0f,
    val sweepAngle: Float = 360f,
    override val stageIndex: Int,
    override val layer: VisualLayer
) : VisualElement

data class HatchElement(
    val lines: List<Pair<Pt, Pt>>,
    val role: StrokeRole = StrokeRole.SHADING_TONE,
    val strokeWidth: Float = 1.5f,
    override val stageIndex: Int,
    override val layer: VisualLayer = VisualLayer.SHADING
) : VisualElement

data class StippleElement(
    val dots: List<Pt>,
    val radius: Float = 2.2f,
    val role: StrokeRole = StrokeRole.SHADING_TONE,
    override val stageIndex: Int,
    override val layer: VisualLayer = VisualLayer.SHADING
) : VisualElement

data class ShadedSphereElement(
    val cx: Float,
    val cy: Float,
    val r: Float,
    val lightOffsetX: Float = -0.35f,
    val lightOffsetY: Float = -0.35f,
    val mode: SphereToneMode,
    override val stageIndex: Int,
    override val layer: VisualLayer = VisualLayer.SHADING
) : VisualElement

enum class SphereToneMode {
    FORM_BASE_AND_CORE,
    REFLECTED_LIGHT_AND_HIGHLIGHT,
    CAST_SHADOW
}

data class ToneRectElement(
    val x: Float,
    val y: Float,
    val w: Float,
    val h: Float,
    val fillAlpha: Float,
    val borderRole: StrokeRole = StrokeRole.PRIMARY_CONTOUR,
    override val stageIndex: Int,
    override val layer: VisualLayer = VisualLayer.SHADING
) : VisualElement

data class FocusMarkerElement(
    val cx: Float,
    val cy: Float,
    val r: Float = 0.032f,
    val role: StrokeRole = StrokeRole.ANNOTATION_ARROW,
    override val stageIndex: Int,
    override val layer: VisualLayer = VisualLayer.ANNOTATION
) : VisualElement

data class LabelElement(
    val x: Float,
    val y: Float,
    val text: String,
    val role: StrokeRole = StrokeRole.AXIS_AND_PLUMB,
    override val stageIndex: Int,
    override val layer: VisualLayer = VisualLayer.ANNOTATION
) : VisualElement

data class ConstructionStage(
    val stageNumber: Int,
    val title: String,
    val explanation: String,
    val visualFocus: String,
    val isCleanupStage: Boolean = false
)

data class MistakeComparisonSpec(
    val title: String,
    val wrongLabel: String,
    val rightLabel: String,
    val whyMistakeHappens: String,
    val howToFix: String,
    val wrongElements: List<VisualElement>,
    val rightElements: List<VisualElement>
)

data class VisualDemoSpec(
    val id: String,
    val title: String,
    val category: VisualCategory,
    val worldNumbers: List<Int>,
    val skillIds: List<String>,
    val summary: String,
    val revisitedConcepts: List<String> = emptyList(),
    val stages: List<ConstructionStage>,
    val elements: List<VisualElement>,
    val comparison: MistakeComparisonSpec
) {
    fun shouldRenderLayer(layer: VisualLayer, scaffold: VisualScaffoldLevel): Boolean {
        return when (scaffold) {
            VisualScaffoldLevel.FULL_GUIDANCE -> true
            VisualScaffoldLevel.PARTIAL_GUIDANCE -> layer != VisualLayer.GUIDE && layer != VisualLayer.ANNOTATION
            VisualScaffoldLevel.REFERENCE_ONLY -> layer == VisualLayer.CONTOUR || layer == VisualLayer.SHADING
            VisualScaffoldLevel.MEMORY_PROMPT -> layer == VisualLayer.CONTOUR || layer == VisualLayer.SHADING
        }
    }
}
