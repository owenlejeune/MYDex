package com.owenlejeune.mydex.api.pokeapi.v3.model.misc

import com.google.gson.annotations.SerializedName

class NameAndLanguage(
    @SerializedName("name") val name: String,
    @SerializedName("language.name") val language: String,
    @SerializedName("language.url") val languageUrl: String
)
