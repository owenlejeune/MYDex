package com.owenlejeune.mydex.api.pokeapi.v2.model.items

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class ItemHolderPokemon(
    @SerializedName("rarity") val rarity: Int,
    @SerializedName("version") val version: NameAndUrl
)
