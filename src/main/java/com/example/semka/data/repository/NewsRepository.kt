package com.example.semka.data.repository

import com.example.semka.data.api.NewsApi

class NewsRepository(private val api: NewsApi) {

    suspend fun getArticles(): List<com.example.semka.data.model.Article> {
        return api.getArticles(limit = 10).results
    }
}