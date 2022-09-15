package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.AwesomeName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class PokemonShape(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("awesome_names") val awesomeNames: List<AwesomeName>,
    @SerializedName("pokemon_species") val pokemonSpecies: List<NameAndUrl>
)