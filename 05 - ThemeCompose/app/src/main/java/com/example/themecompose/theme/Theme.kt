package com.example.themecompose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ThemeComposeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        typography = ThemeComposeTypography,
        shapes = ThemeComposeShapes,
        content = content,
    )
}

private val LightColors = lightColors(
    primary = Red700,
    primaryVariant = Red900,
    onPrimary = Color.White,
    secondary = Red700,
    secondaryVariant = Red900,
    onSecondary = Color.White,
    error = Red800
)