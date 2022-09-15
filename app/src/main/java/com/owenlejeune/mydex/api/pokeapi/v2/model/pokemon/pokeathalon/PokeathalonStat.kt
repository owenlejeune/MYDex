package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.pokeathalon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.nature.AffectingNatures

class PokeathalonStat(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("affectingNatures") val affectingNatures: AffectingNatures
)