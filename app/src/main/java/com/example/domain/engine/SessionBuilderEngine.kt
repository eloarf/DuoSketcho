package com.example.domain.engine

import com.example.data.curriculum.CurriculumCatalog
import com.example.data.local.LessonProgressEntity
import com.example.data.local.SkillMasteryEntity
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
        // Fallback: lowest-completed or latest unlocked lesson
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

        // 2. New Lesson Concept Briefing
        steps.add(
            GuidedSessionStep(
                stepIndex = idx++,
                phaseLabel = "2. New Lesson",
                title = nextLesson.title,
                subtitle = nextLesson.learningObjective,
                instructions = "${nextLesson.explanation}\n\nSteps:\n" +
                    nextLesson.steps.mapIndexed { i, s -> "${i + 1}. $s" }.joinToString("\n"),
                repetitions = "Read & prepare: ${nextLesson.requiredMaterials.joinToString(", ")}",
                durationMinutes = 2,
                skillId = nextLesson.primarySkillId,
                lessonId = nextLesson.id
            )
        )

        // 3. Guided Exercises from the lesson
        val drillsToInclude = if (mode == SessionMode.QUICK_10_15) {
            nextLesson.exercises.take(2)
        } else {
            nextLesson.exercises
        }
        drillsToInclude.forEachIndexed { drillIdx, ex ->
            val adjustedMin = if (mode == SessionMode.QUICK_10_15) {
                ex.estimatedMinutes.coerceAtMost(4)
            } else {
                ex.estimatedMinutes
            }
            steps.add(
                GuidedSessionStep(
                    stepIndex = idx++,
                    phaseLabel = "3. Guided Exercise ${drillIdx + 1}",
                    title = ex.title,
                    subtitle = "Physical notebook drill (${ex.repetitions})",
                    instructions = ex.instructions,
                    repetitions = ex.repetitions,
                    durationMinutes = adjustedMin,
                    skillId = ex.skillId,
                    lessonId = nextLesson.id
                )
            )
        }

        // 4. Spaced-Repetition Review of Older Skills
        val dueReviews = skillMasteries
            .filter { it.skillId != nextLesson.primarySkillId && SpacedRepetitionEngine.isSkillDue(it, todayEpochDay) }
            .sortedWith(compareByDescending<SkillMasteryEntity> { it.isWeak }.thenBy { it.nextReviewEpochDay })

        val reviewTargets = if (dueReviews.isNotEmpty()) {
            dueReviews.take(if (mode == SessionMode.QUICK_10_15) 1 else 2)
        } else {
            skillMasteries
                .filter { it.practiceCount > 0 && it.skillId != nextLesson.primarySkillId }
                .sortedBy { it.lastPracticedEpochDay }
                .take(1)
        }

        if (reviewTargets.isEmpty()) {
            // Day-1 fallback: reinforce sighting/contour observation alongside today's new concept
            steps.add(
                GuidedSessionStep(
                    stepIndex = idx++,
                    phaseLabel = "4. Reinforcement Review",
                    title = "1-Minute Proportion & Contour Check",
                    subtitle = "Re-check your fresh sketch using plumb lines and negative space",
                    instructions = "Hold your pencil vertically at arm's length and verify two major alignment points and one negative space cutout on your own drawing.",
                    repetitions = "1 complete proportional audit",
                    durationMinutes = 2,
                    skillId = "sk_sight_prop",
                    lessonId = nextLesson.id,
                    isReview = true
                )
            )
        } else {
            reviewTargets.forEachIndexed { rIdx, mastery ->
                val skill = CurriculumCatalog.getSkillById(mastery.skillId)
                val matchingLesson = CurriculumCatalog.allLessons.firstOrNull { it.primarySkillId == mastery.skillId }
                val reviewExercise = matchingLesson?.exercises?.firstOrNull()
                steps.add(
                    GuidedSessionStep(
                        stepIndex = idx++,
                        phaseLabel = if (reviewTargets.size > 1) "4. Skill Review ${rIdx + 1}" else "4. Skill Review",
                        title = "Review: ${skill?.name ?: mastery.skillId}",
                        subtitle = if (mastery.isWeak) "Weak-skill reinforcement drill" else "Spaced-repetition retention check",
                        instructions = reviewExercise?.instructions
                            ?: (skill?.description ?: "Complete a focused 3-minute recall study in your sketchbook."),
                        repetitions = reviewExercise?.repetitions ?: "1 focused recall plate",
                        durationMinutes = if (mode == SessionMode.QUICK_10_15) 3 else 4,
                        skillId = mastery.skillId,
                        lessonId = matchingLesson?.id,
                        isReview = true
                    )
                )
            }
        }

        // 5. Optional Harder Challenge
        if (includeOptionalChallenge) {
            val ch = nextLesson.optionalChallenge
            steps.add(
                GuidedSessionStep(
                    stepIndex = idx,
                    phaseLabel = "5. Optional Challenge",
                    title = ch.title,
                    subtitle = "Stretch goal for deeper skill consolidation",
                    instructions = ch.instructions,
                    repetitions = ch.repetitions,
                    durationMinutes = ch.estimatedMinutes.coerceAtMost(8),
                    skillId = ch.skillId,
                    lessonId = nextLesson.id,
                    isOptionalChallenge = true
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
