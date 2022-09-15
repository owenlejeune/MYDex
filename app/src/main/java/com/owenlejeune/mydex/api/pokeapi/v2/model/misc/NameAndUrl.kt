package com.owenlejeune.mydex.api.pokeapi.v2.model.misc

import com.google.gson.annotations.SerializedName

class NameAndUrl(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)