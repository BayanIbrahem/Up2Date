package com.dev.bayan_ibrahim.news_app.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dev.bayan_ibrahim.news_app.domain.module.Article

@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateArticle (article: Article)

    @Delete
    suspend fun deleteArticle (article: Article)

    @Query ("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Query ("SELECT * FROM articles where article_url = :url")
    fun getArticle (url: String): LiveData<Article>
}