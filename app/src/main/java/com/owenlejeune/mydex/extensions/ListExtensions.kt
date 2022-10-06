package com.owenlejeune.mydex.extensions

import androidx.compose.ui.text.intl.Locale
import com.owenlejeune.mydex.api.pokeapi.v2.model.misc.NameAndLanguage

fun List<NameAndLanguage>.getNameForLanguage(): String? {
    val lang = Locale.current.language
    val defLang = "en"
    return find { it.language.name == lang }?.name ?: find { it.language.name == defLang}?.name
}

fun <T> List<T>.getIfNotEmpty(index: Int): T? {
    return if (isNotEmpty()) get(index) else null
}