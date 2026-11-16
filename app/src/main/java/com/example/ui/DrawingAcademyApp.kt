package com.example.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Route
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Replay
import androidx.compose.material.icons.outlined.Route
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.data.curriculum.CurriculumCatalog
import com.example.domain.model.SessionMode
import com.example.ui.components.CompletionCelebrationDialog
import com.example.ui.screens.ArtGlossaryScreen
import com.example.ui.screens.CurriculumMapScreen
import com.example.ui.screens.GuidedSessionScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LearnScreen
import com.example.ui.screens.LessonDetailScreen
import com.example.ui.screens.MilestoneProjectScreen
import com.example.ui.screens.MistakeLibraryScreen
import com.example.ui.screens.ObservationChallengesScreen
import com.example.ui.screens.PracticeLibraryScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.ProgressScreen
import com.example.ui.screens.ReviewScreen
import com.example.ui.screens.SketchbookJournalScreen
import com.example.ui.screens.VisualLibraryScreen
import com.example.ui.theme.DrawingAcademyTheme
import com.example.viewmodel.AcademyViewModel

object AcademyRoutes {
    const val HOME = "home"
    const val LEARN = "learn"
    const val REVIEW = "review"
    const val PROGRESS = "progress"
    const val PROFILE = "profile"

    const val LESSON = "lesson/{lessonId}"
    const val SESSION = "session/{mode}"
    const val MILESTONE = "milestone/{worldNumber}"
    const val PRACTICE_LIBRARY = "practice_library"
    const val VISUAL_LIBRARY = "visual_library"
    const val OBSERVATIONS = "observations"
    const val MISTAKE_LIBRARY = "mistake_library"
    const val GLOSSARY = "glossary"
    const val JOURNAL = "journal"
    const val CURRICULUM_MAP = "curriculum_map"

    fun lesson(lessonId: String) = "lesson/$lessonId"
    fun session(mode: SessionMode) = "session/${mode.name}"
    fun milestone(worldNumber: Int) = "milestone/$worldNumber"
}

private data class TopLevelDestination(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

private val topLevelDestinations = listOf(
    TopLevelDestination(AcademyRoutes.HOME, "Home", Icons.Filled.Home, Icons.Outlined.Home),
    TopLevelDestination(AcademyRoutes.LEARN, "Learn", Icons.Filled.Route, Icons.Outlined.Route),
    TopLevelDestination(AcademyRoutes.REVIEW, "Review", Icons.Filled.Replay, Icons.Outlined.Replay),
    TopLevelDestination(AcademyRoutes.PROGRESS, "Progress", Icons.Filled.BarChart, Icons.Outlined.BarChart),
    TopLevelDestination(AcademyRoutes.PROFILE, "Profile", Icons.Filled.Person, Icons.Outlined.Person)
)

@Composable
fun DrawingAcademyApp(
    viewModel: AcademyViewModel
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(state.statusMessage) {
        val msg = state.statusMessage
        if (msg != null) {
            snackbarHostState.showSnackbar(msg)
            viewModel.clearStatusMessage()
        }
    }

    DrawingAcademyTheme(themePreference = state.preferences.themePreference) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val isTopLevel = topLevelDestinations.any { it.route == currentRoute }

        fun navigateTopLevel(route: String) {
            navController.navigate(route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val useNavigationRail = maxWidth >= 680.dp

            Scaffold(
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                bottomBar = {
                    if (isTopLevel && !useNavigationRail) {
                        NavigationBar {
                            topLevelDestinations.forEach { dest ->
                                val selected = currentRoute == dest.route
                                NavigationBarItem(
                                    selected = selected,
                                    onClick = { navigateTopLevel(dest.route) },
                                    icon = {
                                        val badgeCount = if (dest.route == AcademyRoutes.REVIEW) state.dueSkills.size else 0
                                        BadgedBox(
                                            badge = {
                                                if (badgeCount > 0) {
                                                    Badge { Text("$badgeCount") }
                                                }
                                            }
                                        ) {
                                            Icon(
                                                imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                                contentDescription = dest.label
                                            )
                                        }
                                    },
                                    label = { Text(dest.label) },
                                    modifier = Modifier.testTag("nav_tab_${dest.route}")
                                )
                            }
                        }
                    }
                }
            ) { innerPadding ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    if (isTopLevel && useNavigationRail) {
                        NavigationRail {
                            topLevelDestinations.forEach { dest ->
                                val selected = currentRoute == dest.route
                                NavigationRailItem(
                                    selected = selected,
                                    onClick = { navigateTopLevel(dest.route) },
                                    icon = {
                                        val badgeCount = if (dest.route == AcademyRoutes.REVIEW) state.dueSkills.size else 0
                                        BadgedBox(
                                            badge = {
                                                if (badgeCount > 0) {
                                                    Badge { Text("$badgeCount") }
                                                }
                                            }
                                        ) {
                                            Icon(
                                                imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                                contentDescription = dest.label
                                            )
                                        }
                                    },
                                    label = { Text(dest.label) },
                                    modifier = Modifier.testTag("rail_tab_${dest.route}")
                                )
                            }
                        }
                    }

                    Box(modifier = Modifier.weight(1f).fillMaxSize()) {
                        NavHost(
                            navController = navController,
                            startDestination = AcademyRoutes.HOME
                        ) {
                            composable(AcademyRoutes.HOME) {
                                HomeScreen(
                                    state = state,
                                    onOpenLesson = { lessonId ->
                                        viewModel.resetTimer()
                                        navController.navigate(AcademyRoutes.lesson(lessonId))
                                    },
                                    onStartGuidedSession = { mode ->
                                        viewModel.resetTimer()
                                        navController.navigate(AcademyRoutes.session(mode))
                                    },
                                    onOpenReviewTab = { navigateTopLevel(AcademyRoutes.REVIEW) },
                                    onOpenObservations = { navController.navigate(AcademyRoutes.OBSERVATIONS) },
                                    onOpenCurriculumMap = { navController.navigate(AcademyRoutes.CURRICULUM_MAP) },
                                    onOpenVisualLibrary = { navController.navigate(AcademyRoutes.VISUAL_LIBRARY) }
                                )
                            }

                            composable(AcademyRoutes.LEARN) {
                                LearnScreen(
                                    state = state,
                                    onOpenLesson = { lessonId ->
                                        viewModel.resetTimer()
                                        navController.navigate(AcademyRoutes.lesson(lessonId))
                                    },
                                    onOpenMilestone = { worldNum ->
                                        viewModel.resetTimer()
                                        navController.navigate(AcademyRoutes.milestone(worldNum))
                                    },
                                    onOpenPracticeLibrary = { navController.navigate(AcademyRoutes.PRACTICE_LIBRARY) },
                                    onOpenObservations = { navController.navigate(AcademyRoutes.OBSERVATIONS) },
                                    onOpenCurriculumMap = { navController.navigate(AcademyRoutes.CURRICULUM_MAP) },
                                    onOpenVisualLibrary = { navController.navigate(AcademyRoutes.VISUAL_LIBRARY) }
                                )
                            }

                            composable(AcademyRoutes.REVIEW) {
                                ReviewScreen(
                                    state = state,
                                    onCompleteReview = viewModel::completeSkillReview,
                                    onToggleTimer = {
                                        if (state.timerRunning) viewModel.pauseTimer() else viewModel.startTimer()
                                    },
                                    onResetTimer = viewModel::resetTimer,
                                    onOpenMistakeLibrary = { navController.navigate(AcademyRoutes.MISTAKE_LIBRARY) },
                                    onOpenGlossary = { navController.navigate(AcademyRoutes.GLOSSARY) }
                                )
                            }

                            composable(AcademyRoutes.PROGRESS) {
                                ProgressScreen(
                                    state = state,
                                    onOpenJournal = { navController.navigate(AcademyRoutes.JOURNAL) }
                                )
                            }

                            composable(AcademyRoutes.PROFILE) {
                                ProfileScreen(
                                    state = state,
                                    onSetDailyGoal = viewModel::setDailyGoalMinutes,
                                    onSetWeeklyGoal = viewModel::setWeeklyGoalSessions,
                                    onSetTheme = viewModel::setThemePreference,
                                    onUpdateNotifications = viewModel::updateNotificationSettings,
                                    onExportBackup = viewModel::exportBackup,
                                    onImportBackup = viewModel::importBackup,
                                    onResetProgress = viewModel::resetAllProgress
                                )
                            }

                            composable(
                                route = AcademyRoutes.LESSON,
                                arguments = listOf(navArgument("lessonId") { type = NavType.StringType })
                            ) { backStackEntry ->
                                val lessonId = backStackEntry.arguments?.getString("lessonId") ?: ""
                                val lesson = CurriculumCatalog.getLessonById(lessonId) ?: state.nextLesson
                                LessonDetailScreen(
                                    lesson = lesson,
                                    state = state,
                                    onBack = {
                                        viewModel.resetTimer()
                                        navController.popBackStack()
                                    },
                                    onToggleTimer = {
                                        if (state.timerRunning) viewModel.pauseTimer() else viewModel.startTimer()
                                    },
                                    onResetTimer = viewModel::resetTimer,
                                    onCompleteLesson = { rating, ratio, includeCh, reflection, improve, confidence ->
                                        viewModel.completeLesson(
                                            lesson = lesson,
                                            rating = rating,
                                            checklistRatio = ratio,
                                            includeChallenge = includeCh,
                                            reflectionNote = reflection,
                                            needsImprovementNote = improve,
                                            confidence = confidence
                                        )
                                        navController.popBackStack()
                                    }
                                )
                            }

                            composable(
                                route = AcademyRoutes.SESSION,
                                arguments = listOf(navArgument("mode") { type = NavType.StringType })
                            ) { backStackEntry ->
                                val modeName = backStackEntry.arguments?.getString("mode") ?: SessionMode.QUICK_10_15.name
                                val mode = runCatching { SessionMode.valueOf(modeName) }.getOrDefault(SessionMode.QUICK_10_15)
                                val plan = if (mode == SessionMode.DEEP_20_30) {
                                    state.deepSessionPlan
                                } else {
                                    state.quickSessionPlan
                                }
                                if (plan != null) {
                                    GuidedSessionScreen(
                                        plan = plan,
                                        state = state,
                                        onBack = {
                                            viewModel.resetTimer()
                                            navController.popBackStack()
                                        },
                                        onToggleTimer = {
                                            if (state.timerRunning) viewModel.pauseTimer() else viewModel.startTimer()
                                        },
                                        onResetTimer = viewModel::resetTimer,
                                        onCompleteSession = { rating, ratio, reflection, improve, confidence ->
                                            viewModel.completeGuidedSession(
                                                plan = plan,
                                                rating = rating,
                                                checklistRatio = ratio,
                                                reflectionNote = reflection,
                                                needsImprovementNote = improve,
                                                confidence = confidence
                                            )
                                            navController.popBackStack()
                                        }
                                    )
                                }
                            }

                            composable(
                                route = AcademyRoutes.MILESTONE,
                                arguments = listOf(navArgument("worldNumber") { type = NavType.IntType })
                            ) { backStackEntry ->
                                val worldNum = backStackEntry.arguments?.getInt("worldNumber") ?: 1
                                val world = CurriculumCatalog.getWorldByNumber(worldNum) ?: CurriculumCatalog.worlds.first()
                                MilestoneProjectScreen(
                                    project = world.milestoneProject,
                                    state = state,
                                    onBack = {
                                        viewModel.resetTimer()
                                        navController.popBackStack()
                                    },
                                    onToggleTimer = {
                                        if (state.timerRunning) viewModel.pauseTimer() else viewModel.startTimer()
                                    },
                                    onResetTimer = viewModel::resetTimer,
                                    onCompleteMilestone = { minutes, notes ->
                                        viewModel.completeMilestone(world.milestoneProject, minutes, notes)
                                        navController.popBackStack()
                                    }
                                )
                            }

                            composable(AcademyRoutes.PRACTICE_LIBRARY) {
                                PracticeLibraryScreen(
                                    onBack = { navController.popBackStack() },
                                    onOpenLesson = { lessonId ->
                                        viewModel.resetTimer()
                                        navController.navigate(AcademyRoutes.lesson(lessonId))
                                    }
                                )
                            }

                            composable(AcademyRoutes.OBSERVATIONS) {
                                ObservationChallengesScreen(
                                    state = state,
                                    onBack = {
                                        viewModel.resetTimer()
                                        navController.popBackStack()
                                    },
                                    onToggleTimer = {
                                        if (state.timerRunning) viewModel.pauseTimer() else viewModel.startTimer()
                                    },
                                    onResetTimer = viewModel::resetTimer,
                                    onCompleteChallenge = viewModel::completeObservationChallenge
                                )
                            }

                            composable(AcademyRoutes.MISTAKE_LIBRARY) {
                                MistakeLibraryScreen(
                                    onBack = { navController.popBackStack() },
                                    onOpenLesson = { lessonId ->
                                        viewModel.resetTimer()
                                        navController.navigate(AcademyRoutes.lesson(lessonId))
                                    }
                                )
                            }

                            composable(AcademyRoutes.GLOSSARY) {
                                ArtGlossaryScreen(onBack = { navController.popBackStack() })
                            }

                            composable(AcademyRoutes.JOURNAL) {
                                SketchbookJournalScreen(
                                    state = state,
                                    onBack = { navController.popBackStack() },
                                    onAddEntry = viewModel::addJournalEntry,
                                    onDeleteEntry = viewModel::deleteJournalEntry
                                )
                            }

                            composable(AcademyRoutes.CURRICULUM_MAP) {
                                CurriculumMapScreen(
                                    state = state,
                                    onBack = { navController.popBackStack() },
                                    onOpenWorldMilestone = { worldNum ->
                                        viewModel.resetTimer()
                                        navController.navigate(AcademyRoutes.milestone(worldNum))
                                    }
                                )
                            }

                            composable(AcademyRoutes.VISUAL_LIBRARY) {
                                VisualLibraryScreen(
                                    onBack = { navController.popBackStack() },
                                    onOpenLesson = { lessonId ->
                                        viewModel.resetTimer()
                                        navController.navigate(AcademyRoutes.lesson(lessonId))
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        state.lastCompletionResult?.let { result ->
            CompletionCelebrationDialog(
                result = result,
                onDismiss = viewModel::dismissCompletionResult
            )
        }
    }
}
