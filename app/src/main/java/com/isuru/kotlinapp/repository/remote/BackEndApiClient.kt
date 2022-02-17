package com.isuru.kotlinapp.repository.remote

import com.isuru.kotlinapp.repository.model.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class BackEndApiClient @Inject constructor(private val backendApi: BackendApi) {

    suspend fun getBreakingNews(country: String, category: String): Response<NewsResponse> {
        return backendApi.getBreakingNews(country = country, category = category)
    }


}