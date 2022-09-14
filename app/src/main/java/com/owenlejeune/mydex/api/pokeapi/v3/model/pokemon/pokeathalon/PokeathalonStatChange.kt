package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.pokeathalon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class PokeathalonStatChange(
    @SerializedName("max_change") val maxChange: Int,
    @SerializedName("pokeathalon_stat") val pokeathalongStat: NameAndUrl
)
