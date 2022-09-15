package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.move.MoveVersionGroupDetails

class PokemonMove(
    @SerializedName("move.name") val name: String,
    @SerializedName("move.url") val url: String,
    @SerializedName("version_group_details") val versionGroupDetails: List<MoveVersionGroupDetails>
)
