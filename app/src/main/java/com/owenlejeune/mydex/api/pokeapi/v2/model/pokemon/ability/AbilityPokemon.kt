package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability

import com.google.gson.annotations.SerializedName

class AbilityPokemon(
    @SerializedName("slot") val slot: Int,
    @SerializedName("is_hidden") val isHidden: Boolean,
    @SerializedName("pokemon.name") val name: String,
    @SerializedName("pokemon.url") val url: String
)
