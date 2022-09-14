package com.owenlejeune.mydex.api.pokeapi.v3.model.items

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class ItemHolderPokemon(
    @SerializedName("rarity") val rarity: Int,
    @SerializedName("version") val version: NameAndUrl
)
