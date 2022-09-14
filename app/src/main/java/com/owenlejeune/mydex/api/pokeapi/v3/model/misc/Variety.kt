package com.owenlejeune.mydex.api.pokeapi.v3.model.misc

import com.google.gson.annotations.SerializedName

class Variety(
    @SerializedName("is_default") val isDefault: Boolean,
    @SerializedName("pokemon") val pokemon: NameAndUrl
)
