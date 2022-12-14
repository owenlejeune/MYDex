package com.owenlejeune.mydex.utils

import android.util.SparseArray
import com.owenlejeune.mydex.api.pokeapi.v2.model.evolution.EvolutionChain
import com.owenlejeune.mydex.api.pokeapi.v2.model.evolution.EvolutionTrigger
import com.owenlejeune.mydex.api.pokeapi.v2.model.items.Item
import com.owenlejeune.mydex.api.pokeapi.v2.model.location.Location
import com.owenlejeune.mydex.api.pokeapi.v2.model.move.Move
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonSpecies
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonStat
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonType
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.egggroup.EggGroup

object AppCache {

    var cachedSpecies = SparseArray<PokemonSpecies>()
    var cachedPokemon = SparseArray<Pokemon>()
    var cachedTypes = SparseArray<PokemonType>()
    var cachedStats = SparseArray<PokemonStat>()
    var cachedEggGroups = SparseArray<EggGroup>()
    var cachedEvolutionChains = SparseArray<EvolutionChain>()
    var cachedEvolutionTriggers = SparseArray<EvolutionTrigger>()
    var cachedItems = SparseArray<Item>()
    var cachedMoves = SparseArray<Move>()
    var cachedLocations = SparseArray<Location>()

}