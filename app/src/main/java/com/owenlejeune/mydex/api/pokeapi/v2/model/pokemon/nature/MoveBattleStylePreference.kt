package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.nature

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class MoveBattleStylePreference(
    @SerializedName("high_hp_preference") val highHpPreference: Int,
    @SerializedName("low_hp_preference") val lowHpPreference: Int,
    @SerializedName("move_battle_style") val moveBattleStyle: NameAndUrl
)
