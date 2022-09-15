package com.owenlejeune.mydex.api.pokeapi.v2.model.berry

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class BerryFirmness(
    @SerializedName("berries") val berries: List<NameAndUrl>,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>
)