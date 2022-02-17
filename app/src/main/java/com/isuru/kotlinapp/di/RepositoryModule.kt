package com.isuru.kotlinapp.di

import com.isuru.kotlinapp.repository.NewsRepository
import com.isuru.kotlinapp.repository.local.NewsAppDaoClient
import com.isuru.kotlinapp.repository.remote.BackEndApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun getNewsRepository(backEndApiClient: BackEndApiClient, newsAppDaoClient: NewsAppDaoClient): NewsRepository{
        return NewsRepository(backEndApiClient,newsAppDaoClient)
    }
}
