package com.dev.bayan_ibrahim.news_app.data.repo

import androidx.lifecycle.LiveData
import com.dev.bayan_ibrahim.news_app.data.local.ArticlesDao
import com.dev.bayan_ibrahim.news_app.data.remote.NewsApi
import com.dev.bayan_ibrahim.news_app.domain.module.Article
import com.dev.bayan_ibrahim.news_app.domain.module.NewsResponse
import com.dev.bayan_ibrahim.news_app.domain.repo.NewsRepo
import retrofit2.Response
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    val api: NewsApi,
    val dao: ArticlesDao,
): NewsRepo {
    override suspend fun getBreakingNews(
        key: String,
        category: String,
        countryCode: String,
        page: Int,
        pageSize: Int
    ): Response<NewsResponse> {
        return api.getBreakingNews(
            key = key,
            category = category,
            countryCode = countryCode,
            page = page,
            pageSize = pageSize
        )
    }

    override suspend fun searchNews(
        key: String,
        page: Int,
        pageSize: Int,
        searchQuery: String
    ): Response<NewsResponse> {
        return api.searchNews(
            key = key,
            page = page,
            pageSize = pageSize,
            searchQuery = searchQuery
        )
    }

    override suspend fun insertOrUpdateArticle(article: Article) {
        return dao.insertOrUpdateArticle(article = article)
    }

    override suspend fun deleteArticle(article: Article) {
        return dao.deleteArticle(article = article)
    }

    override fun getAllArticles(): LiveData<List<Article>> {
        return dao.getAllArticles()
    }

    override fun getArticle(url: String): LiveData<Article> {
        return dao.getArticle(url = url)
    }
}