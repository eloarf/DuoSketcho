package com.example.data.curriculum

import com.example.domain.model.DiagramType
import com.example.domain.model.DrawingWorld
import com.example.domain.model.MilestoneProject

internal fun worlds7To9(): List<DrawingWorld> = listOf(
    // WORLD 7: TEXTURES
    DrawingWorld(
        number = 7,
        id = "world_7",
        title = "Textures",
        tagline = "Render wood, metal, glass, fabric, skin, and hair with material truth",
        focusSummary = "Learn how texture lives strictly on value transitions—never overpowering form—across matte grain, specular chrome, refractive glass, drapery folds, and organic surfaces.",
        unlockRequirementSummary = "Complete World 6 Milestone & reach Practicing in Still Life skills",
        units = listOf(
            buildUnit(
                7, 1, "w7_u1", "Wood, Stone & Matte Organic Grain",
                "Communicate grain, knots, weathered pits, and cracks while protecting underlying 3D lighting.",
                listOf(
                    LessonSpec(
                        id = "w7_u1_l1",
                        title = "Form First, Texture Second (Wood Grain)",
                        subtitle = "Concentrating grain near the terminator",
                        objective = "Render believable wood planks and carved cylinders where grain flows around corners and peaks near light-to-shadow transitions.",
                        explanation = "Beginner trap: drawing dark wood-grain stripes equally thick across the sunlit face and shadow face, destroying the 3D form! In real life, surface texture pops sharpest right along the **halftone terminator zone**—barely whispering in bright highlights and softening quietly inside deep shadows.",
                        whyItMatters = "This 'terminator texture rule' governs EVERY textured surface—brick walls, skin pores, gravel, and tree bark.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Wooden spoon or plank reference"),
                        steps = listOf(
                            "Construct a 3D plank box and cylinder completely in 5-zone lighting FIRST without a single wood line.",
                            "Notice how wood rings wrap across the cut end grain vs. flowing along the long face.",
                            "Add subtle broken grain waves peaking in contrast along the midtone/terminator band, letting grain fade out in deep shadow and bright glare."
                        ),
                        ex1Title = "Lit Wooden Block & End-Grain Study",
                        ex1Desc = "Draw 2 lit rectangular wood blocks showing long-face cathedral grain wrapping continuously over the cut end-grain rings.",
                        ex1Reps = "2 wrap-around wood blocks",
                        ex1Min = 12,
                        ex2Title = "Wooden Spoon Handle Texture",
                        ex2Desc = "Draw a real wooden spoon under directional light, concentrating fine fiber lines strictly along the turning midtone shoulder.",
                        ex2Reps = "1 observational wooden utensil plate",
                        ex2Min = 12,
                        ex3Title = "Terminator-Only Texture Swatch",
                        ex3Desc = "Shade a smooth cylinder first, then add wood rings ONLY in the middle 40% halftone zone to verify how easily the brain fills in the rest!",
                        ex3Reps = "2 economy-grain cylinders",
                        ex3Min = 7,
                        challengeTitle = "Split Log With Cracked Bark",
                        challengeDesc = "Render a firewood log section showing rough furrowed outer bark, crisp split inner heartwood, and radial growth cracks.",
                        challengeReps = "1 detailed split-log study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing identical thick black stripes everywhere like zebra camo" to "Vary grain weight, keep it mid-value in light zones, and break lines organically.",
                            "Forgetting wood grain turns 90° around cut edges" to "Match long grain stripes cleanly to the rings on the adjacent end face."
                        ),
                        checklist = listOf(
                            "Underlying 3D form lighting reads clearly before texture registers.",
                            "Grain lines concentrate near the halftone-to-shadow transition.",
                            "Grain wraps accurately across corner edges onto adjacent faces."
                        ),
                        criteria = "Complete 5 wood-grain studies demonstrating terminator texture restraint.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_hard",
                        reinforcedSkillIds = listOf("sk_form_shadow")
                    ),
                    LessonSpec(
                        id = "w7_u1_l2",
                        title = "Weathered Stone, Brick & Rough Concrete",
                        subtitle = "Pitted relief shadows and fractured edges",
                        objective = "Simulate rough stone and chipped masonry using micro-cast shadows inside pits and broken silhouette edges.",
                        explanation = "Every tiny pit, crack, or mortar joint in stone is actually a miniature 3D canyon! Under side lighting, each pit catches a tiny bright rim on its far lip and a crisp dark cast shadow on its near lip.",
                        whyItMatters = "Gives ruins, pathways, cliffs, and sculptures authentic tactile crunch without repetitive stipple dots.",
                        materials = listOf("HB, 2B, 4B pencils (sharpened + side slant)", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Shade the overall boulder or brick wall cube softly in big light/shadow families.",
                            "Break straight outline corners gently with small chips and uneven bevels.",
                            "Add miniature dark shadow lips on the light-facing edge of cracks and lift crisp micro-highlights with a pinched kneaded eraser on the opposite catch-lip."
                        ),
                        ex1Title = "Chipped Stone Cube & Boulder",
                        ex1Desc = "Draw 1 carved stone block with corner chips and 1 rough rounded boulder, using micro-catchlights and dark pit shadows along the terminator.",
                        ex1Reps = "2 weathered stone forms",
                        ex1Min = 12,
                        ex2Title = "Recessed Brick Mortar Corner",
                        ex2Desc = "Draw a 2-point corner slice of 8 weathered bricks, recessing mortar joints in shadow and chipping 2 brick edges asymmetrically.",
                        ex2Reps = "1 masonry corner study",
                        ex2Min = 12,
                        ex3Title = "Pitted vs. Polished Stone Sphere",
                        ex3Desc = "Draw two adjacent spheres: left smooth marble, right porous pumice rock—notice how edge crispness and pit shadows change the feel completely.",
                        ex3Reps = "2 tactile contrast spheres",
                        ex3Min = 8,
                        challengeTitle = "Mossy Cobblestone Steps",
                        challengeDesc = "Construct 3 worn stone steps with rounded foot-worn centers, deep dark cracks, and light grass wisps peeking out.",
                        challengeReps = "1 worn stone step study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing brick outlines equally thick black all around every brick" to "Highlight ONLY the bottom/shadow lip of bricks in light and catch light on the top lip of shaded joints.",
                            "Sprinkling uniform circular holes like Swiss cheese" to "Group angular fractures in irregular clusters—big, medium, tiny."
                        ),
                        checklist = listOf(
                            "Pits and cracks obey the same global light direction as the whole rock.",
                            "Silhouettes show organic chips and unevenness.",
                            "Texture doesn't flatten the overall form shadow."
                        ),
                        criteria = "Complete 5 weathered stone and masonry texture studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_hard"
                    ),
                    LessonSpec(
                        id = "w7_u1_l3",
                        title = "Woven Basket, Paper & Matte Ceramics",
                        subtitle = "Micro-rhythm and matte soft highlights",
                        objective = "Distinguish coarse woven fibers, matte ceramic clay, and crisp folded paper through value range and edge softness.",
                        explanation = "Matte materials scatter light broadly, producing gentle midtone transitions and NO razor-bright white specular spots. Woven textures layer small overlapping strips casting soft under-shadows onto neighbors.",
                        whyItMatters = "Teaches you how to keep matte objects calm so shiny metal/glass elements sparkle naturally beside them.",
                        materials = listOf("2H, HB, 2B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "For woven basketry: establish the cylindrical container lighting FIRST, then weave alternating over-under strips bending along the cross-contour.",
                            "For matte ceramics: keep specular highlights soft (#2 rather than razor #1) and emphasize velvety reflected light."
                        ),
                        ex1Title = "Woven Basket Cylinder Section",
                        ex1Desc = "Construct a tilted basket cylinder, lightly wrap cross-contour strips, and shade each strip's individual mini-arch over/under its neighbors.",
                        ex1Reps = "2 woven cylinder studies",
                        ex1Min = 14,
                        ex2Title = "Crisp Origami Paper Plane",
                        ex2Desc = "Fold a sheet of paper into a crisp paper airplane or tent; render razor-sharp crease contrasts and clean matte paper bounce light.",
                        ex2Reps = "2 folded paper studies",
                        ex2Min = 10,
                        ex3Title = "Matte Terracotta Pot Rim",
                        ex3Desc = "Draw an unglazed flower pot or matte mug focusing on broad, velvety soft midtone gradations without glossy shine.",
                        ex3Reps = "1 matte ceramic study",
                        ex3Min = 8,
                        challengeTitle = "Rope Coil Texture Plate",
                        challengeDesc = "Draw a thick twisted rope coiled three times, shading each diagonal hemp strand curving smoothly around the rope cylinder.",
                        challengeReps = "1 twisted rope coil study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Adding sharp bright white specular dots onto matte clay or paper" to "Save #1 pure white glints for wet, glazed, metallic, or glass surfaces.",
                            "Flattening woven bands at the cylinder rim" to "Curve every single reed segment around the silhouette edge."
                        ),
                        checklist = listOf(
                            "Woven strips overlap clearly with tiny under-shadows.",
                            "Matte surfaces maintain soft highlights without mirror glare.",
                            "Global form shadow unites the entire woven volume."
                        ),
                        criteria = "Complete 5 woven, folded-paper, and matte ceramic material studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_hard"
                    )
                )
            ),
            buildUnit(
                7, 2, "w7_u2", "Metal, Chrome & Reflective Glass",
                "Decode high-contrast specular ribbons, distorted reflections, and refractive caustics in monochrome.",
                listOf(
                    LessonSpec(
                        id = "w7_u2_l1",
                        title = "Brushed Steel vs. Mirror Chrome",
                        subtitle = "Sharp contrast jumps & horizon reflection bands",
                        objective = "Render polished chrome and brushed metal cylinders/spheres using crisp abstract reflection shapes and razor value jumps.",
                        explanation = "Polished metal doesn't have normal soft core shadows—it acts like a curved mirror! Dark values (#9) sit directly next to blazing pure white (#1) along sharp reflection bands mirroring the horizon, ceiling, and window. Brushed metal smears those reflections horizontally/circumferentially.",
                        whyItMatters = "Unlocks silverware, watches, armor, cars, kitchen appliances, and eyeglasses frames.",
                        materials = listOf("HB, 2B, 4B, 6B pencils", "Sharp kneaded/vinyl eraser", "Metal spoon or stainless mug"),
                        steps = listOf(
                            "Place a shiny spoon or stainless steel tumbler near a window.",
                            "Squint and map the crisp interlocking dark (#8–#9) and blazing white (#1) reflection stripes—treat them like an abstract puzzle!",
                            "Notice the curved 'dark horizon line' wrapping across the belly where ground reflection meets sky/ceiling reflection."
                        ),
                        ex1Title = "Chrome vs. Brushed Sphere Pair",
                        ex1Desc = "Draw two 6 cm spheres: Left = mirror chrome (crisp horizon wave, high #9 dark band jumping straight to #1 white sky); Right = brushed aluminum (softly streaked bands).",
                        ex1Reps = "2 metallic finish spheres",
                        ex1Min = 14,
                        ex2Title = "Stainless Steel Spoon Study",
                        ex2Desc = "Draw a real metal spoon from life, observing how its concave bowl flips the room reflection upside down!",
                        ex2Reps = "2 live metal spoon studies",
                        ex2Min = 12,
                        ex3Title = "Chrome Cylinder Rim Glint",
                        ex3Desc = "Render a shiny metal thermos or pot lid highlighting the razor-sharp white specular bar running vertically down the cylinder.",
                        ex3Reps = "2 reflective metal cylinders",
                        ex3Min = 8,
                        challengeTitle = "Reflective Teakettle & Studio Window",
                        challengeDesc = "Place a shiny kettle or toaster near a bright window and capture the distorted rectangular window highlight curving around its belly.",
                        challengeReps = "1 distorted-window metal plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Shading shiny chrome with soft gradual gray gradients like matte stone" to "Push dark reflections deep (#8–#9) right next to pure clean #1 paper whites with crisp edges.",
                            "Drawing random squiggles instead of wrapping reflections around the 3D cross-contour" to "Bend every reflection band cleanly along the cylinder/sphere curvature."
                        ),
                        checklist = listOf(
                            "Sharp #1-against-#9 contrast creates unmistakable metallic gleam.",
                            "Reflection shapes curve faithfully along the 3D surface.",
                            "Brushed metal shows finer directional streaks than mirror chrome."
                        ),
                        criteria = "Complete 6 reflective metal sphere, spoon, and cylinder studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_reflect"
                    ),
                    LessonSpec(
                        id = "w7_u2_l2",
                        title = "Clear Glass, Refraction & Caustics",
                        subtitle = "Drawing what bends behind and shines on top",
                        objective = "Render clear drinking glasses and bottles by observing rim thickness, background distortion, and focused caustic table bright spots.",
                        explanation = "You don't actually draw 'glass'—you draw (1) subtle background edge shifts refracting through curved thickness, (2) crisp dark internal total-reflection edges along the base and rim, (3) bright specular surface highlights, and (4) bright focused **caustic light** glowing inside the glass's cast shadow on the table!",
                        whyItMatters = "Makes windows, water bottles, wine glasses, and spectacles look genuinely transparent.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Sharp vinyl + kneaded eraser", "Clear drinking glass (half-filled with water)"),
                        steps = listOf(
                            "Set a clear glass on white paper against a slightly darker/patterned background (e.g., behind a dark book corner).",
                            "Tone the paper softly around the scene (#2–#3) so bright glass speculars (#1) and caustic light spots can actually glow!",
                            "Construct symmetrical ellipses for rim, water line, and thick glass base.",
                            "Map the dark internal thickness rims (#7–#8), shifted refracted background edges, and crisp lifted caustic light inside the soft cast shadow."
                        ),
                        ex1Title = "Empty Clear Tumbler Against Edge",
                        ex1Desc = "Place a clear glass partly in front of a dark notebook edge so you clearly see how the notebook edge bends/shifts inside the glass wall.",
                        ex1Reps = "2 refraction-edge glass studies",
                        ex1Min = 14,
                        ex2Title = "Half-Full Glass + Water Meniscus",
                        ex2Desc = "Fill the glass halfway with water; carefully draw the double-ellipse meniscus clinging up the inner glass wall and bright focused caustic glow in the shadow.",
                        ex2Reps = "1 water-filled glass study",
                        ex2Min = 14,
                        ex3Title = "Glass Marble / Sphere Caustic Study",
                        ex3Desc = "Draw a clear glass marble or magnifying lens resting on toned paper—notice how its core looks bright while its outer rim bends dark, casting a bright hotspot shadow.",
                        ex3Reps = "2 refractive glass spheres",
                        ex3Min = 8,
                        challengeTitle = "Clear Bottle With Label & Liquid",
                        challengeDesc = "Render a half-full clear glass jar or bottle with a matte paper label—contrasting matte paper wrap against refracting liquid and glass base.",
                        challengeReps = "1 mixed glass-and-paper plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Leaving the glass outline dark all around on white paper" to "Tone the background slightly (#2) and let crisp #1 white highlights + dark internal rim edges define the glass.",
                            "Drawing a solid opaque black cast shadow under clear glass" to "Lift a bright caustic light patch right inside the middle of the cast shadow!"
                        ),
                        checklist = listOf(
                            "Glass thickness shows clearly at the rim and solid base.",
                            "Background tones visibly shift/distort through the glass walls.",
                            "Cast shadow contains a believable focused bright caustic patch."
                        ),
                        criteria = "Complete 5 transparent glass and refractive caustic studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_reflect"
                    ),
                    LessonSpec(
                        id = "w7_u2_l3",
                        title = "Wet Surfaces, Leather & Glossy Glaze",
                        subtitle = "Semi-reflective materials between matte and chrome",
                        objective = "Capture satin/semi-gloss materials (glazed ceramic, polished leather, wet stone) by pairing normal 5-zone shading with crisp bright speculars.",
                        explanation = "Unlike pure chrome (pure mirror) or chalk (pure matte), semi-gloss materials like glazed pottery, polished apples, leather boots, or wet pavement hold normal 5-zone form shadows *plus* sharp bright window/lamp specular glints sitting cleanly on top of the lit plane!",
                        whyItMatters = "Covers 80% of real-world painted, glazed, organic, and worn studio materials.",
                        materials = listOf("HB, 2B, 4B pencils", "Precision eraser", "Glazed mug or leather shoe"),
                        steps = listOf(
                            "Render the base object smoothly in standard 5-zone form lighting (keep lit plane Value #2.5–#4 rather than pure #1!).",
                            "Use a crisp vinyl eraser edge to lift exact rectangular/curved window specular highlights (#1) cleanly on top of the turning shoulder.",
                            "Soften specular edges slightly for satin leather vs. razor-crisp for wet/glazed ceramic."
                        ),
                        ex1Title = "Glazed Mug vs. Matte Mug Pair",
                        ex1Desc = "Draw a glossy glazed mug (keeping lit clay at #2.5 so crisp #1 window glints shine brightly) beside a matte paper cup.",
                        ex1Reps = "2 gloss-vs-matte studies",
                        ex1Min = 14,
                        ex2Title = "Polished Leather Shoe Toe",
                        ex2Desc = "Render the rounded toe box and crease folds of a leather shoe, placing crisp soft-edged sheen bands across top ridges.",
                        ex2Reps = "1 leather sheen & crease study",
                        ex2Min = 12,
                        ex3Title = "Wet Pebble Specular Pop",
                        ex3Desc = "Shade 2 dark wet river stones (#5–#8) and carve bright #1 sky-reflection glints across their wet top shoulders.",
                        ex3Reps = "2 wet stone studies",
                        ex3Min = 7,
                        challengeTitle = "Glossy Apple Next to Metal Knife",
                        challengeDesc = "Pair a polished waxed apple with a metal butter knife to contrast crisp semi-gloss skin glints against true metallic mirror bands.",
                        challengeReps = "1 gloss-meets-chrome plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Leaving the entire sunlit side pure #1 white so the specular highlight has nowhere brighter to stand out" to "Tone the lit body gently to #2–#3 so lifted #1 speculars genuinely sparkle.",
                            "Making specular shapes random circular dots" to "Copy the actual distorted shape of the window or lamp."
                        ),
                        checklist = listOf(
                            "Lit body sits at #2–#3 so #1 specular glints pop distinctly.",
                            "Specular shapes bend realistically over surface ridges and creases.",
                            "Gloss, satin, and matte finishes feel unmistakably distinct."
                        ),
                        criteria = "Complete 5 semi-gloss, leather, and wet-surface studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_reflect",
                        reinforcedSkillIds = listOf("sk_edge_control")
                    )
                )
            ),
            buildUnit(
                7, 3, "w7_u3", "Fabric Folds & Drapery Mechanics",
                "Understand how gravity, tension points, and stiffness shape the 7 classic fold patterns.",
                listOf(
                    LessonSpec(
                        id = "w7_u3_l1",
                        title = "Pipe, Diaper & Half-Lock Tension Folds",
                        subtitle = "Reading anchor points and hanging gravity",
                        objective = "Construct pipe folds (one anchor), diaper folds (two anchors), and half-lock folds (bent joints) from underlying tension geometry.",
                        explanation = "Cloth isn't random wrinkles—it obeys physics! Every fold radiates directly out from **stress/pinch points** (a nail, shoulder, belt, or bent knee). A hanging curtain from one hook forms vertical **pipe cones**; cloth sagging between two hooks forms U-shaped **diaper loops**; a bent sleeve compresses into **half-locks**.",
                        whyItMatters = "Makes clothed figures, beds, curtains, and still-life tablecloths look solid and natural instead of scribbled lines.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Hanging towel or draped T-shirt", "Sketchbook"),
                        steps = listOf(
                            "Pinch a towel by one corner (Pipe fold), then drape it between two clothespins/books (Diaper fold).",
                            "Draw ONLY the tension anchor points and radiating ridge centerlines first.",
                            "Treat each ridge as a narrow tapering cylinder/cone with a lit top crest, soft turning core shadow, and crisp cast shadow into the valley beneath!"
                        ),
                        ex1Title = "Single-Hook Pipe Folds",
                        ex1Desc = "Hang a towel from one hook/knob. Construct 2 hanging studies treating each vertical pleat as a solid tapering cone/cylinder.",
                        ex1Reps = "2 hanging pipe-fold studies",
                        ex1Min = 12,
                        ex2Title = "Two-Anchor Diaper Swag",
                        ex2Desc = "Pin or drape fabric sagging between two spaced points. Map the radiating U-loops and shade alternating crest/valley rhythms.",
                        ex2Reps = "2 diaper swag fold studies",
                        ex2Min = 12,
                        ex3Title = "Fold Cross-Section Ribbon Check",
                        ex3Desc = "Draw a cross-section slice across 3 pleats showing how cloth winds cleanly over rounded hills and tucks behind valleys.",
                        ex3Reps = "3 drapery cross-section diagrams",
                        ex3Min = 6,
                        challengeTitle = "Tablecloth Corner Drop",
                        challengeDesc = "Drape a cloth over the corner of a box or table edge and render the radiating conical pleats cascading off the rigid corner.",
                        challengeReps = "1 box-corner drapery study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing isolated dark lines for creases without modeling the rounded cylindrical ridge beside them" to "Every crease has a rounded hill next to a valley—shade the hill smoothly!",
                            "Folds floating independently without radiating from an anchor point" to "Trace every fold line cleanly back toward its pinch/support point."
                        ),
                        checklist = listOf(
                            "Every fold radiates logically from a gravity/tension anchor point.",
                            "Fold ridges read as solid cylindrical volumes with core shadows.",
                            "Valleys receive crisp cast shadows from overlapping crests."
                        ),
                        criteria = "Complete 7 pipe, diaper, and cross-section drapery studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_fabric"
                    ),
                    LessonSpec(
                        id = "w7_u3_l2",
                        title = "Zigzag, Spiral & Drop Folds on Limbs",
                        subtitle = "How fabric compresses and wraps around cylinders",
                        objective = "Construct realistic sleeve and pant-leg creases using interlocking zigzag wedges and spiral wraps around cylindrical forms.",
                        explanation = "When a cylindrical sleeve bends at the elbow, excess fabric compresses inside the bend into **interlocking Y-shaped zigzag folds** while pulling taut in diagonal **spiral folds** around the outer forearm.",
                        whyItMatters = "Directly unlocks realistic clothing on human figures in World 9.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Your own bent sleeve or draped pants", "Sketchbook"),
                        steps = listOf(
                            "Draw a bent cylindrical arm/tube lightly in 2H first—NEVER forget the solid limb inside!",
                            "Mark the taut tension lines pulling around the outer bend (Spiral folds).",
                            "At the inner compression crook, alternate interlocking triangular Y-creases wrapping halfway around the cylinder."
                        ),
                        ex1Title = "Bent-Arm Sleeve Compression",
                        ex1Desc = "Bend your own arm in a sweatshirt/jacket or pose a stuffed sleeve at 90°. Draw the inner cylinder first, then layer Y-zigzags and outer spiral pulls.",
                        ex1Reps = "2 bent-sleeve fold studies",
                        ex1Min = 14,
                        ex2Title = "Interlocking Zigzag Tube Drill",
                        ex2Desc = "Draw 2 upright bunched cloth cylinders (like socks/boots pushed down) alternating crisp interlocking wedge folds left and right.",
                        ex2Reps = "2 zigzag tube studies",
                        ex2Min = 10,
                        ex3Title = "Spiral Tension Wrap",
                        ex3Desc = "Twist a dish towel gently and draw the diagonal spiral ridges hugging the central twisted cylinder.",
                        ex3Reps = "2 twisted spiral cloth studies",
                        ex3Min = 8,
                        challengeTitle = "Hoodie Sleeves & Torso Gather",
                        challengeDesc = "Drape a hoodie over the back of a chair and capture how drop folds hang freely off shoulders while spiral folds pull at the waist.",
                        challengeReps = "1 draped garment plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Drawing flat chevron zigzags all symmetrical left-to-right" to "Stagger and alternate overlapping Y-joints asymmetrically.",
                            "Letting sleeves lose the underlying arm volume" to "Keep cross-contour curvature wrapping tightly around the hidden arm cylinder."
                        ),
                        checklist = listOf(
                            "Underlying cylinder/limb volume remains clearly readable beneath cloth.",
                            "Compression folds stagger naturally with interlocking Y-junctions.",
                            "Taut outer areas stay clean and relatively unwrinkled."
                        ),
                        criteria = "Complete 6 zigzag, spiral, and bent-sleeve drapery studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_fabric",
                        reinforcedSkillIds = listOf("sk_spheres_cyl")
                    ),
                    LessonSpec(
                        id = "w7_u3_l3",
                        title = "Fabric Weight: Silk vs. Heavy Wool",
                        subtitle = "Controlling fold frequency, edge sharpness, and thickness",
                        objective = "Differentiate light crisp fabric (cotton/silk) from stiff heavy cloth (denim/wool) through fold count, curvature, and lip thickness.",
                        explanation = "Thin silk cascades in many narrow, sharp, undulating ripples; heavy wool or denim drops in fewer, wider, thicker tube arches with visible rounded fabric edge lips.",
                        whyItMatters = "Makes clothing materials instantly recognizable in monochrome drawings.",
                        materials = listOf("HB, 2B, 4B pencils", "Thin scarf/shirt vs. heavy towel/denim", "Sketchbook"),
                        steps = listOf(
                            "Drape a thin shirt/tissue next to a heavy towel or denim jacket over the same chair edge.",
                            "Count fold frequency: thin cloth packs 8–10 tight narrow folds; heavy cloth forms 3–4 broad, thick bends.",
                            "Notice the thick rounded folded lip thickness on heavy fabric edges."
                        ),
                        ex1Title = "Thin Cloth vs. Thick Blanket Pair",
                        ex1Desc = "Drape a thin handkerchief and a thick towel side by side over a book stack; contrast crisp tight ripples vs. chunky broad arches.",
                        ex1Reps = "2 fabric-weight comparison studies",
                        ex1Min = 14,
                        ex2Title = "Heavy Denim Cuff & Seam Study",
                        ex2Desc = "Draw a rolled-up jeans cuff or heavy canvas sleeve highlighting thick folded corner lips, broad creases, and subtle stitch ticks.",
                        ex2Reps = "1 heavy-cloth cuff study",
                        ex2Min = 12,
                        ex3Title = "Soft Ribbon Flow Contrast",
                        ex3Desc = "Draw a thin silk/satin ribbon curving across a table—pair soft rolling form turns with crisp bright specular ribbon glints.",
                        ex3Reps = "2 shiny-thin ribbon studies",
                        ex3Min = 8,
                        challengeTitle = "Draped Chair Coat With Collar Thickness",
                        challengeDesc = "Render a heavy wool or leather coat draped over a chair back, showing thick lapel roll, heavy broad back folds, and thin inner lining peeking out.",
                        challengeReps = "1 multi-weight garment plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Drawing 20 tiny hairline wrinkles on heavy winter coats or jeans" to "Edit heavy cloth down to 3–5 large bold structural folds.",
                            "Paper-thin knife edges on thick wool blankets" to "Give turned hems a rounded double-edge thickness."
                        ),
                        checklist = listOf(
                            "Thin fabrics show crisp, tighter, more numerous folds.",
                            "Heavy fabrics show broader curves and visible edge thickness.",
                            "Every fold still obeys 5-zone light and cast-shadow logic."
                        ),
                        criteria = "Complete 5 contrasting light-vs-heavy fabric weight studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_fabric"
                    )
                )
            ),
            buildUnit(
                7, 4, "w7_u4", "Skin, Hair & Organic Tactile Synthesis",
                "Approach hair as sculpted tonal masses and skin as subtle tonal transitions before uniting 6 materials.",
                listOf(
                    LessonSpec(
                        id = "w7_u4_l1",
                        title = "Hair as Sculpted Ribbons & Clumps",
                        subtitle = "Never draw individual spaghetti strands",
                        objective = "Construct realistic hair using broad overlapping S-ribbon volumes, major shadow shapes, and selective tapered strand breaks.",
                        explanation = "Drawing hair line-by-line looks like wire straw. Hair behaves like stacked **thick shiny ribbons** wrapping around a skull! Block the big tonal volume first (just like a cylinder/ribbon), carve major clump separations, lift curved glossy highlight bands across ridges, and pull only a few delicate flyaways at silhouettes.",
                        whyItMatters = "Directly solves the most common portrait struggle ahead of World 10.",
                        materials = listOf("HB, 2B, 4B pencils", "Kneaded + sharp vinyl eraser", "Sketchbook"),
                        steps = listOf(
                            "Draw a light egg/sphere skull base first so hair sits *over* volume (never flat against the forehead).",
                            "Divide hair into 4–6 broad interlocking S-ribbons following gravity and part lines.",
                            "Shade each ribbon clump cleanly from dark root/under-overlap to a bright lifted highlight band wrapping around the head's curve, adding fine tapered strokes ONLY at breaks."
                        ),
                        ex1Title = "Braided & Flowing Hair Ribbons",
                        ex1Desc = "Draw 3 floating sculptural ribbon locks (straight, wavy S-lock, and spiral curl) treating each lock purely as a glossy 3D curved cylinder.",
                        ex1Reps = "3 distinct sculpted hair locks",
                        ex1Min = 12,
                        ex2Title = "Head-Wrapping Hair Mass Block-In",
                        ex2Desc = "Draw 2 simple egg-head silhouettes from 3/4 view and build broad, layered hair clumps wrapping cleanly over skull crown and behind ears.",
                        ex2Reps = "2 full hair-mass head studies",
                        ex2Min = 12,
                        ex3Title = "Curly & Coiled Mass Grouping",
                        ex3Desc = "Render a cluster of tight curls by grouping big cloud-like shadow masses first, then carving coiled highlight arcs and dark crevice curls.",
                        ex3Reps = "2 curly mass studies",
                        ex3Min = 8,
                        challengeTitle = "Ponytail & Parted Crown Study",
                        challengeDesc = "Render a tied ponytail pulled back tight over a sphere crown into a gathered band and cascading ribbon curls below.",
                        challengeReps = "1 gathered hair volume plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing hundreds of uniform parallel lines from root to tip" to "Group into 5–7 major light-and-shadow clumps first; suggest strands mainly near highlights and tips.",
                            "Placing hair completely flat against the skull outline" to "Give hair real loft and thickness stepping outward from the cranium."
                        ),
                        checklist = listOf(
                            "Hair reads as 3D sculpted volumes rather than flat wire lines.",
                            "Highlight bands sweep continuously across adjacent locks around the head's curve.",
                            "Individual strand breaks appear selectively at edges and ends."
                        ),
                        criteria = "Complete 7 ribbon, wavy, coiled, and head-wrapping hair studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_organic"
                    ),
                    LessonSpec(
                        id = "w7_u4_l2",
                        title = "Soft Skin, Fur & Organic Transitions",
                        subtitle = "Subtle halftones and directional micro-breaks",
                        objective = "Render smooth satin organic surfaces (skin/knuckles) and soft animal fur using micro-value control rather than harsh lines.",
                        explanation = "Smooth skin has gentle translucent halftone turns with delicate edge-softness and subtle crease shadows; soft fur breaks ONLY along the **terminator and outer silhouette** into tiny tapered directional tufts while keeping lit centers soft and clean.",
                        whyItMatters = "Prevents portraits from looking aged/leathery and animals from looking stiffly bristled like porcupines.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "For skin: observe your own knuckles or wrist under side light; build soft 2H/HB halftones over big form planes, saving sharp lines strictly for joint creases.",
                            "For fur: shade a smooth animal-muzzle form first, then break the shadow terminator and outer edge with short overlapping V-tufts pointing along growth flow."
                        ),
                        ex1Title = "Back-of-Hand & Knuckle Skin Study",
                        ex1Desc = "Pose your free hand gently relaxed under side light; render soft tendon hollows, smooth satin skin turns, and subtle knuckle crease accents.",
                        ex1Reps = "1 smooth skin observational study",
                        ex1Min = 14,
                        ex2Title = "Short Fur vs. Long Fur Balls",
                        ex2Desc = "Draw two 6 cm spheres: shade both smoothly first, then break edges/terminators into short velvety cat-fur ticks (left) vs. parted long dog-fur tufts (right).",
                        ex2Reps = "2 fur-textured spheres",
                        ex2Min = 12,
                        ex3Title = "Subtle Pore/Freckle Restraint",
                        ex3Desc = "On a simple organic rounded lobe, practice suggesting skin pores ONLY along the 1 cm turning highlight/halftone zone.",
                        ex3Reps = "1 restrained skin-grain swatch",
                        ex3Min = 6,
                        challengeTitle = "Soft Peach / Kiwifruit Dual Texture",
                        challengeDesc = "Draw a fuzzy peach or kiwifruit next to a shiny plum to contrast velvety soft backlit rim fuzz against smooth tight skin.",
                        challengeReps = "1 fruit surface contrast study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing dark fur hairs across the entire bright sunlit face" to "Keep bright fur areas quiet; show individual hair tufts mainly at shadow edges and outer breaks.",
                            "Drawing harsh dark black outlines around skin wrinkles" to "Model soft rounded light rolls beside subtle mid-dark creases."
                        ),
                        checklist = listOf(
                            "Skin planes turn softly without scratchy dark texture.",
                            "Fur clusters align along natural growth directions and taper cleanly.",
                            "Underlying 3D roundness remains unmistakable on both skin and fur."
                        ),
                        criteria = "Complete 4 skin and organic fur texture studies.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_organic",
                        reinforcedSkillIds = listOf("sk_edge_control")
                    ),
                    LessonSpec(
                        id = "w7_u4_l3",
                        title = "Multi-Material Texture Matrix",
                        subtitle = "Contrasting 4 materials under shared lighting",
                        objective = "Render four different material spheres/cylinders side-by-side under one consistent light source so each reads unmistakably.",
                        explanation = "The ultimate test of material mastery is placing contrasting textures next to each other—smooth glass beside rough bark, draped silk beside brushed steel—under the EXACT same light direction.",
                        whyItMatters = "Prepares you directly for World 7's Milestone Project and realistic multi-material illustrations.",
                        materials = listOf("2H, HB, 2B, 4B, 6B pencils", "Kneaded + vinyl erasers", "Drawing paper"),
                        steps = listOf(
                            "Draw four 5.5 cm spheres in a neat 2×2 grid lit identically from top-left.",
                            "Assign Material 1: Rough Bark/Stone; Material 2: Mirror Chrome; Material 3: Clear Glass; Material 4: Soft Fur or Draped Cloth.",
                            "Check from arm's length that all four clearly share one room light while reading completely differently."
                        ),
                        ex1Title = "2×2 Material Sphere Grid (Setup & Lighting)",
                        ex1Desc = "Construct the 4 spheres and shared cast-shadow ground plane cleanly, setting local value ranges for each material.",
                        ex1Reps = "4 base-lit spheres",
                        ex1Min = 10,
                        ex2Title = "2×2 Material Texture Pass",
                        ex2Desc = "Render Stone/Wood, Chrome, Glass, and Fur/Cloth textures onto the four spheres respecting every material's edge and reflection behavior.",
                        ex2Reps = "4 distinct material spheres",
                        ex2Min = 18,
                        ex3Title = "Material Contrast Self-Audit",
                        ex3Desc = "Write a 1-line note under each sphere summarizing what edge/contrast cue sells that material best.",
                        ex3Reps = "4 annotated material notes",
                        ex3Min = 4,
                        challengeTitle = "Real Mixed-Material Pocket Dump",
                        challengeDesc = "Empty 3 pocket items (metal keys, leather wallet/cloth pouch, plastic/glass item) onto your desk and render their material differences cleanly.",
                        challengeReps = "1 live mixed-material study",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Using the same soft shading edge sharpness on metal, stone, and fur" to "Contrast razor-crisp edges on chrome/glass against broken tufts on fur and pitted chips on stone.",
                            "Forgetting consistent cast shadow direction across all four" to "Anchor all four onto matching ground cast shadows."
                        ),
                        checklist = listOf(
                            "All 4 materials share the exact same top-left light direction.",
                            "Each material is instantly identifiable without labels.",
                            "Edges, highlights, and cast shadows match each material's physics."
                        ),
                        criteria = "Complete the 2×2 contrasting material matrix to unlock World 7's Milestone Project.",
                        diagramType = DiagramType.TEXTURE_STUDIES,
                        primarySkillId = "sk_tex_organic",
                        reinforcedSkillIds = listOf("sk_tex_hard", "sk_tex_reflect", "sk_tex_fabric")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w7",
            worldNumber = 7,
            title = "Six-Material Texture Sphere & Drapery Plate",
            brief = "Produce a formal atelier material study sheet combining a draped cloth/scarf base supporting 3 contrasting material objects or spheres (e.g., wooden block/spoon, stainless metal spoon/mug, clear glass jar, plus a textured natural stone or fur/hair lock study) rendered under unified lighting.",
            combinedSkills = listOf("Wood & Stone Grain", "Metal & Glass Reflections", "Fabric Folds", "Organic Hair/Skin/Fur"),
            requiredMaterials = listOf("2H, HB, 2B, 4B, 6B pencils", "Kneaded & sharp vinyl erasers", "A4 Bristol/drawing paper"),
            phases = listOf(
                "Phase 1 (6 min): Plan a balanced 6-part atelier layout (or unified drapery still life with 4+ distinct materials).",
                "Phase 2 (8 min): Construct accurate 3D forms, fold anchor ridges, and global cast-shadow footprints.",
                "Phase 3 (14 min): Establish local value keys and 5-zone base lighting across matte, glossy, and folded areas.",
                "Phase 4 (12 min): Add specular chrome/glass contrast, caustic glow, terminator wood/stone pits, and tapered hair/fur edge breaks."
            ),
            selfAssessmentChecklist = listOf(
                "Every texture reinforces underlying 3D lighting rather than flattening it.",
                "Fabric folds radiate from clear tension points with cylindrical volume.",
                "Metal & glass feature crisp value jumps and realistic refraction/caustics.",
                "Matte wood, stone, and organic forms preserve calm highlights and tactile terminators."
            ),
            estimatedMinutes = 40,
            xpReward = 215
        )
    ),

    // WORLD 8: NATURE
    DrawingWorld(
        number = 8,
        id = "world_8",
        title = "Nature",
        tagline = "Bring organic rhythm, botanical accuracy, landscapes, and animal structure to life",
        focusSummary = "Construct twisting leaves and radially balanced flowers, branching trees, craggy rocks and clouds, and solid animal forms with directional fur/feathers.",
        unlockRequirementSummary = "Complete World 7 Milestone & reach Practicing in Texture skills",
        units = listOf(
            buildUnit(
                8, 1, "w8_u1", "Plants, Leaves & Botanical Flowers",
                "Capture curling ribbons, central stem flow, and cup-shaped floral symmetry without flat pressed-flower stiffness.",
                listOf(
                    LessonSpec(
                        id = "w8_u1_l1",
                        title = "Flowing Stems & Twisting Leaf Ribbons",
                        subtitle = "Seeing leaves as thin curving planes in 3D",
                        objective = "Draw realistic plant leaves twisting smoothly in space with continuous central midribs and clean edge folds.",
                        explanation = "A leaf is NEVER a flat symmetrical football shape—it is a flexible 3D ribbon bending under its own weight! Drawing the sweeping central **stem + midrib axis** first, then wrapping the left and right edges smoothly around that curve (even folding one edge behind the midrib) brings instant life.",
                        whyItMatters = "Transforms stiff botanical icons into living, breathing foliage.",
                        materials = listOf("2H, HB, 2B pencils (or 0.3mm pen)", "Real houseplant or sprig of leaves", "Sketchbook"),
                        steps = listOf(
                            "Draw a graceful sweeping stem line continuing unbroken into the leaf's center midrib.",
                            "Plot two curving side outlines that cross cleanly if the leaf twists over to reveal its underside!",
                            "Darken the overlap fold line and add subtle diagonal leaf veins following the surface turn—never dark ladder bars."
                        ),
                        ex1Title = "Twisting Ribbon Leaf Variations",
                        ex1Desc = "Draw 10 individual leaves twisting at different foreshortened angles (curling toward you, folding over to show underside, drooping downward).",
                        ex1Reps = "10 varied 3D twisting leaves",
                        ex1Min = 12,
                        ex2Title = "Stem-to-Leaf Branch Attachment",
                        ex2Desc = "Draw a real potted plant sprig or tree twig showing 6–8 leaves radiating cleanly out of cylindrical nodes along a tapering woody stem.",
                        ex2Reps = "2 multi-leaf botanical sprigs",
                        ex2Min = 12,
                        ex3Title = "Serrated & Lobed Edge Rhythms",
                        ex3Desc = "Draw an oak, maple, or fern frond by sketching the big simple mitten envelope first, then carving rhythmic toothed lobes along the border.",
                        ex3Reps = "3 lobed-leaf envelopes",
                        ex3Min = 8,
                        challengeTitle = "Wilting Tulip or Houseplant Cluster",
                        challengeDesc = "Observe a full potted houseplant for 15 minutes, mapping overlapping near/far leaves with crisp line-weight separation.",
                        challengeReps = "1 full potted plant study",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing leaf veins like heavy black fishbone ribs" to "Keep veins whisper-light and curve them gently forward along the leaf's 3D camber.",
                            "Disconnected leaf edges meeting awkwardly at twists" to "Trace the continuous midrib and both outer edges transparently through the twist first."
                        ),
                        checklist = listOf(
                            "Leaves twist smoothly showing both upper and underside surfaces.",
                            "Central stems flow uninterrupted into leaf midribs.",
                            "Overlapping leaves separate cleanly via line weight and shadow."
                        ),
                        criteria = "Complete 15 twisting leaves, sprig attachments, and lobed foliage studies.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_botanical"
                    ),
                    LessonSpec(
                        id = "w8_u1_l2",
                        title = "Floral Cups, Cones & Layered Petals",
                        subtitle = "Constructing daisies, roses, and lilies in 3D",
                        objective = "Construct flowers using tilted conical/spherical cups and perspective ellipses so petals wrap radially around a solid center.",
                        explanation = "Every flower sits inside a **3D cone, saucer, or cup**! Before drawing a single petal on a daisy or tulip, draw its tilted perspective rim ellipse and central cone/button—then tuck petals naturally around that ellipse so foreshortened front petals compress convincingly.",
                        whyItMatters = "Prevents flowers from collapsing into flat pinned pinwheels.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook", "Real flower or botanical photo reference"),
                        steps = listOf(
                            "Draw the flower stem spine and attach a tilted cup/cone or saucer ellipse facing the bloom's direction.",
                            "Divide the outer rim ellipse symmetrically into petal anchor wedges.",
                            "Wrap petals outward from the raised center button—foreshortening front petals short and sweeping side petals wide."
                        ),
                        ex1Title = "Tilted Daisy & Sunflower Cups",
                        ex1Desc = "Construct 4 simple radial flowers tilted at 0°, 30°, 60°, and profile views using tilted bounding ellipses before sketching petals.",
                        ex1Reps = "4 tilted floral perspective studies",
                        ex1Min = 12,
                        ex2Title = "Tulip & Bell Cup Layering",
                        ex2Desc = "Draw 3 cup-shaped flowers (tulip, poppy, or lily) showing inner petals cradling the stamen and outer petals overlapping beneath.",
                        ex2Reps = "3 cup-flower studies",
                        ex2Min = 10,
                        ex3Title = "Spiral Rose Construction",
                        ex3Desc = "Start with an inner teardrop cone/egg, then wrap 3 concentric layers of curling petals hugging outward like loose cabbage leaves.",
                        ex3Reps = "2 layered rose constructions",
                        ex3Min = 12,
                        challengeTitle = "Three-Stage Bloom Botanical Plate",
                        challengeDesc = "Draw a single species (e.g., lily or rose) as a tight bud, half-open cup, and full bloom on one shared botanical page.",
                        challengeReps = "1 three-stage botanical plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing all petals identical length even when tilted toward the viewer" to "Follow your tilted rim ellipse strictly—petals pointing right at you look dramatically shorter!",
                            "Floating petals disconnected from the stem receptacle" to "Trace petals invisibly down into the calyx cup under the bloom."
                        ),
                        checklist = listOf(
                            "Petals follow the perspective foreshortening of the outer bounding ellipse.",
                            "Inner petals tuck clearly inside outer overlapping petals.",
                            "Stems join seamlessly into a solid calyx base."
                        ),
                        criteria = "Complete 9 radial, cup, and layered-rose floral constructions.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_botanical"
                    ),
                    LessonSpec(
                        id = "w8_u1_l3",
                        title = "Foliage Canopy Grouping & Light",
                        subtitle = "Shading bushes and bouquets as unified masses",
                        objective = "Render dense leaf clusters and potted bushes as big shadowed spheres/clouds first before suggesting individual leaves.",
                        explanation = "Drawing 400 individual leaves identically turns into gray noise. Instead, group foliage into **3–5 big rounded cloud domes**, shade each dome cleanly with a light side, core shadow, and bottom bounce, and draw crisp individual leaf cutouts strictly along the sunlit crests and silhouette edges!",
                        whyItMatters = "Allows you to draw entire hedges, trees, and floral bouquets quickly with lush volume.",
                        materials = listOf("HB, 2B, 4B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Block a shrub or bouquet as 3–5 overlapping puffy cloud masses.",
                            "Shade the entire underside/shadow pockets of each cloud smoothly at Value #6–#7.",
                            "Carve crisp individual leaf triangles along the outer edge and along the light-to-shadow terminator border."
                        ),
                        ex1Title = "3-Dome Shrub Mass Study",
                        ex1Desc = "Construct a rounded garden bush from 4 overlapping cloud spheres, establish 5-zone lighting, and break ONLY silhouettes and terminators into small leaf clusters.",
                        ex1Reps = "2 lit foliage dome studies",
                        ex1Min = 12,
                        ex2Title = "Leafy Potted Fern / Ivy Cluster",
                        ex2Desc = "Draw a cascading hanging vine or fern by grouping shaded leaf layers behind brightly lit foreground leaves.",
                        ex2Reps = "1 layered hanging plant study",
                        ex2Min = 12,
                        ex3Title = "Negative-Space Sky Holes",
                        ex3Desc = "In a bushy canopy, leave 3–4 irregular bright 'sky-hole' cutouts peeking cleanly through thinner branch gaps.",
                        ex3Reps = "2 pierced canopy silhouettes",
                        ex3Min = 7,
                        challengeTitle = "Wildflower Vase Bouquet",
                        challengeDesc = "Arrange 3 hero blooms inside soft grouped foliage masses in a simple glass jar, preserving crisp focal detail on hero petals.",
                        challengeReps = "1 botanical bouquet vignette",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Drawing solid black outlines around every single leaf inside the bush" to "Hide interior leaf borders inside soft midtone shadow groups.",
                            "Making the bush outer silhouette look like a smooth green bowling ball" to "Break outer perimeters with varied irregular leaf sprigs and sky gaps."
                        ),
                        checklist = listOf(
                            "The bush reads clearly as 3D lit and shaded volumes from afar.",
                            "Individual leaves appear selectively near edges and light breaks.",
                            "Sky holes prevent the canopy from looking like a solid concrete blob."
                        ),
                        criteria = "Complete 5 grouped foliage volume studies.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_botanical",
                        reinforcedSkillIds = listOf("sk_form_shadow")
                    )
                )
            ),
            buildUnit(
                8, 2, "w8_u2", "Trees, Rocks, Clouds & Terrain",
                "Construct branching trunks, fractured rock strata, airy clouds, and sweeping layered landscapes.",
                listOf(
                    LessonSpec(
                        id = "w8_u2_l1",
                        title = "Tapering Tree Trunks & Branching Rhythm",
                        subtitle = "Cylindrical growth, Y-forks, and bark flow",
                        objective = "Construct organic tapering trees using cylindrical branch collars, natural thickness ratios, and 3D canopy volume.",
                        explanation = "Trees grow upward and outward in diminishing **cylinders**! At every Y-fork, the combined cross-section of child branches equals the parent trunk below, and branches flare gracefully out in 3D (pointing toward and away from you—not flat like a 2D rake!).",
                        whyItMatters = "Convincing trees ground nearly every outdoor landscape and architectural sketch.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Real tree view or reference", "Sketchbook"),
                        steps = listOf(
                            "Anchor thick flaring root buttresses solidly into the ground contour.",
                            "Draw a tapering curved trunk cylinder with subtle cross-contours, splitting into varied asymmetric Y-forks.",
                            "Bring at least 2 branches visibly forward toward the viewer (foreshortened!) and tuck 2 behind before placing cloud-canopy caps."
                        ),
                        ex1Title = "Bare Winter Branching Skeleton",
                        ex1Desc = "Draw 3 bare deciduous trees (oak, birch, twisted olive/pine) focusing purely on flaring roots, tapering cylinders, and organic asymmetric Y-forks.",
                        ex1Reps = "3 bare winter tree skeletons",
                        ex1Min = 14,
                        ex2Title = "Foreshortened Branch Collar Study",
                        ex2Desc = "Zoom in on a thick trunk section where one stubby branch points directly toward the viewer and another recedes behind—wrap cross-contours and bark ridges.",
                        ex2Reps = "2 foreshortened trunk fork studies",
                        ex2Min = 10,
                        ex3Title = "Full-Leaf Tree Canopy + Trunk",
                        ex3Desc = "Construct an oak or cypress tree combining solid cylindrical trunk, shaded under-canopy cast shadows, and sunlit foliage puffs.",
                        ex3Reps = "2 full-leaf tree portraits",
                        ex3Min = 12,
                        challengeTitle = "Pine / Conifer Tiered Skirt Study",
                        challengeDesc = "Draw a windswept mountain pine showing drooping needle bough skirts casting deep dark shadows down the reddish bark trunk.",
                        challengeReps = "1 mountain pine study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing branches sticking out flat only to the left and right like a candelabra" to "Project branches forward and backward in front of and behind the trunk.",
                            "Making upper branches thicker than the trunk supporting them" to "Taper width strictly at every single split."
                        ),
                        checklist = listOf(
                            "Roots flare convincingly into the soil rather than ending like a pole.",
                            "Branches fork asymmetrically and reach in all 3D directions.",
                            "Canopy leaves cast clear shadow pockets onto upper branches."
                        ),
                        criteria = "Complete 7 branching skeleton, trunk fork, and full-canopy tree studies.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_trees_terrain",
                        reinforcedSkillIds = listOf("sk_spheres_cyl")
                    ),
                    LessonSpec(
                        id = "w8_u2_l2",
                        title = "Rocks, Cliff Strata & Terrain Planes",
                        subtitle = "Seeing rocks as fractured angular boxes",
                        objective = "Construct believable boulders, cliffs, and rocky terrain using clear 3D box/wedge facets and rhythmic strata lines.",
                        explanation = "Beginners draw rocks like soft potatoes! Real rocks have sharp cleavage planes, flat top/side/front faces, and layered sedimentary fracture lines. Treating every rock first as a **chipped geometric box or wedge** immediately locks in sharp sunlight vs. crisp shadow.",
                        whyItMatters = "Gives natural landscapes grounded structural weight alongside soft trees and clouds.",
                        materials = listOf("HB, 2B, 4B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Block a boulder cluster using Big-Medium-Small angular wedge boxes overlapping cleanly.",
                            "Establish one strong directional light and shade every side/under-plane strictly planar (#4 side, #8 shadow).",
                            "Add jagged diagonal strata seams and subtle pebble scatter around the base contact shadows."
                        ),
                        ex1Title = "Big-Medium-Small Boulder Cluster",
                        ex1Desc = "Compose a group of 5 overlapping boulders (1 giant hero slab, 2 medium blocks, 2 small rubble chips) shaded with crisp planar faces.",
                        ex1Reps = "2 boulder cluster studies",
                        ex1Min = 13,
                        ex2Title = "Stratified Cliff Wall Study",
                        ex2Desc = "Draw a jagged cliff face showing tilted geological rock layers stepping backward and overhanging ledges casting sharp dark shadows.",
                        ex2Reps = "1 stratified cliff study",
                        ex2Min = 12,
                        ex3Title = "Contouring Rolling Hills & Path",
                        ex3Desc = "Sketch a winding dirt trail crossing rolling hills—use subtle cross-contour grass tufts and overlapping ridge silhouettes to show elevation drops.",
                        ex3Reps = "2 terrain elevation studies",
                        ex3Min = 8,
                        challengeTitle = "Waterfall Gorge Over Rock Ledges",
                        challengeDesc = "Combine jagged dark wet cliff ledges with bright cascading vertical white water ribbons and misty soft spray at the pool base.",
                        challengeReps = "1 rock-and-waterfall plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing identical smooth round pebble potatoes scattered evenly" to "Mix sharp angular facets with varied sizes and pack small rubble near big bases.",
                            "Forgetting cast shadows between stacked rocks" to "Use crisp dark crevices where rocks press against neighboring boulders."
                        ),
                        checklist = listOf(
                            "Rocks display crisp top, side, and shadow planes instead of flat ovals.",
                            "Sizes follow Big-Medium-Small rhythmic clustering.",
                            "Terrain lines overlap clearly to convey hill depth."
                        ),
                        criteria = "Complete 5 rock cluster, cliff strata, and rolling terrain studies.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_trees_terrain",
                        reinforcedSkillIds = listOf("sk_cubes", "sk_tex_hard")
                    ),
                    LessonSpec(
                        id = "w8_u2_l3",
                        title = "Clouds, Water & Atmospheric Landscapes",
                        subtitle = "Perspective in the sky and depth across hills",
                        objective = "Construct volumetric cumulus clouds in perspective and layer foreground/midground/background landscape planes with atmospheric value fade.",
                        explanation = "Clouds are NOT flat cotton stickers—they have flat perspective bases sitting on a shared sky ceiling layer and puffy lit tops! Distant mountains fade lighter in value, drop internal contrast, and soften edges as atmospheric haze builds between you and the horizon.",
                        whyItMatters = "Teaches you how to create miles of open depth on a small sheet of paper.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Sketchbook"),
                        steps = listOf(
                            "Draw a low Horizon Line and divide a landscape into Foreground (darkest darks #9, sharpest textures), Midground (#3–#6), and Far Mountains (#1.5–#3 soft gray).",
                            "Sketch receding cloud bottoms flatter and closer together near the horizon, taller and puffier overhead.",
                            "For still water: mirror vertical shoreline shapes directly underneath in softer broken horizontal ripples."
                        ),
                        ex1Title = "3-Plane Atmospheric Mountain Vista",
                        ex1Desc = "Draw 3 receding mountain/hill ridges behind a dark foreground pine silhouette—step contrast cleanly down with every receding layer.",
                        ex1Reps = "2 atmospheric depth vistas",
                        ex1Min = 12,
                        ex2Title = "Volumetric Cumulus Sky Study",
                        ex2Desc = "Shade a soft #3 sky tone first, then lift billowing sunlit #1 cloud tops with a kneaded eraser and tuck soft #5 undersides flattened along perspective cloud bases.",
                        ex2Reps = "2 perspective cloud skies",
                        ex2Min = 12,
                        ex3Title = "Lakeside Water Reflection Sketch",
                        ex3Desc = "Sketch a simple shoreline boulder and tree mirrored downward across calm water broken by crisp horizontal ripple streaks.",
                        ex3Reps = "2 water reflection studies",
                        ex3Min = 8,
                        challengeTitle = "Dramatic Storm Clouds Over Flat Prairie",
                        challengeDesc = "Compose a wide low-horizon prairie road leading toward towering layered storm clouds with shafts of lifted kneaded-eraser sunbeams.",
                        challengeReps = "1 atmospheric sky-and-road plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing faraway mountain ridges with heavy dark 4B outlines" to "Keep distant mountains ultra-light 2H/HB so they sit miles behind foreground darks.",
                            "Drawing fluffy puffy loops on the bottom of cumulus clouds" to "Flatten cloud bottoms into perspective planes receding toward the horizon."
                        ),
                        checklist = listOf(
                            "Foreground holds deepest contrast while distant hills fade light and soft.",
                            "Cloud bottoms flatten and compress toward the horizon.",
                            "Water reflections drop vertically beneath objects and break horizontally."
                        ),
                        criteria = "Complete 6 atmospheric landscape, cloud, and water reflection studies.",
                        diagramType = DiagramType.COMPOSITION_THIRDS,
                        primarySkillId = "sk_trees_terrain",
                        reinforcedSkillIds = listOf("sk_edge_control")
                    )
                )
            ),
            buildUnit(
                8, 3, "w8_u3", "Animal Construction & Gesture",
                "Simplify birds, dogs, cats, and horses into rhythmic action lines and proportional 3D volumes.",
                listOf(
                    LessonSpec(
                        id = "w8_u3_l1",
                        title = "Animal Gesture & Spine Line of Action",
                        subtitle = "Capturing life and movement before anatomy",
                        objective = "Capture the primary C/S-curve spine flow, neck arc, and weight shift of birds and quadrupeds in 1–3 minute gesture sketches.",
                        explanation = "Animals move faster than still lifes! Capturing an animal starts with ONE rhythmic **Line of Action** sweeping from head through neck, arched ribcage, spine, and tail—plus leg angles showing which limbs bear weight.",
                        whyItMatters = "Prevents stiff 'taxidermy' animal drawings and unlocks energetic pet and wildlife sketching.",
                        materials = listOf("2B pencil or charcoal pencil", "Newsprint or sketchbook", "Pet or wildlife photo/video pauses"),
                        steps = listOf(
                            "Spend 15 seconds tracing ONLY the flowing C- or S-curve spine from crown to tail tip.",
                            "Drop two simple ovals/beans for the ribcage and pelvis anchored along that curve.",
                            "Flick fast rhythmic lines for leg reach and ear/beak tilt—do not draw fur or eyes!"
                        ),
                        ex1Title = "10 One-Minute Bird & Cat Gestures",
                        ex1Desc = "Sketch 10 rapid 60-second animal gestures (perching birds, stretching cats, running dogs) using flowing curves + 2 body ovals only.",
                        ex1Reps = "10 sixty-second gestures",
                        ex1Min = 10,
                        ex2Title = "Quadruped Leg Stride Triangles",
                        ex2Desc = "Draw 6 walking/running dog or horse side profiles focusing purely on the Z-shaped shoulder-elbow-wrist and hip-knee-hock joint angles.",
                        ex2Reps = "6 quadruped stride skeletons",
                        ex2Min = 12,
                        ex3Title = "Weight-Bearing vs. Lifted Limbs",
                        ex3Desc = "Draw 4 standing animals showing pelvic tilt when one hind leg rests relaxed vs. planted firmly under the body.",
                        ex3Reps = "4 balanced stance gestures",
                        ex3Min = 8,
                        challengeTitle = "Live Sleeping / Lounging Pet Studies",
                        challengeDesc = "Sketch a real pet (or backyard bird/squirrel) in 5 quick uninterrupted gestures before it shifts pose.",
                        challengeReps = "5 live observation gestures",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing furry outer outlines before finding the ribcage and spine" to "Always lay the spine flow and two torso ovals down first.",
                            "Straight stick legs bending like human knees backwards" to "Remember: what looks like a dog's 'backward knee' in back is actually its elevated ANKLE (hock)—its true knee sits high up near the belly!"
                        ),
                        checklist = listOf(
                            "Every animal gesture shows a clear sweeping spine Line of Action.",
                            "Quadruped leg joints follow true shoulder/elbow and hip/knee/hock Z-angles.",
                            "Poses feel dynamic and balanced rather than frozen."
                        ),
                        criteria = "Complete 20 rapid animal gestures and joint stride studies.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_animal_struct"
                    ),
                    LessonSpec(
                        id = "w8_u3_l2",
                        title = "Bird & Quadruped 3D Volume Construction",
                        subtitle = "Eggs, boxes, cylinders, and muzzle wedges",
                        objective = "Build solid 3D animal bodies in 3/4 view by connecting tilted ribcage eggs, box/wedge pelvises, cylindrical necks, and muzzle boxes.",
                        explanation = "Beneath feathers and fur, a songbird is an egg body + sphere head + triangular beak cone + overlapping wing plates! A dog or horse is a deep barrel-oval ribcage + boxy tapered pelvis connected by a flexible bridge + tapered cylindrical legs + snout box attached to a cranial sphere.",
                        whyItMatters = "Lets you turn animals naturally in 3/4 space instead of getting stuck drawing flat side silhouettes.",
                        materials = listOf("2H & HB pencils", "Sketchbook"),
                        steps = listOf(
                            "Start with the sweeping spine flow and attach a 3D egg ribcage with centerline and cross-contours.",
                            "Connect a tilted rectangular/wedge pelvis behind via the lumbar waist bridge.",
                            "Mount the cranial sphere + tapered box muzzle on a tapering cylinder neck, then attach Z-angled cylinder legs."
                        ),
                        ex1Title = "3/4 Songbird & Owl Constructions",
                        ex1Desc = "Construct 4 birds from varied 3/4 angles using transparent egg torsos, centerlines, folded wing shields, and conical beaks.",
                        ex1Reps = "4 solid 3D bird constructions",
                        ex1Min = 12,
                        ex2Title = "Dog & Cat 3/4 Barrel Assemblies",
                        ex2Desc = "Build 3 dogs/cats in 3/4 perspective showing transparent ribcage ovals, pelvis blocks, cylindrical limbs, and paw pads grounded on a floor plane.",
                        ex2Reps = "3 quadruped 3/4 constructions",
                        ex2Min = 15,
                        ex3Title = "Animal Head & Muzzle Angles",
                        ex3Desc = "Draw 4 animal heads (fox, labrador, cat, horse) as cranial spheres + extruded box muzzles tilted up, down, and sideways.",
                        ex3Reps = "4 cranial + muzzle constructions",
                        ex3Min = 8,
                        challengeTitle = "Leaping Fox or Running Greyhound",
                        challengeDesc = "Construct a dynamic mid-air leaping quadruped stretching spine and limbs cleanly in 3/4 foreshortened perspective.",
                        challengeReps = "1 foreshortened leap construction",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Muzzle pasted on the side like a flat nose instead of wrapping symmetrically around the skull centerline" to "Draw a front-face vertical centerline down the skull sphere and mount the muzzle box squarely across it.",
                            "Front and back legs floating at uneven ground heights" to "Draw a faint perspective floor plane connecting all four paw footprints."
                        ),
                        checklist = listOf(
                            "Ribcages and heads carry centerlines and 3D cross-contours.",
                            "Muzzles attach symmetrically to cranial spheres as solid boxes.",
                            "All planted paws/claws sit firmly on a shared ground plane."
                        ),
                        criteria = "Complete 11 solid 3D bird, quadruped, and muzzle constructions.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_animal_struct",
                        reinforcedSkillIds = listOf("sk_spheres_cyl", "sk_cross_contour")
                    ),
                    LessonSpec(
                        id = "w8_u3_l3",
                        title = "Wings, Paws, Hooves & Comparative Proportions",
                        subtitle = "Mastering tricky animal extremities",
                        objective = "Break complex wings, padded paws, and hooves down into simple layered wedges and overlapping fan groups.",
                        explanation = "A bird wing isn't a jagged zig-zag—it mirrors a human arm (upper arm, forearm, hand) carrying three clean overlapping feather tiers (coverts, secondaries, primaries). Dog paws are boxy knuckle pads resting cleanly on the ground.",
                        whyItMatters = "Clean extremities instantly elevate animal sketches from amateur guesswork to believable naturalism.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "For wings: sketch the 3-segment Z-arm skeleton first, then group primary, secondary, and covert feather fans as clean smooth overlapping shapes.",
                            "For paws/hooves: draw a tapered cylinder ankle sloping into a wedged toe-box sitting squarely flat on the ground."
                        ),
                        ex1Title = "Spread & Folded Wing Diagrams",
                        ex1Desc = "Draw 2 spread bird wings (showing the arm bones inside + 3 layered feather zones) and 2 folded wings resting neatly along the torso.",
                        ex1Reps = "4 wing construction studies",
                        ex1Min = 12,
                        ex2Title = "Canine/Feline Paws & Hooves",
                        ex2Desc = "Construct 4 standing dog/cat paws (top, side, 3/4, underside toe beans) and 2 angled horse hooves using clean wedge blocks.",
                        ex2Reps = "6 paw & hoof studies",
                        ex2Min = 10,
                        ex3Title = "Breed Proportion Shifts",
                        ex3Desc = "Compare side silhouettes of a short-legged Corgi/Dachshund vs. long-legged Greyhound using head-unit ratios.",
                        ex3Reps = "2 comparative breed ratios",
                        ex3Min = 7,
                        challengeTitle = "Soaring Hawk Foreshortened Wing",
                        challengeDesc = "Construct a hawk banking in mid-flight with one wing reaching forward toward the viewer and fanned tail feathers behind.",
                        challengeReps = "1 banking raptor flight study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing 30 separate individual feathers all pointing awkwardly" to "Group feathers into clean sweeping curved edge ribbons and draw separations only at tips.",
                            "Paws looking like limp mittens with flat straight toes" to "Give each toe an arched knuckle step dropping down to the claw pad."
                        ),
                        checklist = listOf(
                            "Wings follow logical arm-bone folding and overlapping feather zones.",
                            "Paws rest solidly flat on the ground with clear toe-arch steps.",
                            "Animal species proportions stay distinct and measurable."
                        ),
                        criteria = "Complete 12 wing, paw, hoof, and comparative proportion studies.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_animal_struct"
                    )
                )
            ),
            buildUnit(
                8, 4, "w8_u4", "Fur, Feathers & Naturalist Synthesis",
                "Layer directional fur/feather textures over lit 3D animal anatomy and unite wildlife with natural habitats.",
                listOf(
                    LessonSpec(
                        id = "w8_u4_l1",
                        title = "Directional Fur Flow & Clump Shading",
                        subtitle = "Following underlying muscle and bone",
                        objective = "Render animal fur cleanly by shading big anatomical volumes first and placing short tapered fur tufts along directional growth seams.",
                        explanation = "Fur grows like water flowing around boulders: radiating outward from the nose bridge, sweeping back over cheekbones, ruffling around the collar, and parting cleanly over shoulders. Never draw hair-by-hair across bright lit zones!",
                        whyItMatters = "Makes animal portraits look lush, dimensional, and alive rather than spiky wire brushes.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Pet/animal photo reference"),
                        steps = listOf(
                            "Construct the animal's head/body cleanly in 2H and shade big 5-zone lighting across skull, snout, and neck.",
                            "Sketch faint flow arrows mapping fur direction (short velvety strokes on nose/muzzle, longer ruff tufts on cheeks and neck).",
                            "Carve crisp dark hair-clump breaks along the shadow terminator and soft silhouette breaks along cheek/ear edges."
                        ),
                        ex1Title = "Directional Fur Flow Map",
                        ex1Desc = "Sketch a dog or fox head lightly and map fur flow arrows + major light/shadow clumps across bridge of nose, brow, cheek ruff, and neck.",
                        ex1Reps = "1 annotated fur-flow study",
                        ex1Min = 10,
                        ex2Title = "Rendered Cat or Dog Portrait Study",
                        ex2Desc = "Build a 15-minute shaded animal head study preserving clean glossy eye catchlights, damp nose texture, and tapered cheek fur tufts.",
                        ex2Reps = "1 rendered animal head study",
                        ex2Min = 15,
                        ex3Title = "Feather Overlap Shading",
                        ex3Desc = "Shade a single layered wing patch showing how top covert feathers cast crisp thin shadows onto the secondary feathers below.",
                        ex3Reps = "1 layered feather-shadow swatch",
                        ex3Min = 7,
                        challengeTitle = "Owl or Lion Mane Portrait",
                        challengeDesc = "Render an owl facial disc or lion mane combining short tight facial fur/down with radiating layered collar textures.",
                        challengeReps = "1 dramatic wildlife texture portrait",
                        challengeMin = 18,
                        mistakes = listOf(
                            "Drawing long coarse fur hairs on the bridge of an animal's nose" to "Notice how muzzle/nose fur is ultra-short (almost smooth velvet!), lengthening gradually toward cheeks and neck.",
                            "Skipping eye eyeball roundness—making flat black almond stickers" to "Keep animal eyes glossy spheres tucked slightly under brow lids with crisp catchlights."
                        ),
                        checklist = listOf(
                            "Fur stroke lengths shift naturally from short muzzle to longer cheek/neck tufts.",
                            "Big 3D skull lighting stays intact underneath fur texture.",
                            "Eyes sit recessed beneath brow structure with clean glossy shine."
                        ),
                        criteria = "Complete fur-flow mapping, feather shadows, and a rendered animal head study.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_animal_coat",
                        reinforcedSkillIds = listOf("sk_tex_organic", "sk_animal_struct")
                    ),
                    LessonSpec(
                        id = "w8_u4_l2",
                        title = "Scales, Shells & Armored Creatures",
                        subtitle = "Mapping geometric patterns cleanly across curved anatomy",
                        objective = "Wrap overlapping scales, turtle scutes, or beetle shells across 3D curved animal volumes using perspective grid wrapping.",
                        explanation = "Drawing scales flat on a curved lizard or fish body ruins the 3D roundness instantly. Lay a curving cross-contour diamond net over the cylindrical body FIRST, then draw individual overlapping scale plates conforming to those perspective cells—darkening under-overlaps cleanly.",
                        whyItMatters = "Teaches precision pattern-wrapping useful for reptiles, armor, pinecones, and rooftops.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Sketchbook"),
                        steps = listOf(
                            "Construct a curving S-cylinder (fish/snake torso) or domed oval (turtle shell) and light it smoothly first.",
                            "Wrap diagonal cross-contour grid bands cleanly around the body—narrower near edges due to foreshortening!",
                            "Shape overlapping scales/plates inside the cells, shading tight under-rim shadows and selective highlight glints near the crest."
                        ),
                        ex1Title = "Wrapped Fish / Reptile Torso Band",
                        ex1Desc = "Draw a curved 3D fish or snake midsection, wrap diagonal diamond bands smoothly around its circumference, and render 30+ scales curving into the silhouette.",
                        ex1Reps = "2 curved scale-wrapped torsos",
                        ex1Min = 14,
                        ex2Title = "Turtle Carapace Scute Dome",
                        ex2Desc = "Construct a domed turtle shell with radial scute plates compressing tightly near the curved side rim, complete with growth-ring texture.",
                        ex2Reps = "1 domed turtle shell plate",
                        ex2Min = 12,
                        ex3Title = "Scale Detail Fade Test",
                        ex3Desc = "On one curved scaly tail, draw crisp individual scale edges ONLY around the focal crest/terminator, fading subtly into quiet simple shading on lit and far shadow zones.",
                        ex3Reps = "1 selective-scale tail study",
                        ex3Min = 7,
                        challengeTitle = "Perched Iguana or Pangolin Plate",
                        challengeDesc = "Draw an armored lizard resting on a branch, contrasting smooth rocky bark against rhythmic overlapping scales.",
                        challengeReps = "1 reptile-on-branch natural study",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Drawing identical flat circles all the way to the outer edge" to "Foreshorten scales sharply into narrow slivers as they wrap around the cylinder sides.",
                            "Outlining every single scale identically black" to "Vary edge contrast—keep scales near highlights subtle and crisp."
                        ),
                        checklist = listOf(
                            "Scales compress narrower cleanly as they wrap toward silhouettes.",
                            "Overlapping plates follow the underlying cross-contour net.",
                            "Lighting unites the entire cylinder rather than breaking into flat polka dots."
                        ),
                        criteria = "Complete 4 curved scale and carapace wrapping studies.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_animal_coat",
                        reinforcedSkillIds = listOf("sk_cross_contour")
                    ),
                    LessonSpec(
                        id = "w8_u4_l3",
                        title = "Field Sketchbook Spread: Flora & Fauna",
                        subtitle = "Composing observational nature pages",
                        objective = "Compose an editorial-style naturalist sketchbook spread combining a full wildlife/botanical subject with zoomed detail callouts.",
                        explanation = "Naturalist field journals (like Audubon or modern scientific illustrators) combine a central 3D constructed animal or plant with clean negative-space margin studies of a leaf cross-section, foot/wing detail, or habitat branch—creating rich, informative sketchbook spreads.",
                        whyItMatters = "Trains independent observational synthesis before tackling World 8's Milestone and World 9's Human Figure.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Clean A4/double sketchbook spread"),
                        steps = listOf(
                            "Choose a unified nature pairing (e.g., songbird on flowering branch, or squirrel beside oak leaves & acorns).",
                            "Plan a balanced page layout leaving space for 1 main study + 2 small detail callouts.",
                            "Construct main forms solidly, harmonize lighting across main and branch elements, and finish textures selectively."
                        ),
                        ex1Title = "Field Page Layout Thumbnail",
                        ex1Desc = "Sketch 2 miniature double-element nature page thumbnails planning main subject placement, supporting branch lead-in, and detail inset positions.",
                        ex1Reps = "2 naturalist layout thumbnails",
                        ex1Min = 6,
                        ex2Title = "Main Bird/Animal + Botanical Branch Construction",
                        ex2Desc = "Draw the full transparent construction of your main wildlife subject perched/resting naturally among stems and leaves.",
                        ex2Reps = "1 combined flora-fauna construction",
                        ex2Min = 12,
                        ex3Title = "Tonal Pass & Margin Detail Insets",
                        ex3Desc = "Shade the hero creature and supporting leaves cleanly, plus add 1 zoomed detail vignette (e.g., perched claw or seed pod).",
                        ex3Reps = "1 finished field study page",
                        ex3Min = 14,
                        challengeTitle = "Inked & Graphite Hybrid Field Plate",
                        challengeDesc = "Outline main crisp biological structures lightly in 0.3mm fineliner while modeling lush soft form values with 2B graphite.",
                        challengeReps = "1 ink-and-graphite field plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Cramming main animal and insets tightly together without breathing margins" to "Leave clean white archival paper gutters around margin callouts.",
                            "Inconsistent lighting between animal and branch" to "Make sure the branch casts shadows consistent with the creature's lit side."
                        ),
                        checklist = listOf(
                            "Animal/plant structures sit convincingly connected in shared 3D space.",
                            "Page layout balances focal subject, negative space, and detail notes.",
                            "Textures stay crisp at focal points and calm in background leaves."
                        ),
                        criteria = "Complete the field sketchbook spread prep to unlock World 8's Milestone Project.",
                        diagramType = DiagramType.BOTANICAL_AND_ANIMAL,
                        primarySkillId = "sk_animal_coat",
                        reinforcedSkillIds = listOf("sk_botanical", "sk_trees_terrain", "sk_animal_struct")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w8",
            worldNumber = 8,
            title = "Observational Botanical & Wildlife Naturalist Spread",
            brief = "Create a cohesive naturalist sketchbook plate featuring a 3D constructed animal (bird, cat, dog, or reptile) integrated with live botanical branches/flowers or rocky terrain, plus 2 supporting observational callout studies, fully shaded with directional fur/feathers and atmospheric contrast.",
            combinedSkills = listOf("Plants & Flowers", "Trees & Terrain", "Animal Construction", "Fur & Feather Rendering"),
            requiredMaterials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "Clean A4/double sketchpad spread"),
            phases = listOf(
                "Phase 1 (5 min): Thumbnail page composition pairing Hero creature, botanical branch/rock perch, and 2 detail margins.",
                "Phase 2 (10 min): Construct animal ribcage/pelvis/muzzle and twisting plant stems/leaves transparently in 2H.",
                "Phase 3 (10 min): Establish unified directional lighting and shadow masses across creature and habitat.",
                "Phase 4 (15 min): Render directional fur/feathers, crisp eye/beak focus, selective leaf veins, and clean margin detail studies."
            ),
            selfAssessmentChecklist = listOf(
                "Creature sits solidly perched/grounded on its botanical or rocky support.",
                "Fur/feathers follow underlying anatomical contours without flattening form.",
                "Leaves and branches twist naturally in 3D space.",
                "Focal contrast draws attention straight to the creature's head/eye."
            ),
            estimatedMinutes = 40,
            xpReward = 230
        )
    ),

    // WORLD 9: HUMAN FIGURE
    DrawingWorld(
        number = 9,
        id = "world_9",
        title = "Human Figure",
        tagline = "Master gesture, 8-head proportions, 3D mannequinization, anatomy, hands, and feet",
        focusSummary = "Build dynamic, weight-bearing human figures from energetic gesture lines through Loomis proportions, Robo-Bean torsos, major muscle masses, and hands/feet.",
        unlockRequirementSummary = "Complete World 8 Milestone & reach Practicing in Nature skills",
        units = listOf(
            buildUnit(
                9, 1, "w9_u1", "Gesture, Rhythm & Weight Balance",
                "Capture movement, asymmetric curve-vs-straight tension, and gravitational balance in 30-second to 3-minute poses.",
                listOf(
                    LessonSpec(
                        id = "w9_u1_l1",
                        title = "Line of Action & CSI Rhythms",
                        subtitle = "Finding energy in 60 seconds",
                        objective = "Capture the full flow and dynamic intent of human poses using C-curves, S-curves, and straight I-thrusts in 30–90 seconds.",
                        explanation = "Gesture is NOT a sloppy outline—it is the invisible current of energy running through the body! Using rhythmic C, S, and I lines (avoiding rigid parallel stick-figure symmetry!) lets a simple 10-line sketch look dramatically alive.",
                        whyItMatters = "Without gesture, even anatomically accurate figures look like stiff plastic store mannequins.",
                        materials = listOf("2B or charcoal pencil (held loosely for big arm sweeps)", "Large A4/A3 pad or newsprint", "Timer"),
                        steps = listOf(
                            "Look at a pose for 5 full seconds before touching pencil to paper—ask: 'What is the torso doing? Where is the weight?'",
                            "Draw ONE sweeping Line of Action from head through spine down into the weight-bearing leg.",
                            "Contrast a curved 'stretch' side against a compressed 'pinch' side on the torso—never draw symmetrical parallel torso walls!"
                        ),
                        ex1Title = "12 One-Minute Action Gestures",
                        ex1Desc = "Set a 1-minute timer × 12 poses (use sports, dance, or mirror poses). Limit yourself to 10–15 sweeping C/S/I strokes per pose—zero fingers or faces!",
                        ex1Reps = "12 sixty-second dynamic gestures",
                        ex1Min = 12,
                        ex2Title = "Pinch vs. Stretch Torso Contrast",
                        ex2Desc = "Draw 6 leaning/twisting standing poses strictly focusing on pairing a taut convex stretch curve opposite a folded concave pinch.",
                        ex2Reps = "6 asymmetrical torso rhythms",
                        ex2Min = 9,
                        ex3Title = "2-Minute Full-Body Rhythm Flows",
                        ex3Desc = "Slow down slightly to 2 minutes per pose (4 poses), adding shoulder/hip tilt crossbars and graceful limb taper lines.",
                        ex3Reps = "4 two-minute figure flows",
                        ex3Min = 8,
                        challengeTitle = "30-Second Espresso Gesture Sprint",
                        challengeDesc = "Draw 10 rapid 30-second poses across a single big sheet—pure spine thrust, tilt angles, and limb direction!",
                        challengeReps = "10 thirty-second sprints",
                        challengeMin = 5,
                        mistakes = listOf(
                            "Copying the outer bumpy clothing silhouette slowly" to "Draw INSIDE the body's energy flow first; ignore wrinkled shirt edges.",
                            "Making both sides of the waist curve symmetrically like a snowman" to "Push one side out in a broad stretch and pinch the opposite side cleanly."
                        ),
                        checklist = listOf(
                            "Every pose communicates clear movement or posture within 3 seconds of viewing.",
                            "Torso walls show clear asymmetrical pinch-vs-stretch contrast.",
                            "Strokes sweep boldly from the shoulder rather than sketchy finger ticks."
                        ),
                        criteria = "Complete 22 rapid figure gestures demonstrating asymmetrical rhythm.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_gesture"
                    ),
                    LessonSpec(
                        id = "w9_u1_l2",
                        title = "Contrapposto, Tilts & Center of Gravity",
                        subtitle = "Making standing figures feel physically balanced",
                        objective = "Plot opposing shoulder/pelvis tilts (contrapposto) and plumb weight lines from the pit of the neck to the supporting foot.",
                        explanation = "When a person shifts weight onto one leg, that hip pushes UP while the opposite hip drops DOWN. To avoid falling over, the spine curves and the shoulders tilt the **opposite direction**! Plus, a vertical plumb line dropped from the pit of the neck (clavicle notch) MUST land right over the weight-bearing foot (or midway between two evenly loaded feet).",
                        whyItMatters = "Fixes leaning, tipping-over characters instantly and gives relaxed poses timeless classical grace.",
                        materials = listOf("2H & 2B pencils", "Mirror (check your own stance!) or pose reference", "Sketchbook"),
                        steps = listOf(
                            "Mark the pit of the neck (suprasternal notch) and drop a faint plumb line straight down to the ground.",
                            "Draw the tilted Pelvis crossbar rising high over the weight-bearing hip.",
                            "Tilt the Shoulder crossbar inversely downward on that same side, curving the spine smoothly between them."
                        ),
                        ex1Title = "Contrapposto Balance Diagrams",
                        ex1Desc = "Draw 6 standing contrapposto poses (varying weight left vs. right), drawing crisp tilted shoulder/pelvis rails and vertical neck-pit plumb lines.",
                        ex1Reps = "6 contrapposto balance studies",
                        ex1Min = 12,
                        ex2Title = "Walking & Lunging Center-of-Mass",
                        ex2Desc = "Sketch 4 mid-stride walking/leaning poses showing how the neck-pit plumb shifts cleanly ahead of the back foot toward the front landing foot.",
                        ex2Reps = "4 dynamic weight-shift poses",
                        ex2Min = 10,
                        ex3Title = "Seated Weight Compression",
                        ex3Desc = "Draw 3 seated figures resting elbows on knees or leaning on one hand—verify weight transfers cleanly down through hips/arms into the chair.",
                        ex3Reps = "3 seated gravity studies",
                        ex3Min = 9,
                        challengeTitle = "Self-Timer Mirror Stance Trio",
                        challengeDesc = "Stand before a full mirror shifting weight onto your left leg, twisting torso, and reaching overhead; sketch all 3 live contrapposto balances.",
                        challengeReps = "3 live mirror stances",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Tilting shoulders and hips parallel in the same direction (makes figure look tilted like a falling statue)" to "Cross-tilt shoulders and hips toward each other on the compressed side!",
                            "Weight-bearing foot placed way off to the side of the neck-pit plumb line" to "Slide the supporting ankle directly underneath the torso's center of gravity."
                        ),
                        checklist = listOf(
                            "Shoulders and pelvis tilt inversely in relaxed weight-bearing poses.",
                            "Plumb line from the pit of the neck lands cleanly over the support foot/base.",
                            "Seated figures visibly compress weight into chair contact planes."
                        ),
                        criteria = "Complete 13 contrapposto, stride, and seated balance studies.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_gesture",
                        reinforcedSkillIds = listOf("sk_sight_prop")
                    ),
                    LessonSpec(
                        id = "w9_u1_l3",
                        title = "Bean & Twist Torso Simplification",
                        subtitle = "Turning flat gestures into bending 3D torso forms",
                        objective = "Combine ribcage and pelvis masses into a single flexible 'Bean' showing forward/back bend and axial torso twist.",
                        explanation = "The Bean simplifies the upper ribcage and lower pelvis into two connected elastic pillow spheres that bend, squash, and twist against each other—creating unmistakable 3D overlap lines right around the belly button and ribs!",
                        whyItMatters = "Bridges 2D fluid gesture lines smoothly into 3D cylindrical mannequin anatomy.",
                        materials = listOf("2H & 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "Draw two overlapping egg/circle shapes for the ribcage and pelvis following your gesture curve.",
                            "Draw a continuous front centerline curving across BOTH ovals to show twist direction.",
                            "Add an overlapping crease fold where the ribcage tucks over the pinched belly side."
                        ),
                        ex1Title = "Twisting Bean Matrix",
                        ex1Desc = "Draw 8 varied twisting/bending Beans with crisp front centerlines, pectoral shoulder lines, and belly overlap wraps.",
                        ex1Reps = "8 twisting 3D beans",
                        ex1Min = 12,
                        ex2Title = "Bean-to-Gesture Pose Overlay",
                        ex2Desc = "Sketch 5 dynamic poses (twisting throw, curled stretch, arched backbend) building the 3D Bean torso first, then sweeping limbs out.",
                        ex2Reps = "5 dynamic bean figures",
                        ex2Min = 12,
                        ex3Title = "Front vs. Back Bean Readability",
                        ex3Desc = "Draw 3 pairs of twisted Beans viewed from front 3/4 vs. rear 3/4—use spinal furrow line on back views vs. sternum/navel centerline on front views.",
                        ex3Reps = "3 front-back bean pairs",
                        ex3Min = 8,
                        challengeTitle = "Acrobatic Mid-Air Twist",
                        challengeDesc = "Construct an arched diver or gymnast twisting 90° between shoulders and hips, wrapping clean cross-contours around the stretched torso.",
                        challengeReps = "2 extreme-twist torso studies",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing two disconnected snowmen balls with no squash-and-stretch" to "Press and overlap the ribcage and pelvis spheres smoothly together.",
                            "Flat vertical centerline that ignores 3D twist" to "Curve the centerline out toward the side turning away, wrapping around the torso's round barrel."
                        ),
                        checklist = listOf(
                            "Ribcage and pelvis spheres visibly bend, overlap, and pinch.",
                            "Curved centerlines clearly show which way chest and hips face.",
                            "Front and back torsos read unambiguously."
                        ),
                        criteria = "Complete 16 dynamic Bean and torso-twist constructions.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_gesture",
                        reinforcedSkillIds = listOf("sk_cross_contour")
                    )
                )
            ),
            buildUnit(
                9, 2, "w9_u2", "Figure Proportions & 3D Mannequin",
                "Master the 8-head proportional canon, Robo-Bean box volumes, and foreshortened cylindrical limbs.",
                listOf(
                    LessonSpec(
                        id = "w9_u2_l1",
                        title = "The 8-Head Figure Proportion Canon",
                        subtitle = "Key anatomical landmarks from crown to heel",
                        objective = "Divide standing adult figures accurately across the classical 8-head grid and align major joint landmarks cleanly.",
                        explanation = "An idealized 8-head canon acts like an internal ruler (real humans vary 7–8 heads, which you'll adjust deliberately once you know the baseline!). Key landmarks: Head 1 = Chin; Head 2 = Nipple/Sternum mid; Head 3 = Belly button/Elbows; Head 4 = Pubic bone/Hips/Wrists; Head 6 = Bottom of Kneecap; Head 8 = Soles of feet.",
                        whyItMatters = "Stops accidental tiny legs, overly long torsos, or gorilla arms before you invest in muscle details.",
                        materials = listOf("2H & HB pencils", "Ruler ONLY for initial 8-tick vertical grid", "Sketchbook"),
                        steps = listOf(
                            "Draw a vertical plumb line and divide it into 8 equal segments (easy trick: halve it -> Head 4 hips! Halve top -> Head 2 chest! Halve bottom -> Head 6 knees!).",
                            "Map Head oval (1), shoulder width (~2–2.3 heads wide), ribcage ending around 3, pelvis ending around 4.2.",
                            "Check arm lengths: elbows align right at the waist/navel (Head 3), wrists align at hip joints (Head 4), fingertips hit mid-thigh (Head 4.75)!"
                        ),
                        ex1Title = "Annotated Front & Side 8-Head Chart",
                        ex1Desc = "Construct 1 front-view and 1 side-profile idealized mannequin figure cleanly aligned along shared horizontal 1–8 head lines.",
                        ex1Reps = "1 dual front/side canon chart",
                        ex1Min = 15,
                        ex2Title = "Back-View Landmark Alignment",
                        ex2Desc = "Draw a rear 8-head view marking shoulder blades (Head 2), waist dimples/sacrum (Head 4), glute fold (Head 4.5), and knee hollows (Head 6).",
                        ex2Reps = "1 rear-view landmark figure",
                        ex2Min = 10,
                        ex3Title = "Quick Freehand Halving Proportion Drill",
                        ex3Desc = "Put the ruler away and sketch 4 fast standing silhouettes using the half-then-quarter visual division method without measuring.",
                        ex3Reps = "4 freehand proportional figures",
                        ex3Min = 8,
                        challengeTitle = "Age & Build Ratio Comparison",
                        challengeDesc = "Side by side on one sheet, draw a 7.5-head stocky build, an 8-head athletic build, and a 6-head child proportion showing how torso/limb ratios shift.",
                        challengeReps = "3 contrasting proportion builds",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Making forearms too short so hands stop at the hip bone" to "Check fingertips: relaxed arms hang all the way down to MID-THIGH!",
                            "Drawing shoulders narrow like head width" to "Give adult male shoulders ~2.3 head-widths and adult female ~1.8–2 head-widths."
                        ),
                        checklist = listOf(
                            "Hip/crotch midpoint lands squarely at the halfway mark (Head 4).",
                            "Elbows align near waist/navel and fingertips reach mid-thigh.",
                            "Knees align cleanly near Head 6."
                        ),
                        criteria = "Complete front, side, rear 8-head charts and 4 freehand proportion drills.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_fig_prop"
                    ),
                    LessonSpec(
                        id = "w9_u2_l2",
                        title = "The Robo-Bean: Boxed Ribcage & Pelvis",
                        subtitle = "Seeing planar side walls and front/back orientation",
                        objective = "Upgrade soft Bean ovals into solid 3D perspective boxes/wedges (the Robo-Bean) showing clear top, front, and side planes.",
                        explanation = "A soft oval hides perspective orientation. Turning the ribcage and pelvis into **modified boxes/wedges** (Loomis/Proko 'Robo-Bean') instantly exposes which way the chest faces, whether we look up under the ribs or down onto the shoulders, and how the hips twist in perspective!",
                        whyItMatters = "Makes lighting, foreshortening, and clothing seams fall naturally onto solid human torso planes.",
                        materials = listOf("2H & HB pencils", "Sketchbook"),
                        steps = listOf(
                            "Draw a dynamic torso gesture curve.",
                            "Build a slightly tapered rectangular ribcage box tilted along the upper spine, carving the rounded pectoral front arch and collarbone notch.",
                            "Build a shorter wedge-like pelvis box below, twisted and tilted inversely to the ribcage—showing its top or bottom plane cleanly!"
                        ),
                        ex1Title = "6 Rotating Robo-Bean Torsos",
                        ex1Desc = "Construct 6 rotated ribcage+pelvis box pairs (front 3/4 high, front 3/4 low, rear 3/4 twisted, side hunch) transparently showing all box planes.",
                        ex1Reps = "6 perspective torso box pairs",
                        ex1Min = 14,
                        ex2Title = "Torso Planes + Basic Lighting",
                        ex2Desc = "Shade 3 of your Robo-Beans simply under top-left lighting, clearly separating bright top/front chest planes from darker side ribs.",
                        ex2Reps = "3 lit planar torso studies",
                        ex2Min = 9,
                        ex3Title = "Neck Cylinder Socket Integration",
                        ex3Desc = "Plant a tilted cylindrical neck rising forward out of the top ribcage collar plane (remember: necks angle forward, never straight vertical!).",
                        ex3Reps = "4 neck-socket attachments",
                        ex3Min = 7,
                        challengeTitle = "Dynamic Heroic Action Mannequin",
                        challengeDesc = "Construct an entire twisted superhero/athlete torso + head sphere + upper thigh stumps in dramatic worm's-eye 3-point perspective.",
                        challengeReps = "1 extreme-angle mannequin torso",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing the ribcage as a rigid flat cardboard rectangle with no top/bottom depth" to "Draw transparently through the top shoulder plane and bottom rib arch.",
                            "Sticking the neck straight vertically out of the middle like a lollipop" to "Angle the neck cylinder slightly forward from the back of the spine toward the chin."
                        ),
                        checklist = listOf(
                            "Front, side, and top/bottom planes of chest and pelvis are unmistakable.",
                            "Ribcage and pelvis twist independently along the spine.",
                            "Neck angles naturally forward from the sloped shoulder plane."
                        ),
                        criteria = "Complete 13 Robo-Bean torso, lighting, and neck-socket constructions.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_fig_prop",
                        reinforcedSkillIds = listOf("sk_cubes")
                    ),
                    LessonSpec(
                        id = "w9_u2_l3",
                        title = "Cylindrical Limbs & Foreshortened Mannequins",
                        subtitle = "Aiming arms and legs straight toward the camera",
                        objective = "Construct full 3D mannequin figures using tapered cylinders with directional cross-contour bands for foreshortened poses.",
                        explanation = "When an arm reaches straight toward you, beginners shrink it weirdly into a tiny T-Rex arm! Using **overlapping tapered cylinders with crisp elliptical cuffs** (just like World 2!) lets an arm or thigh punch straight out toward the viewer convincingly.",
                        whyItMatters = "Unlocks dynamic poses, foreshortened punching/pointing limbs, and seated crossed legs.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "Establish gesture flow and Robo-Bean torso + head egg.",
                            "Treat upper arms, forearms, thighs, and calves as gently tapering cylinders anchored into shoulder/hip ball sockets.",
                            "On foreshortened limbs reaching toward you, wrap 3–4 visible elliptical cross-contour bands overlapping front-over-back cleanly."
                        ),
                        ex1Title = "Foreshortened Limb Cylinder Drills",
                        ex1Desc = "Draw 6 pointing/reaching arms and 4 seated/kneeling foreshortened legs purely as transparent tapered cylinders with clear front-over-back ring overlaps.",
                        ex1Reps = "10 foreshortened limb cylinders",
                        ex1Min = 13,
                        ex2Title = "Full 3D Mannequin Poses",
                        ex2Desc = "Build 4 complete full-body mannequins (running, sitting cross-legged, reaching overhead, crouching) using Robo-Beans + cylindrical limbs + wedge feet.",
                        ex2Reps = "4 full-body 3D mannequins",
                        ex2Min = 16,
                        ex3Title = "Joint Socket Overlap Audit",
                        ex3Desc = "Check elbows and knees on your mannequins—ensure the forearm cylinder tucks slightly cleanly into the upper-arm/elbow pinch.",
                        ex3Reps = "4 joint-overlap checks",
                        ex3Min = 4,
                        challengeTitle = "Dramatic Lounging Foreshortened Figure",
                        challengeDesc = "Draw a mannequin reclining on a couch/floor with feet closest to the viewer (large!) receding cleanly back toward a smaller torso and head.",
                        challengeReps = "1 steep reclining foreshortened figure",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Drawing limbs as flat tapered noodles with straight end cuts" to "Wrap every limb segment in full curved ellipses showing whether the tube points toward or away from you.",
                            "Forgetting the subtle outer curve vs. inner straight rhythm of arms/legs" to "Taper cylinders slightly toward ankles and wrists."
                        ),
                        checklist = listOf(
                            "Foreshortened limbs use overlapping elliptical cross-contours clearly.",
                            "Limb cylinders attach cleanly into shoulder and hip sockets.",
                            "Near limbs read larger and overlap far limbs convincingly."
                        ),
                        criteria = "Complete 10 foreshortened limb drills and 4 full-body 3D mannequin constructions.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_fig_prop",
                        reinforcedSkillIds = listOf("sk_spheres_cyl", "sk_gesture")
                    )
                )
            ),
            buildUnit(
                9, 3, "w9_u3", "Essential Form Anatomy",
                "Learn the major functional muscle masses—pectorals, deltoids, obliques, quads, and calves—as simple interlocking 3D shapes.",
                listOf(
                    LessonSpec(
                        id = "w9_u3_l1",
                        title = "Torso Landmarks: Clavicle, Pectorals & Abs",
                        subtitle = "Anchoring muscles cleanly to bony landmarks",
                        objective = "Map visible bony landmarks (collarbones, ribcage arch, iliac crest) and attach interlocking pectoral, deltoid, and abdominal masses.",
                        explanation = "Muscles NEVER float randomly on flesh—they pull directly from bone to bone! Learning just 4 bony landmarks (clavicle, sternum, rib arch, iliac hip corner) locks the entire chest, shoulder cap, and abs cleanly onto your Robo-Bean.",
                        whyItMatters = "Makes torsos look genuinely athletic and structured without memorizing 200 Latin muscle names.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "Construct a 3/4 Robo-Bean torso.",
                            "Draw the bicycle-handlebar Clavicles from pit-of-neck out to shoulder tops, plus the inverted-V thoracic rib arch.",
                            "Attach fan-shaped Pectorals sweeping from sternum across into the upper arm, wrapped cleanly underneath teardrop Deltoid shoulder caps."
                        ),
                        ex1Title = "Bony Landmark & Chest Overlay",
                        ex1Desc = "Draw 3 Robo-Bean torsos (front, 3/4, raised-arm pose) and map clavicle, thoracic arch, pectorals, rectus abdominis, and side oblique pads.",
                        ex1Reps = "3 front-torso anatomy studies",
                        ex1Min = 14,
                        ex2Title = "Raised-Arm Pectoral Stretch",
                        ex2Desc = "Notice what happens when an arm lifts overhead: the pectoral stretches steeply upward into a thin band while the lat wing flares underneath!",
                        ex2Reps = "2 raised-arm shoulder studies",
                        ex2Min = 10,
                        ex3Title = "Back & Scapula Interlock",
                        ex3Desc = "Draw 2 rear-view torsos mapping the central spine furrow, floating triangular scapulae (shoulder blades), trapezius diamond, and lower back dimples.",
                        ex3Reps = "2 rear-torso anatomy studies",
                        ex3Min = 10,
                        challengeTitle = "Twisting Torso With Light & Shadow",
                        challengeDesc = "Shade a single 3/4 torso flexing side obliques and ribcage planes smoothly under side lighting.",
                        challengeReps = "1 shaded anatomical torso study",
                        challengeMin = 14,
                        mistakes = listOf(
                            "Drawing flat 6-pack squares stacked like ice cubes" to "Wrap the abdominal column smoothly around the curved barrel of the rib arch and iliac crest.",
                            "Sticking deltoids on top like round tennis balls" to "Wrap the teardrop deltoid down seamlessly from the collarbone/scapula into the mid-upper arm."
                        ),
                        checklist = listOf(
                            "Bony landmarks (clavicle, sternum, rib arch, hip crest) anchor every muscle.",
                            "Pectorals visibly pull toward the upper arm bone—even when raised.",
                            "Front and back torsos look solid and interconnected."
                        ),
                        criteria = "Complete 7 front, raised-arm, and rear torso anatomy studies.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_anatomy_core"
                    ),
                    LessonSpec(
                        id = "w9_u3_l2",
                        title = "Arm Chain Interlock: Deltoid to Forearm",
                        subtitle = "The 'chain-link' secret of believable arms",
                        objective = "Draw natural upper arms and forearms using interlocking alternating teardrop forms (biceps/triceps wedging into forearm extensors).",
                        explanation = "Arms don't look like two smooth sausages stacked end-to-end—they lock together like **links of a chain**! Looking at the shoulder-to-elbow: the deltoid points down *between* biceps and triceps; at the elbow, the forearm brachioradialis wedges *up* between them!",
                        whyItMatters = "Gives arms instant three-dimensional tension and natural taper down to the flat wrist.",
                        materials = listOf("2H, HB, 2B pencils", "Your own bent arm in mirror", "Sketchbook"),
                        steps = listOf(
                            "Draw two lightly tapered arm cylinders bent at 90°.",
                            "Drop the deltoid teardrop halfway down the outer upper arm, hugging the bicep front bulge and flat horseshoe tricep back.",
                            "Wedge the meaty upper forearm ridge up onto the outside of the bicep crease, tapering down into a flat rectangular wrist box!"
                        ),
                        ex1Title = "Chain-Link Arm Schematic",
                        ex1Desc = "Draw 4 arms at varied angles (extended, 90° flexed, pronated palm-down, supinated palm-up) showing clean chain-link overlaps.",
                        ex1Reps = "4 interlocking arm studies",
                        ex1Min = 14,
                        ex2Title = "Pronation Twist Observation",
                        ex2Desc = "Hold your own arm forward, twist palm up vs. palm down, and sketch both—observe how forearm muscle ridge wraps diagonally across!",
                        ex2Reps = "2 live mirror forearm twist studies",
                        ex2Min = 10,
                        ex3Title = "Elbow Bony Trio Anchor",
                        ex3Desc = "Draw 3 bent elbows highlighting the crisp hard bony elbow tip (olecranon) contrasting against soft bulging forearm muscles.",
                        ex3Reps = "3 bent-elbow structure studies",
                        ex3Min = 7,
                        challengeTitle = "Arm Crossing Chest Foreshortened",
                        challengeDesc = "Draw a figure's arm reaching across the chest toward the viewer, capturing foreshortened deltoid, bicep, and forearm chain overlaps cleanly.",
                        challengeReps = "1 foreshortened arm anatomy study",
                        challengeMin = 13,
                        mistakes = listOf(
                            "Symmetrical upper-and-lower arm bulges like Popeye bubbles" to "Stagger high-point curves asymmetrically: outer forearm peaks higher than inner forearm!",
                            "Tubular round wrists" to "Flatten wrists into crisp wide rectangular blocks matching the palm base."
                        ),
                        checklist = listOf(
                            "Deltoid, bicep, and forearm wedge together like interlocking chain links.",
                            "Forearm profile tapers asymmetrically down to a flat rectangular wrist.",
                            "Bony elbow landmark remains crisp against soft muscle pads."
                        ),
                        criteria = "Complete 9 arm chain-link, forearm twist, and elbow studies.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_anatomy_core"
                    ),
                    LessonSpec(
                        id = "w9_u3_l3",
                        title = "Leg Rhythms: Thigh, Knee & Asymmetric Calves",
                        subtitle = "Capturing weight, curve, and ankle offset",
                        objective = "Construct strong, graceful legs using S-curve rhythm, boxy patella knees, and staggered asymmetrical calf/ankle steps.",
                        explanation = "Legs carry a distinct front-to-back S-curve: thigh swells forward -> knee tucks cleanly -> calf swells backward -> ankle steps forward! Even on a straight front view, the inner ankle bone sits **HIGHER** than the outer ankle bone, and the outer thigh sweeps higher while the inner calf sits lower!",
                        whyItMatters = "Eliminates stiff table-leg limbs and gives standing or striding figures sweeping classical elegance.",
                        materials = listOf("2H, HB, 2B pencils", "Sketchbook"),
                        steps = listOf(
                            "Build two tapered cylinder segments angled subtly inward from wide hips toward knees.",
                            "Place a crisp little triangular/boxy kneecap block slightly above the shin top.",
                            "Draw the outer calf high and sweeping, inner calf slightly lower, and step the ankle bones diagonally (high inner ankle, low outer ankle!)."
                        ),
                        ex1Title = "Front, Side & Back Leg Rhythm Trio",
                        ex1Desc = "Construct 1 front, 1 side-profile, and 1 back view of a human leg emphasizing the S-curve silhouette and staggered high/low ankle offsets.",
                        ex1Reps = "3 anatomical leg views",
                        ex1Min = 14,
                        ex2Title = "Bent Knee & Squat Compression",
                        ex2Desc = "Draw 3 bent knees (side lunge, kneeling, seated crossing) showing how the patella stays anchored to the shin tendon and hamstring tendons tighten behind.",
                        ex2Reps = "3 bent-knee mechanics studies",
                        ex2Min = 10,
                        ex3Title = "Quick Asymmetrical Lower-Leg Drill",
                        ex3Desc = "Sketch 6 quick calf-to-foot lower legs verifying every ankle shows the diagonal inner-high / outer-low bone slant.",
                        ex3Reps = "6 asymmetrical ankle studies",
                        ex3Min = 7,
                        challengeTitle = "Full Striding Lower Body in Perspective",
                        challengeDesc = "Draw a figure from waist down mid-stride walking diagonally toward the viewer, uniting pelvis tilt, overlapping thigh cylinders, knees, and stepped feet.",
                        challengeReps = "1 striding pelvis-to-feet plate",
                        challengeMin = 15,
                        mistakes = listOf(
                            "Symmetrical twin calf bumps directly opposite each other" to "Offset inner vs. outer muscle curves cleanly so the silhouette flows diagonally.",
                            "Level horizontal ankles" to "Always tilt ankle bones higher on the inside (big-toe side) and lower on the outside."
                        ),
                        checklist = listOf(
                            "Side view clearly displays the thigh-forward / calf-back S-rhythm.",
                            "Ankle bones slant higher inside and lower outside.",
                            "Kneecaps sit cleanly as crisp planar wedges."
                        ),
                        criteria = "Complete 12 leg rhythm, bent knee, and asymmetrical ankle studies.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_anatomy_core"
                    )
                )
            ),
            buildUnit(
                9, 4, "w9_u4", "Hands, Feet & Full-Figure Synthesis",
                "Demystify hands and feet through solid palm boxes, finger arcs, and foot wedges—then unite full figures.",
                listOf(
                    LessonSpec(
                        id = "w9_u4_l1",
                        title = "Hands: Palm Box, Thumb Wedge & Finger Arcs",
                        subtitle = "Stop drawing stiff fork hands",
                        objective = "Construct expressive, solid hands by blocking the trapezoidal palm box, triangular thumb wedge, and stepped cylinder fingers.",
                        explanation = "You ALWAYS have two live drawing models attached to your own wrists! Never start a hand with five fingers—build the **slightly curved trapezoidal palm box** first, attach the **triangular thumb teardrop/wedge** along its outer edge, draw the **curved knuckle fan arcs**, and build fingers as 3 tapering jointed boxes/cylinders!",
                        whyItMatters = "Hands are the #2 storyteller after faces—mastering the palm box instantly removes finger anxiety.",
                        materials = listOf("2H, HB, 2B pencils", "Your own non-drawing hand", "Sketchbook"),
                        steps = listOf(
                            "Pose your free hand naturally relaxed on the desk.",
                            "Construct the flat slightly arched palm trapezoid (narrower at wrist, curved across knuckles—middle finger knuckle sits highest!).",
                            "Attach the meaty thumb pad wedge swinging freely on a ball-like saddle joint.",
                            "Sketch curved light arcs locating middle knuckles and fingertips cleanly before drawing 3-segment tapered finger cylinders."
                        ),
                        ex1Title = "Palm Box + Knuckle Fan Grid",
                        ex1Desc = "Draw 6 poses of your own hand strictly stopping at the palm box + thumb wedge + knuckle-arc mittens (no separated finger details yet!).",
                        ex1Reps = "6 solid hand mitten blocks",
                        ex1Min = 12,
                        ex2Title = "4 Detailed Live Hand Studies",
                        ex2Desc = "Draw your non-drawing hand holding a pencil, resting open palm-up, clenched in a loose fist, and pointing away in foreshortening.",
                        ex2Reps = "4 full live hand studies",
                        ex2Min = 16,
                        ex3Title = "Fingernail & Phalanx Perspective",
                        ex3Desc = "Zoom in on 3 bent fingers showing crisp flat top nail planes, fleshy fingertip pads underneath, and skin-crease folds on the palm side.",
                        ex3Reps = "3 zoomed finger-joint studies",
                        ex3Min = 7,
                        challengeTitle = "Two Interlocked Clasped Hands",
                        challengeDesc = "Fold or interlace both hands (using a mirror or photo reference) and construct how two palm boxes and finger layers interlock cleanly.",
                        challengeReps = "1 clasped-hands plate",
                        challengeMin = 16,
                        mistakes = listOf(
                            "Straight flat horizontal row of identical-length fingers" to "Curve the knuckle ridge cleanly into a fan—middle finger longest, pinky shortest, and notice subtle natural webbing slant!",
                            "Thin flat sausage fingers with no knuckle joints" to "Mark crisp angular joint steps at every bend."
                        ),
                        checklist = listOf(
                            "Every hand began with a clear 3D palm trapezoid and thumb wedge.",
                            "Fingers align along graceful curved knuckle/tip arcs.",
                            "Palm side shows fleshy pads while back side shows crisp tendons and knuckles."
                        ),
                        criteria = "Complete 6 mitten blocks and 7 detailed live hand/finger studies.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_hands_feet"
                    ),
                    LessonSpec(
                        id = "w9_u4_l2",
                        title = "Feet: Wedge, Arch & Toe Platform",
                        subtitle = "Planting the figure solidly onto the ground",
                        objective = "Construct realistic feet from angled wedge ramps, raised inner arches, ankle blocks, and unified toe platforms.",
                        explanation = "A foot is essentially a **sloped doorstop wedge** resting on three contact points: heel bulb, big-toe ball, and outer edge—with a distinct lifted bridge arch on the inside! Grouping toes into one clean angled mitten platform first prevents weird splayed caterpillar toes.",
                        whyItMatters = "Grounds standing figures convincingly into perspective floors and simplifies boots/shoes effortlessly.",
                        materials = listOf("2H, HB, 2B pencils", "Mirror or bare/socked foot model", "Sketchbook"),
                        steps = listOf(
                            "Draw the ankle cylinder dropping into a thick heel sphere/block behind.",
                            "Sweep a sloped triangular wedge bridge forward to the flat ball-of-foot ground footprint.",
                            "Carve the lifted inner arch on the big-toe side, and slope the toe-box wedge diagonally away toward the pinky toe."
                        ),
                        ex1Title = "5-Angle Foot Wedge Studies",
                        ex1Desc = "Construct 5 feet from inner-arch side, outer-flat side, top-down, front foreshortened, and lifted tiptoe views using clean wedges + toe platforms.",
                        ex1Reps = "5 multi-angle foot wedges",
                        ex1Min = 14,
                        ex2Title = "Detailed Bare Foot + Ankle Bones",
                        ex2Desc = "Draw 2 live feet (looking down at your own or in a mirror), shading the high inner arch shadow, Achilles tendon cord, and diagonal ankle bump.",
                        ex2Reps = "2 rendered foot studies",
                        ex2Min = 12,
                        ex3Title = "Foot-to-Shoe Conversion",
                        ex3Desc = "Draw 2 simple wedge foot frames lightly, then wrap a classic sneaker/boot sole thickness and collar cleanly around the exact foot structure.",
                        ex3Reps = "2 shoe-over-foot constructions",
                        ex3Min = 8,
                        challengeTitle = "Dancer Pointe & Jumping Foot",
                        challengeDesc = "Construct a dynamic raised-heel arched foot pressing weight purely onto its bent toe platform.",
                        challengeReps = "2 arched weight-bearing foot studies",
                        challengeMin = 12,
                        mistakes = listOf(
                            "Drawing a flat straight sole on the inner side of the foot" to "Lift the inner midfoot cleanly into a distinct shadowed arch!",
                            "Drawing 5 equally sized square toes straight across" to "Taper the big toe largest and sweep smaller toes stepping cleanly back diagonally."
                        ),
                        checklist = listOf(
                            "Inner foot views reveal a clean lifted arch off the floor.",
                            "Toes group into a clean diagonal tapered step rather than flat rectangles.",
                            "Planted feet sit firmly parallel to the floor perspective plane."
                        ),
                        criteria = "Complete 9 foot-wedge, live foot, and shoe-over-foot studies.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_hands_feet",
                        reinforcedSkillIds = listOf("sk_cubes")
                    ),
                    LessonSpec(
                        id = "w9_u4_l3",
                        title = "Complete Figure Construction & Shading Pass",
                        subtitle = "Gesture → Proportions → Mannequin → Anatomy → Light",
                        objective = "Execute a sustained 25-minute full human figure drawing progressing seamlessly from energetic gesture to lit anatomical volume.",
                        explanation = "Brings every step of World 9 together in classical atelier order: (1) 2-min Gesture & Plumb Balance → (2) 5-min Proportions & Robo-Bean/Cylinders → (3) 8-min Anatomical Interlocks & Hands/Feet → (4) 10-min 2-Value Shadow Mapping & Modeling.",
                        whyItMatters = "Proves you can build dynamic, structurally accurate, solid human figures from scratch.",
                        materials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "A4 sketchpad", "Pose reference or mirror"),
                        steps = listOf(
                            "Choose a compelling contrapposto or seated dynamic pose.",
                            "Spend 2 min locking Line of Action, tilts, and neck-pit balance plumb.",
                            "Construct 8-head proportions, Robo-Bean torso, and cylindrical limbs + palm/foot wedges cleanly in 2H.",
                            "Map anatomical landmarks, unify 2-value shadow shapes, and render core modeling + ground contact shadow."
                        ),
                        ex1Title = "Gesture & Proportions Block-In",
                        ex1Desc = "Run a strict 7-minute construction stage: gesture flow, plumb gravity check, proportional ticks, Robo-Bean, and cylindrical limbs + wedges.",
                        ex1Reps = "1 complete figure construction",
                        ex1Min = 7,
                        ex2Title = "Anatomical Refinement & Hands/Feet",
                        ex2Desc = "Refine pectorals/rib arch/limb chain interlocks and shape clean hand mittens and grounded foot wedges.",
                        ex2Reps = "1 anatomically refined figure",
                        ex2Min = 9,
                        ex3Title = "2-Value Shadow & Core Modeling",
                        ex3Desc = "Group all light vs. shadow planes clearly across torso, limbs, and ground cast shadow, adding crisp core shadows and #9 floor contact darks.",
                        ex3Reps = "1 rendered full-figure study",
                        ex3Min = 12,
                        challengeTitle = "10-Minute Timed Clothed Figure",
                        challengeDesc = "Run a condensed 10-minute full workflow on a clothed standing figure—constructing anatomy underneath first, then draping 3–5 simple gravity folds cleanly over top.",
                        challengeReps = "1 clothed figure synthesis",
                        challengeMin = 10,
                        mistakes = listOf(
                            "Dropping gesture life while carefully measuring boxes" to "Check regularly that the finished pose still retains the initial sweeping Line of Action.",
                            "Shading isolated muscle bumps into lumpy cobblestones" to "Unite the entire shadow side of the figure smoothly as one big lighting shape first."
                        ),
                        checklist = listOf(
                            "Figure balances naturally over its weight-bearing foot/base.",
                            "Proportions, Robo-Bean planes, and muscle interlocks feel unified.",
                            "2-value lighting molds whole 3D volumes rather than fragmented bumps."
                        ),
                        criteria = "Complete the full sustained figure workflow cleanly to unlock World 9's Milestone Project.",
                        diagramType = DiagramType.HUMAN_GESTURE_MANNEQUIN,
                        primarySkillId = "sk_anatomy_core",
                        reinforcedSkillIds = listOf("sk_gesture", "sk_fig_prop", "sk_hands_feet")
                    )
                )
            )
        ),
        milestoneProject = MilestoneProject(
            id = "milestone_w9",
            worldNumber = 9,
            title = "Five-Pose Dynamic Gesture & Mannequin Sheet",
            brief = "Produce a comprehensive figure study plate containing 3 rapid 2-minute dynamic gesture poses alongside 2 sustained 12-minute fully constructed & lit anatomical mannequin/figure studies (including clear hands, feet, contrapposto balance, and directional shading).",
            combinedSkills = listOf("Line of Action & Gesture", "8-Head Proportions & Robo-Bean", "Core Anatomy Interlocks", "Hands & Feet"),
            requiredMaterials = listOf("2H, HB, 2B, 4B pencils", "Kneaded eraser", "A4/A3 drawing pad", "Timer"),
            phases = listOf(
                "Phase 1 (6 min): Execute 3 energetic 2-minute gestures focusing on asymmetric stretch/pinch and weight balance.",
                "Phase 2 (10 min): Construct 2 sustained figures from gesture -> 8-head landmarks -> Robo-Bean torso -> cylindrical limbs -> hand/foot wedges.",
                "Phase 3 (10 min): Map bony landmarks, muscle chain interlocks, and grounded feet.",
                "Phase 4 (10 min): Apply clean 2-value shadow grouping, subtle core modeling, and cast ground shadows."
            ),
            selfAssessmentChecklist = listOf(
                "Gestures feel lively and balanced over supporting feet.",
                "Sustained figures hold believable 8-head proportions and 3D Robo-Bean orientation.",
                "Limbs taper naturally with interlocking joints, solid palm boxes, and arched foot wedges.",
                "Shadow masses wrap across 3D torso/limb planes smoothly."
            ),
            estimatedMinutes = 36,
            xpReward = 250
        )
    )
)
