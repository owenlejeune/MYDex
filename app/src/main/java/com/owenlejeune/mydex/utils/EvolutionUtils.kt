package com.owenlejeune.mydex.utils

import com.owenlejeune.mydex.api.pokeapi.v2.PokemonService
import com.owenlejeune.mydex.api.pokeapi.v2.model.evolution.ChainLink
import com.owenlejeune.mydex.api.pokeapi.v2.model.evolution.EvolutionDetails
import com.owenlejeune.mydex.api.pokeapi.v2.model.evolution.EvolutionTrigger
import com.owenlejeune.mydex.api.pokeapi.v2.model.pokemon.PokemonSpecies
import com.owenlejeune.mydex.extensions.getIdFromUrl
import com.owenlejeune.mydex.extensions.getIfNotEmpty
import com.owenlejeune.mydex.extensions.getNameForLanguage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object EvolutionUtils {

    fun getEvolutionFromChainLink(
        link: ChainLink?,
        callback: (List<EvolutionStage>) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val evolutionStages = ArrayList<EvolutionStage>()

            var nextLink: ChainLink? = link
            while(nextLink != null) {
                val id = nextLink.species.url.getIdFromUrl()
                val evolvesFrom = DataManager.getPokemonSpeciesByIdSync(id)

                if (nextLink.evolves_to != null) {
                    val evolutions = ArrayList<Evolution>()
                    nextLink.evolves_to!!.forEach { et ->
                        et?.let {
                            val etId = it.species.url.getIdFromUrl()
                            val evolvesTo = DataManager.getPokemonSpeciesByIdSync(etId)

                            it.evolutionDetails.forEach { details ->
                                val triggerAndCondition =
                                    evolutionDetailsToTriggerAndCondition(details)
                                evolutions.add(Evolution(evolvesTo, triggerAndCondition))
                            }
                        }
                    }
                    val es = EvolutionStage(evolvesFrom, evolutions)
                    evolutionStages.add(es)
                }
                nextLink = nextLink.evolves_to?.getIfNotEmpty(0)
            }
            withContext(Dispatchers.Main) {
                callback(evolutionStages)
            }
        }
    }

    private fun evolutionDetailsToTriggerAndCondition(details: EvolutionDetails): EvolutionTriggerAndCondition {
        val trigger = details.trigger.name
        val condition = if (details.item != null) {
            details.item.name
        } else if (details.gender != null) {
            if (details.gender == 1) "female" else "male"
        } else if (details.heldItem != null) {
            details.heldItem.name
        } else if (details.knownMove != null) {
            details.knownMove.name
        } else if (details.knownMoveType != null) {
            details.knownMoveType.name
        } else if (details.location != null) {
            details.location.name
        } else if (details.minLevel != null) {
            details.minLevel.toString()
        } else if (details.minHappiness != null) {
            details.minHappiness.toString()
        } else if (details.minBeauty != null) {
            details.minBeauty.toString()
        } else if (details.minAffection != null) {
            details.minAffection.toString()
        } else if (details.needsOverworldRain) {
            "Needs rain"
        } else if (details.partySpecies != null) {
            details.partySpecies.name
        } else if (details.partyType != null) {
            details.partyType.name
        } else if (details.relativePhysicalStats != null) {
            details.relativePhysicalStats.toString()
        } else if (details.timeOfDay != null) {
            details.timeOfDay
        } else if (details.tradeSpecies != null) {
            details.tradeSpecies.name
        } else if (details.turnUpsideDown) {
            "Turn 3DS upside-down"
        } else {
            ""
        }
        return EvolutionTriggerAndCondition(trigger, condition)
    }

}

class EvolutionStage(
    val evolvesFrom: PokemonSpecies,
    val evolvesTo: List<Evolution>?
)

class Evolution(
    val evolvesTo: PokemonSpecies,
    val triggerAndCondition: EvolutionTriggerAndCondition
)

class EvolutionTriggerAndCondition(
//    trigger: EvolutionTrigger,
    val trigger: String,
    val condition: String
)