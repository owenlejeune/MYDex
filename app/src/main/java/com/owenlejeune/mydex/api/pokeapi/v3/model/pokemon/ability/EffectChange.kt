package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.ability

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class EffectChange(
    @SerializedName("version_group") val version: NameAndUrl,
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry>
)
