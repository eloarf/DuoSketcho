package com.example

import com.example.data.curriculum.CurriculumCatalog
import com.example.data.curriculum.PedagogicalData
import com.example.data.local.DailyActivityEntity
import com.example.data.local.LessonProgressEntity
import com.example.data.local.MilestoneProgressEntity
import com.example.data.local.SkillMasteryEntity
import com.example.domain.engine.SessionBuilderEngine
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.engine.StreakAndXpEngine
import com.example.domain.engine.WeeklyReportEngine
import com.example.domain.model.ConfidenceLevel
import com.example.domain.model.DifficultyRating
import com.example.domain.model.ExerciseStage
import com.example.domain.model.MasteryLevel
import com.example.domain.model.SessionMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DrawingAcademyEngineTest {

    @Test
    fun `curriculum provides 12 worlds 48 units 144 lessons with 3 stages recall checks and 6-part exercises`() {
        assertEquals(12, CurriculumCatalog.worlds.size)
        assertEquals(48, CurriculumCatalog.worlds.sumOf { it.units.size })
        assertEquals(144, CurriculumCatalog.allLessons.size)
        assertEquals(48, CurriculumCatalog.skills.size)
        assertTrue(CurriculumCatalog.totalExerciseCount() >= 400)

        val validSkillIds = CurriculumCatalog.skills.map { it.id }.toSet()

        CurriculumCatalog.allLessons.forEach { lesson ->
            assertTrue(lesson.learningObjective.isNotBlank())
            assertTrue(lesson.explanation.isNotBlank())
            assertTrue(lesson.whyItMatters.isNotBlank())
            assertTrue(lesson.requiredMaterials.isNotEmpty())
            assertTrue(lesson.steps.isNotEmpty())
            assertEquals(3, lesson.exercises.size)
            assertEquals(ExerciseStage.GUIDED_PRACTICE, lesson.exercises[0].stage)
            assertEquals(ExerciseStage.INDEPENDENT_PRACTICE, lesson.exercises[1].stage)
            assertEquals(ExerciseStage.UNFAMILIAR_APPLICATION, lesson.exercises[2].stage)
            lesson.exercises.forEach { ex ->
                assertTrue(ex.techniqueFocus.isNotBlank())
                assertTrue(ex.mistakesToAvoid.isNotBlank())
                assertTrue(ex.successCriteria.isNotBlank())
                assertTrue(ex.harderVariation.isNotBlank())
            }
            assertTrue(lesson.optionalChallenge.isChallenge)
            assertTrue(lesson.commonMistakes.isNotEmpty())
            assertTrue(lesson.selfAssessmentChecklist.isNotEmpty())
            assertTrue(lesson.completionCriteria.isNotBlank())
            assertTrue(lesson.diagramCaption.isNotBlank())
            assertTrue(lesson.recallQuestion.prompt.isNotBlank())
            assertTrue(lesson.recallQuestion.options.size >= 3)
            assertTrue(lesson.recallQuestion.correctIndex in lesson.recallQuestion.options.indices)
            assertTrue(lesson.recallQuestion.explanation.isNotBlank())
            assertTrue(lesson.prerequisiteSkillIds.all { it in validSkillIds })
            assertTrue(lesson.estimatedMinutes > 0)
        }

        assertTrue(ReferenceLibraryDataCheck.isLibraryComplete())
    }

    private object ReferenceLibraryDataCheck {
        fun isLibraryComplete(): Boolean {
            return com.example.data.curriculum.ReferenceLibraryData.mistakes.size >= 25 &&
                com.example.data.curriculum.ReferenceLibraryData.glossary.size >= 50 &&
                com.example.data.curriculum.ReferenceLibraryData.observationChallenges.size >= 15 &&
                com.example.data.curriculum.ReferenceLibraryData.achievements.size >= 15
        }
    }

    @Test
    fun `skill enforces delayed mastery gate and adapts intervals to confidence plus difficulty`() {
        val afterFirst = SpacedRepetitionEngine.recordSkillPractice(
            existing = null,
            skillId = "sk_eye_hand",
            rating = DifficultyRating.EASY,
            checklistRatio = 1.0f,
            todayEpochDay = 100L,
            confidence = ConfidenceLevel.HIGH
        )
        assertEquals(MasteryLevel.INTRODUCED.tierIndex, afterFirst.masteryTierIndex)
        assertNotEquals(MasteryLevel.MASTERED.tierIndex, afterFirst.masteryTierIndex)
        // High confidence + Easy widens initial interval beyond low confidence
        assertEquals(103L, afterFirst.nextReviewEpochDay)

        // Low confidence flags skill weak and drops interval to 1 day even if rating wasn't Difficult
        val afterLowConf = SpacedRepetitionEngine.recordSkillPractice(
            existing = afterFirst,
            skillId = "sk_eye_hand",
            rating = DifficultyRating.OKAY,
            checklistRatio = 0.85f,
            todayEpochDay = 103L,
            confidence = ConfidenceLevel.LOW
        )
        assertTrue(afterLowConf.isWeak)
        assertEquals(104L, afterLowConf.nextReviewEpochDay)
        assertEquals(ExerciseStage.GUIDED_PRACTICE, SpacedRepetitionEngine.recommendedStageForSkill(afterLowConf))

        // Rapid multi-day practice within <7 days stops at PROFICIENT with delayedCheckPending = true
        var progressive: SkillMasteryEntity? = null
        for (dayOffset in 0L..4L) {
            progressive = SpacedRepetitionEngine.recordSkillPractice(
                existing = progressive,
                skillId = "sk_eye_hand",
                rating = DifficultyRating.EASY,
                checklistRatio = 0.95f,
                todayEpochDay = 200L + dayOffset,
                confidence = ConfidenceLevel.HIGH
            )
        }
        assertEquals(MasteryLevel.PROFICIENT.tierIndex, progressive!!.masteryTierIndex)
        assertTrue(progressive.delayedCheckPending)

        // Passing delayed retention check >= 7 days after first practice unlocks MASTERED
        val mastered = SpacedRepetitionEngine.recordSkillPractice(
            existing = progressive,
            skillId = "sk_eye_hand",
            rating = DifficultyRating.EASY,
            checklistRatio = 0.95f,
            todayEpochDay = 208L,
            confidence = ConfidenceLevel.HIGH
        )
        assertEquals(MasteryLevel.MASTERED.tierIndex, mastered.masteryTierIndex)
        assertFalse(mastered.delayedCheckPending)
        assertFalse(mastered.isWeak)
    }

    @Test
    fun `tutor recommendation surfaces weak prerequisite remediation before advancing`() {
        val summaries = SpacedRepetitionEngine.computeWorldSummaries(
            worlds = CurriculumCatalog.worlds,
            lessonProgressMap = mapOf(
                "w1_u1_l1" to LessonProgressEntity("w1_u1_l1", 1, completedCount = 1),
                "w1_u1_l2" to LessonProgressEntity("w1_u1_l2", 1, completedCount = 1),
                "w1_u1_l3" to LessonProgressEntity("w1_u1_l3", 1, completedCount = 1)
            ),
            skillMasteryMap = emptyMap(),
            milestoneMap = emptyMap()
        )
        // Next uncompleted lesson in Unit 2 uses sk_contour, whose prerequisite is sk_eye_hand.
        val nextLesson = SessionBuilderEngine.selectNextLesson(summaries, mapOf(
            "w1_u1_l1" to LessonProgressEntity("w1_u1_l1", 1, completedCount = 1),
            "w1_u1_l2" to LessonProgressEntity("w1_u1_l2", 1, completedCount = 1),
            "w1_u1_l3" to LessonProgressEntity("w1_u1_l3", 1, completedCount = 1)
        ))
        val weakPrereqId = nextLesson.prerequisiteSkillIds.first()
        val skillMap = mapOf(
            weakPrereqId to SkillMasteryEntity(
                skillId = weakPrereqId,
                masteryTierIndex = MasteryLevel.PRACTICING.tierIndex,
                practiceCount = 2,
                isWeak = true,
                lastConfidenceIndex = ConfidenceLevel.LOW.index,
                nextReviewEpochDay = 50L
            )
        )

        val rec = SpacedRepetitionEngine.recommendNextTutorAction(
            worldSummaries = summaries,
            lessonProgressMap = mapOf(
                "w1_u1_l1" to LessonProgressEntity("w1_u1_l1", 1, completedCount = 1),
                "w1_u1_l2" to LessonProgressEntity("w1_u1_l2", 1, completedCount = 1),
                "w1_u1_l3" to LessonProgressEntity("w1_u1_l3", 1, completedCount = 1)
            ),
            skillMasteryMap = skillMap,
            todayEpochDay = 55L
        )
        assertTrue(rec.isPrerequisiteRemediation)
        assertEquals(weakPrereqId, rec.targetSkillId)
        assertEquals(ExerciseStage.GUIDED_PRACTICE, rec.recommendedStage)
    }

    @Test
    fun `honest tutor evaluation gives specific criteria and prerequisite alerts without faking visual grading`() {
        val lesson = CurriculumCatalog.allLessons.first { it.prerequisiteSkillIds.isNotEmpty() }
        val feedback = PedagogicalData.evaluateSelfAssessment(
            lesson = lesson,
            checkedStates = listOf(true, false, false),
            rating = DifficultyRating.DIFFICULT,
            confidence = ConfidenceLevel.LOW,
            recallAnsweredCorrectly = false,
            prerequisiteWeakNames = listOf("Contour Observation")
        )
        assertEquals("Targeted Reinforcement Recommended", feedback.headline)
        assertTrue(feedback.observations.any { it.contains("Unchecked criteria") })
        assertTrue(feedback.observations.any { it.contains("Concept recall check missed") })
        assertTrue(feedback.prerequisiteAlert?.contains("Contour Observation") == true)
    }

    @Test
    fun `world mastery gate blocks world 2 until world 1 criteria and milestone met`() {
        val initialSummaries = SpacedRepetitionEngine.computeWorldSummaries(
            worlds = CurriculumCatalog.worlds,
            lessonProgressMap = emptyMap(),
            skillMasteryMap = emptyMap(),
            milestoneMap = emptyMap()
        )
        assertTrue(initialSummaries[0].isUnlocked)
        assertFalse(initialSummaries[1].isUnlocked)

        val w1Lessons = CurriculumCatalog.worlds[0].units.flatMap { it.lessons }
        val lessonMap = w1Lessons.associate { it.id to LessonProgressEntity(it.id, 1, completedCount = 1) }
        val skillMap = CurriculumCatalog.skills.filter { it.worldNumber == 1 }.associate {
            it.id to SkillMasteryEntity(
                skillId = it.id,
                masteryTierIndex = MasteryLevel.PRACTICING.tierIndex,
                practiceCount = 2
            )
        }
        val milestoneMap = mapOf(
            CurriculumCatalog.worlds[0].milestoneProject.id to
                MilestoneProgressEntity(CurriculumCatalog.worlds[0].milestoneProject.id, 1, completed = true)
        )
        val unlockedSummaries = SpacedRepetitionEngine.computeWorldSummaries(
            worlds = CurriculumCatalog.worlds,
            lessonProgressMap = lessonMap,
            skillMasteryMap = skillMap,
            milestoneMap = milestoneMap
        )
        assertTrue(unlockedSummaries[1].isUnlocked)
        assertFalse(unlockedSummaries[2].isUnlocked)
    }

    @Test
    fun `streak requires meaningful practice and consumes freeze across 1 day gap`() {
        val zeroPracticeDay = DailyActivityEntity(epochDay = 500L, minutesPracticed = 0, exercisesCompleted = 0)
        assertFalse(StreakAndXpEngine.isMeaningfulPracticeDay(zeroPracticeDay))

        val days = listOf(
            DailyActivityEntity(epochDay = 497L, minutesPracticed = 15, exercisesCompleted = 3, goalMet = true),
            DailyActivityEntity(epochDay = 499L, minutesPracticed = 20, exercisesCompleted = 3, goalMet = true),
            DailyActivityEntity(epochDay = 500L, minutesPracticed = 15, exercisesCompleted = 2, goalMet = true)
        )

        val streak = StreakAndXpEngine.computeStreak(
            activities = days,
            todayEpochDay = 500L,
            availableFreezes = 1,
            lastFreezeAwardStreak = 0
        )
        assertEquals(3, streak.currentStreak)
        assertEquals(0, streak.remainingFreezes)
        assertTrue(498L in streak.freezeUsedDays)
    }

    @Test
    fun `anti xp farming lowers repeat same day reward and session builder includes all 5 phases`() {
        val firstXp = StreakAndXpEngine.calculateLessonXp(40, true, false, DifficultyRating.OKAY, 1f, false)
        val repeatXp = StreakAndXpEngine.calculateLessonXp(40, false, true, DifficultyRating.OKAY, 1f, false)
        assertTrue(firstXp > repeatXp)

        val deepPlan = SessionBuilderEngine.buildSessionPlan(
            mode = SessionMode.DEEP_20_30,
            nextLesson = CurriculumCatalog.allLessons.first(),
            skillMasteries = listOf(
                SkillMasteryEntity("sk_contour", masteryTierIndex = 1, practiceCount = 1, nextReviewEpochDay = 10L, isWeak = true)
            ),
            todayEpochDay = 20L
        )
        assertTrue(deepPlan.steps.any { it.phaseLabel.contains("Warm-Up") })
        assertTrue(deepPlan.steps.any { it.phaseLabel.contains("New Lesson") })
        assertTrue(deepPlan.steps.any { it.phaseLabel.contains("Guided Exercise") })
        assertTrue(deepPlan.steps.any { it.isReview })
        assertTrue(deepPlan.steps.any { it.isOptionalChallenge })

        val report = WeeklyReportEngine.buildReport(
            activities = listOf(DailyActivityEntity(20L, 25, 60, 1, 3, 1, 15, true)),
            skillMasteries = listOf(SkillMasteryEntity("sk_eye_hand", 3, 4, 2, 2, 0.9f, isWeak = false)),
            todayEpochDay = 20L,
            weeklyGoalSessions = 5
        )
        assertEquals(25, report.minutesLast7Days)
        assertTrue(report.strongestSkills.isNotEmpty())
    }
}
