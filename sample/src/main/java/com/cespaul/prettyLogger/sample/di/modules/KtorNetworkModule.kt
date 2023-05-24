package com.cespaul.prettyLogger.sample.di.modules

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.dsl.module

val ktorNetworkModule = module {
    single { provideKtorHttpClient(get()) }
}

private fun provideKtorHttpClient(prettyLogger: com.cespaul.prettyLogger.ktor.PrettyLogger): HttpClient {
    return HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
            logger = prettyLogger
        }

        install(HttpTimeout) {
            requestTimeoutMillis = KTOR_TIMEOUT
            connectTimeoutMillis = KTOR_TIMEOUT
            socketTimeoutMillis = KTOR_TIMEOUT
        }

        install(ContentNegotiation) {
            json()
        }
    }
}

private const val KTOR_TIMEOUT: Long = 15000L