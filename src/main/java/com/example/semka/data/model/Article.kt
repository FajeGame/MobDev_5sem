package com.example.semka.data.model

import com.google.gson.annotations.SerializedName

data class Article(
    val id: Int,
    val title: String,
    val summary: String,
    @SerializedName("published_at") val publishedAt: String?,
    val url: String,
    @SerializedName("image_url") val imageUrl: String?
)