package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.ability

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class FlavorTextEntry(
    @SerializedName("flavor_text", alternate = ["text"]) val flavorText: String,
    @SerializedName("language") val language: NameAndUrl,
    @SerializedName("version_group") val version: NameAndUrl?
)
