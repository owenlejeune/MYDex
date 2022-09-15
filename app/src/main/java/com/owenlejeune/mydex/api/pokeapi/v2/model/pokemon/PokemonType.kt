package com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.*

class PokemonType(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("damage_relations") val damageRelations: DamageRelations,
    @SerializedName("game_indices") val gameIndices: List<PokemonGameIndex>,
    @SerializedName("generation") val generation: NameAndUrl,
    @SerializedName("move_damage_class") val moveDamageClass: NameAndUrl,
    @SerializedName("moves") val moves: List<NameAndUrl>,
    @SerializedName("past_damage_relations") val pastDamageRelations: List<PastDamageRelation>,
    @SerializedName("pokemon") val pokemon: List<TypePokemon>
)