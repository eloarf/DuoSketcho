package com.example.data.visual

import com.example.data.curriculum.CurriculumCatalog
import com.example.domain.model.DiagramType
import com.example.domain.model.Lesson
import com.example.domain.model.VisualCategory
import com.example.domain.model.VisualDemoSpec

object VisualCatalog {

    val allDemos: List<VisualDemoSpec> by lazy {
        markMakingVisualDemos() +
            formsVisualDemos() +
            lightAndPerspectiveVisualDemos() +
            objectsAndNatureVisualDemos() +
            figureAndCompositionVisualDemos()
    }

    private val byId: Map<String, VisualDemoSpec> by lazy {
        allDemos.associateBy { it.id }
    }

    private val lessonExplicitDemoId: Map<String, String> = mapOf(
        // World 1 — Learning to See
        "w1_u1_l1" to "vis_contour_sighting",
        "w1_u1_l2" to "vis_contour_sighting",
        "w1_u1_l3" to "vis_curves_s_curves",
        "w1_u2_l1" to "vis_negative_space",
        "w1_u2_l2" to "vis_negative_space",
        "w1_u2_l3" to "vis_circles_ellipses",
        "w1_u3_l1" to "vis_contour_sighting",
        "w1_u3_l2" to "vis_contour_sighting",
        "w1_u3_l3" to "vis_contour_sighting",
        "w1_u4_l1" to "vis_composition_thirds",
        "w1_u4_l2" to "vis_contour_sighting",
        "w1_u4_l3" to "vis_negative_space",
        // World 2 — Basic Forms
        "w2_u1_l1" to "vis_cube_construction",
        "w2_u1_l2" to "vis_cube_construction",
        "w2_u1_l3" to "vis_cube_construction",
        "w2_u2_l1" to "vis_circles_ellipses",
        "w2_u2_l2" to "vis_cylinder_construction",
        "w2_u2_l3" to "vis_cone_cross_contour",
        "w2_u3_l1" to "vis_cone_cross_contour",
        "w2_u3_l2" to "vis_cone_cross_contour",
        "w2_u3_l3" to "vis_2d_to_3d",
        "w2_u4_l1" to "vis_form_intersections",
        "w2_u4_l2" to "vis_cup_mug",
        "w2_u4_l3" to "vis_form_intersections",
        // World 3 — Line Control
        "w3_u1_l1" to "vis_confident_lines",
        "w3_u1_l2" to "vis_confident_lines",
        "w3_u1_l3" to "vis_curves_s_curves",
        "w3_u2_l1" to "vis_line_weight",
        "w3_u2_l2" to "vis_line_weight",
        "w3_u2_l3" to "vis_line_weight",
        "w3_u3_l1" to "vis_hatching_stippling",
        "w3_u3_l2" to "vis_hatching_stippling",
        "w3_u3_l3" to "vis_hatching_stippling",
        "w3_u4_l1" to "vis_hatching_stippling",
        "w3_u4_l2" to "vis_textures_materials",
        "w3_u4_l3" to "vis_line_weight",
        // World 4 — Light & Shadow
        "w4_u1_l1" to "vis_value_scale",
        "w4_u1_l2" to "vis_value_scale",
        "w4_u1_l3" to "vis_sphere_shading",
        "w4_u2_l1" to "vis_sphere_shading",
        "w4_u2_l2" to "vis_sphere_shading",
        "w4_u2_l3" to "vis_sphere_shading",
        "w4_u3_l1" to "vis_cast_shadow_edges",
        "w4_u3_l2" to "vis_cast_shadow_edges",
        "w4_u3_l3" to "vis_cast_shadow_edges",
        "w4_u4_l1" to "vis_value_scale",
        "w4_u4_l2" to "vis_sphere_shading",
        "w4_u4_l3" to "vis_still_life_group",
        // World 5 — Perspective
        "w5_u1_l1" to "vis_horizon_1pt",
        "w5_u1_l2" to "vis_horizon_1pt",
        "w5_u1_l3" to "vis_architecture_depth",
        "w5_u2_l1" to "vis_2pt_perspective",
        "w5_u2_l2" to "vis_2pt_perspective",
        "w5_u2_l3" to "vis_book_furniture",
        "w5_u3_l1" to "vis_3pt_subdivision",
        "w5_u3_l2" to "vis_3pt_subdivision",
        "w5_u3_l3" to "vis_circles_ellipses",
        "w5_u4_l1" to "vis_3pt_subdivision",
        "w5_u4_l2" to "vis_2pt_perspective",
        "w5_u4_l3" to "vis_2pt_perspective",
        // World 6 — Still Life & Objects
        "w6_u1_l1" to "vis_bottle_vase",
        "w6_u1_l2" to "vis_cup_mug",
        "w6_u1_l3" to "vis_shoe_household",
        "w6_u2_l1" to "vis_still_life_group",
        "w6_u2_l2" to "vis_still_life_group",
        "w6_u2_l3" to "vis_book_furniture",
        "w6_u3_l1" to "vis_composition_thirds",
        "w6_u3_l2" to "vis_still_life_group",
        "w6_u3_l3" to "vis_negative_space",
        "w6_u4_l1" to "vis_contour_sighting",
        "w6_u4_l2" to "vis_cup_mug",
        "w6_u4_l3" to "vis_still_life_group",
        // World 7 — Textures & Materials
        "w7_u1_l1" to "vis_textures_materials",
        "w7_u1_l2" to "vis_textures_materials",
        "w7_u1_l3" to "vis_book_furniture",
        "w7_u2_l1" to "vis_textures_materials",
        "w7_u2_l2" to "vis_bottle_vase",
        "w7_u2_l3" to "vis_cup_mug",
        "w7_u3_l1" to "vis_textures_materials",
        "w7_u3_l2" to "vis_textures_materials",
        "w7_u3_l3" to "vis_shoe_household",
        "w7_u4_l1" to "vis_portrait_features",
        "w7_u4_l2" to "vis_sphere_shading",
        "w7_u4_l3" to "vis_textures_materials",
        // World 8 — Nature & Animals
        "w8_u1_l1" to "vis_botanical_trees",
        "w8_u1_l2" to "vis_botanical_trees",
        "w8_u1_l3" to "vis_botanical_trees",
        "w8_u2_l1" to "vis_botanical_trees",
        "w8_u2_l2" to "vis_architecture_depth",
        "w8_u2_l3" to "vis_architecture_depth",
        "w8_u3_l1" to "vis_animal_construction",
        "w8_u3_l2" to "vis_animal_construction",
        "w8_u3_l3" to "vis_animal_construction",
        "w8_u4_l1" to "vis_animal_construction",
        "w8_u4_l2" to "vis_animal_construction",
        "w8_u4_l3" to "vis_botanical_trees",
        // World 9 — Human Figure
        "w9_u1_l1" to "vis_figure_gesture",
        "w9_u1_l2" to "vis_figure_gesture",
        "w9_u1_l3" to "vis_figure_gesture",
        "w9_u2_l1" to "vis_figure_gesture",
        "w9_u2_l2" to "vis_figure_gesture",
        "w9_u2_l3" to "vis_figure_gesture",
        "w9_u3_l1" to "vis_figure_gesture",
        "w9_u3_l2" to "vis_figure_gesture",
        "w9_u3_l3" to "vis_figure_gesture",
        "w9_u4_l1" to "vis_hands_feet",
        "w9_u4_l2" to "vis_hands_feet",
        "w9_u4_l3" to "vis_figure_gesture",
        // World 10 — Portraits
        "w10_u1_l1" to "vis_portrait_loomis",
        "w10_u1_l2" to "vis_portrait_loomis",
        "w10_u1_l3" to "vis_portrait_loomis",
        "w10_u2_l1" to "vis_portrait_features",
        "w10_u2_l2" to "vis_portrait_features",
        "w10_u2_l3" to "vis_portrait_features",
        "w10_u3_l1" to "vis_portrait_features",
        "w10_u3_l2" to "vis_portrait_features",
        "w10_u3_l3" to "vis_portrait_features",
        "w10_u4_l1" to "vis_portrait_loomis",
        "w10_u4_l2" to "vis_portrait_features",
        "w10_u4_l3" to "vis_portrait_loomis",
        // World 11 — Composition & Environments
        "w11_u1_l1" to "vis_composition_thirds",
        "w11_u1_l2" to "vis_composition_thirds",
        "w11_u1_l3" to "vis_composition_thirds",
        "w11_u2_l1" to "vis_architecture_depth",
        "w11_u2_l2" to "vis_architecture_depth",
        "w11_u2_l3" to "vis_book_furniture",
        "w11_u3_l1" to "vis_architecture_depth",
        "w11_u3_l2" to "vis_architecture_depth",
        "w11_u3_l3" to "vis_cast_shadow_edges",
        "w11_u4_l1" to "vis_composition_thirds",
        "w11_u4_l2" to "vis_architecture_depth",
        "w11_u4_l3" to "vis_composition_thirds",
        // World 12 — Artistic Independence
        "w12_u1_l1" to "vis_imagination_rotation",
        "w12_u1_l2" to "vis_imagination_rotation",
        "w12_u1_l3" to "vis_imagination_rotation",
        "w12_u2_l1" to "vis_line_weight",
        "w12_u2_l2" to "vis_figure_gesture",
        "w12_u2_l3" to "vis_imagination_rotation",
        "w12_u3_l1" to "vis_still_life_group",
        "w12_u3_l2" to "vis_portrait_loomis",
        "w12_u3_l3" to "vis_composition_thirds",
        "w12_u4_l1" to "vis_imagination_rotation",
        "w12_u4_l2" to "vis_composition_thirds",
        "w12_u4_l3" to "vis_imagination_rotation"
    )

    private val mistakeExplicitDemoId: Map<String, String> = mapOf(
        "m_01" to "vis_contour_sighting",
        "m_02" to "vis_bottle_vase",
        "m_03" to "vis_negative_space",
        "m_04" to "vis_cube_construction",
        "m_05" to "vis_circles_ellipses",
        "m_06" to "vis_cone_cross_contour",
        "m_07" to "vis_confident_lines",
        "m_08" to "vis_line_weight",
        "m_09" to "vis_hatching_stippling",
        "m_10" to "vis_sphere_shading",
        "m_11" to "vis_value_scale",
        "m_12" to "vis_cast_shadow_edges",
        "m_13" to "vis_2pt_perspective",
        "m_14" to "vis_3pt_subdivision",
        "m_15" to "vis_circles_ellipses",
        "m_16" to "vis_bottle_vase",
        "m_17" to "vis_still_life_group",
        "m_18" to "vis_textures_materials",
        "m_19" to "vis_textures_materials",
        "m_20" to "vis_textures_materials",
        "m_21" to "vis_botanical_trees",
        "m_22" to "vis_botanical_trees",
        "m_23" to "vis_architecture_depth",
        "m_24" to "vis_figure_gesture",
        "m_25" to "vis_figure_gesture",
        "m_26" to "vis_hands_feet",
        "m_27" to "vis_portrait_features",
        "m_28" to "vis_portrait_features",
        "m_29" to "vis_portrait_features",
        "m_30" to "vis_composition_thirds",
        "m_31" to "vis_architecture_depth",
        "m_32" to "vis_imagination_rotation"
    )

    fun getById(id: String): VisualDemoSpec? = byId[id]

    fun getByCategory(category: VisualCategory): List<VisualDemoSpec> =
        allDemos.filter { it.category == category }

    fun getDemoForLesson(lesson: Lesson): VisualDemoSpec {
        lessonExplicitDemoId[lesson.id]?.let { id ->
            byId[id]?.let { return it }
        }
        return getDemoForSkill(lesson.primarySkillId)
    }

    fun getDemoForSkill(skillId: String): VisualDemoSpec {
        allDemos.firstOrNull { skillId in it.skillIds }?.let { return it }
        val skill = CurriculumCatalog.getSkillById(skillId)
        if (skill != null) return getDemoForWorld(skill.worldNumber)
        return allDemos.first()
    }

    fun getDemoForWorld(worldNumber: Int): VisualDemoSpec {
        val preferred = when (worldNumber) {
            1 -> "vis_contour_sighting"
            2 -> "vis_cube_construction"
            3 -> "vis_line_weight"
            4 -> "vis_sphere_shading"
            5 -> "vis_2pt_perspective"
            6 -> "vis_still_life_group"
            7 -> "vis_textures_materials"
            8 -> "vis_botanical_trees"
            9 -> "vis_figure_gesture"
            10 -> "vis_portrait_loomis"
            11 -> "vis_composition_thirds"
            12 -> "vis_imagination_rotation"
            else -> "vis_confident_lines"
        }
        return byId[preferred]
            ?: allDemos.firstOrNull { worldNumber in it.worldNumbers }
            ?: allDemos.first()
    }

    fun getDemoForDiagramType(diagramType: DiagramType): VisualDemoSpec {
        val id = when (diagramType) {
            DiagramType.OBSERVATION_CONTOUR -> "vis_contour_sighting"
            DiagramType.NEGATIVE_SPACE -> "vis_negative_space"
            DiagramType.BASIC_FORMS_3D -> "vis_cube_construction"
            DiagramType.CROSS_CONTOUR -> "vis_cone_cross_contour"
            DiagramType.LINE_CONTROL_GHOSTING -> "vis_confident_lines"
            DiagramType.HATCHING_AND_STIPPLING -> "vis_hatching_stippling"
            DiagramType.VALUE_SCALE_AND_SPHERE -> "vis_sphere_shading"
            DiagramType.CAST_SHADOW_LOGIC -> "vis_cast_shadow_edges"
            DiagramType.PERSPECTIVE_1_2_3_POINT -> "vis_2pt_perspective"
            DiagramType.STILL_LIFE_SIGHTING -> "vis_still_life_group"
            DiagramType.TEXTURE_STUDIES -> "vis_textures_materials"
            DiagramType.BOTANICAL_AND_ANIMAL -> "vis_botanical_trees"
            DiagramType.HUMAN_GESTURE_MANNEQUIN -> "vis_figure_gesture"
            DiagramType.LOOMIS_HEAD_PROPORTIONS -> "vis_portrait_loomis"
            DiagramType.COMPOSITION_THIRDS -> "vis_composition_thirds"
            DiagramType.IMAGINATION_SYNTHESIS -> "vis_imagination_rotation"
        }
        return byId[id] ?: allDemos.first()
    }

    fun getDemoForMistake(mistakeId: String, relatedLessonId: String): VisualDemoSpec {
        mistakeExplicitDemoId[mistakeId]?.let { id ->
            byId[id]?.let { return it }
        }
        CurriculumCatalog.getLessonById(relatedLessonId)?.let { return getDemoForLesson(it) }
        return allDemos.first()
    }

    fun getLessonForDemo(demo: VisualDemoSpec): Lesson? {
        val explicitLessonId = lessonExplicitDemoId.entries.firstOrNull { it.value == demo.id }?.key
        if (explicitLessonId != null) {
            CurriculumCatalog.getLessonById(explicitLessonId)?.let { return it }
        }
        for (skillId in demo.skillIds) {
            CurriculumCatalog.allLessons.firstOrNull { it.primarySkillId == skillId }?.let { return it }
        }
        return CurriculumCatalog.allLessons.firstOrNull { it.worldNumber in demo.worldNumbers }
    }
}
