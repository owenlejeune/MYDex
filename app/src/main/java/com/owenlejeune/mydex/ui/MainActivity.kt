package com.owenlejeune.mydex.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kieronquinn.monetcompat.app.MonetCompatActivity
import com.owenlejeune.mydex.preferences.AppPreferences
import com.owenlejeune.mydex.ui.navigation.DataNavItem
import com.owenlejeune.mydex.ui.navigation.MainNavItem
import com.owenlejeune.mydex.ui.theme.MYDexTheme
import com.owenlejeune.mydex.ui.views.AppScaffold
import com.owenlejeune.mydex.ui.views.PokedexView
import com.owenlejeune.mydex.ui.views.PokemonDetailView
import com.owenlejeune.mydex.utils.AppCache
import org.koin.java.KoinJavaComponent

class MainActivity : MonetCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            monet.awaitMonetReady()
            setContent {
                MYDexTheme(monetCompat = monet) {
                    val appNavController = rememberNavController()
                    Box {
                        MainNavigationRoutes(appNavController = appNavController)
                    }
                }
            }
        }
    }
    
    @Composable
    private fun MainNavigationRoutes(
        startDestination: String = MainNavItem.MainView.route,
        appNavController: NavHostController,
        preferences: AppPreferences = KoinJavaComponent.get(AppPreferences::class.java)
    ) {
        NavHost(navController = appNavController, startDestination = startDestination) {
            composable(MainNavItem.MainView.route) {
                AppScaffold(appNavController = appNavController)
            }
            composable(DataNavItem.Pokedex.route) {
                PokedexView(appNavController = appNavController)
            }
            composable(
                MainNavItem.PokemonDetailView.route.plus("/{id}"),
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) {
                val id = it.arguments?.getInt("id")
                id?.let {
                    PokemonDetailView(pokemonId = id, appNavController = appNavController)
                }
            }
        }
    }
}