package com.owenlejeune.mydex.api.pokeapi.v2.model.location

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class PalParkEncounter(
    @SerializedName("rate") val rate: Int,
    @SerializedName("base_score") val baseScore: Int,
    @SerializedName("area") val area: NameAndUrl
)
