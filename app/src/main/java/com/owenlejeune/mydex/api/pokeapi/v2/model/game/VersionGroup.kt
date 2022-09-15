package com.owenlejeune.mydex.api.pokeapi.v2.model.game

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class VersionGroup(
    @SerializedName("generation") val generation: NameAndUrl,
    @SerializedName("id") val id: Int,
    @SerializedName("move_learn_method") val moveLearnMethod: List<NameAndUrl>,
    @SerializedName("name") val name: String,
    @SerializedName("order") val order: Int,
    @SerializedName("pokedexes") val pokedexes: List<NameAndUrl>,
    @SerializedName("regions") val regions: List<NameAndUrl>,
    @SerializedName("versions") val versions: List<NameAndUrl>
)