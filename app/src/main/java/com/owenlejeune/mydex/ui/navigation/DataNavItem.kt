package com.owenlejeune.mydex.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.owenlejeune.mydex.R
import com.owenlejeune.mydex.ui.theme.*
import com.owenlejeune.mydex.utils.ResourceUtils
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

sealed class DataNavItem(
    val route: String,
    val color: Color,
    @StringRes titleRes: Int
): KoinComponent {

    companion object {
        val Pages by lazy { listOf(Pokedex, Moves, Abilities, Items, Locations, TypeCharts) }
    }

    private val resourceUtils: ResourceUtils by inject()

    val title = resourceUtils.getString(titleRes)

    object Pokedex: DataNavItem("pokedex_route", PokeGreen, R.string.pokedex_nav_title)
    object Moves: DataNavItem("moves_route", PokeRed, R.string.moves_nav_title)
    object Abilities: DataNavItem("abilities_route", PokeLightBlue, R.string.abilities_nav_title)
    object Items: DataNavItem("items_route", PokeYellow, R.string.items_nav_title)
    object Locations: DataNavItem("locations_route", PokePurple, R.string.locations_nav_title)
    object TypeCharts: DataNavItem("type_charts_route", PokeBrown, R.string.type_charts_nav_title)

}