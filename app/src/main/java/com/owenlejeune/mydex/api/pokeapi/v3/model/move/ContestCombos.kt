package com.owenlejeune.mydex.api.pokeapi.v3.model.move

import com.google.gson.annotations.SerializedName

class ContestCombos(
    @SerializedName("normal") val normalCombo: ContestCombo?,
    @SerializedName("super") val superCombo: ContestCombo?
)
