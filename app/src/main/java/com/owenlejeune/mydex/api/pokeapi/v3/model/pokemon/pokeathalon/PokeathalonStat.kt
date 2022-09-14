package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.pokeathalon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.nature.AffectingNatures

class PokeathalonStat(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("affectingNatures") val affectingNatures: AffectingNatures
)