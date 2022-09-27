package com.owenlejeune.mydex.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.owenlejeune.mydex.ui.theme.*

object ColorUtils {

    @Composable
    fun pokeColorToComposeColor(color: String): Color {
        return when (color.lowercase()) {
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

    fun pokeTypeNameToComposeColor(type: String): Color {
        return when (type.lowercase()) {
            "bug" -> BugType
            "dark" -> DarkType
            "dragon" -> DragonType
            "electric" -> ElectricType
            "fairy" -> FairyType
            "fighting" -> FightingType
            "fire" -> FireType
            "flying" -> FlyingType
            "ghost" -> GhostType
            "grass" -> GrassType
            "ground" -> GroundType
            "ice" -> IceType
            "normal" -> NormalType
            "poison" -> PoisonType
            "psychic" -> PsychicType
            "rock" -> RockType
            "shadow" -> ShadowType
            "steel" -> SteelType
            "water" -> WaterType
            else -> UnknownType
        }
    }

}