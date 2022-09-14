package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.move

import com.google.gson.annotations.SerializedName

class MoveVersionGroupDetails(
    @SerializedName("level_learned_at") val levelLearnedAt: Int,
    @SerializedName("move_learn_method.name") val moveLearnMethod: String,
    @SerializedName("move_learn_method.url") val moveLearnMethodUrl: String,
    @SerializedName("version_group.name") val versionGroup: String,
    @SerializedName("version_group.url") val versionGroupUrl: String
)
