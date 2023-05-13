package com.cespaul.prettyLogger.sample

import android.app.Application
import com.cespaul.prettyLogger.sample.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SampleApplication)
            modules(
                listOf(
                    appModule,
                    prettyLoggerModule,
                    retrofitModule,
                    ktorNetworkModule,
                    okhttpNetworkModule
                )
            )
        }
    }

}