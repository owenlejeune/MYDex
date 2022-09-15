package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.growthrate

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.Description
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class GrowthRate(
    @SerializedName("descriptions") val descriptions: List<Description>,
    @SerializedName("formula") val formula: String,
    @SerializedName("id") val id: Int,
    @SerializedName("levels") val levels: List<GrowthRateLevel>,
    @SerializedName("name") val name: String,
    @SerializedName("pokemon_species") val pokemonSpecies: List<NameAndUrl>
)