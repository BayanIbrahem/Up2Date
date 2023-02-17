package com.dev.bayan_ibrahim.news_app.domain.repo

import androidx.lifecycle.LiveData
import com.dev.bayan_ibrahim.news_app.BuildConfig
import com.dev.bayan_ibrahim.news_app.domain.module.Article
import com.dev.bayan_ibrahim.news_app.domain.module.NewsResponse
import com.dev.bayan_ibrahim.news_app.utiles.Constants
import com.dev.bayan_ibrahim.news_app.utiles.annotations.Categories
import com.dev.bayan_ibrahim.news_app.utiles.annotations.Countries
import retrofit2.Response

interface NewsRepo {
    /**
     * api methods:
     */
    suspend fun getBreakingNews (
        key: String = BuildConfig.API_KEY,
        @Categories category: String = Constants.Categories.GENERAL,
        @Countries countryCode: String = Constants.Countries.UNITED_ARAB_EMIRATES ,
        page: Int,
        pageSize: Int = 1, // TODO make it annotation also
    ): Response<NewsResponse>
    suspend fun searchNews(
        key: String = BuildConfig.API_KEY,
        page: Int,
        pageSize: Int = 1, // TODO make it annotation also
        searchQuery: String,
    ): Response<NewsResponse>

    /**
     * room methods:
     */
    suspend fun insertOrUpdateArticle (article: Article)
    suspend fun deleteArticle (article: Article)
    fun getAllArticles(): LiveData<List<Article>>
    fun getArticle (url: String): LiveData<Article>
}