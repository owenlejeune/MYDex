package com.owenlejeune.mydex.api.pokeapi.v2.model.machine

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class Machine(
    @SerializedName("id") val id: Int,
    @SerializedName("item") val item: NameAndUrl,
    @SerializedName("move") val move: NameAndUrl,
    @SerializedName("version_group") val versionGroup: NameAndUrl
)