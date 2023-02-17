package com.dev.bayan_ibrahim.news_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dev.bayan_ibrahim.news_app.data.utiles.DatabaseConverters
import com.dev.bayan_ibrahim.news_app.domain.module.Article
import com.dev.bayan_ibrahim.news_app.utiles.Constants

@Database (
    entities = [Article::class],
    version = Constants.Database.VERSION
)
@TypeConverters (DatabaseConverters::class)
abstract class ArticlesDatabase: RoomDatabase() {
    abstract val dao: ArticlesDao
}