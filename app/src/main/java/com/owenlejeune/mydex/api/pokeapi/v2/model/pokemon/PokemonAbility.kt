package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon

import com.google.gson.annotations.SerializedName

class PokemonAbility(
    @SerializedName("is_hidden") val isHidden: Boolean,
    @SerializedName("slot") val slot: Int,
    @SerializedName("ability.name") val name: String,
    @SerializedName("ability.url") val url: String
)
