package com.isuru.kotlinapp.di

import android.app.Application
import com.isuru.kotlinapp.repository.local.NewsAppDao
import com.isuru.kotlinapp.repository.local.NewsAppDatabase
import com.isuru.kotlinapp.repository.local.SharedPreferencesClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {

    @Singleton
    @Provides
    fun getSharedPreferencesClient(application: Application):SharedPreferencesClient{
        return SharedPreferencesClient(application)
    }

    @Singleton
    @Provides
    fun getNewsAppDatabase(application: Application): NewsAppDatabase{
        return NewsAppDatabase.newsAppDatabase(application)
    }

    @Singleton
    @Provides
    fun getNewsAppDao(newsAppDatabase: NewsAppDatabase): NewsAppDao{
        return newsAppDatabase.newsApiDao()
    }



}