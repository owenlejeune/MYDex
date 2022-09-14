package com.owenlejeune.mydex.api.pokeapi.v3.model.berry

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class Flavor(
    @SerializedName("potency") val potency: Int,
    @SerializedName("flavor") val flavor: NameAndUrl
)
