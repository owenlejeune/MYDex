package com.owenlejeune.mydex.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient

class DebugHttpClient: HttpClient {
    override val httpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()
}