package com.owenlejeune.mydex.api.pokeapi.v2.model.items

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability.EffectEntry

class ItemFlingEffect(
    @SerializedName("id") val id: Int,
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry>,
    @SerializedName("items") val items: List<NameAndUrl>,
    @SerializedName("name") val name: String
)