package com.owenlejeune.mydex.api.pokeapi.v2.model.evolution

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class EvolutionChain(
    @SerializedName("id") val id: Int,
    @SerializedName("baby_trigger_item") val babyTriggerItem: NameAndUrl?,
    @SerializedName("chain") val chain: ChainLink?
)