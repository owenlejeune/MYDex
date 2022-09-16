package com.owenlejeune.mydex.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.owenlejeune.mydex.utils.AppCache

@Composable
fun PokemonDetailView(
    pokemonId: Int
) {
    val pokemon = AppCache.cachedSpecies[pokemonId]
    Text(text = pokemon.name)
}