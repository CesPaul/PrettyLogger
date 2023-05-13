package com.cespaul.prettyLogger.sample

import androidx.lifecycle.ViewModel
import com.cespaul.prettyLogger.sample.di.modules.GET_POSTS
import com.cespaul.prettyLogger.sample.model.TestPostModel
import com.cespaul.prettyLogger.sample.model.TestPostModelItem
import com.cespaul.prettyLogger.sample.network.retrofit.RetrofitSevice
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel(), KoinComponent {

    private val retrofitService: RetrofitSevice by inject()
    private val httpClient: HttpClient by inject()

    fun getPosts(): Flow<TestPostModel> = flow {
        val postsResponse = retrofitService.getPosts()
        postsResponse.body()?.let {
            emit(it)
        }
    }

    fun getPostsKtor(): Flow<TestPostModel> = flow {
        val response = httpClient.get {
            url(GET_POSTS)
            accept(ContentType.Application.Json)
        }
        if (response.status.isSuccess()) {
            val body: List<TestPostModelItem> = response.body()
            emit(body as TestPostModel)
        }
    }
}