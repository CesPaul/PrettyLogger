package com.cespaul.prettyLogger.sample.di.modules

import com.cespaul.prettyLogger.sample.network.retrofit.RetrofitService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single { provideRetrofit(get()) }
    factory { provideRetrofitService(get()) }
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

private fun provideRetrofitService(retrofit: Retrofit): RetrofitService =
    retrofit.create(RetrofitService::class.java)


private const val BASE_URL = "https://jsonplaceholder.typicode.com"
const val GET_POSTS = "$BASE_URL/posts"
