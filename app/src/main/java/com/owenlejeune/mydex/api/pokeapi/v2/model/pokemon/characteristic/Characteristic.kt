package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.characteristic

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.Description
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class Characteristic(
    @SerializedName("id") val id: Int,
    @SerializedName("highest_stat") val highestStat: NameAndUrl,
    @SerializedName("possible_values") val possibleValues: List<Int>,
    @SerializedName("gene_modulo") val geneModulo: Int,
    @SerializedName("descriptions") val descriptions: List<Description>
)