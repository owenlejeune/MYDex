package com.owenlejeune.mydex.api.pokeapi.v2.model.misc

import com.google.gson.annotations.SerializedName

class DamageRelations(
    @SerializedName("double_damage_from") val doubleDamageFrom: List<NameAndUrl>,
    @SerializedName("double_damage_to") val doubleDamageTo: List<NameAndUrl>,
    @SerializedName("half_damage_from") val halfDamageFrom: List<NameAndUrl>,
    @SerializedName("half_damage_to") val halfDamageTo: List<NameAndUrl>,
    @SerializedName("no_damage_to") val noDamageTo: List<NameAndUrl>,
    @SerializedName("no_damage_from") val noDamageFrom: List<NameAndUrl>
)
