package com.owenlejeune.mydex.api.pokeapi.v3.model.location

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.PokemonGameIndex

class Location(
    @SerializedName("areas") val areas: List<NameAndUrl>,
    @SerializedName("game_indices") val gameIndices: List<PokemonGameIndex>,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("region") val region: NameAndUrl
)