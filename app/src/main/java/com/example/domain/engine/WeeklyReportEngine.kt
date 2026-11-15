package com.example.domain.engine

import com.example.data.curriculum.CurriculumCatalog
import com.example.data.local.DailyActivityEntity
import com.example.data.local.SkillMasteryEntity
import com.example.domain.model.WeeklyReport
import kotlin.math.roundToInt

object WeeklyReportEngine {

    fun buildReport(
        activities: List<DailyActivityEntity>,
        skillMasteries: List<SkillMasteryEntity>,
        todayEpochDay: Long,
        weeklyGoalSessions: Int
    ): WeeklyReport {
        val windowStart = todayEpochDay - 6L
        val last7Days = activities.filter { it.epochDay in windowStart..todayEpochDay }

        val sessions = last7Days.sumOf { it.sessionsCompleted }
        val minutes = last7Days.sumOf { it.minutesPracticed }
        val xp = last7Days.sumOf { it.xpEarned }
        val goalDaysMet = last7Days.count { it.goalMet || StreakAndXpEngine.isMeaningfulPracticeDay(it) }
        val target = weeklyGoalSessions.coerceAtLeast(1)
        val consistency = ((goalDaysMet.toFloat() / target.toFloat()) * 100f).roundToInt().coerceIn(0, 100)

        val practicedSkills = skillMasteries.filter { it.practiceCount > 0 }

        val strongest = practicedSkills
            .filter { !it.isWeak }
            .sortedWith(
                compareByDescending<SkillMasteryEntity> { it.masteryTierIndex }
                    .thenByDescending { it.bestChecklistRatio }
                    .thenByDescending { it.easeFactor }
            )
            .take(3)
            .map { CurriculumCatalog.getSkillById(it.skillId)?.name ?: it.skillId }

        val weakest = practicedSkills
            .filter { it.isWeak || it.masteryTierIndex <= 2 }
            .sortedWith(
                compareByDescending<SkillMasteryEntity> { it.isWeak }
                    .thenBy { it.masteryTierIndex }
                    .thenBy { it.bestChecklistRatio }
            )
            .take(3)
            .map { CurriculumCatalog.getSkillById(it.skillId)?.name ?: it.skillId }

        val upcomingReviews = practicedSkills.count {
            it.nextReviewEpochDay <= todayEpochDay + 7L || it.isWeak
        }

        return WeeklyReport(
            sessionsLast7Days = sessions,
            minutesLast7Days = minutes,
            xpLast7Days = xp,
            goalDaysMet = goalDaysMet,
            consistencyPercent = consistency,
            strongestSkills = strongest,
            weakestSkills = weakest,
            upcomingReviewsCount = upcomingReviews
        )
    }
}
