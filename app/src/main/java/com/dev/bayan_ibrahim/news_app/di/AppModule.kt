package com.dev.bayan_ibrahim.news_app.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.dev.bayan_ibrahim.news_app.data.local.ArticlesDao
import com.dev.bayan_ibrahim.news_app.data.local.ArticlesDatabase
import com.dev.bayan_ibrahim.news_app.data.remote.NewsApi
import com.dev.bayan_ibrahim.news_app.data.repo.NewsRepoImpl
import com.dev.bayan_ibrahim.news_app.domain.repo.NewsRepo
import com.dev.bayan_ibrahim.news_app.utiles.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger hilt, for singleton components...
 * this already provides singleton instances for:
 * -
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun getDatabase (app: Application): ArticlesDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = ArticlesDatabase::class.java,
            name = Constants.Database.NAME,
        ).build()
    }
    @Provides
    @Singleton
    fun getDao (db: ArticlesDatabase): ArticlesDao = db.dao

    @Provides
    @Singleton
    fun getNewsRepo (api: NewsApi, dao: ArticlesDao): NewsRepo {
        return NewsRepoImpl (api = api, dao = dao)
    }
}