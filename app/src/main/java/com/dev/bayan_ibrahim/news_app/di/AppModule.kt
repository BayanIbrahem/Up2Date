package com.dev.bayan_ibrahim.news_app.di

import com.dev.bayan_ibrahim.news_app.data.remote.NewsApi
import com.dev.bayan_ibrahim.news_app.utiles.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}