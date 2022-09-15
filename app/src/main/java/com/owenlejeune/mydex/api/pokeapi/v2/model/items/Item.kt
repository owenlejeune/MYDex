package com.owenlejeune.mydex.api.pokeapi.v2.model.items

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v2.model.machine.MachineDetails
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonGameIndex
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability.EffectEntry
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.ability.FlavorTextEntry
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.sprite.ItemSprites

class Item(
    @SerializedName("attributes") val attributes: List<NameAndUrl>,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("cost") val cost: Int,
    @SerializedName("fling_power") val flingPower: Int,
    @SerializedName("fling_effect") val flingEffect: NameAndUrl,
    @SerializedName("category") val category: NameAndUrl,
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry>,
    @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("game_indices") val gameIndices: List<PokemonGameIndex>,
    @SerializedName("held_by_pokemon") val heldByPokemon: List<ItemHolderPokemon>,
    @SerializedName("machines") val machines: List<MachineDetails>,
    @SerializedName("sprites") val defaultSprite: ItemSprites
)