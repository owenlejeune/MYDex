package com.owenlejeune.mydex.api.pokeapi.v2.model.misc

import com.google.gson.annotations.SerializedName

class AwesomeName(
    @SerializedName("awesome_name") val awesomeName: String,
    @SerializedName("language") val language: NameAndUrl
)
