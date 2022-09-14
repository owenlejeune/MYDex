package com.owenlejeune.mydex.api.pokeapi.v3.model.location

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class PalParkArea(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndUrl>,
    @SerializedName("pokemon_encounters") val pokemonEncounters: List<PalParkEncounterPokemon>
)