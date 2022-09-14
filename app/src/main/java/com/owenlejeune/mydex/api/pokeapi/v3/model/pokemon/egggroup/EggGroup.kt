package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.egggroup

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class EggGroup(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("name") val names: List<NameAndLanguage>,
    @SerializedName("pokemon_species") val pokemonSpecies: List<NameAndUrl>
)