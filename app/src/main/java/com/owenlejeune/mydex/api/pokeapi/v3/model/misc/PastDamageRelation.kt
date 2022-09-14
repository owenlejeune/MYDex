package com.owenlejeune.mydex.api.pokeapi.v3.model.misc

import com.google.gson.annotations.SerializedName

class PastDamageRelation(
    @SerializedName("damage_relation") val damageRelation: DamageRelations,
    @SerializedName("generation") val generation: NameAndUrl
)
