package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.ability

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndLanguage

class Ability(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("is_main_series") val isMainSeries: Boolean,
    @SerializedName("effect_changes") val effectChanges: List<EffectChange>,
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry>,
    @SerializedName("flavor_text_entries") val flavourTextEntries: List<FlavorTextEntry>,
    @SerializedName("generation") val generation: AbilityGeneration,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("pokemon") val pokemon: List<AbilityPokemon>
)