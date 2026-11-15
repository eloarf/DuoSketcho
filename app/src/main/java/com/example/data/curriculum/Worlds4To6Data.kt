package com.example.data.curriculum

import com.example.domain.model.DiagramType
import com.example.domain.model.DrawingWorld
import com.example.domain.model.MilestoneProject

internal fun worlds4To6(): List<DrawingWorld> = listOf(
    // WORLD 4: LIGHT AND SHADOW
    DrawingWorld(
        number = 4,
        id = "world_4",
        title = "Light and Shadow",
        tagline = "Sculpt unmistakable 3D form through value, shadow shapes, and edge control",
        focusSummary = "Master 9-step value scales, the 5 zones of light, core vs. cast shadows, reflected light, and lost-and-found shading transitions.",
        unlockRequirementSummary = "Complete World 3 Milestone & reach Practicing in Line Control skills",
        units = listOf(
            buildUnit(
                4, 1, "w4_u1", "Value Scales & Tonal Discipline",
                "Control graphite pressure and pencil grades to hit exact, un-streaked tonal steps from paper white to pitch dark.",
                listOf(
                    LessonSpec(
                        id = "w4_u1_l1",
                        title = "5-Step & 9-Step Graphite Value Scales",
                        subtitle = "Calibrating pencil pressure and grade swaps",
                        objective = "Shade even, grain-free tonal steps from #1 (white paper) through #5/#9 (deep 4B/6B black).",
                        explanation = "Color hides weak shading; pure monochrome reveals every blotch immediately. A value scale trains your hand to hold a steady tone across an entire zone without patchy dark streaks, and teaches when to switch from 2H (light halftones) to HB/2B (midtones) to 4B (deep shadows).",
                        whyItMatters = "Value—not outlines—is what makes a sphere pop off a page. Every realistic shaded drawing is built from clean value relationships.",
                        materials = listOf("2H, HB, 2B, 4B graphite pencils", "Smooth Bristol or drawing paper", "Kneaded eraser"),
                        steps = listOf(
                            "Rule a horizontal row of nine 2×2.5 cm adjoining rectangles.",
                            "Leave Box 1 pure untouched paper; fill Box 9 with layered 4B graphite until velvety matte dark (don't grind so hard it turns shiny!).",
                            "Establish Box 5 (exact mid-gray) using HB, then bridge Boxes 2–4 with 2H/HB and Boxes 6–8 with 2B/4B.",
                            "Layer light cross-directional strokes using the side of the pencil lead—no finger smudging!"
                        ),
                        ex1Title = "9-Step Calibration Bar",
                        ex1Desc = "Build a complete 9-step graphite bar checking from 2 meters away that every step jumps evenly without twin boxes.",
                        ex1Reps = "2 full 9-step scales",
                        ex1Min = 12,
                        ex2Title = "Seamless Graphite Gradient Ribbon",
                        ex2Desc = "Shade a 16×3 cm unlined strip transitioning imperceptibly from white paper on the right to velvety 4B dark on the left.",
                        ex2Reps = "2 seamless ribbons",
                        ex2Min = 9,
                        ex3Title = "No-Streak Flat Wash Squares",
                        ex3Desc = "Shade four 4×4 cm squares matching values #2, #4, #6, and #8 completely evenly using slow tiny overlapping ovals ('scumbling').",
                        ex3Reps = "4 flat uniform value patches",
                        ex3Min = 8,
                        challengeTitle = "3-Value Posterization Card",
                        challengeDesc = "Take any room object, squint hard, and render it strictly in 3 flat values (#1 white, #5 mid-gray, #8 dark) with zero gradients.",
                        challengeReps = "2 three-value poster studies",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Pressing hard with HB to try to get black (causes metallic glare)" to "Swap to softer 2B/4B pencils for darks and build in 3 light layers.",
                            "Smearing graphite with bare fingers (leaves skin oils and blotches)" to "Keep tones clean with layered pencil pressure or a clean paper tortillon only."
                        ),
                        checklist = listOf(
                            "Each step on the 9-step scale looks clearly distinct from its neighbors.",
                            "Dark boxes are rich matte black without shiny metallic gouges.",
                            "Flat value patches show minimal streak lines or patchy clouds."
                        ),
                        criteria = "Complete two clean 9-step scales, two gradients, and four flat washes.",
                        diagramType = DiagramType.VALUE_SCALE_AND_SPHERE,
                        primarySkillId = "sk_value_scale"
                    ),
                    LessonSpec(
                        id = "w4_u1_l2",
                        title = "Two-Value Grouping (Light vs. Shadow)",
                        subtitle = "The secret of instant graphic clarity",
                        objective = "Separate an entire subject cleanly into two unified families: everything in direct light vs. everything in shadow.",
                        explanation = "Beginners shade individual bumps bright and dark all over the page, turning drawings muddy. Professionals first map ONE crisp 'shadow line' (terminator) and fill the entire shadow side—both form shadow and cast shadow—with a single flat mid-dark tone.",
                        whyItMatters = "Once your light and shadow shapes read cleanly in 2 values, any subtle details you add later cannot break the lighting.",
                        materials = listOf("HB & 2B pencils", "Sketchbook", "Desk lamp + single light source"),
                        steps = listOf(
                            "Light a white mug or crumpled paper ball with one bright lamp in a dim corner.",
                            "Squint 80% shut so surface textures vanish and only two shapes remain: bright light and dark shadow.",
                            "Draw the clean boundary line separating light from shadow, then fill the ENTIRE shadow family evenly at Value #6."
                        ),
                        ex1Title = "2-Value Crumpled Cloth Study",
                        ex1Desc = "Toss a white pillowcase or paper towel under a single desk lamp. Squint and map ONLY the pure light vs. pure #6 shadow shapes.",
                        ex1Reps = "2 crisp notan cloth studies",
                        ex1Min = 12,
                        ex2Title = "2-Value Cup & Spoon Silhouette",
                        ex2Desc = "Place a white cup and spoon under strong side-light. Unite the cup's shadow side directly into its cast shadow as one continuous dark shape.",
                        ex2Reps = "3 unified shadow-shape studies",
                        ex2Min = 9,
                        ex3Title = "Value Hierarchy Rule Test",
                        ex3Desc = "Draw 3 spheres: keep ALL light-side halftones brighter than Value #4, and ALL shadow values darker than Value #6 so the two families never overlap.",
                        ex3Reps = "3 disciplined 2-family spheres",
                        ex3Min = 8,
                        challengeTitle = "High-Contrast Window Corner",
                        challengeDesc = "Sketch a corner of a sunlit room purely in flat Value #1 (light) and Value #7 (shadow) like a classic ink woodcut.",
                        challengeReps = "1 interior notan thumbnail",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Making shadows too pale and halftones too dark" to "Maintain a clear tonal gap between the darkest halftone and the brightest reflected light.",
                            "Outlining objects heavily around the sunlit side" to "Let the bright side contrast softly against a slightly toned background instead of thick dark outlines."
                        ),
                        checklist = listOf(
                            "Squinting at my drawing shows a bold, readable light-vs-shadow pattern.",
                            "Form shadows and cast shadows flow together as one unified family.",
                            "No halftone accidentally looks darker than the shadow side."
                        ),
                        criteria = "Complete 8 crisp two-value shadow-grouping studies.",
                        diagramType = DiagramType.VALUE_SCALE_AND_SPHERE,
                        primarySkillId = "sk_value_scale",
                        reinforcedSkillIds = listOf("sk_form_shadow")
                    ),
                    LessonSpec(
                        id = "w4_u1_l3",
                        title = "Background Value & Key Control",
                        subtitle = "Using toned surroundings to carve bright edges",
                        objective = "Control contrast around silhouettes by placing dark backgrounds behind sunlit edges and light backgrounds behind shadow edges.",
                        explanation = "A white highlight edge on white paper disappears unless you either outline it (which flattens realism) or lay a subtle Value #3–#5 tone behind it! Value contrast against the background lets edges shine without outlines.",
                        whyItMatters = "Transforms student drawings from 'cutout stickers on blank paper' into atmospheric, grounded compositions.",
                        materials = listOf("2H, HB, 2B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Lightly construct a white egg or white coffee mug on a surface.",
                            "Instead of outlining the sunlit left rim darkly, gently shade a soft Value #4 gradient halo in the background behind that bright rim.",
                            "Allow the shaded right side of the object to read darker against a lighter Value #2 background."
                        ),
                        ex1Title = "Outline-Free Lit Egg Study",
                        ex1Desc = "Draw an egg or white ball lit from top-left with NO dark outer contour lines—carve the sunlit top-left edge using a softly shaded #4 background.",
                        ex1Reps = "2 outline-free eggs",
                        ex1Min = 14,
                        ex2Title = "High-Key vs. Low-Key Squares",
                        ex2Desc = "Draw the same simple pear twice: once in High-Key (all values #1–#5, airy and bright) and once in Low-Key (all values #5–#9, moody chiaroscuro).",
                        ex2Reps = "2 contrasting tonal key studies",
                        ex2Min = 12,
                        ex3Title = "Value-Against-Value Rim Check",
                        ex3Desc = "Shade 4 simple cylinders against a graded horizontal backdrop so each edge shifts cleanly from light-on-dark to dark-on-light.",
                        ex3Reps = "4 counterchange cylinders",
                        ex3Min = 8,
                        challengeTitle = "White Ceramic Bowl on Dark Cloth",
                        challengeDesc = "Place a white cup or bowl on a dark notebook or fabric. Render the bright rim glowing crisply against the dark surround.",
                        challengeReps = "1 outline-free counterchange plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Leaving a stiff white halo gap between the object and background shading" to "Bring background tone cleanly right up to the object's true edge.",
                            "Drawing dark outlines all the way around a shaded sphere" to "Dissolve outlines cleanly into neighboring values."
                        ),
                        checklist = listOf(
                            "Bright edges pop crisply against darker background values without outlines.",
                            "High-key and low-key studies convey distinctly different moods.",
                            "Background tones feel seamless right up to the edge."
                        ),
                        criteria = "Complete 8 counterchange and key-control value studies.",
                        diagramType = DiagramType.VALUE_SCALE_AND_SPHERE,
                        primarySkillId = "sk_value_scale",
                        reinforcedSkillIds = listOf("sk_edge_control")
                    )
                )
            ),
            buildUnit(
                4, 2, "w4_u2", "The 5 Elements of Light on Form",
                "Understand highlight, halftone, core shadow, reflected light, and occlusion shadow on rounded volumes.",
                listOf(
                    LessonSpec(
                        id = "w4_u2_l1",
                        title = "Anatomy of a Lit Sphere",
                        subtitle = "Highlight, halftone, core shadow & reflected light",
                        objective = "Render a believable 3D sphere demonstrating all five classic light zones in proper tonal order.",
                        explanation = "Light strikes perpendicular planes brightest (Center Light + Specular Highlight), grazes curved turns into Halftones, drops past the Terminator line into the darkest band on the object—the Core Shadow—and softly picks up bounce light from the tabletop (Reflected Light) on the far underside.",
                        whyItMatters = "Once you master the lit sphere, you understand how light wraps around cheeks, apples, shoulders, and domes.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Smooth drawing paper"),
                        steps = listOf(
                            "Lightly draw an 8 cm circle and plot a top-left light arrow.",
                            "Map the elliptical Terminator belt wrapping across the sphere at 90° to the light ray.",
                            "Shade the entire shadow side flat at Value #6 first, then darken the Core Shadow belt along the terminator to Value #8.",
                            "Leave the bottom-right rim subtly lighter (#5) as Reflected Light—never as bright as the lit side! Gently step Halftones (#2–#4) around the Highlight (#1)."
                        ),
                        ex1Title = "Annotated 5-Zone Master Sphere",
                        ex1Desc = "Draw one large 9 cm sphere carefully stepping through all 5 zones. Label Highlight, Halftone, Core Shadow, Reflected Light, and Cast Shadow in the margin.",
                        ex1Reps = "1 complete 9 cm master sphere",
                        ex1Min = 15,
                        ex2Title = "Rotating Light Angle Spheres",
                        ex2Desc = "Draw 4 smaller 5 cm spheres lit from: (a) top-left, (b) top-right, (c) dramatic rim back-light, and (d) under-lit spooky angle.",
                        ex2Reps = "4 varied light-direction spheres",
                        ex2Min = 12,
                        ex3Title = "Reflected Light Restraint Check",
                        ex3Desc = "Shade 2 spheres focusing specifically on keeping Reflected Light clearly darker than any Midtone on the lit side.",
                        ex3Reps = "2 value-disciplined spheres",
                        ex3Min = 8,
                        challengeTitle = "Sphere Cluster With Bounce Light",
                        challengeDesc = "Draw two spheres touching on a white table; show the bright sphere bouncing subtle secondary light onto the shaded sphere's lower cheek.",
                        challengeReps = "1 two-sphere bounce study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Making Reflected Light bright white like paper" to "Reflected light belongs to the shadow family—keep it Value #5 or darker so the form doesn't look translucent.",
                            "Drawing the Core Shadow straight instead of curved along the sphere's skin" to "Wrap the terminator ellipse cleanly around the sphere's 3D equator."
                        ),
                        checklist = listOf(
                            "Core shadow sits right along the curved terminator and is darker than reflected light.",
                            "Reflected light stays visibly darker than lit halftones.",
                            "Highlight sits inside the center-light area rather than right on the outer edge."
                        ),
                        criteria = "Complete 7 properly ordered lit spheres across varied light angles.",
                        diagramType = DiagramType.VALUE_SCALE_AND_SPHERE,
                        primarySkillId = "sk_form_shadow"
                    ),
                    LessonSpec(
                        id = "w4_u2_l2",
                        title = "Shading Cylinders, Cones & Cubes",
                        subtitle = "Curved turns vs. sharp planar corners",
                        objective = "Contrast smooth vertical core-shadow transitions on cylinders/cones against crisp planar value jumps on cubes.",
                        explanation = "Curved surfaces (cylinders, cones) transition smoothly from light through core shadow into reflected light; flat planar surfaces (cubes) jump sharply in value at each corner edge because each face aims at a different angle to the light.",
                        whyItMatters = "Human anatomy and architecture combine planar breaks (brow ridge, box steps) with rounded rolls (arms, cheeks).",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Drawing pad"),
                        steps = listOf(
                            "Set up a paper towel roll or cardboard box beside a single lamp.",
                            "On the cube: assign one distinct flat value per face (e.g., Top #1.5, Left #4, Right #7.5) with crisp corner separation.",
                            "On the cylinder/cone: shade a soft vertical core band fading smoothly toward lit edge and gentle reflected rim."
                        ),
                        ex1Title = "3-Plane Cube Value Precision",
                        ex1Desc = "Draw 3 rotated cubes lit from top-left. Render Top (#2), Front (#4.5), and Side (#7.5) smoothly with razor-sharp corner junctions (no dark outlines).",
                        ex1Reps = "3 planar shaded cubes",
                        ex1Min = 10,
                        ex2Title = "Vertical & Tilted Cylinders",
                        ex2Desc = "Shade 2 upright cylinders and 2 lying cylinders showing the soft core-shadow stripe running down their length and slightly lighter reflected edge.",
                        ex2Reps = "4 shaded cylinders",
                        ex2Min = 12,
                        ex3Title = "Cone Light Fan",
                        ex3Desc = "Shade 2 cones showing how the core shadow narrows cleanly into a sharp triangular wedge up toward the cone's apex.",
                        ex3Reps = "2 shaded cones",
                        ex3Min = 7,
                        challengeTitle = "Multi-Primitive Table Trio",
                        challengeDesc = "Compose a cube, upright cylinder, and resting cone together under one directional light, preserving consistent plane brightness across all three.",
                        challengeReps = "1 three-primitive light study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Putting a dark outline around the corner where two cube faces meet" to "Let the dark face meet the light face cleanly edge-to-edge without any outline.",
                            "Drawing cylinder core shadows as uniform vertical bars ignoring the top plane" to "Keep the top circular cap properly flat-lit (#1.5–#3) with a clean crisp rim."
                        ),
                        checklist = listOf(
                            "Cube planes separate via clean value contrast without outlines.",
                            "Cylinder and cone core shadows fade smoothly into reflected bounce light.",
                            "Light direction stays consistent across all objects on the page."
                        ),
                        criteria = "Complete 9 primitive form-shadow studies with clean planar vs. rounded contrast.",
                        diagramType = DiagramType.VALUE_SCALE_AND_SPHERE,
                        primarySkillId = "sk_form_shadow",
                        reinforcedSkillIds = listOf("sk_cubes", "sk_spheres_cyl")
                    ),
                    LessonSpec(
                        id = "w4_u2_l3",
                        title = "Compound Turning Planes & Organic Rolls",
                        subtitle = "Seeing curves as angled facets first",
                        objective = "Simplify complex organic forms (fruit, crumpled bags, facial cheek planes) into angled tonal facets before blending smoothly.",
                        explanation = "Every smooth organic cheek or pear can be broken down into 4–6 tilted flat planes first (like a sculpted wooden block). Determining the exact value of each facet prevents mushy, over-blended 'cotton-ball' shading.",
                        whyItMatters = "This planar-first shading discipline is how master portraitists build structure before soft blending.",
                        materials = listOf("HB, 2B, 4B pencils", "Sketchbook", "Pear, bell pepper, or crumpled paper"),
                        steps = listOf(
                            "Construct your organic form lightly.",
                            "Group its surface into 5–8 tilted facets (top-facing, angled shoulder, front wall, turning edge, under-plane).",
                            "Fill each facet cleanly with its assigned step value, then gently bridge facet borders only where the form curves softly."
                        ),
                        ex1Title = "Faceted Pear / Apple Breakdown",
                        ex1Desc = "Draw an apple or pear twice side-by-side: left version strictly faceted like low-poly carved wood; right version softly bridged into smooth organic skin.",
                        ex1Reps = "2 faceted-to-smooth pairs",
                        ex1Min = 14,
                        ex2Title = "Asaro-Style Nose & Brow Block",
                        ex2Desc = "Sketch a simple geometric wedge-nose and brow shelf lit from top-left, assigning clean distinct values to top, front, side, and underside planes.",
                        ex2Reps = "3 planar facial wedge studies",
                        ex2Min = 9,
                        ex3Title = "Crumpled Paper Angular Planes",
                        ex3Desc = "Toss a crumpled sheet of copy paper under a lamp; shade its crisp geometric triangles using sharp value jumps.",
                        ex3Reps = "1 angular paper plane study",
                        ex3Min = 10,
                        challengeTitle = "Ribbon Fold Value Study",
                        challengeDesc = "Twist a strip of white paper into a waving loop on your desk; block the turning planes first, then soften round arches.",
                        challengeReps = "1 twisted paper ribbon plate",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Smoothing away planar transitions everywhere so structure turns rubbery" to "Preserve crisp transitions on sharp folds and soften only rolling domes.",
                            "Forgetting underside planes receive bounce light" to "Keep downward-facing undersides darker than side walls, catching subtle tabletop bounce."
                        ),
                        checklist = listOf(
                            "I mapped flat planar angles before softening curves.",
                            "Top planes consistently read brighter than side and bottom planes.",
                            "Forms feel sculpted and solid rather than soft and blurry."
                        ),
                        criteria = "Complete 6 planar-to-organic value studies.",
                        diagramType = DiagramType.VALUE_SCALE_AND_SPHERE,
                        primarySkillId = "sk_form_shadow",
                        reinforcedSkillIds = listOf("sk_value_scale")
                    )
                )
            ),
            buildUnit(
                4, 3, "w4_u3", "Cast Shadows & Occlusion",
                "Anchor forms onto ground planes with accurate cast shadow geometry, occlusion darks, and edge softness.",
                listOf(
                    LessonSpec(
                        id = "w4_u3_l1",
                        title = "Cast Shadow Geometry & Angle",
                        subtitle = "Connecting object silhouette to ground shadow",
                        objective = "Project believable cast shadows across ground planes using light angle rays and object footprint lines.",
                        explanation = "A cast shadow is simply the object's silhouette flattened onto the table along the direction of light rays. Two rules govern it: (1) all cast shadows on a flat floor stretch away in the same parallel/radial light direction, and (2) they hug the floor plane, never floating uphill.",
                        whyItMatters = "Without accurate cast shadows, beautifully shaded objects float awkwardly in mid-air like stickers.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Desk lamp + small block/cup", "Sketchbook"),
                        steps = listOf(
                            "Pick a light source height (high overhead = short shadow; low evening lamp = long dramatic shadow).",
                            "Draw light projection rays from the object's top corners down at that exact light angle to meet horizontal ground rays from its base corners.",
                            "Connect the landing points to form the cast shadow footprint on the table."
                        ),
                        ex1Title = "Stick & Cube Ray Projection",
                        ex1Desc = "Draw 3 vertical posts and 3 cubes on a floor grid. Construct their exact cast shadow shapes at both 30° (long) and 65° (short) light angles.",
                        ex1Reps = "6 geometrically projected shadows",
                        ex1Min = 12,
                        ex2Title = "Sphere & Cylinder Ground Shadows",
                        ex2Desc = "Draw 3 spheres and 2 cylinders casting elliptical shadows onto the tabletop, making sure shadows flow smoothly underneath the base contact point.",
                        ex2Reps = "5 curved-form cast shadows",
                        ex2Min = 10,
                        ex3Title = "Shadow Climbing Steps/Walls",
                        ex3Desc = "Draw a vertical stick standing in front of a low box step; bend its cast shadow cleanly up the vertical step face and across the top!",
                        ex3Reps = "3 obstacle-bending shadow studies",
                        ex3Min = 8,
                        challengeTitle = "Real Lamp Shadow Shift Study",
                        challengeDesc = "Place a real mug on blank paper under a flashlight/phone light. Sketch the mug + cast shadow at high noon angle and low sunset angle.",
                        challengeReps = "2 live shadow angle studies",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Cast shadows pointing in two different directions in the same scene" to "Check that all shadow axes point toward the exact same horizon direction.",
                            "Drawing shadows shaped like disconnected puddles beside the base" to "Always attach the shadow cleanly around the shaded base contact footprint."
                        ),
                        checklist = listOf(
                            "Cast shadows match the light source angle consistently across objects.",
                            "Shadows bend cleanly when climbing vertical walls or steps.",
                            "Objects look firmly seated on the floor."
                        ),
                        criteria = "Complete 14 cast-shadow projection exercises.",
                        diagramType = DiagramType.CAST_SHADOW_LOGIC,
                        primarySkillId = "sk_cast_shadow"
                    ),
                    LessonSpec(
                        id = "w4_u3_l2",
                        title = "Ambient Occlusion & Contact Darks",
                        subtitle = "Deep crevice darks where light cannot bounce",
                        objective = "Place razor-crisp Value #9 occlusion accents strictly in tight contact seams, under-lips, and deep creases.",
                        explanation = "Even in a bright room, light rays struggle to bounce into the hair-thin crevice where a cup bottom touches a table or two books press together. That razor-thin dark accent is Ambient Occlusion—the ultimate anchor of realism.",
                        whyItMatters = "A 2-millimeter occlusion accent instantly welds floating objects down onto tabletops and gives folds crisp depth.",
                        materials = listOf("HB, 2B, 4B pencils (sharpened fine)", "Sketchbook"),
                        steps = listOf(
                            "Render a cup resting on a saucer or stacked books with mid-dark cast shadows (#6–#7).",
                            "Sharpen your 4B pencil and tuck a crisp Value #9 line right inside the contact pinch—tapering it cleanly away as the gap opens.",
                            "Avoid putting thick dark occlusion lines where surfaces aren't actually touching!"
                        ),
                        ex1Title = "Contact Pinch & Book Stack",
                        ex1Desc = "Draw 3 stacked books and 2 nested bowls. Render soft shadows first, then apply sharp Value #9 occlusion lines purely in the deepest contact crevices.",
                        ex1Reps = "3 stacked contact studies",
                        ex1Min = 12,
                        ex2Title = "Occlusion vs. Outline Audit",
                        ex2Desc = "Draw 4 overlapping pebbles on a flat floor. Keep outer skyward edges outline-free and use dark #9 occlusion strictly underneath where pebbles touch stone.",
                        ex2Reps = "4 pebble contact studies",
                        ex2Min = 9,
                        ex3Title = "Cast Shadow Falloff Gradient",
                        ex3Desc = "Shade 3 cast shadows starting #8.5 right under the object's foot, softening out to #6 near the far tip as ambient bounce light fills in.",
                        ex3Reps = "3 graded cast shadows",
                        ex3Min = 7,
                        challengeTitle = "Coin Pile or Key Ring Occlusion",
                        challengeDesc = "Scatter 5 overlapping coins or keys on white paper under a lamp; capture their razor-sharp contact darks and gentle outward shadow halos.",
                        challengeReps = "1 overlapping coin/key plate",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Extending heavy #9 black along the entire outer edge of the cast shadow" to "Keep the darkest #9 accent strictly inside the tight contact pinch.",
                            "Drawing uniform flat-black cast shadows" to "Let cast shadows lighten slightly and soften as distance from the object increases."
                        ),
                        checklist = listOf(
                            "Value #9 darks appear strictly inside tight contact crevices.",
                            "Cast shadows lighten gradually away from the contact point.",
                            "Objects feel physically heavy on the surface."
                        ),
                        criteria = "Complete 10 occlusion and cast-shadow gradient studies.",
                        diagramType = DiagramType.CAST_SHADOW_LOGIC,
                        primarySkillId = "sk_cast_shadow"
                    ),
                    LessonSpec(
                        id = "w4_u3_l3",
                        title = "Edge Control: Sharp, Firm & Lost Edges",
                        subtitle = "How shadow edges shift from crisp to soft",
                        objective = "Modulate edge sharpness intentionally across cast shadows, form shadows, and light transitions.",
                        explanation = "Amateur drawings have one identical razor-sharp edge everywhere. In nature, **cast shadows** start crisp near the casting object and blur softly farther away; **form shadow** terminators are soft on gentle spheres and firm on sharp corners; **lost edges** occur where dark shadow meets dark background.",
                        whyItMatters = "Edge variety creates luminous atmosphere, focal hierarchy, and photographic depth in charcoal and graphite.",
                        materials = listOf("HB, 2B, 4B pencils", "Kneaded eraser", "Tissue or blending stump (optional, lightly)"),
                        steps = listOf(
                            "Draw a sphere and a cube side by side under one soft-diffused desk light.",
                            "Keep the cast shadow edge crisp within 1 cm of the base, then gradually feather it soft toward its tip.",
                            "Make the sphere's terminator soft and velvety while keeping the cube's sunlit corner crisp.",
                            "Allow one small shadow edge to melt seamlessly into a shaded background (a 'lost edge')."
                        ),
                        ex1Title = "4-Edge Vocabulary Swatch",
                        ex1Desc = "Rule 4 boxes and practice rendering: (1) Razor Sharp edge, (2) Firm painted edge, (3) Soft velvety rolled edge, and (4) Lost dissolved edge.",
                        ex1Reps = "4 distinct edge-transition swatches",
                        ex1Min = 9,
                        ex2Title = "Soft-Fade Cast Shadow Cylinder",
                        ex2Desc = "Draw 2 upright cylinders casting long shadows; render crisp base edges dissolving gradually into misty soft tips.",
                        ex2Reps = "2 soft-fade cylinder studies",
                        ex2Min = 10,
                        ex3Title = "Lost-Edge Dark Sphere",
                        ex3Desc = "Shade a sphere against a dark #7 background on its shadow side so the dark rim intentionally disappears ('lost edge') while the lit rim pops crisply.",
                        ex3Reps = "2 lost-edge chiaroscuro spheres",
                        ex3Min = 10,
                        challengeTitle = "Diffused Window Light Mug",
                        challengeDesc = "Place a mug near a curtained window (soft light). Render the gentle wrap of the core shadow and soft feathery cast shadow edge.",
                        challengeReps = "1 soft-light still life study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Outlining a soft cast shadow before shading it" to "Shade cast shadows smoothly without drawing a hard dark perimeter fence around them.",
                            "Over-blending everything soft with a tissue" to "Keep at least 30% of focal edges crisp or firm so the drawing doesn't look blurry."
                        ),
                        checklist = listOf(
                            "Cast shadows soften noticeably farther from the casting object.",
                            "Rounded form terminators feel softer than sharp corner breaks.",
                            "Lost edges dissolve naturally without jarring outline fences."
                        ),
                        criteria = "Complete 8 edge-control swatches and chiaroscuro form studies.",
                        diagramType = DiagramType.CAST_SHADOW_LOGIC,
                        primarySkillId = "sk_edge_control",
                        reinforcedSkillIds = listOf("sk_cast_shadow")
                    )
                )
            ),
            buildUnit(
                4, 4, "w4_u4", "Multi-Object Light & Value Synthesis",
                "Harmonize value keys, reflected bounce, cast shadows, and edge variety across multi-form scenes.",
                listOf(
                    LessonSpec(
                        id = "w4_u4_l1",
                        title = "Local Value vs. Lighting Value",
                        subtitle = "Shading dark objects in light vs. white objects in shadow",
                        objective = "Keep a white object's shadow distinguishable from a dark object's sunlit face using relative value scales.",
                        explanation = "If you draw a white egg beside a black mug, the black mug's sunlit side might still be Value #6 while the white egg's shadow is Value #5! Separating *local color/value* (how dark the material is) from *light/shadow* prevents dark objects from turning white and white objects from turning soot-gray.",
                        whyItMatters = "Essential for believable still lifes, skin tones next to dark hair, and monochrome environment depth.",
                        materials = listOf("2H, HB, 2B, 4B, 6B pencils", "White object + dark matte object", "Sketchbook"),
                        steps = listOf(
                            "Place a white cup next to a dark matte book or black mug under one lamp.",
                            "Before shading, rank the 4 key zones from brightest to darkest: (1) White Lit, (2) White Shadow, (3) Black Lit, (4) Black Shadow.",
                            "Honor that hierarchy strictly throughout rendering."
                        ),
                        ex1Title = "White Egg vs. Dark Bottle Pair",
                        ex1Desc = "Set up a light-colored object beside a dark-colored object. Assign distinct 2-value families to both and render cleanly.",
                        ex1Reps = "2 light-vs-dark material pairs",
                        ex1Min = 14,
                        ex2Title = "Checkerboard Sphere & Cube",
                        ex2Desc = "Draw a simple cube with a dark stripe painted across one lit face—ensure the dark stripe stays darker in light than the white plane in shadow!",
                        ex2Reps = "2 patterned-value studies",
                        ex2Min = 9,
                        ex3Title = "Value Spot-Check Margin Strips",
                        ex3Desc = "Keep a small scrap of paper beside your drawing to test pencil value steps before committing dark local values.",
                        ex3Reps = "1 calibrated dual-object sheet",
                        ex3Min = 7,
                        challengeTitle = "Chess Pawn Pair (White & Black Pieces)",
                        challengeDesc = "Arrange a light wood/white object and dark espresso/black piece side by side under directional light and render full 5-zone lighting on both.",
                        challengeReps = "1 contrasting chess-style plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Making the shadow on a white object as dark as the shadow on a black object" to "Keep white shadows noticeably lighter (#4.5–#6) than black shadows (#8–#9).",
                            "Over-highlighting a matte black object white" to "Keep matte black lit planes around #5–#6, reserving #1 only for tiny glossy specular glints."
                        ),
                        checklist = listOf(
                            "The light object clearly reads as light material even on its shadow side.",
                            "The dark object retains its dark identity even under direct lamp light.",
                            "The overall 4-step tonal hierarchy stays consistent."
                        ),
                        criteria = "Complete 5 local-value contrast studies cleanly.",
                        diagramType = DiagramType.VALUE_SCALE_AND_SPHERE,
                        primarySkillId = "sk_form_shadow",
                        reinforcedSkillIds = listOf("sk_value_scale")
                    ),
                    LessonSpec(
                        id = "w4_u4_l2",
                        title = "Subtle Shading Without Smearing",
                        subtitle = "Pure graphite layering & kneaded eraser lifting",
                        objective = "Build luminous, velvety graphite shading strictly through controlled pencil layering and subtractive eraser lifting.",
                        explanation = "Using a pointed HB/2B/4B at a gentle 20° slant lays tiny overlapping grains of graphite into paper valleys cleanly, preserving luminosity. A pinched kneaded eraser becomes a 'reverse pencil' for lifting delicate reflected light and soft highlights.",
                        whyItMatters = "Elevates shading from smeared gray mud into crisp, luminous classical draftsmanship.",
                        materials = listOf("2H, HB, 2B, 4B pencils (well-sharpened)", "Kneaded eraser", "Drawing pad"),
                        steps = listOf(
                            "Lay Pass 1 lightly across the entire shadow with a sharp 2H/HB using tight oval strokes.",
                            "Deepen core shadows gradually with HB → 2B → 4B, keeping pencil tip slanted at ~20°.",
                            "Pinch your kneaded eraser into a fine wedge to softly dab or lift over-darkened halftones or crisp highlight edges."
                        ),
                        ex1Title = "3-Layer Velvety Sphere",
                        ex1Desc = "Render a 7 cm sphere using zero finger/tissue smudging—build silky smooth transitions strictly by layering 2H, HB, 2B, and 4B light passes.",
                        ex1Reps = "2 pure-pencil layered spheres",
                        ex1Min = 15,
                        ex2Title = "Subtractive Eraser Highlight Study",
                        ex2Desc = "Tone an entire 8×8 cm square smoothly to Value #5 with HB, then 'draw' a sunlit draped ribbon purely by lifting lights with a kneaded eraser and deepening darks with 2B.",
                        ex2Reps = "2 subtractive charcoal/graphite studies",
                        ex2Min = 12,
                        ex3Title = "Paper-Tooth Respect Check",
                        ex3Desc = "Practice patching tiny pale grain speckles inside a halftone using a sharp needle-point 2H tip ('filling the pores').",
                        ex3Reps = "2 fine-grain refinement swatches",
                        ex3Min = 6,
                        challengeTitle = "Toned-Paper Dramatic Apple",
                        challengeDesc = "Lay an even #4 graphite tone across a 10×10 cm frame first, then sculpt a realistic apple using subtractive eraser lights and additive 4B darks.",
                        challengeReps = "1 reductive value plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Gouging the paper with a dull hard pencil" to "Keep strokes feather-light and step up to softer 2B/4B leads for darker values.",
                            "Rubbing the kneaded eraser across paper and smearing" to "Dab/tap or lift gently in one direction, kneading clean between touches."
                        ),
                        checklist = listOf(
                            "Transitions appear silky and luminous without greasy finger smears.",
                            "Paper surface remained un-bruised and matte even in deep shadows.",
                            "Kneaded eraser lifts created soft highlights cleanly."
                        ),
                        criteria = "Complete 6 pure-pencil and reductive value studies.",
                        diagramType = DiagramType.VALUE_SCALE_AND_SPHERE,
                        primarySkillId = "sk_edge_control",
                        reinforcedSkillIds = listOf("sk_value_scale")
                    ),
                    LessonSpec(
                        id = "w4_u4_l3",
                        title = "Complete Monochrome Value Plate",
                        subtitle = "Uniting construction, light logic, and edge hierarchy",
                        objective = "Execute a cohesive 3-primitive value composition from light construction through final occlusion and edge polishing.",
                        explanation = "This synthesis lesson unites World 4's entire lighting system: clean construction → 2-value shadow mapping → 5-zone form modeling → ray-checked cast shadows → occlusion darks → varied edge refinement.",
                        whyItMatters = "Proves you can control light believably from scratch—preparing you directly for Perspective (World 5) and Still Life (World 6).",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "A4 drawing paper", "Desk lamp + 2–3 matte primitives/fruit"),
                        steps = listOf(
                            "Set up 2–3 simple real items (apple, matte cup, folded paper box) under one lamp.",
                            "Construct forms lightly in 2H and map the crisp 2-value terminator + cast shadow boundaries.",
                            "Step into full 5-zone modeling, maintaining local value differences and soft/crisp edge variety.",
                            "Finish with subtle background atmosphere and razor-clean Value #9 contact occlusions."
                        ),
                        ex1Title = "Tonal Thumbnail & Light Map",
                        ex1Desc = "Before drawing large, sketch a 5×6 cm 3-value thumbnail verifying light-vs-shadow design and cast shadow angles.",
                        ex1Reps = "2 value thumbnails",
                        ex1Min = 6,
                        ex2Title = "Full Shadow-Family Block-In",
                        ex2Desc = "Transfer the construction lightly onto a main sheet and fill all form + cast shadows flat at Value #6 as one united shape.",
                        ex2Reps = "1 unified block-in stage",
                        ex2Min = 9,
                        ex3Title = "Modeling, Halftones & Edge Polish",
                        ex3Desc = "Model core shadows, reflected bounce, crisp vs. soft cast shadow edges, and #9 contact occlusion accents cleanly.",
                        ex3Reps = "1 finished rendered plate",
                        ex3Min = 15,
                        challengeTitle = "Dramatic Low-Light Chiaroscuro Version",
                        challengeDesc = "Lower the lamp close to table level and execute a second 15-minute moody low-key study with elongated cast shadows.",
                        challengeReps = "1 dramatic chiaroscuro study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Jumping straight to polished halftones before locking down the shadow family" to "Finish 100% of the flat shadow map before turning any halftones.",
                            "Losing core shadow contrast while blending" to "Re-establish core shadows and #9 occlusions as your final accent pass."
                        ),
                        checklist = listOf(
                            "Light direction is crystal clear across every object and cast shadow.",
                            "All 5 zones of light appear cleanly without over-bright reflected light.",
                            "Edge hierarchy contrasts crisp corners/occlusions against soft cast tips."
                        ),
                        criteria = "Complete the 3-stage value workflow cleanly to unlock World 4's Milestone Project.",
                        diagramType = DiagramType.CAST_SHADOW_LOGIC,
                        primarySkillId = "sk_edge_control",
                        reinforcedSkillIds = listOf("sk_value_scale", "sk_form_shadow", "sk_cast_shadow")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w4",
            worldNumber = 4,
            title = "Three-Primitive Single-Light Value Study",
            brief = "Arrange 3 matte forms of varying local values (e.g., white egg/ball, mid-tone cardboard box, dark ceramic/wooden cup) under one strong directional lamp and render a complete, outline-free monochrome value study showcasing all 5 zones of light, cast shadows, occlusion, and varied edges.",
            combinedSkills = listOf("Controlled Value Scales", "Terminator & Form Shadow", "Cast Shadow Projection", "Lost & Found Edges"),
            requiredMaterials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "A4 drawing paper", "Single directional desk lamp"),
            phases = listOf(
                "Phase 1 (5 min): Paint a quick 5×6 cm 3-value thumbnail to lock composition and shadow pattern.",
                "Phase 2 (7 min): Construct accurate 2H forms and cast-shadow footprint rays on the main sheet.",
                "Phase 3 (8 min): Fill the unified shadow family at Value #6 and establish local value hierarchy.",
                "Phase 4 (15 min): Sculpt core shadows, halftones, subtle background counterchange, varied cast-shadow edges, and #9 contact occlusions."
            ),
            selfAssessmentChecklist = listOf(
                "Zero hard dark outlines remain around sunlit rims.",
                "Light family and shadow family never overlap awkwardly in value.",
                "Reflected light remains darker than lit halftones.",
                "Cast shadows soften away from the base and lock down with #9 contact darks."
            ),
            estimatedMinutes = 35,
            xpReward = 165
        )
    ),

    // WORLD 5: PERSPECTIVE
    DrawingWorld(
        number = 5,
        id = "world_5",
        title = "Perspective",
        tagline = "Construct believable 3D space, depth, and architectural scale on flat paper",
        focusSummary = "Master horizon lines, 1-point, 2-point, and 3-point perspective, perspective division/multiplication, and foreshortened ellipses.",
        unlockRequirementSummary = "Complete World 4 Milestone & reach Practicing in Light & Shadow skills",
        units = listOf(
            buildUnit(
                5, 1, "w5_u1", "Horizon Line & One-Point Perspective",
                "Anchor eye level and build crisp 1-point interiors, corridors, and receding boxes.",
                listOf(
                    LessonSpec(
                        id = "w5_u1_l1",
                        title = "Eye Level, Horizon Line & Single Vanishing Point",
                        subtitle = "Why everything converges at your eyes",
                        objective = "Place a Horizon Line accurately and project transparent boxes above, on, and below eye level toward one Vanishing Point (VP).",
                        explanation = "The Horizon Line is literally your eye height! Anything taller than your eyes sits ABOVE the horizon (you see its underside); anything shorter sits BELOW (you see its top). In 1-point perspective, front faces stay flat vertical/horizontal rectangles while all depth edges converge toward one VP.",
                        whyItMatters = "Correct eye-level placement immediately gives rooms, streets, and still-life tabletops believable camera height.",
                        materials = listOf("HB pencil", "Clear ruler (for learning rays, then freehand)", "Sketchbook"),
                        steps = listOf(
                            "Draw a straight horizontal Horizon Line across the middle of the page and mark one VP dot.",
                            "Draw 6 flat squares/rectangles scattered above, across, and below the horizon.",
                            "Connect all 4 corners of each rectangle lightly to the VP, then slice off back vertical and horizontal edges to close 3D boxes."
                        ),
                        ex1Title = "Above / On / Below Eye Level Boxes",
                        ex1Desc = "Plot 9 rectangles (3 above horizon, 3 straddling horizon, 3 below horizon) and project all 9 cleanly to a single VP (drawn transparently!).",
                        ex1Reps = "9 one-point transparent boxes",
                        ex1Min = 12,
                        ex2Title = "Freehand Rough 1-Point Frame",
                        ex2Desc = "Put the ruler away. Draw a Horizon + VP and freehand 8 boxes across the page, then use a ruler ONLY afterward to verify how close your rays aimed to the VP.",
                        ex2Reps = "8 freehand 1-pt boxes + ruler check",
                        ex2Min = 12,
                        ex3Title = "Eye-Level Shift Experiment",
                        ex3Desc = "Draw two identical small room thumbnails: one with a high horizon (standing looking down at furniture) and one with a low horizon (ant's-eye looking up).",
                        ex3Reps = "2 contrasting eye-level thumbnails",
                        ex3Min = 8,
                        challengeTitle = "Floating Staircase & Tunnel",
                        challengeDesc = "Using one VP, draw a hollow square tunnel receding deep into the page with 4 evenly spaced floating doorway frames inside.",
                        challengeReps = "1 receding tunnel plate",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing back edges slanted diagonally instead of strictly horizontal/vertical" to "In true 1-point perspective, ALL front and back faces remain strictly parallel to page edges.",
                            "Seeing both the top AND bottom of a single opaque box simultaneously" to "Boxes above horizon show bottoms only; below horizon show tops only; straddling horizon show neither."
                        ),
                        checklist = listOf(
                            "All depth lines aim cleanly toward the single Vanishing Point.",
                            "Vertical and horizontal face edges stay parallel to the page borders.",
                            "Top vs. bottom visibility matches each box's position relative to the horizon."
                        ),
                        criteria = "Complete 17 one-point transparent boxes and 2 eye-level thumbnails.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_1pt_persp"
                    ),
                    LessonSpec(
                        id = "w5_u1_l2",
                        title = "One-Point Interior Room Box",
                        subtitle = "Constructing walls, doors, windows, and furniture",
                        objective = "Build a cohesive 1-point room interior containing recessed windows, doorway depth, and aligned furniture.",
                        explanation = "An entire room is just the *inside* of a giant 1-point box! Once you place the back wall rectangle and pull 4 corner rays out from the VP, every floorboard, ceiling beam, rug, and bed obeys the exact same vanishing point.",
                        whyItMatters = "Unlocks indoor storytelling scenes, cozy bedroom studies, and architectural interiors.",
                        materials = listOf("2H & HB pencils", "Ruler + freehand cleanup", "Sketchbook"),
                        steps = listOf(
                            "Draw a room frame and place a smaller back wall rectangle inside it; place VP slightly off-center for natural interest.",
                            "Pull rays from VP through all 4 corners of the back wall to form ceiling, floor, and side walls.",
                            "Construct a bed/table box seated squarely on the floor footprint, plus a recessed window showing wall thickness."
                        ),
                        ex1Title = "Empty Room Grid & Wall Thickness",
                        ex1Desc = "Build a 1-point room shell with a floor tile grid, one recessed doorway showing wall thickness, and one framed window.",
                        ex1Reps = "1 complete room shell",
                        ex1Min = 12,
                        ex2Title = "Furnished Room Box Assembly",
                        ex2Desc = "Populate the room shell with a desk, bed/sofa, bookshelf, and rug—drawing floor footprints first so nothing overlaps awkwardly.",
                        ex2Reps = "1 furnished 1-pt interior",
                        ex2Min = 15,
                        ex3Title = "Standing Scale Figure Check",
                        ex3Desc = "Remember: any person standing on the flat floor whose eyes are the same height as yours has their eyes right ON the Horizon Line! Place 3 scale silhouettes in the room.",
                        ex3Reps = "3 horizon-anchored scale figures",
                        ex3Min = 6,
                        challengeTitle = "Library Hallway With Arches",
                        challengeDesc = "Construct a receding hallway lined with tall bookcases and ceiling beams converging cleanly toward an off-center VP.",
                        challengeReps = "1 corridor perspective plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Paper-thin flat windows with no wall depth" to "Add the visible inner thickness sill pointing toward the VP on the far side of window/door cutouts.",
                            "Furniture floating off the floor" to "Always draw the rectangular footprint on the floor tiles BEFORE raising vertical legs/walls."
                        ),
                        checklist = listOf(
                            "Floor footprints were plotted before extruding furniture vertically.",
                            "Doorways and windows show realistic wall thickness.",
                            "Scale figures standing at different depths keep their eye-line on the horizon."
                        ),
                        criteria = "Complete 1 room shell, 1 furnished interior, and scale-figure depth checks.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_1pt_persp"
                    ),
                    LessonSpec(
                        id = "w5_u1_l3",
                        title = "One-Point Street & Atmospheric Scale",
                        subtitle = "Diminishing size toward the vanishing point",
                        objective = "Construct receding street blocks, utility poles, and sidewalks scaling accurately into depth.",
                        explanation = "Objects of equal real height (streetlamps, fence posts, doorway heights) shrink smoothly inside two converging lines pointing toward the VP—creating effortless spatial scale.",
                        whyItMatters = "Teaches you how to populate exterior streets, alleys, and train tracks convincingly.",
                        materials = listOf("2H & HB pencils", "Ruler", "Sketchbook"),
                        steps = listOf(
                            "Place a low-middle Horizon Line and slightly off-center VP.",
                            "Draw converging sidewalk curbs and building roofline rays.",
                            "Draw a tall foreground lamppost, then connect its top and bottom to the VP so every distant post shrinks accurately inside that wedge."
                        ),
                        ex1Title = "Converging Fence & Lamp Row",
                        ex1Desc = "Construct a road with curb, sidewalk, and a row of 6 receding lampposts/trees shrinking cleanly inside VP guidelines.",
                        ex1Reps = "2 receding street-row exercises",
                        ex1Min = 10,
                        ex2Title = "Varied-Height City Block",
                        ex2Desc = "Build 4 adjacent storefronts/buildings of different heights along one street side, showing protruding awnings and recessed shop doors.",
                        ex2Reps = "1 multi-building 1-pt street",
                        ex2Min = 14,
                        ex3Title = "Line-Weight Depth Fade",
                        ex3Desc = "Trace over your street drawing using crisp 2B weight in the foreground and whisper-thin 2H in the far distance.",
                        ex3Reps = "1 depth-weighted cleanup",
                        ex3Min = 6,
                        challengeTitle = "Train Platform & Overhead Roof",
                        challengeDesc = "Construct a train station platform receding in 1-point perspective with tiled edge, benches, and sloped overhang pillars.",
                        challengeReps = "1 station platform study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Keeping distant lamp posts spaced evenly in ruler centimeters" to "Remember: equal 3D spacing compresses tighter and tighter visually as objects approach the VP!",
                            "Tilting vertical walls slightly inward by accident" to "Check vertical building edges frequently against your page side edge."
                        ),
                        checklist = listOf(
                            "Repeating posts/trees shrink smoothly along VP top/bottom rails.",
                            "Spacing between distant posts compresses tighter toward the VP.",
                            "Vertical edges remain strictly perpendicular to the horizon."
                        ),
                        criteria = "Complete 3 receding street/row compositions with accurate depth scaling.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_1pt_persp"
                    )
                )
            ),
            buildUnit(
                5, 2, "w5_u2", "Two-Point Perspective & Rotation",
                "Rotate boxes, buildings, and objects naturally using dual vanishing points without awkward fish-eye distortion.",
                listOf(
                    LessonSpec(
                        id = "w5_u2_l1",
                        title = "Two-Point Box Mastery & Cone of Vision",
                        subtitle = "Avoiding wide-angle fish-eye warping",
                        objective = "Construct undistorted 2-point boxes with vertical edges perpendicular to the horizon and dual VPs spaced wide apart.",
                        explanation = "When you turn a box so a corner faces you, left-going edges head to Left VP and right-going edges head to Right VP. CRITICAL RULE: Keep both VPs wide apart (often off the edges of your drawing paper!)—placing VPs too close together inside a tiny box causes ugly sharp diamond distortion.",
                        whyItMatters = "2-point perspective is the default view of real life—almost nothing we look at sits dead-flat square to our chest.",
                        materials = listOf("2H & HB pencils", "Long ruler or wide desk space", "Sketchbook"),
                        steps = listOf(
                            "Draw a long Horizon Line and place VP1 and VP2 near the very far outer margins (or tape scrap tabs on the desk to extend off-page!).",
                            "Draw a vertical front edge line anywhere between VP1 and VP2.",
                            "Connect top and bottom of that edge to VP1 and VP2, slice left and right verticals, and close back corners transparently."
                        ),
                        ex1Title = "Wide-VP vs. Narrow-VP Comparison",
                        ex1Desc = "Draw 1 box with VPs very close together (notice the sharp distorted front corner!) and 4 boxes with VPs pushed far to outer paper edges for natural realism.",
                        ex1Reps = "5 diagnostic 2-pt boxes",
                        ex1Min = 10,
                        ex2Title = "10 Freehand Two-Point Boxes",
                        ex2Desc = "Draw a horizon with VPs at page corners, then construct 10 boxes of varied sizes above, across, and below the horizon freely.",
                        ex2Reps = "10 varied 2-pt boxes",
                        ex2Min = 14,
                        ex3Title = "25-Box Challenge Starter Batch",
                        ex3Desc = "On a clean page, draw 12 rotated freehand boxes (no ruler!) varying rotations, then ruler-extend every edge family in pencil/color to audit convergence.",
                        ex3Reps = "12 audited freehand boxes",
                        ex3Min = 12,
                        challengeTitle = "Rotated Box Circle (Organic Perspective Wheel)",
                        challengeDesc = "Draw a box rotating in 15° increments along a single horizon line (shifting VPs left and right as the box turns!).",
                        challengeReps = "5-step horizon rotation strip",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Front corner angle sharper than 90° (fish-eye distortion)" to "Push VP1 and VP2 farther apart—if a VP sits off the paper, estimate its distant convergence gently.",
                            "Drawing rotated boxes with identical VPs even when they face different directions" to "Remember: each independently rotated object has its OWN pair of VPs along the shared horizon!"
                        ),
                        checklist = listOf(
                            "Vertical edges stayed strictly upright without leaning.",
                            "Boxes near the center stay free of sharp diamond distortion.",
                            "I drew through all 12 edges cleanly on every box."
                        ),
                        criteria = "Complete 27 two-point boxes including convergence extension audits.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_2pt_persp",
                        reinforcedSkillIds = listOf("sk_cubes")
                    ),
                    LessonSpec(
                        id = "w5_u2_l2",
                        title = "Rotating Independent Objects on One Floor",
                        subtitle = "Multiple VP pairs on a shared horizon",
                        objective = "Place multiple objects rotated at different angles on the same floor plane by sliding VP pairs along one shared Horizon Line.",
                        explanation = "Beginner misconception: 'Every object in a 2-point drawing uses the same two VPs.' Wrong! Only parallel objects (like walls of the same house) share VPs. A chair turned 30° from the table gets its OWN pair of VPs sliding along the SAME horizontal eye-level line!",
                        whyItMatters = "Makes rooms, cluttered desks, and street scenes look lived-in and organic instead of rigidly aligned like grids.",
                        materials = listOf("2H & HB pencils", "Ruler", "Sketchbook"),
                        steps = listOf(
                            "Draw one shared Horizon Line.",
                            "Construct a large table box using VP1 & VP2.",
                            "To place a turned book or chair next to it, slide Left VP inward and push Right VP outward along the same horizon line, then build the second box."
                        ),
                        ex1Title = "Scattered Wooden Blocks Scene",
                        ex1Desc = "Draw 5 wooden blocks resting on one flat floor at 5 completely different rotation angles by shifting VP pairs along one shared Horizon Line.",
                        ex1Reps = "5 rotated blocks on 1 floor",
                        ex1Min = 14,
                        ex2Title = "Turned Chair Next to Desk",
                        ex2Desc = "Construct a neat rectangular desk (VP1/VP2), then tuck a simple boxy chair angled 25° outward from it using shifted VPs on the same horizon.",
                        ex2Reps = "2 desk-and-chair spatial layouts",
                        ex2Min = 12,
                        ex3Title = "Tilted Ramp / Open Laptop Wedge",
                        ex3Desc = "Draw a flat laptop base to VP1/VP2, then tilt its screen lid upward toward a vertical auxiliary VP directly above VP1!",
                        ex3Reps = "3 angled lid/ramp constructions",
                        ex3Min = 8,
                        challengeTitle = "3-Box Piled Corner Market Crate",
                        challengeDesc = "Stack 3 crates: bottom crate straight, middle crate twisted 20°, top crate resting askew with one corner tilted up on a wedge.",
                        challengeReps = "1 twisted crate pile",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Moving the Horizon Line height up or down for rotated flat objects" to "All flat-grounded objects share the EXACT same horizontal eye-level line—only their VPs slide left/right!",
                            "Letting turned boxes clip into the same space" to "Plot floor footprints clearly first so corners never collide."
                        ),
                        checklist = listOf(
                            "Every flat object converges to points lying on the same single Horizon Line.",
                            "Shifted VP pairs make objects look genuinely angled relative to one another.",
                            "Floor footprints do not overlap unrealistically."
                        ),
                        criteria = "Complete 10 independently rotated objects sharing one consistent ground plane.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_2pt_persp"
                    ),
                    LessonSpec(
                        id = "w5_u2_l3",
                        title = "Two-Point Architectural Exterior",
                        subtitle = "Corners, eaves, pitched roofs, and street depth",
                        objective = "Construct a crisp 2-point corner building with pitched gable roof, overhanging eaves, and recessed windows.",
                        explanation = "Combining 2-point boxes with X-diagonal roof peaks (from World 2!) lets you build realistic architectural corners cleanly. Adding overhanging roof eaves and recessed window jambs immediately elevates boxes into real structures.",
                        whyItMatters = "Provides the exact structural toolkit for World 11 architectural environments.",
                        materials = listOf("2H & HB pencils", "Ruler", "Sketchbook"),
                        steps = listOf(
                            "Draw a main 2-point building mass sitting across a low horizon line.",
                            "Find the gable end face's perspective center using an X-diagonal, raise a vertical centerline peak, and connect roof slopes.",
                            "Extend roof eaves slightly past the walls and step window cutouts inward along VP rays."
                        ),
                        ex1Title = "Gable Cottage Construction",
                        ex1Desc = "Build a corner cottage with pitched gable roof, overhanging eaves, chimney box, and porch step using strict 2-point geometry.",
                        ex1Reps = "1 complete 2-pt cottage",
                        ex1Min = 15,
                        ex2Title = "Recessed Storefront Windows",
                        ex2Desc = "Draw a 2-story corner block and carve 4 recessed window alcoves and an inset corner entry doorway showing true masonry depth.",
                        ex2Reps = "1 recessed facade study",
                        ex2Min = 12,
                        ex3Title = "Stairway Porch Addition",
                        ex3Desc = "Attach 3 perspective porch steps rising cleanly to the front entry using parallel VP lines.",
                        ex3Reps = "2 stepped porch additions",
                        ex3Min = 8,
                        challengeTitle = "Corner Bookstore With Awning & Sidewalk",
                        challengeDesc = "Expand your 2-point corner building onto a street corner with curved sidewalk curb, sloped shop awning, and distant neighboring block.",
                        challengeReps = "1 full corner street plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Vertical roof ridge line leaning crookedly" to "Keep the roof ridge converging cleanly to the second VP, and keep the gable peak plumb directly above the X-intersection.",
                            "Windows stuck flat like stickers" to "Show the inner shaded sill and jamb thickness on the far side of each opening."
                        ),
                        checklist = listOf(
                            "Gable roof peak sits vertically above the perspective X-center.",
                            "Roof eaves overhang cleanly past wall corners.",
                            "Windows and doors reveal authentic structural depth."
                        ),
                        criteria = "Complete 1 gable cottage, 1 recessed corner facade, and 2 stepped porches.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_2pt_persp",
                        reinforcedSkillIds = listOf("sk_persp_div")
                    )
                )
            ),
            buildUnit(
                5, 3, "w5_u3", "Three-Point Perspective & Subdivision",
                "Add dramatic vertical convergence for towering/plunging views and master exact perspective spacing and mirroring.",
                listOf(
                    LessonSpec(
                        id = "w5_u3_l1",
                        title = "Three-Point Perspective (Looking Up & Down)",
                        subtitle = "Adding the 3rd Vertical Vanishing Point",
                        objective = "Construct dramatic bird's-eye (high above) and worm's-eye (looking up) scenes with a 3rd vertical VP.",
                        explanation = "When you tilt your head sharply UP at a skyscraper or DOWN off a balcony, vertical walls no longer stay parallel—they taper toward a 3rd Vanishing Point high in the sky (worm's-eye) or deep below the ground (bird's-eye)!",
                        whyItMatters = "Creates breathtaking cinematic scale for tall architecture, deep canyons, and dynamic superhero/portrait angles.",
                        materials = listOf("2H & HB pencils", "Long straightedge or tape", "Sketchbook"),
                        steps = listOf(
                            "For Worm's-Eye: place Horizon Line VERY LOW near page bottom with VP1/VP2 wide, and place VP3 far ABOVE the top center.",
                            "For Bird's-Eye: place Horizon Line VERY HIGH near page top, and place VP3 far BELOW the bottom center.",
                            "Send all 'vertical' building corners cleanly toward VP3."
                        ),
                        ex1Title = "Worm's-Eye Skyscraper Trio",
                        ex1Desc = "Place Horizon near the bottom edge and VP3 high above. Draw 3 towering buildings converging sharply skyward.",
                        ex1Reps = "1 worm's-eye 3-tower study",
                        ex1Min = 13,
                        ex2Title = "Bird's-Eye Rooftop Plunge",
                        ex2Desc = "Place Horizon near the top edge and VP3 below the bottom. Look down over 4 staggered city blocks with rooftop AC units.",
                        ex2Reps = "1 bird's-eye city plunge",
                        ex2Min = 13,
                        ex3Title = "Subtle 3-Point Tabletop Cup",
                        ex3Desc = "Draw a single large coffee mug seen from a close standing angle—apply subtle downward taper toward a distant VP3 far below the page.",
                        ex3Reps = "2 subtle 3-pt everyday objects",
                        ex3Min = 8,
                        challengeTitle = "Dramatic Stairwell Looking Down",
                        challengeDesc = "Use a deep downward VP3 to draw a spiral/square stairwell plunging 3 floors downward.",
                        challengeReps = "1 plunging stairwell plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Making VP3 too close to the horizon so towers pinch into sharp needle pyramids" to "Place VP3 well outside (or at the very far margin of) your main drawing area for believable lens feel.",
                            "Forgetting to send window sides toward VP3 too" to "Every single vertical edge on every window and door MUST point toward VP3."
                        ),
                        checklist = listOf(
                            "Vertical walls converge smoothly toward VP3 without sharp needle distortion.",
                            "Horizon placement matches looking-up vs. looking-down camera pitch.",
                            "Secondary details (windows/doors) obey VP3 as well."
                        ),
                        criteria = "Complete worm's-eye, bird's-eye, and subtle 3-point object studies.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_3pt_persp"
                    ),
                    LessonSpec(
                        id = "w5_u3_l2",
                        title = "Perspective Division & Multiplication (X-Method)",
                        subtitle = "Equal fence posts, tiles, and mirrored symmetry",
                        objective = "Space repeating vertical intervals evenly and mirror shapes symmetrically across centerlines in perspective.",
                        explanation = "How do you draw evenly spaced windows or train ties receding into perspective? Using Scott Robertson's X-Method & Half-Step Multiplication: draw a rectangle, find its center with an X, draw a horizontal midline, then shoot a ray from the top-left corner through the right-side midpoint down to the bottom rail—giving the EXACT next equal interval!",
                        whyItMatters = "Makes architectural windows, checkerboard floors, car wheelbases, and mirrored wings look engineered rather than guessed.",
                        materials = listOf("2H & HB pencils", "Clear ruler", "Sketchbook"),
                        steps = listOf(
                            "Draw a receding perspective wall plane between two VP rails and mark Post 1 and Post 2.",
                            "Cross diagonals to locate the exact perspective middle height on Post 2.",
                            "Shoot a straight line from the top of Post 1 through the midpoint of Post 2 until it hits the bottom VP rail—drop vertical Post 3 right there! Repeat forever."
                        ),
                        ex1Title = "8-Post Receding Fence Rail",
                        ex1Desc = "Set up a receding 2-point plane and multiply 1 interval out to 8 mathematically accurate receding posts using the diagonal-through-midpoint trick.",
                        ex1Reps = "2 eight-post multiplied fences",
                        ex1Min = 12,
                        ex2Title = "Checkerboard Floor Matrix",
                        ex2Desc = "Draw a large square horizontal plane in 1-pt or 2-pt, subdivide by X-halves into a 4×4 floor grid, and shade alternating tiles cleanly.",
                        ex2Reps = "2 perspective 4×4 checkerboards",
                        ex2Min = 12,
                        ex3Title = "Mirroring Curves Across Centerline",
                        ex3Desc = "Draw a curved wing/hood curve on the left half of a perspective ground plane, use X-extension guidelines to project 4 key curve points across to the right side cleanly.",
                        ex3Reps = "2 mirrored symmetrical curves",
                        ex3Min = 8,
                        challengeTitle = "Receding Arched Arcade Colonnade",
                        challengeDesc = "Multiply 5 equal bays in perspective, then construct semi-circular arches cleanly inside each bay using 3-point arch guides.",
                        challengeReps = "1 five-bay arched colonnade",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Shooting the multiplication line through the top instead of the exact midpoint" to "Find the true center using an X across the first bay, then project horizontally to the second post's midpoint.",
                            "Drawing arches asymmetrical on the far side" to "Always locate the arch apex directly above the perspective X-center of each bay."
                        ),
                        checklist = listOf(
                            "Multiplied intervals visibly compress naturally toward the VP.",
                            "4×4 checkerboard tiles align cleanly at diagonal intersections.",
                            "Mirrored curves retain true bilateral symmetry in foreshortened space."
                        ),
                        criteria = "Complete 6 perspective multiplication, grid, and symmetry mirroring exercises.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_persp_div"
                    ),
                    LessonSpec(
                        id = "w5_u3_l3",
                        title = "Ellipses & Wheels in Perspective Boxes",
                        subtitle = "Connecting square planes to true perspective circles",
                        objective = "Inscribe accurate ellipses inside perspective squares and extrude them into wheels, arches, and cylinders.",
                        explanation = "In perspective, a circle inside a square plane touches all 4 perspective midpoints AND its true minor axis aims perpendicularly to the axle VP! Building wheels inside perspective square boxes prevents flat, wobbly, misaligned car tires.",
                        whyItMatters = "Essential for vehicles, mechanical joints, clocks on angled walls, architectural arches, and circular tabletops.",
                        materials = listOf("2H & HB pencils", "Ruler + freehand ellipse passes", "Sketchbook"),
                        steps = listOf(
                            "Draw a vertical perspective square (plane) converging to VP1.",
                            "Draw an X and horizontal/vertical midlines to find the 4 tangent points where the circle touches the square.",
                            "Locate the perpendicular axle line heading to VP2—this is your ellipse's Minor Axis!",
                            "Ghost and draw a smooth symmetrical ellipse around that Minor Axis touching all 4 midpoints."
                        ),
                        ex1Title = "Wall-Mounted Clocks in Perspective",
                        ex1Desc = "Construct 4 angled wall squares in 2-point perspective (2 left-facing, 2 right-facing) and fit clean axle-aligned ellipses inside each.",
                        ex1Reps = "4 perspective wall circles",
                        ex1Min = 12,
                        ex2Title = "Extruded Wheel & Tire Pair",
                        ex2Desc = "Extrude two perspective circles outward along their axle VP to build thick car wheels with inner hubcap ellipses.",
                        ex2Reps = "3 extruded 3D wheels",
                        ex2Min = 12,
                        ex3Title = "250-Box Cylinder Check-In",
                        ex3Desc = "Draw 4 thin rectangular perspective boxes and carve clean upright cylinders inside each (like water bottles inside shipping cartons).",
                        ex3Reps = "4 box-enclosed upright cylinders",
                        ex3Min = 8,
                        challengeTitle = "Simple Box-Car With 4 Aligned Wheels",
                        challengeDesc = "Construct a simple boxy vintage sedan body in 2-point perspective and mount 4 aligned wheels sharing Front and Rear axles.",
                        challengeReps = "1 boxy vehicle perspective study",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Making the ellipse's longest tilt vertical when the axle is tilted" to "Remember: the ellipse's Minor Axis MUST point to the axle VP—the Major Axis tilts perpendicular to that axle!",
                            "Forgetting the inner rim depth" to "Offset a second slightly shifted plane along the axle for convincing wheel thickness."
                        ),
                        checklist = listOf(
                            "Ellipses touch all 4 midpoints of their perspective square.",
                            "Every wheel's minor axis aligns with its perpendicular axle line.",
                            "Extruded tire edges stay parallel to the axle direction."
                        ),
                        criteria = "Complete 11 perspective-inscribed circles, wheels, and box-enclosed cylinders.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_persp_div",
                        reinforcedSkillIds = listOf("sk_spheres_cyl", "sk_2pt_persp")
                    )
                )
            ),
            buildUnit(
                5, 4, "w5_u4", "Spatial Mastery & Complex Perspective",
                "Synthesize curves, orthographics, and inclined planes into confident spatial constructions.",
                listOf(
                    LessonSpec(
                        id = "w5_u4_l1",
                        title = "Inclined Planes & Auxiliary Vanishing Points",
                        subtitle = "Stairs, pitched roofs, and open lids accurately",
                        objective = "Construct tilted slopes (ramps, stairs, open doors) converging cleanly to Auxiliary Vanishing Points above/below main VPs.",
                        explanation = "Parallel sloped edges (like both railings of a staircase) still converge—not to the Horizon Line, but to an Auxiliary VP sitting straight vertically ABOVE or BELOW the main VP they rise away from!",
                        whyItMatters = "Makes stairs, car windshields, pitched roofs, and open laptop/chest lids lock cleanly into perspective.",
                        materials = listOf("2H & HB pencils", "Ruler", "Sketchbook"),
                        steps = listOf(
                            "Set up a 2-point Horizon Line with VP1 and VP2.",
                            "Draw a plumb vertical dashed line straight up through VP1 to mark an Auxiliary Slope VP above.",
                            "Build a ramp or 4-step staircase whose rising stringers converge cleanly to that Auxiliary Slope VP."
                        ),
                        ex1Title = "Auxiliary-VP Ramp & Stairs",
                        ex1Desc = "Construct 1 flat-sided ramp and 1 five-step freestanding staircase converging up toward an Auxiliary VP directly above VP1.",
                        ex1Reps = "2 auxiliary-VP slope constructions",
                        ex1Min = 14,
                        ex2Title = "Open Treasure Chest / Sketchbook",
                        ex2Desc = "Draw a closed 2-point wooden box, then hinge the lid open at 45° using an Auxiliary VP above VP2.",
                        ex2Reps = "2 hinged open-lid boxes",
                        ex2Min = 10,
                        ex3Title = "Swinging Open Doorway",
                        ex3Desc = "Construct a wall with a doorway and swing the wooden door 60° open into the room using a floor arc and shifted horizon VP.",
                        ex3Reps = "2 swinging door studies",
                        ex3Min = 8,
                        challengeTitle = "A-Frame Cabin With Porch Stairs",
                        challengeDesc = "Combine pitched steep A-frame roof beams (both upward and downward auxiliary VPs!) with front porch stairs.",
                        challengeReps = "1 A-frame perspective study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Placing the Auxiliary VP off to the side instead of straight above/below the main VP" to "Use a vertical perpendicular rail straight up/down from the main VP unless the floor itself is tilted.",
                            "Hinge edges failing to match lid width" to "Swing a perspective circle arc around the hinge corner to match lid depth accurately."
                        ),
                        checklist = listOf(
                            "Rising parallel edges converge cleanly to a vertical Auxiliary VP.",
                            "Step treads and risers alternate back toward the main horizontal VPs.",
                            "Hinged lids match the box footprint length."
                        ),
                        criteria = "Complete 6 auxiliary-VP ramp, stair, and hinged-lid constructions.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_3pt_persp",
                        reinforcedSkillIds = listOf("sk_2pt_persp")
                    ),
                    LessonSpec(
                        id = "w5_u4_l2",
                        title = "Orthographic-to-3D Projection",
                        subtitle = "Turning side/top plans into 3D perspective forms",
                        objective = "Plot a simple 2D side profile and top-down plan, then slice and project them into a crisp 3D perspective box.",
                        explanation = "Industrial designers (Scott Robertson style) design complex curved objects by sketching a flat side silhouette first, measuring height fractions (1/4, 1/2, 3/4), and plotting those coordinates onto the center spine plane of a 3D perspective box.",
                        whyItMatters = "Gives you total control when inventing chairs, mice, watercraft, or sci-fi tools from imagination.",
                        materials = listOf("2H & HB pencils", "Ruler", "Sketchbook"),
                        steps = listOf(
                            "In the top corner, sketch a tiny flat 2D side profile of a sleek shoe, computer mouse, or canoe inside a 1×2 rectangle with halfway tick marks.",
                            "Draw a matching 1×2 proportion 2-point bounding box in 3D.",
                            "Find the vertical center spine plane inside the 3D box using X-diagonals, transfer the profile points, and wrap cross-contour ribs across."
                        ),
                        ex1Title = "3D Computer Mouse / Iron Projection",
                        ex1Desc = "Sketch a 2D side and top silhouette of a computer mouse or clothes iron, then project its domed spine and base rim inside a 2-point bounding box.",
                        ex1Reps = "2 projected 3D product hulls",
                        ex1Min = 15,
                        ex2Title = "Curved Lounge Chair From Side Profile",
                        ex2Desc = "Draw an S-curved modern chair side profile, transfer its 4 key inflection heights onto left & right faces of a 2-pt box, and bridge them smoothly.",
                        ex2Reps = "1 extruded curved chair",
                        ex2Min = 12,
                        ex3Title = "Canoe Hull Rib Slicing",
                        ex3Desc = "Project a tapered boat hull by slicing 4 cross-section U-ribs along a center keel line inside a long 2-pt slab.",
                        ex3Reps = "1 ribbed boat hull",
                        ex3Min = 10,
                        challengeTitle = "Vintage Hairdryer or Kettle Projection",
                        challengeDesc = "Plot side & front orthographics of a sleek handheld hairdryer and construct it transparently in 3/4 perspective with contoured cross-sections.",
                        challengeReps = "1 full industrial projection plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Forgetting to project thickness symmetrically to both left and right sides of the center spine" to "Always establish the vertical centerline plane inside the box first.",
                            "Letting cross-sections twist differently than the box orientation" to "Keep rib width lines aimed straight toward the side VP."
                        ),
                        checklist = listOf(
                            "2D orthographic proportions match the 3D bounding box.",
                            "Center spine plane accurately guides curved domes and profiles.",
                            "Cross-section ribs hold symmetrical width across both sides."
                        ),
                        criteria = "Complete 4 orthographic-to-3D object projections.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_persp_div",
                        reinforcedSkillIds = listOf("sk_cross_contour")
                    ),
                    LessonSpec(
                        id = "w5_u4_l3",
                        title = "Freehand Perspective & Intuition Calibration",
                        subtitle = "Trusting your trained eye without ruler crutches",
                        objective = "Sketch a coherent multi-building or interior environment purely freehand, auditing convergence afterward.",
                        explanation = "You won't carry a 60 cm T-square into coffee shops or parks. After mastering mechanical perspective rules, you train your eyes and shoulder to estimate converging rays naturally—using rulers only afterward to audit accuracy.",
                        whyItMatters = "Bridges rigid technical perspective into fast, lively sketchbook drawing on location and from imagination.",
                        materials = listOf("HB & 2B pencils (or fineliner)", "Ruler ONLY for post-check", "Sketchbook"),
                        steps = listOf(
                            "Place a light freehand Horizon Line and two distant off-paper VPs in your mind.",
                            "Ghost every perspective ray before committing lines, constantly comparing top vs. bottom slope fans.",
                            "Populate a multi-level courtyard or café corner completely freehand, then audit 6 major lines with a ruler afterward."
                        ),
                        ex1Title = "Freehand Living Room Corner",
                        ex1Desc = "Sketch a real corner of your room (sofa/desk, window, rug, ceiling edge) completely freehand in 12 minutes, checking eye-level horizon first.",
                        ex1Reps = "1 freehand room sketch",
                        ex1Min = 12,
                        ex2Title = "Post-Draw Ruler Audit & Notes",
                        ex2Desc = "Take a ruler and extend 8 key receding lines on your freehand sketch to mark where they actually crossed vs. your intended Horizon Line—write 2 takeaways.",
                        ex2Reps = "1 audited room critique",
                        ex2Min = 6,
                        ex3Title = "20-Box Freehand Rotation Sprint",
                        ex3Desc = "Fill a final calibration page with 20 fast rotated freehand boxes above and below horizon, focusing on smooth ghosted strokes.",
                        ex3Reps = "20 freehand rotated boxes",
                        ex3Min = 12,
                        challengeTitle = "Imaginary Courtyard Steps & Arch",
                        challengeDesc = "Invent a sunlit Mediterranean courtyard with 4 steps, an arched wall alcove, and a stone planter completely freehand with shadow blocking.",
                        challengeReps = "1 invented architectural vignette",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Letting floor rug lines drift uphill above the Horizon Line" to "Check regularly: lines below eye level ALWAYS angle UP toward the horizon as they recede.",
                            "Drawing too slowly out of fear of missing invisible off-page VPs" to "Ghost confidently while glancing between neighboring receding edges to ensure they gently pinch together."
                        ),
                        checklist = listOf(
                            "Ruler audit shows receding edges converging reasonably toward a consistent eye level.",
                            "Freehand strokes remained smooth and lively without ruler stiffness.",
                            "I noted specific convergence habits to refine in future reviews."
                        ),
                        criteria = "Complete freehand environment, ruler audit, and 20-box calibration to unlock World 5's Milestone Project.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_2pt_persp",
                        reinforcedSkillIds = listOf("sk_1pt_persp", "sk_3pt_persp", "sk_persp_div")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w5",
            worldNumber = 5,
            title = "Constructed Perspective Environment Plate",
            brief = "Construct a complete multi-element 2-point (or 3-point) architectural/interior scene—such as a cozy workshop corner, street café exterior, or multi-level courtyard—combining X-method subdivision, recessed openings, cylindrical/arched elements, scale figures, and clean line-weight depth.",
            combinedSkills = listOf("1-Point & 2-Point Perspective", "3-Point / Auxiliary Slopes", "Subdivision & Ellipses", "Line Weight Depth"),
            requiredMaterials = listOf("2H, HB, 2B pencils", "Clear ruler (construction) + freehand finish", "A4 sketchpad"),
            phases = listOf(
                "Phase 1 (5 min): Draw 2 thumbnails establishing eye level (horizon) and primary VPs.",
                "Phase 2 (12 min): Build major architectural masses, floor grids, and X-subdivided bays/windows.",
                "Phase 3 (10 min): Add cylindrical/arched elements, furniture/stairs, and horizon-anchored scale silhouettes.",
                "Phase 4 (8 min): Reinforce foreground-to-background line weight and add subtle 2-value shadow blocking."
            ),
            selfAssessmentChecklist = listOf(
                "All parallel structures share consistent vanishing points on one clean Horizon Line.",
                "Repeating bays, tiles, or steps compress naturally using X-method proportion.",
                "Ellipses and arches align squarely to their perspective boxes and axles.",
                "Line weight clearly separates foreground props from distant background."
            ),
            estimatedMinutes = 35,
            xpReward = 180
        )
    ),

    // WORLD 6: STILL LIFE
    DrawingWorld(
        number = 6,
        id = "world_6",
        title = "Still Life",
        tagline = "Translate real everyday objects into structured, grounded observational plates",
        focusSummary = "Unite sighting, centerline symmetry, ellipse construction, overlapping composition, and tonal grouping across multi-object setups.",
        unlockRequirementSummary = "Complete World 5 Milestone & reach Practicing in Perspective skills",
        units = listOf(
            buildUnit(
                6, 1, "w6_u1", "Symmetry & Manufactured Objects",
                "Construct mugs, bottles, bowls, and utensils symmetrically on true perspective centerlines.",
                listOf(
                    LessonSpec(
                        id = "w6_u1_l1",
                        title = "Centerline Symmetry & Bottle Profiles",
                        subtitle = "Stop drawing lopsided vases and wine bottles",
                        objective = "Construct symmetrical rotated objects (bottles, glasses, bowls) using a vertical centerline and horizontal ellipse axes.",
                        explanation = "Symmetrical objects look crooked whenever artists outline left and right edges independently. Drawing a plumb centerline FIRST, plotting horizontal tick marks equidistant left/right, and building full transparent ellipses at every width shift guarantees rock-solid symmetry.",
                        whyItMatters = "Applies to pottery, glassware, lamps, wheels, and even symmetrical human faces later.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook", "2 real bottles/glasses/bowls"),
                        steps = listOf(
                            "Draw a plumb vertical centerline and mark top lip, shoulder, belly, and base heights.",
                            "Measure left and right half-widths evenly from the centerline.",
                            "Draw full transparent horizontal ellipses at each key transition—widening ellipse degree steadily from top lip down toward the base!"
                        ),
                        ex1Title = "Glassware & Bottle Axis Breakdown",
                        ex1Desc = "Set up a tall water bottle and a wide bowl. Construct both transparently with centerlines, tick marks, and stacked ellipses.",
                        ex1Reps = "3 symmetrical vessel constructions",
                        ex1Min = 12,
                        ex2Title = "Degree Opening Check",
                        ex2Desc = "Draw a tall clear drinking glass from slightly above eye level; verify the bottom base ellipse is noticeably rounder/taller than the top rim ellipse.",
                        ex2Reps = "3 clear-glass ellipse checks",
                        ex2Min = 9,
                        ex3Title = "Rim Thickness & Lip Lip-Wrap",
                        ex3Desc = "Zoom in on a thick ceramic bowl and draw the inner rim ellipse tucked cleanly inside the outer rim ellipse so the wall shows real thickness.",
                        ex3Reps = "3 thick-walled bowl rims",
                        ex3Min = 7,
                        challengeTitle = "Ornate Kettle or Pitcher With Spout & Handle",
                        challengeDesc = "Construct a teapot or pitcher symmetrically on its centerline, then project the spout and handle smoothly along the same perspective plane.",
                        challengeReps = "1 asymmetric-handle vessel study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Pointed pinched corners on rim ellipses" to "Wrap the rim ellipse completely around through the back so the corners curve smoothly.",
                            "Top and bottom ellipses drawn the exact same fatness" to "Since the base sits farther below your eye level than the top rim, open the base ellipse rounder."
                        ),
                        checklist = listOf(
                            "Left and right profiles mirror evenly across the plumb centerline.",
                            "Lower ellipses open visibly wider in degree than upper ellipses.",
                            "Ceramic/glass rims show convincing wall thickness."
                        ),
                        criteria = "Complete 9 symmetrical vessel constructions with accurate ellipse degree progression.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_still_construct",
                        reinforcedSkillIds = listOf("sk_spheres_cyl")
                    ),
                    LessonSpec(
                        id = "w6_u1_l2",
                        title = "Tilted & Lying Objects in Perspective",
                        subtitle = "Toppled mugs, angled spoons, and resting tools",
                        objective = "Construct asymmetrical or tipped everyday objects resting naturally at angles on a flat tabletop.",
                        explanation = "An upright mug sits on a vertical centerline; a spoon resting diagonally or a toppled wine bottle lies along a receding perspective axis! Finding its tabletop footprint line first keeps it from hovering above the cloth.",
                        whyItMatters = "Makes still lifes look dynamic and candid rather than stiffly lined up like soldiers.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook", "Mug, spoon, and scissors/wrench"),
                        steps = listOf(
                            "Plot the object's resting axis line lying along the tabletop plane.",
                            "For a spoon or lying bottle: build the tilted Minor Axis first, then drop perpendicular ellipses along it.",
                            "Add a crisp shadow wedge right underneath the lifted arch of a spoon handle or bottle neck."
                        ),
                        ex1Title = "Toppled Cup & Fork Pair",
                        ex1Desc = "Lay a mug on its side pointing 45° toward you with a fork resting beside it. Construct both along receding tabletop axes.",
                        ex1Reps = "2 lying-vessel studies",
                        ex1Min = 12,
                        ex2Title = "Tilted Spoon & Scissor Foreshortening",
                        ex2Desc = "Aim a wooden spoon and pair of scissors pointing nearly toward you on the desk; measure foreshortened lengths carefully before outlining.",
                        ex2Reps = "3 foreshortened tool studies",
                        ex2Min = 10,
                        ex3Title = "Handle Attachment Angle Drill",
                        ex3Desc = "Draw a mug upright and lying down, plotting a perspective plane slicing straight through the mug centerline so the handle aligns cleanly.",
                        ex3Reps = "2 handle-plane studies",
                        ex3Min = 8,
                        challengeTitle = "Open Pocketknife or Eyeglasses",
                        challengeDesc = "Construct folding eyeglasses resting half-open on a table, tracking the asymmetrical bridge and temple hinges accurately.",
                        challengeReps = "1 open-hinge eyeglasses plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Tilting a lying bottle's ellipses vertically instead of perpendicular to its tilted spine" to "Rotate your wrist/paper so every ellipse sits 90° to the bottle's tilted axis.",
                            "Spoon handle bowing off the table unrealistically" to "Track the ground contact points separately from the curved lifted neck."
                        ),
                        checklist = listOf(
                            "Ellipses on lying objects align perpendicularly to their tilted spine.",
                            "Foreshortened tools feel genuinely compressed rather than stretched flat.",
                            "Contact shadows sit strictly under touching points."
                        ),
                        criteria = "Complete 7 lying/foreshortened everyday object constructions.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_still_construct",
                        reinforcedSkillIds = listOf("sk_sight_prop")
                    ),
                    LessonSpec(
                        id = "w6_u1_l3",
                        title = "Organic Still Life: Fruits & Vegetables",
                        subtitle = "Combining primitive symmetry with organic asymmetry",
                        objective = "Draw apples, peppers, garlic, and lemons showing both underlying spherical/box structure and unique natural lumps.",
                        explanation = "An apple isn't a billiard ball—it's a slightly five-lobed tapered sphere with a recessed stem crater. Construct the general primitive volume first, establish cross-contours into the stem dimple, and carve irregular bumps last.",
                        whyItMatters = "Teaches you how to respect geometry without making living things look plastic or machine-lathed.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Real fruit/vegetable", "Sketchbook"),
                        steps = listOf(
                            "Block the overall tilted oval/wedge envelope of the fruit.",
                            "Locate the recessed stem crater on the top-front shoulder (never stuck randomly on top like a cherry if tilted toward you!).",
                            "Run 4 light cross-contour ribs diving into the stem dimple, then refine asymmetric lumps and skin creases."
                        ),
                        ex1Title = "3-Angle Apple or Onion Study",
                        ex1Desc = "Draw the same apple/onion 3 times (upright, tilted stem toward you, tilted base toward you) showing the recessed crater clearly.",
                        ex1Reps = "3 rotated fruit studies",
                        ex1Min = 12,
                        ex2Title = "Cut Citrus & Bell Pepper",
                        ex2Desc = "Slice an orange/lemon or draw a 3-lobed bell pepper, mapping its internal radial wedges and thick peel rim.",
                        ex2Reps = "2 cross-section / lobed studies",
                        ex2Min = 12,
                        ex3Title = "Garlic Bulb Clove Clustering",
                        ex3Desc = "Draw a head of garlic or small bunch of grapes, clustering individual cloves tightly around a shared core axis.",
                        ex3Reps = "2 clustered organic studies",
                        ex3Min = 8,
                        challengeTitle = "Halved Avocado or Walnut Shell",
                        challengeDesc = "Render an open avocado with its round pit sphere nestled cleanly inside the carved hollow cavity.",
                        challengeReps = "1 open-cavity fruit study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Pasting the stem on the outer top edge like a flat icon" to "Tuck the stem inside a curved shadow dimple INSIDE the upper silhouette.",
                            "Drawing perfectly smooth circles for apples/pears" to "Look closely for flat resting shoulders and subtle asymmetric tilts."
                        ),
                        checklist = listOf(
                            "Stems emerge from recessed 3D dimples inside the form.",
                            "Organic lumps feel attached to a solid underlying core.",
                            "Fruit sits heavily on a slightly flattened bottom base."
                        ),
                        criteria = "Complete 7 organic produce studies with believable stem craters and volume.",
                        diagramType = DiagramType.CROSS_CONTOUR,
                        primarySkillId = "sk_still_construct",
                        reinforcedSkillIds = listOf("sk_cross_contour")
                    )
                )
            ),
            buildUnit(
                6, 2, "w6_u2", "Multi-Object Proportions & Grounding",
                "Maintain truthful size ratios, table perspective, and overlapping depth across groups of objects.",
                listOf(
                    LessonSpec(
                        id = "w6_u2_l1",
                        title = "Tabletop Plane & Footprint Mapping",
                        subtitle = "Preventing objects from floating or colliding",
                        objective = "Map a clear ground-plane perspective map (ellipses/footprints) BEFORE raising vertical object bodies.",
                        explanation = "The classic still-life mistake is drawing the front bottle nicely, drawing an apple behind it, and suddenly realizing their bases occupy the exact same spot on the table! Mapping the flat ground footprints first like an architect's floorplan prevents every collision.",
                        whyItMatters = "Grounds multi-object scenes, figure groups, and environment props firmly in shared physical space.",
                        materials = listOf("2H & HB pencils", "Sketchbook", "3–4 household objects"),
                        steps = listOf(
                            "Set up 3–4 items clustered at varying distances (one close front-left, one tall middle, one tucked behind).",
                            "Sight their relative floor heights—remember: objects closer to the front sit LOWER on the page; objects farther back sit HIGHER toward the horizon!",
                            "Sketch ONLY the flat ground footprints (squares/ellipses) on the table plane lightly in 2H, verify spacing, then extrude each object upward."
                        ),
                        ex1Title = "Floorplan-First 4-Object Cluster",
                        ex1Desc = "Arrange 4 items (book, cup, fruit, small box). Draw their light 2H ground footprints cleanly first, check overlap gaps, then construct heights.",
                        ex1Reps = "2 floorplan-first constructions",
                        ex1Min = 14,
                        ex2Title = "High-vs-Low Horizon Table Test",
                        ex2Desc = "Draw the same 2 objects seated on a table edge from standing height vs. seated eye-level height.",
                        ex2Reps = "2 eye-level comparison sketches",
                        ex2Min = 10,
                        ex3Title = "Tangent Elimination Exercise",
                        ex3Desc = "Arrange 3 items intentionally overlapping nicely (never kissing edge-to-edge!). Adjust placement so overlaps cleanly show front-vs-back.",
                        ex3Reps = "2 tangent-free overlap layouts",
                        ex3Min = 8,
                        challengeTitle = "Crowded Breakfast Table Corner",
                        challengeDesc = "Construct 6 items (plate, mug, spoon, toast/fruit, napkin, jar) on a visible table corner using strict footprint mapping.",
                        challengeReps = "1 six-item floorplan plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Kissing tangents where two objects barely touch at exact corners" to "Either overlap objects clearly by 20% OR separate them with clean negative space.",
                            "Drawing background object bases as low on the page as foreground objects" to "Shift rear object contact bases higher up toward the tabletop's back edge."
                        ),
                        checklist = listOf(
                            "Every object has an unobstructed, believable footprint on the table plane.",
                            "Overlaps clearly communicate front-to-back depth without awkward tangents.",
                            "Rear objects sit appropriately higher on the table plane."
                        ),
                        criteria = "Complete 6 footprint-mapped multi-object layouts.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_still_prop",
                        reinforcedSkillIds = listOf("sk_sight_prop")
                    ),
                    LessonSpec(
                        id = "w6_u2_l2",
                        title = "Comparative Scale Across Disparate Sizes",
                        subtitle = "Pairing tiny spoons with tall pitchers accurately",
                        objective = "Maintain accurate proportional relationships across 3+ objects of wildly different heights and widths.",
                        explanation = "When drawing one object, minor scale drift hides easily. When drawing a tall wine bottle next to a small espresso cup and a garlic clove, any 10% drift makes the espresso cup look huge! Constant cross-checking between objects locks scale.",
                        whyItMatters = "Trains relational thinking needed for full environments and multi-figure scenes.",
                        materials = listOf("HB pencil", "Sketchbook", "1 tall, 1 medium, 1 tiny object"),
                        steps = listOf(
                            "Choose your medium object (like a coffee mug) as your Master Unit = 1.0.",
                            "Sight how many 'mug heights' tall the tall bottle is (e.g., 2.4×) and how big the tiny spoon/walnut is (0.35×).",
                            "Check horizontal level lines across all three objects ('does the garlic top line up with the mug's handle bottom?')."
                        ),
                        ex1Title = "1-2-3 Scale Ladder Setup",
                        ex1Desc = "Arrange a tall thermos, medium mug, and tiny lemon/coin. Sight and mark exact unit ratios and horizontal alignment lines across all three.",
                        ex1Reps = "2 measured 3-scale constructions",
                        ex1Min = 14,
                        ex2Title = "Book-Stack + Lamp Scale Check",
                        ex2Desc = "Draw a stack of 3 varied-thickness books topped by a small cup or clock, verifying book thicknesses proportionally.",
                        ex2Reps = "2 measured stack proportions",
                        ex2Min = 10,
                        ex3Title = "Rapid Ratio Correction Drill",
                        ex3Desc = "Make a fast 3-minute setup sketch, then hold your pencil at arm's length to measure 5 vertical/horizontal ratios and mark exact red/dark correction ticks.",
                        ex3Reps = "2 self-measured ratio audits",
                        ex3Min = 8,
                        challengeTitle = "Kitchen Counter Grouping",
                        challengeDesc = "Measure and construct 5 kitchen utensils/jars of drastically different heights in one unified proportional block-in.",
                        challengeReps = "1 five-scale kitchen block-in",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing small objects bigger than life so their details fit easily" to "Respect actual tiny silhouettes—simplify tiny details instead of inflating scale.",
                            "Measuring one item accurately then guessing the rest" to "Always reference every new object back to your Master Unit."
                        ),
                        checklist = listOf(
                            "Small objects stayed appropriately small relative to tall objects.",
                            "Horizontal alignment lines match real life accurately.",
                            "Proportional ticks guided construction before detail drawing."
                        ),
                        criteria = "Complete 6 multi-scale sighted still-life constructions.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_still_prop"
                    ),
                    LessonSpec(
                        id = "w6_u2_l3",
                        title = "Table Edges, Corners & Environment Context",
                        subtitle = "Grounding the still life inside a believable room",
                        objective = "Place still-life setups onto perspective-accurate table corners, wall seams, and window frames.",
                        explanation = "Objects don't float in an infinite gray void. Including the front edge of the table, the distant wall-to-table corner, or a soft window shadow strip behind anchors your still life inside real architecture.",
                        whyItMatters = "Transforms isolated object practice into rich environmental still-life compositions.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "Include the tabletop's back or corner edge converging toward your Horizon Line.",
                            "Add a subtle horizontal/vertical background wall plane break behind the objects.",
                            "Let cast shadows cross cleanly over tabletop seams or drop over the front table lip."
                        ),
                        ex1Title = "Table-Edge Overhang Composition",
                        ex1Desc = "Place a bowl and folded cloth/spoon right near the front edge of a table so part of a cloth or spoon handle overhangs the edge.",
                        ex1Reps = "2 table-edge compositions",
                        ex1Min = 12,
                        ex2Title = "Corner Wall & Window Shadow Backdrop",
                        ex2Desc = "Set objects near a wall corner and lightly grade the background wall planes so one wall reads darker than the lit wall.",
                        ex2Reps = "2 anchored wall-backdrop studies",
                        ex2Min = 12,
                        ex3Title = "Perspective-Checked Table Lines",
                        ex3Desc = "Draw 2 still-life layouts ensuring the left and right table edges converge plausibly to VPs on the same horizon as your cup ellipses.",
                        ex3Reps = "2 perspective-synced table setups",
                        ex3Min = 8,
                        challengeTitle = "Windowsill Plant & Mug Scene",
                        challengeDesc = "Draw a mug and small potted plant sitting on a real windowsill with window sash bars and exterior sky/wall tone contrast.",
                        challengeReps = "1 windowsill environmental study",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Table edge tilting inconsistently with cup ellipse degrees" to "Higher eye-level (rounder cup ellipses) means a steeper downward table surface!",
                            "Dark heavy line cutting across the back wall edge behind objects" to "Keep the rear table line soft and atmospheric so objects stay in front."
                        ),
                        checklist = listOf(
                            "Tabletop edges match the perspective eye level of the objects sitting on it.",
                            "Rear table/wall seams stay softer than foreground objects.",
                            "Overhanging elements add clear 3D depth."
                        ),
                        criteria = "Complete 6 grounded still-life setups with environmental table/wall planes.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_still_comp",
                        reinforcedSkillIds = listOf("sk_1pt_persp", "sk_2pt_persp")
                    )
                )
            ),
            buildUnit(
                6, 3, "w6_u3", "Still Life Composition & Storytelling",
                "Design balanced asymmetrical arrangements, focal contrast, and varied visual rhythm.",
                listOf(
                    LessonSpec(
                        id = "w6_u3_l1",
                        title = "Asymmetrical Balance & Rule of Thirds",
                        subtitle = "Designing arrangements before picking up the pencil",
                        objective = "Arrange physical still-life objects deliberately using big-medium-small variety, asymmetrical focal placement, and directional pointers.",
                        explanation = "A boring still life puts three identical-sized cans spaced evenly in a straight row. A compelling still life pairs a **Hero** (large focal item at a rule-of-thirds intersection), a **Companion** (medium overlapping item), and an **Accent** (small tilted item like a spoon pointing the viewer's eye straight back to the Hero!).",
                        whyItMatters = "Turns random desk clutter into deliberate, captivating artistic compositions.",
                        materials = listOf("HB & 2B pencils", "Sketchbook", "3–5 varied household items"),
                        steps = listOf(
                            "Curate 3 items of distinct heights/textures (Big, Medium, Small).",
                            "Arrange them physically on your desk avoiding dead-center symmetry and equal gaps.",
                            "Draw 4 small thumbnail compositions shifting eye level and crop until one thumbnail leads the eye effortlessly to the Hero."
                        ),
                        ex1Title = "Big-Medium-Small Arrangement Lab",
                        ex1Desc = "Physically rearrange 3 objects into 4 distinct layouts (tight overlap, triangular triad, L-shape, diagonal lead-in) and draw quick 2-value thumbnails of each.",
                        ex1Reps = "4 compositional thumbnails",
                        ex1Min = 12,
                        ex2Title = "Directional Pointer Study",
                        ex2Desc = "Place a spoon, paintbrush, or knife angled on the cloth specifically to point the viewer's eye straight toward your focal cup/fruit.",
                        ex2Reps = "2 eye-flow pointer compositions",
                        ex2Min = 10,
                        ex3Title = "Shape Rhythm & Silhouette Check",
                        ex3Desc = "Block ONLY the merged outer silhouette of your chosen 3-object group to ensure it forms an interesting dynamic triangle or asymmetric pyramid.",
                        ex3Reps = "2 merged silhouette checks",
                        ex3Min = 6,
                        challengeTitle = "High-Drama Close-Up Crop",
                        challengeDesc = "Crop tightly into a 4-object setup so the largest pitcher/book bleeds cleanly off one frame edge while the focal teacup gleams in full view.",
                        challengeReps = "1 cropped focal composition",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Lining objects up evenly like bowling pins" to "Stagger objects forward and back in depth so two overlap while one steps aside.",
                            "Putting the focal item dead-center" to "Shift the Hero onto a 1/3 horizontal or vertical intersection."
                        ),
                        checklist = listOf(
                            "The setup features clear Big, Medium, and Small silhouette variety.",
                            "Focal object sits cleanly near a rule-of-thirds sweet spot.",
                            "Leading lines/pointers guide the eye back into the scene."
                        ),
                        criteria = "Complete 8 thumbnail and compositional flow studies.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_still_comp"
                    ),
                    LessonSpec(
                        id = "w6_u3_l2",
                        title = "Tonal Composition & Focal Contrast",
                        subtitle = "Directing attention with highest value contrast",
                        objective = "Place the sharpest contrast (brightest light against deepest dark) strictly on the focal object while softening peripheral zones.",
                        explanation = "Your eye naturally locks onto wherever Value #1 touches Value #9 with a crisp edge. By keeping background props slightly softer in contrast (#3 against #6) and concentrating razor contrast on your Hero object, you steer the viewer's gaze cleanly.",
                        whyItMatters = "Prevents busy still lifes from feeling noisy or visually exhausting.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Sketch a 3-object composition cleanly.",
                            "Designate ONE Hero object (e.g., the ceramic cup or pear) to carry the brightest #1 highlight and deepest #9 occlusion/core shadow.",
                            "Restrain secondary background items to a narrower mid-value range (#3 to #7) with slightly softer edges."
                        ),
                        ex1Title = "Focal Contrast Map Thumbnails",
                        ex1Desc = "Sketch the same 3-object setup twice in tiny 5×6 cm boxes: Box A spotlights the foreground apple; Box B spotlights the rear bottle—purely by moving highest value contrast!",
                        ex1Reps = "2 spotlight-shift thumbnails",
                        ex1Min = 10,
                        ex2Title = "Focal-Hierarchy Still Life Render",
                        ex2Desc = "Execute a medium 15-minute still life keeping sharp #1/#9 contrast strictly at the focal center and toning down distant edges.",
                        ex2Reps = "1 focal-hierarchy study",
                        ex2Min = 15,
                        ex3Title = "Detail Economy on Supporting Props",
                        ex3Desc = "Draw a textured book or cloth behind a smooth cup—suggest book pages/cloth folds simply so they never out-compete the Hero.",
                        ex3Reps = "1 subordinate-detail study",
                        ex3Min = 8,
                        challengeTitle = "Monochrome Still Life Narrative",
                        challengeDesc = "Compose a 'story' still life (e.g., reading glasses resting on an open book beside a steaming tea mug) and lead the eye to the mug/glasses junction via contrast.",
                        challengeReps = "1 narrative focal plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Adding sharp, high-contrast cracks/logos onto an unimportant background box" to "Save sharpest contrast and finest edge detail exclusively for the Hero.",
                            "Putting bright white paper edges near the frame borders" to "Gently tone outer corners down to #2–#3 to cradle the viewer's eye inside."
                        ),
                        checklist = listOf(
                            "My eye immediately lands on the intended Hero object first.",
                            "Highest contrast (#1 next to #9) sits cleanly at the focal zone.",
                            "Supporting objects feel integrated rather than competing for attention."
                        ),
                        criteria = "Complete 4 focal-hierarchy and narrative tonal studies.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_still_value",
                        reinforcedSkillIds = listOf("sk_still_comp")
                    ),
                    LessonSpec(
                        id = "w6_u3_l3",
                        title = "Negative Shape Harmony & Cropping",
                        subtitle = "Balancing empty space around the still life",
                        objective = "Design pleasing asymmetrical background shapes around a still life so empty space feels intentional, not leftover.",
                        explanation = "In great still-life paintings (Chardin, Morandi), the empty wall above and around the bottles is broken into calm, varied rectangles and triangles—never equal borders or awkward cramped corners.",
                        whyItMatters = "Makes simple 2-object studies look composed like museum pieces.",
                        materials = listOf("HB, 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "Draw a crisp ruled border box (e.g., 14×18 cm) on your page.",
                            "Compose 2–3 objects inside, adjusting zoom until negative shapes around the top, left, and right differ pleasantly in size.",
                            "Tone the quiet background gently to unify those negative spaces."
                        ),
                        ex1Title = "Morandi-Inspired Quiet Vessel Trio",
                        ex1Desc = "Arrange 3 simple bottles/boxes tightly grouped in the lower third of a 12×15 cm frame, letting calm quiet wall space occupy the upper 60%.",
                        ex1Reps = "2 minimalist negative-space plates",
                        ex1Min = 14,
                        ex2Title = "Border-Crop Sensitivity Check",
                        ex2Desc = "Draw 3 small frames showing: (A) cramped margins, (B) too tiny floating in huge blank page, and (C) balanced asymmetrical breathing room.",
                        ex2Reps = "3 comparative crop boxes",
                        ex2Min = 9,
                        ex3Title = "Subtle Background Gradient Wash",
                        ex3Desc = "Shade a smooth directional background tone across one vessel study (darker behind lit sides, lighter behind dark sides).",
                        ex3Reps = "1 graded backdrop plate",
                        ex3Min = 8,
                        challengeTitle = "Panoramic Horizontal Still Life",
                        challengeDesc = "Rule a wide 20×8 cm cinematic horizontal frame and pace 4 small items rhythmically across the strip with clean negative pauses.",
                        challengeReps = "1 panoramic still-life strip",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Leaving equal tiny 1 cm margins on all four sides" to "Give extra airy space above/ahead of the focal direction.",
                            "Letting an object's tip barely kiss the frame border" to "Either keep a clean margin inside the border OR slice boldly right through the frame edge."
                        ),
                        checklist = listOf(
                            "Empty background spaces have varied, pleasant proportions.",
                            "No object awkwardly kisses the border frame.",
                            "Subtle background tone supports object edges."
                        ),
                        criteria = "Complete 6 balanced negative-space and crop-sensitivity compositions.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_still_comp",
                        reinforcedSkillIds = listOf("sk_neg_space")
                    )
                )
            ),
            buildUnit(
                6, 4, "w6_u4", "Observational Still Life Mastery",
                "Bring sighting, perspective construction, value grouping, and atmospheric rendering together from real life.",
                listOf(
                    LessonSpec(
                        id = "w6_u4_l1",
                        title = "Bargue-Inspired Sight-Size Block-In",
                        subtitle = "Precision angle and shadow-map accuracy",
                        objective = "Execute a clean classical block-in mapping outer envelope, interior angles, and crisp shadow boundaries before any shading.",
                        explanation = "Classical academies (Charles Bargue method) separate drawing cleanly into (1) Accurate Light Construction & Shadow Mapping, and (2) Pure Value Rendering. Fixing every measurement BEFORE shading prevents having to erase darkened work later.",
                        whyItMatters = "Builds relentless accuracy and saves hours of rework on long drawings.",
                        materials = listOf("2H & HB pencils", "Long knitting needle or straight pencil for sighting", "Sketchbook"),
                        steps = listOf(
                            "Set up a classic 2-object still life (pitcher + apple or candlestick + cup) under fixed lamp light.",
                            "Use straight-line envelope strokes in 2H to locate outer boundaries, plumb checks, and ellipse centers.",
                            "Map the exact shadow shapes (terminator + cast shadow edges) lightly as crisp polygons—stop and audit 100% before shading."
                        ),
                        ex1Title = "Pure Classical Block-In Plate",
                        ex1Desc = "Spend 15 full minutes strictly doing a precision 2H/HB envelope, plumb check, and shadow-boundary line map of a 2-object still life—DO NOT shade yet!",
                        ex1Reps = "1 precision audited block-in",
                        ex1Min = 15,
                        ex2Title = "Self-Audit With Plumb & Angle Sighting",
                        ex2Desc = "Compare 6 key landmarks on your block-in against real life with straight-arm sighting; adjust any off-angle lines cleanly.",
                        ex2Reps = "1 corrected block-in plate",
                        ex2Min = 8,
                        ex3Title = "2-Value Block-In Fill",
                        ex3Desc = "Fill ONLY the mapped shadow polygons neatly with Value #6 HB tone to test if the drawing already reads 3D before modeling.",
                        ex3Reps = "1 flat-shadow verification pass",
                        ex3Min = 7,
                        challengeTitle = "30-Minute Complex Cast-Shadow Still Life",
                        challengeDesc = "Choose an ornate mug or kettle casting intricate shadows across folded paper and complete a razor-accurate Bargue-style block-in.",
                        challengeReps = "1 complex precision block-in",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Shading early to 'check how it looks' before verifying proportions" to "Finish the entire construction and shadow line map first!",
                            "Curving shadow lines timidly" to "Treat curved terminators initially as clean straight-angle segments."
                        ),
                        checklist = listOf(
                            "100% of proportional checks were verified before shading began.",
                            "Shadow boundaries are plotted cleanly as continuous shapes.",
                            "The flat 2-value fill already reads unmistakably 3D."
                        ),
                        criteria = "Complete an audited classical block-in and 2-value verification pass.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_still_value",
                        reinforcedSkillIds = listOf("sk_sight_prop", "sk_still_prop")
                    ),
                    LessonSpec(
                        id = "w6_u4_l2",
                        title = "Timed Still-Life Sprints (10m vs 25m)",
                        subtitle = "Scaling depth of finish to available time",
                        objective = "Adapt your still-life workflow to deliver finished-feeling studies in both 10-minute rapid sketches and 25-minute sustained plates.",
                        explanation = "Knowing how to finish cleanly in 10 minutes keeps your daily habit alive; knowing how to pace 25–45 minutes builds museum-grade depth. The secret: work **whole-to-part** so even a 10-minute sketch feels complete, not half-finished!",
                        whyItMatters = "Trains real-world sketching agility whether drawing at a café or working in a quiet studio.",
                        materials = listOf("HB, 2B, 4B pencils", "Timer", "Sketchbook"),
                        steps = listOf(
                            "For 10-min Sprint: 2 min loose construction -> 3 min bold 2-value shadow sweep -> 5 min core accents & #9 contacts.",
                            "For 25-min Sustained: 6 min sighting/block-in -> 6 min unified shadow wash -> 13 min halftone turning, reflected light, and focal edges."
                        ),
                        ex1Title = "Two 10-Minute Rapid Still Lifes",
                        ex1Desc = "Set a strict 10-minute timer twice for two fresh 2-object arrangements. Work whole-to-part so both read complete when the bell rings.",
                        ex1Reps = "2 ten-minute whole-to-part sketches",
                        ex1Min = 20,
                        ex2Title = "One 20-Minute Sustained Study",
                        ex2Desc = "Pick one favorite pair and pace 20 minutes cleanly from accurate construction through subtle halftone modeling.",
                        ex2Reps = "1 sustained 20-min plate",
                        ex2Min = 20,
                        ex3Title = "Time-Budget Post-Mortem",
                        ex3Desc = "Compare your 10-min sketch vs. 20-min plate: write 2 notes in your margin on where time helped most and where details crept in early.",
                        ex3Reps = "1 written self-review",
                        ex3Min = 4,
                        challengeTitle = "Back-to-Back 5-Minute Gesture Still Life",
                        challengeDesc = "Draw 3 completely different tabletop angles in 5 minutes each, capturing tilt, big shadow shape, and ground occlusion swiftly.",
                        challengeReps = "3 five-minute rapid studies",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Spending 9 minutes rendering one tiny mug rim and leaving the rest blank" to "Always block the entire composition in the first 25% of your timer.",
                            "Rushing sighting during a 25-minute piece" to "Protect the first 6 minutes purely for accurate measurement."
                        ),
                        checklist = listOf(
                            "10-minute studies covered the whole composition before detailing.",
                            "20-minute sustained piece kept halftones organized inside the 2-value design.",
                            "I paced each phase consciously against the timer."
                        ),
                        criteria = "Complete two 10-minute sprints and one sustained 20-minute still-life study.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_still_value"
                    ),
                    LessonSpec(
                        id = "w6_u4_l3",
                        title = "Complete Observational Still Life Workflow",
                        subtitle = "Dry-run preparation for World 6 Milestone",
                        objective = "Execute all 5 phases—Thumbnail, Sighted Construction, Shadow Mapping, Value Hierarchy, and Edge Polish—fluidly from life.",
                        explanation = "Consolidates every skill from Worlds 1 through 6 into one seamless observational system ready for real-world tabletop subjects.",
                        whyItMatters = "Completes your foundational observational mastery before diving into Textures (World 7) and Living Nature/Figures (Worlds 8–10).",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "A4 sketchpad", "Desk lamp + 3 real objects"),
                        steps = listOf(
                            "Thumbnail 2 crops and choose asymmetrical focal balance.",
                            "Build footprint floorplan + centerline symmetry + proportional sighting.",
                            "Map unified 2-value shadow family cleanly across forms and table.",
                            "Model halftones, reflected bounce, #9 contact occlusions, and focal contrast."
                        ),
                        ex1Title = "Thumbnail & Floorplan Setup",
                        ex1Desc = "Prepare a 3-object setup, create 2 thumbnails, and lay out the sighted 2H floorplan and symmetrical centerlines.",
                        ex1Reps = "2 thumbnails + 1 floorplan block-in",
                        ex1Min = 10,
                        ex2Title = "2-Value Shadow Map & Local Values",
                        ex2Desc = "Map form and cast shadow polygons cleanly and lay down the unified shadow wash respecting light vs. dark object materials.",
                        ex2Reps = "1 shadow-mapped layer",
                        ex2Min = 10,
                        ex3Title = "Focal Modeling & Polish",
                        ex3Desc = "Refine Hero contrast, soften secondary backgrounds, and weld objects down with #9 occlusion darks.",
                        ex3Reps = "1 finished study",
                        ex3Min = 12,
                        challengeTitle = "Reverse-Light Rearrangement",
                        challengeDesc = "Switch your lamp from left to right and sketch a fast 10-minute alternate lighting thumbnail of the exact same setup.",
                        challengeReps = "1 alternate-lighting thumbnail",
                        challengeMin = 10,
                        mistakes = listOf(
                            "Losing ellipse symmetry during shading" to "Verify rim curves one last time right before darkening surrounding backgrounds.",
                            "Neglecting tabletop perspective" to "Check that rear table edges stay softly atmospheric and level with eye height."
                        ),
                        checklist = listOf(
                            "Construction, ellipses, and proportions held steady under rendering.",
                            "Hero object commands clear focal attention via value contrast.",
                            "Every object sits solidly grounded on the table plane."
                        ),
                        criteria = "Complete the full 5-phase still-life study to unlock World 6's Milestone Project.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_still_value",
                        reinforcedSkillIds = listOf("sk_still_construct", "sk_still_prop", "sk_still_comp")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w6",
            worldNumber = 6,
            title = "Three-Object Measured Still Life in Full Value",
            brief = "Curate a Big-Medium-Small arrangement of 3 real objects (e.g., tall bottle/pitcher, ceramic mug or bowl, and fruit/utensil) on a visible table corner under single directional lighting, and execute a finished monochrome plate from thumbnail through full tonal polish.",
            combinedSkills = listOf("Symmetry Construction", "Multi-Object Proportions", "Compositional Balance", "Tonal Grouping & Edges"),
            requiredMaterials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Clean A4 drawing paper", "Single directional lamp + 3 objects"),
            phases = listOf(
                "Phase 1 (5 min): Draw 3 thumbnails exploring asymmetrical Big-Medium-Small focal balance.",
                "Phase 2 (10 min): Map floor footprints, plumb alignments, centerline symmetry, and accurate ellipse degrees in 2H.",
                "Phase 3 (8 min): Map and fill the unified 2-value shadow family + cast shadow projections.",
                "Phase 4 (17 min): Render local value differences, halftones, soft-to-sharp edge shifts, #9 contact occlusions, and calm background framing."
            ),
            selfAssessmentChecklist = listOf(
                "Symmetrical vessels show accurate mirror balance and progressively rounder lower ellipses.",
                "Relative sizes across all three objects feel completely true to life.",
                "Objects sit solidly on the table with zero floating or tangent collisions.",
                "Focal contrast draws the eye straight to the Hero object cleanly."
            ),
            estimatedMinutes = 40,
            xpReward = 200
        )
    )
)
