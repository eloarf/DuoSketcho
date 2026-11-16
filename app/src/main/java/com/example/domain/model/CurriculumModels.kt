package com.example.domain.model

enum class DiagramType {
    OBSERVATION_CONTOUR,
    NEGATIVE_SPACE,
    BASIC_FORMS_3D,
    CROSS_CONTOUR,
    LINE_CONTROL_GHOSTING,
    HATCHING_AND_STIPPLING,
    VALUE_SCALE_AND_SPHERE,
    CAST_SHADOW_LOGIC,
    PERSPECTIVE_1_2_3_POINT,
    STILL_LIFE_SIGHTING,
    TEXTURE_STUDIES,
    BOTANICAL_AND_ANIMAL,
    HUMAN_GESTURE_MANNEQUIN,
    LOOMIS_HEAD_PROPORTIONS,
    COMPOSITION_THIRDS,
    IMAGINATION_SYNTHESIS
}

enum class ExerciseStage(val displayName: String, val stageNumber: Int, val summary: String) {
    GUIDED_PRACTICE("Guided Practice", 1, "Follow structured cues and focus on core mechanics"),
    INDEPENDENT_PRACTICE("Independent Repetition", 2, "Vary scale, angle, or subject with lighter scaffolding"),
    UNFAMILIAR_APPLICATION("Independent Application", 3, "Apply the skill to an unfamiliar or unguided subject")
}

data class RecallQuestion(
    val prompt: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class SkillDefinition(
    val id: String,
    val name: String,
    val worldNumber: Int,
    val category: String,
    val description: String,
    val prerequisiteSkillIds: List<String> = emptyList()
)

data class MistakeCorrection(
    val mistake: String,
    val correction: String
)

data class PracticalExercise(
    val id: String,
    val title: String,
    val instructions: String,
    val repetitions: String,
    val estimatedMinutes: Int,
    val skillId: String,
    val isChallenge: Boolean = false,
    val stage: ExerciseStage = ExerciseStage.GUIDED_PRACTICE,
    val techniqueFocus: String = "",
    val mistakesToAvoid: String = "",
    val successCriteria: String = "",
    val harderVariation: String = "",
    val isUnguided: Boolean = false
)

data class Lesson(
    val id: String,
    val worldNumber: Int,
    val unitId: String,
    val orderInUnit: Int,
    val title: String,
    val subtitle: String,
    val learningObjective: String,
    val explanation: String,
    val whyItMatters: String,
    val requiredMaterials: List<String>,
    val steps: List<String>,
    val exercises: List<PracticalExercise>,
    val optionalChallenge: PracticalExercise,
    val commonMistakes: List<MistakeCorrection>,
    val selfAssessmentChecklist: List<String>,
    val completionCriteria: String,
    val estimatedMinutes: Int,
    val diagramType: DiagramType,
    val primarySkillId: String,
    val reinforcedSkillIds: List<String>,
    val xpReward: Int = 35,
    val recallQuestion: RecallQuestion,
    val prerequisiteSkillIds: List<String> = emptyList(),
    val cumulativeSkillsLabel: String = "",
    val diagramCaption: String = learningObjective
)

data class CurriculumUnit(
    val id: String,
    val worldNumber: Int,
    val orderInWorld: Int,
    val title: String,
    val summary: String,
    val lessons: List<Lesson>
)

data class MilestoneProject(
    val id: String,
    val worldNumber: Int,
    val title: String,
    val brief: String,
    val combinedSkills: List<String>,
    val requiredMaterials: List<String>,
    val phases: List<String>,
    val selfAssessmentChecklist: List<String>,
    val estimatedMinutes: Int,
    val xpReward: Int = 120
)

data class DrawingWorld(
    val number: Int,
    val id: String,
    val title: String,
    val tagline: String,
    val focusSummary: String,
    val units: List<CurriculumUnit>,
    val milestoneProject: MilestoneProject,
    val unlockRequirementSummary: String
)

data class MistakeLibraryEntry(
    val id: String,
    val worldNumber: Int,
    val worldTitle: String,
    val title: String,
    val symptom: String,
    val rootCause: String,
    val correctiveDrill: String,
    val relatedLessonId: String
)

data class GlossaryTerm(
    val id: String,
    val term: String,
    val category: String,
    val definition: String,
    val practicalTip: String
)

data class ObservationChallenge(
    val id: String,
    val title: String,
    val worldRecommended: Int,
    val subjectPrompt: String,
    val setupInstructions: String,
    val techniqueFocus: List<String>,
    val estimatedMinutes: Int,
    val xpReward: Int = 45
)
