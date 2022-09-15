package com.owenlejeune.mydex.api.pokeapi.v2

import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.PaginatedResponse
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response

class PokemonService: KoinComponent {

    companion object {
        private const val DEFAULT_LIMIT = 20
    }

    private val service: PokemonApi by inject()

    suspend fun getPokemon(id: Int): Response<Pokemon> {
        return service.getPokemon(id)
    }

    suspend fun getPaginatedPokemon(page: Int = 1): Response<PaginatedResponse> {
        val limit = DEFAULT_LIMIT
        val offset = DEFAULT_LIMIT * page

        return service.getPaginatedPokemon(offset = offset, limit = limit)
    }

}