package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.characteristic

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.Description

class Characteristic(
    @SerializedName("id") val id: Int,
    @SerializedName("highest_stat.name") val highestStat: String,
    @SerializedName("highest_stat.url") val highestStatUrl: String,
    @SerializedName("possible_values") val possibleValues: List<Int>,
    @SerializedName("gene_modulo") val geneModulo: Int,
    @SerializedName("descriptions") val descriptions: List<Description>
)