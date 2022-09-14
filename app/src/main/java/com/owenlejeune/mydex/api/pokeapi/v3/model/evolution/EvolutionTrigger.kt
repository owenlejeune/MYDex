package com.owenlejeune.mydex.api.pokeapi.v3.model.evolution

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class EvolutionTrigger(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: NameAndLanguage,
    @SerializedName("pokemon_species") val pokemonSpecies: List<NameAndUrl>
)