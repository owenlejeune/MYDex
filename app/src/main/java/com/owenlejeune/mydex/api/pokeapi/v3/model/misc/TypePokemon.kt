package com.owenlejeune.mydex.api.pokeapi.v3.model.misc

import com.google.gson.annotations.SerializedName

class TypePokemon(
    @SerializedName("slot") val slot: Int,
    @SerializedName("pokemon") val pokemon: NameAndUrl
)