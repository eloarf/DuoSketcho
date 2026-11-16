package com.example.domain.engine

import com.example.data.curriculum.CurriculumCatalog
import com.example.data.local.LessonProgressEntity
import com.example.data.local.SkillMasteryEntity
import com.example.domain.model.ExerciseStage
import com.example.domain.model.GuidedSessionPlan
import com.example.domain.model.GuidedSessionStep
import com.example.domain.model.Lesson
import com.example.domain.model.SessionMode
import com.example.domain.model.WorldProgressSummary

object SessionBuilderEngine {

    private data class WarmupTemplate(
        val title: String,
        val instructions: String,
        val reps: String,
        val skillId: String
    )

    private val warmups = listOf(
        WarmupTemplate(
            title = "Shoulder Dot-to-Dot & Ghosted Lines",
            instructions = "Plot 8 pairs of dots across a scrap sheet. Hover 3 times from your shoulder, then pull 1 confident straight stroke per pair without wrist wobble.",
            reps = "8 long straight lines + 8 parallel ghosted lines",
            skillId = "sk_stroke_conf"
        ),
        WarmupTemplate(
            title = "Aligned Ellipses & Minor Axis Drill",
            instructions = "Draw 3 tilted centerline axes, then ghost 3 rotations from your shoulder and draw through 2 clean passes of narrow, medium, and wide ellipses.",
            reps = "12 ellipses across 3 minor axes",
            skillId = "sk_spheres_cyl"
        ),
        WarmupTemplate(
            title = "5-Step Controlled Hatching Strip",
            instructions = "Draw 5 small boxes side by side and fill them from light whisper-thin (#1) to dense layered cross-hatching (#8), lifting your pencil after each stroke.",
            reps = "1 five-step tonal hatch bar",
            skillId = "sk_hatching"
        ),
        WarmupTemplate(
            title = "90-Second Blind Contour Wake-Up",
            instructions = "Pick your non-drawing hand or mug on the desk. Keep your eyes locked 100% on its outer rim and trace slowly at ant-speed without peeking down.",
            reps = "2 continuous blind contour passes",
            skillId = "sk_eye_hand"
        )
    )

    fun selectNextLesson(
        worldSummaries: List<WorldProgressSummary>,
        lessonProgressMap: Map<String, LessonProgressEntity>
    ): Lesson {
        val unlockedWorlds = worldSummaries.filter { it.isUnlocked }.sortedBy { it.world.number }
        for (summary in unlockedWorlds) {
            val uncompleted = summary.world.units
                .sortedBy { it.orderInWorld }
                .flatMap { unit -> unit.lessons.sortedBy { it.orderInUnit } }
                .firstOrNull { (lessonProgressMap[it.id]?.completedCount ?: 0) == 0 }
            if (uncompleted != null) return uncompleted
        }
        val lastUnlocked = unlockedWorlds.lastOrNull() ?: worldSummaries.first()
        return lastUnlocked.world.units.first().lessons.first()
    }

    fun buildSessionPlan(
        mode: SessionMode,
        nextLesson: Lesson,
        skillMasteries: List<SkillMasteryEntity>,
        todayEpochDay: Long,
        includeOptionalChallenge: Boolean = mode.includeOptionalChallenge
    ): GuidedSessionPlan {
        val steps = mutableListOf<GuidedSessionStep>()
        var idx = 1
        val masteryMap = skillMasteries.associateBy { it.skillId }

        // 1. Short Warm-up
        val warmup = warmups[(todayEpochDay % warmups.size).toInt().coerceAtLeast(0)]
        steps.add(
            GuidedSessionStep(
                stepIndex = idx++,
                phaseLabel = "1. Warm-Up",
                title = warmup.title,
                subtitle = "Loosen shoulder & calibrate eye-hand focus",
                instructions = warmup.instructions,
                repetitions = warmup.reps,
                durationMinutes = if (mode == SessionMode.QUICK_10_15) 2 else 3,
                skillId = warmup.skillId,
                lessonId = null
            )
        )

        // 2. Concept Briefing
        steps.add(
            GuidedSessionStep(
                stepIndex = idx++,
                phaseLabel = "2. New Lesson • Understand",
                title = nextLesson.title,
                subtitle = nextLesson.learningObjective,
                instructions = "${nextLesson.explanation}\n\nDeconstruct:\n" +
                    nextLesson.steps.mapIndexed { i, s -> "${i + 1}. $s" }.joinToString("\n"),
                repetitions = "Materials: ${nextLesson.requiredMaterials.joinToString(", ")}",
                durationMinutes = 2,
                skillId = nextLesson.primarySkillId,
                lessonId = nextLesson.id
            )
        )

        // 3. Adaptive Drills from Lesson (Stage 1 -> Stage 2 -> Stage 3)
        val recommendedStage = SpacedRepetitionEngine.recommendedStageForSkill(masteryMap[nextLesson.primarySkillId])
        val drillsToInclude = when {
            mode == SessionMode.QUICK_10_15 && recommendedStage == ExerciseStage.UNFAMILIAR_APPLICATION ->
                listOf(nextLesson.exercises.first(), nextLesson.exercises.last())
            mode == SessionMode.QUICK_10_15 ->
                nextLesson.exercises.take(2)
            else ->
                nextLesson.exercises
        }

        drillsToInclude.forEachIndexed { drillIdx, ex ->
            val adjustedMin = if (mode == SessionMode.QUICK_10_15) {
                ex.estimatedMinutes.coerceAtMost(4)
            } else {
                ex.estimatedMinutes
            }
            val fullInstructions = buildString {
                append(ex.instructions)
                if (ex.techniqueFocus.isNotBlank()) {
                    append("\n\nFocus: ${ex.techniqueFocus}")
                }
                if (ex.mistakesToAvoid.isNotBlank() && !ex.isUnguided) {
                    append("\nWatch out: ${ex.mistakesToAvoid}")
                }
            }
            steps.add(
                GuidedSessionStep(
                    stepIndex = idx++,
                    phaseLabel = "3. Guided Exercise ${drillIdx + 1} • ${ex.stage.displayName}",
                    title = ex.title,
                    subtitle = if (ex.isUnguided) "Unguided transfer • ${ex.repetitions}" else "Sketchbook drill • ${ex.repetitions}",
                    instructions = fullInstructions,
                    repetitions = ex.repetitions,
                    durationMinutes = adjustedMin,
                    skillId = ex.skillId,
                    lessonId = nextLesson.id,
                    isUnguided = ex.isUnguided,
                    stage = ex.stage
                )
            )
        }

        // 4. Prerequisite Remediation OR Spaced-Repetition / Delayed Check Review
        val weakPrerequisites = SpacedRepetitionEngine.findWeakPrerequisites(nextLesson.primarySkillId, masteryMap)
        val dueReviews = skillMasteries
            .filter { it.skillId != nextLesson.primarySkillId && SpacedRepetitionEngine.isSkillDue(it, todayEpochDay) }
            .sortedWith(
                compareByDescending<SkillMasteryEntity> { it.delayedCheckPending }
                    .thenByDescending { it.isWeak }
                    .thenBy { it.nextReviewEpochDay }
            )

        val reviewTargets = if (dueReviews.isNotEmpty()) {
            dueReviews.take(if (mode == SessionMode.QUICK_10_15) 1 else 2)
        } else {
            skillMasteries
                .filter { it.practiceCount > 0 && it.skillId != nextLesson.primarySkillId }
                .sortedBy { it.lastPracticedEpochDay }
                .take(1)
        }

        var addedReviews = 0
        if (weakPrerequisites.isNotEmpty()) {
            val prereq = weakPrerequisites.first()
            val prereqLesson = CurriculumCatalog.allLessons.firstOrNull { it.primarySkillId == prereq.id }
            val prereqEx = prereqLesson?.exercises?.firstOrNull()
            steps.add(
                GuidedSessionStep(
                    stepIndex = idx++,
                    phaseLabel = "4. Prerequisite Repair",
                    title = "Tighten Foundation: ${prereq.name}",
                    subtitle = "Supports ${nextLesson.title} — fix core error before rushing forward",
                    instructions = prereqEx?.instructions ?: prereq.description,
                    repetitions = prereqEx?.repetitions ?: "1 focused foundational plate",
                    durationMinutes = 3,
                    skillId = prereq.id,
                    lessonId = prereqLesson?.id ?: nextLesson.id,
                    isReview = true,
                    isPrerequisiteRemediation = true,
                    stage = ExerciseStage.GUIDED_PRACTICE
                )
            )
            addedReviews++
        }

        if (reviewTargets.isEmpty() && addedReviews == 0) {
            steps.add(
                GuidedSessionStep(
                    stepIndex = idx++,
                    phaseLabel = "4. Unfamiliar Audit",
                    title = "1-Minute Proportion & Contour Check",
                    subtitle = "Re-check your fresh sketch without reference hints",
                    instructions = "Hold your pencil vertically at arm's length and verify two major alignment points and one negative space cutout on your own drawing.",
                    repetitions = "1 complete proportional audit",
                    durationMinutes = 2,
                    skillId = "sk_sight_prop",
                    lessonId = nextLesson.id,
                    isReview = true,
                    isUnguided = true,
                    stage = ExerciseStage.UNFAMILIAR_APPLICATION
                )
            )
        } else {
            val remainingReviewSlots = (if (mode == SessionMode.QUICK_10_15) 1 else 2) - addedReviews
            reviewTargets
                .filter { target -> weakPrerequisites.none { it.id == target.skillId } }
                .take(remainingReviewSlots.coerceAtLeast(0))
                .forEachIndexed { rIdx, mastery ->
                    val skill = CurriculumCatalog.getSkillById(mastery.skillId)
                    val matchingLesson = CurriculumCatalog.allLessons.firstOrNull { it.primarySkillId == mastery.skillId }
                    val targetStage = SpacedRepetitionEngine.recommendedStageForSkill(mastery)
                    val exercise = when (targetStage) {
                        ExerciseStage.GUIDED_PRACTICE -> matchingLesson?.exercises?.getOrNull(0)
                        ExerciseStage.INDEPENDENT_PRACTICE -> matchingLesson?.exercises?.getOrNull(1)
                        ExerciseStage.UNFAMILIAR_APPLICATION -> matchingLesson?.exercises?.getOrNull(2)
                    } ?: matchingLesson?.exercises?.firstOrNull()

                    steps.add(
                        GuidedSessionStep(
                            stepIndex = idx++,
                            phaseLabel = when {
                                mastery.delayedCheckPending -> "4. Delayed Mastery Check"
                                reviewTargets.size > 1 -> "4. Interleaved Review ${rIdx + 1}"
                                else -> "4. Interleaved Review"
                            },
                            title = "Review: ${skill?.name ?: mastery.skillId}",
                            subtitle = when {
                                mastery.delayedCheckPending -> "Unguided retention test before Mastery lock"
                                mastery.isWeak -> "Weak-skill reinforcement • ${targetStage.displayName}"
                                else -> "Spaced check in fresh context • ${targetStage.displayName}"
                            },
                            instructions = exercise?.instructions
                                ?: (skill?.description ?: "Complete a focused 3-minute recall study in your sketchbook."),
                            repetitions = exercise?.repetitions ?: "1 focused recall plate",
                            durationMinutes = if (mode == SessionMode.QUICK_10_15) 3 else 4,
                            skillId = mastery.skillId,
                            lessonId = matchingLesson?.id,
                            isReview = true,
                            isUnguided = mastery.delayedCheckPending || targetStage == ExerciseStage.UNFAMILIAR_APPLICATION,
                            stage = targetStage
                        )
                    )
                }
        }

        // 5. Optional Cumulative Harder Challenge
        if (includeOptionalChallenge) {
            val ch = nextLesson.optionalChallenge
            steps.add(
                GuidedSessionStep(
                    stepIndex = idx,
                    phaseLabel = "5. Cumulative Challenge",
                    title = ch.title,
                    subtitle = nextLesson.cumulativeSkillsLabel.ifBlank { "Stretch goal for deeper consolidation" },
                    instructions = ch.instructions,
                    repetitions = ch.repetitions,
                    durationMinutes = ch.estimatedMinutes.coerceAtMost(8),
                    skillId = ch.skillId,
                    lessonId = nextLesson.id,
                    isOptionalChallenge = true,
                    isUnguided = true,
                    stage = ExerciseStage.UNFAMILIAR_APPLICATION
                )
            )
        }

        val totalMinutes = steps.sumOf { it.durationMinutes }
        val estimatedXp = nextLesson.xpReward +
            (reviewTargets.size * 22) +
            (if (includeOptionalChallenge) 15 else 0) +
            10

        return GuidedSessionPlan(
            mode = mode,
            steps = steps,
            totalEstimatedMinutes = totalMinutes,
            estimatedXp = estimatedXp
        )
    }
}
