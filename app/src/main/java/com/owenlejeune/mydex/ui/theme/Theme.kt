package com.owenlejeune.mydex.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kieronquinn.monetcompat.core.MonetCompat
import com.owenlejeune.mydex.preferences.AppPreferences
import org.koin.java.KoinJavaComponent.get

private val DarkColorPalette = darkColorScheme(
    primary = Color.White,
    secondary = Color(0xFFC20029),
    onPrimary = Color.Black,
    tertiary = Color.White,
    onSecondary = Color.Black,
    background = Color(0xFFEEEEEE),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFD00036),
    onError = Color.White
)

val LightColorPalette = lightColorScheme(
    primary = Color.White,
    secondary = Color(0xFFC20029),
    onPrimary = Color.Black,
    tertiary = Color.White,
    onSecondary = Color.Black,
    background = Color(0xFFEEEEEE),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFD00036),
    onError = Color.White
)

@Composable
fun MYDexTheme(
    preferences: AppPreferences = get(AppPreferences::class.java),
    monetCompat: MonetCompat,
    content: @Composable () -> Unit
) {
    val isDarkTheme = when(preferences.darkTheme) {
        AppPreferences.DarkMode.Automatic.ordinal -> isSystemInDarkTheme()
        AppPreferences.DarkMode.Dark.ordinal -> true
        AppPreferences.DarkMode.Light.ordinal -> false
        else -> throw IllegalArgumentException("Illegal theme value ${preferences.darkTheme}")
    }

    val colors = when {
        isDarkTheme && preferences.useWallpaperColors -> monetCompat.darkMonetCompatScheme()
        isDarkTheme && !preferences.useWallpaperColors -> DarkColorPalette
        !isDarkTheme && preferences.useWallpaperColors -> monetCompat.lightMonetCompatScheme()
        !isDarkTheme && !preferences.useWallpaperColors -> LightColorPalette
        else -> throw Exception("Error getting theme colors, should never happen")
    }

    androidx.compose.material3.MaterialTheme(
        colorScheme = colors,
        typography = Typography
    ) {
        MaterialTheme(
            colors = Colors(
                primary = colors.primary,
                primaryVariant = colors.inversePrimary,
                secondary = colors.secondary,
                onSecondary = colors.onSecondary,
                secondaryVariant = colors.secondaryContainer,
                background = colors.background,
                onBackground = colors.onBackground,
                surface = colors.surface,
                error = colors.error,
                onPrimary = colors.onPrimary,
                onSurface = colors.onSurface,
                onError = colors.onError,
                isLight = !isDarkTheme
            ),
            shapes = Shapes,
            content = {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(color = androidx.compose.material3.MaterialTheme.colorScheme.background)

                content()
            }
        )
    }
}