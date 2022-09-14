package com.owenlejeune.mydex.api.pokeapi.v3.model.contest

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class ContestType(
    @SerializedName("berry_flavor") val berryFlavor: NameAndUrl,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>
)