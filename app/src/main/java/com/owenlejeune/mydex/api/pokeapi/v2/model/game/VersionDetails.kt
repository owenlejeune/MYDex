package com.owenlejeune.mydex.api.pokeapi.v2.model.game

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.encounter.EncounterDetails
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class VersionDetails(
    @SerializedName("encounter_details") val encounterDetails: List<EncounterDetails>,
    @SerializedName("max_chance") val maxChance: Int,
    @SerializedName("version") val version: NameAndUrl
)