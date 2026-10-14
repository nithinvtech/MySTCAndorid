package com.example.mystcandorid.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val MystcColors = lightColorScheme(
    primary = BrandPink,
    onPrimary = AppBackground,
    background = AppBackground,
    onBackground = AppText,
    surface = AppBackground,
    onSurface = AppText,
    outline = AppBorder,
)

@Composable
fun MystcTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = MystcColors,
        content = content,
    )
}
