package com.isuru.kotlinapp.repository.local

import androidx.lifecycle.LiveData
import com.isuru.kotlinapp.repository.model.Article
import javax.inject.Inject

class NewsAppDaoClient @Inject constructor(private val newsAppDao: NewsAppDao) {

    suspend fun insertArticles(article: Article) {
        newsAppDao.insertArticles(article)
    }

    fun getArticles(): LiveData<List<Article>> {
       return newsAppDao.getArticles()
    }


}