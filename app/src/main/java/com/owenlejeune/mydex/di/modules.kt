package com.owenlejeune.mydex.di

import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapterFactory
import com.owenlejeune.mydex.BuildConfig
import com.owenlejeune.mydex.api.*
import com.owenlejeune.mydex.api.pokeapi.PokeApiClient
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonApi
import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.preferences.AppPreferences
import com.owenlejeune.mydex.utils.ResourceUtils
import org.koin.dsl.module

val networkModule = module {
    single { if (BuildConfig.DEBUG) DebugHttpClient() else ProdHttpClient() }
    single<ConverterFactoryFactory> { GsonConverter() }
    factory { (baseUrl: String) -> Client(baseUrl) }

    single<List<TypeAdapterFactory>> {
        listOf(FlattenTypeAdapterFactory())
    }

    single {
        GsonBuilder().apply {
            get<List<TypeAdapterFactory>>().forEach { taf -> registerTypeAdapterFactory(taf) }
        }.create()
    }

    single { PokeApiClient() }
    single { get<PokeApiClient>().createPokemonService() }
    single { PokemonService() }
}

val preferencesModule = module {
    single { AppPreferences(get()) }
}

val appModule = module {
    factory { ResourceUtils(get()) }
}

val Modules = listOf(networkModule, preferencesModule, appModule)