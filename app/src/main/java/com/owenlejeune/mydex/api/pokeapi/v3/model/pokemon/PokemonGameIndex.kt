package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class PokemonGameIndex(
    @SerializedName("game_index") val gameIndex: Int,
    @SerializedName("version", alternate = ["generation"]) val version: NameAndUrl
)
