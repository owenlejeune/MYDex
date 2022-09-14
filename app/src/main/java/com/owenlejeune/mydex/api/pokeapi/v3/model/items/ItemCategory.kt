package com.owenlejeune.mydex.api.pokeapi.v3.model.items

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class ItemCategory(
    @SerializedName("id") val id: Int,
    @SerializedName("items") val items: List<NameAndUrl>,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("pocket") val pocket: NameAndUrl
)