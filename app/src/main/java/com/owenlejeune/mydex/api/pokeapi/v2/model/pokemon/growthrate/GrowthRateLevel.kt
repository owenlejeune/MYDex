package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.growthrate

import com.google.gson.annotations.SerializedName

class GrowthRateLevel(
    @SerializedName("experience") val experience: Int,
    @SerializedName("level") val level: Int
)
