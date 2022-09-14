package com.owenlejeune.mydex.api.pokeapi.v3.model.game

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class PokedexNumber(
    @SerializedName("entry_number") val entryNumber: Int,
    @SerializedName("pokedex") val pokedex: NameAndUrl
)
