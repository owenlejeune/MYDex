package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.nature

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class StatAffectingNatures(
    @SerializedName("decrease") val decrease: List<NameAndUrl>,
    @SerializedName("increase") val increase: List<NameAndUrl>
)
