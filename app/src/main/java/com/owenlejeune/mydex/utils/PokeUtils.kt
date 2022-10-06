package com.owenlejeune.mydex.utils

import com.owenlejeune.mydex.api.pokeapi.v2.model.evolution.EvolutionDetails
import kotlin.math.ceil
import kotlin.math.floor

object PokeUtils {

    private val HEC_TO_LBS = 0.22f
    private val HEC_TO_KG = 0.1f
    private val DEC_TO_CM = 10
    private val CM_TO_IN = 2.54
    private val IN_TO_FT = 12
    private val GENDER_RATE = 1f/8f

    fun idToDexNumber(id: Int, includeNumberSign: Boolean = true): String {
        val padded = id.toString().padStart(3, '0')
        return if (includeNumberSign) {
            "#$padded"
        } else {
            padded
        }
    }

    fun spriteFromId(id: Int): String {
        val paddedNumber = idToDexNumber(id, false)
        return "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${paddedNumber}.png"
    }

    fun weightInPounds(weight: Int): String {
        return "${weight * HEC_TO_LBS} lbs"
    }

    fun weightInKg(weight: Int): String {
        return "${weight * HEC_TO_KG} kg"
    }

    fun heightToCm(height: Int): String {
        return "${height * DEC_TO_CM} cm"
    }

    fun heightToFtIn(height: Int): String {
        val heightCm = height * DEC_TO_CM

        val feet = floor((heightCm / CM_TO_IN) / IN_TO_FT).toInt()
        val inches = ceil((heightCm / CM_TO_IN) - (feet * IN_TO_FT)).toInt()

        return "${feet}' ${inches}\""
    }

    fun genderRateToPercentage(genderRate: Int): Float {
       return genderRate.toFloat() * GENDER_RATE * 100
    }

    fun evolutionDetailsToConditionString(evolutionDetails: EvolutionDetails): String {
        return ""
    }

}