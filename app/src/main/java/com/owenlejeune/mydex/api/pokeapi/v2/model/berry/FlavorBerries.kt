package com.owenlejeune.mydex.api.pokeapi.v2.model.berry

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class FlavorBerries(
    @SerializedName("potency") val potency: Int,
    @SerializedName("berry") val berry: NameAndUrl
)