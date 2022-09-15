package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class PokemonGameIndex(
    @SerializedName("game_index") val gameIndex: Int,
    @SerializedName("version", alternate = ["generation"]) val version: NameAndUrl
)
