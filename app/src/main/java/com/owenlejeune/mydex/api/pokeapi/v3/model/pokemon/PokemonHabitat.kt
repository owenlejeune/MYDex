package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class PokemonHabitat(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("pokemon_species") val species: List<NameAndUrl>
)