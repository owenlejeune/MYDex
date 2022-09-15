package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.move

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class StatAffectingMove(
    @SerializedName("change") val change: Int,
    @SerializedName("move") val move: NameAndUrl
)
