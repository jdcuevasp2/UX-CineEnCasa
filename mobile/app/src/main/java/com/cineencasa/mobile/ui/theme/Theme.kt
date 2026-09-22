package com.cineencasa.mobile.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val CineEnCasaDarkColorScheme = darkColorScheme(
    primary = Azul1Primary,
    onPrimary = OnBackgroundPrimary,
    secondary = Azul2Secondary,
    onSecondary = OnBackgroundPrimary,
    background = Background,
    onBackground = OnBackgroundPrimary,
    surface = Surface,
    onSurface = OnBackgroundPrimary,
    surfaceVariant = Surface,
    onSurfaceVariant = OnBackgroundSecondary,
    outline = Outline,
    outlineVariant = Outline
)

/**
 * Dark-only theme: the Figma source has no light variant, so this app always
 * renders with [CineEnCasaDarkColorScheme] regardless of [isSystemInDarkTheme].
 */
@Composable
fun CineEnCasaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CineEnCasaDarkColorScheme,
        typography = CineEnCasaTypography,
        content = content
    )
}
