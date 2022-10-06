package com.owenlejeune.mydex.api.pokeapi.v2

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
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Response<Pokemon>

    @GET("pokemon/")
    suspend fun getPaginatedPokemon(@Query("offset") offset: Int, @Query("limit") limit: Int): Response<PaginatedResponse>

    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpecies(@Path("id") id: Int): Response<PokemonSpecies>

    @GET("type/{id}")
    suspend fun getPokemonType(@Path("id") id: Int): Response<PokemonType>

    @GET("stat/{id}")
    suspend fun getPokemonStat(@Path("id") id: Int): Response<PokemonStat>

    @GET("egg-group/{id}")
    suspend fun getEggGroup(@Path("id") id: Int): Response<EggGroup>

    @GET("evolution-chain/{id}")
    suspend fun getEvolutionChain(@Path("id") id: Int): Response<EvolutionChain>

    @GET("evolution-trigger/{id}")
    suspend fun getEvolutionTrigger(@Path("id") id: Int): Response<EvolutionTrigger>

    @GET("item/{id}")
    suspend fun getItem(@Path("id") id: Int): Response<Item>

    @GET("move/{id}")
    suspend fun getMove(@Path("id") id: Int): Response<Move>

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: Int): Response<Location>

}