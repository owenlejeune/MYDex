package com.owenlejeune.mydex.api.pokeapi.v3.model.items

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.Description
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class ItemAttribute(
    @SerializedName("descriptions") val descriptions: List<Description>,
    @SerializedName("id") val id: Int,
    @SerializedName("items") val items: List<NameAndUrl>,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>
)