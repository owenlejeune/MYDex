package com.owenlejeune.mydex.api.pokeapi.v2.model.location

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class PalParkEncounterPokemon(
    @SerializedName("rate") val rate: Int,
    @SerializedName("base_score") val baseScore: Int,
    @SerializedName("pokemon_species") val pokemonSpecies: NameAndUrl
)