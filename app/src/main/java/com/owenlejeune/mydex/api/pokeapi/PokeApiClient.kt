package com.owenlejeune.mydex.api.pokeapi

import com.owenlejeune.mydex.api.Client
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonApi
import com.owenlejeune.mydex.preferences.AppPreferences
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class PokeApiClient: KoinComponent {

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    private val client: Client by inject { parametersOf(BASE_URL) }
    private val preferences: AppPreferences by inject()

    fun createPokemonService(): PokemonApi {
        return client.create(PokemonApi::class.java)
    }

}