package com.example.domain.engine

import com.example.data.curriculum.ReferenceLibraryData
import com.example.data.local.DailyActivityEntity
import com.example.data.local.LessonProgressEntity
import com.example.data.local.MilestoneProgressEntity
import com.example.data.local.SkillMasteryEntity
import com.example.domain.model.AchievementDefinition
import com.example.domain.model.MasteryLevel

object AchievementEngine {

    data class EvaluationInput(
        val currentStreak: Int,
        val longestStreak: Int,
        val lessonProgress: List<LessonProgressEntity>,
        val skillMasteries: List<SkillMasteryEntity>,
        val dailyActivities: List<DailyActivityEntity>,
        val milestones: List<MilestoneProgressEntity>,
        val totalJournalEntries: Int,
        val totalObservationCompletions: Int,
        val totalReviewsCompleted: Int,
        val totalExercisesCompleted: Int,
        val alreadyUnlockedIds: Set<String>
    )

    fun evaluateNewAchievements(input: EvaluationInput): List<AchievementDefinition> {
        val totalMinutes = input.dailyActivities.sumOf { it.minutesPracticed }
        val completedLessonsCount = input.lessonProgress.count { it.completedCount > 0 }
        val masteredSkillsCount = input.skillMasteries.count {
            it.masteryTierIndex >= MasteryLevel.MASTERED.tierIndex
        }
        val completedWorldMilestones = input.milestones.filter { it.completed }.map { it.worldNumber }.toSet()
        val bestStreak = maxOf(input.currentStreak, input.longestStreak)

        return ReferenceLibraryData.achievements.filter { def ->
            if (def.id in input.alreadyUnlockedIds) return@filter false
            when (def.id) {
                "ach_first_lesson" -> completedLessonsCount >= 1
                "ach_streak_3" -> bestStreak >= 3
                "ach_streak_7" -> bestStreak >= 7
                "ach_streak_14" -> bestStreak >= 14
                "ach_streak_30" -> bestStreak >= 30
                "ach_ex_25" -> input.totalExercisesCompleted >= 25
                "ach_ex_100" -> input.totalExercisesCompleted >= 100
                "ach_min_300" -> totalMinutes >= 300
                "ach_min_1200" -> totalMinutes >= 1200
                "ach_first_mastered" -> masteredSkillsCount >= 1
                "ach_five_mastered" -> masteredSkillsCount >= 5
                "ach_reviews_15" -> input.totalReviewsCompleted >= 15
                "ach_milestone_1" -> 1 in completedWorldMilestones
                "ach_milestone_4" -> 4 in completedWorldMilestones
                "ach_milestone_6" -> 6 in completedWorldMilestones
                "ach_milestone_9" -> 9 in completedWorldMilestones
                "ach_milestone_12" -> 12 in completedWorldMilestones
                "ach_journal_5" -> input.totalJournalEntries >= 5
                "ach_obs_5" -> input.totalObservationCompletions >= 5
                else -> false
            }
        }
    }
}
