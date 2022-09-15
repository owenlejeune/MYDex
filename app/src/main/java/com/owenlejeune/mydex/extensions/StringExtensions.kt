package com.owenlejeune.mydex.extensions

fun String.charAtFromEnd(index: Int): Char {
    return get(length-1-index)
}