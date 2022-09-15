package com.owenlejeune.mydex.api.pokeapi.v2.model.move

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class ContestCombo(
    @SerializedName("use_after") val useAfter: List<NameAndUrl>?,
    @SerializedName("use_before") val useBefore: List<NameAndUrl>?
)
