package com.owenlejeune.mydex.api.pokeapi.v3.model.berry

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class FlavorBerries(
    @SerializedName("potency") val potency: Int,
    @SerializedName("berry") val berry: NameAndUrl
)