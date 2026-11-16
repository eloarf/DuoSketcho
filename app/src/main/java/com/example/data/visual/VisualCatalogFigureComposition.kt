package com.example.data.visual

import com.example.domain.model.ConstructionStage
import com.example.domain.model.MistakeComparisonSpec
import com.example.domain.model.StrokeRole
import com.example.domain.model.VisualCategory
import com.example.domain.model.VisualDemoSpec
import com.example.domain.model.VisualLayer

internal fun figureAndCompositionVisualDemos(): List<VisualDemoSpec> = listOf(
    // 27. Human Figure Construction (7 Stages matching Section 2!)
    VisualDemoSpec(
        id = "vis_figure_gesture",
        title = "Human Figure: Gesture to Volume (7 Stages)",
        category = VisualCategory.HUMAN_FIGURE,
        worldNumbers = listOf(9),
        skillIds = listOf("sk_gesture", "sk_fig_prop", "sk_anatomy_core"),
        summary = "Take a dynamic standing pose from a single Line of Action through ribcage, pelvis, limb cylinders, 8-head proportions, and volume.",
        revisitedConcepts = listOf("C/S curves", "Box & cylinder primitives", "Plumb balance"),
        stages = listOf(
            ConstructionStage(1, "Establish Line of Action", "Sweep one fluid C/S curve from crown through spine down the weight-bearing leg.", "Captures balance and rhythm in 5 seconds before details."),
            ConstructionStage(2, "Add Head & Counter-Tilted Axes", "Place the head oval on top and oppose shoulder tilt against opposite hip tilt (contrapposto).", "Opposing tilts create natural weight shift instead of stiff soldier posture."),
            ConstructionStage(3, "Construct the Ribcage Mass", "Build an egg/box ribcage tilted along the upper spine axis.", "Marks the broad upper thoracic volume and collarbone line."),
            ConstructionStage(4, "Add Tilted Pelvis Wedge", "Connect a sturdy box/wedge pelvis angled inversely beneath the ribcage.", "The pinched waist vs. stretched side brings instant life to the torso."),
            ConstructionStage(5, "Connect Cylindrical Limbs & Joints", "Attach tapering cylinder arms and legs following the gesture arc to grounded feet.", "Drop a gravity plumb from the neck pit straight to the planted ankle."),
            ConstructionStage(6, "Refine Proportions (8-Head Canon)", "Check key landmarks on the right 8-head ruler: chin (1), chest (2), waist (3), hip/wrist (4), knees (6), heels (8).", "Catches oversized torsos or stubby legs early."),
            ConstructionStage(7, "Add Volume, Cross-Contours & Anatomy Shadow", "Wrap anatomical contours (pectorals, deltoids, calves) and shade the right shadow side.", "Turns mannequin construction into cohesive human solidity.", isCleanupStage = true)
        ),
        elements = listOf(
            // Stage 0: Line of Action + Gravity plumb
            cubic(p(0.42f, 0.14f), p(0.32f, 0.36f), p(0.48f, 0.56f), p(0.38f, 0.88f), stage = 0, role = StrokeRole.ANNOTATION_ARROW, width = 2.6f, layer = VisualLayer.STRUCTURE),
            label(0.06f, 0.06f, "1. Line of action", stage = 0, StrokeRole.ANNOTATION_ARROW),

            // Stage 1: Head & counter-tilted shoulder/hip lines
            oval(0.42f, 0.14f, 0.045f, 0.055f, stage = 1, width = 2.4f),
            axisLine(0.28f, 0.23f, 0.54f, 0.27f, stage = 1, dashed = false, width = 2.4f),
            axisLine(0.31f, 0.49f, 0.53f, 0.44f, stage = 1, dashed = false, width = 2.4f),

            // Stage 2: Ribcage
            poly(p(0.33f, 0.24f), p(0.51f, 0.27f), p(0.48f, 0.39f), p(0.34f, 0.37f), closed = true, role = StrokeRole.AXIS_AND_PLUMB, width = 2.4f, stage = 2, layer = VisualLayer.STRUCTURE),

            // Stage 3: Pelvis
            poly(p(0.34f, 0.42f), p(0.49f, 0.40f), p(0.51f, 0.49f), p(0.32f, 0.51f), closed = true, role = StrokeRole.AXIS_AND_PLUMB, width = 2.4f, stage = 3, layer = VisualLayer.STRUCTURE),

            // Stage 4: Limbs & plumb balance
            inkLine(0.31f, 0.24f, 0.24f, 0.40f, stage = 4, width = 2.4f),
            inkLine(0.24f, 0.40f, 0.26f, 0.54f, stage = 4, width = 2.2f),
            inkLine(0.52f, 0.27f, 0.59f, 0.42f, stage = 4, width = 2.4f),
            inkLine(0.59f, 0.42f, 0.57f, 0.56f, stage = 4, width = 2.2f),
            inkLine(0.35f, 0.50f, 0.38f, 0.68f, stage = 4, width = 2.8f),
            inkLine(0.38f, 0.68f, 0.38f, 0.88f, stage = 4, width = 2.6f),
            inkLine(0.49f, 0.48f, 0.56f, 0.66f, stage = 4, width = 2.8f),
            inkLine(0.56f, 0.66f, 0.58f, 0.86f, stage = 4, width = 2.6f),

            // Stage 5: 8-Head proportion ruler on right
            axisLine(0.76f, 0.085f, 0.76f, 0.885f, stage = 5, dashed = false, width = 1.8f),
            inkLine(0.74f, 0.085f, 0.78f, 0.085f, stage = 5, width = 1.8f),
            inkLine(0.74f, 0.185f, 0.78f, 0.185f, stage = 5, width = 1.8f),
            inkLine(0.74f, 0.285f, 0.78f, 0.285f, stage = 5, width = 1.8f),
            inkLine(0.74f, 0.385f, 0.78f, 0.385f, stage = 5, width = 1.8f),
            inkLine(0.74f, 0.485f, 0.78f, 0.485f, stage = 5, width = 2.4f),
            inkLine(0.74f, 0.685f, 0.78f, 0.685f, stage = 5, width = 1.8f),
            inkLine(0.74f, 0.885f, 0.78f, 0.885f, stage = 5, width = 1.8f),
            label(0.80f, 0.08f, "0 Crown", stage = 5),
            label(0.80f, 0.46f, "4 Hip", stage = 5, StrokeRole.ANNOTATION_ARROW),
            label(0.80f, 0.85f, "8 Feet", stage = 5),

            // Stage 6: Volume contours & shadow side
            quad(p(0.32f, 0.37f), p(0.30f, 0.42f), p(0.33f, 0.49f), stage = 6, width = 2.8f),
            quad(p(0.51f, 0.27f), p(0.49f, 0.37f), p(0.50f, 0.46f), stage = 6, width = 2.8f),
            hatch(listOf(
                p(0.45f, 0.26f) to p(0.45f, 0.47f),
                p(0.48f, 0.27f) to p(0.48f, 0.48f)
            ), stage = 6),
            boldLine(0.34f, 0.88f, 0.42f, 0.88f, stage = 6, width = 3.8f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Stiff Parallel Snowman vs. Dynamic Contrapposto",
            wrongLabel = "Parallel Horizontal Levels",
            rightLabel = "Counter-Tilted Weight Shift",
            whyMistakeHappens = "Keeping shoulders, waist, and hips horizontally level makes standing poses look rigid and robotic.",
            howToFix = "Tilt the shoulder axis down on one side, tilt the pelvis opposite, and align the planted ankle under the neck pit.",
            wrongElements = listOf(
                oval(0.50f, 0.16f, 0.07f, 0.07f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.6f),
                inkLine(0.32f, 0.28f, 0.68f, 0.28f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                poly(p(0.36f, 0.28f), p(0.64f, 0.28f), p(0.64f, 0.56f), p(0.36f, 0.56f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.6f, stage = 0),
                inkLine(0.40f, 0.56f, 0.40f, 0.86f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.60f, 0.56f, 0.60f, 0.86f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Stiff robot rectangle")
            ),
            rightElements = listOf(
                cubic(p(0.50f, 0.14f), p(0.38f, 0.36f), p(0.56f, 0.54f), p(0.46f, 0.86f), 0, StrokeRole.ANNOTATION_ARROW, 2.4f),
                oval(0.50f, 0.16f, 0.06f, 0.07f, 0, width = 2.6f),
                axisLine(0.33f, 0.25f, 0.65f, 0.31f, 0, dashed = false, width = 2.4f),
                axisLine(0.35f, 0.53f, 0.63f, 0.47f, 0, dashed = false, width = 2.4f),
                inkLine(0.42f, 0.52f, 0.46f, 0.86f, 0, 2.8f),
                inkLine(0.58f, 0.49f, 0.66f, 0.84f, 0, 2.8f),
                rightNote("Natural opposing shoulder/hip tilts")
            )
        )
    ),

    // 28. Hands & Feet Construction
    VisualDemoSpec(
        id = "vis_hands_feet",
        title = "Hands (Palm Box) & Feet (Wedge Arch)",
        category = VisualCategory.HUMAN_FIGURE,
        worldNumbers = listOf(9),
        skillIds = listOf("sk_hands_feet"),
        summary = "Simplify tricky hands into a curved palm box, thumb wedge, and knuckle arc—and ground feet with a solid triangular wedge.",
        revisitedConcepts = listOf("Box perspective", "Curved knuckle arcs"),
        stages = listOf(
            ConstructionStage(1, "Block Trapezoid Palm & Wedge Foot", "Draw a slightly curved trapezoid box for the palm and a triangular wedge for the foot.", "Establishes mass, thickness, and perspective tilt immediately."),
            ConstructionStage(2, "Attach Thumb Wedge & Ankle Cylinder", "Add the triangular thumb pad on the palm side and a cylinder ankle rising off the heel.", "The thumb sits in a separate rotational plane from the other four fingers."),
            ConstructionStage(3, "Draw Curved Knuckle & Finger Tip Arcs", "Sweep gentle convex arcs across the knuckle joints and fingertip boundaries.", "Fingers step in unequal graceful arcs—never straight ruler rows."),
            ConstructionStage(4, "Place Simplified Finger & Toe Cylinders", "Block the four fingers tapering smoothly toward their curved arcs.", "Group middle and ring fingers together slightly for natural gesture."),
            ConstructionStage(5, "Refine Joint Creases & Ground Weight", "Accentuate palm folds, tendon lines, and heavy arch-to-heel floor contact.", "Anchors hands and feet firmly in 3D space.", isCleanupStage = true)
        ),
        elements = listOf(
            // Left: Hand construction
            poly(p(0.16f, 0.46f), p(0.38f, 0.42f), p(0.36f, 0.74f), p(0.18f, 0.74f), closed = true, width = 2.6f, stage = 0),
            // Right: Foot wedge
            poly(p(0.62f, 0.48f), p(0.76f, 0.48f), p(0.92f, 0.72f), p(0.60f, 0.76f), closed = true, width = 2.6f, stage = 0),

            poly(p(0.38f, 0.56f), p(0.49f, 0.46f), p(0.46f, 0.70f), p(0.36f, 0.74f), closed = true, width = 2.4f, stage = 1),
            inkLine(0.63f, 0.22f, 0.62f, 0.48f, stage = 1, width = 2.6f),
            inkLine(0.75f, 0.22f, 0.76f, 0.48f, stage = 1, width = 2.6f),

            quad(p(0.14f, 0.44f), p(0.27f, 0.36f), p(0.40f, 0.42f), stage = 2, role = StrokeRole.AXIS_AND_PLUMB, width = 2.0f, dashed = true, layer = VisualLayer.STRUCTURE),
            quad(p(0.11f, 0.20f), p(0.27f, 0.10f), p(0.43f, 0.22f), stage = 2, role = StrokeRole.AXIS_AND_PLUMB, width = 2.0f, dashed = true, layer = VisualLayer.STRUCTURE),
            label(0.08f, 0.05f, "3. Curved knuckle & tip arcs", stage = 2),

            inkLine(0.16f, 0.46f, 0.14f, 0.22f, stage = 3, width = 2.4f),
            inkLine(0.22f, 0.44f, 0.22f, 0.16f, stage = 3, width = 2.4f),
            inkLine(0.28f, 0.43f, 0.29f, 0.15f, stage = 3, width = 2.4f),
            inkLine(0.34f, 0.43f, 0.36f, 0.19f, stage = 3, width = 2.4f),
            inkLine(0.38f, 0.43f, 0.41f, 0.26f, stage = 3, width = 2.2f),

            quad(p(0.64f, 0.76f), p(0.76f, 0.71f), p(0.88f, 0.75f), stage = 4, width = 2.8f),
            boldLine(0.60f, 0.76f, 0.92f, 0.76f, stage = 4, width = 4.0f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Fork Hands vs. Curved Palm Box + Arcs",
            wrongLabel = "Equal Straight Fork Prongs",
            rightLabel = "Trapezoid Palm + Knuckle Arc",
            whyMistakeHappens = "Drawing fingers as five equal-height cylinders sprouting from a flat square line makes hands look wooden.",
            howToFix = "Curve the knuckle line gently upward, vary finger lengths along an outer arc, and angle the thumb separately.",
            wrongElements = listOf(
                poly(p(0.28f, 0.48f), p(0.72f, 0.48f), p(0.72f, 0.80f), p(0.28f, 0.80f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, width = 2.6f, stage = 0),
                inkLine(0.32f, 0.48f, 0.32f, 0.20f, 0, 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.45f, 0.48f, 0.45f, 0.20f, 0, 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.58f, 0.48f, 0.58f, 0.20f, 0, 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.70f, 0.48f, 0.70f, 0.20f, 0, 2.6f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Flat square + identical forks")
            ),
            rightElements = listOf(
                poly(p(0.30f, 0.48f), p(0.68f, 0.44f), p(0.66f, 0.78f), p(0.32f, 0.78f), closed = true, width = 2.6f, stage = 0),
                poly(p(0.68f, 0.58f), p(0.84f, 0.48f), p(0.80f, 0.74f), p(0.66f, 0.78f), closed = true, width = 2.4f, stage = 0),
                quad(p(0.28f, 0.24f), p(0.49f, 0.10f), p(0.70f, 0.28f), 0, StrokeRole.CORRECTION_HIGHLIGHT, 1.8f, dashed = true),
                inkLine(0.32f, 0.48f, 0.28f, 0.24f, 0, 2.6f),
                inkLine(0.44f, 0.46f, 0.45f, 0.16f, 0, 2.6f),
                inkLine(0.56f, 0.45f, 0.58f, 0.18f, 0, 2.6f),
                inkLine(0.67f, 0.45f, 0.70f, 0.28f, 0, 2.4f),
                rightNote("Stepped tip arc + thumb wedge")
            )
        )
    ),

    // 29. Portrait — Loomis Head Construction (7 Stages matching Section 2!)
    VisualDemoSpec(
        id = "vis_portrait_loomis",
        title = "Portrait: Loomis Head Construction (7 Stages)",
        category = VisualCategory.PORTRAITS,
        worldNumbers = listOf(10),
        skillIds = listOf("sk_loomis_head"),
        summary = "Construct a tilted 3/4 head from a sphere, sliced temporal plane, wrapping centerline, proportional thirds, features, planes, and shadow.",
        revisitedConcepts = listOf("Sphere equator", "Cross-contours", "Terminator shading"),
        stages = listOf(
            ConstructionStage(1, "Begin With Cranium Sphere", "Draw a clean circle representing the upper cranial ball before adding the jaw.", "Establishes the skull's 3D tilt before features compete for attention."),
            ConstructionStage(2, "Establish Wrapping Centerline & Temporal Slice", "Slice a flat oval off the side of the sphere and curve the front vertical centerline around the 3/4 turn.", "Because heads are round—not flat masks—the centerline wraps asymmetrically."),
            ConstructionStage(3, "Add Brow & Facial Guideline (Thirds)", "Wrap the horizontal brow line across the temporal cross-center and step equal thirds: Hairline -> Brow -> Nose -> Chin.", "Locks symmetrical eye and nose alignment regardless of head tilt."),
            ConstructionStage(4, "Establish Eye Placement & Jaw Wedge", "Drop the jaw line down from the front cheek and chin while placing eye sockets directly under the brow ridge.", "Keep the jaw corner tucked cleanly below the ear's lower quadrant."),
            ConstructionStage(5, "Construct Nose Bridge & Mouth Alignment", "Project the triangular nose prism out from the centerline and wrap the mouth cylinder halfway between nose and chin.", "Remember the nose projects forward off the flat face mask."),
            ConstructionStage(6, "Refine Facial Planes & Ear Placement", "Seat the ear inside the lower-back temporal quadrant (between brow and nose lines) and chisel cheekbone planes.", "Separating front and side planes keeps features locked in perspective."),
            ConstructionStage(7, "Add Light, Shadow & Structural Detail", "Group shadow under the brow shelf, nose underside, lower lip shadow, and jawline cast shadow.", "Clean shadow planes unify the portrait into three dimensions.", isCleanupStage = true)
        ),
        elements = listOf(
            // Stage 0: Cranium sphere
            oval(0.44f, 0.40f, 0.24f, 0.24f, stage = 0, width = 2.6f),

            // Stage 1: Temporal side slice + wrapping vertical centerline
            oval(0.55f, 0.40f, 0.11f, 0.16f, stage = 1, role = StrokeRole.AXIS_AND_PLUMB, width = 2.2f, layer = VisualLayer.STRUCTURE),
            cubic(p(0.36f, 0.16f), p(0.28f, 0.36f), p(0.28f, 0.62f), p(0.36f, 0.86f), stage = 1, role = StrokeRole.ANNOTATION_ARROW, width = 2.2f, layer = VisualLayer.STRUCTURE),
            label(0.05f, 0.08f, "2. Temporal slice + curved centerline", stage = 1),

            // Stage 2: Brow line & equal thirds
            quad(p(0.20f, 0.40f), p(0.38f, 0.42f), p(0.66f, 0.40f), stage = 2, role = StrokeRole.ANNOTATION_ARROW, width = 2.2f, layer = VisualLayer.STRUCTURE),
            guideLine(0.24f, 0.24f, 0.62f, 0.24f, stage = 2),
            guideLine(0.26f, 0.60f, 0.56f, 0.60f, stage = 2),
            guideLine(0.30f, 0.86f, 0.48f, 0.86f, stage = 2),
            label(0.69f, 0.22f, "1/3 Hair", stage = 2),
            label(0.69f, 0.40f, "1/3 Brow", stage = 2, StrokeRole.ANNOTATION_ARROW),
            label(0.69f, 0.60f, "1/3 Nose", stage = 2),
            label(0.69f, 0.82f, "1/3 Chin", stage = 2),

            // Stage 3: Jaw contour + eye sockets
            poly(p(0.20f, 0.42f), p(0.24f, 0.68f), p(0.36f, 0.86f), p(0.50f, 0.78f), p(0.56f, 0.56f), width = 2.8f, stage = 3),
            oval(0.27f, 0.45f, 0.036f, 0.018f, stage = 3, width = 2.4f),
            oval(0.40f, 0.45f, 0.044f, 0.020f, stage = 3, width = 2.4f),

            // Stage 4: Nose wedge & mouth curve
            poly(p(0.32f, 0.42f), p(0.27f, 0.58f), p(0.35f, 0.60f), width = 2.5f, stage = 4),
            quad(p(0.28f, 0.71f), p(0.35f, 0.73f), p(0.42f, 0.71f), stage = 4, width = 2.4f),

            // Stage 5: Ear in lower-back quadrant & cheekbone plane
            oval(0.58f, 0.51f, 0.032f, 0.068f, stage = 5, width = 2.5f),
            inkLine(0.48f, 0.42f, 0.52f, 0.64f, stage = 5, width = 1.8f, role = StrokeRole.AXIS_AND_PLUMB),

            // Stage 6: Shadow side planes & hair top mass
            hatch(listOf(
                p(0.50f, 0.42f) to p(0.49f, 0.78f),
                p(0.54f, 0.43f) to p(0.53f, 0.74f),
                p(0.58f, 0.44f) to p(0.57f, 0.68f)
            ), stage = 6),
            boldLine(0.27f, 0.58f, 0.35f, 0.60f, stage = 6, width = 3.4f),
            boldLine(0.36f, 0.86f, 0.50f, 0.78f, stage = 6, width = 3.6f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Sticker Eyes on 3/4 Head vs. Wrapping Loomis Planes",
            wrongLabel = "Identical Flat Front Eyes",
            rightLabel = "Wrapped Centerline + Recessed Sockets",
            whyMistakeHappens = "Drawing both eyes the exact same width and flattening the nose sideways breaks 3/4 head rotation.",
            howToFix = "Curve the vertical centerline around the face mask, narrow the far eye subtly, and recess both inside brow sockets.",
            wrongElements = listOf(
                oval(0.48f, 0.48f, 0.24f, 0.32f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.6f),
                oval(0.36f, 0.44f, 0.06f, 0.03f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.6f),
                oval(0.58f, 0.44f, 0.06f, 0.03f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.6f),
                inkLine(0.47f, 0.20f, 0.47f, 0.76f, 0, 2.2f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Flat center line + twin sticker eyes")
            ),
            rightElements = listOf(
                oval(0.48f, 0.42f, 0.22f, 0.22f, 0, width = 2.2f),
                cubic(p(0.38f, 0.20f), p(0.30f, 0.42f), p(0.30f, 0.66f), p(0.38f, 0.84f), 0, StrokeRole.ANNOTATION_ARROW, 2.2f),
                poly(p(0.26f, 0.42f), p(0.28f, 0.68f), p(0.38f, 0.84f), p(0.56f, 0.76f), p(0.64f, 0.52f), width = 2.6f, stage = 0),
                oval(0.29f, 0.45f, 0.032f, 0.018f, 0, width = 2.4f),
                oval(0.43f, 0.45f, 0.044f, 0.020f, 0, width = 2.4f),
                rightNote("Far eye foreshortens around curve")
            )
        )
    ),

    // 30. Portrait Features (Eyes, Nose, Mouth, Ears & Expressions)
    VisualDemoSpec(
        id = "vis_portrait_features",
        title = "Eyes, Nose Planes, Mouth Cylinder & Ears",
        category = VisualCategory.PORTRAITS,
        worldNumbers = listOf(10),
        skillIds = listOf("sk_eyes_nose", "sk_mouth_ears_hair", "sk_expressions"),
        summary = "Construct facial features as 3D curved structures—wrapping eyelids over an eyeball sphere, nose prism, and mouth cylinder.",
        revisitedConcepts = listOf("Sphere roundness", "Plane shading"),
        stages = listOf(
            ConstructionStage(1, "Wrap Eye Lids Over Eyeball Sphere", "Draw the round eyeball first, then wrap thick upper/lower eyelid arcs tightly over it.", "Eyelids curve in 3D thickness—never draw flat almond stickers."),
            ConstructionStage(2, "Block Keystone & Nose Prism Planes", "Divide the nose into a flat front bridge, ball tip sphere, wing nostrils, and shaded underside triangle.", "Shading the underside plane instantly lifts the nose off the cheek."),
            ConstructionStage(3, "Wrap Lips Over Curved Dental Cylinder", "Treat the mouth like wrapping clay around a half-cylinder so mouth corners tuck gently backward.", "Shade the top lip dark and leave the lower lip catching light with a cast shadow underneath."),
            ConstructionStage(4, "Sculpt Ear C-Rim & Y-Ridge", "Frame the tilted C-shape outer helix and internal Y-cartilage inside brow-to-nose height.", "Avoid outlining intricate inner spirals—focus on big shadow pockets."),
            ConstructionStage(5, "Show Facial Expression & Hair Ribbon Masses", "Lower/raise brow muscles for expression and group hair into broad sculpted S-ribbons.", "Squash and stretch brows while keeping the bony skull constant.")
        ),
        elements = listOf(
            // Top-left: Eye wrapped on sphere
            oval(0.28f, 0.28f, 0.11f, 0.11f, stage = 0, role = StrokeRole.CONSTRUCTION_GUIDE, width = 1.8f, dashed = true, layer = VisualLayer.GUIDE),
            quad(p(0.14f, 0.28f), p(0.28f, 0.19f), p(0.42f, 0.29f), stage = 0, width = 2.8f),
            quad(p(0.14f, 0.28f), p(0.28f, 0.36f), p(0.42f, 0.29f), stage = 0, width = 2.2f),
            oval(0.28f, 0.27f, 0.042f, 0.042f, stage = 0, width = 2.4f, fillAlpha = 0.20f),
            label(0.12f, 0.08f, "1. Lids hug sphere", stage = 0),

            // Top-right: Nose 3D prism planes
            poly(p(0.68f, 0.14f), p(0.75f, 0.14f), p(0.78f, 0.38f), p(0.65f, 0.38f), closed = true, width = 2.4f, stage = 1),
            poly(p(0.65f, 0.38f), p(0.78f, 0.38f), p(0.72f, 0.44f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.35f, width = 2.2f, stage = 1, layer = VisualLayer.SHADING),
            oval(0.63f, 0.38f, 0.032f, 0.025f, stage = 1, width = 2.2f),
            oval(0.80f, 0.38f, 0.032f, 0.025f, stage = 1, width = 2.2f),
            label(0.58f, 0.06f, "2. Nose bridge + shadow base", stage = 1),

            // Bottom-left: Mouth wrapping cylinder
            quad(p(0.14f, 0.70f), p(0.28f, 0.63f), p(0.42f, 0.70f), stage = 2, width = 2.5f),
            quad(p(0.14f, 0.70f), p(0.28f, 0.73f), p(0.42f, 0.70f), stage = 2, width = 2.8f),
            quad(p(0.18f, 0.72f), p(0.28f, 0.80f), p(0.38f, 0.72f), stage = 2, width = 2.2f),
            toneRect(0.22f, 0.80f, 0.12f, 0.025f, 0.38f, stage = 2),
            label(0.12f, 0.54f, "3. Upper shade + under-lip cast", stage = 2),

            // Bottom-right: Ear C-Helix + Y-Ridge
            cubic(p(0.66f, 0.58f), p(0.84f, 0.52f), p(0.84f, 0.86f), p(0.68f, 0.84f), stage = 3, width = 2.8f),
            cubic(p(0.68f, 0.64f), p(0.76f, 0.62f), p(0.78f, 0.74f), p(0.70f, 0.78f), stage = 3, width = 2.2f),
            label(0.62f, 0.50f, "4. Ear C + Y ridge", stage = 3),

            boldLine(0.14f, 0.28f, 0.28f, 0.21f, stage = 4, width = 3.6f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Flat Symbol Mouth vs. Cylindrical Volume Lips",
            wrongLabel = "Dark Outlined Fish-Lips",
            rightLabel = "Shaded Top Lip + Under-Lip Cast",
            whyMistakeHappens = "Outlining the entire bright lower lip in heavy black ink makes mouths look like painted stickers.",
            howToFix = "Shade the downward-tilting upper lip darker, soften the bottom lip edge, and place a small cast shadow underneath.",
            wrongElements = listOf(
                quad(p(0.18f, 0.52f), p(0.50f, 0.34f), p(0.82f, 0.52f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 3.4f),
                quad(p(0.18f, 0.52f), p(0.50f, 0.70f), p(0.82f, 0.52f), 0, StrokeRole.MISTAKE_HIGHLIGHT, 3.4f),
                inkLine(0.18f, 0.52f, 0.82f, 0.52f, 0, 3.0f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Hard dark outline around bright bottom lip")
            ),
            rightElements = listOf(
                poly(p(0.20f, 0.52f), p(0.42f, 0.42f), p(0.50f, 0.45f), p(0.58f, 0.42f), p(0.80f, 0.52f), p(0.50f, 0.54f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.36f, width = 2.2f, stage = 0),
                quad(p(0.26f, 0.54f), p(0.50f, 0.66f), p(0.74f, 0.54f), 0, width = 1.6f),
                oval(0.50f, 0.68f, 0.14f, 0.025f, 0, role = StrokeRole.SHADING_TONE, fillAlpha = 0.45f, layer = VisualLayer.SHADING),
                rightNote("Shaded top plane + soft under-lip shadow")
            )
        )
    ),

    // 31. Composition Thumbnails & Rule of Thirds
    VisualDemoSpec(
        id = "vis_composition_thirds",
        title = "Composition Thumbnails & Focal Contrast",
        category = VisualCategory.COMPOSITION_ENVIRONMENTS,
        worldNumbers = listOf(11),
        skillIds = listOf("sk_comp_focal", "sk_storytelling"),
        summary = "Plan compositions in small 3-value thumbnails placing highest contrast at a Rule-of-Thirds focal intersection.",
        revisitedConcepts = listOf("3-value grouping", "Overlapping silhouettes"),
        stages = listOf(
            ConstructionStage(1, "Divide Frame With Rule-of-Thirds Grid", "Draw two vertical and two horizontal thirds lines inside a neat border.", "Avoid placing primary focal objects dead center or kissing outer corners."),
            ConstructionStage(2, "Anchor Focal Point at Power Intersection", "Place your hero subject right on one of the four thirds crossings.", "Off-center balance naturally invites the eye to explore the scene."),
            ConstructionStage(3, "Design Leading Diagonal Path", "Aim foreground terrain, roads, or roof ridges straight toward the focal anchor.", "Guides the viewer's gaze smoothly back into the frame."),
            ConstructionStage(4, "Mass Three Clear Values (FG / MG / BG)", "Block dark foreground silhouettes, midtone midground, and pale bright sky around focal point.", "Greatest dark-against-light contrast belongs strictly on the hero."),
            ConstructionStage(5, "Audit Tangents & Edge Exits", "Check that nothing points awkwardly into the frame corners before full rendering.", "Strong 3-value thumbnails guarantee strong full drawings.", isCleanupStage = true)
        ),
        elements = listOf(
            poly(p(0.08f, 0.12f), p(0.92f, 0.12f), p(0.92f, 0.88f), p(0.08f, 0.88f), closed = true, width = 2.6f, stage = 0),
            axisLine(0.36f, 0.12f, 0.36f, 0.88f, stage = 0),
            axisLine(0.64f, 0.12f, 0.64f, 0.88f, stage = 0),
            axisLine(0.08f, 0.37f, 0.92f, 0.37f, stage = 0),
            axisLine(0.08f, 0.63f, 0.92f, 0.63f, stage = 0),

            focusRing(0.64f, 0.37f, stage = 1, r = 0.048f, StrokeRole.ANNOTATION_ARROW),
            poly(p(0.58f, 0.40f), p(0.64f, 0.24f), p(0.70f, 0.40f), closed = true, role = StrokeRole.LINE_WEIGHT_ACCENT, fillAlpha = 0.80f, stage = 1),
            label(0.52f, 0.16f, "2. Focal #1/#9 contrast", stage = 1, StrokeRole.ANNOTATION_ARROW),

            cubic(p(0.08f, 0.84f), p(0.36f, 0.72f), p(0.48f, 0.56f), p(0.62f, 0.42f), stage = 2, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.4f, dashed = true, arrowEnd = true, layer = VisualLayer.GUIDE),

            poly(p(0.08f, 0.70f), p(0.44f, 0.60f), p(0.92f, 0.72f), p(0.92f, 0.88f), p(0.08f, 0.88f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.55f, width = 2.0f, stage = 3, layer = VisualLayer.SHADING),
            poly(p(0.08f, 0.54f), p(0.50f, 0.44f), p(0.92f, 0.52f), p(0.92f, 0.72f), p(0.08f, 0.70f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.22f, width = 1.6f, stage = 3, layer = VisualLayer.SHADING),

            boldLine(0.08f, 0.70f, 0.44f, 0.60f, stage = 4, width = 3.8f),
            label(0.12f, 0.78f, "4. Dark FG -> Mid MG -> Pale BG", stage = 4, StrokeRole.HIGHLIGHT_ACCENT)
        ),
        comparison = MistakeComparisonSpec(
            title = "Bulls-Eye Clutter vs. Thirds Focal Hierarchy",
            wrongLabel = "Dead Center + Equal Contrast",
            rightLabel = "Thirds Anchor + Value Separation",
            whyMistakeHappens = "Centering subjects and rendering background trees equally dark as foreground rocks creates visual chaos.",
            howToFix = "Anchor hero contrast on a thirds crossing and separate FG (dark), MG (midtone), and BG (light).",
            wrongElements = listOf(
                poly(p(0.10f, 0.14f), p(0.90f, 0.14f), p(0.90f, 0.86f), p(0.10f, 0.86f), closed = true, width = 2.4f, stage = 0),
                poly(p(0.44f, 0.40f), p(0.50f, 0.24f), p(0.56f, 0.40f), closed = true, role = StrokeRole.MISTAKE_HIGHLIGHT, fillAlpha = 0.5f, stage = 0),
                inkLine(0.10f, 0.52f, 0.90f, 0.52f, 0, 3.2f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                inkLine(0.10f, 0.68f, 0.90f, 0.68f, 0, 3.2f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Center split + dark far lines")
            ),
            rightElements = listOf(
                poly(p(0.10f, 0.14f), p(0.90f, 0.14f), p(0.90f, 0.86f), p(0.10f, 0.86f), closed = true, width = 2.4f, stage = 0),
                poly(p(0.58f, 0.42f), p(0.64f, 0.26f), p(0.70f, 0.42f), closed = true, role = StrokeRole.LINE_WEIGHT_ACCENT, fillAlpha = 0.85f, stage = 0),
                poly(p(0.10f, 0.68f), p(0.52f, 0.58f), p(0.90f, 0.70f), p(0.90f, 0.86f), p(0.10f, 0.86f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.45f, stage = 0),
                rightNote("Clear focal anchor & depth layers")
            )
        )
    ),

    // 32. Architectural Street & Atmospheric Depth
    VisualDemoSpec(
        id = "vis_architecture_depth",
        title = "Street Architecture & Atmospheric Depth",
        category = VisualCategory.COMPOSITION_ENVIRONMENTS,
        worldNumbers = listOf(5, 8, 11),
        skillIds = listOf("sk_arch_env", "sk_atmo_depth"),
        summary = "Ground streets by projecting building boxes to a shared VP, aligning standing eyes onto the Horizon, and fading distant contrast.",
        revisitedConcepts = listOf("1-pt/2-pt perspective", "X-subdivision", "Value control"),
        stages = listOf(
            ConstructionStage(1, "Place Eye-Level Horizon & Street VP", "Draw the horizontal eye-level line and set the distant street Vanishing Point.", "Every standing pedestrian's eye level sits right on this line."),
            ConstructionStage(2, "Project Street Curb & Roof Perspective Rays", "Pull radiating lines from VP toward top and bottom corners of the page.", "Locks rooftops, windows, and street curbs in unified perspective."),
            ConstructionStage(3, "Slice Foreground & Midground Building Volumes", "Drop crisp vertical building divisions compressing narrower toward VP.", "Use X-subdivision to space evenly along receding facades."),
            ConstructionStage(4, "Place Scale Figures Eye-Aligned to Horizon", "Draw tall foreground and tiny distant people—keeping all heads at the exact Horizon height!", "Instantly communicates believable architectural scale."),
            ConstructionStage(5, "Apply Atmospheric Perspective Value Fade", "Keep foreground buildings dark/crisp and fade distant towers pale and soft.", "Air density weakens contrast with distance.", isCleanupStage = true)
        ),
        elements = listOf(
            axisLine(0.06f, 0.56f, 0.94f, 0.56f, stage = 0, dashed = false),
            focusRing(0.52f, 0.56f, stage = 0, r = 0.025f, StrokeRole.ANNOTATION_ARROW),
            label(0.08f, 0.49f, "Horizon (Standing Eyes)", stage = 0),

            guideLine(0.52f, 0.56f, 0.08f, 0.12f, stage = 1),
            guideLine(0.52f, 0.56f, 0.08f, 0.88f, stage = 1),
            guideLine(0.52f, 0.56f, 0.92f, 0.16f, stage = 1),
            guideLine(0.52f, 0.56f, 0.92f, 0.86f, stage = 1),

            poly(p(0.10f, 0.14f), p(0.30f, 0.34f), p(0.30f, 0.72f), p(0.10f, 0.86f), closed = true, width = 2.8f, stage = 2),
            poly(p(0.30f, 0.34f), p(0.42f, 0.46f), p(0.42f, 0.64f), p(0.30f, 0.72f), closed = true, width = 2.0f, stage = 2),
            poly(p(0.70f, 0.36f), p(0.90f, 0.18f), p(0.90f, 0.84f), p(0.70f, 0.70f), closed = true, width = 2.8f, stage = 2),
            poly(p(0.60f, 0.46f), p(0.70f, 0.36f), p(0.70f, 0.70f), p(0.60f, 0.62f), closed = true, width = 1.8f, stage = 2),

            // Scale figures: heads on horizon (0.56f)!
            oval(0.36f, 0.56f, 0.016f, 0.018f, stage = 3, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.4f),
            inkLine(0.36f, 0.58f, 0.36f, 0.76f, stage = 3, width = 2.8f, role = StrokeRole.CORRECTION_HIGHLIGHT),
            oval(0.48f, 0.56f, 0.008f, 0.009f, stage = 3, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.0f),
            inkLine(0.48f, 0.57f, 0.48f, 0.62f, stage = 3, width = 2.0f, role = StrokeRole.CORRECTION_HIGHLIGHT),

            poly(p(0.10f, 0.14f), p(0.30f, 0.34f), p(0.30f, 0.72f), p(0.10f, 0.86f), closed = true, role = StrokeRole.SHADING_TONE, fillAlpha = 0.30f, stage = 4, layer = VisualLayer.SHADING),
            boldLine(0.10f, 0.86f, 0.30f, 0.72f, stage = 4, width = 4.2f),
            boldLine(0.70f, 0.70f, 0.90f, 0.84f, stage = 4, width = 4.2f)
        ),
        comparison = MistakeComparisonSpec(
            title = "Giant Background People vs. Eye-Level Horizon Rule",
            wrongLabel = "Floating Giant Distant Figure",
            rightLabel = "All Standing Eyes on Horizon",
            whyMistakeHappens = "Placing small or large characters arbitrarily above or below the Horizon Line destroys spatial scale.",
            howToFix = "Keep every standing adult's eyes directly on the eye-level Horizon Line across both near and distant depths.",
            wrongElements = listOf(
                axisLine(0.06f, 0.52f, 0.94f, 0.52f, 0, dashed = false),
                oval(0.30f, 0.52f, 0.02f, 0.02f, 0, width = 2.4f),
                inkLine(0.30f, 0.54f, 0.30f, 0.76f, 0, 2.8f),
                oval(0.68f, 0.36f, 0.02f, 0.02f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.6f),
                inkLine(0.68f, 0.38f, 0.68f, 0.62f, 0, 2.8f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Distant figure floats above horizon")
            ),
            rightElements = listOf(
                axisLine(0.06f, 0.52f, 0.94f, 0.52f, 0, dashed = false),
                oval(0.28f, 0.52f, 0.022f, 0.022f, 0, StrokeRole.CORRECTION_HIGHLIGHT, 2.4f),
                inkLine(0.28f, 0.54f, 0.28f, 0.78f, 0, 3.0f),
                oval(0.68f, 0.52f, 0.011f, 0.011f, 0, StrokeRole.CORRECTION_HIGHLIGHT, 2.2f),
                inkLine(0.68f, 0.53f, 0.68f, 0.62f, 0, 2.4f),
                rightNote("Near & far eyes stay locked on horizon")
            )
        )
    ),

    // 33. Rotational Invention & Shape Language
    VisualDemoSpec(
        id = "vis_imagination_rotation",
        title = "Rotational Invention & Shape Language",
        category = VisualCategory.COMPOSITION_ENVIRONMENTS,
        worldNumbers = listOf(12),
        skillIds = listOf("sk_imagination", "sk_stylization", "sk_master_study", "sk_portfolio"),
        summary = "Turn a mental 3D primitive across three viewing angles and stylize silhouettes using Circle, Square, and Triangle shape psychology.",
        revisitedConcepts = listOf("3D spheres & cubes", "2-point rotation", "Axis symmetry"),
        stages = listOf(
            ConstructionStage(1, "Define Mental Primitive Recipe", "Break an invented subject into a clear sphere + box + center axis recipe in Front View.", "Once memorized as simple volumes, you no longer depend on one photo angle."),
            ConstructionStage(2, "Rotate Centerline to 3/4 Angle", "Shift the vertical centerline off-center and wrap the horizontal equator around the turn.", "Proves you understand the form spatially rather than copying flat lines."),
            ConstructionStage(3, "Rotate Full 90° Profile View", "Construct the side view keeping exact height alignment across all three turnarounds.", "Horizontal level lines ensure consistent proportions across turns."),
            ConstructionStage(4, "Apply Shape Language Psychology", "Contrast friendly Circles, sturdy Squares, and sharp dynamic Triangles.", "Shape vocabulary communicates character personality instantaneously."),
            ConstructionStage(5, "Polish Master-Study Hierarchy", "Weight overlapping turning contours and group tonal focus.", "Unites independent invention with polished draftsmanship.", isCleanupStage = true)
        ),
        elements = listOf(
            // Three turnaround spheres/heads with rotating centerlines
            guideLine(0.10f, 0.24f, 0.90f, 0.24f, stage = 0),
            guideLine(0.10f, 0.56f, 0.90f, 0.56f, stage = 0),
            oval(0.20f, 0.40f, 0.11f, 0.14f, stage = 0, width = 2.6f),
            axisLine(0.20f, 0.24f, 0.20f, 0.56f, stage = 0),
            oval(0.20f, 0.40f, 0.11f, 0.036f, stage = 0, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.0f),

            oval(0.50f, 0.40f, 0.11f, 0.14f, stage = 1, width = 2.6f),
            cubic(p(0.52f, 0.26f), p(0.58f, 0.36f), p(0.58f, 0.46f), p(0.52f, 0.54f), stage = 1, role = StrokeRole.ANNOTATION_ARROW, width = 2.2f, layer = VisualLayer.STRUCTURE),
            oval(0.50f, 0.40f, 0.11f, 0.036f, stage = 1, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.0f),

            oval(0.80f, 0.40f, 0.11f, 0.14f, stage = 2, width = 2.6f),
            axisLine(0.91f, 0.26f, 0.91f, 0.54f, stage = 2, dashed = false, width = 2.2f),
            oval(0.80f, 0.40f, 0.11f, 0.036f, stage = 2, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.0f),
            label(0.14f, 0.12f, "Front", stage = 2),
            label(0.45f, 0.12f, "3/4 Turn", stage = 2, StrokeRole.ANNOTATION_ARROW),
            label(0.75f, 0.12f, "Side 90°", stage = 2),

            // Shape language row below
            oval(0.20f, 0.77f, 0.08f, 0.08f, stage = 3, role = StrokeRole.CORRECTION_HIGHLIGHT, width = 2.6f),
            poly(p(0.42f, 0.69f), p(0.58f, 0.69f), p(0.58f, 0.85f), p(0.42f, 0.85f), closed = true, role = StrokeRole.AXIS_AND_PLUMB, width = 2.6f, stage = 3),
            poly(p(0.80f, 0.68f), p(0.71f, 0.85f), p(0.89f, 0.85f), closed = true, role = StrokeRole.ANNOTATION_ARROW, width = 2.6f, stage = 3),
            label(0.14f, 0.88f, "Soft", stage = 3),
            label(0.44f, 0.88f, "Sturdy", stage = 3),
            label(0.75f, 0.88f, "Dynamic", stage = 3)
        ),
        comparison = MistakeComparisonSpec(
            title = "Memorized 2D Front Copy vs. Rotatable 3D Model",
            wrongLabel = "Flat Un-Rotatable Stamp",
            rightLabel = "Wrapped Axes Rotate Anywhere",
            whyMistakeHappens = "Memorizing flat 2D line recipes breaks completely the moment you turn a character or prop 45°.",
            howToFix = "Always store subjects in memory as simple 3D volumes with curved equators and wrapping centerlines.",
            wrongElements = listOf(
                oval(0.24f, 0.48f, 0.12f, 0.14f, 0, width = 2.4f),
                oval(0.68f, 0.48f, 0.12f, 0.14f, 0, StrokeRole.MISTAKE_HIGHLIGHT, 2.4f),
                inkLine(0.68f, 0.34f, 0.68f, 0.62f, 0, 2.4f, role = StrokeRole.MISTAKE_HIGHLIGHT),
                wrongNote("Stuck facing straight forward")
            ),
            rightElements = listOf(
                oval(0.26f, 0.48f, 0.12f, 0.14f, 0, width = 2.4f),
                axisLine(0.26f, 0.34f, 0.26f, 0.62f, 0),
                oval(0.68f, 0.48f, 0.12f, 0.14f, 0, width = 2.4f),
                cubic(p(0.69f, 0.34f), p(0.77f, 0.44f), p(0.77f, 0.54f), p(0.69f, 0.62f), 0, StrokeRole.CORRECTION_HIGHLIGHT, 2.6f),
                oval(0.68f, 0.48f, 0.12f, 0.04f, 0, StrokeRole.CORRECTION_HIGHLIGHT, 2.0f),
                rightNote("Curved axes rotate cleanly")
            )
        )
    )
)
