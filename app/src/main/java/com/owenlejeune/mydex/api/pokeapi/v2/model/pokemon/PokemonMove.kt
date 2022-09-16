package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.move.MoveVersionGroupDetails

class PokemonMove(
    @SerializedName("move") val move: NameAndUrl,
    @SerializedName("version_group_details") val versionGroupDetails: List<MoveVersionGroupDetails>
)
