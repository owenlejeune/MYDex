package com.owenlejeune.mydex.api.pokeapi.v3.model.location

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class Region(
    @SerializedName("id") val id: Int,
    @SerializedName("locations") val locations: List<NameAndUrl>,
    @SerializedName("main_generation") val mainGeneration: NameAndUrl,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("pokedexes") val pokedexes: List<NameAndUrl>,
    @SerializedName("version_groups") val versionGroups: List<NameAndUrl>
)