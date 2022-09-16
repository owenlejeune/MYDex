package com.owenlejeune.mydex.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.owenlejeune.mydex.ui.theme.*

object ColorUtils {

    @Composable
    fun pokeColorToComposeColor(color: String): Color {
        return when (color) {
            "green" -> PokeGreen
            "red" -> PokeRed
            "blue" -> PokeBlue
            "black" -> PokeBlack
            "brown" -> PokeBrown
            "purple" -> PokePurple
            "pink" -> PokeLightBrown
            "grey" -> PokeGrey
            "white" -> PokeWhite
            "yellow" -> PokeYellow
            else -> MaterialTheme.colorScheme.secondaryContainer
        }
    }

}