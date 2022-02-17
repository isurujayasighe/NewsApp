package com.isuru.kotlinapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isuru.kotlinapp.repository.NewsRepository
import com.isuru.kotlinapp.repository.model.NewsResponse
import com.isuru.kotlinapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsAppViewModel @Inject constructor(private val newsRepository: NewsRepository) :
    ViewModel() {

    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()

    fun getNewsFromApi(country: String, category: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(country, category)
        if (response.isSuccessful) {
            response.body()?.let { newsResponse ->
                breakingNews.postValue(Resource.Success(newsResponse))
            }
        } else {
            breakingNews.postValue(Resource.Error(response.message()))

        }
    }
}