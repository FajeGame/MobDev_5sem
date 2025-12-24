package com.example.semka.data.api

import com.example.semka.data.model.Article
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("articles")
    suspend fun getArticles(
        @Query("limit") limit: Int = 10
    ): ArticlesResponse
}

data class ArticlesResponse(
    val results: List<Article>
)