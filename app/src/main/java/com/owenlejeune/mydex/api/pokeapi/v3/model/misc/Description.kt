package com.owenlejeune.mydex.api.pokeapi.v3.model.misc

import com.google.gson.annotations.SerializedName

class Description(
    @SerializedName("description") val description: String,
    @SerializedName("language") val language: NameAndUrl
)
