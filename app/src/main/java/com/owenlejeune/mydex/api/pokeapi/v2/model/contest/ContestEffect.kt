package com.owenlejeune.mydex.api.pokeapi.v2.model.contest

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability.EffectEntry
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability.FlavorTextEntry

class ContestEffect(
    @SerializedName("appeal") val appeal: Int,
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry>,
    @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("id") val id: Int,
    @SerializedName("jam") val jam: Int
)