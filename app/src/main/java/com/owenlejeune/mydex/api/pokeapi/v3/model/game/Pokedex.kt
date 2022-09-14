package com.owenlejeune.mydex.api.pokeapi.v3.model.game

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.Description
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl

class Pokedex(
    @SerializedName("descriptions") val descriptions: List<Description>,
    @SerializedName("id") val id: Int,
    @SerializedName("is_main_series") val isMainSeries: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("pokemon_entries") val pokemonEntries: List<PokemonEntry>,
    @SerializedName("region") val region: NameAndUrl,
    @SerializedName("version_groups") val regionGroups: List<NameAndUrl>
)