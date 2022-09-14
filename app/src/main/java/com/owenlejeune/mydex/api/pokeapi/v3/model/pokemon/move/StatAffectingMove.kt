package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.move

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class StatAffectingMove(
    @SerializedName("change") val change: Int,
    @SerializedName("move") val move: NameAndUrl
)
