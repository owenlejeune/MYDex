package com.owenlejeune.mydex.api

import okhttp3.OkHttpClient

class ProdHttpClient: HttpClient {
    override val httpClient: OkHttpClient
        get() = OkHttpClient.Builder().build()
}