package com.owenlejeune.mydex.api.pokeapi.v3.model.move

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.Description
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class MoveCategory(
    @SerializedName("id") val id: Int,
    @SerializedName("descriptions") val descriptions: List<Description>,
    @SerializedName("moves") val moves: List<NameAndUrl>,
    @SerializedName("name") val name: String
)