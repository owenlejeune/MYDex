package com.owenlejeune.mydex.api.pokeapi.v2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.Pokemon
import com.owenlejeune.mydex.api.pokeapi.v2.paging.PokemonPagingSource
import kotlinx.coroutines.flow.Flow

class PokemonViewModel: ViewModel() {
    val pokemon: Flow<PagingData<NameAndUrl>> = Pager(PagingConfig(pageSize = Int.MAX_VALUE)) {
        PokemonPagingSource()
    }.flow.cachedIn(viewModelScope)
}