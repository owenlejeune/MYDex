package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.ability

import com.google.gson.annotations.SerializedName

class AbilityGeneration(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
