package com.owenlejeune.mydex.api

import okhttp3.OkHttpClient

interface HttpClient {
    val httpClient: OkHttpClient
}
