package com.owenlejeune.mydex.api.pokeapi.v2.model.machine

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class MachineDetails(
    @SerializedName("machine.url") val machineUrl: String,
    @SerializedName("version_group") val versionGroup: NameAndUrl
)
