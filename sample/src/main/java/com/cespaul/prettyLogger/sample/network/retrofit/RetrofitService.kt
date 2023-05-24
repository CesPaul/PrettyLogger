package com.cespaul.prettyLogger.sample.network.retrofit

import retrofit2.Response
import retrofit2.http.GET
import com.cespaul.prettyLogger.sample.model.PostItem

interface RetrofitService {
    @GET("posts")
    suspend fun getPosts(): Response<List<PostItem>>
}