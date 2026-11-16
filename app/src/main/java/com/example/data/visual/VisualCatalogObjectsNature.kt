package com.example.data.visual

import com.example.domain.model.ConstructionStage
import com.example.domain.model.MistakeComparisonSpec
import com.example.domain.model.StrokeRole
import com.example.domain.model.VisualCategory
import com.example.domain.model.VisualDemoSpec
import com.example.domain.model.VisualLayer

internal fun objectsAndNatureVisualDemos(): List<VisualDemoSpec> = listOf(
    // 19. Cups & Mugs (Revisits Ellipses!)
    VisualDemoSpec(
        id = "vis_cup_mug",
        title = "Ceramic Cup / Mug (Ellipses Applied)",
        category = VisualCategory.OBJECT_DRAWING,
        worldNumbers = listOf(6),
        skillIds = listOf("sk_still_construct"),
        summary = "Construct a grounded ceramic cup using cylinder ellipse progressions and a box-plane aligned handle.",
        revisitedConcepts = listOf("Cylinder minor axis", "Ellipse degrees (15° vs 45°)", "Cast shadow occlusion"),
        stages = listOf(
            ConstructionStage(1, "Drop Vertical Plumb Centerline", "Start with a crisp vertical symmetry spine and flat horizontal rim guide.", "Locks both sides symmetrical before drawing rims."),
            ConstructionStage(2, "Construct Top Rim Ellipse (Inner + Outer)", "Draw a clean 90° ellipse for the opening, plus a concentric inner rim thickness ring.", "Showing ceramic wall thickness makes cups feel solid, not paper-thin."),
            ConstructionStage(3, "Draw Tapered Walls & Wider Base Ellipse", "Angle both sides gently inward toward a rounder bottom ellipse.", "Base sits lower from eye level, so its curve opens slightly wider."),
            ConstructionStage(4, "Block Handle Using Planar Box Guides", "Project two aligned horizontal guide lines from the side wall to house the C-handle ribbon.", "Handles fail when pasted flat on without top/bottom thickness planes."),
            ConstructionStage(5, "Clean Construction Axes & Guides", "Lighten internal ellipse back lines and vertical construction lines.", "Reveals a clean structural mug ready for value.", isCleanupStage = true),
            ConstructionStage(6, "Add Core Shadow, Interior Tone & Grounding", "Shade the inner back rim wall and right cylindrical turning shadow + base cast shadow.", "Note how the interior shadow sits on the OPPOSITE side of the exterior shadow!")
        ),
        elements = listOf(
            axisLine(0.42f, 0.14f, 0.42f, 0.88f, stage = 0),
            axisLine(0.18f, 0.28f, 0.66f, 0.28f, stage = 0, dashed = true, width = 1.6f),

            oval(0.42f, 0.28f, 0.20f, 0.068f, stage = 1, width = 2.6f),
            oval(0.42f, 0.28f, 0.18f, 0.056f, stage = 1, role = StrokeRole.AXIS_AND_PLUMB, width = 1.6f),

            inkLine(0.22f, 0.28f, 0.27f, 0.78f, stage = 2, width = 2.6f),
            inkLine(0.62f, 0.28f, 0.57f, 0.78f, stage = 2, width = 2.6f),
            oval(0.42f, 0.78f, 0.15f, 0.068f, stage = 2, width = 2.6f, startAngle = 0f, sweepAngle = 180f),
            oval(0.42f, 0.78f, 0.15f, 0.068f, stage = 2, width = 1.6f, dashed = true, startAngle = 180f, sweepAngle = 180f, layer = VisualLayer.STRUCTURE),

            guideLine(0.61f, 0.36f, 0.78f, 0.36f, stage = 3),
            guideLine(0.58f, 0.66f, 0.76f, 0.66f, stage = 3),
            cubic(p(0.61f, 0.36f), p(0.84f, 0.34f), p(0.82f, 0.68f), p(0.58f, 0.66f), stage = 3, width = 2.6f),
            cubic(p(0.60f, 0.42f), p(0.76f, 0.40f), p(0.75f, 0.62f), p(0.58f, 0.60f), stage = 3, width = 2.2f),

            label(0.10f, 0.06f, "5. Trim hidden rim & axis lines", stage = 4, StrokeRole.CORRECTION_HIGHLIGHT),

            // Interior shadow (left side!) + exterior shadow (right side) + cast shadow
            hatch(listOf(
                p(0.27f, 0.25f) to p(0.27f, 0.31f),
                p(0.31f, 0.24f) to p(0.31f, 0.32f),
                p(0.35f, 0.23f) to p(0.35f, 0.33f)
            ), stage = 5),
            hatch(listOf(
                p(0.49f, 0.35f) to p(0.48f, 0.82f),
                p(0.53f, 0.34f) to p(0.51f, 0.80f),
                p(0.57f, 0.32f) to p(0.54f, 0.78f)
            ), stage = 5),
            oval(0.58f, 0.81f, 0.17f, 0.045f, stage = 5, role = StrokeRole.SHADING_TONE, width = 1.0f, fillAlpha = 0.28f, layer = VisualLayer.SHADING),
            boldLine(0.30f, 0.84f, 0.54f, 0.84f, stage = 5, width = 4.0f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Paper Handle vs. Symmetrical Cylinder Mug",
            wrongLabel = "Pinched Rim + Floating Handle",
            rightLabel = "Full Ellipses + Planar Handle",
            whyMistakeHappens = "Ignoring the inner cylinder ellipse and drawing a thin single wire loop for the handle flattens the cup.",
            howToFix = "Show rim thickness with double ellipses, round the base, and align the handle inside horizontal construction rails.",
            wrongElements = listOf(
                oval(0.44f, 0.30f, 0.22f, 0.06f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.6f),
                inkLine(0.22f, 0.30f, 0.26f, 0.78f, 0, 2.6f),
                inkLine(0.66f, 0.30f, 0.62f, 0.78f, 0, 2.6f),
                inkLine(0.26f, 0.78f, 0.62f, 0.78f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                quad(p(0.65f, 0.38f), p(0.84f, 0.50f), p(0.63f, 0.64f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.6f),
                wrongNote("Flat base + wire handle")
            ),
            rightElements = listOf(
                axisLine(0.44f, 0.16f, 0.44f, 0.86f, 0),
                oval(0.44f, 0.28f, 0.20f, 0.065f, 0, width = 2.6f),
                oval(0.44f, 0.28f, 0.17f, 0.052f, 0, width = 1.6f),
                inkLine(0.24f, 0.28f, 0.28f, 0.76f, 0, 2.6f),
                inkLine(0.64f, 0.28f, 0.60f, 0.76f, 0, 2.6f),
                oval(0.44f, 0.76f, 0.16f, 0.068f, 0, width = 2.6f, startAngle = 0f, sweepAngle = 180f),
                cubic(p(0.63f, 0.36f), p(0.84f, 0.34f), p(0.82f, 0.68f), p(0.60f, 0.66f), 0, width = 2.6f),
                rightNote("Solid rim + wide base curve")
            )
        )
    ),

    // 20. Bottles & Vases (Revisits Cylinder + Plumb Symmetry!)
    VisualDemoSpec(
        id = "vis_bottle_vase",
        title = "Symmetrical Bottle (Cylinders + Ticks)",
        category = VisualCategory.OBJECT_DRAWING,
        worldNumbers = listOf(6),
        skillIds = listOf("sk_still_construct"),
        summary = "Build symmetrical glass bottles and vases by stacking cross-level ticks and ellipses along one plumb spine.",
        revisitedConcepts = listOf("Plumb centerline", "Stacked ellipses"),
        stages = listOf(
            ConstructionStage(1, "Plot Vertical Centerline & Height Levels", "Mark mouth, neck base, shoulder, and foot levels horizontally across a single plumb axis.", "Locks vertical heights before any curve is drawn."),
            ConstructionStage(2, "Measure Equal Left/Right Width Ticks", "Use your pencil to confirm equal left and right widths on every horizontal level.", "Eliminates lopsided bottle shoulders permanently."),
            ConstructionStage(3, "Draw Full Stacked Ellipses", "Place narrow mouth, wider shoulder, and fullest base ellipses horizontally across ticks.", "Each ellipse degree deepens smoothly down the spine."),
            ConstructionStage(4, "Connect Symmetrical S-Curve Profiles", "Sweep smooth outer walls touching every ellipse's widest left/right tangent.", "Notice how ellipses dictate exact shoulder curvature."),
            ConstructionStage(5, "Clean Back Guides & Add Vertical Highlight", "Erase back ellipse arcs and leave a crisp vertical glass specular reflection strip.", "Clean specular strips communicate curved gloss effortlessly.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.50f, 0.10f, 0.50f, 0.90f, stage = 0),
            guideLine(0.32f, 0.18f, 0.68f, 0.18f, stage = 0),
            guideLine(0.24f, 0.44f, 0.76f, 0.44f, stage = 0),
            guideLine(0.24f, 0.80f, 0.76f, 0.80f, stage = 0),

            focusRing(0.42f, 0.18f, stage = 1, r = 0.018f, StrokeRole.CORRECTION_HIGHLIGHT),
            focusRing(0.58f, 0.18f, stage = 1, r = 0.018f, StrokeRole.CORRECTION_HIGHLIGHT),
            focusRing(0.32f, 0.44f, stage = 1, r = 0.018f, StrokeRole.CORRECTION_HIGHLIGHT),
            focusRing(0.68f, 0.44f, stage = 1, r = 0.018f, StrokeRole.CORRECTION_HIGHLIGHT),
            label(0.62f, 0.25f, "2. Equal L/R ticks", stage = 1),

            oval(0.50f, 0.18f, 0.08f, 0.025f, stage = 2, width = 2.4f),
            oval(0.50f, 0.44f, 0.18f, 0.055f, stage = 2, role = StrokeRole.AXIS_AND_PLUMB, width = 1.8f, dashed = true, layer = VisualLayer.STRUCTURE),
            oval(0.50f, 0.80f, 0.18f, 0.072f, stage = 2, width = 2.6f, startAngle = 0f, sweepAngle = 180f),

            cubic(p(0.42f, 0.18f), p(0.42f, 0.34f), p(0.32f, 0.36f), p(0.32f, 0.44f), stage = 3, width = 2.8f),
            cubic(p(0.58f, 0.18f), p(0.58f, 0.34f), p(0.68f, 0.36f), p(0.68f, 0.44f), stage = 3, width = 2.8f),
            inkLine(0.32f, 0.44f, 0.32f, 0.80f, stage = 3, width = 2.8f),
            inkLine(0.68f, 0.44f, 0.68f, 0.80f, stage = 3, width = 2.8f),

            // Specular gloss band & shaded right side
            poly(p(0.37f, 0.45f), p(0.41f, 0.45f), p(0.41f, 0.77f), p(0.37f, 0.77f), closed = true, role = StrokeRole.HIGHLIGHT_ACCENT, width = 1.8f, fillAlpha = 0.18f, stage = 4, layer = VisualLayer.SHADING),
            hatch(listOf(
                p(0.59f, 0.44f) to p(0.59f, 0.82f),
                p(0.62f, 0.43f) to p(0.62f, 0.80f),
                p(0.65f, 0.42f) to p(0.65f, 0.79f)
            ), stage = 4),
            boldLine(0.35f, 0.85f, 0.65f, 0.85f, stage = 4, width = 3.8f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Lopsided Bottle vs. Tick-Checked Symmetry",
            wrongLabel = "Asymmetric Bulging Sides",
            rightLabel = "Equal Ticks Around Axis",
            whyMistakeHappens = "Drawing the left curve from top to bottom and then guessing the right curve freehand causes asymmetry.",
            howToFix = "Measure left-right width ticks from a shared vertical centerline at neck, shoulder, and base first.",
            wrongElements = listOf(
                cubic(p(0.44f, 0.20f), p(0.44f, 0.36f), p(0.34f, 0.40f), p(0.34f, 0.80f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.8f),
                cubic(p(0.54f, 0.20f), p(0.58f, 0.34f), p(0.82f, 0.42f), p(0.74f, 0.80f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.8f),
                wrongNote("Right bulge far wider than left")
            ),
            rightElements = listOf(
                axisLine(0.50f, 0.12f, 0.50f, 0.86f, 0),
                guideLine(0.32f, 0.44f, 0.68f, 0.44f, 0),
                cubic(p(0.42f, 0.20f), p(0.42f, 0.34f), p(0.32f, 0.38f), p(0.32f, 0.46f), 0, width = 2.8f),
                cubic(p(0.58f, 0.20f), p(0.58f, 0.34f), p(0.68f, 0.38f), p(0.68f, 0.46f), 0, width = 2.8f),
                inkLine(0.32f, 0.46f, 0.32f, 0.80f, 0, 2.8f),
                inkLine(0.68f, 0.46f, 0.68f, 0.80f, 0, 2.8f),
                oval(0.50f, 0.80f, 0.18f, 0.06f, 0, width = 2.6f, startAngle = 0f, sweepAngle = 180f),
                rightNote("Equal distances both sides")
            )
        )
    ),

    // 21. Books & Furniture (Revisits 2-Point Cubes!)
    VisualDemoSpec(
        id = "vis_book_furniture",
        title = "Chair & Book Box Construction (2-Pt Applied)",
        category = VisualCategory.OBJECT_DRAWING,
        worldNumbers = listOf(5, 6),
        skillIds = listOf("sk_still_construct", "sk_2pt_persp"),
        summary = "Carve complex chairs and curved open books cleanly inside a simple two-point bounding crate.",
        revisitedConcepts = listOf("2-Point perspective cube", "Line weight overlap"),
        stages = listOf(
            ConstructionStage(1, "Build 2-Point Bounding Crate", "Establish a tall 2-point bounding box representing the chair's outer volume.", "If the bounding box sits straight on the floor, the chair cannot twist weirdly."),
            ConstructionStage(2, "Slice Seat Height & Backrest Plane", "Divide the lower seat platform and isolate the slim rear backrest plane.", "Carving inward from a box locks all four corners in shared perspective."),
            ConstructionStage(3, "Drop Four Legs Inside Box Corners", "Sketch all four leg posts traveling cleanly down to the box's floor footprint.", "Guarantees every leg touches the same flat ground plane."),
            ConstructionStage(4, "Add Curved Spine / Top Back Rail", "Round the chair back rail and add subtle seat edge bevels.", "Organic curves feel grounded when anchored to box geometry."),
            ConstructionStage(5, "Clean Crate Guides & Weight Base", "Fade bounding construction lines and press heavy weight on front legs & seat overlap.", "Turns engineering scaffolding into a crisp furniture study.", isCleanupStage = true)
        ),
        elements = listOf(
            guideLine(0.46f, 0.46f, 0.46f, 0.86f, stage = 0, dashed = false),
            guideLine(0.24f, 0.38f, 0.24f, 0.72f, stage = 0),
            guideLine(0.72f, 0.34f, 0.72f, 0.68f, stage = 0),
            guideLine(0.24f, 0.72f, 0.46f, 0.86f, stage = 0),
            guideLine(0.46f, 0.86f, 0.72f, 0.68f, stage = 0),
            guideLine(0.24f, 0.38f, 0.50f, 0.26f, stage = 0),
            guideLine(0.50f, 0.26f, 0.72f, 0.34f, stage = 0),

            // Seat slab & Backrest frame
            poly(p(0.24f, 0.54f), p(0.50f, 0.43f), p(0.72f, 0.52f), p(0.46f, 0.64f), closed = true, width = 2.6f, stage = 1),
            inkLine(0.24f, 0.54f, 0.24f, 0.59f, stage = 1, width = 2.4f),
            inkLine(0.46f, 0.64f, 0.46f, 0.69f, stage = 1, width = 2.4f),
            inkLine(0.72f, 0.52f, 0.72f, 0.57f, stage = 1, width = 2.4f),
            inkLine(0.24f, 0.59f, 0.46f, 0.69f, stage = 1, width = 2.4f),
            inkLine(0.46f, 0.69f, 0.72f, 0.57f, stage = 1, width = 2.4f),

            // Four legs + backrest posts
            inkLine(0.24f, 0.59f, 0.24f, 0.72f, stage = 2, width = 2.8f),
            inkLine(0.46f, 0.69f, 0.46f, 0.86f, stage = 2, width = 3.0f),
            inkLine(0.72f, 0.57f, 0.72f, 0.68f, stage = 2, width = 2.6f),
            inkLine(0.50f, 0.58f, 0.50f, 0.66f, stage = 2, width = 2.0f),
            inkLine(0.24f, 0.22f, 0.24f, 0.54f, stage = 2, width = 2.8f),
            inkLine(0.50f, 0.14f, 0.50f, 0.43f, stage = 2, width = 2.6f),

            // Top back rail curve
            quad(p(0.24f, 0.22f), p(0.37f, 0.16f), p(0.50f, 0.14f), stage = 3, width = 2.8f),
            quad(p(0.24f, 0.30f), p(0.37f, 0.24f), p(0.50f, 0.22f), stage = 3, width = 2.4f),

            boldLine(0.46f, 0.69f, 0.46f, 0.86f, stage = 4, width = 4.2f),
            boldLine(0.24f, 0.59f, 0.46f, 0.69f, stage = 4, width = 3.8f),
            poly(p(0.46f, 0.64f), p(0.72f, 0.52f), p(0.72f, 0.57f), p(0.46f, 0.69f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.20f, stage = 4, layer = VisualLayer.SHADING)
        ),
        comparison = MistakeComparisonSpec(
            title = "Twisted Legs vs. Bounding-Box Grounding",
            wrongLabel = "Uneven Floating Legs",
            rightLabel = "Carved From Shared Crate",
            whyMistakeHappens = "Drawing furniture legs without a floor footprint rectangle makes back legs drop too low or twist off-plane.",
            howToFix = "Build the outer 2-point bounding crate first, verify the ground footprint, then carve legs inside the corners.",
            wrongElements = listOf(
                poly(p(0.24f, 0.44f), p(0.56f, 0.36f), p(0.76f, 0.46f), p(0.44f, 0.56f), closed = true, width = 2.4f, stage = 0),
                inkLine(0.24f, 0.44f, 0.22f, 0.78f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.44f, 0.56f, 0.46f, 0.70f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.76f, 0.46f, 0.82f, 0.82f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Front leg shorter than rear leg!")
            ),
            rightElements = listOf(
                guideLine(0.24f, 0.72f, 0.46f, 0.84f, 0),
                guideLine(0.46f, 0.84f, 0.74f, 0.68f, 0),
                poly(p(0.24f, 0.46f), p(0.52f, 0.34f), p(0.74f, 0.44f), p(0.46f, 0.56f), closed = true, width = 2.6f, stage = 0),
                inkLine(0.24f, 0.46f, 0.24f, 0.72f, 0, 2.8f),
                inkLine(0.46f, 0.56f, 0.46f, 0.84f, 0, 3.2f),
                inkLine(0.74f, 0.44f, 0.74f, 0.68f, 0, 2.6f),
                rightNote("All feet sit on footprint plane")
            )
        )
    ),

    // 22. Shoes & Household Objects
    VisualDemoSpec(
        id = "vis_shoe_household",
        title = "Shoes & Asymmetric Everyday Objects",
        category = VisualCategory.OBJECT_DRAWING,
        worldNumbers = listOf(1, 6),
        skillIds = listOf("sk_still_construct", "sk_still_prop"),
        summary = "Break down tricky asymmetric sneakers into a flat sole footprint, heel cylinder, and sloped toe wedge.",
        revisitedConcepts = listOf("2-pt footprint", "Cylinder ankle", "Cross-contours"),
        stages = listOf(
            ConstructionStage(1, "Plot Sole Footprint S-Curve", "Map the tilted ground sole footprint first as an elongated bean shape.", "Sets perspective angle and overall shoe length immediately."),
            ConstructionStage(2, "Raise Heel Cylinder & Toe Wedge", "Build a vertical heel cylinder at the back and slope a low wedge forward to the toe.", "Reduces complex footwear into two crisp primitives."),
            ConstructionStage(3, "Carve Ankle Collar & Tongue Angle", "Wrap an angled ellipse around the ankle opening and project the tongue slope.", "Ankle ellipses follow the same 3D perspective rules as cups."),
            ConstructionStage(4, "Wrap Cross-Contour Laces & Outsole", "Curve lace bands over the rounded bridge and trace the thick rubber sole sidewall.", "Curved laces prove the top of the foot arches in 3D space."),
            ConstructionStage(5, "Clean Guides, Weight Sole & Ground Shadow", "Soften box/cylinder guides, thicken the sole contact edge, and cast a crisp floor shadow.", "Turns simple geometry into a believable product sketch.", isCleanupStage = true)
        ),
        elements = listOf(
            cubic(p(0.14f, 0.70f), p(0.32f, 0.76f), p(0.68f, 0.78f), p(0.88f, 0.68f), stage = 0, role = StrokeRole.AXIS_AND_PLUMB, width = 2.0f, dashed = true, layer = VisualLayer.STRUCTURE),
            guideLine(0.14f, 0.70f, 0.88f, 0.68f, stage = 0),

            inkLine(0.16f, 0.34f, 0.14f, 0.70f, stage = 1, width = 2.4f),
            inkLine(0.42f, 0.36f, 0.42f, 0.64f, stage = 1, width = 2.0f),
            inkLine(0.42f, 0.40f, 0.86f, 0.60f, stage = 1, width = 2.2f),

            oval(0.29f, 0.34f, 0.13f, 0.048f, stage = 2, width = 2.6f),
            quad(p(0.42f, 0.38f), p(0.58f, 0.44f), p(0.76f, 0.56f), stage = 2, width = 2.6f),
            quad(p(0.76f, 0.56f), p(0.90f, 0.58f), p(0.88f, 0.68f), stage = 2, width = 2.6f),

            inkLine(0.14f, 0.65f, 0.88f, 0.64f, stage = 3, width = 2.2f),
            quad(p(0.46f, 0.42f), p(0.51f, 0.38f), p(0.54f, 0.46f), stage = 3, role = StrokeRole.AXIS_AND_PLUMB, width = 2.2f),
            quad(p(0.54f, 0.47f), p(0.59f, 0.43f), p(0.62f, 0.51f), stage = 3, role = StrokeRole.AXIS_AND_PLUMB, width = 2.2f),

            boldLine(0.14f, 0.70f, 0.88f, 0.68f, stage = 4, width = 4.2f),
            oval(0.52f, 0.74f, 0.34f, 0.045f, stage = 4, role = StrokeRole.SHADING_TONE, width = 1.0f, fillAlpha = 0.24f, layer = VisualLayer.SHADING)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Side Profile Sticker vs. Tilted Footprint Shoe",
            wrongLabel = "Flat Cartoon Side View",
            rightLabel = "Wedge + Rounded Collar",
            whyMistakeHappens = "Drawing shoes as flat side-profile icons skips the 3D ankle opening and sole footprint perspective.",
            howToFix = "Start with the tilted ground footprint oval, add a cylindrical ankle collar, then wrap curved laces across.",
            wrongElements = listOf(
                poly(p(0.16f, 0.34f), p(0.38f, 0.34f), p(0.46f, 0.52f), p(0.84f, 0.58f), p(0.84f, 0.72f), p(0.16f, 0.72f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.8f, stage = 0),
                wrongNote("Flat straight side view, zero collar hole")
            ),
            rightElements = listOf(
                oval(0.30f, 0.34f, 0.13f, 0.05f, 0, width = 2.6f),
                inkLine(0.17f, 0.34f, 0.15f, 0.68f, 0, 2.6f),
                quad(p(0.43f, 0.34f), p(0.62f, 0.46f), p(0.86f, 0.60f), 0, width = 2.6f),
                quad(p(0.86f, 0.60f), p(0.90f, 0.68f), p(0.84f, 0.70f), 0, width = 2.6f),
                boldLine(0.15f, 0.68f, 0.84f, 0.70f, 0, width = 3.8f),
                rightNote("3D collar + arched lace bridge")
            )
        )
    ),

    // 23. Still-Life Arrangement (Revisits Forms + Light!)
    VisualDemoSpec(
        id = "vis_still_life_group",
        title = "Still-Life Grouping, Overlap & Value Unity",
        category = VisualCategory.OBJECT_DRAWING,
        worldNumbers = listOf(6),
        skillIds = listOf("sk_still_prop", "sk_still_comp", "sk_still_value"),
        summary = "Arrange multiple objects on shared footprints with bold foreground overlaps and unified shadow shapes.",
        revisitedConcepts = listOf("Sphere + cylinder", "Shadow family", "Line weight T-junction"),
        stages = listOf(
            ConstructionStage(1, "Establish Table Horizon & Floor Footprints", "Place overlapping oval footprints on the table plane before extruding height.", "Footprint planning stops rear objects from colliding inside front objects."),
            ConstructionStage(2, "Block Tall, Medium & Low Silhouettes", "Vary heights cleanly (tall bottle left, medium cup center, low fruit front) into an asymmetric triangle.", "Variety in height and overlap creates pleasing rhythm."),
            ConstructionStage(3, "Draw Transparent Forms & Verify Overlap", "Construct each cylinder/sphere clearly, then emphasize which edge sits closest.", "Front bowl boldly overlaps the rear bottle's lower base."),
            ConstructionStage(4, "Group Unified Shadow Shapes", "Connect the bottle's shadow shape right into the bowl's shadow across shared light direction.", "Shadow grouping pulls separate props into one cohesive scene."),
            ConstructionStage(5, "Anchor Table Occlusion & Focal Contrast", "Press crisp darks where items rest on the cloth and highlight the focal rim.", "Directs the viewer's eye straight to the hero overlap.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.06f, 0.64f, 0.94f, 0.64f, stage = 0, dashed = false),
            oval(0.32f, 0.72f, 0.12f, 0.045f, stage = 0, role = StrokeRole.CONSTRUCTION_GUIDE, dashed = true, layer = VisualLayer.GUIDE),
            oval(0.56f, 0.78f, 0.16f, 0.055f, stage = 0, role = StrokeRole.CONSTRUCTION_GUIDE, dashed = true, layer = VisualLayer.GUIDE),

            // Tall bottle left + bowl/apple overlapping right front
            axisLine(0.32f, 0.14f, 0.32f, 0.76f, stage = 1),
            oval(0.32f, 0.18f, 0.05f, 0.02f, stage = 1, width = 2.4f),
            inkLine(0.27f, 0.18f, 0.20f, 0.42f, stage = 1, width = 2.4f),
            inkLine(0.37f, 0.18f, 0.44f, 0.42f, stage = 1, width = 2.4f),
            inkLine(0.20f, 0.42f, 0.20f, 0.72f, stage = 1, width = 2.4f),
            inkLine(0.44f, 0.42f, 0.44f, 0.72f, stage = 1, width = 2.4f),

            oval(0.56f, 0.56f, 0.18f, 0.065f, stage = 2, width = 2.8f),
            quad(p(0.38f, 0.56f), p(0.40f, 0.86f), p(0.56f, 0.84f), stage = 2, width = 2.8f),
            quad(p(0.74f, 0.56f), p(0.72f, 0.86f), p(0.56f, 0.84f), stage = 2, width = 2.8f),
            focusRing(0.44f, 0.56f, stage = 2, r = 0.036f, StrokeRole.ANNOTATION_ARROW),

            hatch(listOf(
                p(0.35f, 0.42f) to p(0.35f, 0.70f),
                p(0.39f, 0.42f) to p(0.39f, 0.62f),
                p(0.62f, 0.62f) to p(0.62f, 0.82f),
                p(0.67f, 0.60f) to p(0.67f, 0.80f)
            ), stage = 3),
            oval(0.72f, 0.82f, 0.14f, 0.04f, stage = 3, role = StrokeRole.SHADING_TONE, fillAlpha = 0.25f, layer = VisualLayer.SHADING),

            boldLine(0.40f, 0.80f, 0.70f, 0.82f, stage = 4, width = 4.2f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Separated Tangent Parade vs. Overlapping Depth",
            wrongLabel = "Kissing Edges in a Flat Line",
            rightLabel = "Bold Forward Overlap",
            whyMistakeHappens = "Spacing objects equally without overlaps flattens space and creates awkward edge tangents.",
            howToFix = "Stagger footprint heights and let the foreground object boldly cover 20–30% of the rear form.",
            wrongElements = listOf(
                poly(p(0.14f, 0.28f), p(0.34f, 0.28f), p(0.34f, 0.76f), p(0.14f, 0.76f), closed = true, width = 2.4f, stage = 0),
                oval(0.45f, 0.62f, 0.11f, 0.14f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.4f),
                poly(p(0.56f, 0.44f), p(0.84f, 0.44f), p(0.84f, 0.76f), p(0.56f, 0.76f), closed = true, width = 2.4f, stage = 0),
                focusRing(0.34f, 0.62f, 0, r = 0.04f, StrokeRole.MISTAKE_HIGHLIGHT),
                focusRing(0.56f, 0.62f, 0, r = 0.04f, StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Kissing tangents on same line")
            ),
            rightElements = listOf(
                poly(p(0.18f, 0.24f), p(0.40f, 0.24f), p(0.40f, 0.74f), p(0.18f, 0.74f), closed = true, width = 2.2f, stage = 0),
                oval(0.42f, 0.68f, 0.14f, 0.15f, 0, width = 2.8f, fillAlpha = 0.06f),
                poly(p(0.54f, 0.44f), p(0.82f, 0.44f), p(0.82f, 0.72f), p(0.54f, 0.72f), closed = true, width = 2.2f, stage = 0),
                boldLine(0.30f, 0.78f, 0.52f, 0.78f, 0, width = 3.8f),
                rightNote("Staggered depth + clear overlaps")
            )
        )
    ),

    // 24. Material Textures (Wood, Metal & Drapery Folds)
    VisualDemoSpec(
        id = "vis_textures_materials",
        title = "Wood Grain, Reflective Metal & Cloth Folds",
        category = VisualCategory.OBJECT_DRAWING,
        worldNumbers = listOf(7),
        skillIds = listOf("sk_tex_hard", "sk_tex_reflect", "sk_tex_fabric"),
        summary = "Apply surface texture selectively over underlying 3D lighting rather than drawing uniform detail everywhere.",
        revisitedConcepts = listOf("Terminator shading", "Cylinder forms"),
        stages = listOf(
            ConstructionStage(1, "Divide Three Material Test Panels", "Block three clean vertical forms: wood plank, chrome cylinder, and hanging cloth fold.", "Texture never replaces underlying light and form."),
            ConstructionStage(2, "Establish Underlying Form Value First", "Shade the wood shadow side, high-contrast metal gradient, and cloth pipe cylinder first.", "Without base form value, wood and cloth look like flat wallpaper."),
            ConstructionStage(3, "Place Wood Grain Around Terminator", "Draw crisp organic knots and grain lines strongest near the halftone-shadow transition.", "Keep highlights uncluttered so the lit edge breathes."),
            ConstructionStage(4, "Sharpen Chrome #1-to-#9 Horizon Jump", "Place dark #9 horizon reflections cleanly against crisp #1 paper highlights.", "High contrast sharpness sells polished metal instantly."),
            ConstructionStage(5, "Model Cloth Tension Anchor & Pipe Fold", "Trace folds radiating from one upper tension pin and shade the rounded underside crease.", "Every cloth fold follows gravity from a hang point.")
        ),
        elements = listOf(
            poly(p(0.06f, 0.22f), p(0.30f, 0.22f), p(0.30f, 0.82f), p(0.06f, 0.82f), closed = true, width = 2.2f, stage = 0),
            poly(p(0.38f, 0.22f), p(0.62f, 0.22f), p(0.62f, 0.82f), p(0.38f, 0.82f), closed = true, width = 2.2f, stage = 0),
            poly(p(0.70f, 0.22f), p(0.94f, 0.22f), p(0.94f, 0.82f), p(0.70f, 0.82f), closed = true, width = 2.2f, stage = 0),
            label(0.08f, 0.10f, "Wood", stage = 0),
            label(0.41f, 0.10f, "Chrome", stage = 0),
            label(0.74f, 0.10f, "Cloth Fold", stage = 0),

            toneRect(0.20f, 0.22f, 0.10f, 0.60f, 0.22f, stage = 1),
            toneRect(0.38f, 0.22f, 0.24f, 0.24f, 0.78f, stage = 1),

            cubic(p(0.12f, 0.24f), p(0.16f, 0.42f), p(0.09f, 0.62f), p(0.13f, 0.80f), stage = 2, width = 1.8f),
            cubic(p(0.18f, 0.24f), p(0.23f, 0.45f), p(0.15f, 0.62f), p(0.19f, 0.80f), stage = 2, width = 2.2f),
            oval(0.16f, 0.50f, 0.025f, 0.045f, stage = 2, width = 2.0f),

            toneRect(0.38f, 0.46f, 0.24f, 0.14f, 0.03f, stage = 3),
            toneRect(0.38f, 0.60f, 0.24f, 0.22f, 0.48f, stage = 3),
            label(0.37f, 0.85f, "Sharp #1/#9 edge", stage = 3, StrokeRole.ANNOTATION_ARROW),

            focusRing(0.82f, 0.26f, stage = 4, r = 0.020f, StrokeRole.ANNOTATION_ARROW),
            quad(p(0.82f, 0.26f), p(0.74f, 0.56f), p(0.73f, 0.80f), stage = 4, width = 2.8f),
            quad(p(0.82f, 0.26f), p(0.88f, 0.56f), p(0.89f, 0.80f), stage = 4, width = 2.8f),
            quad(p(0.73f, 0.80f), p(0.81f, 0.86f), p(0.89f, 0.80f), stage = 4, width = 2.8f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Zebra Texture vs. Form-Locked Texture",
            wrongLabel = "Equal Dark Stripes Everywhere",
            rightLabel = "Value-Modulated Grain",
            whyMistakeHappens = "Drawing dark wood grain or brick cracks with equal strength in highlights destroys lighting illusion.",
            howToFix = "Keep bright sunlit faces whisper-light and place sharpest texture detail along the halftone-shadow boundary.",
            wrongElements = listOf(
                poly(p(0.18f, 0.22f), p(0.82f, 0.22f), p(0.82f, 0.80f), p(0.18f, 0.80f), closed = true, width = 2.6f, stage = 0),
                inkLine(0.30f, 0.22f, 0.30f, 0.80f, 0, 3.2f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.45f, 0.22f, 0.45f, 0.80f, 0, 3.2f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.60f, 0.22f, 0.60f, 0.80f, 0, 3.2f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.74f, 0.22f, 0.74f, 0.80f, 0, 3.2f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("No light/shadow, flat stripes")
            ),
            rightElements = listOf(
                poly(p(0.18f, 0.22f), p(0.82f, 0.22f), p(0.82f, 0.80f), p(0.18f, 0.80f), closed = true, width = 2.4f, stage = 0),
                toneRect(0.54f, 0.22f, 0.28f, 0.58f, 0.28f, 0),
                cubic(p(0.52f, 0.24f), p(0.56f, 0.46f), p(0.48f, 0.62f), p(0.53f, 0.78f), 0, width = 2.6f),
                cubic(p(0.64f, 0.24f), p(0.68f, 0.46f), p(0.60f, 0.62f), p(0.64f, 0.78f), 0, width = 2.0f),
                rightNote("Grain hugs terminator & shadow")
            )
        )
    ),

    // 25. Botanical Leaves & 3D Trees
    VisualDemoSpec(
        id = "vis_botanical_trees",
        title = "Botanical Midribs & 3D Tree Branching",
        category = VisualCategory.HUMAN_FIGURE,
        worldNumbers = listOf(8),
        skillIds = listOf("sk_botanical", "sk_trees_terrain"),
        summary = "Construct twisting leaves over a continuous midrib spine and radiate tree limbs cleanly in 360° depth.",
        revisitedConcepts = listOf("S-curves", "Cylinders", "Overlapping contours"),
        stages = listOf(
            ConstructionStage(1, "Sweep Continuous Midrib & Trunk Flow", "Draw the leaf's sweeping center spine and the tree's tapered trunk gesture first.", "A continuous spine prevents disjointed leaf folds."),
            ConstructionStage(2, "Wrap Asymmetric Folding Edges", "Draw one side curving behind the midrib while the front edge overlaps clearly.", "Breaks the flat pressed-flower look."),
            ConstructionStage(3, "Establish 3D Canopy & Cylinder Branches", "Radiate limbs from the trunk forward, sideways, and tucked behind—not flat left/right.", "Treat every limb as a tapering cylinder."),
            ConstructionStage(4, "Mass Leaf Clusters With Core Shadows", "Group foliage into big lit and shaded cloud spheres rather than drawing 500 tiny leaves.", "Big value masses make trees read effortlessly."),
            ConstructionStage(5, "Weight Overlapping Twigs & Clean Guides", "Reinforce overlapping bark curves and shadow undersides.", "Creates natural organic rhythm.", isCleanupStage = true)
        ),
        elements = listOf(
            cubic(p(0.10f, 0.76f), p(0.18f, 0.48f), p(0.28f, 0.30f), p(0.44f, 0.24f), stage = 0, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.6f, layer = VisualLayer.STRUCTURE),
            inkLine(0.68f, 0.84f, 0.68f, 0.42f, stage = 0, width = 3.0f),
            inkLine(0.75f, 0.84f, 0.73f, 0.44f, stage = 0, width = 2.8f),

            cubic(p(0.14f, 0.64f), p(0.10f, 0.32f), p(0.26f, 0.24f), p(0.44f, 0.24f), stage = 1, width = 2.6f),
            cubic(p(0.14f, 0.64f), p(0.34f, 0.66f), p(0.40f, 0.40f), p(0.44f, 0.24f), stage = 1, width = 2.6f),
            label(0.08f, 0.12f, "2. Leaf twists over midrib", stage = 1, StrokeRole.CORRECTION_HIGHLIGHT),

            inkLine(0.68f, 0.52f, 0.54f, 0.32f, stage = 2, width = 2.6f),
            inkLine(0.73f, 0.46f, 0.86f, 0.28f, stage = 2, width = 2.4f),
            inkLine(0.71f, 0.48f, 0.72f, 0.22f, stage = 2, width = 2.2f),

            oval(0.60f, 0.30f, 0.12f, 0.10f, stage = 3, role = StrokeRole.SHADING_TONE, width = 1.8f, fillAlpha = 0.14f, layer = VisualLayer.SHADING),
            oval(0.78f, 0.24f, 0.13f, 0.11f, stage = 3, role = StrokeRole.SHADING_TONE, width = 1.8f, fillAlpha = 0.20f, layer = VisualLayer.SHADING),
            label(0.54f, 0.08f, "4. Canopy shadow masses", stage = 3),

            boldLine(0.14f, 0.64f, 0.22f, 0.54f, stage = 4, width = 3.4f),
            boldLine(0.68f, 0.84f, 0.75f, 0.84f, stage = 4, width = 4.0f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Candelabra Tree vs. 3D Overlapping Branches",
            wrongLabel = "Flat 2D Y-Fork Sticks",
            rightLabel = "Tapered 3D Limb Overlaps",
            whyMistakeHappens = "Branching strictly sideways in one plane makes trees look pressed flat between glass.",
            howToFix = "Aim some branches toward the viewer with overlapping collar rings and group foliage into shadowed spheres.",
            wrongElements = listOf(
                inkLine(0.50f, 0.84f, 0.50f, 0.48f, 0, 3.0f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.50f, 0.48f, 0.24f, 0.24f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.50f, 0.48f, 0.76f, 0.24f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Flat 2D symmetrical Y-stick")
            ),
            rightElements = listOf(
                inkLine(0.46f, 0.84f, 0.46f, 0.46f, 0, 3.2f),
                inkLine(0.54f, 0.84f, 0.52f, 0.48f, 0, 3.0f),
                inkLine(0.46f, 0.54f, 0.26f, 0.30f, 0, 2.6f),
                inkLine(0.52f, 0.48f, 0.74f, 0.28f, 0, 2.4f),
                oval(0.48f, 0.26f, 0.24f, 0.14f, 0, width = 2.0f, fillAlpha = 0.14f),
                rightNote("Tapering trunk + layered masses")
            )
        )
    ),

    // 26. Animal Construction
    VisualDemoSpec(
        id = "vis_animal_construction",
        title = "Animal Volume Construction (Ribcage & Pelvis)",
        category = VisualCategory.HUMAN_FIGURE,
        worldNumbers = listOf(8),
        skillIds = listOf("sk_animal_struct", "sk_animal_coat"),
        summary = "Construct quadrupeds by linking an S-curve spine, large ribcage egg, tilted pelvis wedge, and hinged limb segments.",
        revisitedConcepts = listOf("Spheres & cylinders", "Form intersections"),
        stages = listOf(
            ConstructionStage(1, "Sweep Dynamic Spine Line of Action", "Draw the curved neck-back-tail S-curve before adding any legs or fur.", "Captures graceful animal balance and posture instantly."),
            ConstructionStage(2, "Block Ribcage Egg & Pelvis Mass", "Place a large oval ribcage forward and a smaller tilted pelvis oval behind.", "Remember: quadruped ribcages are deep vertically, not flat tubes."),
            ConstructionStage(3, "Attach Cranium Sphere & Muzzle Box", "Seat a skull sphere at the neck end and protrude a boxy wedge snout.", "Separating snout box from cranium prevents flat side-view faces."),
            ConstructionStage(4, "Hinge Jointed Limb Segments", "Plot shoulder blade, elbow, wrist/hock zigzags down to ground paws.", "Animal hind legs hinge backward at the hock—check joint directions carefully."),
            ConstructionStage(5, "Refine Contour, Directional Fur & Grounding", "Unify outer silhouette over forms and shade underside belly/limb shadows.", "Fur clumps follow underlying ribcage curvature.", isCleanupStage = true)
        ),
        elements = listOf(
            cubic(p(0.18f, 0.32f), p(0.32f, 0.44f), p(0.58f, 0.34f), p(0.84f, 0.46f), stage = 0, role = StrokeRole.ANNOTATION_ARROW, width = 2.4f, layer = VisualLayer.STRUCTURE),
            label(0.14f, 0.10f, "1. Continuous neck-to-spine flow", stage = 0, StrokeRole.ANNOTATION_ARROW),

            oval(0.42f, 0.48f, 0.14f, 0.12f, stage = 1, role = StrokeRole.AXIS_AND_PLUMB, width = 2.4f, layer = VisualLayer.STRUCTURE),
            oval(0.68f, 0.47f, 0.09f, 0.095f, stage = 1, role = StrokeRole.AXIS_AND_PLUMB, width = 2.4f, layer = VisualLayer.STRUCTURE),
            inkLine(0.42f, 0.36f, 0.68f, 0.375f, stage = 1, width = 2.2f),

            oval(0.24f, 0.28f, 0.07f, 0.065f, stage = 2, width = 2.4f),
            poly(p(0.11f, 0.28f), p(0.19f, 0.25f), p(0.20f, 0.34f), p(0.11f, 0.33f), closed = true, width = 2.4f, stage = 2),
            inkLine(0.27f, 0.22f, 0.38f, 0.38f, stage = 2, width = 2.4f),

            poly(p(0.36f, 0.48f), p(0.34f, 0.66f), p(0.36f, 0.84f), role = StrokeRole.PRIMARY_CONTOUR, width = 2.8f, stage = 3),
            poly(p(0.70f, 0.50f), p(0.64f, 0.66f), p(0.74f, 0.72f), p(0.72f, 0.84f), role = StrokeRole.PRIMARY_CONTOUR, width = 2.8f, stage = 3),
            focusRing(0.74f, 0.72f, stage = 3, r = 0.025f, StrokeRole.CORRECTION_HIGHLIGHT),

            quad(p(0.38f, 0.60f), p(0.54f, 0.60f), p(0.66f, 0.56f), stage = 4, width = 2.8f),
            boldLine(0.32f, 0.84f, 0.40f, 0.84f, stage = 4, width = 3.8f),
            boldLine(0.68f, 0.84f, 0.76f, 0.84f, stage = 4, width = 3.8f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Sausage + Stick Legs vs. Ribcage/Pelvis Masses",
            wrongLabel = "Even Tube + Straight Stick Legs",
            rightLabel = "Deep Ribcage + Hinged Hock",
            whyMistakeHappens = "Connecting straight pillar legs onto a flat horizontal tube ignores the deep chest and angled hind hock.",
            howToFix = "Build a deep oval ribcage, smaller pelvis, and draw the three-segment hind leg Z-hinge cleanly.",
            wrongElements = listOf(
                poly(p(0.24f, 0.40f), p(0.76f, 0.40f), p(0.76f, 0.56f), p(0.24f, 0.56f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.6f, stage = 0),
                inkLine(0.30f, 0.56f, 0.30f, 0.84f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.70f, 0.56f, 0.70f, 0.84f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Flat rectangle torso & stiff sticks")
            ),
            rightElements = listOf(
                oval(0.38f, 0.46f, 0.15f, 0.13f, 0, width = 2.6f),
                oval(0.68f, 0.46f, 0.09f, 0.10f, 0, width = 2.6f),
                poly(p(0.34f, 0.48f), p(0.32f, 0.66f), p(0.35f, 0.84f), width = 2.8f, stage = 0),
                poly(p(0.69f, 0.48f), p(0.63f, 0.66f), p(0.74f, 0.72f), p(0.72f, 0.84f), width = 2.8f, stage = 0),
                rightNote("Deep chest + natural joint angles")
            )
        )
    )
)
