package com.example.semka.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semka.data.model.Article
import com.example.semka.data.repository.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.semka.data.api.NewsApi

data class NewsUiState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false
)

class NewsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState: StateFlow<NewsUiState> = _uiState

    private val repository: NewsRepository by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spaceflightnewsapi.net/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(NewsApi::class.java)
        NewsRepository(api)
    }

    init {
        loadArticles()
    }

    private fun loadArticles() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val articles = repository.getArticles()
                _uiState.value = NewsUiState(articles = articles, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = NewsUiState(articles = emptyList(), isLoading = false)
            }
        }
    }
}