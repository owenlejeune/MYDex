package com.owenlejeune.mydex.utils

import android.util.SparseArray
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonSpecies
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonStat
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonType

object AppCache {

    var cachedSpecies = SparseArray<PokemonSpecies>()
    var cachedPokemon = SparseArray<Pokemon>()
    var cachedTypes = SparseArray<PokemonType>()
    var cachedStats = SparseArray<PokemonStat>()

}