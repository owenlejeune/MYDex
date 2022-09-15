package com.owenlejeune.mydex.api.pokeapi.v2.model.contest

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability.FlavorTextEntry

class SuperContestEffect(
    @SerializedName("appeal") val appeal: Int,
    @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("id") val id: Int,
    @SerializedName("moves") val moves: List<NameAndUrl>
)