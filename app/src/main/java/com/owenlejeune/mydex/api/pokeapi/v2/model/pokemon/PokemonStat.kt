package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.nature.StatAffectingNatures
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.move.StatAffectingMoves

class PokemonStat(
    @SerializedName("affecting_natures") val affectingNatures: StatAffectingNatures,
    @SerializedName("affecting_moves") val affectingMoves: StatAffectingMoves,
    @SerializedName("game_index") val gameIndex: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("is_battle_only") val isBattleOnly: Boolean,
    @SerializedName("move_damage_class") val moveDamageClass: NameAndUrl,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>
)