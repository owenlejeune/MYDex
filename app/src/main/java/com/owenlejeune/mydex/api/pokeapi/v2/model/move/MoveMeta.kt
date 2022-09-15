package com.owenlejeune.mydex.api.pokeapi.v2.model.move

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class MoveMeta(
    @SerializedName("ailment") val ailment: NameAndUrl,
    @SerializedName("ailment_chance") val ailmentChance: Int?,
    @SerializedName("category") val category: NameAndUrl,
    @SerializedName("crit_rate") val critRate: Int?,
    @SerializedName("drain") val drain: Int?,
    @SerializedName("flinch_chance") val flinchChance: Int?,
    @SerializedName("healing") val healing: Int?,
    @SerializedName("max_hits") val maxHits: Int?,
    @SerializedName("max_turns") val maxTurns: Int?,
    @SerializedName("min_hits") val minHits: Int?,
    @SerializedName("min_turns") val minTurns: Int?,
    @SerializedName("stat_chance") val statChance: Int?
)
