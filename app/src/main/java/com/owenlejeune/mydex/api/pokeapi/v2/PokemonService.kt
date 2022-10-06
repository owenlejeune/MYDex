package com.owenlejeune.mydex.api.pokeapi.v2

import android.util.Log
import com.owenlejeune.mydex.api.pokeapi.v2.model.evolution.EvolutionChain
import com.owenlejeune.mydex.api.pokeapi.v2.model.evolution.EvolutionTrigger
import com.owenlejeune.mydex.api.pokeapi.v2.model.items.Item
import com.owenlejeune.mydex.api.pokeapi.v2.model.location.Location
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.PaginatedResponse
import com.owenlejeune.mydex.api.pokeapi.v2.model.move.Move
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonSpecies
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonStat
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonType
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.egggroup.EggGroup
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response

class PokemonService: KoinComponent {

    companion object {
        private const val DEFAULT_LIMIT = 60

        val TAG = PokemonService::class.java.simpleName
    }

    private val service: PokemonApi by inject()

    suspend fun getPokemon(id: Int): Response<Pokemon> {
        return service.getPokemon(id)
    }

    suspend fun getPaginatedPokemon(page: Int = 1): Response<PaginatedResponse> {
        val limit = DEFAULT_LIMIT
        val offset = DEFAULT_LIMIT * (page-1)

        Log.d(TAG, "Paginated: page=$page, limit=$limit, offset=$offset")

        return service.getPaginatedPokemon(offset = offset, limit = limit).apply {
            Log.d(TAG, "Response: $isSuccessful, ${body()?.results?.map { it.name }}")
        }
    }

    suspend fun getPokemonSpecies(id: Int): Response<PokemonSpecies> {
        return service.getPokemonSpecies(id)
    }

    suspend fun getPokemonType(id: Int): Response<PokemonType> {
        return service.getPokemonType(id)
    }

    suspend fun getPokemonStat(id: Int): Response<PokemonStat> {
        return service.getPokemonStat(id)
    }

    suspend fun getEggGroup(id: Int): Response<EggGroup> {
        return service.getEggGroup(id)
    }
    
    suspend fun getEvolutionChain(id: Int): Response<EvolutionChain> {
        return service.getEvolutionChain(id)
    }

    suspend fun getEvolutionTrigger(id: Int): Response<EvolutionTrigger> {
        return service.getEvolutionTrigger(id)
    }

    suspend fun getItem(id: Int): Response<Item> {
        return service.getItem(id)
    }

    suspend fun getMove(id: Int): Response<Move> {
        return service.getMove(id)
    }

    suspend fun getLocation(id: Int): Response<Location> {
        return service.getLocation(id)
    }

}