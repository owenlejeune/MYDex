package com.owenlejeune.mydex.utils

import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response

object DataManager: KoinComponent {

    private val service: PokemonService by inject()

    fun getPokemonById(id: Int, callback: (Pokemon) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedPokemon[it] },
            fetcher = { service.getPokemon(it) },
            storer = { AppCache.cachedPokemon.put(it.id, it) }
        )
    }

    suspend fun getPokemonByIdSync(id: Int): Pokemon {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedPokemon[it] },
            fetcher = { service.getPokemon(it) },
            storer = { AppCache.cachedPokemon.put(it.id, it) }
        )
    }

    fun getPokemonSpeciesById(id: Int, callback: (PokemonSpecies) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedSpecies[it] },
            fetcher = { service.getPokemonSpecies(it) },
            storer = { AppCache.cachedSpecies.put(it.id, it) }
        )
    }

    suspend fun getPokemonSpeciesByIdSync(id: Int): PokemonSpecies {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedSpecies[id] },
            fetcher = { service.getPokemonSpecies(id) },
            storer = { AppCache.cachedSpecies.put(it.id, it) }
        )
    }

    fun getTypeById(id: Int, callback: (PokemonType) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedTypes[it] },
            fetcher = { service.getPokemonType(it) },
            storer = { AppCache.cachedTypes.put(it.id, it) }
        )
    }

    suspend fun getTypeByIdSync(id: Int): PokemonType {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedTypes[it] },
            fetcher = { service.getPokemonType(it) },
            storer = { AppCache.cachedTypes.put(it.id, it) }
        )
    }

    fun getStatById(id: Int, callback: (PokemonStat) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedStats[id] },
            fetcher = { service.getPokemonStat(id) },
            storer = { AppCache.cachedStats.put(it.id, it) }
        )
    }

    suspend fun getStatByIdSync(id: Int): PokemonStat {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedStats[id] },
            fetcher = { service.getPokemonStat(id) },
            storer = { AppCache.cachedStats.put(it.id, it) }
        )
    }

    fun getEggGroupById(id: Int, callback: (EggGroup) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedEggGroups[id] },
            fetcher = { service.getEggGroup(id) },
            storer = { AppCache.cachedEggGroups.put(it.id, it) }
        )
    }

    suspend fun getEggGroupById(id: Int): EggGroup {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedEggGroups[id] },
            fetcher = { service.getEggGroup(id) },
            storer = { AppCache.cachedEggGroups.put(it.id, it) }
        )
    }

    fun getEvolutionChainById(id: Int, callback: (EvolutionChain) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedEvolutionChains[id] },
            fetcher = { service.getEvolutionChain(id) },
            storer = { AppCache.cachedEvolutionChains.put(it.id, it) }
        )
    }

    fun getEvolutionTriggerById(id: Int, callback: (EvolutionTrigger) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedEvolutionTriggers[id] },
            fetcher = { service.getEvolutionTrigger(id) },
            storer = { AppCache.cachedEvolutionTriggers.put(it.id, it) }
        )
    }

    suspend fun getEvolutionTriggerByIdSync(id: Int): EvolutionTrigger {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedEvolutionTriggers[id] },
            fetcher = { service.getEvolutionTrigger(id) },
            storer = { AppCache.cachedEvolutionTriggers.put(it.id, it) }
        )
    }

    fun getItemById(id: Int, callback: (Item) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedItems[id] },
            fetcher = { service.getItem(id) },
            storer = { AppCache.cachedItems.put(it.id, it) }
        )
    }

    suspend fun getItemByIdSync(id: Int): Item {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedItems[id] },
            fetcher = { service.getItem(id) },
            storer = { AppCache.cachedItems.put(it.id, it) }
        )
    }

    fun getMoveById(id: Int, callback: (Move) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedMoves[id] },
            fetcher = { service.getMove(id) },
            storer = { AppCache.cachedMoves.put(it.id, it) }
        )
    }

    suspend fun getMoveByIdSync(id: Int): Move {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedMoves[id] },
            fetcher = { service.getMove(id) },
            storer = { AppCache.cachedMoves.put(it.id, it) }
        )
    }

    fun getLocationById(id: Int, callback: (Location) -> Unit) {
        getById(
            id = id,
            callback = callback,
            retriever = { AppCache.cachedLocations[id] },
            fetcher = { service.getLocation(id) },
            storer = { AppCache.cachedLocations.put(it.id, it) }
        )
    }

    suspend fun getLocationByIdSync(id: Int): Location {
        return getByIdSync(
            id = id,
            retriever = { AppCache.cachedLocations[id] },
            fetcher = { service.getLocation(id) },
            storer = { AppCache.cachedLocations.put(it.id, it) }
        )
    }

    private fun <T> getById(
        id: Int,
        callback: (T) -> Unit,
        retriever: (Int) -> T?,
        fetcher: suspend (Int) -> Response<T>,
        storer: (T) -> Unit
    ) {
        retriever(id)?.let(callback) ?: run {
            CoroutineScope(Dispatchers.IO).launch {
                fetcher(id).apply {
                    if (isSuccessful) {
                        body()?.let {
                            storer(it)
                            callback(it)
                        }
                    }
                }
            }
        }
    }

    private suspend fun <T> getByIdSync(
        id: Int,
        retriever: (Int) -> T?,
        fetcher: suspend (Int) -> Response<T>,
        storer: (T) -> Unit
    ): T {
        val retreived = retriever(id)
        if (retreived != null) {
            return retreived
        }
        val fetched = fetcher(id)
        return fetched.body()!!.apply { storer(this) }
    }

}