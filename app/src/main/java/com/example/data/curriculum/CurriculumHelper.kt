package com.example.data.curriculum

import com.example.domain.model.CurriculumUnit
import com.example.domain.model.DiagramType
import com.example.domain.model.DrawingWorld
import com.example.domain.model.ExerciseStage
import com.example.domain.model.Lesson
import com.example.domain.model.MilestoneProject
import com.example.domain.model.MistakeCorrection
import com.example.domain.model.PracticalExercise
import com.example.domain.model.RecallQuestion
import com.example.domain.model.SkillDefinition

internal data class LessonSpec(
    val id: String,
    val title: String,
    val subtitle: String,
    val objective: String,
    val explanation: String,
    val whyItMatters: String,
    val materials: List<String>,
    val steps: List<String>,
    val ex1Title: String,
    val ex1Desc: String,
    val ex1Reps: String,
    val ex1Min: Int,
    val ex2Title: String,
    val ex2Desc: String,
    val ex2Reps: String,
    val ex2Min: Int,
    val ex3Title: String,
    val ex3Desc: String,
    val ex3Reps: String,
    val ex3Min: Int,
    val challengeTitle: String,
    val challengeDesc: String,
    val challengeReps: String,
    val challengeMin: Int,
    val mistakes: List<Pair<String, String>>,
    val checklist: List<String>,
    val criteria: String,
    val diagramType: DiagramType,
    val primarySkillId: String,
    val reinforcedSkillIds: List<String> = emptyList()
)

internal fun buildLesson(
    worldNumber: Int,
    unitId: String,
    orderInUnit: Int,
    spec: LessonSpec
): Lesson {
    val totalMinutes = spec.ex1Min + spec.ex2Min + spec.ex3Min + 3
    val pedagogy = PedagogicalData.getPedagogy(spec.primarySkillId)
    val prereqs = PedagogicalData.skillPrerequisites[spec.primarySkillId].orEmpty()
    val recall = PedagogicalData.recallQuestionsBySkill[spec.primarySkillId] ?: RecallQuestion(
        prompt = "Before committing dark details in '${spec.title}', what check keeps your drawing structurally sound?",
        options = listOf(
            "Verify big proportions, axis alignment, and key light/shadow boundaries first",
            "Render small surface textures completely in one corner before placing the rest",
            "Trace the heaviest dark outline immediately"
        ),
        correctIndex = 0,
        explanation = "Checking structure, alignment, and overall hierarchy first prevents costly late corrections."
    )
    val caption = PedagogicalData.diagramCaptions[spec.diagramType] ?: spec.objective
    val mistake1 = spec.mistakes.getOrNull(0)?.let { "${it.first} -> Fix: ${it.second}" }
        ?: "Avoid rushing straight to details before placing primary axes."
    val mistake2 = spec.mistakes.getOrNull(1)?.let { "${it.first} -> Fix: ${it.second}" }
        ?: mistake1
    val mistake3 = spec.mistakes.lastOrNull()?.let { "${it.first} -> Fix: ${it.second}" }
        ?: mistake1

    val check1 = spec.checklist.getOrNull(0) ?: spec.criteria
    val check2 = spec.checklist.getOrNull(1) ?: check1
    val check3 = spec.checklist.getOrNull(2) ?: spec.criteria

    val cumulativeLabel = buildString {
        if (prereqs.isNotEmpty()) {
            append("Builds on earlier skills • ")
        }
        append(pedagogy.cumulativeTieIn)
    }

    return Lesson(
        id = spec.id,
        worldNumber = worldNumber,
        unitId = unitId,
        orderInUnit = orderInUnit,
        title = spec.title,
        subtitle = spec.subtitle,
        learningObjective = spec.objective,
        explanation = spec.explanation,
        whyItMatters = spec.whyItMatters,
        requiredMaterials = spec.materials,
        steps = spec.steps,
        exercises = listOf(
            PracticalExercise(
                id = "${spec.id}_ex1",
                title = spec.ex1Title,
                instructions = spec.ex1Desc,
                repetitions = spec.ex1Reps,
                estimatedMinutes = spec.ex1Min,
                skillId = spec.primarySkillId,
                stage = ExerciseStage.GUIDED_PRACTICE,
                techniqueFocus = pedagogy.techniqueFocus,
                mistakesToAvoid = mistake1,
                successCriteria = check1,
                harderVariation = "Repeat once more with a lighter 2H/HB touch and zero erasing.",
                isUnguided = false
            ),
            PracticalExercise(
                id = "${spec.id}_ex2",
                title = spec.ex2Title,
                instructions = spec.ex2Desc,
                repetitions = spec.ex2Reps,
                estimatedMinutes = spec.ex2Min,
                skillId = spec.primarySkillId,
                stage = ExerciseStage.INDEPENDENT_PRACTICE,
                techniqueFocus = "${pedagogy.techniqueFocus} Vary size or rotation across each repetition.",
                mistakesToAvoid = mistake2,
                successCriteria = check2,
                harderVariation = pedagogy.harderStretch,
                isUnguided = false
            ),
            PracticalExercise(
                id = "${spec.id}_ex3",
                title = spec.ex3Title,
                instructions = "${spec.ex3Desc} Unfamiliar context cue: ${pedagogy.unfamiliarSubjectHint}",
                repetitions = spec.ex3Reps,
                estimatedMinutes = spec.ex3Min,
                skillId = spec.reinforcedSkillIds.firstOrNull() ?: spec.primarySkillId,
                stage = ExerciseStage.UNFAMILIAR_APPLICATION,
                techniqueFocus = "Apply this method independently without tracing guide marks from earlier steps.",
                mistakesToAvoid = mistake3,
                successCriteria = check3,
                harderVariation = pedagogy.harderStretch,
                isUnguided = (orderInUnit >= 2 || worldNumber >= 3)
            )
        ),
        optionalChallenge = PracticalExercise(
            id = "${spec.id}_ch",
            title = spec.challengeTitle,
            instructions = spec.challengeDesc,
            repetitions = spec.challengeReps,
            estimatedMinutes = spec.challengeMin,
            skillId = spec.primarySkillId,
            isChallenge = true,
            stage = ExerciseStage.UNFAMILIAR_APPLICATION,
            techniqueFocus = pedagogy.cumulativeTieIn,
            mistakesToAvoid = mistake1,
            successCriteria = spec.criteria,
            harderVariation = pedagogy.harderStretch,
            isUnguided = true
        ),
        commonMistakes = spec.mistakes.map { MistakeCorrection(it.first, it.second) },
        selfAssessmentChecklist = spec.checklist,
        completionCriteria = spec.criteria,
        estimatedMinutes = totalMinutes,
        diagramType = spec.diagramType,
        primarySkillId = spec.primarySkillId,
        reinforcedSkillIds = spec.reinforcedSkillIds,
        xpReward = 30 + (worldNumber * 3),
        recallQuestion = recall,
        prerequisiteSkillIds = prereqs,
        cumulativeSkillsLabel = cumulativeLabel,
        diagramCaption = caption
    )
}

internal fun buildUnit(
    worldNumber: Int,
    orderInWorld: Int,
    id: String,
    title: String,
    summary: String,
    specs: List<LessonSpec>
): CurriculumUnit {
    return CurriculumUnit(
        id = id,
        worldNumber = worldNumber,
        orderInWorld = orderInWorld,
        title = title,
        summary = summary,
        lessons = specs.mapIndexed { idx, spec ->
            buildLesson(worldNumber, id, idx + 1, spec)
        }
    )
}

object CurriculumCatalog {
    val skills: List<SkillDefinition> by lazy {
        listOf(
            // World 1
            SkillDefinition("sk_eye_hand", "Hand-Eye Tracking", 1, "Observation", "Synchronizing eye speed with pencil movement"),
            SkillDefinition("sk_contour", "Contour Observation", 1, "Observation", "Following true outer and inner edges without guessing"),
            SkillDefinition("sk_neg_space", "Negative Space", 1, "Observation", "Seeing background shapes around subjects"),
            SkillDefinition("sk_sight_prop", "Sight-Measuring & Proportions", 1, "Observation", "Comparing angles, plumb lines, and relative ratios"),
            // World 2
            SkillDefinition("sk_cubes", "Box & Cube Construction", 2, "Basic Forms", "Drawing believable 3D boxes with converging edges"),
            SkillDefinition("sk_spheres_cyl", "Spheres, Cylinders & Cones", 2, "Basic Forms", "Ellipses, minor axes, and curved primitives"),
            SkillDefinition("sk_cross_contour", "Cross-Contour Wrapping", 2, "Basic Forms", "Wrapping surface lines to reveal volume"),
            SkillDefinition("sk_form_intersect", "Form Intersections", 2, "Basic Forms", "Joining primitives together in shared 3D space"),
            // World 3
            SkillDefinition("sk_stroke_conf", "Shoulder Stroke Confidence", 3, "Line Control", "Smooth, un-wobbled lines driven from shoulder"),
            SkillDefinition("sk_line_weight", "Line Weight Hierarchy", 3, "Line Control", "Using pressure and thickness to signal depth and overlap"),
            SkillDefinition("sk_hatching", "Hatching & Cross-Hatching", 3, "Line Control", "Evenly spaced directional tone and contour wraps"),
            SkillDefinition("sk_stippling_tex", "Stippling & Ink Mark-Making", 3, "Line Control", "Controlled dot density and rhythmic ink textures"),
            // World 4
            SkillDefinition("sk_value_scale", "Controlled Value Scales", 4, "Light & Shadow", "Stepping cleanly across 5 to 9 tonal values"),
            SkillDefinition("sk_form_shadow", "Terminator & Form Shadow", 4, "Light & Shadow", "Separating light family from core shadow and reflected light"),
            SkillDefinition("sk_cast_shadow", "Cast Shadow Projection", 4, "Light & Shadow", "Anchoring objects with accurate ground shadows"),
            SkillDefinition("sk_edge_control", "Lost & Found Edge Shading", 4, "Light & Shadow", "Blending soft transitions vs. crisp shadow edges"),
            // World 5
            SkillDefinition("sk_1pt_persp", "1-Point Perspective", 5, "Perspective", "Horizon line, eye level, and single vanishing point"),
            SkillDefinition("sk_2pt_persp", "2-Point Perspective", 5, "Perspective", "Rotated boxes converging cleanly to dual vanishing points"),
            SkillDefinition("sk_3pt_persp", "3-Point & Tilted Views", 5, "Perspective", "Bird's-eye and worm's-eye vertical convergence"),
            SkillDefinition("sk_persp_div", "Perspective Subdivision & Ellipses", 5, "Perspective", "X-method spacing, mirroring, and wheels in space"),
            // World 6
            SkillDefinition("sk_still_construct", "Object Construction & Symmetry", 6, "Still Life", "Building mugs, bottles, and tools on centerlines"),
            SkillDefinition("sk_still_prop", "Multi-Object Proportions", 6, "Still Life", "Maintaining accurate scale relationships across items"),
            SkillDefinition("sk_still_comp", "Still Life Arrangement", 6, "Still Life", "Overlapping silhouettes and table-plane grounding"),
            SkillDefinition("sk_still_value", "Tonal Still Life Grouping", 6, "Still Life", "Organizing darks and lights across multiple surfaces"),
            // World 7
            SkillDefinition("sk_tex_hard", "Wood, Stone & Matte Surfaces", 7, "Textures", "Breaking value patches into grain, cracks, and pits"),
            SkillDefinition("sk_tex_reflect", "Metal & Reflective Glass", 7, "Textures", "High-contrast specular shapes and distorted reflections"),
            SkillDefinition("sk_tex_fabric", "Fabric Folds & Drapery", 7, "Textures", "Pipe, zigzag, diaper, and spiral fold mechanics"),
            SkillDefinition("sk_tex_organic", "Skin, Hair & Tactile Surfaces", 7, "Textures", "Clumping hair masses and subtle tonal transitions"),
            // World 8
            SkillDefinition("sk_botanical", "Plants, Leaves & Flowers", 8, "Nature", "Ribs, overlapping petals, and radial symmetry"),
            SkillDefinition("sk_trees_terrain", "Trees, Rocks & Landscapes", 8, "Nature", "Cylindrical branching and layered terrain planes"),
            SkillDefinition("sk_animal_struct", "Animal Construction", 8, "Nature", "Comparative ribcage/pelvis masses and quadruped rhythm"),
            SkillDefinition("sk_animal_coat", "Fur, Feathers & Scales", 8, "Nature", "Directional clumps following underlying form shadow"),
            // World 9
            SkillDefinition("sk_gesture", "Line of Action & Gesture", 9, "Human Figure", "Capturing energy, tilt, and weight in 1–3 minutes"),
            SkillDefinition("sk_fig_prop", "Figure Proportions & Mannequin", 9, "Human Figure", "8-head canon, robo-bean, and foreshortened cylinders"),
            SkillDefinition("sk_anatomy_core", "Torso & Limb Anatomy", 9, "Human Figure", "Pectorals, obliques, deltoids, and leg interlocks"),
            SkillDefinition("sk_hands_feet", "Hands, Feet & Dynamic Balance", 9, "Human Figure", "Box-and-wedge palm, finger arcs, and foot arches"),
            // World 10
            SkillDefinition("sk_loomis_head", "Loomis Head Construction", 10, "Portraits", "Sphere, temporal slice, thirds, and jaw plane"),
            SkillDefinition("sk_eyes_nose", "Eyes & Nose Structure", 10, "Portraits", "Eyeball wrapping lids and keystone/bulb nose planes"),
            SkillDefinition("sk_mouth_ears_hair", "Mouth, Ears & Hair Volumes", 10, "Portraits", "Dental cylinder wrapping, ear Y-ridge, and hair ribbons"),
            SkillDefinition("sk_expressions", "Portrait Likeness & Expressions", 10, "Portraits", "Squash, stretch, brow creases, and tilt shifts"),
            // World 11
            SkillDefinition("sk_comp_focal", "Focal Points & Thumbnails", 11, "Composition", "Rule of thirds, value contrast, and leading lines"),
            SkillDefinition("sk_arch_env", "Architecture & Street Scenes", 11, "Composition", "Scale figures, facades, and multi-plane perspective"),
            SkillDefinition("sk_atmo_depth", "Atmospheric Depth & Lighting", 11, "Composition", "Foreground/midground/background value separation"),
            SkillDefinition("sk_storytelling", "Visual Storytelling Scenes", 11, "Composition", "Camera angle, silhouette readability, and mood"),
            // World 12
            SkillDefinition("sk_imagination", "Drawing From Imagination", 12, "Independence", "Rotational recall of objects without reference"),
            SkillDefinition("sk_stylization", "Intentional Stylization", 12, "Independence", "Shape language, exaggeration, and simplification"),
            SkillDefinition("sk_master_study", "Master Studies & Analysis", 12, "Independence", "Reverse-engineering draftsmanship from old masters"),
            SkillDefinition("sk_portfolio", "Personal Style & Portfolio", 12, "Independence", "Planning and finishing cohesive multi-study plates")
        ).map { sk ->
            sk.copy(prerequisiteSkillIds = PedagogicalData.skillPrerequisites[sk.id].orEmpty())
        }
    }

    val worlds: List<DrawingWorld> by lazy {
        worlds1To3() + worlds4To6() + worlds7To9() + worlds10To12()
    }

    val allLessons: List<Lesson> by lazy {
        worlds.flatMap { world -> world.units.flatMap { it.lessons } }
    }

    val allMilestones: List<MilestoneProject> by lazy {
        worlds.map { it.milestoneProject }
    }

    fun getLessonById(lessonId: String): Lesson? = allLessons.find { it.id == lessonId }

    fun getWorldByNumber(worldNumber: Int): DrawingWorld? = worlds.find { it.number == worldNumber }

    fun getSkillById(skillId: String): SkillDefinition? = skills.find { it.id == skillId }

    fun totalExerciseCount(): Int = allLessons.sumOf { it.exercises.size + 1 } + allMilestones.size
}
