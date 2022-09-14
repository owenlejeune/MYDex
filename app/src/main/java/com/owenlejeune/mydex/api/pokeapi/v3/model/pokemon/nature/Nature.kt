package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.nature

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.pokeathalon.PokeathalonStatChange

class Nature(
    @SerializedName("id") val id: Int,
    @SerializedName("decreased_stat") val decreasedState: NameAndUrl,
    @SerializedName("increased_stat") val increasedStat: NameAndUrl,
    @SerializedName("hates_flavor") val hatesFlavor: NameAndUrl,
    @SerializedName("likes_flavor") val likesFlavor: NameAndUrl,
    @SerializedName("move_battle_style_preference") val moveBattleStylePreference: MoveBattleStylePreference,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("pokeathalon_stat_changes") val pokeathalonStatChanges: List<PokeathalonStatChange>
)