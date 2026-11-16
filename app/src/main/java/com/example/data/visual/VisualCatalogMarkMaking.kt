package com.example.data.visual

import com.example.domain.model.ConstructionStage
import com.example.domain.model.MistakeComparisonSpec
import com.example.domain.model.StrokeRole
import com.example.domain.model.VisualCategory
import com.example.domain.model.VisualDemoSpec
import com.example.domain.model.VisualLayer

internal fun markMakingVisualDemos(): List<VisualDemoSpec> = listOf(
    // 1. Confident Lines
    VisualDemoSpec(
        id = "vis_confident_lines",
        title = "Confident Ghosted Lines",
        category = VisualCategory.BASIC_MARK_MAKING,
        worldNumbers = listOf(1, 3),
        skillIds = listOf("sk_stroke_conf"),
        summary = "Replace hesitant wrist flicks with plotted endpoints, shoulder ghosting, and one smooth stroke.",
        stages = listOf(
            ConstructionStage(1, "Plot Start & End Points", "Mark light dots before drawing so your eye already knows the destination.", "Focus on the end dot, not your pencil tip."),
            ConstructionStage(2, "Ghost From the Shoulder", "Hover 2 mm above the page 3 times along the path to calibrate arm muscle memory.", "Lock wrist and fingers; swing from the shoulder joint."),
            ConstructionStage(3, "Pull One Light Stroke", "Drop the pencil cleanly onto dot A and glide smoothly through dot B in one pass.", "Steady medium speed beats slow trembling."),
            ConstructionStage(4, "Add Weight Variations", "Practice whisper-light construction strokes above and bold dark accent strokes below.", "Vary downward shoulder pressure while staying straight."),
            ConstructionStage(5, "Verify Parallel Alignment", "Stack parallel rows checking uniform gap spacing and clean, un-hooked ends.", "Lift cleanly off the page at the target dot.", isCleanupStage = true)
        ),
        elements = listOf(
            focusRing(0.12f, 0.24f, stage = 0, r = 0.020f),
            focusRing(0.84f, 0.24f, stage = 0, r = 0.020f),
            focusRing(0.12f, 0.45f, stage = 0, r = 0.020f),
            focusRing(0.84f, 0.45f, stage = 0, r = 0.020f),
            label(0.12f, 0.11f, "1. Plot A -> B dots first", stage = 0, StrokeRole.ANNOTATION_ARROW),

            guideLine(0.12f, 0.24f, 0.84f, 0.24f, stage = 1, dashed = true, arrowEnd = true),
            arrowLine(0.32f, 0.18f, 0.62f, 0.18f, stage = 1),
            label(0.28f, 0.30f, "2. Hover & ghost 3x (shoulder swing)", stage = 1),

            inkLine(0.12f, 0.45f, 0.84f, 0.45f, stage = 2, width = 2.4f),
            label(0.14f, 0.50f, "3. One fluid stroke", stage = 2),

            inkLine(0.12f, 0.63f, 0.84f, 0.63f, stage = 3, width = 1.6f),
            boldLine(0.12f, 0.78f, 0.84f, 0.78f, stage = 3, width = 4.6f),
            label(0.14f, 0.67f, "4. Light guide (2H) vs Bold foreground (2B)", stage = 3, StrokeRole.LINE_WEIGHT_ACCENT),

            axisLine(0.12f, 0.18f, 0.12f, 0.84f, stage = 4, dashed = true, width = 1.5f),
            axisLine(0.84f, 0.18f, 0.84f, 0.84f, stage = 4, dashed = true, width = 1.5f),
            label(0.16f, 0.87f, "5. Crisp vertical alignment at start & stop", stage = 4, StrokeRole.CORRECTION_HIGHLIGHT)
        ),
        comparison = MistakeComparisonSpec(
            title = "Chicken-Scratching vs. Confident Stroke",
            wrongLabel = "Hesitant Wrist Ticks",
            rightLabel = "Plotted Shoulder Stroke",
            whyMistakeHappens = "Flexing only your fingers limits reach to ~3 cm, forcing overlapping hairy dashes.",
            howToFix = "Plot both dots, look at the destination dot, ghost 3 passes from the shoulder, and pull once.",
            wrongElements = listOf(
                inkLine(0.08f, 0.48f, 0.24f, 0.43f, 0, width = 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.18f, 0.50f, 0.38f, 0.46f, 0, width = 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.32f, 0.44f, 0.52f, 0.51f, 0, width = 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.46f, 0.53f, 0.68f, 0.45f, 0, width = 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.60f, 0.43f, 0.88f, 0.49f, 0, width = 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                focusRing(0.48f, 0.48f, 0, r = 0.08f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Furry overlapping segments")
            ),
            rightElements = listOf(
                focusRing(0.10f, 0.48f, 0, r = 0.025f, role = StrokeRole.CORRECTION_HIGHLIGHT),
                focusRing(0.88f, 0.48f, 0, r = 0.025f, role = StrokeRole.CORRECTION_HIGHLIGHT),
                guideLine(0.10f, 0.36f, 0.88f, 0.36f, 0, arrowEnd = true, role = StrokeRole.AXIS_AND_PLUMB),
                inkLine(0.10f, 0.48f, 0.88f, 0.48f, 0, width = 3.2f, role = StrokeRole.PRIMARY_CONTOUR),
                rightNote("1 clean shoulder pull")
            )
        )
    ),

    // 2. Straight & Curved Lines (C-Curves & S-Curves)
    VisualDemoSpec(
        id = "vis_curves_s_curves",
        title = "C-Curves, S-Curves & Trajectory",
        category = VisualCategory.BASIC_MARK_MAKING,
        worldNumbers = listOf(1, 3),
        skillIds = listOf("sk_stroke_conf"),
        summary = "Anchor curves to a straight chord baseline and mark the peak bow before sweeping.",
        revisitedConcepts = listOf("Endpoint dots", "Shoulder ghosting"),
        stages = listOf(
            ConstructionStage(1, "Draw Straight Chord Axis", "Connect the start and end points with a faint straight reference line.", "Curves become predictable when measured against a straight chord."),
            ConstructionStage(2, "Mark Peak Bow Distance", "Place a subtle apex tick showing how far the curve swells away from the axis.", "Controls symmetry and prevents unexpected flattening."),
            ConstructionStage(3, "Sweep Smooth C-Curve", "Ghost the arc twice, then pull a clean C-curve grazing the apex tick.", "Rotate the sketchbook page so your arm pulls naturally inward."),
            ConstructionStage(4, "Add S-Curve Inflection Point", "Cross the straight axis smoothly at the midpoint to reverse curvature.", "One fluid motion connects convex and concave halves."),
            ConstructionStage(5, "Refine & Taper Flow", "Clean construction ticks and reinforce directional rhythm.", "Thicken the swell apex slightly for organic volume.", isCleanupStage = true)
        ),
        elements = listOf(
            guideLine(0.12f, 0.34f, 0.86f, 0.34f, stage = 0),
            guideLine(0.12f, 0.72f, 0.86f, 0.72f, stage = 0),
            label(0.12f, 0.12f, "1. Straight chord baselines", stage = 0),

            focusRing(0.49f, 0.18f, stage = 1, r = 0.020f),
            focusRing(0.32f, 0.56f, stage = 1, r = 0.020f),
            focusRing(0.68f, 0.86f, stage = 1, r = 0.020f),
            label(0.54f, 0.14f, "2. Apex distance ticks", stage = 1, StrokeRole.ANNOTATION_ARROW),

            quad(p(0.12f, 0.34f), p(0.49f, 0.04f), p(0.86f, 0.34f), stage = 2, width = 3.0f),
            label(0.14f, 0.39f, "3. C-curve touches apex smoothly", stage = 2),

            focusRing(0.49f, 0.72f, stage = 3, r = 0.024f, StrokeRole.AXIS_AND_PLUMB),
            cubic(p(0.12f, 0.72f), p(0.30f, 0.44f), p(0.68f, 1.00f), p(0.86f, 0.72f), stage = 3, width = 3.0f),
            label(0.14f, 0.87f, "4. S-curve crosses axis cleanly at midpoint", stage = 3),

            arrowLine(0.24f, 0.22f, 0.38f, 0.18f, stage = 4),
            boldLine(0.44f, 0.19f, 0.54f, 0.19f, stage = 4, width = 3.4f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Kinked Wrist Bend vs. Guided Arc",
            wrongLabel = "Flat Midpoint Kink",
            rightLabel = "Chord + Apex Sweep",
            whyMistakeHappens = "Drawing curves without a baseline or apex target forces mid-stroke steering.",
            howToFix = "Lightly plot the straight chord and apex dot, rotate the paper comfortably, and sweep.",
            wrongElements = listOf(
                poly(p(0.10f, 0.62f), p(0.32f, 0.32f), p(0.55f, 0.38f), p(0.88f, 0.64f), role = StrokeRole.MISTAKE_HIGHLIGHT, width = 3.0f, stage = 0),
                focusRing(0.32f, 0.32f, 0, r = 0.055f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Sharp accidental corner")
            ),
            rightElements = listOf(
                guideLine(0.10f, 0.64f, 0.88f, 0.64f, 0),
                focusRing(0.49f, 0.32f, 0, r = 0.024f, role = StrokeRole.CORRECTION_HIGHLIGHT),
                quad(p(0.10f, 0.64f), p(0.49f, 0.02f), p(0.88f, 0.64f), 0, width = 3.2f),
                rightNote("Continuous arc over apex")
            )
        )
    ),

    // 3. Circles & Ellipses
    VisualDemoSpec(
        id = "vis_circles_ellipses",
        title = "Circles & Degree-Controlled Ellipses",
        category = VisualCategory.BASIC_MARK_MAKING,
        worldNumbers = listOf(1, 2, 3),
        skillIds = listOf("sk_spheres_cyl"),
        summary = "Align ellipses around perpendicular major and minor axes and vary degree width smoothly.",
        revisitedConcepts = listOf("Shoulder ghosting", "Plumb axes"),
        stages = listOf(
            ConstructionStage(1, "Establish Major & Minor Axes", "Cross two perpendicular centerlines before drawing any curve.", "Ellipses must be symmetrical across both axes."),
            ConstructionStage(2, "Frame Bounding Guides", "Add light horizontal tangent boundaries so upper and lower halves stay equal.", "Prevents pinched or lopsided eggs."),
            ConstructionStage(3, "Ghost & Draw Full Circle", "Sweep 2 continuous shoulder passes through all four quadrant ticks.", "Keep curves round right through the far sides."),
            ConstructionStage(4, "Progress Through Ellipse Degrees", "Draw 15°, 45°, and 75° ellipses stacked down a shared vertical minor axis.", "Ellipses widen as surfaces tilt further away from eye level."),
            ConstructionStage(5, "Lock Perpendicularity", "Check that every ellipse's widest major axis meets the centerline at 90°.", "Tilting the major axis makes cups and wheels look warped."),
            ConstructionStage(6, "Weight & Clean Guidelines", "Reinforce crisp final contours and soften axis construction lines.", "Darken the lower rim slightly to suggest solidity.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.24f, 0.22f, 0.24f, 0.78f, stage = 0),
            axisLine(0.08f, 0.50f, 0.40f, 0.50f, stage = 0),
            axisLine(0.72f, 0.14f, 0.72f, 0.88f, stage = 0),
            label(0.08f, 0.08f, "1. Crosshair & vertical minor axis", stage = 0),

            guideLine(0.10f, 0.30f, 0.38f, 0.30f, stage = 1),
            guideLine(0.10f, 0.70f, 0.38f, 0.70f, stage = 1),
            guideLine(0.10f, 0.30f, 0.10f, 0.70f, stage = 1),
            guideLine(0.38f, 0.30f, 0.38f, 0.70f, stage = 1),

            oval(0.24f, 0.50f, 0.14f, 0.20f, stage = 2, width = 2.6f),
            label(0.11f, 0.76f, "3. Touch 4 midpoints", stage = 2),

            oval(0.72f, 0.24f, 0.17f, 0.045f, stage = 3, width = 2.5f),
            oval(0.72f, 0.49f, 0.17f, 0.095f, stage = 3, width = 2.5f),
            oval(0.72f, 0.76f, 0.17f, 0.145f, stage = 3, width = 2.5f),
            label(0.50f, 0.05f, "4. Narrow (15°) -> Mid (45°) -> Open (75°)", stage = 3),

            axisLine(0.54f, 0.49f, 0.90f, 0.49f, stage = 4, dashed = false, width = 1.6f),
            focusRing(0.72f, 0.49f, stage = 4, r = 0.025f, StrokeRole.CORRECTION_HIGHLIGHT),
            label(0.46f, 0.92f, "5. Major axis stays 90° to minor axis", stage = 4, StrokeRole.CORRECTION_HIGHLIGHT),

            oval(0.72f, 0.76f, 0.17f, 0.145f, stage = 5, role = StrokeRole.LINE_WEIGHT_ACCENT, width = 3.5f, startAngle = 15f, sweepAngle = 150f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Pinched 'Football' Ends vs. Smooth Rounded Ellipse",
            wrongLabel = "Pointed Almond Corners",
            rightLabel = "Full-Loop Shoulder Ellipse",
            whyMistakeHappens = "Stopping pencil momentum at left and right ends creates sharp corners instead of circular turns.",
            howToFix = "Ghost 3 full continuous loops above the page and round smoothly past the major-axis ends.",
            wrongElements = listOf(
                quad(p(0.10f, 0.50f), p(0.50f, 0.22f), p(0.90f, 0.50f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 3.0f),
                quad(p(0.10f, 0.50f), p(0.50f, 0.78f), p(0.90f, 0.50f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 3.0f),
                focusRing(0.10f, 0.50f, 0, r = 0.055f, StrokeRole.MISTAKE_HIGHLIGHT),
                focusRing(0.90f, 0.50f, 0, r = 0.055f, StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Pinched sharp corners")
            ),
            rightElements = listOf(
                axisLine(0.50f, 0.22f, 0.50f, 0.78f, 0),
                axisLine(0.08f, 0.50f, 0.92f, 0.50f, 0),
                oval(0.50f, 0.50f, 0.38f, 0.19f, 0, width = 3.0f),
                focusRing(0.12f, 0.50f, 0, r = 0.045f, StrokeRole.CORRECTION_HIGHLIGHT),
                focusRing(0.88f, 0.50f, 0, r = 0.045f, StrokeRole.CORRECTION_HIGHLIGHT),
                rightNote("Smooth C-curve turns")
            )
        )
    ),

    // 4. Line Weight Hierarchy
    VisualDemoSpec(
        id = "vis_line_weight",
        title = "Line Weight & Overlap Depth",
        category = VisualCategory.BASIC_MARK_MAKING,
        worldNumbers = listOf(3, 6),
        skillIds = listOf("sk_line_weight"),
        summary = "Use line thickness on foreground overlaps and grounded bases to create depth without shading.",
        revisitedConcepts = listOf("Confident strokes", "Box construction"),
        stages = listOf(
            ConstructionStage(1, "Draft Uniform Light Structure", "Establish overlapping shapes cleanly with thin, even 2H pressure.", "Decide which form sits in front before committing heavy ink."),
            ConstructionStage(2, "Locate T-Junction Overlaps", "Highlight where a foreground edge crosses in front of a background edge.", "T-junctions tell the viewer's eye what sits closest."),
            ConstructionStage(3, "Thicken Foreground Silhoutte", "Press heavier (2B) along the front overlapping contour and underside.", "Weight on the bottom edge anchors objects to the table."),
            ConstructionStage(4, "Keep Back & Top Edges Thin", "Leave receding top and background edges whisper-thin.", "Contrast between thick and thin creates instant air and space.", isCleanupStage = true)
        ),
        elements = listOf(
            poly(p(0.42f, 0.24f), p(0.82f, 0.24f), p(0.82f, 0.72f), p(0.42f, 0.72f), closed = true, width = 2.0f, stage = 0),
            poly(p(0.18f, 0.36f), p(0.56f, 0.36f), p(0.56f, 0.82f), p(0.18f, 0.82f), closed = true, width = 2.0f, fillAlpha = 0.06f, stage = 0),
            label(0.14f, 0.10f, "1. Uniform light wireframe", stage = 0),

            focusRing(0.56f, 0.36f, stage = 1, r = 0.042f, StrokeRole.ANNOTATION_ARROW),
            focusRing(0.42f, 0.72f, stage = 1, r = 0.042f, StrokeRole.ANNOTATION_ARROW),
            label(0.52f, 0.16f, "2. T-junction overlap", stage = 1, StrokeRole.ANNOTATION_ARROW),

            boldLine(0.56f, 0.36f, 0.56f, 0.82f, stage = 2, width = 4.6f),
            boldLine(0.18f, 0.82f, 0.56f, 0.82f, stage = 2, width = 4.8f),
            boldLine(0.56f, 0.72f, 0.82f, 0.72f, stage = 2, width = 3.8f),
            label(0.16f, 0.88f, "3. Heavy front overlap & ground base", stage = 2, StrokeRole.LINE_WEIGHT_ACCENT),

            inkLine(0.42f, 0.24f, 0.82f, 0.24f, stage = 3, width = 1.4f),
            inkLine(0.82f, 0.24f, 0.82f, 0.72f, stage = 3, width = 1.5f),
            label(0.60f, 0.82f, "4. Thin back edges recede", stage = 3, StrokeRole.CORRECTION_HIGHLIGHT)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Wireframe Weight vs. Spatial Hierarchy",
            wrongLabel = "Equal Thickness Everywhere",
            rightLabel = "Weighted Overlap & Base",
            whyMistakeHappens = "Applying identical pressure to every line turns overlapping forms into a flat coloring-book puzzle.",
            howToFix = "Keep back edges light, thicken front T-junctions, and press firmest along ground contact.",
            wrongElements = listOf(
                poly(p(0.18f, 0.34f), p(0.62f, 0.34f), p(0.62f, 0.78f), p(0.18f, 0.78f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.8f, stage = 0),
                poly(p(0.46f, 0.22f), p(0.86f, 0.22f), p(0.86f, 0.66f), p(0.46f, 0.66f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.8f, stage = 0),
                wrongNote("No overlap clarity")
            ),
            rightElements = listOf(
                poly(p(0.46f, 0.22f), p(0.86f, 0.22f), p(0.86f, 0.66f), p(0.46f, 0.66f), closed = true, width = 1.6f, stage = 0),
                poly(p(0.18f, 0.34f), p(0.62f, 0.34f), p(0.62f, 0.78f), p(0.18f, 0.78f), closed = true, width = 2.2f, fillAlpha = 0.08f, stage = 0),
                boldLine(0.62f, 0.34f, 0.62f, 0.78f, 0, width = 4.6f),
                boldLine(0.18f, 0.78f, 0.62f, 0.78f, 0, width = 4.8f),
                rightNote("Front form pops forward")
            )
        )
    ),

    // 5. Hatching, Cross-Hatching & Stippling
    VisualDemoSpec(
        id = "vis_hatching_stippling",
        title = "Hatching, Cross-Hatching & Stippling",
        category = VisualCategory.BASIC_MARK_MAKING,
        worldNumbers = listOf(3, 4),
        skillIds = listOf("sk_hatching", "sk_stippling_tex"),
        summary = "Build clean value through uniform stroke spacing, angled second passes, contour wrap, and stipple density.",
        revisitedConcepts = listOf("Controlled line pulls", "Cross-contour curvature"),
        stages = listOf(
            ConstructionStage(1, "Frame Tonal Swatches", "Divide practice zones cleanly so stroke endings stay inside crisp borders.", "Prevents messy scribble overshoot."),
            ConstructionStage(2, "Parallel Lifted Hatching", "Draw evenly spaced diagonal lines, lifting cleanly off the paper at every end.", "Spacing controls lightness; zero zigzag hooks."),
            ConstructionStage(3, "Add 35° Cross-Hatching", "Layer a second diagonal pass at 30°–45° to deepen shadow tone cleanly.", "Avoid 90° grid cross-hatching which looks stiff like screen mesh."),
            ConstructionStage(4, "Wrap Contour Hatching", "Bend strokes along a curved axis so tone describes 3D cylinder roundness.", "Curved hatching builds form and value simultaneously."),
            ConstructionStage(5, "Build Stipple Density Gradient", "Tap vertical pen dots closer together on the right to darken value cleanly.", "More dots—not bigger messy blobs—create smooth tone.")
        ),
        elements = listOf(
            poly(p(0.06f, 0.24f), p(0.25f, 0.24f), p(0.25f, 0.78f), p(0.06f, 0.78f), closed = true, width = 1.8f, stage = 0),
            poly(p(0.29f, 0.24f), p(0.48f, 0.24f), p(0.48f, 0.78f), p(0.29f, 0.78f), closed = true, width = 1.8f, stage = 0),
            poly(p(0.52f, 0.24f), p(0.71f, 0.24f), p(0.71f, 0.78f), p(0.52f, 0.78f), closed = true, width = 1.8f, stage = 0),
            poly(p(0.75f, 0.24f), p(0.94f, 0.24f), p(0.94f, 0.78f), p(0.75f, 0.78f), closed = true, width = 1.8f, stage = 0),

            hatch(buildParallelHatch(0.07f, 0.26f, 0.17f, 0.50f, count = 6, skewX = -0.02f), stage = 1),
            label(0.06f, 0.12f, "Parallel", stage = 1),

            hatch(buildParallelHatch(0.30f, 0.26f, 0.17f, 0.50f, count = 6, skewX = -0.02f), stage = 2),
            hatch(buildCrossHatch(0.30f, 0.26f, 0.17f, 0.50f, count = 6), stage = 2, role = StrokeRole.AXIS_AND_PLUMB),
            label(0.29f, 0.12f, "Cross 35°", stage = 2, StrokeRole.AXIS_AND_PLUMB),

            quad(p(0.53f, 0.34f), p(0.615f, 0.41f), p(0.70f, 0.34f), stage = 3, width = 1.8f, role = StrokeRole.SHADING_TONE),
            quad(p(0.53f, 0.44f), p(0.615f, 0.51f), p(0.70f, 0.44f), stage = 3, width = 1.8f, role = StrokeRole.SHADING_TONE),
            quad(p(0.53f, 0.54f), p(0.615f, 0.61f), p(0.70f, 0.54f), stage = 3, width = 1.8f, role = StrokeRole.SHADING_TONE),
            quad(p(0.53f, 0.64f), p(0.615f, 0.71f), p(0.70f, 0.64f), stage = 3, width = 1.8f, role = StrokeRole.SHADING_TONE),
            label(0.52f, 0.12f, "Contour", stage = 3),

            stipple(stippleGrid(0.76f, 0.26f, 0.17f, 0.50f, cols = 8, rows = 8), stage = 4),
            label(0.75f, 0.12f, "Stipple", stage = 4)
        ),
        comparison = MistakeComparisonSpec(
            title = "Continuous Zigzag Scribble vs. Lifted Hatching",
            wrongLabel = "Hooked Zigzag Ends",
            rightLabel = "Lifted Clean Strokes",
            whyMistakeHappens = "Keeping the pen pressed down while reversing direction leaves dark, knotted edge hooks.",
            howToFix = "Lift the tip cleanly off the paper at the end of every stroke before starting the next line.",
            wrongElements = listOf(
                poly(
                    p(0.14f, 0.28f), p(0.26f, 0.74f), p(0.32f, 0.28f), p(0.46f, 0.74f),
                    p(0.52f, 0.28f), p(0.66f, 0.74f), p(0.72f, 0.28f), p(0.86f, 0.74f),
                    role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.4f, stage = 0
                ),
                focusRing(0.26f, 0.74f, 0, r = 0.055f, StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Dark reversal hooks")
            ),
            rightElements = listOf(
                hatch(buildParallelHatch(0.12f, 0.26f, 0.76f, 0.48f, count = 8, skewX = -0.04f), stage = 0, role = StrokeRole.PRIMARY_CONTOUR, width = 2.2f),
                rightNote("Even spacing & crisp lift")
            )
        )
    ),

    // 6. Contour Observation & Sighting
    VisualDemoSpec(
        id = "vis_contour_sighting",
        title = "Plumb Sighting & Envelope Contours",
        category = VisualCategory.BASIC_MARK_MAKING,
        worldNumbers = listOf(1, 6),
        skillIds = listOf("sk_eye_hand", "sk_contour", "sk_sight_prop"),
        summary = "Measure tilt angles and vertical plumb alignment with straight envelope chords before carving curves.",
        stages = listOf(
            ConstructionStage(1, "Drop Vertical Plumb & Level Lines", "Establish a true vertical centerline and horizontal height level ticks.", "Gives an objective ruler to spot tilting or drifting."),
            ConstructionStage(2, "Block Straight Tilt Chords", "Frame the silhouette with 6 straight angle lines before attempting curves.", "Straight tilts are far easier to judge than wavy curves."),
            ConstructionStage(3, "Check Clock Angles by Sight", "Hold your pencil at arm's length to transfer exact diagonal slope angles.", "Prevents guessing symmetrical curves from memory."),
            ConstructionStage(4, "Carve True Observed Contours", "Follow subtle swells and narrowings gently inside the straight envelope.", "Move your eyes and pencil at the exact same slow speed."),
            ConstructionStage(5, "Clean Envelope & Weight Base", "Fade the straight envelope guides and anchor the base contact.", "Leaves a crisp, grounded silhouette.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.38f, 0.10f, 0.38f, 0.90f, stage = 0),
            axisLine(0.14f, 0.44f, 0.62f, 0.44f, stage = 0),
            label(0.12f, 0.05f, "1. Vertical plumb + level tick", stage = 0),

            guideLine(0.28f, 0.16f, 0.48f, 0.16f, stage = 1, dashed = false),
            guideLine(0.48f, 0.16f, 0.56f, 0.54f, stage = 1, dashed = false),
            guideLine(0.56f, 0.54f, 0.48f, 0.84f, stage = 1, dashed = false),
            guideLine(0.48f, 0.84f, 0.28f, 0.84f, stage = 1, dashed = false),
            guideLine(0.28f, 0.84f, 0.20f, 0.54f, stage = 1, dashed = false),
            guideLine(0.20f, 0.54f, 0.28f, 0.16f, stage = 1, dashed = false),
            label(0.56f, 0.26f, "2. Straight envelope", stage = 1),

            arrowLine(0.68f, 0.78f, 0.88f, 0.24f, stage = 2),
            guideLine(0.68f, 0.78f, 0.90f, 0.78f, stage = 2),
            label(0.64f, 0.14f, "3. Sight angle", stage = 2, StrokeRole.ANNOTATION_ARROW),

            cubic(p(0.28f, 0.16f), p(0.34f, 0.34f), p(0.18f, 0.52f), p(0.28f, 0.84f), stage = 3, width = 2.8f),
            cubic(p(0.48f, 0.16f), p(0.42f, 0.34f), p(0.58f, 0.52f), p(0.48f, 0.84f), stage = 3, width = 2.8f),
            inkLine(0.28f, 0.16f, 0.48f, 0.16f, stage = 3, width = 2.6f),

            boldLine(0.28f, 0.84f, 0.48f, 0.84f, stage = 4, width = 4.2f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Symbolic Leaning Vase vs. Plumb-Anchored Contour",
            wrongLabel = "Drifting Unmeasured Curves",
            rightLabel = "Plumb + Straight Envelope",
            whyMistakeHappens = "Drawing left and right curves freely without a centerline causes subtle leaning and lopsided bellies.",
            howToFix = "Drop a plumb centerline, match horizontal width ticks left and right, then carve curves.",
            wrongElements = listOf(
                cubic(p(0.28f, 0.18f), p(0.40f, 0.42f), p(0.18f, 0.62f), p(0.34f, 0.84f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 3.0f),
                cubic(p(0.48f, 0.18f), p(0.74f, 0.42f), p(0.64f, 0.68f), p(0.58f, 0.84f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 3.0f),
                axisLine(0.44f, 0.14f, 0.44f, 0.86f, 0),
                wrongNote("Lopsided off plumb axis")
            ),
            rightElements = listOf(
                axisLine(0.50f, 0.14f, 0.50f, 0.86f, 0),
                guideLine(0.36f, 0.18f, 0.64f, 0.18f, 0),
                cubic(p(0.36f, 0.18f), p(0.44f, 0.36f), p(0.28f, 0.56f), p(0.38f, 0.84f), 0, width = 3.0f),
                cubic(p(0.64f, 0.18f), p(0.56f, 0.36f), p(0.72f, 0.56f), p(0.62f, 0.84f), 0, width = 3.0f),
                inkLine(0.38f, 0.84f, 0.62f, 0.84f, 0, width = 3.4f),
                rightNote("Balanced across centerline")
            )
        )
    ),

    // 7. Negative Space Drawing
    VisualDemoSpec(
        id = "vis_negative_space",
        title = "Negative Space & Viewfinder Framing",
        category = VisualCategory.BASIC_MARK_MAKING,
        worldNumbers = listOf(1),
        skillIds = listOf("sk_neg_space"),
        summary = "Draw the empty background pockets inside a bounding frame so accurate objects appear automatically.",
        stages = listOf(
            ConstructionStage(1, "Draw Bounding Frame", "Enclose your study in a firm rectangular viewfinder border.", "Outer borders turn empty background air into measurable 2D puzzle shapes."),
            ConstructionStage(2, "Locate Central Interior Pocket", "Find the cleanest trapped air triangle or rectangle inside the chair.", "Measure its height vs. width before looking at surrounding legs."),
            ConstructionStage(3, "Map Outer Air Pockets", "Connect the exterior background spaces touching the bounding frame edges.", "Think 'polygon shapes', never 'chair legs'."),
            ConstructionStage(4, "Shade Negative Air Flat", "Tone the background and trapped holes evenly so the subject pops white.", "Flat gray negative space instantly reveals proportion errors."),
            ConstructionStage(5, "Refine Positive Silhouette", "Clean edges where negative shapes meet the crisp positive chair outline.", "Resulting chair proportions emerge accurately without symbol guessing.", isCleanupStage = true)
        ),
        elements = listOf(
            poly(p(0.14f, 0.14f), p(0.86f, 0.14f), p(0.86f, 0.88f), p(0.14f, 0.88f), closed = true, width = 2.6f, stage = 0, layer = VisualLayer.STRUCTURE),
            label(0.16f, 0.06f, "1. Rectangular viewfinder frame", stage = 0),

            poly(p(0.45f, 0.60f), p(0.66f, 0.60f), p(0.66f, 0.88f), p(0.45f, 0.88f), closed = true, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.2f, fillAlpha = 0.20f, stage = 1, layer = VisualLayer.GUIDE),
            label(0.47f, 0.70f, "Air B", stage = 1, StrokeRole.CORRECTION_HIGHLIGHT),

            poly(p(0.14f, 0.14f), p(0.40f, 0.14f), p(0.40f, 0.54f), p(0.28f, 0.54f), p(0.14f, 0.88f), closed = true, role = StrokeRole.AXIS_AND_PLUMB, width = 2.0f, fillAlpha = 0.22f, stage = 2, layer = VisualLayer.GUIDE),
            label(0.17f, 0.28f, "Air A", stage = 2),

            poly(p(0.46f, 0.14f), p(0.86f, 0.14f), p(0.86f, 0.88f), p(0.72f, 0.88f), p(0.72f, 0.54f), p(0.46f, 0.54f), closed = true, role = StrokeRole.SHADING_TONE, width = 1.6f, fillAlpha = 0.16f, stage = 3, layer = VisualLayer.SHADING),
            label(0.56f, 0.30f, "4. Background mass", stage = 3),

            boldLine(0.42f, 0.18f, 0.42f, 0.88f, stage = 4, width = 4.6f),
            boldLine(0.42f, 0.56f, 0.69f, 0.56f, stage = 4, width = 4.6f),
            boldLine(0.69f, 0.56f, 0.69f, 0.88f, stage = 4, width = 4.6f),
            label(0.16f, 0.91f, "5. Chair appears from trapped air shapes", stage = 4, StrokeRole.CORRECTION_HIGHLIGHT)
        ),
        comparison = MistakeComparisonSpec(
            title = "Symbol Guessing vs. Framed Negative Space",
            wrongLabel = "Guessing Isolated Sticks",
            rightLabel = "Framed Air Pockets",
            whyMistakeHappens = "Drawing chair parts from memory without a frame makes spacing and leg angles drift randomly.",
            howToFix = "Box the scene, draw the trapped background shapes between legs first, then darken the air.",
            wrongElements = listOf(
                inkLine(0.32f, 0.20f, 0.36f, 0.82f, 0, 3.0f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.34f, 0.54f, 0.72f, 0.48f, 0, 3.0f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.66f, 0.50f, 0.78f, 0.84f, 0, 3.0f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("No frame -> tilted legs")
            ),
            rightElements = listOf(
                poly(p(0.12f, 0.14f), p(0.88f, 0.14f), p(0.88f, 0.84f), p(0.12f, 0.84f), closed = true, width = 2.2f, stage = 0),
                poly(p(0.44f, 0.56f), p(0.68f, 0.56f), p(0.68f, 0.84f), p(0.44f, 0.84f), closed = true, role = StrokeRole.CORRECTION_HIGHLIGHT, fillAlpha = 0.24f, stage = 0),
                boldLine(0.41f, 0.20f, 0.41f, 0.84f, 0, width = 4.0f),
                boldLine(0.41f, 0.54f, 0.70f, 0.54f, 0, width = 4.0f),
                boldLine(0.70f, 0.54f, 0.70f, 0.84f, 0, width = 4.0f),
                rightNote("Locked proportions via Air")
            )
        )
    )
)
