package com.example.domain.model

enum class MasteryLevel(
    val tierIndex: Int,
    val displayName: String,
    val shortDescription: String
) {
    NOT_STARTED(0, "Not Started", "Not yet practiced"),
    INTRODUCED(1, "Introduced", "Initial lesson completed; needs spaced practice"),
    PRACTICING(2, "Practicing", "Building muscle memory through repetition"),
    DEVELOPING(3, "Developing", "Consistent execution emerging across sessions"),
    PROFICIENT(4, "Proficient", "Reliable control under varied subjects"),
    MASTERED(5, "Mastered", "Verified across delayed spaced checks")
}

enum class DifficultyRating(val label: String, val xpBonus: Int) {
    DIFFICULT("Difficult", 5),
    OKAY("Okay", 5),
    EASY("Easy", 5)
}

enum class ConfidenceLevel(val index: Int, val label: String, val shortLabel: String) {
    LOW(0, "Low Confidence", "Unsure"),
    MODERATE(1, "Somewhat Confident", "Growing"),
    HIGH(2, "Confident", "Solid")
}

enum class SessionMode(val label: String, val targetMinutes: Int, val includeOptionalChallenge: Boolean) {
    QUICK_10_15("Quick Session (10–15m)", 12, false),
    DEEP_20_30("Deep Session (20–30m)", 25, true)
}

data class LearnerLevel(
    val level: Int,
    val title: String,
    val currentLevelXp: Int,
    val nextLevelXp: Int,
    val totalXp: Int
)

data class AchievementDefinition(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val xpBonus: Int
)

data class GuidedSessionStep(
    val stepIndex: Int,
    val phaseLabel: String,
    val title: String,
    val subtitle: String,
    val instructions: String,
    val repetitions: String,
    val durationMinutes: Int,
    val skillId: String,
    val lessonId: String?,
    val isReview: Boolean = false,
    val isOptionalChallenge: Boolean = false,
    val isUnguided: Boolean = false,
    val isPrerequisiteRemediation: Boolean = false,
    val stage: ExerciseStage = ExerciseStage.GUIDED_PRACTICE
)

data class GuidedSessionPlan(
    val mode: SessionMode,
    val steps: List<GuidedSessionStep>,
    val totalEstimatedMinutes: Int,
    val estimatedXp: Int
)

data class TutorRecommendation(
    val title: String,
    val reason: String,
    val actionLabel: String,
    val targetLessonId: String,
    val targetSkillId: String,
    val recommendedStage: ExerciseStage,
    val isPrerequisiteRemediation: Boolean = false,
    val isDelayedMasteryCheck: Boolean = false,
    val isWeakSkillReview: Boolean = false
)

data class HonestEvaluationFeedback(
    val headline: String,
    val observations: List<String>,
    val nextStepAdvice: String,
    val prerequisiteAlert: String? = null
)

data class WeeklyReport(
    val sessionsLast7Days: Int,
    val minutesLast7Days: Int,
    val xpLast7Days: Int,
    val goalDaysMet: Int,
    val consistencyPercent: Int,
    val strongestSkills: List<String>,
    val weakestSkills: List<String>,
    val upcomingReviewsCount: Int
)

data class WorldProgressSummary(
    val world: DrawingWorld,
    val completedLessons: Int,
    val totalLessons: Int,
    val milestoneCompleted: Boolean,
    val masteredSkillsCount: Int,
    val totalSkillsCount: Int,
    val isUnlocked: Boolean,
    val gateProgressPercent: Int,
    val lockReason: String?
)
