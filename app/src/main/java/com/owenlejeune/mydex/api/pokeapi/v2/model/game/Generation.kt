package com.owenlejeune.mydex.api.pokeapi.v2.model.game

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl

class Generation(
    @SerializedName("abilities") val abilities: List<NameAndUrl>,
    @SerializedName("id") val id: Int,
    @SerializedName("main_region") val mainRegion: NameAndUrl,
    @SerializedName("moves") val moves: List<NameAndUrl>,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("pokemon_species") val pokemonSpecies: List<NameAndLanguage>,
    @SerializedName("types") val types: List<NameAndUrl>,
    @SerializedName("version_groups") val versionGroups: List<NameAndUrl>
)