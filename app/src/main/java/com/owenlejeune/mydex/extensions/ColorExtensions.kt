package com.owenlejeune.mydex.extensions

import androidx.annotation.FloatRange
import androidx.compose.ui.graphics.Color

fun Color.adjustBy(@FloatRange(from = (-1f).toDouble(), to = 1f.toDouble()) x: Float): Color {
    return copy(
        red = (red+x).coerceIn(minimumValue = 0f, maximumValue = 1f),
        green = (green+x).coerceIn(minimumValue = 0f, maximumValue = 1f),
        blue = (blue+x).coerceIn(minimumValue = 0f, maximumValue = 1f)
    )
}