package com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.gender

import com.google.gson.annotations.SerializedName
import com.owenlejeune.mydex.api.pokeapi.v3.model.misc.NameAndUrl
import com.owenlejeune.mydex.api.pokeapi.v3.model.pokemon.PokemonSpeciesDetails

class Gender(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("pokemon_species_details") val pokemonSpeciesDetails: List<PokemonSpeciesDetails>,
    @SerializedName("required_for_evolution") val requiredForEvolution: List<NameAndUrl>
)