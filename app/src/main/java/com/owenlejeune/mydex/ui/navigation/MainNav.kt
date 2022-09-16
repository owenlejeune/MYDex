package com.owenlejeune.mydex.ui.navigation

sealed class MainNavItem(val route: String) {

    companion object {
        val Items by lazy { listOf(MainView) }
    }

    object MainView: MainNavItem("main_route")
    object PokemonDetailView: MainNavItem("pokemon_route")

}