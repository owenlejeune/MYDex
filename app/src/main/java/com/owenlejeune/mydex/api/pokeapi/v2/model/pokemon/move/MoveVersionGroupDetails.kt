package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.move

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class MoveVersionGroupDetails(
    @SerializedName("level_learned_at") val levelLearnedAt: Int,
    @SerializedName("move_learn_method") val moveLearnMethod: NameAndUrl,
    @SerializedName("version_group") val versionGroup: NameAndUrl,
)
