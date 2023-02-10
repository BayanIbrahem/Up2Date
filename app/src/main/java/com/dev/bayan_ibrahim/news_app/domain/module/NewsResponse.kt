package com.dev.bayan_ibrahim.news_app.domain.module

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)