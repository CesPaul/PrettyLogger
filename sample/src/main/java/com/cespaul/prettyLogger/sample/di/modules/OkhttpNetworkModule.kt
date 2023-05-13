package com.cespaul.prettyLogger.sample.di.modules

import com.cespaul.prettyLogger.okhttp.PrettyLogger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val okhttpNetworkModule = module {
    single { provideOkHttpClient(get()) }
}

private fun provideOkHttpClient(prettyLogger: PrettyLogger): OkHttpClient {
    val okHttpClientBuilder = OkHttpClient.Builder()
    return okHttpClientBuilder
        .addInterceptor(HttpLoggingInterceptor(prettyLogger).setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(OKHTTP_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(OKHTTP_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(OKHTTP_TIMEOUT, TimeUnit.SECONDS)
        .build()
}

private const val OKHTTP_TIMEOUT: Long = 30