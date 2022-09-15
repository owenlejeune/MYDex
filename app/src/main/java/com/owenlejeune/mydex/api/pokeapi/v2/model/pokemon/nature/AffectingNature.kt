package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.nature

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class AffectingNature(
    @SerializedName("max_change") val maxChange: Int,
    @SerializedName("nature") val nature: NameAndUrl
)
