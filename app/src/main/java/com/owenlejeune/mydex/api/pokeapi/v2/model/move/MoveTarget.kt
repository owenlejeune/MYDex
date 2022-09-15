package com.owenlejeune.mydex.api.pokeapi.v2.model.move

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.Description
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class MoveTarget(
    @SerializedName("descriptions") val descriptions: List<Description>,
    @SerializedName("id") val id: Int,
    @SerializedName("moves") val moves: List<NameAndUrl>,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>
)