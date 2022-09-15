package com.owenlejeune.mydex.api.pokeapi.v2.model.misc

import com.google.gson.annotations.SerializedName

class PastDamageRelation(
    @SerializedName("damage_relation") val damageRelation: DamageRelations,
    @SerializedName("generation") val generation: NameAndUrl
)
