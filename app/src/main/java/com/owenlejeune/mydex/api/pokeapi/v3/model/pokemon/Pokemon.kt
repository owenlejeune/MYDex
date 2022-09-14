package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.Stat
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.Type
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.sprite.Sprites

class Pokemon(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("order") val order: Int,
    @SerializedName("base_experience") val baseExperience: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("is_default") val isDefault: Boolean,
    @SerializedName("location_area_encounters") val locationAreaEncountersUrl: String,
    @SerializedName("abilities") val abilities: List<PokemonAbility>,
    @SerializedName("forms") val forms: List<NameAndUrl>,
    @SerializedName("game_indices") val gameIndices: List<PokemonGameIndex>,
    @SerializedName("moves") val moves: List<PokemonMove>,
    @SerializedName("species") val species: NameAndUrl,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("stats") val state: List<Stat>,
    @SerializedName("types") val types: List<Type>
)