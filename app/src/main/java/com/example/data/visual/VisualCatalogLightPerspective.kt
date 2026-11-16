package com.example.data.visual

import com.example.domain.model.ConstructionStage
import com.example.domain.model.MistakeComparisonSpec
import com.example.domain.model.SphereToneMode
import com.example.domain.model.StrokeRole
import com.example.domain.model.VisualCategory
import com.example.domain.model.VisualDemoSpec
import com.example.domain.model.VisualLayer

internal fun lightAndPerspectiveVisualDemos(): List<VisualDemoSpec> = listOf(
    // 13. Five-Value Scale
    VisualDemoSpec(
        id = "vis_value_scale",
        title = "5-Value Scale & Light/Shadow Families",
        category = VisualCategory.LIGHT_AND_SHADOW,
        worldNumbers = listOf(4, 6),
        skillIds = listOf("sk_value_scale"),
        summary = "Organize tone into five crisp steps and never let reflected shadow tones invade the light family.",
        revisitedConcepts = listOf("Uniform hatching", "Layer pressure"),
        stages = listOf(
            ConstructionStage(1, "Divide Five Equal Tonal Boxes", "Rule five touching rectangles cleanly from left to right.", "Consistent boxes let you judge tonal jumps accurately."),
            ConstructionStage(2, "Reserve #1 Highlight & #2 Light Tone", "Keep #1 pure bright paper and tone #2 lightly with 2H pressure.", "These two belong strictly to the sunlit Light Family."),
            ConstructionStage(3, "Establish #3 Halftone Bridge", "Fill the middle step evenly with HB to bridge light toward shadow.", "Never push halftone dark enough to blur into core shadow."),
            ConstructionStage(4, "Anchor #4 Reflected & #5 Core/Occlusion", "Tone #4 clearly darker than #3, and push #5 velvety dark with 2B/4B.", "Keep #4 darker than #3 so solid shadows never glow."),
            ConstructionStage(5, "Squint-Check Family Separation", "Group #1–#3 (Light Family) apart from #4–#5 (Shadow Family).", "Two clear families make every drawing read cleanly from across the room.")
        ),
        elements = listOf(
            toneRect(0.08f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.02f, stage = 0),
            toneRect(0.24f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.02f, stage = 0),
            toneRect(0.40f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.02f, stage = 0),
            toneRect(0.56f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.02f, stage = 0),
            toneRect(0.72f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.02f, stage = 0),

            toneRect(0.08f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.03f, stage = 1),
            toneRect(0.24f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.20f, stage = 1),
            label(0.11f, 0.66f, "#1 Paper", stage = 1),
            label(0.27f, 0.66f, "#2 Light", stage = 1),

            toneRect(0.40f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.42f, stage = 2),
            label(0.43f, 0.66f, "#3 Half", stage = 2),

            toneRect(0.56f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.68f, stage = 3),
            toneRect(0.72f, 0.28f, 0.16f, 0.34f, fillAlpha = 0.90f, stage = 3),
            label(0.59f, 0.66f, "#4 Refl.", stage = 3),
            label(0.75f, 0.66f, "#5 Core", stage = 3),

            axisLine(0.56f, 0.14f, 0.56f, 0.78f, stage = 4),
            label(0.14f, 0.12f, "LIGHT FAMILY (#1-#3)", stage = 4, StrokeRole.CORRECTION_HIGHLIGHT),
            label(0.59f, 0.12f, "SHADOW FAMILY (#4-#5)", stage = 4, StrokeRole.ANNOTATION_ARROW)
        ),
        comparison = MistakeComparisonSpec(
            title = "Muddy Equal Midtones vs. Clean 5-Value Steps",
            wrongLabel = "Blurry Undifferentiated Grays",
            rightLabel = "Crisp Light vs. Shadow Separation",
            whyMistakeHappens = "Using the same medium pressure everywhere collapses highlight, halftone, and shadow into muddy gray.",
            howToFix = "Squint while shading and keep a visible value jump between #3 Halftone and #4 Shadow.",
            wrongElements = listOf(
                toneRect(0.10f, 0.32f, 0.20f, 0.34f, 0.35f, 0, StrokeRole.MISTAKE_HIGHLIGHT),
                toneRect(0.30f, 0.32f, 0.20f, 0.34f, 0.40f, 0, StrokeRole.MISTAKE_HIGHLIGHT),
                toneRect(0.50f, 0.32f, 0.20f, 0.34f, 0.42f, 0, StrokeRole.MISTAKE_HIGHLIGHT),
                toneRect(0.70f, 0.32f, 0.20f, 0.34f, 0.46f, 0, StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Steps blend into one muddy gray")
            ),
            rightElements = listOf(
                toneRect(0.10f, 0.32f, 0.16f, 0.34f, 0.04f, 0),
                toneRect(0.26f, 0.32f, 0.16f, 0.34f, 0.22f, 0),
                toneRect(0.42f, 0.32f, 0.16f, 0.34f, 0.42f, 0),
                toneRect(0.58f, 0.32f, 0.16f, 0.34f, 0.68f, 0),
                toneRect(0.74f, 0.32f, 0.16f, 0.34f, 0.90f, 0),
                axisLine(0.58f, 0.22f, 0.58f, 0.74f, 0),
                rightNote("Distinct tonal ladder")
            )
        )
    ),

    // 14. Circle to Sphere Light & Shadow (6 Stages matching Section 2 exactly!)
    VisualDemoSpec(
        id = "vis_sphere_shading",
        title = "Circle to Shaded 3D Sphere (6 Stages)",
        category = VisualCategory.LIGHT_AND_SHADOW,
        worldNumbers = listOf(4, 6),
        skillIds = listOf("sk_form_shadow", "sk_edge_control"),
        summary = "Turn a flat 2D circle into a luminous 3D sphere using light rays, terminator, core shadow, reflected light, and cast shadow.",
        revisitedConcepts = listOf("Clean circle", "5-value discipline"),
        stages = listOf(
            ConstructionStage(1, "Draw Clean Circle & Ground Line", "Establish a balanced circle resting on a flat tabletop horizon.", "Keep outer contour light so shading—not ink—carves the sunlit rim."),
            ConstructionStage(2, "Establish Light Direction", "Place the light source top-left and project directional rays toward the sphere.", "Defines exactly where light grazes off the round surface."),
            ConstructionStage(3, "Identify Shadow Region & Terminator", "Map the curved terminator arc dividing the sunlit side from the shadow family.", "The terminator runs perpendicular to the incoming light rays."),
            ConstructionStage(4, "Add Core Shadow & Form Shading", "Fill the shadow side evenly and darken the core shadow band right along the terminator.", "Core shadow is darker because neither direct sun nor floor bounce hits it."),
            ConstructionStage(5, "Introduce Reflected Light & Highlight", "Leave a subtle softer glow (#4) along the bottom-right rim and pinpoint the #1 highlight.", "Keep reflected light darker than lit halftones so the sphere stays solid."),
            ConstructionStage(6, "Anchor With Cast Shadow & Occlusion", "Project a dark elliptical cast shadow across the table with deepest occlusion under the base.", "Seats the sphere firmly on the table plane.", isCleanupStage = true)
        ),
        elements = listOf(
            // Stage 0: Circle & table line
            axisLine(0.08f, 0.78f, 0.94f, 0.78f, stage = 0, dashed = false, width = 1.8f),
            oval(0.46f, 0.52f, 0.23f, 0.23f, stage = 0, width = 2.6f),

            // Stage 1: Light source & rays
            focusRing(0.14f, 0.16f, stage = 1, r = 0.032f, StrokeRole.LIGHT_RAY),
            lightRay(0.17f, 0.19f, 0.34f, 0.34f, stage = 1),
            lightRay(0.18f, 0.16f, 0.54f, 0.28f, stage = 1),
            label(0.08f, 0.05f, "2. Light source (45° top-left)", stage = 1, StrokeRole.LIGHT_RAY),

            // Stage 2: Curved terminator dividing lit & shadow
            cubic(p(0.62f, 0.33f), p(0.56f, 0.50f), p(0.42f, 0.66f), p(0.27f, 0.67f), stage = 2, role = StrokeRole.AXIS_AND_PLUMB, width = 2.4f, dashed = true, layer = VisualLayer.STRUCTURE),
            label(0.64f, 0.25f, "3. Terminator line", stage = 2),

            // Stage 3: Form shadow & Core shadow
            sphereTone(0.46f, 0.52f, 0.23f, SphereToneMode.FORM_BASE_AND_CORE, stage = 3),
            label(0.66f, 0.42f, "4. Core shadow band", stage = 3),

            // Stage 4: Reflected light & Highlight
            sphereTone(0.46f, 0.52f, 0.23f, SphereToneMode.REFLECTED_LIGHT_AND_HIGHLIGHT, stage = 4),
            focusRing(0.36f, 0.41f, stage = 4, r = 0.026f, StrokeRole.HIGHLIGHT_ACCENT),
            label(0.68f, 0.58f, "5. Reflected bounce", stage = 4, StrokeRole.CORRECTION_HIGHLIGHT),

            // Stage 5: Cast shadow & occlusion
            sphereTone(0.46f, 0.52f, 0.23f, SphereToneMode.CAST_SHADOW, stage = 5),
            boldLine(0.38f, 0.75f, 0.54f, 0.75f, stage = 5, width = 4.4f),
            label(0.68f, 0.84f, "6. Cast shadow + occlusion", stage = 5)
        ),
        comparison = MistakeComparisonSpec(
            title = "Over-Bright Rim & Dark Outline vs. Structured Light",
            wrongLabel = "Glowing Rim + Sticker Outline",
            rightLabel = "Disciplined Shadow Family",
            whyMistakeHappens = "Making reflected light bright white (#1) and wrapping a heavy dark outline around the lit side makes spheres look transparent or flat.",
            howToFix = "Keep reflected light strictly darker than lit halftones (#4), and let the terminator carve the form.",
            wrongElements = listOf(
                oval(0.50f, 0.50f, 0.26f, 0.26f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 4.2f, fillAlpha = 0.18f),
                cubic(p(0.66f, 0.30f), p(0.58f, 0.50f), p(0.42f, 0.68f), p(0.28f, 0.68f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.5f),
                focusRing(0.69f, 0.62f, 0, r = 0.055f, StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("White rim glows + harsh outline")
            ),
            rightElements = listOf(
                oval(0.46f, 0.52f, 0.23f, 0.23f, 0, width = 2.0f),
                sphereTone(0.46f, 0.52f, 0.23f, SphereToneMode.FORM_BASE_AND_CORE, 0),
                sphereTone(0.46f, 0.52f, 0.23f, SphereToneMode.REFLECTED_LIGHT_AND_HIGHLIGHT, 0),
                sphereTone(0.46f, 0.52f, 0.23f, SphereToneMode.CAST_SHADOW, 0),
                rightNote("Subtle #4 bounce + cast anchor")
            )
        )
    ),

    // 15. Cast Shadow Projection
    VisualDemoSpec(
        id = "vis_cast_shadow_edges",
        title = "Cast Shadow Rays & Lost/Found Edges",
        category = VisualCategory.LIGHT_AND_SHADOW,
        worldNumbers = listOf(4, 7),
        skillIds = listOf("sk_cast_shadow", "sk_edge_control"),
        summary = "Project light rays past object corners down to the ground plane and balance sharp contact edges with soft distant falloff.",
        revisitedConcepts = listOf("Cube construction", "5-value hierarchy"),
        stages = listOf(
            ConstructionStage(1, "Place Box & Ground Light Base", "Draw the box form and mark the ground point directly beneath your light source.", "Every cast shadow extends outward from the light source's ground anchor."),
            ConstructionStage(2, "Project Light Rays Over Top Corners", "Extend light rays from the elevated lamp down past the top block corners to the table.", "Where each ray strikes the floor line marks the cast shadow's corner."),
            ConstructionStage(3, "Enclose Ground Cast-Shadow Polygon", "Connect the object's base corners out to the ray-projected shadow corners.", "Keeps shadow angles physically locked to the object's height."),
            ConstructionStage(4, "Fill Shadow & Crisp Base Occlusion", "Darken the shadow polygon cleanly, pressing darkest right against the contact base.", "Ambient occlusion welds objects onto the floor."),
            ConstructionStage(5, "Soften Far Cast Edge & Lit Outline", "Fade the distant shadow tip softly while keeping the base crisp.", "Sharp near / soft far creates natural daylight depth.")
        ),
        elements = listOf(
            poly(p(0.32f, 0.42f), p(0.50f, 0.42f), p(0.50f, 0.80f), p(0.32f, 0.80f), closed = true, width = 2.6f, stage = 0),
            focusRing(0.14f, 0.16f, stage = 0, r = 0.03f, StrokeRole.LIGHT_RAY),
            focusRing(0.14f, 0.80f, stage = 0, r = 0.02f, StrokeRole.AXIS_AND_PLUMB),
            axisLine(0.14f, 0.18f, 0.14f, 0.80f, stage = 0),

            lightRay(0.16f, 0.18f, 0.84f, 0.84f, stage = 1),
            lightRay(0.16f, 0.18f, 0.72f, 0.68f, stage = 1),
            label(0.50f, 0.22f, "2. Rays past top corner -> ground", stage = 1, StrokeRole.LIGHT_RAY),

            poly(p(0.50f, 0.80f), p(0.84f, 0.84f), p(0.72f, 0.68f), p(0.50f, 0.64f), closed = true, role = StrokeRole.SHADING_TONE, width = 2.0f, fillAlpha = 0.25f, stage = 2),

            poly(p(0.50f, 0.80f), p(0.84f, 0.84f), p(0.72f, 0.68f), p(0.50f, 0.64f), closed = true, role = StrokeRole.SHADING_TONE, width = 1.0f, fillAlpha = 0.42f, stage = 3, layer = VisualLayer.SHADING),
            boldLine(0.32f, 0.80f, 0.54f, 0.80f, stage = 3, width = 4.6f),

            label(0.56f, 0.87f, "5. Crisp base -> soft far tip", stage = 4, StrokeRole.CORRECTION_HIGHLIGHT)
        ),
        comparison = MistakeComparisonSpec(
            title = "Random Detached Blob vs. Ray-Projected Shadow",
            wrongLabel = "Flat Floating Oval Blob",
            rightLabel = "Ray-Locked Cast Polygon",
            whyMistakeHappens = "Guessing an arbitrary shadow blob ignoring light height makes objects look pasted onto backgrounds.",
            howToFix = "Project straight rays from your light source past the top corners down to the ground plane.",
            wrongElements = listOf(
                poly(p(0.32f, 0.36f), p(0.56f, 0.36f), p(0.56f, 0.76f), p(0.32f, 0.76f), closed = true, width = 2.6f, stage = 0),
                oval(0.68f, 0.82f, 0.18f, 0.05f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.6f, fillAlpha = 0.30f),
                wrongNote("Detached oval ignores box corners")
            ),
            rightElements = listOf(
                poly(p(0.30f, 0.38f), p(0.48f, 0.38f), p(0.48f, 0.78f), p(0.30f, 0.78f), closed = true, width = 2.6f, stage = 0),
                lightRay(0.14f, 0.16f, 0.84f, 0.80f, 0),
                poly(p(0.48f, 0.78f), p(0.84f, 0.80f), p(0.70f, 0.66f), p(0.48f, 0.64f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.55f, stage = 0),
                boldLine(0.30f, 0.78f, 0.52f, 0.78f, 0, width = 4.2f),
                rightNote("Anchored directly to base corners")
            )
        )
    ),

    // 16. Horizon Line & 1-Point Perspective
    VisualDemoSpec(
        id = "vis_horizon_1pt",
        title = "Horizon Line, Eye Level & 1-Point Perspective",
        category = VisualCategory.PERSPECTIVE,
        worldNumbers = listOf(5, 11),
        skillIds = listOf("sk_1pt_persp"),
        summary = "Understand how the Horizon Line sets eye level and drives whether you see tops or undersides of 1-point boxes.",
        revisitedConcepts = listOf("Cube construction", "Straight ghosted lines"),
        stages = listOf(
            ConstructionStage(1, "Place Horizon Line (Eye Level)", "Draw a true horizontal eye-level line across the frame.", "Everything above this line is seen from underneath; everything below shows its top."),
            ConstructionStage(2, "Place Single Vanishing Point (VP)", "Mark one clear VP dot directly on the Horizon Line.", "Every depth edge parallel to your line of sight aims straight at this dot."),
            ConstructionStage(3, "Draw Flat Front Faces", "Place one box rectangle below the horizon and a second above it.", "In 1-point perspective, front faces stay true flat vertical/horizontal rectangles."),
            ConstructionStage(4, "Project Converging Rays to VP", "Shoot faint construction rays from every front corner straight into VP.", "Notice how bottom-box rays climb up and top-box rays drop down."),
            ConstructionStage(5, "Slice Horizontal & Vertical Back Edges", "Cutoff depth cleanly using strictly horizontal and vertical lines between rays.", "Creates solid 3D boxes above and below eye level."),
            ConstructionStage(6, "Weight Silhouettes & Shade Underside/Side", "Press bold outlines on foreground edges and tone shaded planes.", "Reveals top face below eye level and underside above eye level.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.06f, 0.48f, 0.94f, 0.48f, stage = 0, dashed = false, width = 2.2f),
            label(0.08f, 0.41f, "Horizon (Eye Level)", stage = 0),

            focusRing(0.52f, 0.48f, stage = 1, r = 0.026f, StrokeRole.ANNOTATION_ARROW),
            label(0.55f, 0.41f, "VP", stage = 1, StrokeRole.ANNOTATION_ARROW),

            // Lower box front face + upper box front face
            poly(p(0.12f, 0.60f), p(0.36f, 0.60f), p(0.36f, 0.86f), p(0.12f, 0.86f), closed = true, width = 2.6f, stage = 2),
            poly(p(0.66f, 0.12f), p(0.90f, 0.12f), p(0.90f, 0.34f), p(0.66f, 0.34f), closed = true, width = 2.6f, stage = 2),

            // Rays to VP
            guideLine(0.12f, 0.60f, 0.52f, 0.48f, stage = 3),
            guideLine(0.36f, 0.60f, 0.52f, 0.48f, stage = 3),
            guideLine(0.36f, 0.86f, 0.52f, 0.48f, stage = 3),
            guideLine(0.66f, 0.12f, 0.52f, 0.48f, stage = 3),
            guideLine(0.66f, 0.34f, 0.52f, 0.48f, stage = 3),
            guideLine(0.90f, 0.34f, 0.52f, 0.48f, stage = 3),

            // Slice depth planes
            poly(p(0.12f, 0.60f), p(0.24f, 0.56f), p(0.42f, 0.56f), p(0.36f, 0.60f), closed = true, width = 2.5f, stage = 4),
            poly(p(0.36f, 0.60f), p(0.42f, 0.56f), p(0.42f, 0.74f), p(0.36f, 0.86f), closed = true, width = 2.5f, stage = 4),
            poly(p(0.66f, 0.34f), p(0.90f, 0.34f), p(0.79f, 0.40f), p(0.61f, 0.40f), closed = true, width = 2.5f, stage = 4),
            poly(p(0.66f, 0.12f), p(0.61f, 0.22f), p(0.61f, 0.40f), p(0.66f, 0.34f), closed = true, width = 2.5f, stage = 4),

            poly(p(0.36f, 0.60f), p(0.42f, 0.56f), p(0.42f, 0.74f), p(0.36f, 0.86f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.20f, stage = 5, layer = VisualLayer.SHADING),
            poly(p(0.66f, 0.34f), p(0.90f, 0.34f), p(0.79f, 0.40f), p(0.61f, 0.40f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.28f, stage = 5, layer = VisualLayer.SHADING),
            label(0.10f, 0.89f, "Below horizon: see TOP", stage = 5),
            label(0.58f, 0.04f, "Above horizon: see UNDERSIDE", stage = 5)
        ),
        comparison = MistakeComparisonSpec(
            title = "Broken Eye Level vs. True Horizon Convergence",
            wrongLabel = "Seeing Top Above Eye Level",
            rightLabel = "Converging Correctly to VP",
            whyMistakeHappens = "Drawing every box from an imagined bird's-eye angle even when it sits higher than the Horizon Line.",
            howToFix = "Aim every depth edge strictly to VP; boxes above the Horizon Line automatically show their underside.",
            wrongElements = listOf(
                axisLine(0.06f, 0.62f, 0.94f, 0.62f, 0, dashed = false),
                poly(p(0.30f, 0.22f), p(0.70f, 0.22f), p(0.70f, 0.48f), p(0.30f, 0.48f), closed = true, width = 2.5f, stage = 0),
                poly(p(0.30f, 0.22f), p(0.40f, 0.12f), p(0.80f, 0.12f), p(0.70f, 0.22f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.8f, stage = 0),
                wrongNote("Impossible top visible above horizon!")
            ),
            rightElements = listOf(
                axisLine(0.06f, 0.62f, 0.94f, 0.62f, 0, dashed = false),
                focusRing(0.22f, 0.62f, 0, r = 0.025f, StrokeRole.ANNOTATION_ARROW),
                poly(p(0.46f, 0.16f), p(0.82f, 0.16f), p(0.82f, 0.42f), p(0.46f, 0.42f), closed = true, width = 2.6f, stage = 0),
                poly(p(0.46f, 0.42f), p(0.82f, 0.42f), p(0.68f, 0.49f), p(0.38f, 0.49f), closed = true, role = StrokeRole.CORRECTION_HIGHLIGHT, fillAlpha = 0.18f, width = 2.6f, stage = 0),
                poly(p(0.46f, 0.16f), p(0.38f, 0.26f), p(0.38f, 0.49f), p(0.46f, 0.42f), closed = true, width = 2.4f, stage = 0),
                rightNote("Underside & side converge to VP")
            )
        )
    ),

    // 17. Two-Point Perspective (6 Stages matching Section 2!)
    VisualDemoSpec(
        id = "vis_2pt_perspective",
        title = "Two-Point Perspective Box Construction",
        category = VisualCategory.PERSPECTIVE,
        worldNumbers = listOf(5, 6, 11),
        skillIds = listOf("sk_2pt_persp"),
        summary = "Establish wide vanishing points on the horizon, project converging side faces, add an overlapping box, and avoid fish-eye distortion.",
        revisitedConcepts = listOf("Y-vertex cube", "Horizon line"),
        stages = listOf(
            ConstructionStage(1, "Establish Horizon & Wide Vanishing Points", "Draw the Horizon Line and place VP1 and VP2 near opposite outer edges.", "Wide VP spacing keeps front corners natural (>= 90°) inside your cone of vision."),
            ConstructionStage(2, "Draw Vertical Front Corner Edge", "Place the closest vertical edge cleanly perpendicular to the horizon.", "In 2-point perspective, all verticals stay vertical."),
            ConstructionStage(3, "Draw Converging Construction Lines", "Shoot straight rays from top and bottom of the vertical corner to both VP1 and VP2.", "Left wall converges to VP1; right wall converges to VP2."),
            ConstructionStage(4, "Construct & Close the Box", "Slice left and right vertical edges, then cross top back edges toward opposite VPs.", "Notice how crossing rays automatically locate the exact back corner."),
            ConstructionStage(5, "Add Overlapping Secondary Depth Box", "Build a smaller second box tucked slightly behind using the exact same VP1/VP2.", "Shared horizon & VPs unify an entire street or tabletop."),
            ConstructionStage(6, "Weight Edges & Clean Construction Rays", "Bold front vertical & ground edges and shade the right receding planes.", "Creates immediate architectural depth.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.04f, 0.32f, 0.96f, 0.32f, stage = 0, dashed = false, width = 2.0f),
            focusRing(0.07f, 0.32f, stage = 0, r = 0.025f, StrokeRole.ANNOTATION_ARROW),
            focusRing(0.93f, 0.32f, stage = 0, r = 0.025f, StrokeRole.ANNOTATION_ARROW),
            label(0.05f, 0.22f, "VP1", stage = 0, StrokeRole.ANNOTATION_ARROW),
            label(0.88f, 0.22f, "VP2", stage = 0, StrokeRole.ANNOTATION_ARROW),

            inkLine(0.50f, 0.42f, 0.50f, 0.84f, stage = 1, width = 3.0f),

            guideLine(0.50f, 0.42f, 0.07f, 0.32f, stage = 2),
            guideLine(0.50f, 0.84f, 0.07f, 0.32f, stage = 2),
            guideLine(0.50f, 0.42f, 0.93f, 0.32f, stage = 2),
            guideLine(0.50f, 0.84f, 0.93f, 0.32f, stage = 2),

            inkLine(0.30f, 0.37f, 0.30f, 0.60f, stage = 3, width = 2.6f),
            inkLine(0.70f, 0.37f, 0.70f, 0.61f, stage = 3, width = 2.6f),
            inkLine(0.30f, 0.37f, 0.50f, 0.42f, stage = 3, width = 2.6f),
            inkLine(0.30f, 0.60f, 0.50f, 0.84f, stage = 3, width = 2.6f),
            inkLine(0.70f, 0.37f, 0.50f, 0.42f, stage = 3, width = 2.6f),
            inkLine(0.70f, 0.61f, 0.50f, 0.84f, stage = 3, width = 2.6f),
            guideLine(0.30f, 0.37f, 0.93f, 0.32f, stage = 3),
            guideLine(0.70f, 0.37f, 0.07f, 0.32f, stage = 3),
            inkLine(0.30f, 0.37f, 0.50f, 0.35f, stage = 3, width = 2.4f),
            inkLine(0.70f, 0.37f, 0.50f, 0.35f, stage = 3, width = 2.4f),

            // Secondary behind-left box using same VPs
            poly(p(0.14f, 0.44f), p(0.24f, 0.48f), p(0.24f, 0.72f), p(0.14f, 0.64f), closed = true, width = 2.2f, stage = 4),
            inkLine(0.14f, 0.44f, 0.28f, 0.41f, stage = 4, width = 2.0f),
            inkLine(0.24f, 0.48f, 0.30f, 0.45f, stage = 4, width = 2.0f),

            poly(p(0.50f, 0.42f), p(0.70f, 0.37f), p(0.70f, 0.61f), p(0.50f, 0.84f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.16f, stage = 5, layer = VisualLayer.SHADING),
            boldLine(0.50f, 0.42f, 0.50f, 0.84f, stage = 5, width = 4.0f),
            boldLine(0.30f, 0.60f, 0.50f, 0.84f, stage = 5, width = 4.2f),
            boldLine(0.50f, 0.84f, 0.70f, 0.61f, stage = 5, width = 4.2f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Fish-Eye Close VPs vs. Proper Wide VPs",
            wrongLabel = "Pinched <90° Diamond Corner",
            rightLabel = "Natural Wide VP Spacing",
            whyMistakeHappens = "Putting VP1 and VP2 too close inside the drawing creates severe acute corners (<90°) that look distorted.",
            howToFix = "Push VP1 and VP2 out to the far page margins (or off-page extension tabs) so the bottom corner exceeds 90°.",
            wrongElements = listOf(
                axisLine(0.06f, 0.30f, 0.94f, 0.30f, 0, dashed = false),
                focusRing(0.28f, 0.30f, 0, r = 0.025f, StrokeRole.MISTAKE_HIGHLIGHT),
                focusRing(0.72f, 0.30f, 0, r = 0.025f, StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.50f, 0.42f, 0.50f, 0.84f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                poly(p(0.50f, 0.42f), p(0.36f, 0.36f), p(0.36f, 0.54f), p(0.50f, 0.84f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.6f, stage = 0),
                poly(p(0.50f, 0.42f), p(0.64f, 0.36f), p(0.64f, 0.54f), p(0.50f, 0.84f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.6f, stage = 0),
                wrongNote("VPs too close -> pinched diamond")
            ),
            rightElements = listOf(
                axisLine(0.04f, 0.30f, 0.96f, 0.30f, 0, dashed = false),
                focusRing(0.06f, 0.30f, 0, r = 0.025f, StrokeRole.CORRECTION_HIGHLIGHT),
                focusRing(0.94f, 0.30f, 0, r = 0.025f, StrokeRole.CORRECTION_HIGHLIGHT),
                poly(p(0.50f, 0.44f), p(0.30f, 0.38f), p(0.30f, 0.62f), p(0.50f, 0.82f), closed = true, width = 2.6f, stage = 0),
                poly(p(0.50f, 0.44f), p(0.70f, 0.38f), p(0.70f, 0.62f), p(0.50f, 0.82f), closed = true, width = 2.6f, stage = 0),
                inkLine(0.30f, 0.38f, 0.50f, 0.35f, 0, 2.4f),
                inkLine(0.70f, 0.38f, 0.50f, 0.35f, 0, 2.4f),
                rightNote("Wide VPs -> realistic corner")
            )
        )
    ),

    // 18. 3-Point Perspective & X-Subdivision
    VisualDemoSpec(
        id = "vis_3pt_subdivision",
        title = "3-Point Taper & Perspective X-Subdivision",
        category = VisualCategory.PERSPECTIVE,
        worldNumbers = listOf(5, 11),
        skillIds = listOf("sk_3pt_persp", "sk_persp_div"),
        summary = "Use a 3rd vertical vanishing point for towering heights and diagonal X-crossings to divide bays evenly in depth.",
        revisitedConcepts = listOf("2-point perspective", "Line straightness"),
        stages = listOf(
            ConstructionStage(1, "Place Horizon + Elevated 3rd VP", "Set left/right horizon VPs plus a high zenith VP3 for looking upward.", "Verticals now lean toward VP3 instead of staying strictly parallel."),
            ConstructionStage(2, "Block Tall 3-Point Tower Mass", "Converge both outer left and right edges upward toward the high zenith VP3.", "Immediately conveys towering architectural scale."),
            ConstructionStage(3, "Draw X-Diagonals Across Front Wall", "Connect opposite corners of the left facade to find the true perspective midpoint.", "Perspective centers always sit slightly closer to the far edge than ruler midpoints."),
            ConstructionStage(4, "Mirror Equal Receding Bays", "Drop a vertical center divider through the X intersection and step further toward VP1.", "Notice each receding bay compresses naturally narrower."),
            ConstructionStage(5, "Weight Closest Edge & Clean Rays", "Accentuate foreground edges while leaving construction X-diagonals faint.", "Cleanly spaced windows or fence posts in real space.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.06f, 0.78f, 0.94f, 0.78f, stage = 0, dashed = false),
            focusRing(0.50f, 0.08f, stage = 0, r = 0.025f, StrokeRole.ANNOTATION_ARROW),
            label(0.54f, 0.06f, "VP3 (Zenith)", stage = 0, StrokeRole.ANNOTATION_ARROW),

            poly(p(0.50f, 0.24f), p(0.32f, 0.34f), p(0.24f, 0.84f), p(0.50f, 0.90f), closed = true, width = 2.6f, stage = 1),
            poly(p(0.50f, 0.24f), p(0.68f, 0.34f), p(0.76f, 0.84f), p(0.50f, 0.90f), closed = true, width = 2.6f, stage = 1),
            guideLine(0.24f, 0.84f, 0.50f, 0.08f, stage = 1),
            guideLine(0.76f, 0.84f, 0.50f, 0.08f, stage = 1),

            guideLine(0.24f, 0.84f, 0.50f, 0.24f, stage = 2, role = StrokeRole.AXIS_AND_PLUMB),
            guideLine(0.32f, 0.34f, 0.50f, 0.90f, stage = 2, role = StrokeRole.AXIS_AND_PLUMB),
            focusRing(0.39f, 0.56f, stage = 2, r = 0.025f, StrokeRole.CORRECTION_HIGHLIGHT),
            label(0.08f, 0.16f, "3. X finds perspective center", stage = 2),

            inkLine(0.405f, 0.29f, 0.385f, 0.87f, stage = 3, width = 2.2f, role = StrokeRole.AXIS_AND_PLUMB),
            inkLine(0.34f, 0.325f, 0.295f, 0.855f, stage = 3, width = 2.0f, role = StrokeRole.AXIS_AND_PLUMB),

            boldLine(0.50f, 0.24f, 0.50f, 0.90f, stage = 4, width = 4.0f),
            poly(p(0.50f, 0.24f), p(0.68f, 0.34f), p(0.76f, 0.84f), p(0.50f, 0.90f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.16f, stage = 4, layer = VisualLayer.SHADING)
        ),
        comparison = MistakeComparisonSpec(
            title = "Equal Ruler Spacing vs. Perspective Compression",
            wrongLabel = "Identical Width Fence Bays",
            rightLabel = "X-Method Foreshortened Bays",
            whyMistakeHappens = "Measuring equal centimeters across a receding wall ignores foreshortening, making buildings look warped flat.",
            howToFix = "Use diagonal X-crossings through midpoints so each receding bay compresses progressively narrower toward the VP.",
            wrongElements = listOf(
                poly(p(0.16f, 0.24f), p(0.86f, 0.42f), p(0.86f, 0.68f), p(0.16f, 0.86f), closed = true, width = 2.4f, stage = 0),
                inkLine(0.335f, 0.285f, 0.335f, 0.815f, 0, 2.5f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.51f, 0.33f, 0.51f, 0.77f, 0, 2.5f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.685f, 0.375f, 0.685f, 0.725f, 0, 2.5f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Equal gaps ignore depth!")
            ),
            rightElements = listOf(
                poly(p(0.16f, 0.24f), p(0.86f, 0.42f), p(0.86f, 0.68f), p(0.16f, 0.86f), closed = true, width = 2.4f, stage = 0),
                inkLine(0.43f, 0.31f, 0.43f, 0.79f, 0, 2.4f, role = StrokeRole.CORRECTION_HIGHLIGHT),
                inkLine(0.62f, 0.36f, 0.62f, 0.74f, 0, 2.4f, role = StrokeRole.CORRECTION_HIGHLIGHT),
                inkLine(0.75f, 0.39f, 0.75f, 0.71f, 0, 2.4f, role = StrokeRole.CORRECTION_HIGHLIGHT),
                inkLine(0.82f, 0.41f, 0.82f, 0.69f, 0, 2.4f, role = StrokeRole.CORRECTION_HIGHLIGHT),
                rightNote("Bays compress smoothly to VP")
            )
        )
    )
)
