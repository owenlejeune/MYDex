package com.owenlejeune.mydex.api.pokeapi.v2.model.misc

import com.google.gson.annotations.SerializedName

class Type(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: NameAndUrl
)
