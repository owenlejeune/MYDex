package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.move

import com.google.gson.annotations.SerializedName

class StatAffectingMoves(
    @SerializedName("decrease") val decrease: List<StatAffectingMove>,
    @SerializedName("increase") val increase: List<StatAffectingMove>
)