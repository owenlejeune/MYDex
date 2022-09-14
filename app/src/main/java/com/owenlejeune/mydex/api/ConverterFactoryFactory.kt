package com.owenlejeune.mydex.api

import retrofit2.Converter

interface ConverterFactoryFactory {

    fun get(): Converter.Factory

}
