package com.example.domain.engine

import com.example.data.curriculum.CurriculumCatalog
import com.example.data.curriculum.PedagogicalData
import com.example.data.local.LessonProgressEntity
import com.example.data.local.MilestoneProgressEntity
import com.example.data.local.SkillMasteryEntity
import com.example.domain.model.ConfidenceLevel
import com.example.domain.model.DifficultyRating
import com.example.domain.model.DrawingWorld
import com.example.domain.model.ExerciseStage
import com.example.domain.model.MasteryLevel
import com.example.domain.model.SkillDefinition
import com.example.domain.model.TutorRecommendation
import com.example.domain.model.WorldProgressSummary
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

object SpacedRepetitionEngine {

    fun masteryLevelFromIndex(index: Int): MasteryLevel {
        return MasteryLevel.entries.firstOrNull { it.tierIndex == index } ?: MasteryLevel.NOT_STARTED
    }

    fun confidenceFromIndex(index: Int): ConfidenceLevel {
        return ConfidenceLevel.entries.firstOrNull { it.index == index } ?: ConfidenceLevel.MODERATE
    }

    fun recommendedStageForSkill(mastery: SkillMasteryEntity?): ExerciseStage {
        if (mastery == null || mastery.practiceCount == 0 || mastery.isWeak || mastery.lastConfidenceIndex == ConfidenceLevel.LOW.index) {
            return ExerciseStage.GUIDED_PRACTICE
        }
        return if (mastery.masteryTierIndex >= MasteryLevel.PROFICIENT.tierIndex || mastery.delayedCheckPending) {
            ExerciseStage.UNFAMILIAR_APPLICATION
        } else {
            ExerciseStage.INDEPENDENT_PRACTICE
        }
    }

    fun recordSkillPractice(
        existing: SkillMasteryEntity?,
        skillId: String,
        rating: DifficultyRating,
        checklistRatio: Float,
        todayEpochDay: Long,
        confidence: ConfidenceLevel = ConfidenceLevel.MODERATE
    ): SkillMasteryEntity {
        val current = existing ?: SkillMasteryEntity(skillId = skillId)
        val clampedRatio = checklistRatio.coerceIn(0f, 1f)
        val firstDay = when {
            current.firstPracticedEpochDay > 0L -> current.firstPracticedEpochDay
            current.lastPracticedEpochDay > 0L -> current.lastPracticedEpochDay
            else -> todayEpochDay
        }
        val isNewDay = current.lastPracticedEpochDay != todayEpochDay
        val newPracticeCount = current.practiceCount + 1
        val newDistinctDays = if (isNewDay) current.distinctDaysPracticed + 1 else max(1, current.distinctDaysPracticed)
        val bestRatio = max(current.bestChecklistRatio, clampedRatio)

        val passed = rating != DifficultyRating.DIFFICULT &&
            confidence != ConfidenceLevel.LOW &&
            clampedRatio >= 0.65f
        val newConsecutiveSuccesses = if (passed) current.consecutiveSuccesses + 1 else 0

        val newEase = when {
            rating == DifficultyRating.DIFFICULT || confidence == ConfidenceLevel.LOW ->
                max(1.3f, current.easeFactor - 0.2f)
            rating == DifficultyRating.EASY && confidence == ConfidenceLevel.HIGH ->
                min(2.8f, current.easeFactor + 0.15f)
            rating == DifficultyRating.EASY ->
                min(2.8f, current.easeFactor + 0.1f)
            confidence == ConfidenceLevel.HIGH ->
                min(2.8f, current.easeFactor + 0.05f)
            else -> current.easeFactor
        }

        var newInterval = when {
            !passed -> 1
            rating == DifficultyRating.OKAY -> when {
                newPracticeCount <= 1 -> 1
                newPracticeCount == 2 -> 3
                else -> (current.intervalDays * newEase).roundToInt().coerceIn(2, 45)
            }
            rating == DifficultyRating.EASY && confidence == ConfidenceLevel.HIGH -> when {
                newPracticeCount <= 1 -> 3
                newPracticeCount == 2 -> 7
                else -> (current.intervalDays * newEase * 1.35f).roundToInt().coerceIn(4, 60)
            }
            else -> when {
                newPracticeCount <= 1 -> 2
                newPracticeCount == 2 -> 6
                else -> (current.intervalDays * newEase * 1.25f).roundToInt().coerceIn(3, 60)
            }
        }

        val newWeak = when {
            rating == DifficultyRating.DIFFICULT || confidence == ConfidenceLevel.LOW || clampedRatio < 0.6f -> true
            newConsecutiveSuccesses >= 2 && confidence != ConfidenceLevel.LOW -> false
            else -> current.isWeak
        }

        val elapsedDays = todayEpochDay - firstDay
        val rawTier = computeMasteryTier(
            practiceCount = newPracticeCount,
            distinctDays = newDistinctDays,
            consecutiveSuccesses = newConsecutiveSuccesses,
            bestRatio = bestRatio,
            easeFactor = newEase,
            isWeak = newWeak,
            elapsedSinceFirstDay = elapsedDays,
            delayedCheckPassed = passed && (current.delayedCheckPending || elapsedDays >= 7L)
        )

        val coreReadyForMastery = (newPracticeCount >= 7 || (newPracticeCount >= 5 && newEase >= 2.2f)) &&
            newDistinctDays >= 4 &&
            newConsecutiveSuccesses >= 4 &&
            bestRatio >= 0.85f &&
            !newWeak

        val nextDelayedCheckPending = if (!passed) {
            false
        } else if (rawTier == MasteryLevel.MASTERED) {
            false
        } else if (coreReadyForMastery) {
            true
        } else {
            current.delayedCheckPending
        }

        if (nextDelayedCheckPending && rawTier != MasteryLevel.MASTERED) {
            val daysUntilSeven = (7L - elapsedDays).coerceIn(3L, 7L).toInt()
            newInterval = min(newInterval, daysUntilSeven)
        }

        return current.copy(
            masteryTierIndex = rawTier.tierIndex,
            practiceCount = newPracticeCount,
            distinctDaysPracticed = newDistinctDays,
            consecutiveSuccesses = newConsecutiveSuccesses,
            bestChecklistRatio = bestRatio,
            easeFactor = newEase,
            intervalDays = newInterval,
            nextReviewEpochDay = todayEpochDay + newInterval,
            lastPracticedEpochDay = todayEpochDay,
            isWeak = newWeak,
            lastConfidenceIndex = confidence.index,
            delayedCheckPending = nextDelayedCheckPending,
            firstPracticedEpochDay = firstDay
        )
    }

    /**
     * Never marks a skill Mastered after one exercise.
     * Requires repeated deliberate practice across multiple distinct days, sustained success,
     * and a delayed retention window (>= 7 elapsed days or delayed check pass).
     */
    fun computeMasteryTier(
        practiceCount: Int,
        distinctDays: Int,
        consecutiveSuccesses: Int,
        bestRatio: Float,
        easeFactor: Float,
        isWeak: Boolean,
        elapsedSinceFirstDay: Long = 7L,
        delayedCheckPassed: Boolean = true
    ): MasteryLevel {
        if (practiceCount <= 0) return MasteryLevel.NOT_STARTED
        if (practiceCount == 1) return MasteryLevel.INTRODUCED

        val canMasterCore = (practiceCount >= 7 || (practiceCount >= 5 && easeFactor >= 2.2f)) &&
            distinctDays >= 4 &&
            consecutiveSuccesses >= 4 &&
            bestRatio >= 0.85f &&
            !isWeak

        if (canMasterCore && elapsedSinceFirstDay >= 7L && delayedCheckPassed) {
            return MasteryLevel.MASTERED
        }

        val canProficient = practiceCount >= 5 &&
            distinctDays >= 3 &&
            consecutiveSuccesses >= 3 &&
            bestRatio >= 0.75f &&
            !isWeak
        if (canProficient || canMasterCore) return MasteryLevel.PROFICIENT

        val canDevelop = practiceCount >= 3 &&
            distinctDays >= 2 &&
            consecutiveSuccesses >= 2 &&
            bestRatio >= 0.7f
        if (canDevelop) return MasteryLevel.DEVELOPING

        return MasteryLevel.PRACTICING
    }

    fun isSkillDue(skill: SkillMasteryEntity, todayEpochDay: Long): Boolean {
        return skill.practiceCount > 0 && (
            skill.nextReviewEpochDay <= todayEpochDay ||
                skill.isWeak ||
                (skill.delayedCheckPending && skill.nextReviewEpochDay <= todayEpochDay + 1L)
            )
    }

    fun findWeakPrerequisites(
        skillId: String,
        skillMasteryMap: Map<String, SkillMasteryEntity>
    ): List<SkillDefinition> {
        val prereqIds = PedagogicalData.skillPrerequisites[skillId].orEmpty()
        return prereqIds.mapNotNull { pid ->
            val mastery = skillMasteryMap[pid]
            val struggling = mastery != null && (mastery.isWeak || mastery.lastConfidenceIndex == ConfidenceLevel.LOW.index)
            if (struggling) CurriculumCatalog.getSkillById(pid) else null
        }
    }

    fun recommendNextTutorAction(
        worldSummaries: List<WorldProgressSummary>,
        lessonProgressMap: Map<String, LessonProgressEntity>,
        skillMasteryMap: Map<String, SkillMasteryEntity>,
        todayEpochDay: Long
    ): TutorRecommendation {
        val nextLesson = SessionBuilderEngine.selectNextLesson(worldSummaries, lessonProgressMap)

        // 1. Weak prerequisite remediation: if a prerequisite for the next lesson (or a currently weak skill) is struggling, fix the root first
        val weakPrereqs = findWeakPrerequisites(nextLesson.primarySkillId, skillMasteryMap)
        if (weakPrereqs.isNotEmpty()) {
            val prereq = weakPrereqs.first()
            val prereqLesson = CurriculumCatalog.allLessons.firstOrNull { it.primarySkillId == prereq.id } ?: nextLesson
            return TutorRecommendation(
                title = "Strengthen Foundation: ${prereq.name}",
                reason = "Your recent practice flagged uncertainty in ${prereq.name}, which directly supports ${nextLesson.title}. Tightening it first prevents repeating errors.",
                actionLabel = "Drill Foundation (${prereqLesson.estimatedMinutes}m)",
                targetLessonId = prereqLesson.id,
                targetSkillId = prereq.id,
                recommendedStage = ExerciseStage.GUIDED_PRACTICE,
                isPrerequisiteRemediation = true
            )
        }

        // 2. Delayed mastery check due
        val delayedCandidate = skillMasteryMap.values
            .filter { it.delayedCheckPending && it.nextReviewEpochDay <= todayEpochDay }
            .sortedBy { it.nextReviewEpochDay }
            .firstOrNull()
        if (delayedCandidate != null) {
            val skill = CurriculumCatalog.getSkillById(delayedCandidate.skillId)
            val targetLesson = CurriculumCatalog.allLessons.firstOrNull { it.primarySkillId == delayedCandidate.skillId } ?: nextLesson
            return TutorRecommendation(
                title = "Delayed Mastery Check: ${skill?.name ?: delayedCandidate.skillId}",
                reason = "You showed strong consistency earlier — complete one unguided retention check after spacing to lock in Mastery.",
                actionLabel = "Verify Mastery",
                targetLessonId = targetLesson.id,
                targetSkillId = delayedCandidate.skillId,
                recommendedStage = ExerciseStage.UNFAMILIAR_APPLICATION,
                isDelayedMasteryCheck = true
            )
        }

        // 3. Overdue weak skill needing reinforcement
        val weakSkill = skillMasteryMap.values
            .filter { it.practiceCount > 0 && it.isWeak && it.nextReviewEpochDay <= todayEpochDay }
            .sortedWith(compareBy<SkillMasteryEntity> { it.lastConfidenceIndex }.thenBy { it.nextReviewEpochDay })
            .firstOrNull()
        if (weakSkill != null) {
            val skill = CurriculumCatalog.getSkillById(weakSkill.skillId)
            val targetLesson = CurriculumCatalog.allLessons.firstOrNull { it.primarySkillId == weakSkill.skillId } ?: nextLesson
            return TutorRecommendation(
                title = "Reinforce Weak Skill: ${skill?.name ?: weakSkill.skillId}",
                reason = "Marked difficult or low-confidence recently. A focused repeat at Guided/Independent stage will rebuild control.",
                actionLabel = "Practice Weakness",
                targetLessonId = targetLesson.id,
                targetSkillId = weakSkill.skillId,
                recommendedStage = recommendedStageForSkill(weakSkill),
                isWeakSkillReview = true
            )
        }

        // 4. Forward structured curriculum lesson
        val existingSkill = skillMasteryMap[nextLesson.primarySkillId]
        val stage = recommendedStageForSkill(existingSkill)
        val reason = if (existingSkill == null || existingSkill.practiceCount == 0) {
            "New concept ready for your sketchbook: starts with Understand -> Observe -> Deconstruct before guided drills."
        } else {
            "Continue progressing at ${stage.displayName} level based on your prior confidence."
        }

        return TutorRecommendation(
            title = nextLesson.title,
            reason = reason,
            actionLabel = "Start Lesson (~${nextLesson.estimatedMinutes}m)",
            targetLessonId = nextLesson.id,
            targetSkillId = nextLesson.primarySkillId,
            recommendedStage = stage
        )
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
