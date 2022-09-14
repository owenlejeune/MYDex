package com.owenlejeune.mydex.api.pokeapi.v3.model.game

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class PokemonEntry(
    @SerializedName("entry_number") val entryNumber: Int,
    @SerializedName("pokemon_species") val pokemonSpecies: NameAndUrl
)