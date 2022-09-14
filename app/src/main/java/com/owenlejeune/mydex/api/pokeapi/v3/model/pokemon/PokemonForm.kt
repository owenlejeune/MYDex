package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.Type
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.pokemon.sprite.Sprites

class PokemonForm(
    @SerializedName("form_name") val formName: String,
    @SerializedName("form_names") val formNames: List<NameAndLanguage>,
    @SerializedName("form_order") val formOrder: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("is_battle_only") val isBattleOnly: Boolean,
    @SerializedName("isDefault") val isDefault: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("order") val order: Int,
    @SerializedName("pokemon") val pokemon: NameAndUrl,
    @SerializedName("sprites") val sprites: Sprites,
    @SerializedName("types") val types: List<Type>,
    @SerializedName("version_group") val versionGroup: NameAndUrl
)
