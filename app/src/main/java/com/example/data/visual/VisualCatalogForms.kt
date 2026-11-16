package com.example.data.visual

import com.example.domain.model.ConstructionStage
import com.example.domain.model.MistakeComparisonSpec
import com.example.domain.model.StrokeRole
import com.example.domain.model.VisualCategory
import com.example.domain.model.VisualDemoSpec
import com.example.domain.model.VisualLayer

internal fun formsVisualDemos(): List<VisualDemoSpec> = listOf(
    // 8. Flat 2D Shapes to 3D Forms
    VisualDemoSpec(
        id = "vis_2d_to_3d",
        title = "From Flat 2D Shapes to 3D Volumes",
        category = VisualCategory.SHAPES_AND_FORMS,
        worldNumbers = listOf(1, 2),
        skillIds = listOf("sk_sight_prop", "sk_cubes"),
        summary = "See how adding a central axis, depth extrusion, and wrapped equator transforms flat 2D symbols into solid 3D forms.",
        revisitedConcepts = listOf("2D envelope silhouettes", "Ellipses"),
        stages = listOf(
            ConstructionStage(1, "Start With Flat 2D Silhouettes", "Place a square, triangle, and circle side by side on the picture plane.", "2D shapes establish flat height and width only."),
            ConstructionStage(2, "Insert Center Axis Lines", "Drop vertical symmetry axes and floor footprints to anchor space.", "Axes prepare a form to rotate and sit on a ground plane."),
            ConstructionStage(3, "Extrude Into Depth Planes", "Add a receding side plane to the square and elliptical bases to triangle & circle.", "Depth planes break the flat paper boundary."),
            ConstructionStage(4, "Wrap Surface Equators", "Curve an equator ellipse across the sphere and round base arcs.", "Wrapped bands prove the surface curves toward and away from you."),
            ConstructionStage(5, "Weight Bases & Lightly Shade Side Planes", "Darken shadow sides subtly and press ground contact lines firmly.", "Completes the shift from flat diagram to dimensional solid.", isCleanupStage = true)
        ),
        elements = listOf(
            poly(p(0.08f, 0.34f), p(0.28f, 0.34f), p(0.28f, 0.72f), p(0.08f, 0.72f), closed = true, width = 2.4f, stage = 0),
            poly(p(0.50f, 0.24f), p(0.39f, 0.72f), p(0.61f, 0.72f), closed = true, width = 2.4f, stage = 0),
            oval(0.81f, 0.50f, 0.13f, 0.20f, stage = 0, width = 2.4f),
            label(0.08f, 0.08f, "1. Flat 2D shapes: Square, Triangle, Circle", stage = 0),

            axisLine(0.50f, 0.18f, 0.50f, 0.80f, stage = 1),
            axisLine(0.81f, 0.24f, 0.81f, 0.76f, stage = 1),

            poly(p(0.08f, 0.34f), p(0.16f, 0.24f), p(0.35f, 0.24f), p(0.28f, 0.34f), closed = true, role = StrokeRole.PRIMARY_CONTOUR, width = 2.3f, stage = 2),
            poly(p(0.28f, 0.34f), p(0.35f, 0.24f), p(0.35f, 0.62f), p(0.28f, 0.72f), closed = true, role = StrokeRole.PRIMARY_CONTOUR, width = 2.3f, fillAlpha = 0.14f, stage = 2),
            oval(0.50f, 0.72f, 0.11f, 0.055f, stage = 2, width = 2.3f),

            oval(0.81f, 0.50f, 0.13f, 0.05f, stage = 3, role = StrokeRole.AXIS_AND_PLUMB, width = 2.2f),
            label(0.69f, 0.78f, "4. Equator wrap", stage = 3),

            boldLine(0.08f, 0.72f, 0.28f, 0.72f, stage = 4, width = 3.8f),
            boldLine(0.28f, 0.72f, 0.35f, 0.62f, stage = 4, width = 3.6f),
            oval(0.50f, 0.72f, 0.11f, 0.055f, stage = 4, role = StrokeRole.LINE_WEIGHT_ACCENT, width = 3.4f, startAngle = 10f, sweepAngle = 160f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat 2D Sticker vs. 3D Volume Construction",
            wrongLabel = "Flat 2D Circle + Triangle",
            rightLabel = "Axis + Ellipse 3D Cone",
            whyMistakeHappens = "Drawing cones or cylinders with flat straight horizontal bottom lines ignores camera perspective.",
            howToFix = "Always replace flat base lines with a full horizontal ellipse centered on a vertical axis.",
            wrongElements = listOf(
                poly(p(0.50f, 0.20f), p(0.24f, 0.76f), p(0.76f, 0.76f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 3.0f, stage = 0),
                focusRing(0.50f, 0.76f, 0, r = 0.06f, StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Flat horizontal base")
            ),
            rightElements = listOf(
                axisLine(0.50f, 0.14f, 0.50f, 0.84f, 0),
                oval(0.50f, 0.74f, 0.26f, 0.08f, 0, width = 2.8f),
                inkLine(0.50f, 0.20f, 0.24f, 0.74f, 0, width = 2.8f),
                inkLine(0.50f, 0.20f, 0.76f, 0.74f, 0, width = 2.8f),
                rightNote("Round ellipse sits in space")
            )
        )
    ),

    // 9. Cube Construction (6 Stages matching Section 2 exactly!)
    VisualDemoSpec(
        id = "vis_cube_construction",
        title = "Constructing a 3D Cube (6 Stages)",
        category = VisualCategory.SHAPES_AND_FORMS,
        worldNumbers = listOf(2, 5),
        skillIds = listOf("sk_cubes"),
        summary = "Build solid rotating cubes from a front Y-vertex, converging depth rays, draw-through verification, cleanup, and plane shading.",
        revisitedConcepts = listOf("Dot-to-dot ghosting", "Angle sighting"),
        stages = listOf(
            ConstructionStage(1, "Establish Initial Vertical Edge & Y-Vertex", "Draw the closest vertical corner edge, then angle two bottom edges upward to form a Y.", "Keep all three Y-angles wider than 90° to prevent boxy distortion."),
            ConstructionStage(2, "Add Diagonal Edges to Establish Depth", "Extend upper receding depth edges converging gently toward the side vanishing directions.", "Edges traveling away from your eye must converge slightly—never flare wider."),
            ConstructionStage(3, "Connect Corresponding Corners", "Drop the left and right vertical edges and join back top edges to enclose the visible cube faces.", "Check that vertical edges stay crisp and parallel."),
            ConstructionStage(4, "Reveal Hidden Back Edges (Draw-Through)", "Sketch the three internal hidden edges lightly dashed so you verify the interior corner meets cleanly.", "Drawing through guarantees a solid 3D volume instead of three flat stickers."),
            ConstructionStage(5, "Clean Up Construction Lines", "Soften overshoot rays and internal X-ray lines while preserving crisp visible edges.", "Leaves the surface clean for final line weight and tone.", isCleanupStage = true),
            ConstructionStage(6, "Add Line Weight & Plane Shading", "Bold the outer silhouette & ground edges and hatch the right side plane away from top-left light.", "Separates planes instantly via value and line thickness.")
        ),
        elements = listOf(
            // Stage 0: Y-Vertex
            inkLine(0.50f, 0.42f, 0.50f, 0.80f, stage = 0, width = 3.0f),
            inkLine(0.50f, 0.42f, 0.26f, 0.30f, stage = 0, width = 2.6f),
            inkLine(0.50f, 0.42f, 0.74f, 0.31f, stage = 0, width = 2.6f),
            focusRing(0.50f, 0.42f, stage = 0, r = 0.036f, StrokeRole.ANNOTATION_ARROW),
            label(0.54f, 0.41f, "1. Front Y-vertex (>90°)", stage = 0, StrokeRole.ANNOTATION_ARROW),

            // Stage 1: Diagonal depth edges (bottom & back top converging)
            guideLine(0.26f, 0.30f, 0.18f, 0.26f, stage = 1),
            guideLine(0.74f, 0.31f, 0.82f, 0.27f, stage = 1),
            inkLine(0.50f, 0.80f, 0.28f, 0.66f, stage = 1, width = 2.6f),
            inkLine(0.50f, 0.80f, 0.72f, 0.67f, stage = 1, width = 2.6f),
            arrowLine(0.24f, 0.76f, 0.14f, 0.68f, stage = 1),
            label(0.08f, 0.84f, "2. Depth edges converge gently", stage = 1),

            // Stage 2: Connect outer corners
            inkLine(0.26f, 0.30f, 0.28f, 0.66f, stage = 2, width = 2.6f),
            inkLine(0.74f, 0.31f, 0.72f, 0.67f, stage = 2, width = 2.6f),
            inkLine(0.26f, 0.30f, 0.50f, 0.20f, stage = 2, width = 2.6f),
            inkLine(0.74f, 0.31f, 0.50f, 0.20f, stage = 2, width = 2.6f),

            // Stage 3: Hidden internal back edges
            axisLine(0.50f, 0.20f, 0.50f, 0.56f, stage = 3, dashed = true, width = 2.0f),
            axisLine(0.28f, 0.66f, 0.50f, 0.56f, stage = 3, dashed = true, width = 2.0f),
            axisLine(0.72f, 0.67f, 0.50f, 0.56f, stage = 3, dashed = true, width = 2.0f),
            focusRing(0.50f, 0.56f, stage = 3, r = 0.025f, StrokeRole.AXIS_AND_PLUMB),
            label(0.55f, 0.54f, "4. Hidden back corner", stage = 3),

            // Stage 4: Cleanup / highlight visible contours cleanly
            inkLine(0.26f, 0.30f, 0.50f, 0.42f, stage = 4, width = 2.8f),
            inkLine(0.74f, 0.31f, 0.50f, 0.42f, stage = 4, width = 2.8f),
            label(0.10f, 0.08f, "5. Trim overshoot & lock visible seams", stage = 4, StrokeRole.CORRECTION_HIGHLIGHT),

            // Stage 5: Weight & right-plane shading
            poly(p(0.50f, 0.42f), p(0.74f, 0.31f), p(0.72f, 0.67f), p(0.50f, 0.80f), closed = true, role = StrokeRole.SHADING_TONE, width = 1.0f, fillAlpha = 0.16f, stage = 5, layer = VisualLayer.SHADING),
            hatch(
                listOf(
                    p(0.53f, 0.44f) to p(0.53f, 0.76f),
                    p(0.57f, 0.42f) to p(0.57f, 0.73f),
                    p(0.61f, 0.40f) to p(0.61f, 0.71f),
                    p(0.65f, 0.38f) to p(0.65f, 0.69f),
                    p(0.69f, 0.36f) to p(0.69f, 0.67f)
                ),
                stage = 5
            ),
            boldLine(0.28f, 0.66f, 0.50f, 0.80f, stage = 5, width = 4.2f),
            boldLine(0.50f, 0.80f, 0.72f, 0.67f, stage = 5, width = 4.2f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Diverging Back Edges vs. Converging Cube",
            wrongLabel = "Reverse Perspective Flare",
            rightLabel = "Converging Edges",
            whyMistakeHappens = "Making back planes wider than the front edge makes cubes feel warped or inverted.",
            howToFix = "Aim every receding edge slightly closer together as it travels away from the front vertical corner.",
            wrongElements = listOf(
                inkLine(0.50f, 0.40f, 0.50f, 0.78f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.50f, 0.40f, 0.22f, 0.20f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.50f, 0.78f, 0.18f, 0.68f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.22f, 0.20f, 0.18f, 0.68f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.50f, 0.40f, 0.78f, 0.22f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.50f, 0.78f, 0.82f, 0.70f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.78f, 0.22f, 0.82f, 0.70f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Back edge taller than front!")
            ),
            rightElements = listOf(
                inkLine(0.50f, 0.42f, 0.50f, 0.80f, 0, 3.0f),
                inkLine(0.50f, 0.42f, 0.26f, 0.30f, 0, 2.6f),
                inkLine(0.50f, 0.80f, 0.28f, 0.66f, 0, 2.6f),
                inkLine(0.26f, 0.30f, 0.28f, 0.66f, 0, 2.6f),
                inkLine(0.50f, 0.42f, 0.74f, 0.31f, 0, 2.6f),
                inkLine(0.50f, 0.80f, 0.72f, 0.67f, 0, 2.6f),
                inkLine(0.74f, 0.31f, 0.72f, 0.67f, 0, 2.6f),
                inkLine(0.26f, 0.30f, 0.50f, 0.20f, 0, 2.4f),
                inkLine(0.74f, 0.31f, 0.50f, 0.20f, 0, 2.4f),
                rightNote("Back edges shrink subtly")
            )
        )
    ),

    // 10. Cylinder & Ellipse Viewing Angles (6 Stages matching Section 2!)
    VisualDemoSpec(
        id = "vis_cylinder_construction",
        title = "Cylinder Construction & Viewing Angles",
        category = VisualCategory.SHAPES_AND_FORMS,
        worldNumbers = listOf(2, 6),
        skillIds = listOf("sk_spheres_cyl"),
        summary = "Build upright cylinders along a central minor axis and understand how ellipse fullness changes with eye level.",
        revisitedConcepts = listOf("Rounded ellipse ends", "Plumb axis"),
        stages = listOf(
            ConstructionStage(1, "Draw Central Minor Axis", "Establish a straight spine line running vertically down the cylinder's center.", "The minor axis guarantees top and bottom ellipses share identical tilt."),
            ConstructionStage(2, "Construct Top Ellipse Perpendicular (90°)", "Wrap a crisp ellipse centered symmetrically around the minor axis.", "At high eye level, the top rim stays narrow."),
            ConstructionStage(3, "Extend Parallel Side Tangents", "Drop straight side walls cleanly from the widest left and right edge points of the top ellipse.", "Sides must touch the curved rim smoothly—no corner notches."),
            ConstructionStage(4, "Construct Wider Bottom Ellipse", "Draw the base ellipse noticeably taller/rounder than the top ellipse.", "Because the base sits further below your eye level, you see deeper into its circle."),
            ConstructionStage(5, "Show Eye-Level Degree Progression", "Compare a flat eye-level rim against a wide low ellipse on the right reference bar.", "Higher distance from eye level = fuller degree ellipse."),
            ConstructionStage(6, "Add Core Form Shading & Ground Anchor", "Shade the cylinder's turning shadow band cleanly and weight the front base curve.", "Curved shadow follows the vertical side walls.", isCleanupStage = true)
        ),
        elements = listOf(
            // Stage 0: Minor axis
            axisLine(0.36f, 0.12f, 0.36f, 0.90f, stage = 0),
            label(0.10f, 0.05f, "1. Central minor axis", stage = 0),

            // Stage 1: Narrow top ellipse
            axisLine(0.18f, 0.24f, 0.54f, 0.24f, stage = 1, dashed = true, width = 1.5f),
            oval(0.36f, 0.24f, 0.16f, 0.048f, stage = 1, width = 2.8f),
            focusRing(0.36f, 0.24f, stage = 1, r = 0.022f, StrokeRole.CORRECTION_HIGHLIGHT),

            // Stage 2: Side tangent walls
            inkLine(0.20f, 0.24f, 0.20f, 0.76f, stage = 2, width = 2.8f),
            inkLine(0.52f, 0.24f, 0.52f, 0.76f, stage = 2, width = 2.8f),

            // Stage 3: Wider bottom ellipse (back half dashed)
            oval(0.36f, 0.76f, 0.16f, 0.095f, stage = 3, width = 2.8f, startAngle = 0f, sweepAngle = 180f),
            oval(0.36f, 0.76f, 0.16f, 0.095f, stage = 3, width = 2.0f, dashed = true, startAngle = 180f, sweepAngle = 180f, layer = VisualLayer.STRUCTURE),
            label(0.10f, 0.89f, "4. Base ellipse is rounder (further below eye)", stage = 3),

            // Stage 4: Right-side viewing position diagram
            axisLine(0.64f, 0.18f, 0.94f, 0.18f, stage = 4, dashed = false, width = 1.8f),
            label(0.66f, 0.11f, "Eye Level (Flat)", stage = 4, StrokeRole.ANNOTATION_ARROW),
            oval(0.79f, 0.24f, 0.10f, 0.018f, stage = 4, role = StrokeRole.AXIS_AND_PLUMB, width = 2.0f),
            oval(0.79f, 0.48f, 0.10f, 0.048f, stage = 4, role = StrokeRole.AXIS_AND_PLUMB, width = 2.0f),
            oval(0.79f, 0.74f, 0.10f, 0.082f, stage = 4, role = StrokeRole.AXIS_AND_PLUMB, width = 2.0f),
            arrowLine(0.91f, 0.26f, 0.91f, 0.74f, stage = 4),

            // Stage 5: Core shading & front base weight
            hatch(
                listOf(
                    p(0.41f, 0.28f) to p(0.41f, 0.83f),
                    p(0.44f, 0.28f) to p(0.44f, 0.82f),
                    p(0.47f, 0.27f) to p(0.47f, 0.80f),
                    p(0.50f, 0.26f) to p(0.50f, 0.77f)
                ),
                stage = 5
            ),
            oval(0.36f, 0.76f, 0.16f, 0.095f, stage = 5, role = StrokeRole.LINE_WEIGHT_ACCENT, width = 3.8f, startAngle = 10f, sweepAngle = 160f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Identical Flat Ellipses vs. Progressive Depth",
            wrongLabel = "Flat Bottom / Skewed Axis",
            rightLabel = "Wider Bottom + 90° Axis",
            whyMistakeHappens = "Drawing the bottom of a cup narrower or flatter than the top makes the form look pinched or inverted.",
            howToFix = "Check that the ellipse farther from eye level opens wider, and keep every ellipse 90° to the minor axis.",
            wrongElements = listOf(
                oval(0.50f, 0.24f, 0.24f, 0.09f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.8f),
                inkLine(0.26f, 0.24f, 0.26f, 0.78f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.74f, 0.24f, 0.74f, 0.78f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.26f, 0.78f, 0.74f, 0.78f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                focusRing(0.50f, 0.78f, 0, r = 0.06f, StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Flat straight bottom line")
            ),
            rightElements = listOf(
                axisLine(0.50f, 0.12f, 0.50f, 0.88f, 0),
                oval(0.50f, 0.24f, 0.24f, 0.055f, 0, width = 2.8f),
                inkLine(0.26f, 0.24f, 0.26f, 0.74f, 0, 2.8f),
                inkLine(0.74f, 0.24f, 0.74f, 0.74f, 0, 2.8f),
                oval(0.50f, 0.74f, 0.24f, 0.11f, 0, width = 2.8f, startAngle = 0f, sweepAngle = 180f),
                oval(0.50f, 0.74f, 0.24f, 0.11f, 0, width = 1.8f, dashed = true, startAngle = 180f, sweepAngle = 180f, layer = VisualLayer.STRUCTURE),
                rightNote("Base opens wider than rim")
            )
        )
    ),

    // 11. Cones & Wrapping Cross-Contours
    VisualDemoSpec(
        id = "vis_cone_cross_contour",
        title = "Cones & Wrapping Cross-Contours",
        category = VisualCategory.SHAPES_AND_FORMS,
        worldNumbers = listOf(2, 9),
        skillIds = listOf("sk_cross_contour"),
        summary = "Hook cross-contour ellipses around curved silhouettes so flat organic shapes suddenly turn in 3D space.",
        revisitedConcepts = listOf("Ellipses", "Continuous contours"),
        stages = listOf(
            ConstructionStage(1, "Plot Base Ellipse & Central Axis", "Establish an organic silhouette or cone base ellipse and spine axis.", "Sets the directional flow of the volume."),
            ConstructionStage(2, "Connect Outer Profile Silhouette", "Draw the tapering cone walls or curved bean contour cleanly.", "Keeps the volume contained before wrapping surfaces."),
            ConstructionStage(3, "Wrap Curved Cross-Contour Arcs", "Trace surface bands arching toward you across the middle of the form.", "Think of wrapping rubber bands around an apple or arm."),
            ConstructionStage(4, "Hook Arcs Sharply at Silhouette Edges", "Bend each cross-contour sharply backward right as it reaches the outer boundary.", "This subtle edge hook is what sells true 3D roundness."),
            ConstructionStage(5, "Weight Turning Overlap & Clean", "Reinforce foreground edge weight and lighten hidden back ticks.", "Gives immediate sculptural volume without shading.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.24f, 0.14f, 0.24f, 0.82f, stage = 0),
            oval(0.24f, 0.76f, 0.14f, 0.065f, stage = 0, width = 2.4f),
            cubic(p(0.46f, 0.56f), p(0.52f, 0.34f), p(0.76f, 0.30f), p(0.88f, 0.56f), stage = 0, role = StrokeRole.AXIS_AND_PLUMB, width = 1.8f, dashed = true, layer = VisualLayer.STRUCTURE),

            inkLine(0.24f, 0.18f, 0.10f, 0.76f, stage = 1, width = 2.8f),
            inkLine(0.24f, 0.18f, 0.38f, 0.76f, stage = 1, width = 2.8f),
            cubic(p(0.46f, 0.62f), p(0.46f, 0.24f), p(0.76f, 0.22f), p(0.88f, 0.44f), stage = 1, width = 2.8f),
            cubic(p(0.88f, 0.44f), p(0.94f, 0.72f), p(0.68f, 0.84f), p(0.46f, 0.62f), stage = 1, width = 2.8f),

            quad(p(0.16f, 0.48f), p(0.24f, 0.56f), p(0.32f, 0.48f), stage = 2, role = StrokeRole.AXIS_AND_PLUMB, width = 2.2f),
            quad(p(0.52f, 0.36f), p(0.58f, 0.52f), p(0.52f, 0.68f), stage = 2, role = StrokeRole.AXIS_AND_PLUMB, width = 2.2f),
            quad(p(0.64f, 0.31f), p(0.72f, 0.52f), p(0.64f, 0.74f), stage = 2, role = StrokeRole.AXIS_AND_PLUMB, width = 2.2f),
            quad(p(0.77f, 0.34f), p(0.85f, 0.54f), p(0.77f, 0.74f), stage = 2, role = StrokeRole.AXIS_AND_PLUMB, width = 2.2f),

            focusRing(0.52f, 0.36f, stage = 3, r = 0.028f, StrokeRole.ANNOTATION_ARROW),
            focusRing(0.64f, 0.74f, stage = 3, r = 0.028f, StrokeRole.ANNOTATION_ARROW),
            label(0.44f, 0.10f, "4. Hook rings sharply at outer edge", stage = 3, StrokeRole.ANNOTATION_ARROW),

            boldLine(0.10f, 0.76f, 0.12f, 0.78f, stage = 4, width = 3.2f),
            oval(0.24f, 0.76f, 0.14f, 0.065f, stage = 4, role = StrokeRole.LINE_WEIGHT_ACCENT, width = 3.4f, startAngle = 10f, sweepAngle = 160f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Bracelet Stripes vs. Wrapping Cross-Contours",
            wrongLabel = "Straight Flat Stripes",
            rightLabel = "Hooked 3D Volume Arcs",
            whyMistakeHappens = "Drawing straight ruler lines across a rounded limb or bottle immediately flattens the 3D surface.",
            howToFix = "Curve cross-contours strongly across the front and hook each end back around the edge silhouette.",
            wrongElements = listOf(
                inkLine(0.26f, 0.20f, 0.26f, 0.80f, 0, 2.8f),
                inkLine(0.74f, 0.20f, 0.74f, 0.80f, 0, 2.8f),
                inkLine(0.26f, 0.36f, 0.74f, 0.36f, 0, 2.4f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.26f, 0.52f, 0.74f, 0.52f, 0, 2.4f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.26f, 0.68f, 0.74f, 0.68f, 0, 2.4f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Flat 2D ladder bars")
            ),
            rightElements = listOf(
                inkLine(0.26f, 0.20f, 0.26f, 0.80f, 0, 2.8f),
                inkLine(0.74f, 0.20f, 0.74f, 0.80f, 0, 2.8f),
                quad(p(0.26f, 0.35f), p(0.50f, 0.47f), p(0.74f, 0.35f), 0, StrokeRole.CORRECTION_HIGHLIGHT, 2.4f),
                quad(p(0.26f, 0.52f), p(0.50f, 0.64f), p(0.74f, 0.52f), 0, StrokeRole.CORRECTION_HIGHLIGHT, 2.4f),
                quad(p(0.26f, 0.69f), p(0.50f, 0.81f), p(0.74f, 0.69f), 0, StrokeRole.CORRECTION_HIGHLIGHT, 2.4f),
                rightNote("Curved wrap shows round tube")
            )
        )
    ),

    // 12. Rotating Geometric Forms & Intersections
    VisualDemoSpec(
        id = "vis_form_intersections",
        title = "Rotating Forms & Surface Intersections",
        category = VisualCategory.SHAPES_AND_FORMS,
        worldNumbers = listOf(2, 12),
        skillIds = listOf("sk_form_intersect"),
        summary = "Join two 3D primitives cleanly by drawing through transparently and curving the collision seam.",
        revisitedConcepts = listOf("Cube Y-vertex", "Sphere equator"),
        stages = listOf(
            ConstructionStage(1, "Place Primary Cube Transparently", "Construct a 3D box first so you know its top plane orientation.", "Intersections require knowing the exact angle of the pierced surface."),
            ConstructionStage(2, "Embed Intersecting Sphere / Cylinder", "Draw the full sphere piercing the top-right corner of the box.", "Draw through hidden overlap zones lightly to find the true slice."),
            ConstructionStage(3, "Plot Curved Intersection Seam", "Trace the curved ellipse arc where the sphere meets the flat top plane.", "Flat plane + curved sphere = crisp elliptical seam."),
            ConstructionStage(4, "Remove Hidden Occluded Lines", "Clean away hidden interior cube edges that sit behind the foreground sphere.", "Creates immediate solid spatial overlap.", isCleanupStage = true),
            ConstructionStage(5, "Weight the Collision Crease", "Darken the intersection seam and front silhouette cleanly.", "Heavy crease lines sell tight physical interlocking.")
        ),
        elements = listOf(
            // Cube base (left/center)
            poly(p(0.16f, 0.44f), p(0.46f, 0.34f), p(0.74f, 0.44f), p(0.44f, 0.56f), closed = true, width = 2.4f, stage = 0),
            inkLine(0.16f, 0.44f, 0.18f, 0.78f, stage = 0, width = 2.4f),
            inkLine(0.44f, 0.56f, 0.44f, 0.88f, stage = 0, width = 2.4f),
            inkLine(0.74f, 0.44f, 0.72f, 0.78f, stage = 0, width = 2.4f),
            inkLine(0.18f, 0.78f, 0.44f, 0.88f, stage = 0, width = 2.4f),
            inkLine(0.44f, 0.88f, 0.72f, 0.78f, stage = 0, width = 2.4f),

            // Sphere piercing top-right face
            oval(0.58f, 0.38f, 0.19f, 0.19f, stage = 1, width = 2.6f),
            oval(0.58f, 0.38f, 0.19f, 0.06f, stage = 1, role = StrokeRole.CONSTRUCTION_GUIDE, width = 1.8f, dashed = true, layer = VisualLayer.GUIDE),

            // Curved intersection seam where sphere pierces top plane
            quad(p(0.41f, 0.44f), p(0.58f, 0.54f), p(0.73f, 0.43f), stage = 2, role = StrokeRole.ANNOTATION_ARROW, width = 3.2f, layer = VisualLayer.CONTOUR),
            focusRing(0.58f, 0.49f, stage = 2, r = 0.030f, StrokeRole.ANNOTATION_ARROW),
            label(0.12f, 0.10f, "3. Seam curves along top plane angle", stage = 2, StrokeRole.ANNOTATION_ARROW),

            label(0.12f, 0.89f, "4. Occluded back lines fade away", stage = 3, StrokeRole.CORRECTION_HIGHLIGHT),

            boldLine(0.18f, 0.78f, 0.44f, 0.88f, stage = 4, width = 4.0f),
            boldLine(0.44f, 0.88f, 0.72f, 0.78f, stage = 4, width = 4.0f),
            quad(p(0.41f, 0.44f), p(0.58f, 0.54f), p(0.73f, 0.43f), stage = 4, role = StrokeRole.LINE_WEIGHT_ACCENT, width = 3.8f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Sticker Touch vs. True 3D Seam",
            wrongLabel = "Flat Straight Line Overlap",
            rightLabel = "Curved Intersection Seam",
            whyMistakeHappens = "Leaving a straight box edge running flat across a round sphere makes them look pasted flat.",
            howToFix = "Bend the intersection seam smoothly around the pierced object's surface curvature.",
            wrongElements = listOf(
                poly(p(0.16f, 0.52f), p(0.84f, 0.52f), p(0.84f, 0.84f), p(0.16f, 0.84f), closed = true, width = 2.6f, stage = 0),
                oval(0.54f, 0.44f, 0.22f, 0.22f, 0, width = 2.6f),
                inkLine(0.32f, 0.52f, 0.76f, 0.52f, 0, 3.2f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Straight line ignores sphere curve")
            ),
            rightElements = listOf(
                poly(p(0.16f, 0.52f), p(0.84f, 0.52f), p(0.84f, 0.84f), p(0.16f, 0.84f), closed = true, width = 2.4f, stage = 0),
                oval(0.54f, 0.42f, 0.22f, 0.22f, 0, width = 2.6f),
                quad(p(0.33f, 0.49f), p(0.54f, 0.62f), p(0.75f, 0.49f), 0, StrokeRole.CORRECTION_HIGHLIGHT, 3.4f),
                rightNote("Curved seam hugs surface")
            )
        )
    )
)
