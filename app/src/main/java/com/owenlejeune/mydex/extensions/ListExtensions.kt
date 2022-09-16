package com.owenlejeune.mydex.extensions

import androidx.compose.ui.text.intl.Locale
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndLanguage

fun List<NameAndLanguage>.getNameForLanguage(): String? {
    val lang = Locale.current.language
    return find { it.language.name == lang }?.name
}