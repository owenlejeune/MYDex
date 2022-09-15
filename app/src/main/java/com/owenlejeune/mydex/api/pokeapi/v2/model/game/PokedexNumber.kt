package com.owenlejeune.mydex.api.pokeapi.v2.model.game

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class PokedexNumber(
    @SerializedName("entry_number") val entryNumber: Int,
    @SerializedName("pokedex") val pokedex: NameAndUrl
)
