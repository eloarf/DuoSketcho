package com.example.domain.engine

import com.example.data.curriculum.CurriculumCatalog
import com.example.data.local.LessonProgressEntity
import com.example.data.local.MilestoneProgressEntity
import com.example.data.local.SkillMasteryEntity
import com.example.domain.model.DifficultyRating
import com.example.domain.model.DrawingWorld
import com.example.domain.model.MasteryLevel
import com.example.domain.model.WorldProgressSummary
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

object SpacedRepetitionEngine {

    fun masteryLevelFromIndex(index: Int): MasteryLevel {
        return MasteryLevel.entries.firstOrNull { it.tierIndex == index } ?: MasteryLevel.NOT_STARTED
    }

    fun recordSkillPractice(
        existing: SkillMasteryEntity?,
        skillId: String,
        rating: DifficultyRating,
        checklistRatio: Float,
        todayEpochDay: Long
    ): SkillMasteryEntity {
        val current = existing ?: SkillMasteryEntity(skillId = skillId)
        val clampedRatio = checklistRatio.coerceIn(0f, 1f)
        val isNewDay = current.lastPracticedEpochDay != todayEpochDay
        val newPracticeCount = current.practiceCount + 1
        val newDistinctDays = if (isNewDay) current.distinctDaysPracticed + 1 else max(1, current.distinctDaysPracticed)
        val bestRatio = max(current.bestChecklistRatio, clampedRatio)

        val passed = rating != DifficultyRating.DIFFICULT && clampedRatio >= 0.65f
        val newConsecutiveSuccesses = if (passed) current.consecutiveSuccesses + 1 else 0

        val newEase = when (rating) {
            DifficultyRating.DIFFICULT -> max(1.3f, current.easeFactor - 0.2f)
            DifficultyRating.OKAY -> current.easeFactor
            DifficultyRating.EASY -> min(2.8f, current.easeFactor + 0.1f)
        }

        val newInterval = when (rating) {
            DifficultyRating.DIFFICULT -> 1
            DifficultyRating.OKAY -> when {
                newPracticeCount <= 1 -> 1
                newPracticeCount == 2 -> 3
                else -> (current.intervalDays * newEase).roundToInt().coerceIn(2, 45)
            }
            DifficultyRating.EASY -> when {
                newPracticeCount <= 1 -> 2
                newPracticeCount == 2 -> 6
                else -> (current.intervalDays * newEase * 1.25f).roundToInt().coerceIn(3, 60)
            }
        }

        val newWeak = when {
            rating == DifficultyRating.DIFFICULT || clampedRatio < 0.6f -> true
            newConsecutiveSuccesses >= 2 -> false
            else -> current.isWeak
        }

        val tierIndex = computeMasteryTier(
            practiceCount = newPracticeCount,
            distinctDays = newDistinctDays,
            consecutiveSuccesses = newConsecutiveSuccesses,
            bestRatio = bestRatio,
            easeFactor = newEase,
            isWeak = newWeak
        ).tierIndex

        return current.copy(
            masteryTierIndex = tierIndex,
            practiceCount = newPracticeCount,
            distinctDaysPracticed = newDistinctDays,
            consecutiveSuccesses = newConsecutiveSuccesses,
            bestChecklistRatio = bestRatio,
            easeFactor = newEase,
            intervalDays = newInterval,
            nextReviewEpochDay = todayEpochDay + newInterval,
            lastPracticedEpochDay = todayEpochDay,
            isWeak = newWeak
        )
    }

    /**
     * Never marks a skill Mastered after one exercise.
     * Requires repeated deliberate practice across multiple days and sustained successful reviews.
     */
    fun computeMasteryTier(
        practiceCount: Int,
        distinctDays: Int,
        consecutiveSuccesses: Int,
        bestRatio: Float,
        easeFactor: Float,
        isWeak: Boolean
    ): MasteryLevel {
        if (practiceCount <= 0) return MasteryLevel.NOT_STARTED
        if (practiceCount == 1) return MasteryLevel.INTRODUCED

        val canMaster = (practiceCount >= 7 || (practiceCount >= 5 && easeFactor >= 2.2f)) &&
            distinctDays >= 4 &&
            consecutiveSuccesses >= 4 &&
            bestRatio >= 0.85f &&
            !isWeak

        if (canMaster) return MasteryLevel.MASTERED

        val canProficient = practiceCount >= 5 &&
            distinctDays >= 3 &&
            consecutiveSuccesses >= 3 &&
            bestRatio >= 0.75f &&
            !isWeak
        if (canProficient) return MasteryLevel.PROFICIENT

        val canDevelop = practiceCount >= 3 &&
            distinctDays >= 2 &&
            consecutiveSuccesses >= 2 &&
            bestRatio >= 0.7f
        if (canDevelop) return MasteryLevel.DEVELOPING

        return MasteryLevel.PRACTICING
    }

    fun isSkillDue(skill: SkillMasteryEntity, todayEpochDay: Long): Boolean {
        return skill.practiceCount > 0 && (skill.nextReviewEpochDay <= todayEpochDay || skill.isWeak)
    }

    fun computeWorldSummaries(
        worlds: List<DrawingWorld>,
        lessonProgressMap: Map<String, LessonProgressEntity>,
        skillMasteryMap: Map<String, SkillMasteryEntity>,
        milestoneMap: Map<String, MilestoneProgressEntity>
    ): List<WorldProgressSummary> {
        val result = mutableListOf<WorldProgressSummary>()
        for (world in worlds.sortedBy { it.number }) {
            val lessons = world.units.flatMap { it.lessons }
            val completedLessons = lessons.count { (lessonProgressMap[it.id]?.completedCount ?: 0) > 0 }
            val worldSkills = CurriculumCatalog.skills.filter { it.worldNumber == world.number }
            val masteredSkills = worldSkills.count {
                (skillMasteryMap[it.id]?.masteryTierIndex ?: 0) >= MasteryLevel.MASTERED.tierIndex
            }
            val milestoneDone = milestoneMap[world.milestoneProject.id]?.completed == true

            val (unlocked, gatePct, lockMsg) = if (world.number == 1) {
                Triple(true, 100, null)
            } else {
                val prevWorld = result[world.number - 2]
                val prevLessonsRatio = if (prevWorld.totalLessons == 0) 1f else {
                    prevWorld.completedLessons.toFloat() / prevWorld.totalLessons.toFloat()
                }
                val prevWorldSkills = CurriculumCatalog.skills.filter { it.worldNumber == world.number - 1 }
                val practicingOrAbove = prevWorldSkills.count {
                    (skillMasteryMap[it.id]?.masteryTierIndex ?: 0) >= MasteryLevel.PRACTICING.tierIndex
                }
                val skillGateRatio = if (prevWorldSkills.isEmpty()) 1f else {
                    practicingOrAbove.toFloat() / prevWorldSkills.size.toFloat()
                }
                val milestoneScore = if (prevWorld.milestoneCompleted) 1f else 0f
                val pct = (((prevLessonsRatio * 0.4f) + (skillGateRatio * 0.35f) + (milestoneScore * 0.25f)) * 100f)
                    .roundToInt().coerceIn(0, 100)

                val passesGate = prevWorld.milestoneCompleted &&
                    prevLessonsRatio >= 0.65f &&
                    skillGateRatio >= 0.5f

                val reason = if (!passesGate) {
                    buildString {
                        append("Mastery Gate: Finish World ${world.number - 1} Milestone")
                        if (skillGateRatio < 0.5f) append(" & reach Practicing in 50%+ of World ${world.number - 1} skills")
                    }
                } else null

                Triple(passesGate, pct, reason)
            }

            result.add(
                WorldProgressSummary(
                    world = world,
                    completedLessons = completedLessons,
                    totalLessons = lessons.size,
                    milestoneCompleted = milestoneDone,
                    masteredSkillsCount = masteredSkills,
                    totalSkillsCount = worldSkills.size,
                    isUnlocked = unlocked,
                    gateProgressPercent = gatePct,
                    lockReason = lockMsg
                )
            )
        }
        return result
    }
}
