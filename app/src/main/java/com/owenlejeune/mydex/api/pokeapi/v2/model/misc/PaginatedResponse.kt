package com.owenlejeune.mydex.api.pokeapi.v2.model.misc

import com.google.gson.annotations.SerializedName

class PaginatedResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<NameAndUrl>
)