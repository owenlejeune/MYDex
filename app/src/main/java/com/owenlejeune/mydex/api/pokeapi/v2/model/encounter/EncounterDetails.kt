package com.owenlejeune.mydex.api.pokeapi.v2.model.encounter

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class EncounterDetails(
    @SerializedName("chance") val chance: Int,
    @SerializedName("max_level") val maxLevel: Int,
    @SerializedName("method") val method: NameAndUrl,
    @SerializedName("min_level") val minLevel: Int,
    @SerializedName("condition_values") val conditionValues: List<NameAndUrl>
)
