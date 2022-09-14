package com.owenlejeune.mydex.api.pokeapi.v3.model.location

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.encounter.PokemonEncounter
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class LocationArea(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("game_index") val gameIndex: Int,
    @SerializedName("location") val location: NameAndUrl,
    @SerializedName("pokemon_encounters") val pokemonEncounters: List<PokemonEncounter>
)