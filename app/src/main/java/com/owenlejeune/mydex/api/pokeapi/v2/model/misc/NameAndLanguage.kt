package com.owenlejeune.mydex.api.pokeapi.v2.model.misc

import com.google.gson.annotations.SerializedName

class NameAndLanguage(
    @SerializedName("name") val name: String,
    @SerializedName("language") val language: NameAndUrl
)
