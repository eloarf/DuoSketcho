package com.example

import com.example.data.curriculum.CurriculumCatalog
import com.example.data.curriculum.ReferenceLibraryData
import com.example.data.local.DailyActivityEntity
import com.example.data.local.LessonProgressEntity
import com.example.data.local.MilestoneProgressEntity
import com.example.data.local.SkillMasteryEntity
import com.example.domain.engine.SessionBuilderEngine
import com.example.domain.engine.SpacedRepetitionEngine
import com.example.domain.engine.StreakAndXpEngine
import com.example.domain.engine.WeeklyReportEngine
import com.example.domain.model.DifficultyRating
import com.example.domain.model.MasteryLevel
import com.example.domain.model.SessionMode
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DrawingAcademyEngineTest {

    @Test
    fun `curriculum provides 12 worlds 48 units 144 lessons and over 400 distinct exercises`() {
        assertEquals(12, CurriculumCatalog.worlds.size)
        assertEquals(48, CurriculumCatalog.worlds.sumOf { it.units.size })
        assertEquals(144, CurriculumCatalog.allLessons.size)
        assertEquals(48, CurriculumCatalog.skills.size)
        assertTrue(CurriculumCatalog.totalExerciseCount() >= 400)

        CurriculumCatalog.allLessons.forEach { lesson ->
            assertTrue(lesson.learningObjective.isNotBlank())
            assertTrue(lesson.explanation.isNotBlank())
            assertTrue(lesson.whyItMatters.isNotBlank())
            assertTrue(lesson.requiredMaterials.isNotEmpty())
            assertTrue(lesson.steps.isNotEmpty())
            assertEquals(3, lesson.exercises.size)
            assertTrue(lesson.optionalChallenge.isChallenge)
            assertTrue(lesson.commonMistakes.isNotEmpty())
            assertTrue(lesson.selfAssessmentChecklist.isNotEmpty())
            assertTrue(lesson.completionCriteria.isNotBlank())
            assertTrue(lesson.estimatedMinutes > 0)
        }

        assertTrue(ReferenceLibraryData.mistakes.size >= 25)
        assertTrue(ReferenceLibraryData.glossary.size >= 50)
        assertTrue(ReferenceLibraryData.observationChallenges.size >= 15)
        assertTrue(ReferenceLibraryData.achievements.size >= 15)
    }

    @Test
    fun `skill is never mastered after one exercise and adapts intervals to ratings`() {
        val afterFirst = SpacedRepetitionEngine.recordSkillPractice(
            existing = null,
            skillId = "sk_eye_hand",
            rating = DifficultyRating.EASY,
            checklistRatio = 1.0f,
            todayEpochDay = 100L
        )
        assertEquals(MasteryLevel.INTRODUCED.tierIndex, afterFirst.masteryTierIndex)
        assertNotEquals(MasteryLevel.MASTERED.tierIndex, afterFirst.masteryTierIndex)
        assertEquals(102L, afterFirst.nextReviewEpochDay)

        val afterDifficult = SpacedRepetitionEngine.recordSkillPractice(
            existing = afterFirst,
            skillId = "sk_eye_hand",
            rating = DifficultyRating.DIFFICULT,
            checklistRatio = 0.5f,
            todayEpochDay = 102L
        )
        assertTrue(afterDifficult.isWeak)
        assertEquals(103L, afterDifficult.nextReviewEpochDay)

        // Repeated multi-day consistent high-quality practice eventually earns Mastery
        var progressive = afterFirst
        for (i in 1..6) {
            progressive = SpacedRepetitionEngine.recordSkillPractice(
                existing = progressive,
                skillId = "sk_eye_hand",
                rating = DifficultyRating.EASY,
                checklistRatio = 0.95f,
                todayEpochDay = 102L + (i * 3L)
            )
        }
        assertEquals(MasteryLevel.MASTERED.tierIndex, progressive.masteryTierIndex)
        assertFalse(progressive.isWeak)
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

        // Complete all World 1 lessons + skills to Practicing + milestone
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
            // 498 missed -> should consume 1 freeze
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
