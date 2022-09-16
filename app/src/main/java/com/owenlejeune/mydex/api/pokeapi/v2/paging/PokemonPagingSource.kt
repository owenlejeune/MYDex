package com.owenlejeune.mydex.api.pokeapi.v2.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.PaginatedResponse
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.utils.AppCache
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PokemonPagingSource: PagingSource<Int, NameAndUrl>(), KoinComponent {

    companion object {
        private val TAG = PokemonPagingSource::class.java.simpleName
    }

    private val pokemonService: PokemonService by inject()

    override fun getRefreshKey(state: PagingState<Int, NameAndUrl>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NameAndUrl> {
        return try {
            val nextPage = params.key ?: 1
            val response = pokemonService.getPaginatedPokemon(nextPage)
            if (response.isSuccessful) {
                val responseBody = response.body()
                val results = responseBody?.results ?: emptyList()
                Log.d(TAG, "${results.map { it.name }}")
                LoadResult.Page(
                    data = results,
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = if (results.isEmpty()) null else nextPage + 1
                )
            } else {
                LoadResult.Invalid()
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

//    fun t() {
//        val nextPage = params.key ?: 1
//        var pokemon = AppCache.cachedPokemon[nextPage]
//        if (pokemon == null) {
//            val response =  pokemonService.getPokemon(nextPage)
//            if (response.isSuccessful) {
//                pokemon = response.body()!!
//            } else {
//                return LoadResult.Invalid()
//            }
//        }
//        Log.d(TAG, pokemon.name)
//        LoadResult.Page(
//            data = listOf(pokemon),
//            prevKey = if (nextPage == 1) null else nextPage - 1,
//            nextKey = nextPage + 1
//        )
//    }

}