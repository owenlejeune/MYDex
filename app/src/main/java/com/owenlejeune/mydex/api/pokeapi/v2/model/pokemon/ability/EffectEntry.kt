package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class EffectEntry(
    @SerializedName("language") val language: NameAndUrl,
    @SerializedName("effect") val effect: String,
    @SerializedName("short_effect") val shortEffect: String?
)
