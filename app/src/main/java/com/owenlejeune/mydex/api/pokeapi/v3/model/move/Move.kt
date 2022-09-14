package com.owenlejeune.mydex.api.pokeapi.v3.model.move

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.machine.MachineDetails
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.ability.EffectChange
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.ability.EffectEntry
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.ability.FlavorTextEntry

class Move (
    @SerializedName("accuracy") val accuracy: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndUrl>,
    @SerializedName("power") val power: Int,
    @SerializedName("pp") val pp: Int,
    @SerializedName("priority") val priority: Int,
    @SerializedName("contest_combos") val contestCombos: ContestCombos,
    @SerializedName("contest_effect.url") val contestEffectUrl: String,
    @SerializedName("contest_type") val contestType: NameAndUrl,
    @SerializedName("damage_class") val damageClass: NameAndUrl,
    @SerializedName("effect_chance") val effectChance: Int,
    @SerializedName("effect_changes") val effectChanges: List<EffectChange>,
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry>,
    @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("generation") val generation: NameAndUrl,
    @SerializedName("learned_by_pokemon") val learnedByPokemon: List<NameAndUrl>,
    @SerializedName("machines") val machines: List<MachineDetails>,
    @SerializedName("meta") val meta: MoveMeta,
    @SerializedName("super_contest_effect.url") val superContestEffectUrl: String,
    @SerializedName("target") val target: NameAndUrl,
    @SerializedName("type") val type: NameAndUrl
)