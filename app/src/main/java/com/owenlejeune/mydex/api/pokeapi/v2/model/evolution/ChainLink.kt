package com.owenlejeune.mydex.api.pokeapi.v2.model.evolution

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class ChainLink(
    @SerializedName("is_baby") val isBaby: Boolean,
    @SerializedName("species") val species: NameAndUrl,
    @SerializedName("evolution_details") val evolutionDetails: EvolutionDetails,
    @SerializedName("evolves_to") val evolves_to: List<ChainLink?>?
)
