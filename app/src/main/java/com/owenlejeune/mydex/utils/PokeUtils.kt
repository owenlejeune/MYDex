package com.owenlejeune.mydex.utils

import kotlin.math.ceil
import kotlin.math.floor

object PokeUtils {

    private val HEC_TO_LBS = 0.22f
    private val HEC_TO_KG = 0.1f
    private val DEC_TO_CM = 10
    private val CM_TO_IN = 2.54
    private val IN_TO_FT = 12

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

    fun weightInPounds(weight: Int): Float {
        return weight * HEC_TO_LBS
    }

    fun weightInKg(weight: Int): Float {
        return weight * HEC_TO_KG
    }

    fun heightToCm(height: Int): Int {
        return height * DEC_TO_CM
    }

    fun heightToFtIn(height: Int): Pair<Int, Int> {
        val heightCm = height * DEC_TO_CM

        val feet = floor((height / CM_TO_IN) / IN_TO_FT).toInt()
        val inches = ceil((height / CM_TO_IN) - (feet * IN_TO_FT)).toInt()

        return Pair(feet, inches)
    }

}