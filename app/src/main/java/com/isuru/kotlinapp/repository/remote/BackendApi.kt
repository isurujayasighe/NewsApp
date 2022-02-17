package com.isuru.kotlinapp.repository.remote

import com.isuru.kotlinapp.repository.model.NewsResponse
import com.isuru.kotlinapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BackendApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<NewsResponse>
}