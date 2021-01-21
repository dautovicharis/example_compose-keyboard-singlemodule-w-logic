package com.example.composekeyboardperformance.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color.Black,
    primaryVariant = grey800,
    background = grey900,
    surface = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
).copy(
    secondaryVariant = grey800
)

private val LightColorPalette = lightColors(
    primary = primaryGrey,
    primaryVariant = primaryVariantGrey,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.Black,
    onSecondary = Color(0xFFFAFAFA),
    onBackground = Color.Black,
    onSurface = Color.Black,

    )

private val DebugColorPalette = lightColors(
    primary = Color.Red,
    primaryVariant = Color.Yellow,
    secondary = Color.Green,
    background = Color.Black,
    surface = Color.Blue,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        shapes = shapes,
        content = content
    )
}