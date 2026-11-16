package com.example.data.curriculum

import com.example.domain.model.ConfidenceLevel
import com.example.domain.model.DiagramType
import com.example.domain.model.DifficultyRating
import com.example.domain.model.HonestEvaluationFeedback
import com.example.domain.model.Lesson
import com.example.domain.model.RecallQuestion

internal data class SkillPedagogy(
    val techniqueFocus: String,
    val unfamiliarSubjectHint: String,
    val harderStretch: String,
    val cumulativeTieIn: String
)

object PedagogicalData {

    val skillPrerequisites: Map<String, List<String>> = mapOf(
        // World 1
        "sk_eye_hand" to emptyList(),
        "sk_contour" to listOf("sk_eye_hand"),
        "sk_neg_space" to listOf("sk_contour"),
        "sk_sight_prop" to listOf("sk_contour", "sk_neg_space"),
        // World 2
        "sk_cubes" to listOf("sk_sight_prop"),
        "sk_spheres_cyl" to listOf("sk_sight_prop", "sk_contour"),
        "sk_cross_contour" to listOf("sk_spheres_cyl"),
        "sk_form_intersect" to listOf("sk_cubes", "sk_spheres_cyl"),
        // World 3
        "sk_stroke_conf" to listOf("sk_eye_hand"),
        "sk_line_weight" to listOf("sk_stroke_conf", "sk_cubes"),
        "sk_hatching" to listOf("sk_stroke_conf", "sk_cross_contour"),
        "sk_stippling_tex" to listOf("sk_hatching"),
        // World 4
        "sk_value_scale" to listOf("sk_hatching"),
        "sk_form_shadow" to listOf("sk_value_scale", "sk_spheres_cyl"),
        "sk_cast_shadow" to listOf("sk_form_shadow", "sk_cubes"),
        "sk_edge_control" to listOf("sk_form_shadow", "sk_cast_shadow"),
        // World 5
        "sk_1pt_persp" to listOf("sk_cubes", "sk_sight_prop"),
        "sk_2pt_persp" to listOf("sk_1pt_persp", "sk_cubes"),
        "sk_3pt_persp" to listOf("sk_2pt_persp"),
        "sk_persp_div" to listOf("sk_2pt_persp", "sk_spheres_cyl"),
        // World 6
        "sk_still_construct" to listOf("sk_spheres_cyl", "sk_sight_prop"),
        "sk_still_prop" to listOf("sk_sight_prop", "sk_still_construct"),
        "sk_still_comp" to listOf("sk_still_prop", "sk_line_weight"),
        "sk_still_value" to listOf("sk_form_shadow", "sk_still_comp"),
        // World 7
        "sk_tex_hard" to listOf("sk_edge_control", "sk_hatching"),
        "sk_tex_reflect" to listOf("sk_value_scale", "sk_still_construct"),
        "sk_tex_fabric" to listOf("sk_cross_contour", "sk_form_shadow"),
        "sk_tex_organic" to listOf("sk_edge_control", "sk_tex_fabric"),
        // World 8
        "sk_botanical" to listOf("sk_contour", "sk_cross_contour"),
        "sk_trees_terrain" to listOf("sk_spheres_cyl", "sk_line_weight"),
        "sk_animal_struct" to listOf("sk_form_intersect", "sk_sight_prop"),
        "sk_animal_coat" to listOf("sk_form_shadow", "sk_animal_struct"),
        // World 9
        "sk_gesture" to listOf("sk_eye_hand", "sk_stroke_conf"),
        "sk_fig_prop" to listOf("sk_sight_prop", "sk_cubes", "sk_spheres_cyl"),
        "sk_anatomy_core" to listOf("sk_fig_prop", "sk_cross_contour"),
        "sk_hands_feet" to listOf("sk_cubes", "sk_fig_prop"),
        // World 10
        "sk_loomis_head" to listOf("sk_spheres_cyl", "sk_cross_contour", "sk_sight_prop"),
        "sk_eyes_nose" to listOf("sk_loomis_head", "sk_form_shadow"),
        "sk_mouth_ears_hair" to listOf("sk_loomis_head", "sk_tex_organic"),
        "sk_expressions" to listOf("sk_eyes_nose", "sk_mouth_ears_hair"),
        // World 11
        "sk_comp_focal" to listOf("sk_still_comp", "sk_value_scale"),
        "sk_arch_env" to listOf("sk_2pt_persp", "sk_persp_div"),
        "sk_atmo_depth" to listOf("sk_edge_control", "sk_comp_focal"),
        "sk_storytelling" to listOf("sk_comp_focal", "sk_arch_env", "sk_gesture"),
        // World 12
        "sk_imagination" to listOf("sk_form_intersect", "sk_2pt_persp"),
        "sk_stylization" to listOf("sk_fig_prop", "sk_imagination"),
        "sk_master_study" to listOf("sk_still_value", "sk_comp_focal"),
        "sk_portfolio" to listOf("sk_imagination", "sk_storytelling", "sk_master_study")
    )

    val diagramCaptions: Map<DiagramType, String> = mapOf(
        DiagramType.OBSERVATION_CONTOUR to "Vertical plumb & horizontal alignment checks catch tilt errors; compare the red sighting angle before drawing curves.",
        DiagramType.NEGATIVE_SPACE to "Draw the trapped background shapes (blue & green) around the object instead of naming 'chair' or 'leg'.",
        DiagramType.BASIC_FORMS_3D to "Start boxes from the front Y-vertex, align cylinder ellipses to the dashed minor axis, and wrap an equator around spheres.",
        DiagramType.CROSS_CONTOUR to "Hook each cross-contour ring sharply around the outer silhouette edge so flat paper reads as turning 3D volume.",
        DiagramType.LINE_CONTROL_GHOSTING to "Plot dots first, hover (ghost) 3 times from the shoulder, then commit in one crisp stroke; heavier front lines create depth.",
        DiagramType.HATCHING_AND_STIPPLING to "Build value cleanly through spacing and angle changes rather than smearing graphite—parallel, cross-hatch, contour-wrap, stipple.",
        DiagramType.VALUE_SCALE_AND_SPHERE to "Separate the light family (#1–#3) from the shadow family (#5–#9) cleanly at the terminator; keep reflected light darker than halftones.",
        DiagramType.CAST_SHADOW_LOGIC to "Project rays from the light source past top corners down to the ground plane to locate sharp cast-shadow boundaries.",
        DiagramType.PERSPECTIVE_1_2_3_POINT to "All horizontal edges on a face converge cleanly to VP1 or VP2 sitting on the eye-level Horizon Line.",
        DiagramType.STILL_LIFE_SIGHTING to "Build bottles on a shared vertical centerline, stack symmetrical ellipses, and overlap a forward bowl to establish space.",
        DiagramType.TEXTURE_STUDIES to "Every texture sits on top of simple form value: broken wood grain, crisp #1–#9 metal contrast, and smooth pipe-fold ridges.",
        DiagramType.BOTANICAL_AND_ANIMAL to "Track the continuous central midrib on leaves and interlock ribcage & pelvis ovals before adding fur or details.",
        DiagramType.HUMAN_GESTURE_MANNEQUIN to "Capture the sweeping C/S Line of Action first, oppose shoulder vs. hip tilts, and check heights on an 8-head mannequin ruler.",
        DiagramType.LOOMIS_HEAD_PROPORTIONS to "Slice flat temporal sides off the cranium sphere and divide Hairline → Brow → Nose → Chin into equal thirds.",
        DiagramType.COMPOSITION_THIRDS to "Place your focal contrast on a Rule-of-Thirds intersection and step values lighter/softer from Foreground to Background.",
        DiagramType.IMAGINATION_SYNTHESIS to "If you can rotate a primitive with clear centerlines and equators across 3 angles, you can invent believable subjects from memory."
    )

    internal val skillPedagogy: Map<String, SkillPedagogy> = mapOf(
        "sk_eye_hand" to SkillPedagogy(
            techniqueFocus = "Synchronize eye movement speed with pencil tip speed; resist looking down to 'fix' proportions prematurely.",
            unfamiliarSubjectHint = "Pick an unfamiliar household object with uneven bends (e.g., crumpled paper, keys, or a shoe).",
            harderStretch = "Double the size on your page and trace continuous micro-bends without lifting your pencil once.",
            cumulativeTieIn = "Foundation for all contour accuracy and gesture speed."
        ),
        "sk_contour" to SkillPedagogy(
            techniqueFocus = "Follow true convex/concave outer edges and inner creases rather than drawing symbolic curves.",
            unfamiliarSubjectHint = "Turn a complex object upside down or draw a crumpled cloth corner you have never drawn before.",
            harderStretch = "Draw two overlapping objects in a single continuous contour pass with varied line pressure.",
            cumulativeTieIn = "Prepares accurate silhouettes for Negative Space and Still Life."
        ),
        "sk_neg_space" to SkillPedagogy(
            techniqueFocus = "Lock onto the geometry of empty air pockets framed by outer edges—ignore what the object 'is'.",
            unfamiliarSubjectHint = "Draw the negative cutouts inside a bicycle wheel, folding chair, or plant stems.",
            harderStretch = "Draw an entire complex object purely by shading its surrounding negative space shapes.",
            cumulativeTieIn = "Eliminates symbol drawing and verifies spacing in Multi-Object Still Life."
        ),
        "sk_sight_prop" to SkillPedagogy(
            techniqueFocus = "Lock your elbow straight, close one eye, measure ratios with your pencil tip, and transfer tick marks lightly.",
            unfamiliarSubjectHint = "Sight-measure a tall lamp or doorway corner across the room from 6+ feet away.",
            harderStretch = "Establish 5 alignment ticks for width, height, and tilt before drawing a single contour line.",
            cumulativeTieIn = "Backbone of Still Life, Figure Proportions, and Perspective depth."
        ),
        "sk_cubes" to SkillPedagogy(
            techniqueFocus = "Construct the front Y-vertex cleanly and make receding parallel edges slightly converge away from you.",
            unfamiliarSubjectHint = "Rotate an open cardboard box or stack of books at an awkward 3/4 tilt on the floor.",
            harderStretch = "Draw a cluster of 4 overlapping transparent boxes of different sizes from imagination.",
            cumulativeTieIn = "Prepares directly for 2-Point Perspective and architectural blocks."
        ),
        "sk_spheres_cyl" to SkillPedagogy(
            techniqueFocus = "Keep the ellipse major axis strictly perpendicular (90°) to the cylinder's centerline minor axis.",
            unfamiliarSubjectHint = "Draw a tilted watering can, flashlight, or flashlight beam pointing toward your eye.",
            harderStretch = "Draw a cylinder tumbling across 4 sequential angles from flat coin (10°) to full circle (85°).",
            cumulativeTieIn = "Essential for mugs, bottles, tree trunks, limbs, and the Loomis head sphere."
        ),
        "sk_cross_contour" to SkillPedagogy(
            techniqueFocus = "Curve internal surface bands faster near the silhouette edges so the surface visibly wraps around the back.",
            unfamiliarSubjectHint = "Wrap cross-contours over an asymmetrical vegetable (pepper, squash, or peeled orange).",
            harderStretch = "Place an imagined dent or crease on the form and bend every cross-contour accurately into it.",
            cumulativeTieIn = "Bridges 2D contours to 3D shading and anatomical muscles."
        ),
        "sk_form_intersect" to SkillPedagogy(
            techniqueFocus = "Draw through transparent forms completely so you can trace the exact curved seam where two volumes collide.",
            unfamiliarSubjectHint = "Combine a tilted cone piercing a box and cylinder (e.g., an invented mechanical nozzle or toy).",
            harderStretch = "Intersect 3 primitives at non-90° angles and darken only the visible front intersection seams.",
            cumulativeTieIn = "Core construction engine for Animals, Figures, and Imagination Synthesis."
        ),
        "sk_stroke_conf" to SkillPedagogy(
            techniqueFocus = "Plot end dots, ghost 2–3 times from your shoulder joint, and pull decisively at steady medium speed.",
            unfamiliarSubjectHint = "Fill a blank newsprint page with sweeping S-curves and connecting arcs between random dot pairs.",
            harderStretch = "Draw a complete box or ellipse grid in ink pen—no erasing, one deliberate stroke per edge.",
            cumulativeTieIn = "Makes every later line in Perspective, Gesture, and Ink clean."
        ),
        "sk_line_weight" to SkillPedagogy(
            techniqueFocus = "Press heavier where edges overlap in front or sit in shadow; keep background and upper lit edges whisper-thin.",
            unfamiliarSubjectHint = "Line-weight an untidy pile of overlapping kitchen utensils or tangled headphones.",
            harderStretch = "Communicate depth across 3 overlapping forms using line weight alone—zero shading.",
            cumulativeTieIn = "Clarifies Still Life silhouettes, Anatomy overlaps, and Architecture planes."
        ),
        "sk_hatching" to SkillPedagogy(
            techniqueFocus = "Keep stroke spacing uniform, lift the pencil cleanly at each stroke end, and rotate angles slightly (30°–45°) per pass.",
            unfamiliarSubjectHint = "Shade a crumpled paper bag solely using directional contour hatching—no smudging.",
            harderStretch = "Transition seamlessly across 6 value steps using only single-pass spacing compression.",
            cumulativeTieIn = "Clean tonal engine for Pen/Pencil Value Studies and Textures."
        ),
        "sk_stippling_tex" to SkillPedagogy(
            techniqueFocus = "Tap vertically without dragging tails; build darker tones via tighter dot clusters rather than larger messy blobs.",
            unfamiliarSubjectHint = "Stipple a weathered pebble, pinecone, or citrus peel under directional desk light.",
            harderStretch = "Render a sphere from bright highlight to cast shadow using strictly stippled clusters.",
            cumulativeTieIn = "Adds tactile surface variety to Nature, Hard Textures, and Ink illustrations."
        ),
        "sk_value_scale" to SkillPedagogy(
            techniqueFocus = "Keep every value step visually distinct from its neighbors; squint to verify smooth even jumps.",
            unfamiliarSubjectHint = "Create a 7-step tonal posterization of a random clutter corner by squinting.",
            harderStretch = "Compress a 9-step scale cleanly into only 3 bold values (Light, Midtone, Shadow) without losing readability.",
            cumulativeTieIn = "Calibrates your eye for Form Shadow, Still Life Grouping, and Composition."
        ),
        "sk_form_shadow" to SkillPedagogy(
            techniqueFocus = "Establish a clear terminator line separating light from shadow, then keep reflected light darker than the darkest halftone.",
            unfamiliarSubjectHint = "Light a white egg or mug with a single desk lamp in a dim room and map only its shadow family.",
            harderStretch = "Shade a compound object (sphere resting on a cylinder) with unified shadow-family value.",
            cumulativeTieIn = "Foundation for realistic Still Life, Portrait planes, and Anatomical volume."
        ),
        "sk_cast_shadow" to SkillPedagogy(
            techniqueFocus = "Anchor shadows sharply right at the object's contact base (ambient occlusion), then soften edges further out.",
            unfamiliarSubjectHint = "Cast raking afternoon shadow from a tall bottle across another box or curved mug.",
            harderStretch = "Bend a cast shadow accurately up a nearby vertical wall or curved cylinder.",
            cumulativeTieIn = "Grounds objects onto Perspective planes and Environments."
        ),
        "sk_edge_control" to SkillPedagogy(
            techniqueFocus = "Keep cast-shadow & overlap edges crisp ('found'), and soften core-shadow transitions & lost shadow edges ('lost').",
            unfamiliarSubjectHint = "Draw a softly lit ceramic cup or dark folded sleeve where part of its shadow melts into the background.",
            harderStretch = "Render an object with zero outline—using only lost & found value edges against a midtone ground.",
            cumulativeTieIn = "Elevates Textures, Portraits, and Atmospheric Depth."
        ),
        "sk_1pt_persp" to SkillPedagogy(
            techniqueFocus = "Keep verticals strictly vertical, horizontals flat, and send every depth edge straight to the single VP.",
            unfamiliarSubjectHint = "Draw a real hallway, kitchen counter, or open bookshelf from your current eye level.",
            harderStretch = "Draw the same hallway from worm's-eye (6 inches off floor) and standing eye level.",
            cumulativeTieIn = "Directly feeds 2-Point rooms, interiors, and focal leading lines."
        ),
        "sk_2pt_persp" to SkillPedagogy(
            techniqueFocus = "Place VPs wide enough outside your drawing frame to avoid severe fish-eye corner distortion.",
            unfamiliarSubjectHint = "Place a chair or coffee table at a corner angle and construct its bounding box in 2-point perspective.",
            harderStretch = "Draw an outdoor street corner with 3 rotated buildings at differing heights sharing one Horizon Line.",
            cumulativeTieIn = "Essential for Architecture, Furniture, and angled Still Life blocks."
        ),
        "sk_3pt_persp" to SkillPedagogy(
            techniqueFocus = "Use a dedicated 3rd vertical VP far above or below the horizon so tall forms lean dynamically without looking melted.",
            unfamiliarSubjectHint = "Look up at a bookcase or corner building exterior and project its vertical taper.",
            harderStretch = "Draw a dramatic bird's-eye rooftop looking down at street blocks with a consistent 3rd VP.",
            cumulativeTieIn = "Drives dramatic camera storytelling angles in Composition."
        ),
        "sk_persp_div" to SkillPedagogy(
            techniqueFocus = "Use diagonal X-intersections to find true perspective midpoints before replicating equal arches, tiles, or windows.",
            unfamiliarSubjectHint = "Draw a real wooden fence, window panes, or bicycle wheels receding down a room.",
            harderStretch = "Construct a receding row of 5 equal-spaced cylinders using only X-subdivision.",
            cumulativeTieIn = "Precision tool for Environments, Wheels, and Architectural Facades."
        ),
        "sk_still_construct" to SkillPedagogy(
            techniqueFocus = "Drop a crisp vertical centerline first, check ellipse flatness near eye level vs. bottom, and draw full transparent ellipses.",
            unfamiliarSubjectHint = "Construct a teapot, spray bottle, or kettle combining cylinder, cone, and attached handle planes.",
            harderStretch = "Draw a tilted spoon resting inside a transparent glass without breaking either centerline.",
            cumulativeTieIn = "Unifies World 2 Basic Forms and World 5 Perspective into real objects."
        ),
        "sk_still_prop" to SkillPedagogy(
            techniqueFocus = "Pick one medium object as your 1-unit ruler and compare every height, width, and gap against it before detailing.",
            unfamiliarSubjectHint = "Set up 3 contrasting objects (tall narrow, short wide, spherical) and align their table footprints.",
            harderStretch = "Draw 4 objects spaced across varying depths without any negative-space collisions.",
            cumulativeTieIn = "Ensures believable scale across Environments and Figure groups."
        ),
        "sk_still_comp" to SkillPedagogy(
            techniqueFocus = "Create clear overlapping triangles and vary spacing so objects feel arranged rather than lined up like soldiers.",
            unfamiliarSubjectHint = "Rearrange 3 desk items 3 different ways in small 2-minute thumbnail frames before choosing the strongest.",
            harderStretch = "Crop an arrangement aggressively right through one edge while keeping the focal overlap intact.",
            cumulativeTieIn = "Rehearses Composition rules on manageable tabletop scenes."
        ),
        "sk_still_value" to SkillPedagogy(
            techniqueFocus = "Squint and group adjacent dark shadows across objects into unified shapes before rendering midtones or details.",
            unfamiliarSubjectHint = "Arrange a dark mug, white egg, and wooden spoon under one strong side lamp.",
            harderStretch = "Paint/shade a complete 4-value still life study keeping every light above #4 and every shadow below #6.",
            cumulativeTieIn = "Directly prepares for Master Studies and Full Value Compositions."
        ),
        "sk_tex_hard" to SkillPedagogy(
            techniqueFocus = "Shade the underlying simple form first; place texture marks almost exclusively along the halftone/terminator boundary.",
            unfamiliarSubjectHint = "Observe weathered tree bark, brick, or cracked cutting board wood in strong side light.",
            harderStretch = "Render a wooden cube and rough stone sphere side by side sharing identical light direction.",
            cumulativeTieIn = "Adds believable material contrast to Environments and Still Life."
        ),
        "sk_tex_reflect" to SkillPedagogy(
            techniqueFocus = "Look for sharp, high-contrast jumps (#1 next to #9) wrapping cleanly along the object's 3D cross-contours.",
            unfamiliarSubjectHint = "Draw a shiny metal spoon or clear glass tumbler resting on a patterned napkin.",
            harderStretch = "Capture both the bent rim refraction and a dark-room bright window highlight on glass.",
            cumulativeTieIn = "Contrasts crisp hard speculars against soft matte fabrics and skin."
        ),
        "sk_tex_fabric" to SkillPedagogy(
            techniqueFocus = "Identify the tension anchor point (hook, shoulder, or knee), then trace cylindrical pipe ridges and triangular valleys.",
            unfamiliarSubjectHint = "Hang a heavy towel over one doorknob or drape a hoodie sleeve over your chair.",
            harderStretch = "Draw the same sleeve relaxed vs. bent sharply at the elbow to contrast pipe vs. zigzag folds.",
            cumulativeTieIn = "Essential for clothed Figures, Portraits, and Storytelling poses."
        ),
        "sk_tex_organic" to SkillPedagogy(
            techniqueFocus = "Treat hair as bold shaded S-ribbons first, adding individual stray strands only along edge silhouettes and highlights.",
            unfamiliarSubjectHint = "Study coiled rope, braided yarn, or softly lit skin tones over knuckles.",
            harderStretch = "Render curly vs. straight hair ribbons wrapping a simple sphere with unified core shadow.",
            cumulativeTieIn = "Feeds directly into Portraits, Animal Coats, and Tactile Finishes."
        ),
        "sk_botanical" to SkillPedagogy(
            techniqueFocus = "Draw the curving stem and central leaf midrib first; fold overlapping outer petals around a cup cylinder.",
            unfamiliarSubjectHint = "Draw a potted houseplant or open flower from 3 angles (top, side, 3/4 tilt).",
            harderStretch = "Draw a cluster of 5 overlapping leaves foreshortened sharply toward the viewer.",
            cumulativeTieIn = "Applies Cross-Contour & Overlapping Line Weight to living forms."
        ),
        "sk_trees_terrain" to SkillPedagogy(
            techniqueFocus = "Taper trunks & branches smoothly using Y-forks and treat foliage canopies as simple sunlit cloud spheres.",
            unfamiliarSubjectHint = "Step outside or look out a window to sketch a bare winter tree fork and rocky slope.",
            harderStretch = "Combine foreground tree bark texture with receding atmospheric background hills.",
            cumulativeTieIn = "Feeds Architecture/Landscape Environments and Atmospheric Depth."
        ),
        "sk_animal_struct" to SkillPedagogy(
            techniqueFocus = "Lock in the spinal curve, barrel ribcage, and wedged pelvis mass before placing angled joint segments.",
            unfamiliarSubjectHint = "Sketch a pet or bird in motion using ribcage-pelvis ovals and paw footprint perspective.",
            harderStretch = "Construct an animal resting, walking, and turning its head in 3/4 foreshortened view.",
            cumulativeTieIn = "Applies Form Intersections & Gesture to living creatures."
        ),
        "sk_animal_coat" to SkillPedagogy(
            techniqueFocus = "Break fur and feathers into overlapping directional tufts clustered along the core shadow edge—never every hair.",
            unfamiliarSubjectHint = "Draw a close-up wing feather group or shaggy fur clump turning over a curved shoulder.",
            harderStretch = "Suggest silky vs. bristly fur strictly through edge sharpness and tuft length.",
            cumulativeTieIn = "Combines Edge Control, Value Grouping, and Organic Texture."
        ),
        "sk_gesture" to SkillPedagogy(
            techniqueFocus = "Sweep a single fluid C or S Line of Action from head to weight-bearing foot in the first 10 seconds.",
            unfamiliarSubjectHint = "Practice 60-second gestures of people reaching, twisting, or carrying heavy bags.",
            harderStretch = "Capture full pose energy and weight balance in under 45 seconds using at most 12 strokes.",
            cumulativeTieIn = "Prevents stiff mannequin drawings in Figure Construction & Storytelling."
        ),
        "sk_fig_prop" to SkillPedagogy(
            techniqueFocus = "Anchor the torso via counter-tilted ribcage and pelvis ('robo-bean'), then check landmarks at 4 heads (crotch) & 6 heads (knees).",
            unfamiliarSubjectHint = "Construct a figure seated on a stool or foreshortened reaching forward from memory + mirror.",
            harderStretch = "Foreshorten a mannequin leaping diagonally toward the viewer while keeping head-unit volume consistent.",
            cumulativeTieIn = "Combines Sighting, Cylinders, and Gesture into believable human scale."
        ),
        "sk_anatomy_core" to SkillPedagogy(
            techniqueFocus = "Attach major muscle groups (pecs, deltoids, abs, quads) around the mannequin so limbs interlock like chain links.",
            unfamiliarSubjectHint = "Study an arm twisting from palm-up to palm-down (pronation) via forearm muscle overlap.",
            harderStretch = "Sketch 3 twisting torsos showing stretched vs. pinched oblique side planes.",
            cumulativeTieIn = "Turns wooden mannequins into responsive, weight-bearing human forms."
        ),
        "sk_hands_feet" to SkillPedagogy(
            techniqueFocus = "Block the palm as a slight trapezoidal wedge first; group fingers along sweeping knuckle arcs rather than sticks.",
            unfamiliarSubjectHint = "Draw your non-drawing hand holding a pencil, mug handle, or curled into a loose fist.",
            harderStretch = "Draw your hand in 4 steep foreshortened poses (pointing at you, gripping, flat, resting).",
            cumulativeTieIn = "Finishes full Figure Studies and expressive Portrait gestures."
        ),
        "sk_loomis_head" to SkillPedagogy(
            techniqueFocus = "Chop equal flat ovals off both sides of the sphere; wrap brow & nose centerlines accurately in 3D space.",
            unfamiliarSubjectHint = "Draw Loomis spheres tilted sharply upward (looking up) and downward (looking down).",
            harderStretch = "Spin one imagined head across 5 horizontal angles from front to full profile.",
            cumulativeTieIn = "Combines Sphere Equators & Perspective Thirds for solid portraits."
        ),
        "sk_eyes_nose" to SkillPedagogy(
            techniqueFocus = "Set eyeballs deep inside shadowed eye sockets and wrap upper/lower lids over a round sphere; treat the nose as a 4-plane wedge.",
            unfamiliarSubjectHint = "Draw 3/4 eyes where the far eye narrows naturally in foreshortening around the nose bridge.",
            harderStretch = "Construct nose + both eyes strictly from dramatic under-lighting without losing bridge alignment.",
            cumulativeTieIn = "Anchors likeness onto the Loomis head thirds."
        ),
        "sk_mouth_ears_hair" to SkillPedagogy(
            techniqueFocus = "Wrap mouth corners backward around the curved dental cylinder; tilt the ear parallel to the nose angle on the jaw line.",
            unfamiliarSubjectHint = "Draw a side-3/4 head showing how hair volumes sit on top of—not flat inside—the skull.",
            harderStretch = "Construct an open smiling mouth keeping tooth cylinder perspective and chin follow-through.",
            cumulativeTieIn = "Completes 3D facial integration before rendering likeness."
        ),
        "sk_expressions" to SkillPedagogy(
            techniqueFocus = "Push squash-and-stretch across the entire face: lowered brows compress cheek masses upward; wide surprise drops the jaw.",
            unfamiliarSubjectHint = "Use a mirror to capture genuine focused concentration, smirk, or astonishment.",
            harderStretch = "Transition one character's head through neutral → furious → laughing without losing bone structure.",
            cumulativeTieIn = "Drives Character Design and Emotional Storytelling."
        ),
        "sk_comp_focal" to SkillPedagogy(
            techniqueFocus = "Place highest value contrast (#1 against #9) and sharpest edges exclusively at your primary focal area.",
            unfamiliarSubjectHint = "Draft 4 postage-stamp (2x3\") value thumbnails of an everyday room using only 3 gray markers/tones.",
            harderStretch = "Lead the viewer's eye cleanly from foreground corner to focal point and back through secondary echoes.",
            cumulativeTieIn = "Organizes Still Life, Architecture, and Figure into cohesive artwork."
        ),
        "sk_arch_env" to SkillPedagogy(
            techniqueFocus = "Scale every doorway, bench, and window against eye-level human silhouettes seated on the same ground plane.",
            unfamiliarSubjectHint = "Sketch a street corner, staircase, or library table scene mixing 2-point boxes with organic trees.",
            harderStretch = "Draw an exterior staircase descending around a corner building with accurate human scale figures.",
            cumulativeTieIn = "Integrates Perspective, Subdivision, and Textures into real places."
        ),
        "sk_atmo_depth" to SkillPedagogy(
            techniqueFocus = "Reserve dark #8–#9 shadows and crisp details for the foreground; compress midground & background values toward lighter mist.",
            unfamiliarSubjectHint = "Observe a long street, foggy park, or layered hallway and separate FG / MG / BG tonal bands.",
            harderStretch = "Establish 4 distinct depth planes in one thumbnail using zero perspective lines—pure value & edge fade.",
            cumulativeTieIn = "Creates spatial airiness across Landscapes and Illustrated Worlds."
        ),
        "sk_storytelling" to SkillPedagogy(
            techniqueFocus = "Test every scene as a pure black silhouette first—the action, mood, and relationship must read clearly without details.",
            unfamiliarSubjectHint = "Stage an everyday narrative moment (e.g., waiting at a rainy station or fixing a broken bicycle).",
            harderStretch = "Re-stage the exact same story moment from a tense low camera angle vs. quiet high bird's-eye view.",
            cumulativeTieIn = "Unifies Figure Gesture, Perspective, Composition, and Mood."
        ),
        "sk_imagination" to SkillPedagogy(
            techniqueFocus = "Build simple wireframes, centerlines, and perspective footprints from memory before committing surface detail.",
            unfamiliarSubjectHint = "Observe an everyday tool for 60 seconds, hide it completely, and draw it rotated 90° from memory.",
            harderStretch = "Invent a cohesive prop (lantern, backpack, or vehicle) across front, 3/4, and top views.",
            cumulativeTieIn = "Synthesizes every structural skill from Worlds 1–6 without crutches."
        ),
        "sk_stylization" to SkillPedagogy(
            techniqueFocus = "Exaggerate underlying Big/Medium/Small proportions intentionally while obeying genuine 3D gravity and overlap.",
            unfamiliarSubjectHint = "Redesign an ordinary teacup or bird in 3 distinct shape languages (Angular, Round, Elongated).",
            harderStretch = "Stylize a complex seated human pose keeping weight balance and anatomical rhythm believable.",
            cumulativeTieIn = "Turns solid realism into intentional artistic voice."
        ),
        "sk_master_study" to SkillPedagogy(
            techniqueFocus = "Ask 'why did the artist place this dark shape and line weight here?'—decode structure and value hierarchy, never blindly trace.",
            unfamiliarSubjectHint = "Analyze an unfamiliar landscape or still life study by building its 3-value compositional skeleton first.",
            harderStretch = "Complete a master structural analysis, then paint/draw an original subject applying that exact rhythm.",
            cumulativeTieIn = "Bridges classic draftsmanship into original portfolio plates."
        ),
        "sk_portfolio" to SkillPedagogy(
            techniqueFocus = "Follow the full professional pipeline: thumbnails -> structural wireframe -> value study -> disciplined final finish.",
            unfamiliarSubjectHint = "Design a multi-panel observational + imaginative plate solving one visual problem end-to-end.",
            harderStretch = "Critique your finished plate ruthlessly against all 4 pillar checkpoints (Proportion, Form, Value, Composition).",
            cumulativeTieIn = "Capstone synthesis uniting all 12 Worlds."
        )
    )

    val recallQuestionsBySkill: Map<String, RecallQuestion> = mapOf(
        "sk_eye_hand" to RecallQuestion(
            prompt = "During blind contour training, why do we keep our eyes locked on the subject rather than peeking down at the paper?",
            options = listOf(
                "To train slow eye-hand synchronization instead of rushing with memory symbols",
                "So our hand draws faster without needing control",
                "To make every line perfectly straight like a ruler"
            ),
            correctIndex = 0,
            explanation = "Peeking triggers guessing and quick correction habits. Watching only the subject trains genuine observation speed."
        ),
        "sk_contour" to RecallQuestion(
            prompt = "When a contour moves inside a subject (cross-crease or overlapping rim), what does a deliberate weight break communicate?",
            options = listOf(
                "Which form sits in front of the other",
                "That the pencil lead needs sharpening",
                "Strictly decorative border patterns"
            ),
            correctIndex = 0,
            explanation = "An overlapping contour T-junction immediately tells the viewer which surface is closer."
        ),
        "sk_neg_space" to RecallQuestion(
            prompt = "Why is drawing negative space shapes often more accurate than drawing the object itself?",
            options = listOf(
                "Empty air shapes have no preconceived name or symbol bias",
                "Negative spaces are always perfect squares",
                "It eliminates the need to look at angles"
            ),
            correctIndex = 0,
            explanation = "Your brain doesn't hold a pre-baked symbol for an empty gap between chair legs, so you naturally measure true angles."
        ),
        "sk_sight_prop" to RecallQuestion(
            prompt = "To keep sight-measurements consistent while measuring with your pencil at arm's length, what must stay locked?",
            options = listOf(
                "Elbow straight, same head position, and one eye closed",
                "Resting your elbow comfortably on the sketchbook",
                "Tilting your head side to side to check both angles"
            ),
            correctIndex = 0,
            explanation = "Bending your elbow changes the pencil's apparent distance and breaks every comparative ratio."
        ),
        "sk_cubes" to RecallQuestion(
            prompt = "In a believable 3D cube rotated away from you, what happens to a set of parallel edges as they recede?",
            options = listOf(
                "They gradually converge toward each other",
                "They flare wider apart as they go back",
                "They bend into circular curves"
            ),
            correctIndex = 0,
            explanation = "Distant parallel edges appear slightly closer together (foreshortened) as they recede from your eye."
        ),
        "sk_spheres_cyl" to RecallQuestion(
            prompt = "What is the exact geometric angle between a cylinder's central minor axis and the widest axis of its ellipse?",
            options = listOf(
                "Always 90 degrees (perpendicular), regardless of tilt",
                "Always 45 degrees toward the light",
                "Strictly horizontal on the paper"
            ),
            correctIndex = 0,
            explanation = "Keeping the ellipse major axis 90° perpendicular to the cylinder's spine prevents twisted or crooked bottles and limbs."
        ),
        "sk_cross_contour" to RecallQuestion(
            prompt = "What happens to a cross-contour line right as it reaches the outer silhouette of a rounded form?",
            options = listOf(
                "It hooks tightly around the edge as the surface turns away from view",
                "It flattens straight out perpendicular to the silhouette",
                "It stops half an inch before the border"
            ),
            correctIndex = 0,
            explanation = "Hooking cross-contours at the perimeter reveals that the surface wraps smoothly around behind the object."
        ),
        "sk_form_intersect" to RecallQuestion(
            prompt = "Why should you 'draw through' hidden back edges when intersecting two 3D forms?",
            options = listOf(
                "So you can calculate the exact 3D wrap where their internal volumes meet",
                "Because erasers cannot remove construction lines",
                "To make the final line art look cluttered"
            ),
            correctIndex = 0,
            explanation = "Without knowing the internal depth of both objects, intersection seams look pasted flat onto the surface."
        ),
        "sk_stroke_conf" to RecallQuestion(
            prompt = "Which arm joint should drive long structural lines and wide ellipses?",
            options = listOf(
                "The shoulder joint, locked smoothly through the elbow",
                "Tiny finger flexing while the wrist stays planted",
                "Fast wrist flicks only"
            ),
            correctIndex = 0,
            explanation = "Finger and wrist pivots create short arcs and hairy strokes; shoulder motion produces fluid, confident lines."
        ),
        "sk_line_weight" to RecallQuestion(
            prompt = "In pure line drawings without shading, where should the darkest, thickest line weight typically live?",
            options = listOf(
                "Closer overlapping edges and underside shadow transitions",
                "Distant background horizon lines",
                "The brightest top edge facing the light"
            ),
            correctIndex = 0,
            explanation = "Heavier front overlaps create instant foreground/background separation and imply gravity."
        ),
        "sk_hatching" to RecallQuestion(
            prompt = "What creates dark, non-muddy cross-hatching?",
            options = listOf(
                "Controlled spacing and deliberate 30°–45° angle layers rather than scrubbing",
                "Pressing furiously back and forth without lifting the pen",
                "Using perpendicular 90° checkerboards everywhere"
            ),
            correctIndex = 0,
            explanation = "Diamond-shaped angle shifts let paper breathe through cleanly; right-angle grids often look mechanical and flat."
        ),
        "sk_stippling_tex" to RecallQuestion(
            prompt = "How should darker shadow tones be created when stippling?",
            options = listOf(
                "By placing uniform small dots much closer together",
                "By dragging short dashes across the shadow",
                "By drawing giant thick circles only in shadows"
            ),
            correctIndex = 0,
            explanation = "Consistent dot size with shifting spatial density preserves crisp optical blending."
        ),
        "sk_value_scale" to RecallQuestion(
            prompt = "Why do artists squint their eyes when checking tonal values on a subject?",
            options = listOf(
                "Squinting blurs distracting details so large light and dark value masses read clearly",
                "Squinting makes light values appear bright white",
                "It measures perspective angles automatically"
            ),
            correctIndex = 0,
            explanation = "Reducing visual detail helps group values accurately into clean Light vs. Shadow families."
        ),
        "sk_form_shadow" to RecallQuestion(
            prompt = "What is the most common tonal mistake beginners make with Reflected Light inside a shadow?",
            options = listOf(
                "Making reflected light as bright as the lit side, breaking the shadow family",
                "Making the core shadow darker than the highlight",
                "Blending the halftone smoothly"
            ),
            correctIndex = 0,
            explanation = "Reflected light sits inside the shadow family—it must ALWAYS stay darker than the darkest halftone on the lit side."
        ),
        "sk_cast_shadow" to RecallQuestion(
            prompt = "Where is a cast shadow typically sharpest and darkest?",
            options = listOf(
                "Right at the contact point (occlusion crease) beneath the object",
                "At the far tip furthest away from the object",
                "Floating separated from the base edge"
            ),
            correctIndex = 0,
            explanation = "Little ambient light reaches the tight gap under the base, creating crisp occlusion anchoring the object."
        ),
        "sk_edge_control" to RecallQuestion(
            prompt = "Where do soft ('lost') edges naturally belong on a lit curved form?",
            options = listOf(
                "Along gentle form turns like the core shadow transition",
                "At overlapping foreground silhouettes against a white wall",
                "Along razor-sharp cast shadow bases"
            ),
            correctIndex = 0,
            explanation = "Varying crisp overlaps against soft rounded turns gives drawings natural atmospheric three-dimensionality."
        ),
        "sk_1pt_persp" to RecallQuestion(
            prompt = "In 1-point perspective, what does the Horizon Line always represent?",
            options = listOf(
                "The viewer's exact eye level",
                "Strictly the floor height",
                "Where the light source sits"
            ),
            correctIndex = 0,
            explanation = "Planes above the Horizon Line show their undersides; planes below show their tops because it equals your eye height."
        ),
        "sk_2pt_persp" to RecallQuestion(
            prompt = "Why do boxes look unnaturally warped when both Vanishing Points sit very close together inside the page?",
            options = listOf(
                "They violate the natural 60° cone of vision, causing extreme lens distortion",
                "The horizon line disappears",
                "Vertical lines become curved"
            ),
            correctIndex = 0,
            explanation = "Keeping VPs spaciously separated creates natural camera perspective free of pinched corners."
        ),
        "sk_3pt_persp" to RecallQuestion(
            prompt = "When do you add a 3rd Vanishing Point above or below the Horizon Line?",
            options = listOf(
                "When looking dramatically steep upward or downward so verticals converge too",
                "Whenever an object sits on a flat table at eye level",
                "To draw curved cylinders without ellipses"
            ),
            correctIndex = 0,
            explanation = "Tilting the camera sharply up or down causes tall vertical edges to taper toward a 3rd zenith/nadir VP."
        ),
        "sk_persp_div" to RecallQuestion(
            prompt = "How does drawing an 'X' across a perspective rectangle find its true visual center?",
            options = listOf(
                "Perspective foreshortening compresses the far half, and the diagonal intersection marks true midpoint",
                "It splits the plane into two unequal triangles",
                "You only use X-diagonals on flat circles"
            ),
            correctIndex = 0,
            explanation = "The far half is physically smaller on paper than the front half; the X locates true foreshortened symmetry."
        ),
        "sk_still_construct" to RecallQuestion(
            prompt = "On a vertical cup or wine glass below your eye level, which ellipse looks rounder (wider vertically)?",
            options = listOf(
                "The bottom base ellipse, because it sits further below the Horizon Line",
                "The top rim ellipse closest to eye level",
                "Both are always identical circles"
            ),
            correctIndex = 0,
            explanation = "As horizontal circles drop further from your eye level, you see more of their circular face (wider minor axis)."
        ),
        "sk_still_prop" to RecallQuestion(
            prompt = "When sketching a 3-object still life, what should happen BEFORE shading or surface textures?",
            options = listOf(
                "Verify comparative widths, heights, overlaps, and floor footprints across all items",
                "Finish shading the mug completely first",
                "Outline all brand logos in dark ink"
            ),
            correctIndex = 0,
            explanation = "Locking overall proportions and relationships early prevents having to erase detailed shading later."
        ),
        "sk_still_comp" to RecallQuestion(
            prompt = "Why do artists intentionally overlap objects in a still life rather than spacing them neatly apart?",
            options = listOf(
                "Overlapping immediately creates unified groupings and clear front-to-back depth",
                "It hides poorly drawn edges",
                "So every object has the exact same height"
            ),
            correctIndex = 0,
            explanation = "Overlaps create strong T-junction depth cues and bind separate items into one cohesive focal group."
        ),
        "sk_still_value" to RecallQuestion(
            prompt = "What is the primary goal of 'value grouping' across a multi-object still life?",
            options = listOf(
                "Merging adjacent cast and form shadows into simple readable dark patterns",
                "Making every surface equal middle gray",
                "Tracing harsh black outlines around every item"
            ),
            correctIndex = 0,
            explanation = "Unified shadow patterns simplify visual clutter and give dramatic lighting punch."
        ),
        "sk_tex_hard" to RecallQuestion(
            prompt = "Where should small wood grain, brick cracks, or surface texture details appear sharpest?",
            options = listOf(
                "Along the halftone/terminator turning area, fading softly inside bright lights & deep shadows",
                "Evenly drawn at 100% intensity across every square inch",
                "Only inside the darkest #9 cast shadow"
            ),
            correctIndex = 0,
            explanation = "Over-rendering texture everywhere flattens the underlying 3D light and shadow form."
        ),
        "sk_tex_reflect" to RecallQuestion(
            prompt = "What visual signature separates shiny chrome/metal from matte plaster or wood?",
            options = listOf(
                "Sharp, abrupt tonal jumps from near-white (#1) directly next to deep dark (#9)",
                "Soft, blurry uniform midtones everywhere",
                "Eliminating cast shadows completely"
            ),
            correctIndex = 0,
            explanation = "Mirror-like surfaces reflect crisp high-contrast bands of surrounding sky and dark ground."
        ),
        "sk_tex_fabric" to RecallQuestion(
            techniqueQuestionPrompt("What creates the fold direction and stretch lines in draped fabric?"),
            options = listOf(
                "Gravity pulling downward away from physical anchor/tension points",
                "Random squiggly waves independent of the body underneath",
                "Strictly horizontal parallel stripes"
            ),
            correctIndex = 0,
            explanation = "Every fold starts from a pin, shoulder, knee, or gravity hang—understanding the tension point explains every crease."
        ),
        "sk_tex_organic" to RecallQuestion(
            prompt = "How do you avoid hair looking like dry hay or tangled wire?",
            options = listOf(
                "Render hair as grouped 3D ribbons following the head's light and core shadow first",
                "Draw thousands of individual thin hairs from start to finish",
                "Leave the entire hair silhouette pure white"
            ),
            correctIndex = 0,
            explanation = "Large sculptural clumps with a unified terminator give hair believable weight and shine."
        ),
        "sk_botanical" to RecallQuestion(
            prompt = "What keeps leaves and flower petals from looking like flat paper stickers?",
            options = listOf(
                "Tracking the 3D twisting center midrib ribbon and overlapping petal depth",
                "Drawing saw-tooth outlines around every leaf before placing the stem",
                "Making every petal completely symmetrical"
            ),
            correctIndex = 0,
            explanation = "Following the curving spine midrib reveals how leaves bend toward and away from the viewer."
        ),
        "sk_trees_terrain" to RecallQuestion(
            prompt = "How should tree foliage canopies be thought of before adding leaf clusters?",
            options = listOf(
                "Simple interlocking 3D rounded spheres with clear sunlit tops and shadowed undersides",
                "Thousands of separate individual leaf outlines",
                "Flat green triangle silhouettes"
            ),
            correctIndex = 0,
            explanation = "Shading canopies as big lit volumes makes trees feel grounded and sunlit in seconds."
        ),
        "sk_animal_struct" to RecallQuestion(
            prompt = "Which two major structural masses anchor nearly every quadruped animal pose?",
            options = listOf(
                "Ribcage mass and pelvis mass linked by the flexible spine curve",
                "Ears and tail tip",
                "Individual whiskers and fur stripes"
            ),
            correctIndex = 0,
            explanation = "Placing ribcage and pelvis volumes sets balance, perspective twist, and limb sockets immediately."
        ),
        "sk_animal_coat" to RecallQuestion(
            prompt = "Where does fur texture naturally break up most visibly on a mammal's coat?",
            options = listOf(
                "Along the outer silhouette edge and right across the core shadow border",
                "Flatly stamped in identical marks over the highlight",
                "Only on the nose tip"
            ),
            correctIndex = 0,
            explanation = "Suggesting fur selectively at silhouette edges and shadow turns keeps the animal's 3D form intact."
        ),
        "sk_gesture" to RecallQuestion(
            prompt = "In a dynamic 60-second gesture drawing, what takes top priority?",
            options = listOf(
                "Overall Line of Action, weight balance, and shoulder/hip opposition",
                "Cleanly outlining fingers, shoelaces, and facial eyelashes",
                "Shading muscles smoothly with cross-hatching"
            ),
            correctIndex = 0,
            explanation = "Gesture captures life, rhythm, and balance in seconds; anatomy and polish always follow later."
        ),
        "sk_fig_prop" to RecallQuestion(
            prompt = "In the classic 8-head standing figure proportion canon, what landmark sits near the halfway point (4 heads down)?",
            options = listOf(
                "The pelvis / hip hinge (greater trochanters & pubic arch)",
                "The belly button",
                "The knees"
            ),
            correctIndex = 0,
            explanation = "Knowing the hip hinge splits the figure evenly in half prevents oversized torsos or stubby legs."
        ),
        "sk_anatomy_core" to RecallQuestion(
            prompt = "When the torso tilts sideways (contrapposto), what happens to the shoulder vs. hip angles?",
            options = listOf(
                "They counter-tilt opposite each other, pinching one side waist and stretching the other",
                "They stay strictly parallel horizontal lines",
                "Both hips lift up toward the head"
            ),
            correctIndex = 0,
            explanation = "Opposing shoulder/hip tilts plus asymmetric stretch-vs-pinch folds give standing poses natural gravity."
        ),
        "sk_hands_feet" to RecallQuestion(
            prompt = "Before drawing individual fingers, how should you simplify the palm and knuckles?",
            options = listOf(
                "As a simple 3D wedge/box with curved knuckle arcs guiding finger lengths",
                "As 5 straight parallel sticks off a circle",
                "By drawing fingernails first"
            ),
            correctIndex = 0,
            explanation = "A box-wedge palm enforces perspective foreshortening and keeps finger bases naturally arched."
        ),
        "sk_loomis_head" to RecallQuestion(
            prompt = "On a constructed Loomis head, what are the 3 equal vertical thirds on the front facial mask?",
            options = listOf(
                "Hairline to Brow • Brow to Nose Base • Nose Base to Chin",
                "Top of Skull to Eyes • Eyes to Mouth • Mouth to Neck",
                "Ear to Cheek • Cheek to Chin • Chin to Shoulder"
            ),
            correctIndex = 0,
            explanation = "Dividing the facial plane into equal thirds places the features accurately across tilted angles."
        ),
        "sk_eyes_nose" to RecallQuestion(
            prompt = "Why should eyelids curve visibly around the eye rather than looking like flat almond stickers?",
            options = listOf(
                "Because eyelids have thickness and wrap over a 3D spherical eyeball recessed inside the socket",
                "Because eyebrows sit right on the eyelashes",
                "To make eyes twice as wide as the mouth"
            ),
            correctIndex = 0,
            explanation = "Respecting eyeball sphericity and lid thickness makes eyes sit organically inside the skull."
        ),
        "sk_mouth_ears_hair" to RecallQuestion(
            prompt = "How does the dental cylinder shape affect drawing a smiling or 3/4 mouth?",
            options = listOf(
                "Mouth corners wrap backward around the rounded jaw curve; the far corner foreshortens sharply",
                "Mouth lines stay completely flat left-to-right regardless of head turn",
                "The ear attaches directly to the mouth corner"
            ),
            correctIndex = 0,
            explanation = "Wrapping lips over the barrel of teeth and jaw prevents 'floating sideways sticker' mouths."
        ),
        "sk_expressions" to RecallQuestion(
            prompt = "What makes an emotional expression feel alive rather than stiffly pasted on?",
            options = listOf(
                "Connected squash-and-stretch across brows, cheeks, nostrils, and jaw volume together",
                "Moving only the mouth line while keeping eyes/cheeks frozen",
                "Drawing darker outlines around teeth"
            ),
            correctIndex = 0,
            explanation = "Facial muscles pull skin across the whole mask; authentic expression reshapes neighboring planes too."
        ),
        "sk_comp_focal" to RecallQuestion(
            prompt = "Which tool is most effective for testing whether a composition's focal point works before committing hours to a finish?",
            options = listOf(
                "Small 2–3 inch 3-value grayscale thumbnail sketches",
                "Starting immediately on a giant sheet at 100% scale",
                "Adding intricate texture details first"
            ),
            correctIndex = 0,
            explanation = "Thumbnails expose balance, focal contrast, and dead spaces in 3 minutes instead of wasting hours."
        ),
        "sk_arch_env" to RecallQuestion(
            prompt = "When standing on flat ground, where does the eye level of other standing people of similar height align on your page?",
            options = listOf(
                "Their heads sit right on your Horizon Line regardless of how close or far they stand",
                "Distant people float near the very top edge of the page",
                "Closer people shrink smaller below the horizon"
            ),
            correctIndex = 0,
            explanation = "Anyone sharing your flat ground plane and approximate height aligns their eyes with your Horizon Line—scaling their feet downward cleanly."
        ),
        "sk_atmo_depth" to RecallQuestion(
            prompt = "As mountains or buildings recede miles into the background, what happens to their value contrast and edges?",
            options = listOf(
                "Contrast narrows and softens toward lighter background air; deep darks stay in the foreground",
                "Background silhouettes become pitch black #9 with razor edges",
                "Everything stays equal contrast from front to back"
            ),
            correctIndex = 0,
            explanation = "Dust and air scatter light across distance, softening edges and lifting dark shadows lighter."
        ),
        "sk_storytelling" to RecallQuestion(
            prompt = "How does shifting the Horizon Line low (worm's-eye angle) alter the emotional mood of a scene?",
            options = listOf(
                "Subjects loom monumental, dramatic, or imposing above the viewer",
                "Subjects appear small, fragile, or surveyed from above",
                "It flattens all perspective lines into parallel grids"
            ),
            correctIndex = 0,
            explanation = "Camera height directly shapes empathy and power hierarchy between viewer and subject."
        ),
        "sk_imagination" to RecallQuestion(
            prompt = "What separates persuasive imaginative drawing from flat cartoon guesswork?",
            options = listOf(
                "Constructing transparent primitives, centerlines, and perspective footprints before rendering details",
                "Never looking at real-world references again",
                "Memorizing decorative surface cracks"
            ),
            correctIndex = 0,
            explanation = "Rotation from imagination relies on structural boxes, cylinders, and light logic built up from real observation."
        ),
        "sk_stylization" to RecallQuestion(
            prompt = "Why do great stylized artists first study realistic structure and anatomy?",
            options = listOf(
                "So their intentional exaggerations still feel balanced, rhythmic, and three-dimensional",
                "Because stylized art cannot use simple shapes",
                "To copy photographs pixel by pixel"
            ),
            correctIndex = 0,
            explanation = "Stylization is selective simplification and exaggeration of truth—not ignorance of how form works."
        ),
        "sk_master_study" to RecallQuestion(
            prompt = "What is the best first step when learning from a Master Drawing study?",
            options = listOf(
                "Analyze its underlying 3-value structure, gesture flow, and focal light placement before copying strokes",
                "Trace the outer outline mechanically inch by inch",
                "Ignore shadows and focus only on signature style"
            ),
            correctIndex = 0,
            explanation = "Understanding WHY the master placed key shapes builds transferable knowledge for your own art."
        ),
        "sk_portfolio" to RecallQuestion(
            prompt = "When a finished drawing feels 'off' or stiff at the end, which discipline most often reveals the root flaw?",
            options = listOf(
                "Checking foundational structure, proportions, and Big Light/Shadow grouping (not tiny surface polish)",
                "Adding heavier highlights and sharper tiny hairs",
                "Switching to an expensive brand of paper"
            ),
            correctIndex = 0,
            explanation = "Surface details never fix structural, proportional, or value-grouping errors underneath."
        )
    )

    private fun techniqueQuestionPrompt(raw: String): String = raw

    internal fun getPedagogy(skillId: String): SkillPedagogy {
        return skillPedagogy[skillId] ?: SkillPedagogy(
            techniqueFocus = "Construct primary structural shapes lightly before refining final contours or tones.",
            unfamiliarSubjectHint = "Select a new subject from your room or memory that shares this core form.",
            harderStretch = "Repeat the plate at double speed or rotated 45° without erasing.",
            cumulativeTieIn = "Links observational accuracy, 3D volume, and intentional value control."
        )
    }

    fun getRecallQuestion(lesson: Lesson): RecallQuestion {
        return recallQuestionsBySkill[lesson.primarySkillId] ?: RecallQuestion(
            prompt = "Before adding details to '${lesson.title}', what should come first in your sketchbook?",
            options = listOf(
                "Light structural placement, big proportions, and honest visual checking",
                "Heavy dark outlines and fine surface texture",
                "Working strictly from zoomed-in corner to corner"
            ),
            correctIndex = 0,
            explanation = "Big structural placement and honest observation prevent costly errors before rendering."
        )
    }

    fun evaluateSelfAssessment(
        lesson: Lesson,
        checkedStates: List<Boolean>,
        rating: DifficultyRating,
        confidence: ConfidenceLevel,
        recallAnsweredCorrectly: Boolean?,
        prerequisiteWeakNames: List<String>
    ): HonestEvaluationFeedback {
        val checkedCount = checkedStates.count { it }
        val totalChecks = checkedStates.size.coerceAtLeast(1)
        val ratio = checkedCount.toFloat() / totalChecks.toFloat()
        val missedCriteria = lesson.selfAssessmentChecklist.filterIndexed { idx, _ ->
            !checkedStates.getOrElse(idx) { false }
        }

        val observations = mutableListOf<String>()
        if (missedCriteria.isNotEmpty()) {
            observations.add("Unchecked criteria to target next: ${missedCriteria.take(2).joinToString(" • ")}")
        } else {
            observations.add("All $totalChecks physical inspection criteria checked honestly.")
        }

        if (recallAnsweredCorrectly == false) {
            observations.add("Concept recall check missed — re-read the diagram & explanation cues before rushing ahead.")
        } else if (recallAnsweredCorrectly == true) {
            observations.add("Concept check confirmed — your mental model matches the physical drill.")
        }

        if (confidence == ConfidenceLevel.HIGH && rating == DifficultyRating.DIFFICULT) {
            observations.add("You felt confident despite high difficulty: great persistence, though spaced repetition will return soon to lock it in.")
        } else if (confidence == ConfidenceLevel.LOW && rating == DifficultyRating.EASY) {
            observations.add("Notice that discrepancy: you marked it Easy, yet Confidence was Low — trust your honest uncertainty and schedule a light unguided check.")
        }

        val headline = when {
            confidence == ConfidenceLevel.LOW || rating == DifficultyRating.DIFFICULT || ratio < 0.65f ->
                "Targeted Reinforcement Recommended"
            confidence == ConfidenceLevel.HIGH && rating == DifficultyRating.EASY && ratio >= 0.85f && recallAnsweredCorrectly != false ->
                "Strong Execution & Clear Understanding"
            else ->
                "Solid Progress — Ready for Spaced Spacing"
        }

        val nextStepAdvice = when {
            prerequisiteWeakNames.isNotEmpty() && (confidence == ConfidenceLevel.LOW || rating == DifficultyRating.DIFFICULT) ->
                "Before pushing harder variations, spend 5 minutes tightening ${prerequisiteWeakNames.first()} — weak foundations magnify errors here."
            confidence == ConfidenceLevel.LOW || rating == DifficultyRating.DIFFICULT || ratio < 0.65f ->
                "This skill is queued for short-interval review tomorrow (1 day) starting at Guided Practice. Focus specifically on: ${missedCriteria.firstOrNull() ?: lesson.completionCriteria}"
            confidence == ConfidenceLevel.HIGH && rating == DifficultyRating.EASY && ratio >= 0.85f ->
                "Next interval widened so you don't waste time repeating what already clicks. Watch for an unguided delayed check later to lock in Mastery."
            else ->
                "Scheduled for an interleaved review in a few days on a fresh subject so the habit transfers cleanly."
        }

        val prereqAlert = if (prerequisiteWeakNames.isNotEmpty()) {
            "Prerequisite check: ${prerequisiteWeakNames.joinToString(", ")} showed earlier struggle and directly supports this skill."
        } else null

        return HonestEvaluationFeedback(
            headline = headline,
            observations = observations,
            nextStepAdvice = nextStepAdvice,
            prerequisiteAlert = prereqAlert
        )
    }
}
