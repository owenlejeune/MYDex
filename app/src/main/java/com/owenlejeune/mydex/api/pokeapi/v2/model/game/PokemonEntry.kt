package com.owenlejeune.mydex.api.pokeapi.v2.model.game

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class PokemonEntry(
    @SerializedName("entry_number") val entryNumber: Int,
    @SerializedName("pokemon_species") val pokemonSpecies: NameAndUrl
)