package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.nature

import com.google.gson.annotations.SerializedName

class AffectingNatures(
    @SerializedName("increase") val increase: List<AffectingNature>,
    @SerializedName("decrease") val decrease: List<AffectingNature>
)
