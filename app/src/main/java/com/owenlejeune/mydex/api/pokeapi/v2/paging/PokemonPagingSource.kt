package com.owenlejeune.mydex.api.pokeapi.v2.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PokemonPagingSource: PagingSource<Int, Pokemon>(), KoinComponent {

    companion object {
        private val TAG = PokemonPagingSource::class.java.simpleName
    }

    private val pokemonService: PokemonService by inject()

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val nextPage = params.key ?: 1
            val response =  pokemonService.getPokemon(nextPage)
            if (response.isSuccessful) {
                val responseBody = response.body()!!
//                Log.d(TAG, "${results.map { it.name }}")
                LoadResult.Page(
                    data = listOf(responseBody),
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = if (responseBody == null) null else nextPage + 1
                )
            } else {
                LoadResult.Invalid()
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}