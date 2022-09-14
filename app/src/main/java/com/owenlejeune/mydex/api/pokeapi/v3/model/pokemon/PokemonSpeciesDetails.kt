package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class PokemonSpeciesDetails(
    @SerializedName("rate") val rate: Int,
    @SerializedName("pokemon_species") val species: NameAndUrl
)
