package com.dev.bayan_ibrahim.news_app.domain.module

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "articles")
data class Article(
    @ColumnInfo (name = "article_author")
    val author: String,
    @ColumnInfo (name = "article_content")
    val content: String,
    @ColumnInfo (name = "article_description")
    val description: String,
    @ColumnInfo (name = "article_publishedAt")
    val publishedAt: String,
    @ColumnInfo (name = "article_source")
    val source: Source,
    @ColumnInfo (name = "article_title")
    val title: String,
    @PrimaryKey
    @ColumnInfo (name = "article_url")
    val url: String,
    @ColumnInfo (name = "article_urlToImage")
    val urlToImage: String
)