package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.game.PokedexNumber
import com.owenlejeune.mydex.api.pokeapi.v3.model.location.PalParkEncounter
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.ability.FlavorTextEntry
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.*

class PokemonSpecies(
    @SerializedName("base_happiness") val baseHappiness: Int,
    @SerializedName("capture_rate") val captureRate: Int,
    @SerializedName("color") val color: NameAndUrl,
    @SerializedName("egg_groups") val eggGroups: List<NameAndUrl>,
    @SerializedName("evolution_change.url") val evolutionChangeUrl: String,
    @SerializedName("flavor_text_entries") val flavorTextEntries: List<FlavorTextEntry>,
    @SerializedName("form_descriptions") val formDescriptions: List<Description>,
    @SerializedName("forms_switchable") val formsSwitchable: Boolean,
    @SerializedName("gender_rate") val genderRate: Int,
    @SerializedName("genera") val genera: List<Genus>,
    @SerializedName("generation") val generation: NameAndUrl,
    @SerializedName("growth_rate") val growthRate: NameAndUrl,
    @SerializedName("habitat") val habitat: NameAndUrl,
    @SerializedName("has_gender_differences") val hasGenderDifferences: Boolean,
    @SerializedName("hatch_counter") val hatchCounter: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("is_baby") val isBaby: Boolean,
    @SerializedName("is_legendary") val isLegendary: Boolean,
    @SerializedName("is_mythical") val isMythical: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("names") val names: List<NameAndLanguage>,
    @SerializedName("order") val order: Int,
    @SerializedName("pal_park_encounters") val palParkEncounters: List<PalParkEncounter>,
    @SerializedName("pokedex_numbers") val pokedexNumbers: List<PokedexNumber>,
    @SerializedName("shape") val shape: NameAndUrl,
    @SerializedName("varieties") val varieties: List<Variety>
)