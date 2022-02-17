package com.isuru.kotlinapp.repository

import com.isuru.kotlinapp.repository.local.NewsAppDaoClient
import com.isuru.kotlinapp.repository.model.Article
import com.isuru.kotlinapp.repository.model.NewsResponse
import com.isuru.kotlinapp.repository.remote.BackEndApiClient
import retrofit2.Response

class NewsRepository constructor(private val backEndApiClient: BackEndApiClient,private val newsAppDaoClient: NewsAppDaoClient) {

    suspend fun getBreakingNews(country: String, category: String): Response<NewsResponse> {
        return backEndApiClient.getBreakingNews(country = country, category = category)
    }

    suspend fun insertArticles(article: Article) {
        newsAppDaoClient.insertArticles(article)

    }


}