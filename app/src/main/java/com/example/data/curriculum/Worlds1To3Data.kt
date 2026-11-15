package com.example.data.curriculum

import com.example.domain.model.DiagramType
import com.example.domain.model.DrawingWorld
import com.example.domain.model.MilestoneProject

internal fun worlds1To3(): List<DrawingWorld> = listOf(
    // WORLD 1: LEARNING TO SEE
    DrawingWorld(
        number = 1,
        id = "world_1",
        title = "Learning to See",
        tagline = "Train your eye before training your hand",
        focusSummary = "Break symbol-drawing habits through blind contours, negative space, angle sighting, and proportional measurement.",
        unlockRequirementSummary = "Open to all beginners",
        units = listOf(
            buildUnit(
                1, 1, "w1_u1", "Seeing Edges & Hand-Eye Sync",
                "Slow down your eyes so your pencil follows real contours instead of memorized symbols.",
                listOf(
                    LessonSpec(
                        id = "w1_u1_l1",
                        title = "Blind Contour Synchronization",
                        subtitle = "Lock eye speed to pencil speed",
                        objective = "Draw continuous object contours without looking at the paper to eliminate symbol guessing.",
                        explanation = "Beginners draw what they *think* an object looks like (a circle for an apple, two triangles for a cat) rather than what is actually in front of them. Blind contour drawing forces your pencil to move at the exact millimeter-per-second pace of your eyes scanning the subject's edge.",
                        whyItMatters = "Every advanced drawing relies on accurate observation. Until your eyes and pencil share the same speed, details get rushed and proportions distort.",
                        materials = listOf("HB or 2B graphite pencil", "A4 sketchpad", "Real household object (mug, shoe, or hand)"),
                        steps = listOf(
                            "Tape or clip your paper flat and turn your torso 45° away from the page so you cannot peek.",
                            "Place your pencil point in the center of the page and choose one starting edge on your subject.",
                            "Imagine your eyes are an ant crawling slowly along every tiny bump, dent, and turn of the contour.",
                            "Move your pencil continuously at the exact speed of your eye—never lift the tip until finished."
                        ),
                        ex1Title = "Non-Dominant Hand Blind Contours",
                        ex1Desc = "Pose your non-drawing hand in three bent-finger positions. Spend 3 minutes per pose tracing every knuckle wrinkle and nail edge without glancing down.",
                        ex1Reps = "3 poses × 3 minutes each",
                        ex1Min = 9,
                        ex2Title = "Everyday Tool Edge Crawl",
                        ex2Desc = "Place scissors, keys, or eyeglasses on the desk. Follow both outer perimeter edges and inner cutout edges in one unbroken path.",
                        ex2Reps = "4 objects × 2 minutes each",
                        ex2Min = 8,
                        ex3Title = "Slow-Motion Mug Silhouette",
                        ex3Desc = "Set a ceramic mug at eye angle. Spend a full 4 minutes crawling around rim, handle loop, and base curve without lifting.",
                        ex3Reps = "2 uninterrupted drawings",
                        ex3Min = 8,
                        challengeTitle = "Crumpled Paper Bag Blind Contour",
                        challengeDesc = "Crumple a kraft paper bag or receipt. Trace every ridge and fold crease for 6 uninterrupted minutes.",
                        challengeReps = "1 complex 6-minute study",
                        challengeMin = 6,
                        mistakes = listOf(
                            "Peeking at the paper mid-stroke" to "Place a sheet of cardboard or second sketchbook over your drawing hand while sketching.",
                            "Moving the pencil faster than your eyes" to "Count 'one-thousand-one' per centimeter of contour so your hand waits for visual confirmation."
                        ),
                        checklist = listOf(
                            "I kept my eyes glued to the real subject for the entire timer.",
                            "My lines show subtle bumps and turns rather than smooth generic curves.",
                            "I avoided lifting the pencil and sketching hairy short dashes."
                        ),
                        criteria = "Complete all 9 blind contour studies without peeking; distorted proportions are expected and welcome.",
                        diagramType = DiagramType.OBSERVATION_CONTOUR,
                        primarySkillId = "sk_eye_hand"
                    ),
                    LessonSpec(
                        id = "w1_u1_l2",
                        title = "Modified Contour & Micro-Glances",
                        subtitle = "Connecting inner edges accurately",
                        objective = "Anchor spatial jumps with brief 1-second glances while preserving pure observational focus.",
                        explanation = "Modified contour lets you spend 85% of your time looking at the object and 15% glancing down purely to reposition your pencil tip when transitioning to an internal edge.",
                        whyItMatters = "Pure blind contours drift across the page; modified contour bridges raw observation with coherent spatial placement.",
                        materials = listOf("HB pencil", "Sketchbook", "Desk lamp, shoe, or coiled headphones"),
                        steps = listOf(
                            "Draw the outer contour using blind contour speed.",
                            "Stop your hand completely whenever you need to relocate to an interior seam or crease.",
                            "Glance at the paper only while the pencil is frozen, drop the tip on the exact anchor spot, then look back at the object before moving."
                        ),
                        ex1Title = "85/15 Sneaker Study",
                        ex1Desc = "Place an athletic shoe angled at 3/4 view. Trace sole tread, eyelets, laces, and collar folds using stop-and-glance repositioning.",
                        ex1Reps = "2 views (side & 3/4), 6 min each",
                        ex1Min = 12,
                        ex2Title = "Plant Stem & Leaf Junctions",
                        ex2Desc = "Draw a leafy branch or houseplant. Freeze your hand at each stem fork, glance to align, then draw the leaf edge blind.",
                        ex2Reps = "3 cluster studies",
                        ex2Min = 9,
                        ex3Title = "Coiled Cable Overlap Test",
                        ex3Desc = "Loop a charging cable across itself twice on the desk. Record exact over-under crossings using modified contour.",
                        ex3Reps = "3 cable tangles",
                        ex3Min = 6,
                        challengeTitle = "Bicycle Gear or Complex Kitchen Utensil",
                        challengeDesc = "Draw a whisk, corkscrew, or bike derailleur using strict stop-when-glancing discipline.",
                        challengeReps = "1 detailed 12-minute study",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing while glancing at the paper" to "Make a strict rule: pencil moves ONLY when eyes are on the subject.",
                            "Guessing overlapping gaps" to "Trace up to the overlap boundary, lift, locate the continuation, and confirm angle."
                        ),
                        checklist = listOf(
                            "My pencil stayed still every time I looked down at the page.",
                            "Overlapping edges meet cleanly without wild gaps.",
                            "Internal seams sit inside the silhouette logically."
                        ),
                        criteria = "Finish 8 modified contour studies with clear over-under overlaps and continuous line quality.",
                        diagramType = DiagramType.OBSERVATION_CONTOUR,
                        primarySkillId = "sk_contour",
                        reinforcedSkillIds = listOf("sk_eye_hand")
                    ),
                    LessonSpec(
                        id = "w1_u1_l3",
                        title = "Straight & Curved Boundary Calibration",
                        subtitle = "Seeing angles before curves",
                        objective = "Break complex organic contours into crisp straight tilt segments (envelope method) before refining curves.",
                        explanation = "Curved lines are hard to judge accurately in isolation. Professional draftsmen convert complex silhouettes into a series of straight 'chords' first—judging exact tilt angles—and curve only in a second pass.",
                        whyItMatters = "This envelope technique stabilizes proportions on figures, portraits, and still lifes before you invest in details.",
                        materials = listOf("2H & HB pencils", "Sketchbook", "2–3 household items with curved profiles"),
                        steps = listOf(
                            "Lightly block the outer 'envelope' of the object using 5 to 8 straight lines.",
                            "Compare each straight edge tilt against an imaginary vertical or horizontal clock hand (e.g., '11 o'clock tilt').",
                            "Inside those straight boundaries, carve out the true curved contours with an HB pencil."
                        ),
                        ex1Title = "Envelope Polygons of Bottles & Fruit",
                        ex1Desc = "Arrange a pear, spoon, and bottle. Draw ONLY their outer polygon envelopes using 6–10 straight lines each.",
                        ex1Reps = "6 straight-line envelopes",
                        ex1Min = 9,
                        ex2Title = "Two-Pass Curve Carving",
                        ex2Desc = "Use 2H light straight lines for the envelope of 3 mugs/pitchers, then carve smooth curves inside the straight chords with HB.",
                        ex2Reps = "3 two-pass drawings",
                        ex2Min = 9,
                        ex3Title = "Clock-Face Tilt Drill",
                        ex3Desc = "Hold your pencil up to match 8 edges around your room (chair back, monitor corner, lamp arm) and transfer their exact clock angles to paper.",
                        ex3Reps = "12 angled edges measured",
                        ex3Min = 6,
                        challengeTitle = "Complex Ceramic Vase Profile",
                        challengeDesc = "Draw an ornate pitcher or lamp in a 10-line envelope, then refine every S-curve symmetrically.",
                        challengeReps = "1 full-page refinement",
                        challengeMin = 10,
                        mistakes = listOf(
                            "Drawing dark, heavy envelope lines" to "Use a sharp 2H or ultra-light HB grip at the back of the pencil.",
                            "Making too many tiny straight segments" to "Limit the initial envelope to max 8 straight strokes."
                        ),
                        checklist = listOf(
                            "Initial envelope lines stayed light enough to remain secondary.",
                            "Tilt angles match the real object rather than defaulting to vertical/horizontal.",
                            "Final curves touch the straight envelope chords naturally."
                        ),
                        criteria = "Complete 9 envelope constructions and 12 angle-transfer checks.",
                        diagramType = DiagramType.OBSERVATION_CONTOUR,
                        primarySkillId = "sk_contour",
                        reinforcedSkillIds = listOf("sk_sight_prop")
                    )
                )
            ),
            buildUnit(
                1, 2, "w1_u2", "Negative Space & Shape Thinking",
                "Bypass your brain's object labels by drawing the empty shapes trapped between and around forms.",
                listOf(
                    LessonSpec(
                        id = "w1_u2_l1",
                        title = "Trapped Air: Negative Space Shapes",
                        subtitle = "Draw the holes, not the chair",
                        objective = "Identify and draw negative spaces (gaps and background cutouts) as concrete 2D puzzle pieces.",
                        explanation = "Your brain has strong biases about chairs, hands, and bicycles, which distort proportions. Empty air has NO preconceptions. When you draw the exact triangles and trapezoids of air *between* chair legs, the chair itself appears accurately by default.",
                        whyItMatters = "Negative space is the fastest real-time error detector in observational drawing, especially for foreshortened limbs and tangled foliage.",
                        materials = listOf("HB & 2B pencil", "Sketchbook", "Stool, dining chair, or houseplant"),
                        steps = listOf(
                            "Draw a crisp rectangular frame (viewfinder box) on your sketchbook page.",
                            "Pick the clearest enclosed gap inside your subject (like the space between two chair rungs).",
                            "Draw that air shape accurately and lightly shade it flat gray so your eye treats it as solid.",
                            "Build adjacent air shapes outward until they touch the frame edge."
                        ),
                        ex1Title = "Chair Leg Air-Puzzle",
                        ex1Desc = "Set a wooden chair or folding stool against a plain wall. Draw a 12×15 cm box and draw ONLY the trapped spaces between rungs and legs.",
                        ex1Reps = "2 chair angles × 8 minutes",
                        ex1Min = 16,
                        ex2Title = "Hand Window Cutouts",
                        ex2Desc = "Place your free hand on the table with fingers loosely spread or resting on a mug. Draw the triangular air pockets between fingers.",
                        ex2Reps = "4 hand gap studies",
                        ex2Min = 8,
                        ex3Title = "Scissors & Pliers Silhouette Inversion",
                        ex3Desc = "Open scissors at 45°. Shade the background and finger-hole interiors dark, leaving the metal blades pure white paper.",
                        ex3Reps = "3 inverted tool studies",
                        ex3Min = 6,
                        challengeTitle = "Bicycle Frame Negative Space",
                        challengeDesc = "Draw a bicycle or stepladder strictly by mapping every triangle and crescent of background space inside a bordered frame.",
                        challengeReps = "1 complete 15-minute frame study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Switching back to naming the object mid-drawing" to "Turn your reference photo or drawing upside down briefly to see pure abstract shapes.",
                            "Leaving out the outer bounding box" to "Always enclose negative space studies inside a frame so outer background shapes have clear edges."
                        ),
                        checklist = listOf(
                            "I drew a bounding frame before starting each negative space study.",
                            "Gaps between limbs/rungs have believable relative sizes.",
                            "The positive object emerged accurately from the shaded air shapes."
                        ),
                        criteria = "Produce 9 negative-space frames where positive forms read accurately without direct outlining.",
                        diagramType = DiagramType.NEGATIVE_SPACE,
                        primarySkillId = "sk_neg_space"
                    ),
                    LessonSpec(
                        id = "w1_u2_l2",
                        title = "Upside-Down Deconstruction",
                        subtitle = "Shutting off symbolic memory",
                        objective = "Copy complex line compositions inverted to train pure relational shape observation.",
                        explanation = "Drawing an upside-down subject breaks the brain's left-hemisphere habit of labeling 'eye', 'shoe', or 'collar'. Suddenly every line is just a curve, angle, or spacing distance relative to its neighbor.",
                        whyItMatters = "Trains you to measure relationships objectively instead of trusting assumptions—the secret behind faithful portrait and figure accuracy.",
                        materials = listOf("HB pencil", "Sketchbook", "Printed reference or upright object inverted in a mirror/book"),
                        steps = listOf(
                            "Take any detailed line drawing (e.g., a chair, portrait sketch, or still life) in a book or notebook and rotate it 180°.",
                            "Cover 75% of it with a blank sheet so you work strip by strip from top to bottom.",
                            "Talk to yourself purely in geometry: 'this curve drops two units and meets a 30° straight line.'",
                            "Flip both right-side up only after finishing the final line."
                        ),
                        ex1Title = "Inverted Master Line Copy",
                        ex1Desc = "Rotate a simple portrait or figure line sketch upside down. Copy every line relationship without naming facial features.",
                        ex1Reps = "1 full 15-minute inverted study",
                        ex1Min = 15,
                        ex2Title = "Sideways Silhouette Matching",
                        ex2Desc = "Turn a familiar household silhouette (kettle or boot) 90° sideways on a card and draw its abstract curves and negative margins.",
                        ex2Reps = "3 rotated 5-min studies",
                        ex2Min = 15,
                        ex3Title = "Pure Shape Decomposition",
                        ex3Desc = "Look at 3 everyday items normally, but reduce each purely into 2D shapes (circles, triangles, trapezoids) touching one another.",
                        ex3Reps = "6 shape-block thumbnails",
                        ex3Min = 6,
                        challengeTitle = "Upside-Down Draped Coat",
                        challengeDesc = "Hang a jacket over a chair, photograph or sketch a frame, invert your working logic, and draw every fold shape relationally.",
                        challengeReps = "1 complex 15-minute fold study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Flipping the page early to check progress" to "Commit to finishing 100% of the lines before flipping.",
                            "Drawing isolated details in open space" to "Always step from one anchored line directly to an adjacent touching line."
                        ),
                        checklist = listOf(
                            "I kept the drawing inverted until the final stroke.",
                            "I judged line lengths and angles relative to neighboring lines.",
                            "Upon flipping right-side up, proportions held together naturally."
                        ),
                        criteria = "Complete 4 inverted relational studies and 6 shape-decomposition thumbnails.",
                        diagramType = DiagramType.NEGATIVE_SPACE,
                        primarySkillId = "sk_neg_space",
                        reinforcedSkillIds = listOf("sk_contour")
                    ),
                    LessonSpec(
                        id = "w1_u2_l3",
                        title = "Basic 2D Shape Vocabulary",
                        subtitle = "Circles, ovals, triangles & quadrilaterals",
                        objective = "Simplify any chaotic real-world silhouette into clean overlapping 2D geometric shapes.",
                        explanation = "Every complex subject starts flat on paper as interlocking basic 2D shapes: circles, ellipses, rectangles, trapezoids, and triangles. Finding these large 'parent shapes' first prevents getting lost in surface bumps.",
                        whyItMatters = "Simplifying into basic 2D shapes lets you place a whole composition on your page in 60 seconds and check balance before committing.",
                        materials = listOf("2H & HB pencils", "Sketchbook", "Household objects"),
                        steps = listOf(
                            "Squint at your subject to blur small textures.",
                            "Identify the largest primary shape (e.g., a tall rectangle for a lamp base, triangle for shade).",
                            "Attach secondary shapes (circles for joints, trapezoids for spouts) using light overlapping construction."
                        ),
                        ex1Title = "2D Geometric Breakdown Grid",
                        ex1Desc = "Divide a page into 6 boxes. Look at 6 objects in your room and draw ONLY their 2D parent shapes (no shading, no tiny details).",
                        ex1Reps = "6 simplified object breakdowns",
                        ex1Min = 9,
                        ex2Title = "Overlapping Shape Silhouette Chains",
                        ex2Desc = "Group 3 objects together (book + mug + apple). Block all three as overlapping 2D shapes in one unified silhouette.",
                        ex2Reps = "4 grouped thumbnail studies",
                        ex2Min = 8,
                        ex3Title = "Sub-Shape Refinement Pass",
                        ex3Desc = "Take 2 of your 2D shape breakdowns and add medium-level sub-shapes (handle loops, rim ovals, cap cylinders) before outlining.",
                        ex3Reps = "2 refined shape studies",
                        ex3Min = 8,
                        challengeTitle = "Rapid 30-Second Room Scan",
                        challengeDesc = "Spend 30 seconds each capturing 10 different objects across your room purely with 2D shape geometry.",
                        challengeReps = "10 × 30-second thumbnails",
                        challengeMin = 5,
                        mistakes = listOf(
                            "Tracing tiny notches before placing the parent rectangle" to "Always place the largest outer rectangle/oval first.",
                            "Drawing shapes disconnected instead of overlapping" to "Let shapes overlap transparently so joints feel solid."
                        ),
                        checklist = listOf(
                            "Parent shapes cover the overall height-to-width footprint accurately.",
                            "Smaller shapes attach cleanly to the larger shapes.",
                            "No premature surface details were added before proportions matched."
                        ),
                        criteria = "Complete 12 geometric breakdowns and 2 refined multi-shape objects.",
                        diagramType = DiagramType.OBSERVATION_CONTOUR,
                        primarySkillId = "sk_sight_prop",
                        reinforcedSkillIds = listOf("sk_neg_space")
                    )
                )
            ),
            buildUnit(
                1, 3, "w1_u3", "Sight-Measuring & Proportions",
                "Use your pencil as an optical ruler for height-to-width ratios, plumb lines, and alignment.",
                listOf(
                    LessonSpec(
                        id = "w1_u3_l1",
                        title = "Pencil Sighting & Comparative Ratios",
                        subtitle = "Measuring width vs. height accurately",
                        objective = "Measure relative height-to-width ratios from life using straight-arm thumb sighting.",
                        explanation = "Sight-measuring uses your pencil held at full arm's length (elbow locked!) with one eye closed to compare a 'unit' (like a bottle neck or apple width) against larger distances.",
                        whyItMatters = "Without comparative measurement, drawings slowly widen or elongate without you noticing until the page runs out of space.",
                        materials = listOf("Long HB pencil", "Sketchbook", "Tall bottle + short bowl"),
                        steps = listOf(
                            "Lock your elbow straight so your distance from eye to pencil never changes.",
                            "Close one eye, align the pencil tip with the top of a reference unit (e.g., bowl width), and slide your thumb to mark its bottom.",
                            "Rotate your wrist 90° without bending your elbow to check how many 'bowl widths' fit into the bottle's height."
                        ),
                        ex1Title = "Unit-Ratio Calibration Table",
                        ex1Desc = "Measure 5 objects on your desk using your locked-elbow pencil. Write down their true Width:Height ratio (e.g., 1 : 2.3) before drawing.",
                        ex1Reps = "5 measured objects + box plots",
                        ex1Min = 10,
                        ex2Title = "Tall vs. Wide Pair Study",
                        ex2Desc = "Place a tall thermos next to a wide plate. Mark tick marks on paper for top, bottom, left, and right proportional bounds first.",
                        ex2Reps = "3 measured pair drawings",
                        ex2Min = 9,
                        ex3Title = "Tick-Mark Bounding Box Sprint",
                        ex3Desc = "Practice plotting ONLY 4 outer tick marks (top, bottom, left, right) for 5 different room objects using sighting.",
                        ex3Reps = "5 bounding tick plots",
                        ex3Min = 6,
                        challengeTitle = "Full Armchair Proportional Grid",
                        challengeDesc = "Measure seat height, backrest height, and total width of a chair from across the room and build its exact proportional frame.",
                        challengeReps = "1 complete measured frame",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Bending the elbow between measurements" to "Keep shoulder forward and elbow fully straight every single measurement.",
                            "Keeping both eyes open" to "Close your non-dominant eye so double-vision parallax doesn't shift your thumb."
                        ),
                        checklist = listOf(
                            "I kept my elbow locked at a consistent distance on every measurement.",
                            "I plotted light top/bottom/left/right tick marks before drawing details.",
                            "My drawn height-to-width ratio matches the measured unit ratio."
                        ),
                        criteria = "Measure and draw 8 proportional setups with documented unit ratios.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_sight_prop"
                    ),
                    LessonSpec(
                        id = "w1_u3_l2",
                        title = "Plumb Lines & Horizontal Alignments",
                        subtitle = "Checking what lines up vertically and horizontally",
                        objective = "Use imaginary vertical plumb lines and horizontal level checks to align features accurately.",
                        explanation = "A plumb line drops straight down vertically; a level line runs strictly horizontal. Checking 'If I drop a vertical line from this corner, what does it hit below?' instantly catches leaning bottles and crooked portraits.",
                        whyItMatters = "Plumb lines anchor every complex scene to gravity so objects sit naturally rather than tilting sideways.",
                        materials = listOf("HB pencil", "Sketchbook", "3-object tabletop arrangement"),
                        steps = listOf(
                            "Hold your pencil perfectly vertical against a key landmark (like the tip of a spout or corner of a table).",
                            "Observe every point above and below that aligns on that same vertical line.",
                            "Lightly ghost that vertical plumb guideline on your paper before placing connected elements.",
                            "Repeat horizontally across the scene to see which heights match."
                        ),
                        ex1Title = "3-Object Plumb Map",
                        ex1Desc = "Arrange a spoon, mug, and apple overlapping slightly. Draw 3 faint vertical plumb lines and 3 horizontal level lines connecting key landmarks.",
                        ex1Reps = "3 mapped still-life layouts",
                        ex1Min = 12,
                        ex2Title = "Room Corner Vertical Anchors",
                        ex2Desc = "Look toward a corner of your room with furniture. Use plumb checks to verify where a chair leg sits relative to a window frame above it.",
                        ex2Reps = "2 room-corner alignments",
                        ex2Min = 8,
                        ex3Title = "Tilted Object Gravity Check",
                        ex3Desc = "Lean a book against a mug. Drop a plumb line from the top corner of the tilted book to locate where its base meets the table.",
                        ex3Reps = "3 leaning object alignments",
                        ex3Min = 6,
                        challengeTitle = "Bookshelf Corner Alignment Study",
                        challengeDesc = "Draw a section of a cluttered shelf using at least 6 faint plumb and level reference lines before outlining any item.",
                        challengeReps = "1 full 15-minute shelf study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Tilting the pencil slightly while checking vertical" to "Compare your pencil edge directly against the vertical edge of a doorframe or wall corner.",
                            "Skipping horizontal checks" to "Pair every vertical plumb check with at least one horizontal eye-level check."
                        ),
                        checklist = listOf(
                            "Vertical guidelines remain straight relative to my page edges.",
                            "Leaning angles were verified against vertical plumb lines.",
                            "Objects align with each other spatially rather than floating independently."
                        ),
                        criteria = "Complete 8 plumb-and-level alignment drawings with visible light construction guides.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_sight_prop",
                        reinforcedSkillIds = listOf("sk_neg_space")
                    ),
                    LessonSpec(
                        id = "w1_u3_l3",
                        title = "Angle Transfer & Triangulation",
                        subtitle = "Locking points in 2D space by triangle",
                        objective = "Locate any floating landmark accurately using triangle angles from two known points.",
                        explanation = "If you know Point A and Point B accurately, you can pinpoint Point C by measuring the tilt angle from A-to-C and B-to-C. Where those two rays cross is Point C's exact home!",
                        whyItMatters = "Triangulation eliminates guesswork when spacing eyes on a face or positioning distant trees and buildings.",
                        materials = listOf("2H & HB pencils", "Sketchbook"),
                        steps = listOf(
                            "Establish one crisp baseline (two known points, like left and right sides of a box base).",
                            "Sight the angle from Point A to your target Point C and lightly extend that ray.",
                            "Sight the angle from Point B to Point C and extend it until the rays intersect."
                        ),
                        ex1Title = "3-Dot Triangulation Accuracy Drill",
                        ex1Desc = "Place 3 random objects on your desk (eraser, coin, sharpener). Sight and triangulate their exact 2D triangle footprint on paper.",
                        ex1Reps = "5 triangular desk maps",
                        ex1Min = 10,
                        ex2Title = "Asymmetric Mug & Spoon Triangulation",
                        ex2Desc = "Place a spoon diagonally in front of a mug. Triangulate both ends of the spoon from the mug's top and bottom corners.",
                        ex2Reps = "3 triangulated compositions",
                        ex2Min = 9,
                        ex3Title = "Contour + Triangulation Hybrid",
                        ex3Desc = "Triangulate 5 key anchor points on a lamp or kettle first, then connect them using modified contour observation.",
                        ex3Reps = "2 hybrid studies",
                        ex3Min = 8,
                        challengeTitle = "Multi-Item Desk Cluster Map",
                        challengeDesc = "Draw 5 scattered stationery items across a full page using triangulation rays so every gap distance is faithful.",
                        challengeReps = "1 full-page precision map",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Guessing distances without intersecting two rays" to "Always confirm a landmark from TWO separate anchor points.",
                            "Moving your head position while sighting" to "Keep your head steady like it is resting against an invisible headrest."
                        ),
                        checklist = listOf(
                            "Light triangulation rays intersect cleanly at landmarks.",
                            "Distances between separated items feel natural and true to life.",
                            "I kept my head still while transferring angles."
                        ),
                        criteria = "Finish 10 triangulated plots and hybrid observational drawings.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_sight_prop",
                        reinforcedSkillIds = listOf("sk_contour")
                    )
                )
            ),
            buildUnit(
                1, 4, "w1_u4", "Observational Integration",
                "Combine contour, negative space, and sighting into cohesive real-world observational drawings.",
                listOf(
                    LessonSpec(
                        id = "w1_u4_l1",
                        title = "Thumbnail Framing & Placement",
                        subtitle = "Planning the page before committing",
                        objective = "Compose small 4×5 cm framing thumbnails to avoid running off the edge of the paper.",
                        explanation = "Jumping straight into a large drawing often crops off handles, feet, or top edges. Drawing a tiny 60-second thumbnail box guarantees the whole subject fits harmoniously before scaling up.",
                        whyItMatters = "Saves hours of wasted effort and introduces intentional page composition from day one.",
                        materials = listOf("HB pencil", "Sketchbook", "Cardboard L-frame viewfinder (optional)"),
                        steps = listOf(
                            "Draw 3 small 4×5 cm boxes at the corner of your page.",
                            "Try 3 crops of your subject inside them (close-up, centered, off-center).",
                            "Choose the strongest thumbnail and transfer its proportional grid lines onto your main page."
                        ),
                        ex1Title = "3-Crop Thumbnail Exploration",
                        ex1Desc = "Choose one corner of your room or desk. Sketch 3 distinct miniature thumbnails shifting crop and zoom.",
                        ex1Reps = "6 thumbnails across 2 subjects",
                        ex1Min = 9,
                        ex2Title = "Thumbnail-to-Page Scale Up",
                        ex2Desc = "Pick your favorite thumbnail, lightly divide both thumbnail and main box into quarters, and transfer the major shapes accurately.",
                        ex2Reps = "2 scaled observational blocks",
                        ex2Min = 10,
                        ex3Title = "Margin Respect Drill",
                        ex3Desc = "Draw 4 objects ensuring every object leaves clean breathing margins on all 4 sides without touching page edges.",
                        ex3Reps = "4 framed object studies",
                        ex3Min = 8,
                        challengeTitle = "Window View Composition Sheet",
                        challengeDesc = "Create 4 varied thumbnails of the view through your window, then execute a clean contour + sighting drawing of the best one.",
                        challengeReps = "4 thumbnails + 1 main study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Making thumbnails as detailed as final drawings" to "Keep thumbnails to 3–5 major shapes in under 60 seconds each.",
                            "Ignoring empty margins" to "Treat the outer empty margin as active negative space."
                        ),
                        checklist = listOf(
                            "No part of my scaled drawing accidentally clipped the page edge.",
                            "Thumbnails explored different croppings before committing.",
                            "Quarter-grid transfer kept placement balanced."
                        ),
                        criteria = "Complete 6 thumbnails, 2 scaled transfers, and 4 framed margin studies.",
                        diagramType = DiagramType.NEGATIVE_SPACE,
                        primarySkillId = "sk_neg_space",
                        reinforcedSkillIds = listOf("sk_sight_prop")
                    ),
                    LessonSpec(
                        id = "w1_u4_l2",
                        title = "Correcting Proportions Without Fear",
                        subtitle = "Restating light lines instead of erasing",
                        objective = "Use light exploratory lines and clean restatement strokes to self-correct accurately.",
                        explanation = "Constant erasing slows observation and damages paper tooth. Keeping early lines light allows you to visibly compare your mistaken line against the new corrected line—making your eye smarter.",
                        whyItMatters = "Visible comparison trains proportional calibration twice as fast as erasing every mistake immediately.",
                        materials = listOf("2H, HB, and 2B pencils", "Sketchbook", "Kneaded eraser (cleanup only at end)"),
                        steps = listOf(
                            "Block the entire subject lightly with 2H without touching an eraser.",
                            "Stand back 50 cm, compare plumb lines and negative spaces, and lightly restate corrected contours right next to the old ones.",
                            "Only once the proportions lock together, commit your final crisp line with HB/2B."
                        ),
                        ex1Title = "No-Eraser Correction Study",
                        ex1Desc = "Put your eraser across the room. Draw a teapot, shoe, or backpack using light ghost strokes, actively correcting mistakes with cleaner second and third passes.",
                        ex1Reps = "2 full 10-minute studies",
                        ex1Min = 20,
                        ex2Title = "Error-Spotting Comparison",
                        ex2Desc = "Draw an object in 3 minutes, then stop and circle 3 proportional errors using a red/blue pencil or dashed marks, and redraw cleanly beside it.",
                        ex2Reps = "2 draw-critique-redraw pairs",
                        ex2Min = 12,
                        ex3Title = "Pressure Staircase Warmup",
                        ex3Desc = "Draw 3 copies of a simple bottle: Pass 1 barely visible, Pass 2 structural refinement, Pass 3 bold selective final edges.",
                        ex3Reps = "3 layered line passes",
                        ex3Min = 6,
                        challengeTitle = "Back-to-Back Iteration Sprint",
                        challengeDesc = "Draw the same complex object 3 times in a row (4 min, 5 min, 7 min), fixing one specific proportional flaw each round.",
                        challengeReps = "3 iterative studies",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Pressing hard on Pass 1" to "Hold the pencil halfway up the barrel for Pass 1 so physical pressure stays light.",
                            "Getting discouraged by messy search lines" to "Search lines are scaffolding—only the final Pass 3 ink/2B line defines the finished image."
                        ),
                        checklist = listOf(
                            "I resisted erasing during initial proportional placement.",
                            "I identified and corrected specific angle/ratio errors between passes.",
                            "My final pass stands out clearly above the light construction lines."
                        ),
                        criteria = "Complete 2 no-eraser studies, 2 critique-redraw pairs, and 3 pressure passes.",
                        diagramType = DiagramType.OBSERVATION_CONTOUR,
                        primarySkillId = "sk_contour",
                        reinforcedSkillIds = listOf("sk_sight_prop")
                    ),
                    LessonSpec(
                        id = "w1_u4_l3",
                        title = "Complete Observational Line Study",
                        subtitle = "Bringing World 1 skills together",
                        objective = "Execute a clean, accurately proportioned contour drawing of a multi-part subject from life.",
                        explanation = "This capstone lesson weaves everything in World 1 into one calm workflow: Thumbnail → Envelope & Sighting → Negative Space Verification → Modified Contour Refinement.",
                        whyItMatters = "Proves you can look at any real-world subject and translate its 2D proportions onto paper reliably.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook", "Desk lamp or potted plant + mug"),
                        steps = listOf(
                            "Create two 45-second thumbnails to pick your framing.",
                            "Plot top/bottom/left/right tick marks and light plumb/level alignments.",
                            "Check 2 key negative-space cutouts to verify gaps.",
                            "Commit smooth, observant modified contours with deliberate HB/2B line clarity."
                        ),
                        ex1Title = "2-Thumbnail & Tick Setup",
                        ex1Desc = "Set up a 2-object pair on your desk. Create 2 thumbnails and build the light proportional envelope on a fresh full page.",
                        ex1Reps = "2 thumbnails + 1 light scaffold",
                        ex1Min = 8,
                        ex2Title = "Negative Space & Plumb Audit",
                        ex2Desc = "Before drawing final contours, check and mark at least 3 plumb alignments and 2 trapped negative space shapes inside your scaffold.",
                        ex2Reps = "1 audited construction scaffold",
                        ex2Min = 6,
                        ex3Title = "Final Observational Contour Pass",
                        ex3Desc = "Complete the drawing with confident modified contour observation and selective line emphasis on outer silhouettes.",
                        ex3Reps = "1 finished line drawing",
                        ex3Min = 12,
                        challengeTitle = "15-Minute Corner Still Life",
                        challengeDesc = "Add a 3rd overlapping item (like eyeglasses or folded cloth) and repeat the full 4-stage observational workflow.",
                        challengeReps = "1 three-object observational plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Rushing straight to contour details before checking plumb lines" to "Spend at least the first 40% of time strictly on placement and sighting.",
                            "Uniformly heavy lines everywhere" to "Keep construction lines faint and let outer silhouettes carry clean weight."
                        ),
                        checklist = listOf(
                            "I followed Thumbnail -> Sighting -> Negative Space -> Contour in order.",
                            "Proportions match my measured height-to-width ratios.",
                            "Overlapping edges read clearly without confusing tangents."
                        ),
                        criteria = "Complete the 4-stage observational workflow cleanly to unlock World 1's Milestone Project.",
                        diagramType = DiagramType.STILL_LIFE_SIGHTING,
                        primarySkillId = "sk_sight_prop",
                        reinforcedSkillIds = listOf("sk_eye_hand", "sk_contour", "sk_neg_space")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w1",
            worldNumber = 1,
            title = "Observational Desk Study Plate",
            brief = "Draw an arrangement of 3 everyday objects on your desk (such as a mug, scissors/keys, and a small bottle or shoe) purely in line, using thumbnails, plumb lines, negative space checks, and modified contours.",
            combinedSkills = listOf("Hand-Eye Tracking", "Contour Observation", "Negative Space", "Sight-Measuring"),
            requiredMaterials = listOf("2H & HB pencils", "Clean A4/A5 sketchbook page", "3 real desk objects"),
            phases = listOf(
                "Phase 1 (3 min): Sketch two 4×5 cm framing thumbnails and select the strongest layout.",
                "Phase 2 (7 min): Plot light proportional tick marks, 2H envelopes, and vertical/horizontal plumb alignments.",
                "Phase 3 (5 min): Verify trapped negative space shapes between objects and adjust any drifting edges.",
                "Phase 4 (15 min): Execute slow, observant modified contour lines with crisp HB line clarity."
            ),
            selfAssessmentChecklist = listOf(
                "All 3 objects fit inside the page with balanced breathing margins.",
                "Objects sit believably on the same table plane without floating.",
                "Negative space gaps match the real arrangement accurately.",
                "Contours reflect real subtle curves instead of generic circles or straight boxes."
            ),
            estimatedMinutes = 30,
            xpReward = 120
        )
    ),

    // WORLD 2: BASIC FORMS
    DrawingWorld(
        number = 2,
        id = "world_2",
        title = "Basic Forms",
        tagline = "Think in three-dimensional volume, not flat outlines",
        focusSummary = "Master cubes, spheres, cylinders, cones, cross-contours, and intersecting 3D forms so every subject carries real spatial weight.",
        unlockRequirementSummary = "Complete World 1 Milestone & reach Practicing in Observation skills",
        units = listOf(
            buildUnit(
                2, 1, "w2_u1", "Cubes, Boxes & Spatial Rotation",
                "Build the single most important form in drawing—the 3D box—from every angle.",
                listOf(
                    LessonSpec(
                        id = "w2_u1_l1",
                        title = "Anatomy of a 3D Box (Y-Method)",
                        subtitle = "Constructing rotated cubes cleanly",
                        objective = "Construct transparent 3D boxes using the initial Y-corner method with parallel/converging sets.",
                        explanation = "Every box viewed from an angle starts with a 'Y' at its closest corner: one vertical spine and two upward-tilted arms (>90° between arms so the box doesn't distort). From those 3 edges, all remaining edges fall into 3 parallel/converging families.",
                        whyItMatters = "Boxes represent orientation, tilt, and depth in space—everything from houses to human ribcages can be boxed in first.",
                        materials = listOf("HB pencil or 0.5mm fineliner", "Sketchbook", "Small cardboard box for visual reference"),
                        steps = listOf(
                            "Draw a central vertical line and two upward-angled arms forming a 'Y' (keep all 3 angles around the center > 90°).",
                            "Extend the outer edges converging gently back toward three implied directions.",
                            "Draw THROUGH the box: lightly plot the 3 hidden back edges and back corner so the box is fully transparent."
                        ),
                        ex1Title = "Y-Corner Angle Variation Grid",
                        ex1Desc = "Draw 12 initial Y-corners across a page, varying the height/tilt of the arms—keep every angle > 90°.",
                        ex1Reps = "12 Y-starts",
                        ex1Min = 6,
                        ex2Title = "Transparent Draw-Through Boxes",
                        ex2Desc = "Complete 8 rotated boxes showing all 12 edges (front + hidden back edges) cleanly.",
                        ex2Reps = "8 transparent boxes",
                        ex2Min = 12,
                        ex3Title = "Ruler Convergence Self-Audit",
                        ex3Desc = "Use a ruler and pencil/pen to lightly extend each box's 3 edge families outward to check whether they converge or mistakenly flare apart.",
                        ex3Reps = "8 audited boxes",
                        ex3Min = 6,
                        challengeTitle = "15-Box Extreme Tilt Sheet",
                        challengeDesc = "Draw 15 boxes including steep worm's-eye (looking up) and bird's-eye (looking down) rotations.",
                        challengeReps = "15 varied-angle boxes",
                        challengeMin = 15,
                        mistakes = listOf(
                            "One Y-angle narrower than 90°" to "Check that all three angles at the front corner look open/obtuse to prevent fish-eye warping.",
                            "Back edges flaring wider than front edges" to "Remember: edges moving away from the viewer MUST stay parallel or get closer together, never diverge."
                        ),
                        checklist = listOf(
                            "Every box shows all 12 edges (drawn transparently through the form).",
                            "Angles at the front Y-corner stay greater than 90°.",
                            "Opposite edges converge toward shared directions rather than spreading apart."
                        ),
                        criteria = "Draw 8 transparent boxes and verify convergence directions with extension checks.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_cubes"
                    ),
                    LessonSpec(
                        id = "w2_u1_l2",
                        title = "Rotating & Proportional Boxes",
                        subtitle = "Bricks, slabs, and thin planes",
                        objective = "Control box proportions (cubes, planks, tall pillars) while rotating them naturally in 3D space.",
                        explanation = "Real objects are rarely perfect 1:1:1 cubes. A book is a flat slab; a fridge is a tall column; a table top is a wafer plane. Rotating non-cube boxes trains your brain to track foreshortening across unequal side lengths.",
                        whyItMatters = "Prepares you directly for architectural masses, still-life proportions, and mannequin torso blocks.",
                        materials = listOf("HB pencil", "Sketchbook", "A paperback book or cereal box"),
                        steps = listOf(
                            "Choose a specific proportion before drawing (e.g., 1:3:0.5 book slab).",
                            "Establish the Y-corner with matching short, medium, and long edge ratios.",
                            "Check foreshortening: faces turned away from you appear compressed compared to faces facing you."
                        ),
                        ex1Title = "Book-Slab Rotation Sequence",
                        ex1Desc = "Place a paperback book at 4 angles (flat, tilted, standing upright, seen from end-on) and draw all 4 transparently.",
                        ex1Reps = "4 rotated book slabs",
                        ex1Min = 10,
                        ex2Title = "Brick & Pillar Variations",
                        ex2Desc = "Draw 6 tall pillars and 6 flat bricks at varied rotations across one sheet, keeping opposite faces convincing.",
                        ex2Reps = "12 varied-ratio boxes",
                        ex2Min = 12,
                        ex3Title = "Stacking Two Boxes",
                        ex3Desc = "Draw a smaller rotated box resting squarely on top of a larger slab box—verify their contact plane shares orientation.",
                        ex3Reps = "4 stacked pairs",
                        ex3Min = 8,
                        challengeTitle = "Open Hinged Box Lid",
                        challengeDesc = "Draw a cardboard box with its top flaps bent open at 45° and 120° angles in space.",
                        challengeReps = "2 open-flap box studies",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing top faces too tall even when seen nearly edge-on" to "When a face approaches eye level, compress its visible depth sharply.",
                            "Floating stacked boxes" to "Draw the full top face of the bottom box first, then plant the upper box's footprint directly inside it."
                        ),
                        checklist = listOf(
                            "Proportions clearly read as slabs, bricks, or pillars rather than generic cubes.",
                            "Foreshortened faces look visually compressed.",
                            "Stacked boxes sit solidly on the supporting top face."
                        ),
                        criteria = "Complete 16 proportional rotated boxes and 4 stacked pairs.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_cubes"
                    ),
                    LessonSpec(
                        id = "w2_u1_l3",
                        title = "Carving & Subdividing Boxes",
                        subtitle = "Bevels, notches, and sloped roofs",
                        objective = "Find centers of perspective faces and carve crisp wedges, ramps, and notches out of solid boxes.",
                        explanation = "Drawing an X from corner to corner on any perspective face locates its true perspective center. From there, you can slice off corners, cut notches, or raise pitched roofs cleanly.",
                        whyItMatters = "Turns simple boxes into cars, furniture, houses, and mechanical parts.",
                        materials = listOf("2H & HB pencils", "Sketchbook"),
                        steps = listOf(
                            "Draw a transparent 3D box.",
                            "Draw light X-diagonals across the front and back faces to find exact midpoints.",
                            "Connect midpoints to carve a diagonal wedge/ramp or remove a recessed corner notch."
                        ),
                        ex1Title = "Center-Finding & Roof Peaks",
                        ex1Desc = "Draw 6 transparent boxes, find the front/back centers with X-diagonals, raise a center peak, and turn each into a pitched roof block.",
                        ex1Reps = "6 roof-carved boxes",
                        ex1Min = 10,
                        ex2Title = "Corner Notch Subtraction",
                        ex2Desc = "Draw 4 large boxes and carve L-shaped step notches out of one top corner, drawing the new inner planes cleanly.",
                        ex2Reps = "4 notched blocks",
                        ex2Min = 10,
                        ex3Title = "Bevel & Ramp Slices",
                        ex3Desc = "Slice one edge off 4 boxes at a 45° chamfer angle, keeping front and back slice edges parallel in perspective.",
                        ex3Reps = "4 chamfered wedges",
                        ex3Min = 8,
                        challengeTitle = "L-Shaped Staircase Block",
                        challengeDesc = "Construct a 3-step staircase carved out of a single large rectangular block using perspective guidelines.",
                        challengeReps = "2 multi-step blocks",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Guessing the center halfway by ruler instead of perspective X-diagonals" to "Always cross corner-to-corner; perspective shifts the visual center slightly back.",
                            "Forgetting the hidden inner lines of a carved notch" to "Draw the sliced interior planes cleanly so the cut feels solid."
                        ),
                        checklist = listOf(
                            "X-diagonals locate the perspective centers of faces.",
                            "Carved ramps and notches remain aligned with the parent box.",
                            "Cut surfaces look flat and solid."
                        ),
                        criteria = "Complete 14 carved/subdivided box constructions.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_cubes"
                    )
                )
            ),
            buildUnit(
                2, 2, "w2_u2", "Ellipses, Cylinders & Cones",
                "Control ellipse degrees and align circular forms smoothly along 3D minor axes.",
                listOf(
                    LessonSpec(
                        id = "w2_u2_l1",
                        title = "Ellipse Mechanics & Minor Axis",
                        subtitle = "Why circles flatten cleanly in space",
                        objective = "Draw smooth, symmetrical ellipses through 2–3 passes aligned perpendicularly to a chosen minor axis.",
                        explanation = "A circle seen at an angle becomes an ellipse. Every ellipse has a Major Axis (widest span) and a Minor Axis (narrowest span). Crucially, the Minor Axis ALWAYS acts like the axle sticking straight out of a wheel or cylinder center!",
                        whyItMatters = "Misaligned ellipses make cups, tires, and necks look crooked or melted. Mastering the minor axis locks circular forms into perspective.",
                        materials = listOf("HB pencil or 0.5mm fineliner", "Sketchbook"),
                        steps = listOf(
                            "Draw a straight central spine line (the Minor Axis).",
                            "Ghost an oval smoothly around that spine from your shoulder, making sure the spine cuts the oval into two identical halves.",
                            "Draw through the ellipse 2 full loops in one continuous fluid motion—never stop halfway or draw pointed football tips."
                        ),
                        ex1Title = "Degree-Progression Rows",
                        ex1Desc = "Draw 3 rows of 8 ellipses along vertical spines, gradually opening from razor-thin 15° slivers up to full 90° circles.",
                        ex1Reps = "24 ellipses (3 degree rows)",
                        ex1Min = 8,
                        ex2Title = "Tilted-Axle Ellipse Alignment",
                        ex2Desc = "Draw 10 tilted axle lines at random angles. Draw 2 ellipses per axle, ensuring the spine cleanly bisects every ellipse at 90° to its major width.",
                        ex2Reps = "20 axle-aligned ellipses",
                        ex2Min = 9,
                        ex3Title = "Ellipses Inside Skewed Planes",
                        ex3Desc = "Draw 8 flat perspective planes (parallelograms) and fit ellipses inside each so they touch all 4 midpoints cleanly.",
                        ex3Reps = "8 plane-bound ellipses",
                        ex3Min = 8,
                        challengeTitle = "Concentric Target Ellipses",
                        challengeDesc = "Draw 6 tilted planes and nest 3 concentric ellipses inside each with evenly shrinking spacing.",
                        challengeReps = "6 nested ellipse targets",
                        challengeMin = 10,
                        mistakes = listOf(
                            "Pointed 'almond' or 'football' corners" to "Round out the tight turns; keep shoulder motion sweeping smoothly around both ends.",
                            "Drawing slowly with wrist wobble" to "Ghost 3 passes in the air first, then commit 2 brisk passes onto paper."
                        ),
                        checklist = listOf(
                            "Ellipses have rounded, smooth ends with no sharp corners.",
                            "The minor axis cuts every ellipse into mirror-image halves.",
                            "Passes stay tight (2–3 loops) without stray scribbling."
                        ),
                        criteria = "Complete 52 controlled ellipses demonstrating varied degrees and accurate axle symmetry.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_spheres_cyl"
                    ),
                    LessonSpec(
                        id = "w2_u2_l2",
                        title = "Cylinders & Degree Shift in Space",
                        subtitle = "Connecting two ellipses with a true spine",
                        objective = "Construct transparent 3D cylinders where the far ellipse opens wider in degree than the near ellipse.",
                        explanation = "As a cylinder tilts away or toward you, its far circular face sits at a slightly steeper viewing angle than the near face—so the back ellipse is always slightly wider (fatter degree) than the front ellipse, and both share the exact same central minor axis.",
                        whyItMatters = "Arms, legs, tree trunks, mugs, pipes, and necks are all cylinders. Nailing cylinder degree shift instantly creates depth.",
                        materials = listOf("HB pencil", "Sketchbook", "Paper towel tube or mug for reference"),
                        steps = listOf(
                            "Draw a straight central spine (the cylinder's axis) and plot two crossbars for front and back centers.",
                            "Draw the near ellipse perpendicular to the spine.",
                            "Draw the far ellipse slightly wider in degree, also centered on the exact same spine.",
                            "Connect the outermost tangent edges smoothly on both sides."
                        ),
                        ex1Title = "Floating Axis Cylinders",
                        ex1Desc = "Draw 10 cylinders pointing in varied directions across the page. Draw through both ellipses completely.",
                        ex1Reps = "10 full transparent cylinders",
                        ex1Min = 12,
                        ex2Title = "Degree-Shift Check",
                        ex2Desc = "Draw 4 dramatic foreshortened cylinders (almost facing straight at you, like pointing a telescope). Exaggerate how narrow the near cap is vs. wider far cap.",
                        ex2Reps = "4 extreme foreshortened cylinders",
                        ex2Min = 8,
                        ex3Title = "Stepped & Tapered Tubes",
                        ex3Desc = "Stack 3 cylinders of decreasing radius on a shared axis (like a telescope or stacked cake).",
                        ex3Reps = "3 concentric stacked forms",
                        ex3Min = 7,
                        challengeTitle = "Bent & Curved Pipe Tubes",
                        challengeDesc = "Draw a curved S-line spine and string 5 tilted ellipses along the curve so it bends like a flexible hose.",
                        challengeReps = "3 curved organic tubes",
                        challengeMin = 10,
                        mistakes = listOf(
                            "Making the far ellipse narrower than the near ellipse" to "Check real perspective with a mug: as a rim drops below eye level, the ellipse opens wider.",
                            "Flat straight lines instead of rounded bottom curves" to "Never draw a flat bottom edge on a cylinder—keep the bottom curve continuous."
                        ),
                        checklist = listOf(
                            "Both end ellipses sit symmetrically on the central spine line.",
                            "Far ellipse is visibly wider in degree than the near ellipse.",
                            "Side edges meet the ellipses tangentially without pinching."
                        ),
                        criteria = "Construct 17 transparent cylinders across varied angles and foreshortening depths.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_spheres_cyl"
                    ),
                    LessonSpec(
                        id = "w2_u2_l3",
                        title = "Spheres & Cones in 3D Space",
                        subtitle = "Turning flat circles into round volumes",
                        objective = "Give spheres and cones unmistakable 3D volume using axial rings and conical bases.",
                        explanation = "A plain circle looks totally flat like a coin. Adding an internal equatorial ellipse (like Earth's equator) and vertical meridian immediately turns that circle into a tilted globe. A cone simply connects a cylinder's base ellipse cleanly to an apex point along its axis.",
                        whyItMatters = "Spheres underlie heads, apples, eyeballs, and shoulder joints; cones govern lampshades, pine trees, and horns.",
                        materials = listOf("HB pencil", "Sketchbook"),
                        steps = listOf(
                            "For a sphere: ghost a clean circle, choose a tilt axis, and wrap two perpendicular equatorial ellipses cleanly around its surface.",
                            "For a cone: draw an axis spine, construct the base ellipse at one end, mark the tip apex on the spine, and draw tangents from the tip to the ellipse's widest shoulders."
                        ),
                        ex1Title = "Globe Axis Spheres",
                        ex1Desc = "Draw 8 circles and transform each into a sphere tilted at a different angle by wrapping an equator and meridian ellipse around it.",
                        ex1Reps = "8 tilted globe spheres",
                        ex1Min = 10,
                        ex2Title = "Rotated Cones & Frustums",
                        ex2Desc = "Draw 6 pointed cones and 4 sliced cones (frustums like paper cups) pointing up, sideways, and toward you.",
                        ex2Reps = "10 conical constructions",
                        ex2Min = 10,
                        ex3Title = "Ice-Cream & Cup Hybrids",
                        ex3Desc = "Combine a sphere resting cleanly inside a cone or cylinder rim, drawing through the hidden overlap ring.",
                        ex3Reps = "4 combined sphere-cone studies",
                        ex3Min = 7,
                        challengeTitle = "Sphere Divided Into 8 Wedges",
                        challengeDesc = "Draw a large sphere and divide it cleanly with 4 longitude ellipses (like peeled orange segments).",
                        challengeReps = "2 multi-meridian spheres",
                        challengeMin = 10,
                        mistakes = listOf(
                            "Equator ellipse stopping shy of the sphere's outer edge" to "Wrap the ellipse curve cleanly all the way to the sphere boundary and tuck around it.",
                            "Cone tangent lines meeting the ellipse ends awkwardly" to "Connect cone sides slightly above/past the sharp tips so the silhouette transitions smoothly."
                        ),
                        checklist = listOf(
                            "Equator ellipses wrap smoothly all the way to the sphere rim.",
                            "Cone apex lines up squarely along the base ellipse's minor axis.",
                            "Spheres read unmistakably as 3D balls rather than flat coins."
                        ),
                        criteria = "Complete 8 globe spheres, 10 cones, and 4 combined sphere-cone studies.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_spheres_cyl",
                        reinforcedSkillIds = listOf("sk_cross_contour")
                    )
                )
            ),
            buildUnit(
                2, 3, "w2_u3", "Organic Forms & Cross-Contours",
                "Wrap surface contour bands around rounded and organic volumes to feel curvature in 3D.",
                listOf(
                    LessonSpec(
                        id = "w2_u3_l1",
                        title = "Organic Sausage Forms",
                        subtitle = "Inflated cylinders that bend naturally",
                        objective = "Draw smooth, rounded organic cylinder-blobs ('sausages') without pinching, flattening, or awkward joints.",
                        explanation = "Real bodies, roots, clouds, and limbs aren't rigid pipes—they are flexible, inflated organic sausages. Learning to keep them simple with rounded ends and consistent width builds the bedrock for figure drawing.",
                        whyItMatters = "Bridges rigid geometry (boxes/cylinders) with living organic forms (muscles, branches, animals).",
                        materials = listOf("HB pencil or 0.5mm fineliner", "Sketchbook"),
                        steps = listOf(
                            "Ghost a single smooth, curving silhouette in two long strokes—avoid wavy noodle shapes or pinched waists.",
                            "Keep both ends smoothly rounded like hemispherical caps.",
                            "Mark a light central flow line running down the middle of the sausage."
                        ),
                        ex1Title = "2-Page Sausage Flow Sheet",
                        ex1Desc = "Fill one full page with 12–15 simple, gently curved organic forms of varied sizes—aim for inflated volume, no sharp pinches.",
                        ex1Reps = "14 clean organic forms",
                        ex1Min = 9,
                        ex2Title = "Contour-Ellipse Stuffed Sausages",
                        ex2Desc = "Draw 8 bent sausages and place 5–6 transparent contour ellipses along their spine, shifting ellipse degree as the form turns toward or away.",
                        ex2Reps = "8 contoured forms",
                        ex2Min = 10,
                        ex3Title = "Contour-Curve Only (Visible Side)",
                        ex3Desc = "Draw 6 organic forms and wrap ONLY the front-facing contour curves, hooking each curve firmly around the silhouette edge.",
                        ex3Reps = "6 hooked contour forms",
                        ex3Min = 8,
                        challengeTitle = "Piled Organic Bean Cluster",
                        challengeDesc = "Stack 6 soft sausage forms draping over one another with gravity, maintaining solid overlapping silhouettes.",
                        challengeReps = "2 draped bean piles",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Flat straight contour lines across a rounded tube" to "Hook the ends of every contour curve tightly back around the silhouette boundary.",
                            "Making sausages overly wavy like ribbons" to "Stick to simple C-curves and slight S-bends with even width."
                        ),
                        checklist = listOf(
                            "Contour curves hook distinctly around the outer edges rather than ending flat.",
                            "Ellipse degrees widen or narrow consistently along each bend.",
                            "Forms look plump and inflated rather than deflated."
                        ),
                        criteria = "Complete 28 organic form studies with hooked cross-contours.",
                        diagramType = DiagramType.CROSS_CONTOUR,
                        primarySkillId = "sk_cross_contour"
                    ),
                    LessonSpec(
                        id = "w2_u3_l2",
                        title = "Cross-Contour Grids on Complex Forms",
                        subtitle = "Topographic wireframes on real objects",
                        objective = "Map longitudinal and latitudinal wireframe bands across irregular real-world objects.",
                        explanation = "Imagine draping a stretchy fishnet stocking over a pepper, pear, or shoe. Drawing those wrapping topographic lines teaches your hand to ride *over* hills and dip *into* valleys.",
                        whyItMatters = "If you can trace cross-contours across a surface, your shading strokes later will automatically sculpt 3D volume.",
                        materials = listOf("2H & HB pencils", "Sketchbook", "Bell pepper, pear, or sneaker"),
                        steps = listOf(
                            "Draw the clean outer silhouette of your organic object.",
                            "Trace vertical longitude lines running from stem/top down to the base following surface bumps.",
                            "Add horizontal latitude rings wrapping around the object to complete the 3D wireframe."
                        ),
                        ex1Title = "Bell Pepper or Pear Wireframe",
                        ex1Desc = "Place a bumpy fruit/vegetable in front of you. Draw its outline lightly, then trace 6 longitude and 5 latitude cross-contours.",
                        ex1Reps = "2 full wireframe fruit studies",
                        ex1Min = 12,
                        ex2Title = "Shoe & Hat Topographic Map",
                        ex2Desc = "Draw a baseball cap or sneaker and wrap cross-contour rings across the toe box, tongue, and arch.",
                        ex2Reps = "2 complex object wireframes",
                        ex2Min = 12,
                        ex3Title = "2D Blob to 3D Terrain",
                        ex3Desc = "Draw 4 random amoeba shapes on paper, then invent convincing 3D hills and craters inside them purely using cross-contours.",
                        ex3Reps = "4 invented terrain blobs",
                        ex3Min = 6,
                        challengeTitle = "Arm & Fist Cross-Contour Wrap",
                        challengeDesc = "Look at your own forearm and closed fist; draw light cross-contour wristbands stepping from wrist up over knuckles.",
                        challengeReps = "1 forearm/hand wireframe",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing wireframe lines straight like graph paper" to "Bend every single wire line when it crosses a ridge or dip.",
                            "Overcrowding with 30 tiny lines" to "Use 5–8 clean, deliberate ribbons per direction."
                        ),
                        checklist = listOf(
                            "Wireframe lines curve smoothly with bumps and indentations.",
                            "Lines hook cleanly at the silhouette boundary.",
                            "The flat silhouette visibly pops into 3D space."
                        ),
                        criteria = "Complete 8 cross-contour wireframe studies across real and invented forms.",
                        diagramType = DiagramType.CROSS_CONTOUR,
                        primarySkillId = "sk_cross_contour",
                        reinforcedSkillIds = listOf("sk_contour")
                    ),
                    LessonSpec(
                        id = "w2_u3_l3",
                        title = "Form Wrapping & Surface Attachment",
                        subtitle = "Straps, belts, and organic add-ons",
                        objective = "Attach smaller secondary forms smoothly onto curved host forms without looking pasted flat.",
                        explanation = "When a strap wraps around a barrel, or a petal/muscle attaches to a stem/bone, the contact seam MUST follow the curvature of the underlying host surface.",
                        whyItMatters = "Solves the 'sticker effect' where clothing straps, belts, eyes, or armor look glued flat instead of wrapping around a body.",
                        materials = listOf("HB pencil", "Sketchbook"),
                        steps = listOf(
                            "Draw a large base cylinder, sphere, or organic sausage with faint cross-contours.",
                            "Place a thick band or smaller secondary pod hugging its surface.",
                            "Ensure the seam line bends tightly around the host's curvature."
                        ),
                        ex1Title = "Belted Cylinders & Spheres",
                        ex1Desc = "Draw 6 large cylinders and spheres, then wrap thick 3D raised belts and ribbons tightly around them with visible edge thickness.",
                        ex1Reps = "6 belted base forms",
                        ex1Min = 10,
                        ex2Title = "Draped Sausage Overlays",
                        ex2Desc = "Draw 4 large horizontal sausages and drape 2 smaller flexible sausages heavily across their backs so the upper ones bend to match.",
                        ex2Reps = "4 gravity-draped overlays",
                        ex2Min = 10,
                        ex3Title = "Socket & Joint Attachments",
                        ex3Desc = "Attach cylindrical branches or pipe nozzles onto curved spheres using clean circular collar seams.",
                        ex3Reps = "6 collared attachments",
                        ex3Min = 8,
                        challengeTitle = "Armored Shoulder Pad Study",
                        challengeDesc = "Start with a sphere-and-cylinder shoulder/arm base and wrap 3 overlapping curved plates cleanly around the volume.",
                        challengeReps = "1 layered plate construction",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Ignoring edge thickness on belts/plates" to "Add a thin side edge where the strap wraps over the silhouette so it feels thick.",
                            "Straight seams on round surfaces" to "Curve every contact seam to match the host form's cross-contour."
                        ),
                        checklist = listOf(
                            "Attached elements hug the curved host surface convincingly.",
                            "Raised straps show subtle edge thickness at silhouettes.",
                            "Contact seams wrap symmetrically around forms."
                        ),
                        criteria = "Complete 16 form-wrapping and surface-attachment constructions.",
                        diagramType = DiagramType.CROSS_CONTOUR,
                        primarySkillId = "sk_cross_contour",
                        reinforcedSkillIds = listOf("sk_spheres_cyl")
                    )
                )
            ),
            buildUnit(
                2, 4, "w2_u4", "Form Intersections & Construction",
                "Combine boxes, spheres, cylinders, and cones into cohesive, solid compound structures.",
                listOf(
                    LessonSpec(
                        id = "w2_u4_l1",
                        title = "Box-to-Box & Box-to-Cylinder Intersections",
                        subtitle = "Finding the shared seam in 3D",
                        objective = "Construct piercing intersections between rigid primitives and trace the exact seam where one enters another.",
                        explanation = "When a cylinder pierces through the flat face of a box, the intersection seam sits directly on that flat plane as an ellipse! Plotting intersections forces your brain to see forms occupying real, shared 3D space.",
                        whyItMatters = "Essential for vehicles, mechanical tools, furniture joinery, and complex architectural volumes.",
                        materials = listOf("2H & HB pencils", "Sketchbook"),
                        steps = listOf(
                            "Draw both penetrating primitives transparently so you see where their volumes overlap.",
                            "Determine which surface plane cuts through which form.",
                            "Trace the intersection seam crisply along the surface and darken visible exterior lines."
                        ),
                        ex1Title = "Interlocking Box Pairs",
                        ex1Desc = "Draw 6 pairs of rotated boxes passing through each other at varied angles, mapping the crisp straight intersection seams.",
                        ex1Reps = "6 box-box intersections",
                        ex1Min = 12,
                        ex2Title = "Peg-in-Box Cylinder Piercings",
                        ex2Desc = "Draw 6 boxes pierced at right and angled tilts by cylinders, drawing the contact ellipse right on the box face.",
                        ex2Reps = "6 cylinder-box intersections",
                        ex2Min = 10,
                        ex3Title = "Intersecting Cylinder T-Joints",
                        ex3Desc = "Join two cylinders in a T-pipe or X-cross and trace the saddle-shaped seam where the two curved skins meet.",
                        ex3Reps = "4 pipe intersections",
                        ex3Min = 8,
                        challengeTitle = "10-Primitive Interlocking Cluster",
                        challengeDesc = "Fill half a page with 10 intertwined boxes, cylinders, and cones all sharing one consistent spatial floor.",
                        challengeReps = "1 clustered intersection plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Skipping the draw-through lines inside the forms" to "Always draw both shapes completely before finding the seam.",
                            "Drawing flat straight seams on curved cylinders" to "Remember: a seam wrapping onto a cylinder curves around the cylinder's skin."
                        ),
                        checklist = listOf(
                            "Every pair was constructed transparently first.",
                            "Intersection seams visibly follow the flat or curved skin of the pierced object.",
                            "Final outer line weight clarifies which form sits in front."
                        ),
                        criteria = "Complete 16 multi-form intersection studies.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_form_intersect",
                        reinforcedSkillIds = listOf("sk_cubes", "sk_spheres_cyl")
                    ),
                    LessonSpec(
                        id = "w2_u4_l2",
                        title = "Constructing Compound Everyday Objects",
                        subtitle = "Seeing cameras, lamps, and kettles as primitives",
                        objective = "Break real compound manufactured objects down into assembled boxes, cylinders, cones, and spheres.",
                        explanation = "A vintage camera is a slab box + protruding cylinder lens + tiny button cylinders. A desk lamp is a cone shade + thin pipe + weighted disc base. Construction replaces copying surface outlines with assembling solid 3D parts.",
                        whyItMatters = "Once you construct objects from primitives, you can rotate and draw them from imagination—not just from one photo angle.",
                        materials = listOf("2H & HB pencils", "Sketchbook", "3 household gadgets/appliances"),
                        steps = listOf(
                            "Identify the largest main primitive (box or cylinder) and draw it transparently.",
                            "Find the centerline or surface attachment point for secondary primitives.",
                            "Add handles, spouts, buttons, and chamfers as smaller attached forms."
                        ),
                        ex1Title = "Coffee Maker or Kettle Assembly",
                        ex1Desc = "Deconstruct a kettle, French press, or coffee mug with handle into pure boxes, cylinders, cones, and ribbons.",
                        ex1Reps = "2 household item constructions",
                        ex1Min = 12,
                        ex2Title = "Handheld Tool Breakdown",
                        ex2Desc = "Construct a tape dispenser, stapler, hairdryer, or spray bottle from transparent primitives.",
                        ex2Reps = "2 gadget breakdowns",
                        ex2Min = 12,
                        ex3Title = "Headphones or Desk Lamp",
                        ex3Desc = "Build a desk lamp or pair of headphones using central axes, spheres/disks, and curved bands.",
                        ex3Reps = "1 complex assembly study",
                        ex3Min = 10,
                        challengeTitle = "Draw the Same Object From an Invented Angle",
                        challengeDesc = "After constructing your spray bottle or mug from your desk view, close your eyes, rotate it 90° in your head, and construct it from the new angle.",
                        challengeReps = "1 rotated memory construction",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing details like logos before finishing the primitive skeleton" to "Complete 100% of the primitive assembly before adding knobs or seams.",
                            "Crooked spouts/handles misaligned with centerlines" to "Draw a faint centerline down the front of symmetrical objects."
                        ),
                        checklist = listOf(
                            "Every component was built as a transparent 3D primitive first.",
                            "Centerlines kept handles, spouts, and buttons symmetrically placed.",
                            "The finished construction feels sturdy enough to hold."
                        ),
                        criteria = "Construct 5 real compound objects cleanly from basic geometric volumes.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_form_intersect",
                        reinforcedSkillIds = listOf("sk_cubes", "sk_spheres_cyl")
                    ),
                    LessonSpec(
                        id = "w2_u4_l3",
                        title = "Form Simplification Under Rotation",
                        subtitle = "Rotating primitives fluently",
                        objective = "Draw a single compound primitive group rotated across 4 consecutive turntable views.",
                        explanation = "True spatial mastery appears when you can keep proportions consistent as an object spins on a turntable—watching which faces widen, which compress, and which parts tuck behind others.",
                        whyItMatters = "Directly unlocks character turnarounds, vehicles, and imaginative drawing later in World 12.",
                        materials = listOf("2H & HB pencils", "Sketchbook", "Simple physical prop (mug or stacked blocks)"),
                        steps = listOf(
                            "Build a simple 2- or 3-piece prop (e.g., cylinder sitting beside a wedged box, or a mug).",
                            "Draw it straight-on (0°), then rotate it ~45°, ~90°, and ~135° across 4 panels.",
                            "Keep base height consistent across panels using horizontal guide rails."
                        ),
                        ex1Title = "4-Panel Block-and-Cylinder Turntable",
                        ex1Desc = "Rule 4 side-by-side panels with shared top/bottom height rails. Draw a box + upright cylinder rotating 45° per panel.",
                        ex1Reps = "1 four-panel turntable",
                        ex1Min = 14,
                        ex2Title = "Mug Handle Orbit",
                        ex2Desc = "Draw a mug 4 times as the handle swings from full side profile, 45° front, disappearing behind the rim, and emerging opposite.",
                        ex2Reps = "4 orbital mug views",
                        ex2Min = 12,
                        ex3Title = "Tilted Wedge Spin",
                        ex3Desc = "Rotate a simple wedge/cheese-slice box across 3 angles preserving consistent thickness.",
                        ex3Reps = "3 rotated wedge studies",
                        ex3Min = 8,
                        challengeTitle = "Simple Wooden Toy Car Turntable",
                        challengeDesc = "Design a boxy toy truck (2 boxes + 4 wheel cylinders) and draw it from front 3/4 and rear 3/4 views.",
                        challengeReps = "2 matching 3/4 views",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Object changing size drastically between panels" to "Use light horizontal height lines across all panels.",
                            "Forgetting to move hidden overlap behind the cylinder" to "Draw through transparently on all 4 views so overlaps never cheat."
                        ),
                        checklist = listOf(
                            "Shared horizontal guide rails kept object heights consistent.",
                            "Hidden elements disappeared smoothly behind front volumes as rotated.",
                            "Proportions remained recognizable across all views."
                        ),
                        criteria = "Finish all 3 turntable sequences consistently to unlock World 2's Milestone Project.",
                        diagramType = DiagramType.BASIC_FORMS_3D,
                        primarySkillId = "sk_form_intersect",
                        reinforcedSkillIds = listOf("sk_cubes", "sk_cross_contour")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w2",
            worldNumber = 2,
            title = "Constructed 3D Primitive Still Life Plate",
            brief = "Arrange 3–4 household objects with distinct geometric bases (e.g., box/book, cylindrical thermos, conical funnel or bowl, spherical fruit) and draw a clean transparent construction plate plus finished contour pass showing intersections and cross-contours.",
            combinedSkills = listOf("Box Construction", "Spheres & Cylinders", "Cross-Contours", "Form Intersections"),
            requiredMaterials = listOf("2H, HB, 2B pencils", "A4 sketchpad", "3–4 geometric household objects"),
            phases = listOf(
                "Phase 1 (5 min): Sight overall scale and lay down faint 2H ground footprints.",
                "Phase 2 (10 min): Construct every object transparently as boxes, cylinders, cones, or spheres.",
                "Phase 3 (7 min): Add cross-contour bands on curved surfaces and map any contact intersections.",
                "Phase 4 (8 min): Reinforce visible outer edges and overlaps with crisp HB/2B line weight."
            ),
            selfAssessmentChecklist = listOf(
                "Every circular rim aligns perpendicularly to its vertical/tilted minor axis.",
                "Boxes have convincing parallel/converging sets with obtuse front Y-angles.",
                "Cross-contours wrap convincingly around curved volumes.",
                "No objects clip awkwardly into the same floor footprint."
            ),
            estimatedMinutes = 30,
            xpReward = 135
        )
    ),

    // WORLD 3: LINE CONTROL
    DrawingWorld(
        number = 3,
        id = "world_3",
        title = "Line Control",
        tagline = "Command pressure, rhythm, weight, and expressive ink/graphite marks",
        focusSummary = "Build effortless shoulder-driven line confidence, deliberate line weight hierarchy, parallel/cross-hatching, and controlled stippling.",
        unlockRequirementSummary = "Complete World 2 Milestone & reach Practicing in Basic Forms skills",
        units = listOf(
            buildUnit(
                3, 1, "w3_u1", "Motor Mechanics & Stroke Confidence",
                "Eliminate shaky wrist lines through shoulder pivots, dot-to-dot ghosting, and multi-direction calibration.",
                listOf(
                    LessonSpec(
                        id = "w3_u1_l1",
                        title = "Shoulder Pivot, Ghosting & Dot Connection",
                        subtitle = "Smooth lines at any angle",
                        objective = "Execute crisp, un-wobbled straight lines between plotted endpoints using shoulder pivots and ghosting.",
                        explanation = "Fingers and wrists pivot in tiny tight arcs, forcing long lines to curve or wobble. Locking your wrist and swinging from your shoulder creates clean, straight trajectories. Ghosting—hovering back and forth 3–5 times before touching paper—programs the muscle path before ink or graphite lands.",
                        whyItMatters = "Confident linework separates crisp, authoritative drawings from tentative, hairy sketches—and speeds up every drill you'll ever do.",
                        materials = listOf("0.5mm fineliner or sharp HB pencil", "Smooth A4 paper"),
                        steps = listOf(
                            "Plot two clear dots 5 to 18 cm apart.",
                            "Hover your pen tip 2 mm above the paper, swinging back and forth smoothly from your shoulder between both dots (ghosting).",
                            "Rotate the page if an angle feels stiff so your arm moves along its most comfortable natural arc.",
                            "Drop the tip cleanly onto the start dot and pull one swift, decisive stroke to the end dot—never slow down mid-line to steer."
                        ),
                        ex1Title = "Multi-Length Ghosted Lines",
                        ex1Desc = "Plot pairs of dots at short (4 cm), medium (10 cm), and full-page-width (20 cm) spans across varied angles. Draw 1 crisp stroke per pair.",
                        ex1Reps = "30 ghosted point-to-point lines",
                        ex1Min = 8,
                        ex2Title = "8-Direction Compass Calibration",
                        ex2Desc = "Draw a central dot and 8 outer target dots like a compass star (N, NE, E, SE, S, SW, W, NW). Connect all 8 WITHOUT rotating the page first, then repeat rotating the page for comfort.",
                        ex2Reps = "3 compass stars (24 strokes)",
                        ex2Min = 8,
                        ex3Title = "Parallel Rail Spacing Drill",
                        ex3Desc = "Draw one long 15 cm line, then trace 10 parallel companion lines spaced cleanly 4 mm apart at the same speed and pressure.",
                        ex3Reps = "3 sets of 10 parallel rails",
                        ex3Min = 8,
                        challengeTitle = "Superimposed Ribbon Curves",
                        challengeDesc = "Use a French curve or mug rim to draw 4 smooth curved guides, then freehand-trace directly over each curve 8 times without fraying.",
                        challengeReps = "4 curves × 8 superimposed passes",
                        challengeMin = 8,
                        mistakes = listOf(
                            "Wobbling near the end dot while trying to hit it accurately" to "Prioritize straightness and confidence first; a slight overshoot is better than a wiggly correction.",
                            "Scratching small overlapping segments ('chicken-scratching')" to "Commit to ONE continuous stroke from start to finish."
                        ),
                        checklist = listOf(
                            "Lines look smooth and straight without jittery mid-course corrections.",
                            "I used my shoulder/elbow rather than flexing only my wrist.",
                            "Parallel lines maintained even spacing without drifting."
                        ),
                        criteria = "Complete 84 deliberate point-to-point, compass, and parallel rail strokes.",
                        diagramType = DiagramType.LINE_CONTROL_GHOSTING,
                        primarySkillId = "sk_stroke_conf"
                    ),
                    LessonSpec(
                        id = "w3_u1_l2",
                        title = "Ghosted Planes & Precision Anchoring",
                        subtitle = "Connecting lines cleanly at corners",
                        objective = "Close 4-sided perspective planes and internal bisectors cleanly without messy corner tangles.",
                        explanation = "Drawing isolated lines is step one; connecting four lines into closed planes without overshooting corners or wobbling requires controlled deceleration and consistent endpoint plotting.",
                        whyItMatters = "Planes form the faces of every box, wall, tabletop, and structural block.",
                        materials = listOf("0.5mm fineliner or sharp HB pencil", "Smooth sketchpad"),
                        steps = listOf(
                            "Plot 4 arbitrary corner dots forming varied irregular quadrilaterals (skewed trapezoids, diamonds, tall rectangles).",
                            "Ghost and connect all 4 outer sides cleanly.",
                            "Ghost and draw the 2 corner-to-corner diagonals to find the center, then bisect vertically and horizontally through that center."
                        ),
                        ex1Title = "20 Irregular Ghosted Planes",
                        ex1Desc = "Fill a page tightly with 20 varied 4-corner planes of different sizes and skew angles.",
                        ex1Reps = "20 closed 4-sided planes",
                        ex1Min = 10,
                        ex2Title = "Bisected Center Crosses",
                        ex2Desc = "Inside each of your 20 planes, draw the two diagonals and the center-aligned vertical/horizontal midlines.",
                        ex2Reps = "20 planes × 4 internal lines",
                        ex2Min = 9,
                        ex3Title = "Touch-and-Stop Corner Precision",
                        ex3Desc = "Draw 10 freehand squares targeting exact 0 mm corner overshoots—focus on lifting cleanly right at the plotted dot.",
                        ex3Reps = "10 zero-overshoot squares",
                        ex3Min = 6,
                        challengeTitle = "Nested Halving Maze",
                        challengeDesc = "Draw a large skewed plane, subdivide it into 4 quadrants, subdivide one quadrant into 4 again, and repeat 4 levels deep.",
                        challengeReps = "2 recursive subdivided planes",
                        challengeMin = 9,
                        mistakes = listOf(
                            "Skipping dot plotting and guessing corner placement mid-stroke" to "Always place corner dots first—planning takes 1 second and prevents warped planes.",
                            "Center cross missing the diagonal intersection" to "Aim directly through the X-intersection point while ghosting."
                        ),
                        checklist = listOf(
                            "Corners meet cleanly with minimal overshoot or gaps.",
                            "Internal center crosshairs pass right through the diagonal X intersection.",
                            "Line smoothness stayed consistent across small and large planes."
                        ),
                        criteria = "Complete 20 bisected planes and 10 precision corner squares.",
                        diagramType = DiagramType.LINE_CONTROL_GHOSTING,
                        primarySkillId = "sk_stroke_conf",
                        reinforcedSkillIds = listOf("sk_cubes")
                    ),
                    LessonSpec(
                        id = "w3_u1_l3",
                        title = "Tapered Strokes & Flowing S-Curves",
                        subtitle = "Dynamic entry, pressure swell, and clean lift",
                        objective = "Execute graceful C-curves and S-curves with deliberate start-to-finish pressure tapering.",
                        explanation = "Mechanical drawings use even lines; expressive drawings breathe through tapered strokes—starting light as the pencil lands like an airplane, pressing steadily through the belly of the curve, and lifting smoothly into a feather point.",
                        whyItMatters = "Essential for gesture lines, drapery folds, botanical stems, hair strands, and dynamic silhouettes.",
                        materials = listOf("2B graphite pencil (sharpened long) or brush pen", "Sketchbook"),
                        steps = listOf(
                            "Hold your pencil slightly lower or at a 35° slant for broader pressure range.",
                            "Sweep a rhythmic C-curve landing lightly, pressing smoothly in the middle, and flicking off into a crisp taper.",
                            "Practice reverse S-curves maintaining unbroken flow without stiff elbow kinks."
                        ),
                        ex1Title = "Feather-Taper S-Curve Ribbons",
                        ex1Desc = "Draw 15 large rhythmic S-curves across the page, starting hairline-thin, swelling dark in the center turn, and feathering out.",
                        ex1Reps = "15 tapered S-curves",
                        ex1Min = 7,
                        ex2Title = "Parallel Flowing Wave Sets",
                        ex2Desc = "Draw a flowing 18 cm C-curve, then echo it with 6 evenly spaced companion curves mimicking ribbon pleats or hair locks.",
                        ex2Reps = "4 sets of 7 wave strokes",
                        ex2Min = 9,
                        ex3Title = "C-S-I Line Alphabet Drill",
                        ex3Desc = "Fill half a page connecting alternating C-curves, S-curves, and straight I-lines cleanly at tangent joints without corners.",
                        ex3Reps = "12 combined C-S-I flows",
                        ex3Min = 7,
                        challengeTitle = "Calligraphic Contour Leaf",
                        challengeDesc = "Draw a twisting ribbon or curling iris leaf purely using smoothly tapered C and S strokes.",
                        challengeReps = "3 calligraphic ribbon leaves",
                        challengeMin = 9,
                        mistakes = listOf(
                            "Blunt stopped 'dot' ends on organic curves" to "Keep your arm moving forward as you lift the pencil off the paper.",
                            "Kinks where two curves join" to "Ghost right through the transition zone before dropping the tip."
                        ),
                        checklist = listOf(
                            "Curves swell smoothly and taper cleanly at both tips.",
                            "Echoed wave curves maintain harmonious spacing without colliding.",
                            "No stiff elbow kinks interrupt S-curves."
                        ),
                        criteria = "Complete 43 tapered C/S/wave strokes and 12 C-S-I tangent flows.",
                        diagramType = DiagramType.LINE_CONTROL_GHOSTING,
                        primarySkillId = "sk_stroke_conf"
                    )
                )
            ),
            buildUnit(
                3, 2, "w3_u2", "Line Weight & Depth Hierarchy",
                "Use line thickness, softness, and intentional breaks to communicate overlap, mass, and light without shading.",
                listOf(
                    LessonSpec(
                        id = "w3_u2_l1",
                        title = "Overlap & Foreground Line Weight",
                        subtitle = "Signaling what sits in front",
                        objective = "Apply heavier line weight cleanly at overlapping junctions and outer silhouettes to create instant 3D separation.",
                        explanation = "When every line in a drawing has the exact same thickness, overlapping boxes turn into a confusing wire tangle. Boldly thickening ONLY the line of the front object right where it crosses behind another pops it forward immediately.",
                        whyItMatters = "Line weight lets pure ink or pencil line drawings read with depth and clarity before a single drop of shading is added.",
                        materials = listOf("HB & 2B pencils (or 0.2mm + 0.5mm fineliners)", "Sketchbook"),
                        steps = listOf(
                            "Draw 3–4 overlapping forms cleanly with thin uniform construction weight.",
                            "Identify every T-junction where a front edge crosses over a rear edge.",
                            "Trace a smooth, tapered thickening pass strictly over the overlapping front segment and outer ground-facing silhouette."
                        ),
                        ex1Title = "Overlapping Plane Stack",
                        ex1Desc = "Draw 6 overlapping flat rectangles/cards stacked like scattered playing cards. Use bold tapered weight on front overlaps and thin lines on hidden/back edges.",
                        ex1Reps = "3 stacks of 6 cards",
                        ex1Min = 9,
                        ex2Title = "Tapered Box Silhouette Weight",
                        ex2Desc = "Draw 6 rotated boxes transparently. Keep interior Y-edges light, thicken outer silhouette gently, and add extra weight on overlapping corners.",
                        ex2Reps = "6 weighted 3D boxes",
                        ex2Min = 10,
                        ex3Title = "Foreground-to-Background Fade",
                        ex3Desc = "Draw a row of 5 receding cylinders from large foreground to tiny background, stepping line weight from heavy 2B down to whisper-light 2H.",
                        ex3Reps = "2 receding 5-cylinder rows",
                        ex3Min = 8,
                        challengeTitle = "Tangled Rope Knot Line Weight",
                        challengeDesc = "Draw a complex woven pretzel knot with thin guidelines, then apply clean local line-weight swells at every over-under crossing.",
                        challengeReps = "2 woven knot studies",
                        challengeMin = 10,
                        mistakes = listOf(
                            "Thickening entire lines abruptly like a cartoon sticker" to "Taper smoothly into and out of intersections so weight blends naturally.",
                            "Making internal construction lines darker than outer silhouettes" to "Reserve heaviest weight strictly for foreground silhouettes and under-edges."
                        ),
                        checklist = listOf(
                            "Front overlapping forms visually jump forward over background forms.",
                            "Weight transitions taper smoothly rather than starting as blocky blobs.",
                            "Interior construction marks stay clearly lighter than silhouettes."
                        ),
                        criteria = "Complete 11 line-weight depth exercises with clear foreground/background separation.",
                        diagramType = DiagramType.LINE_CONTROL_GHOSTING,
                        primarySkillId = "sk_line_weight",
                        reinforcedSkillIds = listOf("sk_cubes")
                    ),
                    LessonSpec(
                        id = "w3_u2_l2",
                        title = "Gravity Weight & Light-Side Breaks",
                        subtitle = "Suggesting light and mass purely with line",
                        objective = "Thicken underside/shadow edges and intentionally break light-facing contours to evoke illumination in pure line.",
                        explanation = "Light hits top edges and dissolves them; weight settles toward the bottom shadow edge where an object meets the table. Leaving tiny crisp gaps on the lit side while reinforcing the underside creates vivid light and gravity without shading.",
                        whyItMatters = "Used by master comic artists, architects, and industrial sketchers to make line drawings look sunlit and heavy.",
                        materials = listOf("HB & 2B pencils (or 0.3mm + 0.7mm pens)", "Sketchbook"),
                        steps = listOf(
                            "Pick a clear light direction (e.g., top-left sun) and mark a tiny arrow on the page.",
                            "Draw your form lightly; lift your pencil briefly on the brightest highlight edge to create a subtle 'lost' line break.",
                            "Reinforce the shadow-facing edges and ground-contact line firmly with 2B weight."
                        ),
                        ex1Title = "Sunlit Primitive Weight Study",
                        ex1Desc = "Draw a cube, sphere, cylinder, and cone lit from top-left. Break or keep whisper-thin top-left edges; thicken bottom-right shadow rims and contact shadows.",
                        ex1Reps = "2 sets of 4 lit primitives",
                        ex1Min = 10,
                        ex2Title = "Heavy vs. Light Object Pairs",
                        ex2Desc = "Draw a heavy anvil/stone next to an airy balloon/feather using thick grounded contact lines for weight vs. broken airy strokes for lightness.",
                        ex2Reps = "3 weight-contrast pairs",
                        ex2Min = 9,
                        ex3Title = "Tabletop Grounding Lines",
                        ex3Desc = "Draw 5 simple mugs/bottles and practice laying a crisp dark occlusion line ONLY right under their bottom contact rim.",
                        ex3Reps = "5 grounded tabletop studies",
                        ex3Min = 7,
                        challengeTitle = "Line-Only Draped Towel",
                        challengeDesc = "Draw a hanging hand towel lit from one side using zero shading—convey every fold purely through shadow-side thickening and lit-side line breaks.",
                        challengeReps = "1 pure-line drapery study",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Putting broken lines on the shadow side" to "Keep shadow edges crisp and continuous; only break edges facing direct light.",
                            "Over-thickening contact lines so the object floats on a thick black bar" to "Taper contact lines cleanly toward outer corners."
                        ),
                        checklist = listOf(
                            "The light direction is unmistakably readable without tonal shading.",
                            "Bottom contact lines anchor objects firmly to the surface.",
                            "Lit-side line breaks feel intentional and clean."
                        ),
                        criteria = "Complete 16 lit-line and weight-contrast drawings.",
                        diagramType = DiagramType.LINE_CONTROL_GHOSTING,
                        primarySkillId = "sk_line_weight"
                    ),
                    LessonSpec(
                        id = "w3_u2_l3",
                        title = "Restrained Ink & Graphite Clean-Up",
                        subtitle = "Selective inking over rough scaffolding",
                        objective = "Cleanly ink or finalize deliberate lines over a rough construction scaffold without losing energy.",
                        explanation = "Beginners often trace over rough pencil sketches rigidly, killing all life and smoothness. Instead, treat your rough 2H sketch merely as coordinates while executing fresh, confident final strokes.",
                        whyItMatters = "Prevents stiff, traced-looking cleanups when transitioning from sketch to finished ink or final graphite pass.",
                        materials = listOf("2H pencil + 0.5mm fineliner (or 2B pencil)", "Sketchbook"),
                        steps = listOf(
                            "Sketch 3 objects loosely in 2H light pencil (keep rough search lines intact).",
                            "Wait 30 seconds, rotate paper for best arm comfort, and trace ONLY the chosen final lines with fresh ghosted shoulder strokes.",
                            "Erase 2H pencil cleanly only after ink has completely dried."
                        ),
                        ex1Title = "Loose-to-Crisp Boxed Gadgets",
                        ex1Desc = "Sketch a stapler, mug, and shoe loosely in 2H pencil (4 min each), then execute a crisp, single-pass 0.5mm ink or 2B final pass.",
                        ex1Reps = "3 rough-to-clean transformations",
                        ex1Min = 15,
                        ex2Title = "No-Trace Rhythm Pass",
                        ex2Desc = "Draw 4 simple botanical stems in light 2H, then ink them using swift tapered passes slightly faster than your sketch.",
                        ex2Reps = "4 lively botanical ink passes",
                        ex2Min = 8,
                        ex3Title = "Detail Economy Check",
                        ex3Desc = "Take a busy reference item (sneaker or camera) and ink it using 30% fewer lines—suggest stitches or vents with selective dots/dashes.",
                        ex3Reps = "2 selective-detail inkings",
                        ex3Min = 10,
                        challengeTitle = "One-Layer Pen-Only Object",
                        challengeDesc = "Skip pencil altogether and draw a complex chair or backpack directly in fineliner, embracing light initial lines as part of the craft.",
                        challengeReps = "1 direct-to-ink study",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Tracing slowly millimeter by millimeter" to "Re-ghost each section and pull crisp strokes just like in Lesson 1.",
                            "Drawing every texture crack in heavy ink" to "Leave light areas calm; concentrate detail near focal overlaps."
                        ),
                        checklist = listOf(
                            "Final strokes feel fresh and fluid rather than traced slowly.",
                            "Unnecessary rough search lines didn't clutter final ink choices.",
                            "Detail density was kept intentional and readable."
                        ),
                        criteria = "Complete 9 rough-to-final cleanups and selective-detail inkings.",
                        diagramType = DiagramType.LINE_CONTROL_GHOSTING,
                        primarySkillId = "sk_line_weight",
                        reinforcedSkillIds = listOf("sk_stroke_conf")
                    )
                )
            ),
            buildUnit(
                3, 3, "w3_u3", "Hatching & Cross-Hatching",
                "Build controlled parallel tone, layered cross-hatch grids, and 3D cross-contour hatching.",
                listOf(
                    LessonSpec(
                        id = "w3_u3_l1",
                        title = "Even Parallel Hatching & Value Bars",
                        subtitle = "Spacing and pressure control in line tone",
                        objective = "Produce smooth, uniform tone blocks using evenly spaced parallel ink or pencil hatching strokes.",
                        explanation = "Hatching builds value out of clean parallel lines instead of smudging. Tone brightness depends on two dials: line spacing (tighter = darker) and stroke thickness/pressure.",
                        whyItMatters = "Creates crisp, atmospheric, non-muddy shading in ink, ballpoint, and architectural or classical pencil drawings.",
                        materials = listOf("0.3mm or 0.5mm fineliner + sharp HB pencil", "Sketchbook"),
                        steps = listOf(
                            "Draw 5 adjoining 3×3 cm squares in a horizontal bar.",
                            "Fill Box 1 leaving bare paper, Box 2 with wide 3 mm parallel diagonals, Box 3 at 1.5 mm, Box 4 tightly spaced, Box 5 tightly overlapping.",
                            "Keep every stroke crisp at both ends—no sloppy hooks or scribbled back-and-forth zigzags!"
                        ),
                        ex1Title = "5-Step Parallel Hatch Gradient Bar",
                        ex1Desc = "Draw 3 horizontal 5-box bars: one using diagonal 45° strokes, one vertical, and one horizontal—avoid zigzagging.",
                        ex1Reps = "3 five-step hatch bars",
                        ex1Min = 12,
                        ex2Title = "Continuous Seamless Hatch Strip",
                        ex2Desc = "Draw a 15×3 cm long strip and hatch a smooth continuous dark-to-light gradient without box dividers.",
                        ex2Reps = "2 seamless hatch gradients",
                        ex2Min = 8,
                        ex3Title = "Flat Cube Plane Hatching",
                        ex3Desc = "Draw 4 simple cubes and shade one side medium-hatch and one side dense-hatch, stopping sharply at every corner edge.",
                        ex3Reps = "4 hatched 3D cubes",
                        ex3Min = 8,
                        challengeTitle = "Precision Micro-Tile Checkerboard",
                        challengeDesc = "Draw a 4×4 grid and alternate light and dark hatched tiles cleanly inside borders with zero corner bleed.",
                        challengeReps = "1 sixteen-tile hatch precision grid",
                        challengeMin = 10,
                        mistakes = listOf(
                            "Scribbling back-and-forth without lifting the pen ('fishhook ends')" to "Lift the pen cleanly at the end of EVERY single stroke.",
                            "Uneven dark stripes inside a flat box" to "Keep hand rhythm steady and avoid overlapping rows erratically."
                        ),
                        checklist = listOf(
                            "Every hatch stroke starts and stops cleanly without hooked reversals.",
                            "Step intervals progress smoothly from light to dark.",
                            "Edges stop accurately at cube boundaries."
                        ),
                        criteria = "Complete 5 value bars/strips and 4 hatched cube planes cleanly.",
                        diagramType = DiagramType.HATCHING_AND_STIPPLING,
                        primarySkillId = "sk_hatching"
                    ),
                    LessonSpec(
                        id = "w3_u3_l2",
                        title = "Layered Cross-Hatching Angles",
                        subtitle = "Intersecting layers without muddy checkerboards",
                        objective = "Layer 2 to 4 passes of directional hatching at natural 25°–45° crossing angles to deepen tone smoothly.",
                        explanation = "Crossing lines at right angles (90°) creates harsh screen-door grids. Crossing second and third hatch passes at subtle 25°–35° diamond angles blends smoothly into rich velvety darks.",
                        whyItMatters = "Allows you to push shadows dramatically dark with an ordinary 0.3mm pen or single HB pencil.",
                        materials = listOf("0.3mm/0.5mm fineliner or sharp HB/2B pencil", "Sketchbook"),
                        steps = listOf(
                            "Lay Pass 1 cleanly at 45° covering the full shadow zone.",
                            "Layer Pass 2 across only the deeper shadow zone tilted ~30° off Pass 1 (creating slender diamonds, not square checkerboards).",
                            "Add Pass 3 tightly across the deepest core/occlusion shadows."
                        ),
                        ex1Title = "3-Pass Cross-Hatch Density Scale",
                        ex1Desc = "Draw 4 boxes: 1-pass hatch, 2-pass diamond cross-hatch, 3-pass dense cross-hatch, and 4-pass near-black cross-hatch.",
                        ex1Reps = "2 sets of 4 cross-hatch boxes",
                        ex1Min = 10,
                        ex2Title = "Curved-Plane Cross-Hatch Ribbon",
                        ex2Desc = "Draw 3 wide undulating ribbons. Darken the underside turns using 2- and 3-pass diamond cross-hatching.",
                        ex2Reps = "3 shaded cross-hatch ribbons",
                        ex2Min = 9,
                        ex3Title = "2-Pass vs 90°-Grid Comparison",
                        ex3Desc = "Draw two 4×4 cm test swatches side by side: one using harsh 90° crosses and one using graceful 30° diamond crosses to visually observe the difference.",
                        ex3Reps = "2 comparative swatches",
                        ex3Min = 6,
                        challengeTitle = "Faceted Polyhedron Cross-Hatch",
                        challengeDesc = "Draw a low-poly crystal or folded paper crane and shade every triangular facet cleanly using 1–3 passes of directional cross-hatching.",
                        challengeReps = "1 faceted crystal plate",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Crossing at exact 90° perpendicular squares" to "Shift your crossing angle to 25°–40° so patterns weave like fine fabric.",
                            "Changing stroke length randomly mid-swatch" to "Work in neat overlapping bands with consistent wrist/arm sweep."
                        ),
                        checklist = listOf(
                            "Crossing angles form slender diamonds rather than boxy grids.",
                            "Dark tones step up convincingly across Pass 1, 2, 3, and 4.",
                            "Transitions between pass layers feel gradual."
                        ),
                        criteria = "Complete 13 cross-hatch density and ribbon exercises.",
                        diagramType = DiagramType.HATCHING_AND_STIPPLING,
                        primarySkillId = "sk_hatching"
                    ),
                    LessonSpec(
                        id = "w3_u3_l3",
                        title = "Contour-Following Cross-Hatching",
                        subtitle = "Sculpting 3D curvature with every stroke",
                        objective = "Bend hatching and cross-hatching curves directly along the 3D cross-contours of cylinders, spheres, and cones.",
                        explanation = "Straight diagonal hatching across a sphere can flatten it out. Wrapping your hatching strokes around the curved latitude and longitude tracks of the form simultaneously adds tone AND reinforces 3D roundness.",
                        whyItMatters = "This is the hallmark technique of Albrecht Dürer, Rembrandt, and classical pen-and-ink illustration.",
                        materials = listOf("0.3mm fineliner or sharp HB pencil", "Sketchbook"),
                        steps = listOf(
                            "Lightly construct a sphere, cylinder, and cone with faint cross-contour guides.",
                            "Draw curved parallel hatches wrapping around the shadow side along the object's surface ribs.",
                            "Layer a second curved cross-hatch pass running perpendicular along the opposite surface direction in the darkest shadow band."
                        ),
                        ex1Title = "Curved-Hatch Cylinder & Cone",
                        ex1Desc = "Draw 2 cylinders and 2 cones. Shade their shadow sides with curved bands wrapping around the circumference + vertical core passes.",
                        ex1Reps = "4 contour-hatched tubes/cones",
                        ex1Min = 12,
                        ex2Title = "Engraved Hatch Sphere",
                        ex2Desc = "Draw a large 8 cm sphere lit from top-left. Wrap curved longitude and latitude hatch layers smoothly around the shadow crescent.",
                        ex2Reps = "2 engraved cross-hatch spheres",
                        ex2Min = 12,
                        ex3Title = "Organic Pebble & Apple Contour Hatch",
                        ex3Desc = "Draw an apple or rounded river stone and sculpt its dimples and curvature purely with curved cross-hatching.",
                        ex3Reps = "2 organic contour-hatch studies",
                        ex3Min = 8,
                        challengeTitle = "Draped Sleeve Ink Engraving Study",
                        challengeDesc = "Draw a bent cloth sleeve or simple coiled rope, wrapping contour cross-hatches cleanly into every crease.",
                        challengeReps = "1 engraved sleeve/rope study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Flattening strokes straight near the edge of a sphere" to "Curve strokes tighter as they approach the rim, echoing the sphere's edge.",
                            "Over-hatching into the bright highlight zone" to "Leave bright highlights untouched pure paper white."
                        ),
                        checklist = listOf(
                            "Hatch strokes clearly curve around the 3D surface rather than lying flat.",
                            "Highlights remain clean bare paper.",
                            "Crossed curved passes build rich shadow depth smoothly."
                        ),
                        criteria = "Finish 8 contour-hatched 3D volumes with readable light and curvature.",
                        diagramType = DiagramType.HATCHING_AND_STIPPLING,
                        primarySkillId = "sk_hatching",
                        reinforcedSkillIds = listOf("sk_cross_contour")
                    )
                )
            ),
            buildUnit(
                3, 4, "w3_u4", "Stippling & Rhythmic Mark-Making",
                "Control stipple density, broken ink textures, and rhythmic textural strokes for non-smooth surfaces.",
                listOf(
                    LessonSpec(
                        id = "w3_u4_l1",
                        title = "Controlled Stippling Gradients",
                        subtitle = "Pure dot density without dragging",
                        objective = "Create smooth light-to-dark value transitions using clean round ink/pencil stipple dots.",
                        explanation = "Stippling builds value purely by packing individual dots closer together in shadows and scattering them widely toward light. Keeping the tip vertical prevents ugly comma tails.",
                        whyItMatters = "Develops extraordinary patience, micro-control, and precision eye-for-value—ideal for stone, skin, and scientific illustration.",
                        materials = listOf("0.3mm or 0.5mm fineliner (never slam hard—tap gently)", "Sketchbook"),
                        steps = listOf(
                            "Hold the pen nearly upright (85°–90°) so every tap makes a crisp round dot rather than a dash.",
                            "Begin in the darkest zone with tightly clustered dots, then gradually open spacing as you drift toward light.",
                            "Squint regularly to verify there are no accidental dark clumps or bright blank corridors."
                        ),
                        ex1Title = "Stippled 12 cm Gradient Strip",
                        ex1Desc = "Rule a 12×2.5 cm rectangle. Populate a smooth seamless transition from dense pure dark on the left to scattered airy dots on the right.",
                        ex1Reps = "2 seamless stipple bars",
                        ex1Min = 10,
                        ex2Title = "Stippled Sphere Study",
                        ex2Desc = "Draw a 6 cm sphere and render its shadow crescent, reflected rim, and cast shadow using pure dots (no outline!).",
                        ex2Reps = "1 outline-free stippled sphere",
                        ex2Min = 12,
                        ex3Title = "Stippled Citrus Peel Texture",
                        ex3Desc = "Draw an orange or lemon slice using clusters of fine and bold dots to mimic dimpled skin.",
                        ex3Reps = "2 small citrus studies",
                        ex3Min = 8,
                        challengeTitle = "Stippled Seashell or Pinecone",
                        challengeDesc = "Render a small natural seashell purely in stipple dots, using dot spacing alone to define ridges and shadows.",
                        challengeReps = "1 complete stipple object plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Dragging the pen fast and leaving comet tails instead of dots" to "Slow down slightly and lift strictly vertically after every tap.",
                            "Lining dots up in rigid robot rows" to "Scatter dot placement organically in triangles and clusters."
                        ),
                        checklist = listOf(
                            "Dots are round rather than smeared dashes or commas.",
                            "Dot distribution looks organic with no robotic grid lines.",
                            "The stippled sphere reads clearly even without a dark outline."
                        ),
                        criteria = "Complete 2 stipple gradient bars, 1 outline-free sphere, and 2 texture studies.",
                        diagramType = DiagramType.HATCHING_AND_STIPPLING,
                        primarySkillId = "sk_stippling_tex"
                    ),
                    LessonSpec(
                        id = "w3_u4_l2",
                        title = "Textural Ink & Pencil Mark Library",
                        subtitle = "Inventing marks for rough, broken & organic surfaces",
                        objective = "Design 8 distinct repeatable pen/pencil mark patterns (scumbling, broken dashes, wood-grain, dry-drag) to suggest texture.",
                        explanation = "Not everything should be shaded with slick mechanical lines. Tree bark wants jagged vertical dashes; foliage wants lively scribble clusters; worn stone wants fractured stipple + short ticks.",
                        whyItMatters = "Prepares your hand to express distinct surface materials effortlessly in Worlds 7 and 8.",
                        materials = listOf("0.5mm fineliner + 2B pencil", "Sketchbook"),
                        steps = listOf(
                            "Rule eight 4×4 cm square swatches on a page.",
                            "Dedicate each swatch to a single mark family (broken dashes, interlocking loops, crisp zigzags, pebble clusters, bark furrows, cross-ticks, directional fur flicks, crumbly pencil side-drag).",
                            "Vary spacing across each swatch from dark dense left to light airy right."
                        ),
                        ex1Title = "8-Swatch Textural Mark Dictionary",
                        ex1Desc = "Fill eight 4×4 cm swatches with 8 distinct textural mark vocabularies, fading each from dense dark to airy light.",
                        ex1Reps = "8 graded texture swatches",
                        ex1Min = 14,
                        ex2Title = "Texture-Mapped Primitives",
                        ex2Desc = "Draw 3 simple cylinders and wrap each in a different mark language (rough bark, woven basket, pitted concrete).",
                        ex2Reps = "3 textured 3D cylinders",
                        ex2Min = 10,
                        ex3Title = "Broken Silhouette Experiment",
                        ex3Desc = "Draw a stone and a leafy bush silhouette WITHOUT solid unbroken outlines—use short broken textural marks along the edges.",
                        ex3Reps = "4 broken-edge forms",
                        ex3Min = 7,
                        challengeTitle = "Old Wooden Fence Post & Grass Tuft",
                        challengeDesc = "Combine grain strokes, knot swirls, and flicked grass lines into one 6×8 cm miniature ink vignette.",
                        challengeReps = "1 vignette ink study",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Making chaotic scribbles that ignore value" to "Keep light areas sparse and pack texture tightly ONLY in shadow areas.",
                            "Drawing identical marks at the exact same size" to "Vary small, medium, and large marks within every patch."
                        ),
                        checklist = listOf(
                            "All 8 swatches look visually distinct and tactile.",
                            "Textured cylinders still clearly read as round 3D shadows.",
                            "Broken silhouettes feel organic rather than flat wireframes."
                        ),
                        criteria = "Produce an 8-swatch mark dictionary and 7 textured object/edge studies.",
                        diagramType = DiagramType.HATCHING_AND_STIPPLING,
                        primarySkillId = "sk_stippling_tex",
                        reinforcedSkillIds = listOf("sk_hatching")
                    ),
                    LessonSpec(
                        id = "w3_u4_l3",
                        title = "Ink & Graphite Economy Synthesis",
                        subtitle = "Saying more with fewer, better-placed lines",
                        objective = "Render a crisp constructed subject combining line weight, selective hatching, and minimal texture marks.",
                        explanation = "Great ink and pencil draftsmen don't cover every square millimeter in lines—they leave clean breathing white paper on lit surfaces and let crisp shadow hatching + weight carry the entire illusion.",
                        whyItMatters = "Brings together every World 3 line discipline into controlled, gallery-clean linework.",
                        materials = listOf("2H pencil + 0.3mm/0.5mm fineliners (or HB/2B pencils)", "Sketchbook"),
                        steps = listOf(
                            "Under-draw a chosen subject lightly in 2H.",
                            "Apply deliberate line weight for foreground overlaps and bottom gravity.",
                            "Add clean directional hatching ONLY in shadow planes and 10% suggestive texture marks near focal transitions."
                        ),
                        ex1Title = "30% Hatch Economy Study",
                        ex1Desc = "Draw a wooden spoon or vintage key. Keep at least 60% of the object pure unshaded paper; use hatching ONLY on cast and underside shadows.",
                        ex1Reps = "2 economy-focused studies",
                        ex1Min = 12,
                        ex2Title = "Boxed Architecture Thumbnail",
                        ex2Desc = "Draw a simple doorway or stone steps in 2H, then finalize with crisp line weight, shadow hatching, and brief brick/stone ticks.",
                        ex2Reps = "1 architectural line vignette",
                        ex2Min = 10,
                        ex3Title = "Rhythm & Pause Check",
                        ex3Desc = "Draw a mug or teapot intentionally leaving sunlit side edges open and quiet while detailing the handle shadow cleanly.",
                        ex3Reps = "1 selective-contrast study",
                        ex3Min = 8,
                        challengeTitle = "Mixed Line + Stipple Insect or Beetle",
                        challengeDesc = "Draw a beetle or shell using crisp outer line weight, contour hatching on dark wing plates, and fine stippling on highlights.",
                        challengeReps = "1 precision mixed-mark study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Over-hatching light planes out of nervousness" to "Leave bright areas completely open so dark marks have dramatic impact.",
                            "Using the exact same pen stroke for every material" to "Contrast smooth contour hatching against brief textural marks."
                        ),
                        checklist = listOf(
                            "More than half the subject breathes with clean light paper.",
                            "Line weight, hatching, and texture each serve a clear purpose.",
                            "Strokes remain confident without scratchy backtracking."
                        ),
                        criteria = "Complete 4 economical mixed-line studies to unlock World 3's Milestone Project.",
                        diagramType = DiagramType.HATCHING_AND_STIPPLING,
                        primarySkillId = "sk_line_weight",
                        reinforcedSkillIds = listOf("sk_stroke_conf", "sk_hatching", "sk_stippling_tex")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w3",
            worldNumber = 3,
            title = "Master Line-Control & Hatching Plate",
            brief = "Create a finished monochrome ink or crisp graphite plate featuring a constructed object (like a boots/leather shoe, wooden box with tools, or old lantern) utilizing deliberate line weight, contour-following cross-hatching, and restrained texture marks.",
            combinedSkills = listOf("Shoulder Stroke Confidence", "Line Weight Hierarchy", "Contour Cross-Hatching", "Textural Marks"),
            requiredMaterials = listOf("2H pencil (underdrawing)", "0.3mm & 0.5mm fineliners or sharp HB/2B/4B pencils", "A4 Bristol or smooth sketchpad"),
            phases = listOf(
                "Phase 1 (6 min): Construct the object accurately in light 2H pencil using World 1 & 2 sighting and primitive geometry.",
                "Phase 2 (8 min): Commit clean outer contours and overlapping junctions with varied line weight.",
                "Phase 3 (12 min): Layer curved contour hatching and 30° cross-hatching across shadow planes only.",
                "Phase 4 (4 min): Add minimal, rhythmic stipple or grain texture near focal edges; erase visible 2H guidelines."
            ),
            selfAssessmentChecklist = listOf(
                "All long lines are smooth and confident without chicken-scratching.",
                "Foreground overlaps and underside shadows carry clean, tapered weight.",
                "Hatching wraps around 3D curvature and crosses at subtle diamond angles.",
                "Lit surfaces stay clean and open for strong tonal contrast."
            ),
            estimatedMinutes = 30,
            xpReward = 150
        )
    )
)
