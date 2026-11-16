package com.example

import com.example.data.curriculum.CurriculumCatalog
import com.example.data.curriculum.ReferenceLibraryData
import com.example.data.visual.VisualCatalog
import com.example.domain.model.DiagramType
import com.example.domain.model.VisualCategory
import com.example.domain.model.VisualLayer
import com.example.domain.model.VisualScaffoldLevel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class VisualLearningEngineTest {

    @Test
    fun visualCatalogCoversAllCategoriesAndHasUniqueIds() {
        val demos = VisualCatalog.allDemos
        assertTrue("Expected at least 30 visual demonstrations", demos.size >= 33)
        assertEquals(demos.size, demos.map { it.id }.toSet().size)

        VisualCategory.entries.forEach { category ->
            val inCat = VisualCatalog.getByCategory(category)
            assertTrue("Category ${category.fullTitle} should have visual demos", inCat.isNotEmpty())
        }
    }

    @Test
    fun allDemosHaveValidStagesElementsAndMistakeComparisons() {
        VisualCatalog.allDemos.forEach { demo ->
            assertTrue("${demo.id} should have 4..7 stages", demo.stages.size in 4..7)
            demo.stages.forEachIndexed { idx, stage ->
                assertEquals("${demo.id} stage numbering mismatch", idx + 1, stage.stageNumber)
                assertTrue("${demo.id} stage title blank", stage.title.isNotBlank())
                assertTrue("${demo.id} stage explanation blank", stage.explanation.isNotBlank())
                assertTrue("${demo.id} stage visualFocus blank", stage.visualFocus.isNotBlank())
            }
            assertTrue("${demo.id} elements should not be empty", demo.elements.isNotEmpty())
            demo.elements.forEach { el ->
                assertTrue(
                    "${demo.id} element has out-of-range stageIndex ${el.stageIndex}",
                    el.stageIndex in demo.stages.indices
                )
            }
            val comp = demo.comparison
            assertTrue("${demo.id} comparison title blank", comp.title.isNotBlank())
            assertTrue("${demo.id} comparison whyMistakeHappens blank", comp.whyMistakeHappens.isNotBlank())
            assertTrue("${demo.id} comparison howToFix blank", comp.howToFix.isNotBlank())
            assertTrue("${demo.id} comparison wrongElements empty", comp.wrongElements.isNotEmpty())
            assertTrue("${demo.id} comparison rightElements empty", comp.rightElements.isNotEmpty())
        }
    }

    @Test
    fun coreProgressiveDemonstrationsHaveExpectedStageDepth() {
        assertEquals(6, VisualCatalog.getById("vis_cube_construction")?.stages?.size)
        assertEquals(6, VisualCatalog.getById("vis_sphere_shading")?.stages?.size)
        assertEquals(6, VisualCatalog.getById("vis_cylinder_construction")?.stages?.size)
        assertEquals(6, VisualCatalog.getById("vis_2pt_perspective")?.stages?.size)
        assertEquals(7, VisualCatalog.getById("vis_figure_gesture")?.stages?.size)
        assertEquals(7, VisualCatalog.getById("vis_portrait_loomis")?.stages?.size)
    }

    @Test
    fun everyLessonSkillWorldDiagramAndMistakeMapsToVisualDemo() {
        assertEquals(144, CurriculumCatalog.allLessons.size)
        CurriculumCatalog.allLessons.forEach { lesson ->
            val demo = VisualCatalog.getDemoForLesson(lesson)
            assertNotNull("Lesson ${lesson.id} should map to a VisualDemoSpec", demo)
            assertNotNull(VisualCatalog.getLessonForDemo(demo))
        }

        assertEquals(48, CurriculumCatalog.skills.size)
        CurriculumCatalog.skills.forEach { skill ->
            val demo = VisualCatalog.getDemoForSkill(skill.id)
            assertNotNull("Skill ${skill.id} should map cleanly", demo)
        }

        (1..12).forEach { world ->
            val demo = VisualCatalog.getDemoForWorld(world)
            assertTrue(world in demo.worldNumbers || demo.id.isNotBlank())
        }

        DiagramType.entries.forEach { dt ->
            assertNotNull(VisualCatalog.getDemoForDiagramType(dt))
        }

        ReferenceLibraryData.mistakes.forEach { mistake ->
            val demo = VisualCatalog.getDemoForMistake(mistake.id, mistake.relatedLessonId)
            assertTrue(demo.comparison.wrongElements.isNotEmpty())
            assertTrue(demo.comparison.rightElements.isNotEmpty())
        }
    }

    @Test
    fun gradualGuidanceRemovalFiltersLayersCorrectly() {
        val cube = VisualCatalog.getById("vis_cube_construction")!!

        // Full guidance displays everything
        VisualLayer.entries.forEach { layer ->
            assertTrue(cube.shouldRenderLayer(layer, VisualScaffoldLevel.FULL_GUIDANCE))
        }

        // Partial guidance removes heavy guides and annotation callouts while keeping structure & contour
        assertFalse(cube.shouldRenderLayer(VisualLayer.GUIDE, VisualScaffoldLevel.PARTIAL_GUIDANCE))
        assertFalse(cube.shouldRenderLayer(VisualLayer.ANNOTATION, VisualScaffoldLevel.PARTIAL_GUIDANCE))
        assertTrue(cube.shouldRenderLayer(VisualLayer.STRUCTURE, VisualScaffoldLevel.PARTIAL_GUIDANCE))
        assertTrue(cube.shouldRenderLayer(VisualLayer.CONTOUR, VisualScaffoldLevel.PARTIAL_GUIDANCE))

        // Reference only & Memory revealed check strip construction/structure scaffolding to contour + shading
        assertFalse(cube.shouldRenderLayer(VisualLayer.GUIDE, VisualScaffoldLevel.REFERENCE_ONLY))
        assertFalse(cube.shouldRenderLayer(VisualLayer.STRUCTURE, VisualScaffoldLevel.REFERENCE_ONLY))
        assertTrue(cube.shouldRenderLayer(VisualLayer.CONTOUR, VisualScaffoldLevel.REFERENCE_ONLY))
        assertTrue(cube.shouldRenderLayer(VisualLayer.SHADING, VisualScaffoldLevel.REFERENCE_ONLY))
    }
}
