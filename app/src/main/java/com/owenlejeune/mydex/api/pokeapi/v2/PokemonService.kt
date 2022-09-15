package com.owenlejeune.mydex.api.pokeapi.v2

import android.util.Log
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.PaginatedResponse
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response

class PokemonService: KoinComponent {

    companion object {
        private const val DEFAULT_LIMIT = 20

        val TAG = PokemonService::class.java.simpleName
    }

    private val service: PokemonApi by inject()

    suspend fun getPokemon(id: Int): Response<Pokemon> {
        return service.getPokemon(id)
    }

    suspend fun getPaginatedPokemon(page: Int = 1): Response<PaginatedResponse> {
        val limit = DEFAULT_LIMIT
        val offset = DEFAULT_LIMIT * page

        Log.d(TAG, "Paginated: page=$page, limit=$limit, offset=$offset")

        return service.getPaginatedPokemon(offset = offset, limit = limit).apply {
            Log.d(TAG, "Response: $isSuccessful, ${body()?.results?.map { it.name }}")
        }
    }

}