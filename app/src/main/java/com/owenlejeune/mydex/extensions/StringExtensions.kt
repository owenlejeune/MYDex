package com.owenlejeune.mydex.extensions

fun String.getIdFromUrl(): Int {
    return split("/").find { it.toIntOrNull() != null }?.toInt() ?: -1
}