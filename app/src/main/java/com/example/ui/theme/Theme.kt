package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

enum class ThemePreference {
    SYSTEM,
    LIGHT,
    DARK
}

private val LightColorScheme = lightColorScheme(
    primary = BlueprintCobalt,
    onPrimary = BristolCard,
    primaryContainer = BlueprintCobaltContainer,
    onPrimaryContainer = BlueprintCobalt,
    secondary = AtelierSage,
    onSecondary = BristolCard,
    secondaryContainer = AtelierSageContainer,
    onSecondaryContainer = AtelierSage,
    tertiary = TerracottaFlame,
    onTertiary = BristolCard,
    tertiaryContainer = TerracottaContainer,
    onTertiaryContainer = TerracottaFlame,
    error = DustyCrimson,
    onError = BristolCard,
    errorContainer = DustyCrimsonContainer,
    onErrorContainer = DustyCrimson,
    background = CreamPaper,
    onBackground = IndiaInk,
    surface = BristolCard,
    onSurface = IndiaInk,
    surfaceVariant = DraftingSurface,
    onSurfaceVariant = GraphiteSlate,
    outline = SketchRule,
    outlineVariant = DraftingSurface
)

private val DarkColorScheme = darkColorScheme(
    primary = BlueprintCobaltLight,
    onPrimary = CharcoalBackground,
    primaryContainer = BlueprintCobaltDarkContainer,
    onPrimaryContainer = BlueprintCobaltLight,
    secondary = AtelierSageLight,
    onSecondary = CharcoalBackground,
    secondaryContainer = AtelierSageDarkContainer,
    onSecondaryContainer = AtelierSageLight,
    tertiary = TerracottaFlameLight,
    onTertiary = CharcoalBackground,
    tertiaryContainer = TerracottaDarkContainer,
    onTertiaryContainer = TerracottaFlameLight,
    error = DustyCrimsonLight,
    onError = CharcoalBackground,
    errorContainer = DustyCrimsonDarkContainer,
    onErrorContainer = DustyCrimsonLight,
    background = CharcoalBackground,
    onBackground = WarmChalk,
    surface = CharcoalSurface,
    onSurface = WarmChalk,
    surfaceVariant = CharcoalElevated,
    onSurfaceVariant = WarmAsh,
    outline = CharcoalBorder,
    outlineVariant = CharcoalElevated
)

val AcademyShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

@Composable
fun DrawingAcademyTheme(
    themePreference: ThemePreference = ThemePreference.SYSTEM,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themePreference) {
        ThemePreference.SYSTEM -> isSystemInDarkTheme()
        ThemePreference.LIGHT -> false
        ThemePreference.DARK -> true
    }

    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        shapes = AcademyShapes,
        content = content
    )
}
