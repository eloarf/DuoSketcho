package com.example.data.curriculum

import com.example.domain.model.DiagramType
import com.example.domain.model.DrawingWorld
import com.example.domain.model.MilestoneProject

internal fun worlds10To12(): List<DrawingWorld> = listOf(
    // WORLD 10: PORTRAITS
    DrawingWorld(
        number = 10,
        id = "world_10",
        title = "Portraits",
        tagline = "Construct expressive heads from any angle and capture true human likeness",
        focusSummary = "Master Andrew Loomis ball-and-plane head construction, classic facial thirds, anatomical eyes/nose/mouth/ears/hair, and nuanced emotional expressions.",
        unlockRequirementSummary = "Complete World 9 Milestone & reach Practicing in Human Figure skills",
        units = listOf(
            buildUnit(
                10, 1, "w10_u1", "Loomis Head Construction & Tilt",
                "Rotate the human skull cleanly in 3D space using the ball-and-plane method and proportional facial thirds.",
                listOf(
                    LessonSpec(
                        id = "w10_u1_l1",
                        title = "Loomis Ball & Temporal Side Slices",
                        subtitle = "Turning the skull sphere at any angle",
                        objective = "Construct rotated cranial spheres with flattened temporal side planes, crosshairs, and equal facial thirds.",
                        explanation = "A human head is NOT a round balloon—the sides of the skull near the temples and ears are **flat sheared planes**! Andrew Loomis's genius method draws a sphere, slices off both flat side ovals (spanning 2/3 of the sphere height!), draws a cross-hair on the side plane to locate the ear and brow line, and wraps the brow line cleanly around the front.",
                        whyItMatters = "Once you master the Loomis sphere + side slice, you can tilt heads looking up, down, or sideways without features sliding off the skull.",
                        materials = listOf("2H & HB pencils", "Sketchbook"),
                        steps = listOf(
                            "Draw a clean circle representing the main cranium ball.",
                            "Draw an inner tilted oval on the facing side (~2/3 width/height of the sphere) representing the flat temple/ear plane.",
                            "Cut that oval into quarters with a tilted cross-hair: the horizontal bar sets the **Brow Line**; wrap that curve continuously around the front of the sphere!",
                            "Drop a vertical facial centerline across the brow perpendicular to the brow line."
                        ),
                        ex1Title = "8-Angle Loomis Sphere + Side Slice Grid",
                        ex1Desc = "Draw 8 cranial spheres looking left, right, tilted 30° up, tilted 30° down, and steep 3/4 views—include ONLY sphere, side slice oval, and wrapped brow/centerlines.",
                        ex1Reps = "8 rotated Loomis skull balls",
                        ex1Min = 12,
                        ex2Title = "Facial Thirds Extension (Hairline-Brow-Nose-Chin)",
                        ex2Desc = "On 4 of your Loomis balls, measure the distance from Hairline (top of side oval) to Brow Line, then copy that exact unit down to the Nose Bottom and Chin!",
                        ex2Reps = "4 classic-third head scaffolds",
                        ex2Min = 10,
                        ex3Title = "Jaw Wedge & Cheekbone Drop",
                        ex3Desc = "Connect the jaw hinge (bottom-rear quadrant of the side oval!) forward to the chin wedge, keeping the jaw angle crisp.",
                        ex3Reps = "4 jaw-attached head blocks",
                        ex3Min = 8,
                        challengeTitle = "Worm's-Eye & Bird's-Eye Head Tilts",
                        challengeDesc = "Construct 2 steep looking-up heads (showing underside of jaw & nose triangle) and 2 steep looking-down heads (showing full crown and tucked chin).",
                        challengeReps = "4 extreme head-pitch constructions",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing the side slice oval too small or floating off the edge" to "Keep the side slice ~2/3 of the circle's diameter and align its tilt with the head's pitch.",
                            "Forgetting to curve the brow line around the front sphere" to "Think of the brow line as an equator wrapping around a tilted globe—it curves UP when looking up, DOWN when looking down!"
                        ),
                        checklist = listOf(
                            "Side-slice ovals compress narrower on front views and open round on side profiles.",
                            "Brow line curves symmetrically around the cranial sphere.",
                            "Hairline-to-brow, brow-to-nose, and nose-to-chin thirds stay proportional."
                        ),
                        criteria = "Complete 16 rotated Loomis ball, facial-third, and extreme-tilt constructions.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_loomis_head"
                    ),
                    LessonSpec(
                        id = "w10_u1_l2",
                        title = "Planar Head Breakdown (Asaro Planes)",
                        subtitle = "Seeing brow, cheeks, and jaw as sculptural light blocks",
                        objective = "Subdivide the rounded Loomis head into crisp flat front, side, and underside planes for instant sculptural lighting.",
                        explanation = "Smooth egg-heads turn blurry when shaded. Breaking the Loomis head into clear geometric planes—**Forehead block, Brow keystone, Recessed Eye-socket roof, Cheekbone shelf, Muzzle cylinder, Side Temple wall, and Jaw underside**—makes light fall cleanly across every face.",
                        whyItMatters = "Turns flat drawings into chiseled, dimensional portraits even before drawing eyelashes or lips.",
                        materials = listOf("2H, HB, 2B pencils", "Mirror or head-plane photo reference", "Sketchbook"),
                        steps = listOf(
                            "Construct a 3/4 Loomis head lightly in 2H.",
                            "Carve the recessed dark orbital eye-socket cave under the overhanging brow shelf.",
                            "Define the front facial mask (forehead, cheekbones, cylindrical muzzle) sharply separate from the shaded side temple/jaw wall."
                        ),
                        ex1Title = "3/4 Planar Head Facet Map",
                        ex1Desc = "Construct 3 large 3/4 Loomis heads and map their sculptural flat planes cleanly (forehead, eye sockets, nose prism, cheek turn, jaw underside).",
                        ex1Reps = "3 planar head block-ins",
                        ex1Min = 14,
                        ex2Title = "Top-Lit Head Shadow Grouping",
                        ex2Desc = "Under strong overhead light, notice how the **eye sockets, nose underside, upper lip, chin underside, and neck** fall cleanly into unified shadow! Shade 3 planar heads in 2 values.",
                        ex2Reps = "3 two-value lit planar heads",
                        ex2Min = 12,
                        ex3Title = "Neck Sternocleidomastoid Anchor",
                        ex3Desc = "Attach each head onto a forward-leaning neck cylinder flanked by the two crisp V-cords (sternocleidomastoid muscles) pulling from behind ears down to the pit of the neck.",
                        ex3Reps = "3 head-and-neck attachments",
                        ex3Min = 7,
                        challengeTitle = "Dramatic Under-Lit Planar Portrait",
                        challengeDesc = "Flip the light source underneath (campfire lighting!) on a planar head—reversing the cast shadows upward onto brow ridges and nose bridge.",
                        challengeReps = "1 under-lit planar portrait study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing flat almond eyes flush with the forehead surface" to "Always recess eyes INSIDE the darkened orbital socket shadow underneath the brow ridge!",
                            "Connecting a straight vertical stovepipe neck behind the jaw" to "Slope the neck slightly forward from skull base toward collarbones."
                        ),
                        checklist = listOf(
                            "Side wall of head separates cleanly from front facial mask.",
                            "Eye sockets sit clearly recessed under the brow ridge.",
                            "Neck V-muscles anchor skull tilt naturally to collarbones."
                        ),
                        criteria = "Complete 9 planar head facet, lighting, and neck-attachment studies.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_loomis_head",
                        reinforcedSkillIds = listOf("sk_form_shadow")
                    ),
                    LessonSpec(
                        id = "w10_u1_l3",
                        title = "Individual Facial Proportion Variations",
                        subtitle = "Adjusting the canon for age, heritage & likeness",
                        objective = "Adjust classic Loomis proportions deliberately (wider jaw, taller forehead, closer-set eyes, fuller cheeks) to capture unique real individuals.",
                        explanation = "The Loomis 1/3–1/3–1/3 rule is a neutral **measuring baseline**, NOT a cookie-cutter stamp! Real likeness comes from spotting *deviations* from that baseline: 'Her lower third is slightly shorter; his brow sits heavier over closer-set eyes; his cheekbones sit wider than his jaw.'",
                        whyItMatters = "Prevents 'same-face syndrome' and unlocks authentic portrait likeness.",
                        materials = listOf("2H & HB pencils", "Mirror + 2 varied family/portrait photo references", "Sketchbook"),
                        steps = listOf(
                            "Sketch the standard neutral Loomis scaffold lightly first.",
                            "Compare your real model/self-portrait against those thirds and eye-widths (typical eye gap = 1 eye-width between eyes).",
                            "Note and adjust deviations right onto the scaffold (e.g., stronger square jaw, softer tapered chin, rounder cranium)."
                        ),
                        ex1Title = "Three Contrasting Character Profiles",
                        ex1Desc = "Construct 3 head-and-plane block-ins side by side intentionally varying: (1) broad square heavy-jawed build, (2) slender narrow-chinned build, and (3) soft rounded youthful proportions.",
                        ex1Reps = "3 varied facial proportion heads",
                        ex1Min = 14,
                        ex2Title = "Self-Portrait Mirror Ratio Check",
                        ex2Desc = "Look in a mirror at 3/4 view, construct your own Loomis scaffold, and mark 4 concrete measurements where your real proportions differ from neutral textbook averages.",
                        ex2Reps = "1 measured self-portrait scaffold",
                        ex2Min = 12,
                        ex3Title = "Age Evolution Comparison",
                        ex3Desc = "Compare a child's head (giant cranium, brow sitting BELOW halfway, tiny jaw) vs. an adult head vs. an older portrait (lengthened ears/nose, softened jawline).",
                        ex3Reps = "3 age-proportion head studies",
                        ex3Min = 9,
                        challengeTitle = "Side-Profile Silhouette Gallery",
                        challengeDesc = "Draw 5 distinct side profiles across one strip strictly tweaking forehead slant, nose bridge bump, lip protrusion, and chin projection.",
                        challengeReps = "5 varied profile silhouettes",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Forcing every real face rigidly into 1/3-1/3-1/3 even when the model has a high forehead" to "Use the thirds solely as a measuring ruler to spot what's longer or shorter.",
                            "Making child heads just shrunken adult heads" to "Drop children's eye line WELL below the vertical center of the skull!"
                        ),
                        checklist = listOf(
                            "Each head clearly exhibits distinct skull and jaw proportions.",
                            "Mirror self-portrait noted real deviations from textbook thirds.",
                            "Age variations shifted eye-line height and jaw weight accurately."
                        ),
                        criteria = "Complete 7 varied proportion head constructions and age/profile comparisons.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_loomis_head",
                        reinforcedSkillIds = listOf("sk_sight_prop")
                    )
                )
            ),
            buildUnit(
                10, 2, "w10_u2", "Eyes, Brow & Nose Structure",
                "Construct realistic 3D eyeball-wrapping eyelids and dimensional wedge/prism noses from every angle.",
                listOf(
                    LessonSpec(
                        id = "w10_u2_l1",
                        title = "The Eyeball Sphere & Wrapping Eyelids",
                        subtitle = "Understanding lid thickness and iris ellipses",
                        objective = "Construct eyes by seating a spherical eyeball inside the socket and wrapping thick upper/lower eyelids cleanly over its curve.",
                        explanation = "Eyes aren't flat football stickers! An eye is a **wet 2.5 cm sphere** sitting inside a bony cave, hugged tightly by thick flesh ribbons (eyelids!). Look closely at the **upper lid thickness rim** casting a tiny crisp shadow across the top of the iris, and notice how the iris becomes a narrow vertical **ellipse** when looking sideways in 3/4 view!",
                        whyItMatters = "Expressive, dimensional eyes bring instant soul and gaze focus to every portrait.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Mirror (zoom in on your own eyes!)", "Sketchbook"),
                        steps = listOf(
                            "Draw the recessed bony eye socket keystone + brow ridge first.",
                            "Draw a transparent sphere for the eyeball.",
                            "Wrap the upper eyelid over the sphere (remember: highest arch peaks slightly inward toward the nose; lower lid peaks slightly outward!), showing visible lid thickness.",
                            "Tuck the round/elliptical iris underneath the upper lid (never a full floating circle unless wide-eyed startled!), add dark pupil + bright crisp tear/window catchlight."
                        ),
                        ex1Title = "Eyeball-First Structural Eyes",
                        ex1Desc = "Draw 4 large eyes (front, 3/4 near eye, 3/4 far eye wrapping around skull curve, and looking upward) showing the underlying sphere + eyelid wrap thickness.",
                        ex1Reps = "4 structural eyeball-wrap eyes",
                        ex1Min = 14,
                        ex2Title = "Synchronized Eye Pairs in Perspective",
                        ex2Desc = "Draw 3 pairs of eyes across a curved 3/4 brow line—ensure the far eye visibly narrows horizontally due to skull curvature and sits neatly along the same gaze direction!",
                        ex2Reps = "3 perspective-paired eye sets",
                        ex2Min = 12,
                        ex3Title = "Eyebrow Hair-Plane Turn",
                        ex3Desc = "Shade 2 brow-and-eye studies focusing on how the eyebrow wraps around the bony brow corner—darkest/thickest near nose root, thinning cleanly over the temple turn.",
                        ex3Reps = "2 brow-plane eye studies",
                        ex3Min = 7,
                        challengeTitle = "Closed & Laughing Crinkled Eyes",
                        challengeDesc = "Draw your own eye tightly closed and smiling in a mirror—observing how the eyeball bulge pushes smoothly beneath the draped upper lid curtain.",
                        challengeReps = "2 closed/smiling eye studies",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing both eyes identically wide in a 3/4 head view" to "Compress the far eye narrower horizontally and tuck its outer corner cleanly around the receding skull wall.",
                            "Floating the whole round iris cleanly inside the whites with no upper-lid overlap" to "Always tuck the top 15–20% of a relaxed iris under the upper eyelid shadow!"
                        ),
                        checklist = listOf(
                            "Eyelids visibly curve around a solid 3D sphere and show edge thickness.",
                            "Upper lid casts a subtle shadow band across the top of the iris/sclera.",
                            "3/4 eye pairs narrow correctly on the far side and share the exact same gaze."
                        ),
                        criteria = "Complete 9 eyeball-wrap, paired-3/4, and brow-turn eye studies.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_eyes_nose"
                    ),
                    LessonSpec(
                        id = "w10_u2_l2",
                        title = "Nose Construction: Wedge, Keystone & Ball-Wing",
                        subtitle = "Building noses as crisp 3D architectural prisms",
                        objective = "Construct noses from any view using the glabella keystone, tapered bridge prism, spherical tip, and wrapping nostril wings.",
                        explanation = "Beginners draw noses using two hook nostrils floating in empty cheek space! Constructing the nose as a **4-plane architectural prism** (top bridge plane, two angled side walls, and a shadowed underside triangle!) + a rounded tip ball + two comma-shaped wings tucked cleanly onto the cheeks makes noses effortless from every angle.",
                        whyItMatters = "The nose anchors the center of the face in 3D space; when its underside plane reads cleanly, the whole head snaps into perspective.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Mirror", "Sketchbook"),
                        steps = listOf(
                            "Connect the brow ridge downward via the inverted-trapezoid **keystone (glabella)** into the bridge prism.",
                            "Plot the crisp bottom **underside plane** (including septum attachment) pointing toward the upper lip.",
                            "Sculpt the central ball tip and wrap two flaring nostril wings back into the smile-fold grooves—avoid outlining the sunlit bridge heavily!"
                        ),
                        ex1Title = "5-Angle Nose Prism Grid",
                        ex1Desc = "Construct 5 noses as solid geometric prisms first (front, 3/4 left, side profile, tilted looking up showing nostrils, tilted down hiding nostrils).",
                        ex1Reps = "5 multi-angle nose prisms",
                        ex1Min = 14,
                        ex2Title = "Shaded Organic Nose Studies",
                        ex2Desc = "Turn 3 of your prism noses into realistic shaded noses—relying on the darkened underside plane and soft side-wall halftones instead of dark bridge outlines.",
                        ex2Reps = "3 rendered structural noses",
                        ex2Min = 12,
                        ex3Title = "Nostril Wing & Comma Cave",
                        ex3Desc = "Zoom in on 3 nose undersides showing how nostrils aren't round black circles—they are narrow comma-shaped arched caves tapering backward.",
                        ex3Reps = "3 nostril-underside studies",
                        ex3Min = 7,
                        challengeTitle = "Diverse Nose Shape Sheet",
                        challengeDesc = "Draw 4 distinctly different real nose structures (aquiline hooked bridge, short button tip, wide flared bridge, straight classical) using prism construction.",
                        challengeReps = "4 varied nose anatomy studies",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing two heavy dark vertical outlines down both sides of the nose bridge" to "Use a soft side-wall halftone on the shadow side and leave the lit side wall open!",
                            "Drawing nostrils as flat dark black circles facing straight forward" to "Tuck nostrils cleanly up into the shaded underside triangle plane."
                        ),
                        checklist = listOf(
                            "Every nose started as a clean 4-plane wedge prism with a distinct underside.",
                            "No heavy dark outline walls slice across the lit nose bridge.",
                            "Nostrils curve naturally as recessed caves inside the bottom plane."
                        ),
                        criteria = "Complete 11 multi-angle nose prism and shaded structure studies.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_eyes_nose"
                    ),
                    LessonSpec(
                        id = "w10_u2_l3",
                        title = "Eye-Nose-Brow Socket Integration",
                        subtitle = "Connecting upper face features into one unified bridge",
                        objective = "Unite brow, eye sockets, nose keystone, and cheekbones cleanly across a rotating 3/4 facial mask.",
                        explanation = "Isolated eyes and noses rarely line up when pasted together later. Drawing the entire **T-zone (Brow → Keystone → Nose Bridge → Cheekbone Wing)** as one interlocking sculptural mask ensures correct spacing, overlapping far-eye visibility, and unified lighting.",
                        whyItMatters = "Secures instant likeness and perspective accuracy on upper-face portraits.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Mirror", "Sketchbook"),
                        steps = listOf(
                            "Construct a 3/4 upper head mask from hairline down to upper lip.",
                            "Carve the continuous eye-socket goggles and nose prism together—check how the nose bridge gently overlaps the inner corner of the far eye in steep 3/4 views!",
                            "Shade the entire upper socket cave and nose underside together cleanly."
                        ),
                        ex1Title = "3/4 Goggle-and-Nose Mask Trio",
                        ex1Desc = "Draw 3 upper-face masks rotating progressively from mild 3/4 (both eyes clear) to steep 3/4 (nose bridge partially obscuring far tear duct).",
                        ex1Reps = "3 rotating upper-face masks",
                        ex1Min = 14,
                        ex2Title = "Mirror Upper-Face Lighting Study",
                        ex2Desc = "Sit near a single lamp or window and render your own brows, eyes, nose bridge, and cheekbone highlights faithfully in 15 minutes.",
                        ex2Reps = "1 live upper-face tonal study",
                        ex2Min = 15,
                        ex3Title = "Eyeglass Bridge Fit Check",
                        ex3Desc = "On 1 upper-face mask, seat a pair of eyeglasses resting squarely on the nose bridge and wrapping back over the far temple turn.",
                        ex3Reps = "1 glasses-on-face perspective study",
                        ex3Min = 7,
                        challengeTitle = "Dramatic Chiaroscuro Upper Mask",
                        challengeDesc = "Shade a dramatic side-lit upper face mask where the entire far eye socket drops softly into deep shadow while one lit cheekbone and iris catchlight gleam.",
                        challengeReps = "1 chiaroscuro eye-nose plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Pulling the far eye out past the nose bridge on steep 3/4 turns so it floats off the cheek" to "Let the nose bridge physically overlap the far inner eye corner when the head turns past 45°.",
                            "Forgetting the curved depression ('nasal root') between brow and nose tip" to "Dip inward gracefully right at the eye-level bridge before projecting the nose outward."
                        ),
                        checklist = listOf(
                            "Nose bridge overlaps the far eye naturally on steep 3/4 rotations.",
                            "Both eyes sit snugly inside unified shadow-grouped eye sockets.",
                            "Eyeglass frames or cheekbones follow the curved facial barrel."
                        ),
                        criteria = "Complete 5 integrated upper-face mask studies.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_eyes_nose",
                        reinforcedSkillIds = listOf("sk_loomis_head")
                    )
                )
            ),
            buildUnit(
                10, 3, "w10_u3", "Mouth, Ears & Hair Volumes",
                "Wrap lips around the curved dental barrel, simplify the ear's Y-cartilage, and sculpt hair seamlessly onto the skull.",
                listOf(
                    LessonSpec(
                        id = "w10_u3_l1",
                        title = "Lips Wrapping the Dental Cylinder",
                        subtitle = "5-pillow lip volume without cartoon outlines",
                        objective = "Construct mouths wrapping faithfully around the curved horseshoe dental cylinder using 5 soft volume pillows and corner tuck shadows.",
                        explanation = "Beginner mouths look pasted flat on the face because they ignore that teeth and gums form a **curved cylindrical barrel**! Plus, lips have NO dark outer wire outlines—they are **5 interlocking pillow forms** (center top tubercle + two upper wings, two plump lower lobes) defined mostly by the dark parting crease, upper-lip downward shadow plane, and crisp pocket shadow tucked under the bottom lip!",
                        whyItMatters = "Gives portraits relaxed, supple mouths that wrap convincingly around 3/4 turns.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Mirror", "Sketchbook"),
                        steps = listOf(
                            "Draw the curved cylindrical muzzle mound from nose base to chin FIRST.",
                            "Curve the central mouth parting line cleanly around that cylinder—never a flat straight horizontal line! Note the gentle Cupid's bow dip and upturned/downturned corner tucks.",
                            "Notice under normal top lighting: the **upper lip tilts downward into shadow** while the **lower lip catches bright light** and casts a crisp shadow down onto the chin crease!"
                        ),
                        ex1Title = "Dental Cylinder + 5-Pillow Mouths",
                        ex1Desc = "Draw 4 tilted muzzle cylinders and construct 4 wrapping mouths (front, 3/4 left showing far corner receding sharply, profile silhouette, slight open smile).",
                        ex1Reps = "4 cylindrical lip constructions",
                        ex1Min = 14,
                        ex2Title = "Outline-Free Lit Lip Modeling",
                        ex2Desc = "Render 3 closed relaxed mouths using ZERO dark bottom-lip outlines—let the upper lip plane (#5–#6), crisp center parting line (#8), and under-lip cast shadow (#7) define the entire form.",
                        ex2Reps = "3 outline-free shaded mouths",
                        ex2Min = 12,
                        ex3Title = "Teeth Grouping Without Chiclet Grid",
                        ex3Desc = "Draw 2 gentle open-mouth smiles grouping upper teeth into ONE clean light ribbon fading softer/darker back into the mouth corners—NEVER draw heavy black vertical lines between teeth!",
                        ex3Reps = "2 natural smile-teeth studies",
                        ex3Min = 8,
                        challengeTitle = "3/4 Laughing Mouth & Cheek Dimples",
                        challengeDesc = "Observe your own big smile in a mirror; draw the parted lips curving over teeth while cheek mounds push upward under the eyes.",
                        challengeReps = "1 live expressive smile study",
                        challengeMin = 13,
                        mistakes = listOf(
                            "Tracing a dark outline around the bright lower lip" to "Leave the lower-lip outer edge soft/light against the cast shadow directly beneath it.",
                            "Drawing both sides of a 3/4 mouth equal width" to "Compress the far lip wing sharply shorter as it wraps away around the muzzle cylinder!"
                        ),
                        checklist = listOf(
                            "Mouth parting line wraps around a 3D curved muzzle cylinder.",
                            "Far mouth side narrows convincingly on 3/4 angles.",
                            "Upper lip generally reads darker than lower lip under overhead light, with zero dark tooth grids."
                        ),
                        criteria = "Complete 9 cylindrical mouth, outline-free lip, and subtle-teeth studies.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_mouth_ears_hair"
                    ),
                    LessonSpec(
                        id = "w10_u3_l2",
                        title = "Ear Cartilage Simplified (C-and-Y Frame)",
                        subtitle = "Mastering ears without getting lost in squiggles",
                        objective = "Construct accurate tilted ears tucked cleanly into the lower-rear quadrant of the Loomis side slice.",
                        explanation = "Ears look weird only when pasted randomly too high or drawn as arbitrary mazes. On a neutral head, the ear spans **from Brow Line down to Nose Bottom**, leans backward parallel to the nose bridge, and reduces to three crisp shapes: outer **C-rim (helix)**, inner **Y-ridge (antihelix)**, and bottom **lobe + tragus notch** over the dark ear canal!",
                        whyItMatters = "Well-placed ears lock head tilt instantly—moving ears too high makes a head look tilted down, too low makes it look tilted up!",
                        materials = listOf("2H, HB, 2B pencils", "Mirror (use hand mirror if needed) or profile photo", "Sketchbook"),
                        steps = listOf(
                            "Locate the lower-rear quadrant of your Loomis side oval (between brow line and nose line).",
                            "Draw a tilted rounded wedge/C-shape sloping gently backward ~15°.",
                            "Tuck the inner Y-cartilage forks inside, add the small front tragus shield guarding the dark ear bowl (concha), and finish the soft fleshy lobe."
                        ),
                        ex1Title = "Side, 3/4 & Back-View Ear Trio",
                        ex1Desc = "Construct 4 ears: clean side profile, front view (compressed narrow silhouette hugging skull), 3/4 view, and rear view showing the deep bowl projecting off the head!",
                        ex1Reps = "4 multi-angle ear constructions",
                        ex1Min = 13,
                        ex2Title = "Shaded C-and-Y Cartilage Study",
                        ex2Desc = "Shade 2 detailed large ears mapping the bright curved outer helix rim, shadowed upper bowl hollow, and bright raised Y-bridge.",
                        ex2Reps = "2 shaded ear studies",
                        ex2Min = 12,
                        ex3Title = "Head-Tilt Ear Placement Check",
                        ex3Desc = "Draw 3 quick tilted Loomis heads (looking straight, up, down) purely checking how the ear rises ABOVE brow when looking down and drops BELOW nose when looking up!",
                        ex3Reps = "3 ear-pitch alignment checks",
                        ex3Min = 7,
                        challengeTitle = "Ear With Stud / Hoop Earring & Hair Tuck",
                        challengeDesc = "Draw a 3/4 ear half-tucked behind sweeping hair locks with a subtle metal ring hanging vertically with gravity.",
                        challengeReps = "1 ear-and-hair integration study",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing ears vertically straight up and down or pasted flat onto the back of the neck" to "Anchor ears cleanly right behind the jawline hinge tilted gently back.",
                            "Drawing thick dark wire mazes inside the ear" to "Keep internal cartilage soft and rounded—reserve deepest darks for the concha bowl shadow."
                        ),
                        checklist = listOf(
                            "Ears align between brow and nose lines on level views and shift cleanly with head pitch.",
                            "Inner cartilage reads cleanly as outer C-rim + inner Y-ridge + tragus.",
                            "Back views show the curved bowl projecting outward from the skull."
                        ),
                        criteria = "Complete 9 multi-angle ear constructions and head-pitch alignments.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_mouth_ears_hair"
                    ),
                    LessonSpec(
                        id = "w10_u3_l3",
                        title = "Hairlines, Skull Volume & Portrait Hair",
                        subtitle = "Connecting hair roots cleanly to the cranium",
                        objective = "Design realistic hairlines and flowing 3D hair volumes sitting comfortably above the cranial dome without flattening the head.",
                        explanation = "Combine World 7's sculpted hair ribbons with World 10's Loomis skull! Notice how hairlines don't sit as flat straight bangs across a square forehead—they wrap symmetrically back around the temple peaks (widow's peak / temple corners) and cast a soft **hairline shadow** onto the forehead!",
                        whyItMatters = "Makes hair look naturally rooted to a living head instead of wearing a stiff plastic helmet.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Draw the full Loomis head + hairline boundary first (never guess hair without a skull!).",
                            "Offset hair thickness outward cleanly (1–3 cm loft above skull sphere depending on volume).",
                            "Group hair into major sweeping crown, side, and neck clumps, casting a soft shadow strip along the forehead/neck skin underneath."
                        ),
                        ex1Title = "Hairline Architecture Mapping",
                        ex1Desc = "Sketch 4 bare 3/4 Loomis heads and map distinct natural hairlines cleanly around temples, sideburns, and back neck nape.",
                        ex1Reps = "4 anatomical hairline maps",
                        ex1Min = 9,
                        ex2Title = "Three Contrasting Hairstyles on Loomis Heads",
                        ex2Desc = "On 3 constructed heads, render: (1) short cropped textured hair, (2) shoulder-length parted waves, and (3) braided/bun-pulled style showing soft forehead cast shadow.",
                        ex2Reps = "3 styled hair-on-skull portraits",
                        ex2Min = 16,
                        ex3Title = "Beard & Mustache Muzzle Wrap",
                        ex3Desc = "On 1 male Loomis head, wrap a short beard cleanly around the jaw planes and mustache over the curved dental muzzle—remember beards grow in clumped planes too!",
                        ex3Reps = "1 facial-hair volume study",
                        ex3Min = 8,
                        challengeTitle = "Windblown Backlit Portrait Hair",
                        challengeDesc = "Render sweeping windblown ribbons catching bright rim highlights against a subtly toned background (#4).",
                        challengeReps = "1 windswept hair study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Pasting hair flat onto the skull circle with zero lift" to "Build hair outward from the skull surface, especially at the crown and part.",
                            "Hard razor-sharp black line along the forehead hairline" to "Feather the hairline softly with gentle skin-to-root transitions and tiny broken locks."
                        ),
                        checklist = listOf(
                            "Hair clearly sits above and wraps smoothly around a full 3D skull.",
                            "Hairlines turn realistically around temple peaks and sideburns.",
                            "Hair casts soft grounding shadows onto forehead, ears, and neck."
                        ),
                        criteria = "Complete 8 hairline, multi-style, and facial-hair skull integration studies.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_mouth_ears_hair",
                        reinforcedSkillIds = listOf("sk_tex_organic")
                    )
                )
            ),
            buildUnit(
                10, 4, "w10_u4", "Expressions, Likeness & Full Portraits",
                "Capture authentic emotion through muscle squash/stretch and execute complete portrait plates from life or reference.",
                listOf(
                    LessonSpec(
                        id = "w10_u4_l1",
                        title = "Facial Expressions: Squash, Stretch & Folds",
                        subtitle = "Moving features harmoniously—never isolated emojis",
                        objective = "Render joy, surprise, anger, and sorrow convincingly by moving brow, cheek mounds, jaw drop, and skin creases together.",
                        explanation = "Expression isn't just bending a mouth line up or down! A genuine **smile** lifts cheek fat up, pushes lower eyelids straight/crinkled, widens nostrils, and deepens smile folds. **Anger** pulls brows down and inward, squaring nose-bridge creases. **Surprise** drops the jaw hinge down vertically and raises forehead folds!",
                        whyItMatters = "Breathes genuine humanity, storytelling, and emotional warmth into portraits and characters.",
                        materials = listOf("2H, HB, 2B pencils", "Mirror (make the faces yourself!)", "Sketchbook"),
                        steps = listOf(
                            "Look in a mirror and act out Surprise, Joy, Anger, and Skepticism—feel which muscles tighten and where skin folds bunch!",
                            "Start every face with a quick Loomis ball-and-jaw adjustment (notice how Surprise stretches the jaw lower while Joy puffs cheeks upward!).",
                            "Connect brow movement, cheek push, eyelid squeeze, and mouth shape simultaneously."
                        ),
                        ex1Title = "4-Expression Live Mirror Sheet",
                        ex1Desc = "Sketch your own face in a mirror across 4 distinct emotions (Genuine Laugh, Furrowed Concentration/Anger, Shocked Jaw-Drop Surprise, Subtle Smirk).",
                        ex1Reps = "4 mirror expression studies",
                        ex1Min = 16,
                        ex2Title = "Jaw-Drop Hinge Mechanics",
                        ex2Desc = "Draw 3 side/3/4 heads showing a closed mouth, half-open yell, and wide yawn—rotate the lower jaw down strictly around the ear hinge point!",
                        ex2Reps = "3 hinged jaw-open studies",
                        ex2Min = 9,
                        ex3Title = "Subtle Micro-Expression Pair",
                        ex3Desc = "Draw two nearly identical relaxed heads changing ONLY slight brow angle and tiny mouth-corner tension to shift mood from 'warm calm' to 'quiet worry'.",
                        ex3Reps = "2 subtle emotional shifts",
                        ex3Min = 8,
                        challengeTitle = "Laughing Wrinkles & Nasolabial Folds",
                        challengeDesc = "Render an older smiling face celebrating character lines around eyes (crow's feet) and deep joyful cheek folds without over-darkening every crease.",
                        challengeReps = "1 character-line expression portrait",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Smiling mouth paired with dead relaxed lower eyelids" to "Push lower eyelids gently upward into crescent 'smize' curves whenever cheeks lift!",
                            "Sliding the whole chin straight down vertically instead of swinging backward on the ear hinge" to "Swing the jaw open along an arc centered right under the ear."
                        ),
                        checklist = listOf(
                            "Every emotion moves brows, eyelids, cheeks, and mouth harmoniously.",
                            "Open mouths pivot cleanly on the rear jaw hinge under the ear.",
                            "Skin creases follow muscle compression rather than flat lines."
                        ),
                        criteria = "Complete 9 live expression, jaw-hinge, and subtle mood portrait studies.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_expressions"
                    ),
                    LessonSpec(
                        id = "w10_u4_l2",
                        title = "Portrait Lighting Schemes & Planes",
                        subtitle = "Rembrandt, Loop, Split & Rim portrait lighting",
                        objective = "Recognize and render classic portrait lighting patterns (Loop, Rembrandt triangle, Split) cleanly across facial geometry.",
                        explanation = "Great portraits owe 50% of their drama to **lighting geometry**: **Loop light** casts a neat little downward nose-shadow loop beside the nostril; **Rembrandt light** connects the nose shadow cleanly to the cheek shadow leaving a glowing lit triangle under the far eye; **Split light** halves the face dramatically in light vs. shadow!",
                        whyItMatters = "Lets you light imaginative faces cleanly and pick flattering or dramatic angles when drawing portraits.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Mirror + movable desk lamp", "Sketchbook"),
                        steps = listOf(
                            "Position a single lamp beside/above your face in a dim room mirror (or use clear lit reference).",
                            "Rotate the lamp gently from front-45° (Loop) -> side-45° (Rembrandt triangle) -> 90° side (Split).",
                            "Sketch 3 rapid 2-value portrait block-ins strictly capturing the exact shadow pattern unifying brow, nose, cheek, and neck!"
                        ),
                        ex1Title = "Loop vs. Rembrandt vs. Split Trio",
                        ex1Desc = "Sketch 3 medium 3/4 heads demonstrating Loop, Rembrandt (lit cheek triangle), and Split chiaroscuro lighting strictly in unified 2-value shadow mapping.",
                        ex1Reps = "3 classic lighting-scheme heads",
                        ex1Min = 15,
                        ex2Title = "Mirror Rembrandt Portrait Refinement",
                        ex2Desc = "Set your lamp to Rembrandt 45° angle, map the unified shadow shape cleanly across your face, then spend 12 minutes turning soft cheek halftones and crisp eyes.",
                        ex2Reps = "1 Rembrandt live portrait study",
                        ex2Min = 15,
                        ex3Title = "Neck & Collar Cast Shadow Grounding",
                        ex3Desc = "Verify on your studies that the chin casts a clean curved shadow down across the cylinder of the neck.",
                        ex3Reps = "1 jaw-cast-shadow check",
                        ex3Min = 4,
                        challengeTitle = "Dramatic Back-Rim Portrait Silhouette",
                        challengeDesc = "Light a head mainly from behind/side so 75% of the face sits in luminous shadow bathed in soft bounce light while one crisp #1 rim silhouette glows.",
                        challengeReps = "1 backlit rim portrait",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Making the Rembrandt cheek triangle bright paper white while forgetting the nose shadow connects smoothly to the dark side cheek" to "Unite nose shadow and far-cheek shadow as one continuous dark shape trapping the glowing cheek triangle.",
                            "Drawing a hard dark line under the jaw instead of modeling the soft chin-to-neck cast shadow" to "Model the neck cylinder curving cleanly underneath the jaw's soft cast edge."
                        ),
                        checklist = listOf(
                            "Lighting schemes read immediately at thumbnail size.",
                            "Shadow shapes unite brow, nose, upper lip, and jaw consistently.",
                            "Reflected light under the jaw stays subtly darker than lit cheek halftones."
                        ),
                        criteria = "Complete Loop, Rembrandt, Split, and live Rembrandt portrait studies.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_expressions",
                        reinforcedSkillIds = listOf("sk_form_shadow", "sk_loomis_head")
                    ),
                    LessonSpec(
                        id = "w10_u4_l3",
                        title = "Complete Sustained Portrait Workflow",
                        subtitle = "Synthesizing structure, likeness, expression, and light",
                        objective = "Execute a sustained 30-minute monochrome portrait from Loomis construction through subtle likeness adjustments and focal eye polish.",
                        explanation = "Guides you step by step through a full finished portrait: (1) Placement & Tilt Envelope -> (2) Loomis Ball + Slice + Custom Proportions -> (3) Unified 2-Value Shadow Map -> (4) Feature Architecture -> (5) Tonal Modeling & Selective Hair/Edge Polish.",
                        whyItMatters = "Brings all World 10 disciplines together cleanly ahead of your Portrait Milestone Plate.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded + vinyl erasers", "A4 drawing paper", "Mirror or clear lit portrait reference"),
                        steps = listOf(
                            "Block head angle, neck tilt, and shoulders lightly in 2H.",
                            "Build Loomis sphere, side slice, custom facial thirds, and feature anchor boxes—verify likeness proportions BEFORE shading!",
                            "Map unified 2-value light/shadow pattern across face, neck, and hair clumps.",
                            "Model eyes, nose prism, lips, ears, and sculpted hair ribbons—keeping sharpest contrast on focal eyes and softening outer hair/neck edges."
                        ),
                        ex1Title = "Likeness-Checked Loomis Scaffold",
                        ex1Desc = "Build a complete 2H structural portrait block-in (head, neck, shoulders, custom thirds, feature planes, and shadow boundary lines) and audit every plumb alignment.",
                        ex1Reps = "1 audited structural portrait block-in",
                        ex1Min = 10,
                        ex2Title = "2-Value Shadow & Facial Modeling",
                        ex2Desc = "Fill shadow families smoothly, model planar eye sockets, nose underside, cylindrical lips, and subtle cheek halftones.",
                        ex2Reps = "1 modeled portrait tonal pass",
                        ex2Min = 14,
                        ex3Title = "Focal Eyes, Hair Clumps & Soft Edges",
                        ex3Desc = "Sharpen iris/catchlight/lid thickness contrast, sculpt flowing hair ribbons, and soften outer collar/back-hair edges.",
                        ex3Reps = "1 finished portrait study",
                        ex3Min = 10,
                        challengeTitle = "15-Minute Rapid Portrait Capture",
                        challengeDesc = "Immediately afterward, paint a brisk 15-minute live mirror or reference sketch applying the exact same whole-to-part order at double speed!",
                        challengeReps = "1 brisk 15-min portrait capture",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Rendering a hyper-detailed left eye in minute 4 before mapping both eyes and mouth" to "Work strictly whole-to-part—keep eyes, nose, and mouth at equal rough polish until proportions lock.",
                            "Making hair outlines sharper and darker than the focal eyes" to "Keep sharpest edge focus on eyes, nose tip, and mouth center while letting outer hair soften."
                        ),
                        checklist = listOf(
                            "Head sits solidly on a forward-leaning neck and shoulder collar.",
                            "Features wrap faithfully around the curved 3D facial mask.",
                            "Focal contrast naturally draws the eye straight to the subject's gaze."
                        ),
                        criteria = "Complete the full sustained portrait workflow to unlock World 10's Milestone Project.",
                        diagramType = DiagramType.LOOMIS_HEAD_PROPORTIONS,
                        primarySkillId = "sk_expressions",
                        reinforcedSkillIds = listOf("sk_loomis_head", "sk_eyes_nose", "sk_mouth_ears_hair")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w10",
            worldNumber = 10,
            title = "Multi-Angle Portrait & Expression Plate",
            brief = "Create a classic portrait portfolio sheet featuring 1 sustained finished 3/4 head-and-shoulders portrait (from life/mirror or high-contrast monochrome reference) alongside 2 smaller dynamic head-tilt/expression studies sharing clean Loomis structure, lighting unity, and expressive likeness.",
            combinedSkills = listOf("Loomis Head Construction", "Eyes & Nose Structure", "Mouth, Ears & Hair", "Expression & Portrait Lighting"),
            requiredMaterials = listOf("2H, HB, 2B, 4B pencils", "Kneaded & vinyl erasers", "A4/A3 Bristol or smooth drawing paper", "Mirror or clear portrait reference"),
            phases = listOf(
                "Phase 1 (6 min): Lay out sheet composition placing 1 large hero portrait + 2 supporting expression/angle studies.",
                "Phase 2 (10 min): Construct all 3 heads with Loomis spheres, temporal slices, custom facial proportions, and neck/shoulder connections.",
                "Phase 3 (10 min): Map 2-value lighting patterns and build solid eye-socket, nose-prism, cylindrical-lip, and ear structures.",
                "Phase 4 (16 min): Model subtle skin halftones, crisp eye catchlights, sculpted hair volumes, and calm atmospheric background tone."
            ),
            selfAssessmentChecklist = listOf(
                "All 3 heads rotate convincingly in 3D space with aligned brow/eye/nose/mouth planes.",
                "Eyes sit inside recessed sockets and lips wrap naturally around the muzzle barrel.",
                "Hair forms sculpted ribbon volumes rooted logically to cranial hairlines.",
                "Value hierarchy spotlights focal gaze cleanly without flat outlines."
            ),
            estimatedMinutes = 42,
            xpReward = 265
        )
    ),

    // WORLD 11: COMPOSITION AND ENVIRONMENTS
    DrawingWorld(
        number = 11,
        id = "world_11",
        title = "Composition and Environments",
        tagline = "Direct the viewer's eye across architecture, landscapes, and narrative monochrome scenes",
        focusSummary = "Combine thumbnail planning, focal contrast, atmospheric depth, architectural scale, and storytelling camera angles to build complete visual worlds.",
        unlockRequirementSummary = "Complete World 10 Milestone & reach Practicing in Portrait skills",
        units = listOf(
            buildUnit(
                11, 1, "w11_u1", "Compositional Armature & Value Thumbnails",
                "Design rock-solid layouts in 3-value postage-stamp thumbnails before investing in full drawings.",
                listOf(
                    LessonSpec(
                        id = "w11_u1_l1",
                        title = "Thumbnail Ideation & 3-Value Notan Design",
                        subtitle = "Solving composition in 90 seconds",
                        objective = "Explore 6 radically different compositional thumbnails for one scene idea using strictly 3 values (Black, Mid-Gray, White).",
                        explanation = "Every master illustrator designs small BEFORE drawing big! A 4×6 cm **3-value thumbnail** forces you to look purely at big abstract dark, gray, and light shapes. If your composition works clearly at stamp size, it will shine at full poster size—if it looks muddy at stamp size, adding tiny bricks won't save it!",
                        whyItMatters = "Prevents spending 3 hours on a poorly framed scene and unlocks limitless layout creativity.",
                        materials = listOf("2B & 4B pencils (broad chisel/flat edge)", "Sketchbook"),
                        steps = listOf(
                            "Rule six tiny 4×6 cm rectangular frames on one page.",
                            "Pick one theme (e.g., 'Lone traveler approaching an old stone bridge').",
                            "In each box, try a completely different camera angle, horizon height, and dark-vs-light shape distribution using ONLY 3 flat values (#1 White, #5 Gray, #9 Dark) in 90 seconds each!"
                        ),
                        ex1Title = "6-Thumbnail Camera & Light Exploration",
                        ex1Desc = "Design 6 distinct 3-value thumbnails for 'Old Lantern-Lit Alleyway or Forest Bridge' shifting high/low horizons and light/dark spotlights.",
                        ex1Reps = "6 ninety-second 3-value thumbnails",
                        ex1Min = 10,
                        ex2Title = "Rule of Thirds & Golden Focal Grids",
                        ex2Desc = "Draw 4 thumbnails placing your focal subject cleanly on 1/3 intersections, using leading road/fence/shadow diagonals pointing directly into it.",
                        ex2Reps = "4 rule-of-thirds lead-in studies",
                        ex2Min = 10,
                        ex3Title = "Value Inversion Check",
                        ex3Desc = "Take your favorite thumbnail and invert its light/dark spotlight (dark silhouette hero against bright sky vs. sunlit white hero against dark forest).",
                        ex3Reps = "2 value-inverted hero pairs",
                        ex3Min = 7,
                        challengeTitle = "10-Thumbnail Storytelling Reel",
                        challengeDesc = "Rule 10 miniature wide 16:9 cinema frames and compose 10 rapid 3-value shots following a quiet walk from forest edge to mountain cabin.",
                        challengeReps = "10 cinematic storyboard thumbnails",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing tiny stick-man details inside a 4 cm box instead of broad tonal shapes" to "Use the broad side of a 4B pencil—banish sharp detail lines during thumbnailing!",
                            "Splitting the scene cleanly 50% top sky / 50% bottom ground" to "Favor 1/3 sky vs. 2/3 ground (or vice versa) for dynamic visual rhythm."
                        ),
                        checklist = listOf(
                            "Every thumbnail reads clearly at arm's length using just 3 values.",
                            "Horizon heights and camera zooms vary boldly across all 6 studies.",
                            "Leading lines naturally pull the viewer's eye toward the focal intersection."
                        ),
                        criteria = "Complete 12 compositional 3-value thumbnails and value inversions.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_comp_focal"
                    ),
                    LessonSpec(
                        id = "w11_u1_l2",
                        title = "Leading Lines, Framing & Focal Hierarchy",
                        subtitle = "Guiding the viewer's gaze deliberately around the page",
                        objective = "Construct natural framing devices (archways, tree branches, shadows) and clear visual pathways leading directly to the focal center.",
                        explanation = "Good compositions choreograph how the viewer's eye enters the frame, pauses at the **Primary Focal Point** (highest contrast + finest edges), visits a **Secondary Accent**, and rests comfortably inside the scene without sliding off the corner!",
                        whyItMatters = "Turns passive snapshots into gripping scenes with clear hierarchy and depth.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Sketchbook"),
                        steps = listOf(
                            "Identify 1 Primary Focal Point and 1 quieter Secondary Focal Point.",
                            "Route roads, railings, rooflines, or diagonal cast shadows inward toward the Primary Focal Point.",
                            "Add a dark foreground framing vignette (overhanging branch, shadowy doorway jamb) to push viewers inward."
                        ),
                        ex1Title = "Natural Frame-Within-Frame Studies",
                        ex1Desc = "Sketch 3 scenes looking through foreground frames (dark stone arch, window frame, overhanging foliage) spotlighting a bright focal subject beyond.",
                        ex1Reps = "3 framed-depth compositions",
                        ex1Min = 12,
                        ex2Title = "Eye-Path Arrow Audit",
                        ex2Desc = "Draw 3 environment thumbnails and lightly trace curved arrows alongside them mapping the exact 1 -> 2 -> 3 path your eye travels across the frame.",
                        ex2Reps = "3 audited eye-flow thumbnails",
                        ex2Min = 9,
                        ex3Title = "Tangent & Edge-Exit Rescue",
                        ex3Desc = "Fix 2 'broken' layout sketches where a bright road shoots straight off a bottom corner by placing a dark rock/shadow stop-block to bounce the eye back inside.",
                        ex3Reps = "2 fixed exit-trap compositions",
                        ex3Min = 7,
                        challengeTitle = "Busy Market Corner Focal Discipline",
                        challengeDesc = "Sketch a crowded street stall scene keeping 3 figures/awnings calm in mid-values so the glowing focal shopkeeper/lantern commands instant attention.",
                        challengeReps = "1 controlled crowd composition",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Letting a bright road or fence run straight out into the corner tip" to "Curve paths gently inward or tuck a darker foreground rock/shadow across the exit corner.",
                            "Giving foreground framing branches sharp bright highlights" to "Keep framing silhouettes calm, slightly darker, and quieter than your Hero."
                        ),
                        checklist = listOf(
                            "Foreground frames push attention effortlessly into the bright focal core.",
                            "No leading line accidentally drags the eye off a page corner.",
                            "Highest value contrast sits strictly on the Primary Focal Point."
                        ),
                        criteria = "Complete 8 eye-flow, foreground framing, and exit-rescue compositions.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_comp_focal"
                    ),
                    LessonSpec(
                        id = "w11_u1_l3",
                        title = "Shape Language & Visual Pacing",
                        subtitle = "Contrasting Big, Medium, and Small rests against busy zones",
                        objective = "Balance dense architectural/foliage detail areas against calm open rest spaces using Big-Medium-Small rhythm.",
                        explanation = "A drawing packed 100% corner-to-corner with tiny bricks and leaves exhausts the viewer. Grouping intricate details cleanly near focal zones while leaving broad calm sky, smooth shadow walls, or quiet foreground lawns gives the eye vital resting zones!",
                        whyItMatters = "Creates polished professional pacing—letting viewers savor detail where it counts most.",
                        materials = listOf("HB, 2B, 4B pencils", "Sketchbook"),
                        steps = listOf(
                            "Apply the 70/30 pacing principle: roughly 70% calm open mid/light/shadow resting shapes, 30% rich concentrated detail.",
                            "Vary building/tree/rock widths strictly in Big-Medium-Small asymmetrical clusters—never 3 equal spacing intervals!"
                        ),
                        ex1Title = "70/30 Detail-vs-Rest Scene",
                        ex1Desc = "Sketch an old hillside ruin or coastal pier reserving crisp stonework/rigging details ONLY near the focal tower/boat while keeping surrounding sky and cliffs broad and calm.",
                        ex1Reps = "2 detail-paced landscape studies",
                        ex1Min = 14,
                        ex2Title = "Rhythm Variation Silhouette Strips",
                        ex2Desc = "Draw 3 horizontal skyline silhouettes: Strip A boring equal boxes; Strip B dynamic Big-Medium-Small asymmetrical grouping with varied gaps.",
                        ex2Reps = "3 skyline rhythm comparisons",
                        ex2Min = 8,
                        ex3Title = "Foreground Quiet Anchor",
                        ex3Desc = "Draw an atmospheric hill path where a simple smooth dark foreground shadow sweeps cleanly across the bottom, anchoring detailed midground cottages.",
                        ex3Reps = "2 calm-foreground studies",
                        ex3Min = 8,
                        challengeTitle = "Minimalist Horizon & Lone Tree Plate",
                        challengeDesc = "Create a poetic wide-horizon drawing where 80% is calm graded sky/field and 20% is an intricately detailed wind-bent oak and stone fence.",
                        challengeReps = "1 minimalist contrast plate",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Repeating identical window or tree spacing rhythmically across the frame" to "Break patterns into paired clusters, gaps, and varied silhouette heights.",
                            "Drawing brick-by-brick across an entire background wall" to "Cluster 5–8 suggested bricks right near light edges and leave the rest smoothly toned."
                        ),
                        checklist = listOf(
                            "Calm open areas clearly let detailed focal areas shine.",
                            "Object heights and spacing vary organically in Big-Medium-Small groups.",
                            "The scene feels breathable rather than cluttered."
                        ),
                        criteria = "Complete 7 visual pacing, skyline rhythm, and detail-economy studies.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_comp_focal"
                    )
                )
            ),
            buildUnit(
                11, 2, "w11_u2", "Architectural Scenes & Scale Figures",
                "Construct convincing streetscapes, interiors, rooftops, and human scale inside multi-plane perspective.",
                listOf(
                    LessonSpec(
                        id = "w11_u2_l1",
                        title = "Streetscapes, Facades & Scale People",
                        subtitle = "Bringing urban architecture to human scale",
                        objective = "Construct believable multi-building street scenes populated with horizon-aligned scale figures, awnings, and street furniture.",
                        explanation = "A grand cathedral or cozy alleyway feels meaningless without scale cues! Placing simple gesture silhouettes of standing pedestrians whose **eyes sit right ON the Horizon Line** (for flat streets!) immediately tells the viewer whether a doorway is 2 meters tall or 10 meters towering!",
                        whyItMatters = "Unlocks urban sketching, environment concept plates, and lively architectural drawings.",
                        materials = listOf("2H, HB, 2B pencils (or fineliner)", "Sketchbook"),
                        steps = listOf(
                            "Establish a clear Horizon Line at standing eye height (~1.65 m) and 1- or 2-point VPs.",
                            "Construct 3–5 staggered building masses with recessed doors, balconies, and roof overhangs.",
                            "Drop standing scale figures at near, middle, and far depths—lining EVERY standing adult's eyes directly onto the Horizon Line!"
                        ),
                        ex1Title = "Horizon-Anchored Crowd Scale Strip",
                        ex1Desc = "Draw a receding 1-point plaza floor and place 8 simple gesture silhouettes at 8 depths—all with eye-lines locked strictly on the Horizon Line while feet scale naturally.",
                        ex1Reps = "2 plaza scale-figure checks",
                        ex1Min = 10,
                        ex2Title = "2-Point Corner Café Streetscape",
                        ex2Desc = "Build a lively corner bakery/café with recessed awning, sidewalk tables, hanging streetlamp, and 3 walking pedestrians in accurate perspective.",
                        ex2Reps = "1 complete streetscape sketch",
                        ex2Min = 16,
                        ex3Title = "Sloped Hill Street Adjustment",
                        ex3Desc = "Sketch a street sloping gently UPHILL: notice how pedestrian eye-lines climb ABOVE the level horizon as the sidewalk rises!",
                        ex3Reps = "1 sloped-hill street study",
                        ex3Min = 8,
                        challengeTitle = "Grand Archway Train Hall",
                        challengeDesc = "Construct a soaring vaulted glass-and-iron train terminal with towering trusses above tiny human scale figures on the platform below.",
                        challengeReps = "1 monumental interior plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Drawing distant people with feet on the ground and heads huge—making them look like 4-meter giants" to "Lock every flat-ground standing person's eye height onto the Horizon Line!",
                            "Cardboard-flat facades lacking porch steps, gutters, and window depth" to "Add recessed sill thicknesses and protruding rooflines."
                        ),
                        checklist = listOf(
                            "Flat-ground scale figures share the Horizon Line at eye level.",
                            "Doorways, tables, and benches match human height logically.",
                            "Facades display believable thickness and architectural overhangs."
                        ),
                        criteria = "Complete plaza scale strips, corner café streetscape, and sloped-street study.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_arch_env",
                        reinforcedSkillIds = listOf("sk_2pt_persp")
                    ),
                    LessonSpec(
                        id = "w11_u2_l2",
                        title = "Lived-In Interiors & Overlapping Furniture",
                        subtitle = "Telling stories through rooms and props",
                        objective = "Design a multi-plane interior room (foreground doorway/chair, midground focal desk/hearth, sunlit window) with cohesive cast shadows.",
                        explanation = "Great interiors feel inhabited: a chair slightly turned out from a desk, an open book, dappled window light slicing across floorboards and rugs, and overlapping layers creating cozy depth.",
                        whyItMatters = "Builds storytelling interior scenes for illustration, comics, and observational room journaling.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Sketchbook"),
                        steps = listOf(
                            "Plan a 3-layer interior thumbnail (Foreground edge prop -> Midground focal area -> Sunlit back window/wall).",
                            "Construct room perspective shell, furniture floor footprints, and rotated chairs cleanly in 2H.",
                            "Project sharp sunlight window panes across floors, walls, and furniture as unified shadow patterns."
                        ),
                        ex1Title = "Window-Sunbeam Studio Corner",
                        ex1Desc = "Sketch an artist/writer desk beside a sunlit window, projecting the window-sash light beam cleanly across the desk and floor rugs.",
                        ex1Reps = "1 sunlit interior study",
                        ex1Min = 16,
                        ex2Title = "Foreground Silhouette Doorway Entry",
                        ex2Desc = "Frame a cozy kitchen/living room through a slightly open dark foreground doorway to create dramatic near-to-far depth.",
                        ex2Reps = "1 doorway-framed room study",
                        ex2Min = 14,
                        ex3Title = "Clutter Simplification Pass",
                        ex3Desc = "Draw a packed bookshelf or kitchen counter—group rows of books/jars into rhythmic Big-Medium-Small tonal clusters rather than drawing 80 identical spines.",
                        ex3Reps = "1 simplified shelf cluster",
                        ex3Min = 7,
                        challengeTitle = "Cozy Attic Workshop in 3-Point Plunge",
                        challengeDesc = "Draw a high-angle corner view looking down into a slanted-rafter attic studio with skylights, cluttered workbench, and coiled cables.",
                        challengeReps = "1 tilted-rafter attic scene",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Forgetting to bend window sunbeam light when it drops off a table edge onto the floor" to "Project light angles like inverse shadows—vertical drops step cleanly down onto lower planes!",
                            "Aligning every chair and rug stiffly parallel to the walls" to "Angle one chair or pair of slippers casually for lived-in realism."
                        ),
                        checklist = listOf(
                            "Room contains clear Foreground, Midground, and Background planes.",
                            "Furniture footprints rest cleanly on the perspective floor.",
                            "Window light and cast shadows tie props and room architecture together."
                        ),
                        criteria = "Complete sunlit interior, framed room, and simplified clutter studies.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_arch_env",
                        reinforcedSkillIds = listOf("sk_1pt_persp", "sk_cast_shadow")
                    ),
                    LessonSpec(
                        id = "w11_u2_l3",
                        title = "Architecture Meets Nature (Bridges, Ruins & Villages)",
                        subtitle = "Integrating man-made geometry with organic terrain",
                        objective = "Embed geometric perspective structures (bridges, staircases, cottages) naturally onto curving slopes, cliffs, and tree lines.",
                        explanation = "Putting rigid perspective buildings onto organic hills fails when walls look floating above grass! Always cut horizontal **foundation steps** into sloped terrain, overlap foreground grass/shrubs cleanly over wall bases, and let organic moss/roots climb stone joints.",
                        whyItMatters = "Unlocks pastoral villages, mountain bridges, ruins, and fantasy/historical environments.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Sketchbook"),
                        steps = listOf(
                            "Sketch the sweeping hills, river bank, or cliff slopes first.",
                            "Plant horizontal architectural foundation lines slicing firmly INTO the hillside (never perched on tiptoes!).",
                            "Weave overhanging tree canopies, stone steps curving with terrain, and soft ground shadows together."
                        ),
                        ex1Title = "Hillside Stone Bridge & Creek",
                        ex1Desc = "Construct an arched stone footbridge anchored into uneven rocky creek banks with soft water reflections and framing tree roots.",
                        ex1Reps = "1 arched bridge-in-nature plate",
                        ex1Min = 16,
                        ex2Title = "Stepped Cottage on Winding Trail",
                        ex2Desc = "Draw a 2-point stone cottage nestled into a grassy slope with winding dirt path and leaning wooden fence posts climbing the hill.",
                        ex2Reps = "1 hillside cottage study",
                        ex2Min = 15,
                        ex3Title = "Overgrown Ruin Wall Integration",
                        ex3Desc = "Draw a crumbling stone wall where tree roots twist over masonry seams and wild weeds break the rigid base edge.",
                        ex3Reps = "1 overgrown ruin study",
                        ex3Min = 8,
                        challengeTitle = "Cliffside Lighthouse & Crashing Surf",
                        challengeDesc = "Build a cylindrical lighthouse + keeper's cottage anchored into jagged coastal cliff strata overlooking foamy dark-to-light waves.",
                        challengeReps = "1 coastal cliff architecture plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Drawing flat straight horizontal bottom edges on buildings sitting on sloped hills" to "Step the foundation down the slope or tuck grass/shrubs organically across the uphill seam.",
                            "Drawing fence posts leaning parallel to a steep hill slope" to "Gravity pulls fence posts and tree trunks straight **vertical** even on steep hillsides!"
                        ),
                        checklist = listOf(
                            "Architectural foundations anchor solidly into uneven ground contours.",
                            "Vertical poles and walls stay plumb to gravity even on sloped hills.",
                            "Organic foliage overlaps crisp masonry edges naturally."
                        ),
                        criteria = "Complete hillside bridge, cottage, and overgrown ruin integration studies.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_arch_env",
                        reinforcedSkillIds = listOf("sk_trees_terrain", "sk_2pt_persp")
                    )
                )
            ),
            buildUnit(
                11, 3, "w11_u3", "Atmospheric Depth & Dramatic Lighting",
                "Separate near, mid, and far planes cleanly with atmospheric value compression and cinematic lighting moods.",
                listOf(
                    LessonSpec(
                        id = "w11_u3_l1",
                        title = "Foreground / Midground / Background Separation",
                        subtitle = "Stacking 3–4 crisp depth planes effortlessly",
                        objective = "Control tonal range, edge contrast, and detail density cleanly across 4 distinct depth zones in one environment.",
                        explanation = "Atmospheric perspective works indoors AND outdoors: **Plane 1 (Foreground)**: full #1–#9 range, boldest darks, sharpest texture; **Plane 2 (Midground Hero)**: #2–#8 crisp focal clarity; **Plane 3 (Far Midground)**: compressed #3–#6 soft edges; **Plane 4 (Distance/Sky)**: pale misty #1–#3.5 whisper-light shapes!",
                        whyItMatters = "Gives complex multi-layer scenes instant effortless 3D readability with zero muddy confusion.",
                        materials = listOf("2H, HB, 2B, 4B, 6B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Draw a 4-band depth ladder in your margin assigning exact allowable value ranges to Planes 1, 2, 3, and 4.",
                            "Execute a multi-plane forest path, canyon, or city rooftop scene strictly obeying those plane value caps!",
                            "Notice how zero #9 blacks appear in Plane 3 or Plane 4."
                        ),
                        ex1Title = "4-Plane Value Ladder Landscape",
                        ex1Desc = "Compose a misty valley or forest ridge with 4 distinct overlapping hills/tree-lines obeying strict foreground-to-horizon contrast compression.",
                        ex1Reps = "2 four-plane depth plates",
                        ex1Min = 15,
                        ex2Title = "Receding Alleyway Haze Study",
                        ex2Desc = "Draw a narrow urban alley receding into morning fog—keep near cobblestones/dumpsters crisp #9 black while buildings 50 meters back dissolve to pale #3 silhouettes.",
                        ex2Reps = "1 foggy alleyway depth study",
                        ex2Min = 14,
                        ex3Title = "Overlap-Fog Edge Lift",
                        ex3Desc = "Use a gentle kneaded eraser swipe right behind a dark foreground tree trunk or building corner to create subtle luminous mist separation.",
                        ex3Reps = "2 aerial separation checks",
                        ex3Min = 6,
                        challengeTitle = "Layered Pine Ridge & Valley Village",
                        challengeDesc = "Combine dark gnarled foreground pines, crisp sunlit midground village roofs, misty far church spire, and pale distant mountain peaks.",
                        challengeReps = "1 epic multi-plane alpine plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Putting pitch-black 4B shadows onto distant background hills" to "Restrict distant planes to light 2H/HB values so they physically recede.",
                            "Drawing uniform dark outlines around overlapping hills" to "Let the light edge of a ridge meet misty air softly without wire outlines."
                        ),
                        checklist = listOf(
                            "All 4 depth planes separate unmistakably at a glance.",
                            "Distant planes carry narrower value contrast and softer edges than near planes.",
                            "Subtle light-behind-dark separation pops the midground hero forward."
                        ),
                        criteria = "Complete 5 multi-plane atmospheric depth and fog-separation studies.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_atmo_depth"
                    ),
                    LessonSpec(
                        id = "w11_u3_l2",
                        title = "Light Moods: Noon, Dusk, Backlit & Lantern",
                        subtitle = "Using lighting key and shadow stretch for emotion",
                        objective = "Render the exact same simple environment under 3 radically different lighting moods (harsh noon, golden low-sun dusk, dramatic night lantern).",
                        explanation = "Lighting sets emotional tone! **High-Key Noon** feels crisp and open with short punchy shadows; **Low-Angle Dusk** stretches dramatic long shadows across everything; **Night Point-Light** (campfire/lantern) plunges the world into rich #7–#9 darks with radial falloff glowing around one warm focal hub!",
                        whyItMatters = "Turns environments from neutral architectural diagrams into evocative emotional art.",
                        materials = listOf("HB, 2B, 4B, 6B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Sketch one simple 3-element environment (e.g., stone well + tree + cabin door) 3 times side by side.",
                            "Panel 1 (High Noon): bright paper #1–#3 dominance, crisp short under-shadows.",
                            "Panel 2 (Low Sunset): long sweeping horizontal shadow bands slicing across the ground.",
                            "Panel 3 (Night Lantern): tone whole scene #6–#8 first, then lift a bright radial halo around the lantern casting outward-stretching shadows!"
                        ),
                        ex1Title = "3-Mood Same-Scene Triptych",
                        ex1Desc = "Draw one cabin/courtyard scene three times in a horizontal triptych: Harsh Noon, Long-Shadow Dusk, and Night Lantern Point-Light.",
                        ex1Reps = "1 three-mood lighting triptych",
                        ex1Min = 18,
                        ex2Title = "Dappled Tree Canopy Shadows",
                        ex2Desc = "Draw a sunlit garden path and drape irregular lacy dappled tree shadows rippling smoothly over path bumps, bench, and wall.",
                        ex2Reps = "1 dappled-light environment study",
                        ex2Min = 12,
                        ex3Title = "Moonlit Silhouette Contrast",
                        ex3Desc = "Sketch a dark lakeside dock and boat backlit strictly by bright #1 moonlight shimmer across dark #7 water.",
                        ex3Reps = "1 backlit night silhouette",
                        ex3Min = 8,
                        challengeTitle = "Shafts of God-Rays in Deep Forest",
                        challengeDesc = "Tone a dense forest canopy dark (#6–#8), then cleanly lift diagonal volumetric sunbeams slicing across mist and mossy tree trunks.",
                        challengeReps = "1 volumetric light-shaft forest plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Leaving the surrounding sky white in a night lantern drawing" to "Establish a genuinely dark night tone (#6–#9) everywhere EXCEPT around the glowing light radius!",
                            "Forgetting that point-light shadows fan radially outward from the lantern rather than staying parallel" to "Aim cast shadow rays directly away from the lantern bulb itself."
                        ),
                        checklist = listOf(
                            "All 3 triptych panels evoke unmistakably distinct times of day.",
                            "Night lantern shadows radiate outward cleanly from the single bulb point.",
                            "Dappled ground shadows curve smoothly over terrain and objects."
                        ),
                        criteria = "Complete the 3-mood triptych, dappled sunlight, and moonlit silhouette studies.",
                        diagramType = DiagramType.CAST_SHADOW_LOGIC,
                        primarySkillId = "sk_atmo_depth",
                        reinforcedSkillIds = listOf("sk_value_scale")
                    ),
                    LessonSpec(
                        id = "w11_u3_l3",
                        title = "Dynamic Weather: Rain, Mist & Wind Motion",
                        subtitle = "Drawing atmosphere and motion in monochrome",
                        objective = "Convey atmospheric rain streaks, puddles/wet reflections, fog layers, and wind-bent foliage coherently across a scene.",
                        explanation = "Weather alters value and edge physics everywhere at once: **Rain** darkens vertical wet masonry slightly, turns streets into glossy **mirror puddles** reflecting lights vertically, softens distant planes in mist, and adds subtle diagonal rain streaks only over darker backdrops!",
                        whyItMatters = "Adds rich cinematic storytelling atmosphere to urban or natural scenes.",
                        materials = listOf("HB, 2B, 4B pencils", "Sharp vinyl + kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Lay a cool misty overcast value atmosphere (#2–#7, softening harsh bright sun shadows).",
                            "On wet street ground, invert vertical buildings/lamps softly downward inside dark mirror puddle patches.",
                            "Lift subtle diagonal rain streaks with a sharp eraser corner strictly across mid-dark walls/umbrellas—plus splashes on the curb."
                        ),
                        ex1Title = "Rainy Wet-Pavement Street Corner",
                        ex1Desc = "Sketch a simple streetlamp and corner shop doorway in rain—focus on dark glossy street mirror reflections, figure holding an umbrella, and crisp lifted rain streaks.",
                        ex1Reps = "1 rainy-street atmosphere plate",
                        ex1Min = 16,
                        ex2Title = "Windswept Meadow & Leaning Pines",
                        ex2Desc = "Draw a windswept hilltop tree with sweeping diagonal directional grass clusters and bent cloud tails all leaning consistently with one strong gale.",
                        ex2Reps = "1 wind-motion landscape",
                        ex2Min = 10,
                        ex3Title = "Snow-Muffled Edge Softness",
                        ex3Desc = "Sketch a winter pine/fencepost muffled in thick rounded white snow pillows—notice how crisp hard corners disappear beneath soft #1 sunlit snow caps!",
                        ex3Reps = "1 winter snow-blanket study",
                        ex3Min = 10,
                        challengeTitle = "Stormy Harbor Pier & Lighthouse",
                        challengeDesc = "Combine whipping sea spray, angled rain gusts, dark churning foreground swells, and a piercing lighthouse beam.",
                        challengeReps = "1 stormy seascape plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Drawing thick dark black rain lines everywhere like barbed wire" to "Keep rain whisper-thin—light lifted streaks against dark shadows, faint midtone streaks only selectively!",
                            "Drawing wet street reflections sideways instead of straight vertically downward" to "Drop mirror reflections straight plumb underneath each lamp/building."
                        ),
                        checklist = listOf(
                            "Wet reflections drop vertically straight below lights and structures.",
                            "Wind direction stays unified across grass, trees, clothes, and clouds.",
                            "Rain streaks appear selectively against dark backgrounds without clutter."
                        ),
                        criteria = "Complete rain-puddle, windswept, and winter weather studies.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_atmo_depth"
                    )
                )
            ),
            buildUnit(
                11, 4, "w11_u4", "Visual Storytelling & Environmental Synthesis",
                "Place expressive figures naturally inside designed environments using camera pitch, silhouette clarity, and narrative focus.",
                listOf(
                    LessonSpec(
                        id = "w11_u4_l1",
                        title = "Camera Angle & Emotional Storytelling",
                        subtitle = "Low-angle power vs. high-angle vulnerability",
                        objective = "Tell a visual story intentionally by choosing high-angle (isolation/overview), eye-level (intimacy), or low-angle (heroic/towering) camera viewpoints.",
                        explanation = "Where you place the Horizon Line dictates how the audience *feels*! **Low Horizon (Worm's-eye)** makes a standing traveler or towering tree loom monumental above the viewer. **High Horizon (Bird's-eye)** makes a lone figure look small, vulnerable, or thoughtfully navigating a vast maze!",
                        whyItMatters = "Gives your drawings cinematic directorial power—the core skill of storyboarders, illustrators, and comic artists.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Sketchbook"),
                        steps = listOf(
                            "Take one narrative prompt: 'A courier arrives at an ancient stone gate.'",
                            "Thumbnail Shot A (Low Horizon Heroic): looking up past foreground cobblestones at towering gate + confident silhouette.",
                            "Thumbnail Shot B (High Horizon Vulnerability): perched high on an upper wall looking down into deep courtyard below tiny traveler."
                        ),
                        ex1Title = "High vs. Low Camera Story Pair",
                        ex1Desc = "Execute two 12×15 cm scenes of the exact same narrative encounter—one dramatic low-angle upward shot and one sweeping high-angle downward shot.",
                        ex1Reps = "2 camera-angle narrative panels",
                        ex1Min = 18,
                        ex2Title = "Silhouette Readability Test",
                        ex2Desc = "Place a character silhouette in front of a doorway or rocky ledge—ensure pose silhouette reads instantly without overlapping darkly into dark background clutter!",
                        ex2Reps = "2 high-contrast silhouette checks",
                        ex2Min = 8,
                        ex3Title = "Foreground Story Clue Prop",
                        ex3Desc = "Add one quiet narrative prop in the foreground (dropped satchel, steaming teacup on balcony rail, muddy footprints) hinting at what happened before the frame.",
                        ex3Reps = "2 foreground clue vignettes",
                        ex3Min = 7,
                        challengeTitle = "3-Panel Silent Story Sequence",
                        challengeDesc = "Draw 3 small sequential frames telling a complete wordless micro-story (Wide Establishing -> Medium Character Action -> Dramatic Close-Up).",
                        challengeReps = "1 three-panel visual story",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Hiding the story character darkly right in front of an equally dark bush/shadow" to "Place dark characters against bright background mist/doorways—or bright lit characters against deep background shadows!",
                            "Putting every camera flat at eye-level waist height" to "Shift the Horizon Line intentionally toward top or bottom 1/5 for emotional impact."
                        ),
                        checklist = listOf(
                            "Camera pitch reinforces the emotional mood of each panel.",
                            "Character silhouettes separate cleanly against contrasting background values.",
                            "Props and figure gestures imply a clear ongoing story."
                        ),
                        criteria = "Complete camera-angle storytelling pairs, silhouette checks, and prop vignettes.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_storytelling",
                        reinforcedSkillIds = listOf("sk_3pt_persp", "sk_comp_focal")
                    ),
                    LessonSpec(
                        id = "w11_u4_l2",
                        title = "Populating Scenes With Figures & Props",
                        subtitle = "Integrating people seamlessly into perspective environments",
                        objective = "Place multiple interacting human figures cleanly inside a 2-point environment sharing horizon eye-level, lighting, and cast shadows.",
                        explanation = "Adding figures into environments fails when people look pasted on top like cardboard cutouts! Lock every figure's **floor footprint**, **Horizon eye-level**, **same light direction**, and **ground cast shadow** directly into the room or street perspective.",
                        whyItMatters = "Unites World 9 (Human Figure) cleanly with World 5/11 (Perspective & Environments).",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Sketchbook"),
                        steps = listOf(
                            "Construct a café patio, train bench, or gallery room perspective cleanly first.",
                            "Drop floor footprints and seated/standing mannequin gestures obeying the Horizon Line.",
                            "Connect every figure down onto the floor with matching directional cast shadows and #9 shoe-sole occlusions!"
                        ),
                        ex1Title = "Park Bench & Strolling Figures Scene",
                        ex1Desc = "Construct a park walkway in perspective with 1 seated reader on a bench (note lowered seated eye-level below horizon!) and 2 standing walkers.",
                        ex1Reps = "1 populated park walkway study",
                        ex1Min = 16,
                        ex2Title = "Standing vs. Seated Eye-Height Check",
                        ex2Desc = "Remember: a seated adult's head sits ~30–40% LOWER than a standing adult's eyes on the horizon! Check and draw 2 seated vs. standing interactions.",
                        ex2Reps = "2 seated-standing ratio checks",
                        ex2Min = 8,
                        ex3Title = "Shared Cast Shadow Unification",
                        ex3Desc = "Make sure the bench, tree trunk, and all 3 figures cast shadows at the exact same perspective floor angle.",
                        ex3Reps = "1 unified ground-shadow check",
                        ex3Min = 6,
                        challengeTitle = "Busy Bookshop Interior With 5 Figures",
                        challengeDesc = "Populate a cozy 2-point bookshop aisle with 5 figures (browsing high shelf, seated reading, carrying books, distant clerk) in cohesive perspective & lighting.",
                        challengeReps = "1 five-figure interior plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Putting seated figures' eyes way up on the standing Horizon Line (making them look 2.5 meters tall!)" to "Drop seated heads clearly BELOW standing eye level.",
                            "Forgetting figures' cast shadows when buildings have crisp cast shadows" to "Tie every character solidly to the floor with consistent cast shadows."
                        ),
                        checklist = listOf(
                            "Standing and seated figure heights relate believably to furniture and doors.",
                            "Every figure sits solidly grounded on floor footprints.",
                            "Global light and cast shadows unify figures with architecture."
                        ),
                        criteria = "Complete populated walkway, seated-vs-standing ratios, and unified cast shadow checks.",
                        diagramType = DiagramType.PERSPECTIVE_1_2_3_POINT,
                        primarySkillId = "sk_storytelling",
                        reinforcedSkillIds = listOf("sk_fig_prop", "sk_arch_env")
                    ),
                    LessonSpec(
                        id = "w11_u4_l3",
                        title = "Complete Monochrome Environment Synthesis",
                        subtitle = "From 3-value thumbnail to finished narrative environment",
                        objective = "Execute a full environment workflow: 3-value thumbnail → perspective & figure construction → atmospheric depth → focal lighting & detail.",
                        explanation = "Brings every compositional and environmental tool together smoothly ahead of World 11's Milestone Project.",
                        whyItMatters = "Proves you can direct an entire world on paper—space, mood, architecture, nature, and human presence.",
                        materials = listOf("2H, HB, 2B, 4B, 6B pencils", "Kneaded eraser", "A4 sketchpad"),
                        steps = listOf(
                            "Ideate 3 quick 3-value thumbnails for a chosen narrative location.",
                            "Scale up the winner onto a clean bordered frame: establish Horizon, VPs, architecture, nature, and scale figures.",
                            "Map 4 atmospheric depth zones and global lighting/cast shadows.",
                            "Refine focal contrast, leading lines, and calm outer rest areas."
                        ),
                        ex1Title = "3-Thumbnail Selection & Perspective Grid",
                        ex1Desc = "Sketch 3 thumbnails of a storytelling spot (e.g., mountain observatory, rainy train stop, sunlit library courtyard) and transfer the best into a 2H perspective grid.",
                        ex1Reps = "3 thumbnails + 1 scaled 2H grid",
                        ex1Min = 12,
                        ex2Title = "4-Plane Depth & Lighting Wash",
                        ex2Desc = "Establish foreground/midground/background value ranges cleanly and map major cast shadows across ground, walls, and figures.",
                        ex2Reps = "1 value-mapped environment layer",
                        ex2Min = 12,
                        ex3Title = "Focal Polish & Storytelling Finish",
                        ex3Desc = "Sharpen focal center contrast, add key architectural/foliage textures selectively, and keep distant haze soft.",
                        ex3Reps = "1 finished narrative environment",
                        ex3Min = 14,
                        challengeTitle = "Wide Cinematic Panorama Edition",
                        challengeDesc = "Execute an extra wide 24×10 cm panoramic frame telling a journey across 3 distinct depth transitions.",
                        challengeReps = "1 wide cinematic panorama",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Losing the clarity of your initial 3-value thumbnail during rendering" to "Keep your tiny thumbnail taped right beside your page and squint regularly to match its big dark/light design!",
                            "Over-rendering distant edges equally sharp as foreground" to "Keep distant planes soft and quiet."
                        ),
                        checklist = listOf(
                            "Final full-scale drawing honors the clarity of the 3-value thumbnail.",
                            "Perspective, scale figures, nature, and architecture integrate seamlessly.",
                            "Atmospheric depth and focal hierarchy guide the eye cleanly."
                        ),
                        criteria = "Complete the end-to-end narrative environment workflow to unlock World 11's Milestone.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_storytelling",
                        reinforcedSkillIds = listOf("sk_comp_focal", "sk_arch_env", "sk_atmo_depth")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w11",
            worldNumber = 11,
            title = "Thumbnail-to-Finished Monochrome Environment Plate",
            brief = "Design and render a complete monochrome storytelling environment plate (e.g., misty harbor pier, sunlit courtyard café, mountain temple steps, or rainy street corner) showing your 3-value thumbnail ideation alongside a fully realized perspective scene with architecture, natural elements, scale figures, and 4-plane atmospheric depth.",
            combinedSkills = listOf("Thumbnails & Focal Design", "Architecture & Scale", "Atmospheric Depth & Mood", "Visual Storytelling"),
            requiredMaterials = listOf("2H, HB, 2B, 4B, 6B pencils", "Kneaded & vinyl erasers", "A4/A3 drawing pad", "Clear ruler (light perspective grid only)"),
            phases = listOf(
                "Phase 1 (7 min): Generate 3–4 small 3-value notan thumbnails testing camera angles and lighting mood.",
                "Phase 2 (12 min): Construct clean perspective architecture, natural terrain/trees, and horizon-synced scale figures.",
                "Phase 3 (10 min): Map 4-plane atmospheric value steps and unified cast-shadow lighting design.",
                "Phase 4 (16 min): Polish focal contrast, texture economy, edge softness in distance, and clean #9 foreground anchors."
            ),
            selfAssessmentChecklist = listOf(
                "The finished composition preserves the clear dark/light readability of the chosen thumbnail.",
                "Perspective lines and scale figures feel cohesive and grounded.",
                "Foreground, midground, and distant planes separate cleanly through value compression.",
                "A clear narrative focal point captures attention immediately."
            ),
            estimatedMinutes = 45,
            xpReward = 285
        )
    ),

    // WORLD 12: ARTISTIC INDEPENDENCE
    DrawingWorld(
        number = 12,
        id = "world_12",
        title = "Artistic Independence",
        tagline = "Draw from imagination, analyze masters, shape personal style, and build your portfolio",
        focusSummary = "Build your internal visual library, rotate invented forms from memory, reverse-engineer master drawings, explore intentional stylization, and execute cohesive personal portfolio plates.",
        unlockRequirementSummary = "Complete World 11 Milestone & reach Practicing in Composition skills",
        units = listOf(
            buildUnit(
                12, 1, "w12_u1", "Visual Library & Drawing From Imagination",
                "Train active memory recall, rotational invention, and structured reference synthesis.",
                listOf(
                    LessonSpec(
                        id = "w12_u1_l1",
                        title = "Memory Recall & Rotational Invention",
                        subtitle = "Drawing real subjects cleanly from mental 3D models",
                        objective = "Memorize an object's 3D structural breakdown and reconstruct it from memory at 3 completely new camera angles.",
                        explanation = "'Drawing from imagination' isn't magic—it is simply **recombining a well-stocked 3D visual library**! When you study an object once purely to memorize its primitive recipe (e.g., vintage camera = 2-pt slab + cylinder barrel + dial discs), you can close the reference and rotate that exact camera to ANY invented angle cleanly.",
                        whyItMatters = "Breaks permanent dependence on copying single static photos.",
                        materials = listOf("2H, HB, 2B pencils", "1 real reference item (lamp, shoe, teapot, or bicycle)", "Sketchbook"),
                        steps = listOf(
                            "Observe a real object (e.g., desk lamp or kettle) for 4 minutes while drawing ONLY 1 quick structural recipe breakdown with notes.",
                            "Hide the object completely in a drawer or behind a book!",
                            "Wait 2 minutes, then draw the object from memory at TWO completely new invented camera angles (e.g., looking up from underneath, or rear 3/4) using World 2 & 5 construction!"
                        ),
                        ex1Title = "Study-Hide-Rotate Memory Drill",
                        ex1Desc = "Choose 2 real objects (e.g., vintage mug/kettle and running shoe). Study each for 4 minutes, hide them, and construct both at 2 brand-new angles from memory.",
                        ex1Reps = "4 memory-rotated constructions",
                        ex1Min = 16,
                        ex2Title = "Memory vs. Reality Comparison Audit",
                        ex2Desc = "Bring the hidden objects back out at those exact angles, compare your memory drawings side-by-side, and note 3 forgotten proportion details to fix next time.",
                        ex2Reps = "2 visual-library recall audits",
                        ex2Min = 6,
                        ex3Title = "Mental Primitive Kitbashing",
                        ex3Desc = "Combine memorized parts of 2 real items (e.g., antique lantern frame + bicycle saddle/pedals) into 1 plausible invented object constructed cleanly in 2-point perspective.",
                        ex3Reps = "2 invented kitbash constructions",
                        ex3Min = 10,
                        challengeTitle = "Animal or Pose Memory Turnaround",
                        challengeDesc = "Study a dog or human pose for 3 minutes, hide the reference, and reconstruct the exact pose rotated 90° around the turntable from imagination!",
                        challengeReps = "1 rotated living-form memory turnaround",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Trying to memorize 2D outlines instead of 3D primitive construction recipes" to "Memorize the simple box/cylinder proportions and attachment points—not wavy flat edges.",
                            "Skipping the post-memory audit against reality" to "Checking what you forgot is literally how your brain cements permanent visual library entries!"
                        ),
                        checklist = listOf(
                            "Memory drawings feel structurally solid at brand-new unseen angles.",
                            "Post-audit spotted specific missing structural features accurately.",
                            "Kitbashed invented forms connect cleanly via intersections."
                        ),
                        criteria = "Complete 8 memory-rotation, audit, and kitbashing exercises.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_imagination",
                        reinforcedSkillIds = listOf("sk_form_intersect", "sk_2pt_persp")
                    ),
                    LessonSpec(
                        id = "w12_u1_l2",
                        title = "Intelligent Reference Synthesis (Never Copy Blindly)",
                        subtitle = "Combining multiple references into original scenes",
                        objective = "Synthesize an original composition by pulling pose from Ref A, lighting from Ref B, and costume/architecture from Ref C under one unified perspective.",
                        explanation = "Professionals don't invent every buckle from thin air OR trace one photo slavishly—they **direct references**! You pull a pose from a gesture photo, dress it using a real jacket study, light it with your own studio lamp logic, and plant it inside an original 2-point environment.",
                        whyItMatters = "Lets you create 100% original imaginative scenes that still carry rock-solid observational realism.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Mirror + household props/references", "Sketchbook"),
                        steps = listOf(
                            "Design an original 3-value thumbnail entirely from imagination first (so the composition is YOURS!).",
                            "Identify 3 specific unknowns you need real observation for (e.g., hand gripping lantern -> check your own hand in mirror; trenchcoat fold -> check coat over chair; cobblestone perspective -> construct grid).",
                            "Blend those observed parts seamlessly into your thumbnail's unified perspective and light."
                        ),
                        ex1Title = "Imagination Thumbnail + 3-Ref Callouts",
                        ex1Desc = "Invent a tiny 5×6 cm story thumbnail, list 3 real-world details you'll observe locally (hand pose, coat collar, wooden crate), and sketch those 3 quick reference margins.",
                        ex1Reps = "1 thumbnail + 3 targeted ref studies",
                        ex1Min = 12,
                        ex2Title = "Synthesized Original Scene Render",
                        ex2Desc = "Assemble your invented scene cleanly on a full page, integrating all 3 real observations into one unified horizon and single directional light.",
                        ex2Reps = "1 synthesized original illustration",
                        ex2Min = 18,
                        ex3Title = "Lighting Override Exercise",
                        ex3Desc = "Draw a real object sitting on your brightly lit desk—but deliberately invent dramatic low side-lighting and long cast shadows completely different from your room!",
                        ex3Reps = "2 re-lit observational inventions",
                        ex3Min = 10,
                        challengeTitle = "Mirror-Self Fantasy/Historical Costume Swap",
                        challengeDesc = "Pose yourself in a mirror in everyday clothes holding a broomstick/book, and draw the figure wearing invented historical cloak, satchel, and architectural backdrop.",
                        challengeReps = "1 costume-and-environment invention",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Pasting different lighting directions from mismatched references" to "Override every reference with YOUR single chosen light arrow and shadow pattern.",
                            "Copying background clutter from a reference photo instead of sticking to your thumbnail" to "Take ONLY the structural info you need from each reference."
                        ),
                        checklist = listOf(
                            "The original composition came from my thumbnail rather than copying one photo.",
                            "All referenced elements share one unified horizon and lighting direction.",
                            "Proportions and textures stay cohesive across invented and observed parts."
                        ),
                        criteria = "Complete reference-synthesis thumbnailing, original scene, and lighting overrides.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_imagination",
                        reinforcedSkillIds = listOf("sk_storytelling")
                    ),
                    LessonSpec(
                        id = "w12_u1_l3",
                        title = "Iterative Design & Thumbnail Thumb-Turning",
                        subtitle = "Inventing original props, creatures, or vehicles via variations",
                        objective = "Generate 8 rapid imaginative design silhouettes and refine the strongest 2 into solid 3D perspective constructions.",
                        explanation = "Your first imaginative idea is usually a cliché. Generating 8 quick silhouette variations—pushing proportions wide, tall, sleek, clunky, curved, or angular—uncovers fresh, memorable original designs before polishing.",
                        whyItMatters = "Teaches real concept-art design thinking for characters, creatures, props, and architecture.",
                        materials = listOf("HB & 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "Pick one imaginative prompt (e.g., 'Clockwork Lantern', 'Forest Explorer Backpack', or 'Stone Guardian').",
                            "Sketch 8 fast 4 cm silhouette variations boldly altering Big-Medium-Small shape proportions.",
                            "Select the strongest 2 silhouettes and construct them transparently in 3/4 perspective with callouts."
                        ),
                        ex1Title = "8-Silhouette Prop/Architecture Exploration",
                        ex1Desc = "Explore 8 distinct shapes for an 'Explorer Lantern' or 'Mountain Cabin' pushing tall/squat/asymmetrical proportions.",
                        ex1Reps = "8 imaginative silhouette designs",
                        ex1Min = 10,
                        ex2Title = "3/4 Constructed Hero Design Refinement",
                        ex2Desc = "Pick your 2 best silhouettes and build solid 3D perspective constructions showing materials, hinges, and functional details.",
                        ex2Reps = "2 constructed original designs",
                        ex2Min = 16,
                        ex3Title = "Functional Logic Check",
                        ex3Desc = "Verify joints, grips, weight distribution, or roof supports on your 2 constructions—add 2 tiny mechanical/structural detail callouts.",
                        ex3Reps = "2 functional design callouts",
                        ex3Min = 6,
                        challengeTitle = "Imaginative Creature Hybrid Construction",
                        challengeDesc = "Combine real anatomical elements from 2 animals (e.g., owl head/wings + feline body/paws) into 1 believable 3D constructed creature.",
                        challengeReps = "1 anatomically grounded creature",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Making all 8 silhouettes minor variations of the exact same rectangle" to "Force dramatic shape swings between boxes, triangles, and sweeping ovals.",
                            "Adding spiky decorative nonsense that breaks physical balance" to "Keep functional weight, hinges, and anatomy believable."
                        ),
                        checklist = listOf(
                            "8 silhouettes explored genuinely diverse Big-Medium-Small proportions.",
                            "Selected designs stand up solidly in 3D perspective construction.",
                            "Functional details make physical sense."
                        ),
                        criteria = "Complete 8 design silhouettes, 2 3D constructions, and functional callouts.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_imagination"
                    )
                )
            ),
            buildUnit(
                12, 2, "w12_u2", "Intentional Stylization & Character Design",
                "Push shape language, proportion exaggeration, and simplification without losing underlying 3D truth.",
                listOf(
                    LessonSpec(
                        id = "w12_u2_l1",
                        title = "Shape Language Psychology (Circle, Square, Triangle)",
                        subtitle = "Communicating character personality silently",
                        objective = "Design 3 distinct characters or props built around Circle (warm/friendly), Square (sturdy/reliable), and Triangle (sharp/dynamic) motifs.",
                        explanation = "Stylization is NOT ignorance of anatomy—it is **deliberate editing of form**! Circles/ovals communicate friendliness and softness; sturdy Boxes/squares evoke reliability and strength; sharp Triangles/wedges convey speed, tension, or mischief.",
                        whyItMatters = "Gives original characters, portraits, and illustrated objects unmistakable personality in a single glance.",
                        materials = listOf("HB & 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "Design 3 characters (or 3 matching teapots/cottages) sharing the exact same job—e.g., three travelers or three houses.",
                            "Build #1 almost entirely from bouncy circular/pear curves; #2 from blocky rectangular masses; #3 from sharp tapered wedges and diagonals.",
                            "Keep underlying 3D cross-contours and gravity balance solid inside EVERY style!"
                        ),
                        ex1Title = "Circle-Square-Triangle Prop Triad",
                        ex1Desc = "Design 3 distinct cottages or lanterns—Friendly Round, Sturdy Boxy, and Sleek Angular—constructed solidly in 3/4 perspective.",
                        ex1Reps = "3 shape-language 3D props",
                        ex1Min = 12,
                        ex2Title = "Circle-Square-Triangle Character Trio",
                        ex2Desc = "Build 3 stylized human/animal character studies applying Round, Square, and Triangle shape motifs cleanly across heads, torsos, and hands.",
                        ex2Reps = "3 shape-driven character studies",
                        ex2Min = 16,
                        ex3Title = "Sub-Shape Echoing Drill",
                        ex3Desc = "Verify that secondary choices (eyebrows, lapels, shoes, buttons) echo your character's primary shape language cleanly.",
                        ex3Reps = "3 cohesive detail audits",
                        ex3Min = 6,
                        challengeTitle = "Full Turnaround of One Stylized Character",
                        challengeDesc = "Pick your favorite stylized character and draw a consistent Front, 3/4, and Side-Profile turnaround lined up across horizontal height rails.",
                        challengeReps = "1 three-view character turnaround",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Turning stylization into flat 2D rubber symbols with zero 3D volume" to "Construct stylized characters using 3D spheres, warped boxes, and tapered cones—just exaggerated!",
                            "Mixing sharp spiky hair onto a soft gentle round character without intention" to "Keep shapes harmonious unless contrasting intentionally."
                        ),
                        checklist = listOf(
                            "Each design radiates a clear personality purely from silhouette shapes.",
                            "Stylized forms still hold solid 3D perspective and balance.",
                            "Costume/feature details echo the core shape motif."
                        ),
                        criteria = "Complete 6 shape-language prop and character designs with detail audits.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_stylization",
                        reinforcedSkillIds = listOf("sk_fig_prop")
                    ),
                    LessonSpec(
                        id = "w12_u2_l2",
                        title = "The Realism-to-Simplification Dial",
                        subtitle = "Knowing what to keep and what to omit",
                        objective = "Translate one realistic observational subject across 3 progressive steps of simplification without losing recognition or weight.",
                        explanation = "Every artist picks a favorite spot along the **Simplification Dial**: from full Bargue tonal realism -> expressive ink & line-weight graphic -> bold iconic geometric abstraction. Practicing all three deliberately teaches you *which lines carry 80% of the truth*!",
                        whyItMatters = "Helps you find your authentic personal graphic voice instead of copying someone else's style.",
                        materials = listOf("2H, HB, 2B pencils + 0.5mm fineliner", "Sketchbook"),
                        steps = listOf(
                            "Draw a portrait head or still-life shoe 3 times across one page.",
                            "Version 1 (Observational): full realistic proportions, subtle halftones, soft edge modeling.",
                            "Version 2 (Graphic Editorial): crisp selective contours, bold 2-value inked/2B shadow shapes, omitted midtones.",
                            "Version 3 (Bold Iconic): simplified exaggerated proportions using minimal decisive curves/angles."
                        ),
                        ex1Title = "3-Dial Portrait or Object Translation",
                        ex1Desc = "Draw one subject (your face in mirror, pet, or classic shoe) 3 times: Full Tonal -> Graphic 2-Value -> Bold Exaggerated Caricature/Icon.",
                        ex1Reps = "1 three-stage style spectrum",
                        ex1Min = 18,
                        ex2Title = "5-Line Gesture Distillation",
                        ex2Desc = "Draw a standing figure or bird in 5–8 ultra-economical lines ONLY—find the bare minimum curves needed for instant recognition.",
                        ex2Reps = "6 ultra-minimalist distillations",
                        ex2Min = 9,
                        ex3Title = "Detail Budget Experiment",
                        ex3Desc = "Compare two versions of a tree: one fully rendered, one suggested with 15 bold strategic marks—note which feels livelier!",
                        ex3Reps = "2 tree-economy comparisons",
                        ex3Min = 8,
                        challengeTitle = "Graphic Woodcut Notan Character Scene",
                        challengeDesc = "Translate a complex lit portrait or cozy street café into pure black-and-white graphic ink shapes using ZERO gray midtones.",
                        challengeReps = "1 bold 2-value graphic plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Simplifying by leaving things blank awkwardly instead of choosing iconic rhythm lines" to "Use your boldest, smartest constructive contours and unified shadow shapes.",
                            "Exaggerating randomly without anchoring proportions" to "Push big shapes deliberately (e.g., double jaw width, halve nose length) while keeping 3D construction tight."
                        ),
                        checklist = listOf(
                            "All 3 versions remain unmistakably recognizable as the same subject.",
                            "Graphic 2-value version reads clearly without midtone gradients.",
                            "Minimalist lines still imply genuine 3D mass and overlap."
                        ),
                        criteria = "Complete the 3-dial spectrum, minimalist distillations, and detail comparisons.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_stylization"
                    ),
                    LessonSpec(
                        id = "w12_u2_l3",
                        title = "Character Design in Action & Context",
                        subtitle = "Costume, gesture, and prop storytelling",
                        objective = "Design an original character standing in a dynamic expressive pose with functional layered clothing and signature props.",
                        explanation = "Great character sheets unite gesture (World 9), portrait personality (World 10), drapery tension folds (World 7), and shape language (World 12) into someone who looks like they live in a real world!",
                        whyItMatters = "Synthesizes character craft into portfolio-ready original creation.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Sketchbook"),
                        steps = listOf(
                            "Define character role, shape motif, and 2 signature props (e.g., botanical archivist with brass telescope & satchel).",
                            "Sketch 3 lively dynamic gesture thumbnails exploring personality.",
                            "Construct full 3D anatomy underneath FIRST, drape logical heavy/light clothing layers over top, and finish with crisp value contrast."
                        ),
                        ex1Title = "3 Personality Pose Explorations",
                        ex1Desc = "Sketch 3 full-body gesture poses of an original traveler/artisan character showing how they carry weight, hold props, and tilt their head.",
                        ex1Reps = "3 character personality gestures",
                        ex1Min = 10,
                        ex2Title = "Anatomy-Under-Costume Hero Render",
                        ex2Desc = "Build your best pose cleanly from mannequin up through realistic layered jacket/boots/satchel folds and expressive portrait head.",
                        ex2Reps = "1 complete character design plate",
                        ex2Min = 20,
                        ex3Title = "Prop & Footwear Detail Callouts",
                        ex3Desc = "Add 2 clean margin detail sketches showing a close-up of their satchel clasp/tool and sturdy boot construction.",
                        ex3Reps = "2 character gear callouts",
                        ex3Min = 7,
                        challengeTitle = "Two-Character Height & Chemistry Pair",
                        challengeDesc = "Draw two contrasting original characters standing side-by-side interacting (e.g., tall angular mentor + compact rounded apprentice).",
                        challengeReps = "1 contrasting duo character plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Drawing fancy belt buckles and pouches before checking whether legs and torso balance cleanly" to "Construct the nude/mannequin pose completely balanced first!",
                            "Floaty stiff capes/straps ignoring gravity and shoulder wrap" to "Wrap straps tightly over clavicles and torso cross-contours."
                        ),
                        checklist = listOf(
                            "Character balances weight naturally with clear silhouette personality.",
                            "Clothing folds follow real tension anchors over underlying anatomy.",
                            "Props and costume details reinforce the character's story."
                        ),
                        criteria = "Complete 3 character gestures, 1 full character design, and 2 gear callouts.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_stylization",
                        reinforcedSkillIds = listOf("sk_gesture", "sk_tex_fabric")
                    )
                )
            ),
            buildUnit(
                12, 3, "w12_u3", "Master Studies & Personal Style",
                "Reverse-engineer master draftsmanship analytically and articulate your emerging personal voice.",
                listOf(
                    LessonSpec(
                        id = "w12_u3_l1",
                        title = "Analytical Master Study (Reverse-Engineering)",
                        subtitle = "Studying how masters think—not mindlessly photocopying",
                        objective = "Analyze a historical master drawing (Dürer, Rembrandt, Sargent, Loomis, Bridgman, or Moebius) by decomposing its construction, value map, and line rhythm.",
                        explanation = "Mindless copying trains your hand like a photocopier; **analytical master study** trains your brain like an apprentice! Draw a master work alongside 3 diagnostic notes: *How did they group shadow shapes? Where did they use crisp edges vs. lost edges? How did they build construction volume underneath?*",
                        whyItMatters = "Accelerates taste, restraint, and technical insight decades faster than trial-and-error alone.",
                        materials = listOf("2H, HB, 2B, 4B pencils (or 0.3mm pen matching master medium)", "Art book or saved master monochrome plate", "Sketchbook"),
                        steps = listOf(
                            "Select a timeless monochrome drawing or etching by a master draftsman you genuinely admire.",
                            "Step 1 (5 min): Draw a tiny 2-value thumbnail uncovering ONLY their hidden light-vs-shadow composition.",
                            "Step 2 (5 min): Draw a stripped-down 3D mannequin/box construction diagram underneath their pose or landscape.",
                            "Step 3 (15 min): Execute a faithful study of one focused section (head, hands, drapery, or tree) matching their edge variety and stroke rhythm."
                        ),
                        ex1Title = "Master Structural & Value Dissection",
                        ex1Desc = "Pick 1 master monochrome drawing. Create 1 small 2-value compositional map + 1 stripped-down 3D primitive construction diagram exposing how it was built.",
                        ex1Reps = "2 analytical dissection diagrams",
                        ex1Min = 10,
                        ex2Title = "Focused Master Section Study",
                        ex2Desc = "Reconstruct a key focal zone from the master drawing (head, hand, architectural shadow, or ink hatching patch), matching mark economy and edge softness.",
                        ex2Reps = "1 focused master transcription",
                        ex2Min = 16,
                        ex3Title = "3 Written Craft Takeaways",
                        ex3Desc = "Write 3 concrete technical observations directly onto your page (e.g., 'Kept cast shadows #7 while reserving #9 solely for eye crease and cuff').",
                        ex3Reps = "3 analytical craft notes",
                        ex3Min = 4,
                        challengeTitle = "Apply Master Technique to Original Subject",
                        challengeDesc = "Immediately draw an ordinary object on YOUR desk using the exact mark-making economy, shadow grouping, or hatching rhythm you just uncovered!",
                        challengeReps = "1 applied master-style life study",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Gridding a master image square-by-square and copying surface gray smudges blindly" to "Reconstruct the master's drawing using 3D forms and value families just as they did.",
                            "Studying only polished highlights while ignoring rough construction lines" to "Analyze where the master left lines quiet, fast, or unfinished."
                        ),
                        checklist = listOf(
                            "I uncovered the underlying 3D forms and 2-value map—not just surface marks.",
                            "My study mimics the master's edge control and tonal restraint.",
                            "Written takeaways identify reusable techniques for my own work."
                        ),
                        criteria = "Complete master dissection, focused transcription, and written craft takeaways.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_master_study"
                    ),
                    LessonSpec(
                        id = "w12_u3_l2",
                        title = "Second Master Contrast Study (Line vs. Tone)",
                        subtitle = "Synthesizing your favorite traits from two different lineages",
                        objective = "Compare two radically different monochrome drawing approaches (e.g., crisp Dürer/Moebius ink line vs. atmospheric Sargent/Prud'hon soft tonal charcoal/graphite).",
                        explanation = "Every personal style emerges by **cross-pollinating** influences you love! Comparing a crisp structural ink master against a lush atmospheric tonal master lets you consciously decide what balance of line clarity, value drama, and simplification speaks most to YOU.",
                        whyItMatters = "Turns passive admiration into deliberate personal artistic direction.",
                        materials = listOf("Fineliners + HB/2B/4B graphite", "2 contrasting master plates", "Sketchbook"),
                        steps = listOf(
                            "Choose Master A (Line/Ink priority) and Master B (Atmosphere/Tone priority).",
                            "Sketch quick 10-minute studies from each focusing on their contrasting line weight vs. soft lost edges.",
                            "In Study 3, draw a simple real subject from your room blending Master A's structural line clarity with Master B's atmospheric shadow grouping!"
                        ),
                        ex1Title = "Line-Master Mini Study",
                        ex1Desc = "Execute a crisp 10-minute ink or sharp-pencil study after a line-focused master studying contour weight and hatching economy.",
                        ex1Reps = "1 crisp line-lineage study",
                        ex1Min = 10,
                        ex2Title = "Tone-Master Mini Study",
                        ex2Desc = "Execute an atmospheric 10-minute graphite study after a tonal master focusing on broad lost-and-found shadow shapes.",
                        ex2Reps = "1 atmospheric tone-lineage study",
                        ex2Min = 10,
                        ex3Title = "Hybrid Personal Synthesis Study",
                        ex3Desc = "Draw a subject from life or imagination consciously fusing both lineages (e.g., crisp structural ink shadows paired with soft atmospheric graphite depth).",
                        ex3Reps = "1 personal hybrid synthesis study",
                        ex3Min = 14,
                        challengeTitle = "Personal Style Manifesto Card",
                        challengeDesc = "Fill one neat sketchbook page with 4 small signature mini-sketches (object, tree, portrait, room) united by your favorite line/value recipe + 5 guiding rules.",
                        challengeReps = "1 four-panel style manifesto",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Worrying that you don't have an 'original style' yet" to "Style is simply the consistent byproduct of what you choose to emphasize and omit after thousands of honest observations!",
                            "Muddying ink and heavy graphite without planning" to "Keep ink strokes clean and let graphite handle soft broad value planes."
                        ),
                        checklist = listOf(
                            "Line study vs. Tone study demonstrate two genuinely distinct philosophies.",
                            "The hybrid synthesis blends structure and mood intentionally.",
                            "I articulated specific visual preferences I want to carry forward."
                        ),
                        criteria = "Complete contrasting lineage studies and personal hybrid synthesis.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_master_study",
                        reinforcedSkillIds = listOf("sk_stylization")
                    ),
                    LessonSpec(
                        id = "w12_u3_l3",
                        title = "Self-Critique & Deliberate Practice Design",
                        subtitle = "Becoming your own lifelong drawing coach",
                        objective = "Audit your own sketchbook pages objectively across 5 pillars (Observation, Construction, Perspective, Value, Edge) and prescribe targeted corrective drills.",
                        explanation = "Graduating from a guided academy means knowing how to diagnose **why** a drawing feels 'off' on your own! Using a systematic 5-pillar diagnostic checklist (Checking: Proportions? Perspective Convergence? Form Volume? Value Separation? Edge Hierarchy?) immediately pinpoints the exact root fix instead of redrawing blindly.",
                        whyItMatters = "Ensures you keep improving independently for years after finishing World 12.",
                        materials = listOf("3 of your own older sketchbook pages from earlier months", "2H/HB pencils", "Sticky note or margin ink"),
                        steps = listOf(
                            "Pull out 3 drawings from your sketchbook (ideally 1 figure/portrait, 1 environment/still life, 1 quick gesture).",
                            "Score each calmly across 5 pillars: Proportion/Sighting, 3D Form/Perspective, Light/Value Hierarchy, Edge/Line Control, Composition.",
                            "For the single weakest pillar on each drawing, write a concrete 10-minute corrective drill and execute one redraw fix right now!"
                        ),
                        ex1Title = "5-Pillar Sketchbook Diagnostic",
                        ex1Desc = "Audit 3 past drawings honestly in your notebook margins, identifying 1 strength and 1 root structural/value flaw on each.",
                        ex1Reps = "3 audited sketchbook pages",
                        ex1Min = 9,
                        ex2Title = "Targeted Fix-It Redraw",
                        ex2Desc = "Pick the weakest drawing of the three and redraw it from scratch applying ONLY the exact prescribed fix (e.g., cleaner 2-value shadow grouping or plumb alignment).",
                        ex2Reps = "1 targeted corrective redraw",
                        ex2Min = 15,
                        ex3Title = "Custom 12-Week Maintenance Plan",
                        ex3Desc = "Write out a personal weekly routine balancing warm-ups, observation, and creative projects tailored to your personal artistic goals.",
                        ex3Reps = "1 written practice blueprint",
                        ex3Min = 6,
                        challengeTitle = "Year-One Progress Comparison Plate",
                        challengeDesc = "Redraw the very first household object or still-life setup you sketched back in World 1 today using all 12 Worlds of mastery—compare both side by side!",
                        challengeReps = "1 before-and-after benchmark plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Harsh vague self-criticism like 'this whole drawing looks terrible'" to "Replace vague emotion with surgical questions: 'Did my values separate? Do these two perspective rays converge?'",
                            "Trying to fix 6 different weaknesses in one drawing" to "Target ONE specific upgrade per practice session."
                        ),
                        checklist = listOf(
                            "I diagnosed specific technical causes rather than vague feelings.",
                            "My corrective redraw visibly resolved the targeted flaw.",
                            "I designed a realistic sustainable practice cadence for my goals."
                        ),
                        criteria = "Complete 3 page audits, 1 corrective redraw, and your personal practice blueprint.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_portfolio"
                    )
                )
            ),
            buildUnit(
                12, 4, "w12_u4", "Portfolio Execution & Graduation Capstone",
                "Plan, research, refine, and execute cohesive monochrome portfolio plates worthy of framing.",
                listOf(
                    LessonSpec(
                        id = "w12_u4_l1",
                        title = "Portfolio Project Planning & Reference Pack",
                        subtitle = "Researching, thumbnailing, and staging a centerpiece",
                        objective = "Plan a multi-element monochrome portfolio centerpiece through brief, thumbnails, character/prop studies, and perspective grid setup.",
                        explanation = "Finished portfolio illustrations aren't improvised in one sitting—they are engineered calmly in stages: Brief -> 6 Thumbnails -> Reference/Callout Sheet -> Master Underdrawing -> Full Value Execution.",
                        whyItMatters = "Teaches professional production discipline for large ambitious illustrations.",
                        materials = listOf("2H & HB pencils", "A4/A3 pad", "Self-gathered local references/mirror"),
                        steps = listOf(
                            "Choose a compelling centerpiece theme combining at least 3 Worlds (e.g., Figure + Portrait + Architecture/Nature).",
                            "Generate 4–6 small 3-value thumbnails refining focal flow and lighting drama.",
                            "Draw 1 dedicated study sheet resolving tricky hands, head angle, or architectural props cleanly before touching final paper."
                        ),
                        ex1Title = "Centerpiece Brief & 4 Value Thumbnails",
                        ex1Desc = "Write a 2-sentence scene brief and sketch 4 distinct 3-value compositional thumbnails testing dramatic lighting and focal hierarchy.",
                        ex1Reps = "4 portfolio value thumbnails",
                        ex1Min = 12,
                        ex2Title = "Dedicated Prop & Anatomy Prep Sheet",
                        ex2Desc = "Use mirrors/real objects to resolve the toughest 3 focal details (e.g., character face tilt, hand gripping prop, main building arch) cleanly on a prep page.",
                        ex2Reps = "3 focal-detail prep studies",
                        ex2Min = 15,
                        ex3Title = "Master Underdrawing Transfer",
                        ex3Desc = "Lay down the crisp light 2H/HB structural underdrawing on clean heavy paper, verifying plumb lines, perspective VPs, and scale figures.",
                        ex3Reps = "1 verified master underdrawing",
                        ex3Min = 12,
                        challengeTitle = "Secondary Tonal Key Test",
                        challengeDesc = "Before touching your final plate, test a 1/4-scale tonal rehearsal of the focal corner in graphite/ink to lock value range cleanly.",
                        challengeReps = "1 focal tonal rehearsal",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Skipping prep studies and hoping hands/perspective work out on final Bristol board" to "Solve every hard puzzle on scratch paper first!",
                            "Over-darkening 2H underdrawings with heavy messy erasing" to "Keep master transfer lines crisp, minimal, and whisper-light."
                        ),
                        checklist = listOf(
                            "Value thumbnails clearly lock lighting and composition before scaling up.",
                            "Tricky anatomy/perspective elements were rehearsed cleanly on prep sheets.",
                            "Final underdrawing holds solid proportions and perspective alignment."
                        ),
                        criteria = "Complete portfolio thumbnails, prep studies, and verified master underdrawing.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_portfolio",
                        reinforcedSkillIds = listOf("sk_comp_focal", "sk_imagination")
                    ),
                    LessonSpec(
                        id = "w12_u4_l2",
                        title = "Sustained Portfolio Rendering & Restraint",
                        subtitle = "Pacing lights, shadows, textures, and crisp focus",
                        objective = "Execute clean layered rendering on a major multi-element monochrome work while protecting light shapes and focal contrast.",
                        explanation = "During long multi-hour drawings, the biggest danger is losing track of your big 2-value structure and turning everything into uniform gray fuzz! Work consistently across the whole sheet—shadow map first, atmospheric planes second, focal textures & #9 accents last.",
                        whyItMatters = "Builds stamina and visual judgment across sustained ambitious pieces.",
                        materials = listOf("2H, HB, 2B, 4B, 6B pencils (or archival fineliners)", "Kneaded + vinyl erasers", "Master underdrawing plate"),
                        steps = listOf(
                            "Tape your chosen 3-value thumbnail right beside your workspace as your North Star.",
                            "Establish unified shadow families across foreground, midground, and background before rendering details.",
                            "Step away 2 meters every 15 minutes to check tonal separation, atmospheric distance fade, and focal hierarchy."
                        ),
                        ex1Title = "Global Shadow & Atmosphere Pass",
                        ex1Desc = "Lay down the unified shadow families and 4-plane atmospheric separation cleanly across your entire master plate without detailing.",
                        ex1Reps = "1 unified global-tone pass",
                        ex1Min = 15,
                        ex2Title = "Focal Modeling & Material Truth Pass",
                        ex2Desc = "Render form turns, fabric folds, wood/metal/skin textures, and subtle specular lifts strictly prioritizing the focal zone.",
                        ex2Reps = "1 sustained focal-rendering pass",
                        ex2Min = 20,
                        ex3Title = "2-Meter Step-Back Edge & Contrast Audit",
                        ex3Desc = "Prop your plate upright across the room, squint, and apply final #9 occlusion darks, lifted #1 focal catchlights, and softened distant edges.",
                        ex3Reps = "1 distance-audited final pass",
                        ex3Min = 8,
                        challengeTitle = "Companion Inked Vignette Plate",
                        challengeDesc = "Create a crisp smaller companion study in the corner or second sheet exploring the same world from a close-up character portrait perspective.",
                        challengeReps = "1 companion portrait plate",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Noodling tiny textures in a corner for 30 minutes while adjacent areas sit white" to "Advance the entire drawing in unified global passes.",
                            "Letting midtones creep dark enough to steal glow from highlights" to "Keep light halftones crisp and airy with occasional kneaded eraser cleanup."
                        ),
                        checklist = listOf(
                            "Every 15 minutes I stepped back to verify big 3-value design.",
                            "Materials, lighting, and atmospheric depth remain cohesive across the whole scene.",
                            "Focal contrast pulls viewers directly into the centerpiece."
                        ),
                        criteria = "Complete global shadow, focal modeling, and distance-audited final passes.",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_portfolio"
                    ),
                    LessonSpec(
                        id = "w12_u4_l3",
                        title = "Portfolio Curation & Academy Graduation Prep",
                        subtitle = "Presenting your strongest work as a unified artist",
                        objective = "Curate a cohesive 4-piece portfolio mini-series demonstrating mastery across Observation, Construction, Anatomy/Portraits, and Imaginative Environments.",
                        explanation = "A great portfolio isn't 30 scattered warm-ups—it's 4–6 razor-sharp, finished plates showing range AND consistency! Reviewing your year of sketchbooks to curate your best pieces prepares you for World 12's Final Graduation Milestone.",
                        whyItMatters = "Marks your transformation from zero-experience beginner to confident, self-directed monochrome artist.",
                        materials = listOf("Full collection of your Academy sketchbooks", "Clean presentation folder/sheet", "HB/2B pencils"),
                        steps = listOf(
                            "Select 1 top observational/still-life plate, 1 figure/portrait plate, and 1 environment/imaginative piece from your journey.",
                            "Identify any unifying presentation touches (clean ruled borders, consistent titles/dates, erased smudges).",
                            "Plan your final Capstone Portfolio Centerpiece uniting your personal favorite subject, medium, and style."
                        ),
                        ex1Title = "Best-Works Curation & Border Clean-Up",
                        ex1Desc = "Review all 12 Worlds of sketchbooks, select your top 3 milestone/practice plates, clean smudged margins gently with a kneaded eraser, and sign/date neatly.",
                        ex1Reps = "3 curated signature plates",
                        ex1Min = 10,
                        ex2Title = "Capstone Original Concept Brief",
                        ex2Desc = "Draft your final World 12 Milestone concept brief + 2 crisp compositional thumbnails synthesizing your favorite skills (e.g., portrait + architecture + narrative lighting).",
                        ex2Reps = "1 capstone brief + 2 thumbnails",
                        ex2Min = 12,
                        ex3Title = "Skill-Pillar Mastery Celebration Check",
                        ex3Desc = "Write a brief reflection celebrating how far your eye, line confidence, 3D construction, and shading have grown since World 1 Lesson 1!",
                        ex3Reps = "1 graduation reflection log",
                        ex3Min = 5,
                        challengeTitle = "Curate a Thematic 4-Page Zine / Mini-Series",
                        challengeDesc = "Sketch a 4-panel cohesive monochrome zine sequence following one character or quiet place across four seasons or times of day.",
                        challengeReps = "4-panel thematic zine plan",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Including weak rushed pages just to pad quantity" to "Edit ruthlessly—show only work that reflects your true current standard.",
                            "Forgetting clean archival presentation borders" to "Leave crisp consistent margins and erase messy construction stray smudges at the borders."
                        ),
                        checklist = listOf(
                            "My curated selection showcases genuine mastery across observation, 3D form, anatomy, and composition.",
                            "Margins are clean and work is signed/dated neatly.",
                            "I have a clear, exciting blueprint for my final Capstone Milestone."
                        ),
                        criteria = "Complete portfolio curation and capstone blueprint to unlock the Final Graduation Milestone!",
                        diagramType = DiagramType.IMAGINATION_SYNTHESIS,
                        primarySkillId = "sk_portfolio",
                        reinforcedSkillIds = listOf("sk_imagination", "sk_stylization", "sk_master_study")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w12",
            worldNumber = 12,
            title = "Original Monochrome Portfolio Centerpiece",
            brief = "Plan and execute your Academy Graduation Capstone: an original, self-directed monochrome illustration (graphite, charcoal, or archival ink) combining human figure or expressive portrait, constructed perspective/natural environment, unified dramatic lighting, and your distinct emerging artistic voice—complete with preparatory thumbnails and reference studies.",
            combinedSkills = listOf("Imaginative Invention", "Intentional Stylization", "Master Craft Synthesis", "Full Portfolio Polish"),
            requiredMaterials = listOf("Your preferred monochrome toolkit (2H–6B graphite, charcoal, or fineliners)", "Kneaded & vinyl erasers", "Clean A4/A3 Bristol or heavyweight archival drawing paper"),
            phases = listOf(
                "Phase 1 (10 min): Design 3–4 small 3-value compositional thumbnails and select your strongest narrative camera & lighting mood.",
                "Phase 2 (12 min): Complete targeted mirror/prop reference callouts and transfer a clean verified 2H perspective + anatomical underdrawing.",
                "Phase 3 (12 min): Map 4-plane atmospheric depth and unified 2-value light/shadow architecture across the entire sheet.",
                "Phase 4 (26 min): Execute full sustained rendering—material truth, expressive portraiture/gesture, focal contrast, selective texture economy, and clean archival margins."
            ),
            selfAssessmentChecklist = listOf(
                "Original composition blends imagination and solid observational/reference structure seamlessly.",
                "Perspective, anatomy/portraits, and material values feel cohesive under one unified light source.",
                "Atmospheric depth, edge variety, and focal contrast guide the viewer cleanly.",
                "The finished plate represents my highest craft standard across all 12 Worlds!"
            ),
            estimatedMinutes = 60,
            xpReward = 400
        )
    )
)
