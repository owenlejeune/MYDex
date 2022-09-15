package com.owenlejeune.mydex.api.pokeapi.v2.model.berry

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class Flavor(
    @SerializedName("potency") val potency: Int,
    @SerializedName("flavor") val flavor: NameAndUrl
)
