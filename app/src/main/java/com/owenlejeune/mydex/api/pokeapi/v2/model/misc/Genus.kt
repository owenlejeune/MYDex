package com.owenlejeune.mydex.api.pokeapi.v2.model.misc

import com.google.gson.annotations.SerializedName

class Genus(
    @SerializedName("genus") val genus: String,
    @SerializedName("language") val language: NameAndUrl
)
