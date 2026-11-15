package com.example.domain.engine

import com.example.data.local.DailyActivityEntity
import com.example.domain.model.DifficultyRating
import com.example.domain.model.LearnerLevel
import kotlin.math.max
import kotlin.math.roundToInt

data class StreakSummary(
    val currentStreak: Int,
    val longestStreak: Int,
    val todayMinutes: Int,
    val todayXp: Int,
    val todayGoalMet: Boolean,
    val freezeUsedDays: Set<Long>,
    val remainingFreezes: Int,
    val newFreezeEarned: Boolean
)

object StreakAndXpEngine {

    private val titles = listOf(
        1 to "Apprentice Sketcher",
        2 to "Contour Observer",
        3 to "Form Builder",
        4 to "Line Craftsman",
        5 to "Shadow Student",
        6 to "Perspective Draftsman",
        7 to "Studio Naturalist",
        8 to "Figure Architect",
        9 to "Portraitist",
        10 to "Atelier Master"
    )

    fun computeLearnerLevel(totalXp: Int): LearnerLevel {
        // Progressive XP curve: level n requires n*120 + (n-1)*60
        var level = 1
        var accumulated = 0
        while (true) {
            val neededForThisLevel = 120 + (level - 1) * 80
            if (totalXp < accumulated + neededForThisLevel || level >= 30) {
                val title = titles.lastOrNull { level >= it.first }?.second ?: "Atelier Master"
                return LearnerLevel(
                    level = level,
                    title = title,
                    currentLevelXp = (totalXp - accumulated).coerceAtLeast(0),
                    nextLevelXp = neededForThisLevel,
                    totalXp = totalXp
                )
            }
            accumulated += neededForThisLevel
            level++
        }
    }

    /**
     * Awards XP thoughtfully while preventing meaningless XP farming from spamming already-done lessons.
     */
    fun calculateLessonXp(
        baseXp: Int,
        isFirstCompletion: Boolean,
        isSameDayRepeat: Boolean,
        difficulty: DifficultyRating,
        checklistRatio: Float,
        includeChallenge: Boolean
    ): Int {
        val completionFactor = when {
            isFirstCompletion -> 1.0f
            isSameDayRepeat -> 0.4f // Anti-farming reduction
            else -> 0.8f
        }
        val qualityFactor = (0.7f + 0.3f * checklistRatio.coerceIn(0f, 1f))
        val challengeBonus = if (includeChallenge) 15 else 0
        return (baseXp * completionFactor * qualityFactor).roundToInt() + difficulty.xpBonus + challengeBonus
    }

    fun calculateReviewXp(
        rating: DifficultyRating,
        checklistRatio: Float,
        isDue: Boolean
    ): Int {
        val base = if (isDue) 28 else 14
        val quality = (0.75f + 0.25f * checklistRatio.coerceIn(0f, 1f))
        return (base * quality).roundToInt() + rating.xpBonus
    }

    /**
     * A day counts toward a streak ONLY when meaningful drawing practice occurred
     * (at least 1 exercise/review completed AND minutesPracticed > 0).
     */
    fun isMeaningfulPracticeDay(day: DailyActivityEntity?): Boolean {
        if (day == null) return false
        return day.minutesPracticed > 0 && (day.exercisesCompleted > 0 || day.reviewsCompleted > 0)
    }

    fun computeStreak(
        activities: List<DailyActivityEntity>,
        todayEpochDay: Long,
        availableFreezes: Int,
        lastFreezeAwardStreak: Int
    ): StreakSummary {
        val byDay = activities.associateBy { it.epochDay }
        val today = byDay[todayEpochDay]
        val practicedToday = isMeaningfulPracticeDay(today)

        val freezeUsedDays = activities.filter { it.freezeUsed }.map { it.epochDay }.toMutableSet()
        var freezesLeft = availableFreezes

        // Count consecutive streak walking backward from today (or yesterday if not yet practiced today)
        var currentStreak = 0
        var cursor = if (practicedToday) todayEpochDay else todayEpochDay - 1
        var tempFreezes = freezesLeft

        while (cursor >= 0) {
            val act = byDay[cursor]
            if (isMeaningfulPracticeDay(act)) {
                currentStreak++
                cursor--
            } else if (act?.freezeUsed == true) {
                // Already frozen in record
                cursor--
            } else if (tempFreezes > 0 && currentStreak == 0 && cursor == todayEpochDay - 1 && !practicedToday) {
                // Yesterday missed, check if day before yesterday had active streak to bridge
                val dayBefore = byDay[cursor - 1]
                if (isMeaningfulPracticeDay(dayBefore)) {
                    tempFreezes--
                    freezeUsedDays.add(cursor)
                    cursor--
                } else {
                    break
                }
            } else if (tempFreezes > 0 && currentStreak > 0) {
                val prev = byDay[cursor - 1]
                if (isMeaningfulPracticeDay(prev)) {
                    tempFreezes--
                    freezeUsedDays.add(cursor)
                    cursor--
                } else {
                    break
                }
            } else {
                break
            }
        }

        // Compute historical longest streak across all recorded days
        var longest = currentStreak
        var running = 0
        val sortedDays = activities.filter { isMeaningfulPracticeDay(it) || it.freezeUsed }
            .sortedBy { it.epochDay }
        var prevDay: Long? = null
        for (entry in sortedDays) {
            if (prevDay == null) {
                running = if (isMeaningfulPracticeDay(entry)) 1 else 0
            } else if (entry.epochDay == prevDay + 1) {
                if (isMeaningfulPracticeDay(entry)) running++
            } else {
                running = if (isMeaningfulPracticeDay(entry)) 1 else 0
            }
            prevDay = entry.epochDay
            longest = max(longest, running)
        }

        val earnedMilestoneFreeze = currentStreak > 0 &&
            currentStreak % 7 == 0 &&
            currentStreak > lastFreezeAwardStreak &&
            tempFreezes < 3

        if (earnedMilestoneFreeze) {
            freezesLeft = (tempFreezes + 1).coerceAtMost(3)
        } else {
            freezesLeft = tempFreezes
        }

        return StreakSummary(
            currentStreak = currentStreak,
            longestStreak = longest,
            todayMinutes = today?.minutesPracticed ?: 0,
            todayXp = today?.xpEarned ?: 0,
            todayGoalMet = today?.goalMet ?: false,
            freezeUsedDays = freezeUsedDays,
            remainingFreezes = freezesLeft,
            newFreezeEarned = earnedMilestoneFreeze
        )
    }
}
