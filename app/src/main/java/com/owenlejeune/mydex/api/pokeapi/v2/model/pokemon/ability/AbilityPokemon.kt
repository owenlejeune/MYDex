package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class AbilityPokemon(
    @SerializedName("slot") val slot: Int,
    @SerializedName("is_hidden") val isHidden: Boolean,
    @SerializedName("pokemon") val name: NameAndUrl,
)
