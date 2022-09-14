package com.owenlejeune.mydex.api.pokeapi.v3.model.misc

import com.google.gson.annotations.SerializedName

class Language(
    @SerializedName("id") val id: Int,
    @SerializedName("iso3166") val iso3166: String,
    @SerializedName("iso639") val iso639: String,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("official") val isOfficial: Boolean
)