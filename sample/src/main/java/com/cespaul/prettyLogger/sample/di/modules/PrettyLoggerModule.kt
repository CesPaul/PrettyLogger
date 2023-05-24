package com.cespaul.prettyLogger.sample.di.modules

import android.util.Log
import org.koin.dsl.module


val prettyLoggerModule = module {
    single { provideOkHttpPrettyLogger() }
    single { provideKtorPrettyLogger() }
}

private fun provideOkHttpPrettyLogger(): com.cespaul.prettyLogger.okhttp.PrettyLogger =
    com.cespaul.prettyLogger.okhttp.PrettyLogger {
        Log.d(TAG_OKHTTP, it)
    }

private fun provideKtorPrettyLogger(): com.cespaul.prettyLogger.ktor.PrettyLogger =
    com.cespaul.prettyLogger.ktor.PrettyLogger {
        Log.d(TAG_KTOR, it)
    }


private const val TAG_OKHTTP = "TAG OkHttp"
private const val TAG_KTOR = "TAG KTOR"