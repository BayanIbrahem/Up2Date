package com.dev.bayan_ibrahim.news_app.data.remote

import android.content.res.TypedArray
import com.dev.bayan_ibrahim.news_app.BuildConfig
import com.dev.bayan_ibrahim.news_app.domain.module.NewsResponse
import com.dev.bayan_ibrahim.news_app.utiles.Constants
import com.dev.bayan_ibrahim.news_app.utiles.annotations.Categories
import com.dev.bayan_ibrahim.news_app.utiles.annotations.Countries
import com.dev.bayan_ibrahim.news_app.utiles.annotations.SearchIn
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 FIRST OF ALL THERE IS TWO QUERIES USED IN THIS API "everything" and "top-headlines"
  I WILL MARK PARAMETERS FOR "everything" QUERY WITH e AND FOR "top-headlines" WITH t AND b FOR BOTH.

 * apiKey (b) "REQUIRED": Your API key. Alternatively you can provide this via the X-Api-Key HTTP header.

 * country (b): The 2-letter ISO 3166-1 code of the country you want to get headlines for.
        Note: it is Available at [Constants.Countries] object

 * q (b): Keywords or a phrase to search for.
        Advanced search is supported here (e):
        Surround phrases with quotes (") for exact match.
        Prepend words or phrases that must appear with a + symbol. Eg: +bitcoin
        Prepend words that must not appear with a - symbol. Eg: -bitcoin
        Alternatively you can use the AND / OR / NOT keywords, and optionally group these with parenthesis. Eg: crypto AND (ethereum OR litecoin) NOT bitcoin.
        The complete value for q must be URL-encoded. Max length: 500 chars.

 * searchIn (e): The fields to restrict your q search to.
        The possible options are:
        title
        description
        content
        Multiple options can be specified by separating them with a comma, for example: title,content.
        This parameter is useful if you have an edge case where searching all the fields is not giving
        the desired outcome, but generally you should not need to set this.

 * sources (b):
        A comma-separated string of identifiers for the news sources or blogs you want headlines from.
        Use the https://newsapi.org/docs/endpoints/sources endpoint to locate these programmatically
        or look at the sources index.
        Note: you can't mix this param with the country or category params.

 * category (t): The category you want to get headlines for.
        Possible options: business - entertainment - general - health - science - sports - technology.
        Note: you can't mix this param with the sources param.

 * from (e): A date and optional time for the oldest article allowed.
        This should be in ISO 8601 format
        (e.g. 2023-02-10 or 2023-02-10T19:07:19)
        Default: the oldest according to your plan.

 * to (e): A date and optional time for the newest article allowed.
        This should be in ISO 8601 format
        (e.g. 2023-02-10 or 2023-02-10T19:07:19)

 * language (e): The 2-letter ISO-639-1 code of the language you want to get headlines for.
        Possible options are in [Constants.Languages] object

 * sortBy (e): The order to sort the articles in.
        Possible options: relevancy, popularity, publishedAt.
        relevancy = articles more closely related to q come first.
        popularity = articles from popular sources and publishers come first.
        publishedAt = newest articles come first.
        Default: publishedAt

 * pageSize (int) (b):  The number of results to return per page (request). 20 is the default, 100 is the maximum.

 * page (int) (b): Use this to page through the results if the total results found is greater than the page size.
 */
interface NewsApi {

    @GET(Constants.Api.TOP_HEADLINES)
    suspend fun getBreakingNews(
        @Query ("apiKey") key: String,
        @Query ("category") @Categories category: String,
        @Query ("country") @Countries countryCode: String,
        @Query ("page") page: Int,
        @Query ("pageSize") pageSize: Int, // TODO make it annotation also
    ): Response<NewsResponse>

    @GET(Constants.Api.EVERYTHING)
    suspend fun searchNews(
        @Query ("apiKey") key: String,
        @Query ("page") page: Int,
        @Query ("pageSize") pageSize: Int, // TODO make it annotation also
        @Query ("q") searchQuery: String,
    ): Response<NewsResponse>

    // TODO: add advanced search query.
}