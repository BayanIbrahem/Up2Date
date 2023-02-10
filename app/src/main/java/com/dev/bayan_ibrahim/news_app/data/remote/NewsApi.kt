package com.dev.bayan_ibrahim.news_app.data.remote

import com.dev.bayan_ibrahim.news_app.domain.module.NewsResponse
import com.dev.bayan_ibrahim.news_app.utiles.Categories
import com.dev.bayan_ibrahim.news_app.utiles.Constants
import com.dev.bayan_ibrahim.news_app.utiles.Countries
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * apiKey "REQUIRED": Your API key. Alternatively you can provide this via the X-Api-Key HTTP header.

 * country: The 2-letter ISO 3166-1 code of the country you want to get headlines for.

 * category: The category you want to get headlines for.
        Possible options: business - entertainment - general - health - science - sports - technology.
        Note: you can't mix this param with the sources param.

 * sources:
        A comma-separated string of identifiers for the news sources or blogs you want headlines from.
        Use the https://newsapi.org/docs/endpoints/sources endpoint to locate these programmatically
        or look at the sources index.
        Note: you can't mix this param with the country or category params.

 * q: Keywords or a phrase to search for.
 */
interface NewsApi {

    @GET(Constants.Api.TOP_HEADLINES)
    fun getBreakingNews(
        @Query ("apiKey") key: String,
        @Query ("country") country: Countries = Countries.UNITED_ARAB_EMIRATES,
        @Query ("category") category: Categories = Categories.GENERAL,
    ): NewsResponse

}