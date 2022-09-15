package com.owenlejeune.mydex.api.pokeapi.v2.model.encounter

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.game.VersionDetails
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class PokemonEncounter(
    @SerializedName("pokemon") val pokemon: NameAndUrl,
    @SerializedName("version_details") val versionDetails: List<VersionDetails>
)