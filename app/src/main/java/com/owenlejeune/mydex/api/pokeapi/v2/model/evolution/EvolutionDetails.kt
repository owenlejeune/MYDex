package com.owenlejeune.mydex.api.pokeapi.v2.model.evolution

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class EvolutionDetails(
    @SerializedName("item") val item: NameAndUrl,
    @SerializedName("trigger") val trigger: NameAndUrl,
    @SerializedName("gender") val gender: Int,
    @SerializedName("held_item") val heldItem: NameAndUrl,
    @SerializedName("known_move") val knownMove: NameAndUrl,
    @SerializedName("known_move_type") val knownMoveType: NameAndUrl,
    @SerializedName("location") val location: NameAndUrl,
    @SerializedName("min_level") val minLevel: Int,
    @SerializedName("min_happiness") val minHappiness: Int,
    @SerializedName("min_beauty") val minBeauty: Int,
    @SerializedName("min_affection") val minAffection: Int,
    @SerializedName("needs_overworld_rain") val needsOverworldRain: Boolean,
    @SerializedName("party_species") val partySpecies: NameAndUrl,
    @SerializedName("party_type") val partyType: NameAndUrl,
    @SerializedName("relative_physical_stats") val relativePhysicalStats: Int,
    @SerializedName("time_of_day") val timeOfDay: String,
    @SerializedName("trade_species") val tradeSpecies: NameAndUrl,
    @SerializedName("turn_upside_down") val turnUpsideDown: Boolean
)
