package com.owenlejeune.mydex.utils

import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonSpecies
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonStat
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response

object DataManager: KoinComponent {

    private val service: PokemonService by inject()

    fun getPokemonById(id: Int, callback: (Pokemon) -> Unit) {
        AppCache.cachedPokemon[id]?.let(callback) ?: run {
            CoroutineScope(Dispatchers.IO).launch {
                service.getPokemon(id).apply {
                    if (isSuccessful) {
                        body()?.let {
                            AppCache.cachedPokemon.put(it.id, it)
                            callback(it)
                        }
                    }
                }
            }
        }
    }

    fun getPokemonSpeciesById(id: Int, callback: (PokemonSpecies) -> Unit) {
        AppCache.cachedSpecies[id]?.let(callback) ?: run {
            CoroutineScope(Dispatchers.IO).launch {
                service.getPokemonSpecies(id).apply {
                    if (isSuccessful) {
                        body()?.let {
                            AppCache.cachedSpecies.put(it.id, it)
                            callback(it)
                        }
                    }
                }
            }
        }
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

    fun getStatById(id: Int, callback: (PokemonStat) -> Unit) {
        AppCache.cachedStats[id]?.let(callback) ?: run {
            CoroutineScope(Dispatchers.IO).launch {
                service.getPokemonStat(id).apply {
                    if (isSuccessful) {
                        body()?.let {
                            AppCache.cachedStats.put(it.id, it)
                            callback(it)
                        }
                    }
                }
            }
        }
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

}