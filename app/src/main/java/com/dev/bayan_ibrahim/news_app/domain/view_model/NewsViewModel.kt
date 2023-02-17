package com.dev.bayan_ibrahim.news_app.domain.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.bayan_ibrahim.news_app.domain.module.Article
import com.dev.bayan_ibrahim.news_app.domain.repo.NewsRepo
import com.dev.bayan_ibrahim.news_app.domain.utiles.CurrentFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor (
    private val repo: NewsRepo,
): ViewModel() {
    /*lists: -----------------------------------------==>*/
    private val _breakingNewsPageList = MutableLiveData<List<Article>>()
    var breakingNewsPageList: LiveData<List<Article>> = _breakingNewsPageList

    private var _savedNewsList = MutableLiveData<List<Article>>()
    var savedNewsList: LiveData<List<Article>> = _savedNewsList

    private var _searchNewsPageList = MutableLiveData<List<Article>>()
    val searchNewsPageList: LiveData<List<Article>> = _searchNewsPageList
    /*<==-------------------------------------------lists*/

    /*init: -----------------------------------------==>*/
    /*<==-------------------------------------------lists*/
    private val _currentFragment = MutableLiveData<CurrentFragment>(CurrentFragment.BREAKING_NEWS)
    val currentFragment: LiveData<CurrentFragment> = _currentFragment

    private val _currentArticle = MutableLiveData<Article>()
    var currentArticle: LiveData<Article> = _currentArticle

    private var _isLoading =  MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private var _breakingNewsPage = MutableLiveData<Int> (0)
    val breakingNewsPage: LiveData<Int> = _breakingNewsPage

    private var _searchNewsPage = MutableLiveData<Int> (0)
    val searchNewsPage: LiveData<Int> = _searchNewsPage
    private var currentSearchQuery: String? = null

    suspend fun initAllArticlesValues () {
        loadNextBreakingNewsPage()
        refreshSavedNews()
    }
    suspend fun loadNextBreakingNewsPage() {
        if (_isLoading.value == true) {
            return
        }
        withContext(Dispatchers.Main) {
            _isLoading.postValue(true)
        }
        withContext(Dispatchers.IO) {
            val requiredPage = breakingNewsPage.value?.inc() ?: 1
            val newsResponse = repo.getBreakingNews(page = requiredPage)
            if (newsResponse.isSuccessful) {
                if (newsResponse.body() != null) {
                    val articles = newsResponse.body()!!.articles
                    withContext(Dispatchers.Main) {
                        val totalArticles = _breakingNewsPageList.value?.toMutableList() ?: mutableListOf()
                        totalArticles.addAll(articles)
                        _breakingNewsPageList.postValue(totalArticles)
                        _breakingNewsPage.value = requiredPage
                    }
                } else {
                    // TODO handle empty breaking news event with liveData object handling the state
                }
            } else {
                // TODO handle error request.
            }
        }
        withContext(Dispatchers.Main) {
            _isLoading.postValue(false)
        }
    }
    suspend fun loadNextBreakingNewsPageIfNeeded(lastVisibleItemPosition: Int): Boolean {
        if (lastVisibleItemPosition >= (breakingNewsPageList.value?.size ?: 0) - 1) {
            loadNextBreakingNewsPage()
            return true
        }
        return false
    }
    suspend fun refreshSavedNews() {
        withContext (Dispatchers.IO) {
            val articles = repo.getAllArticles() as MutableLiveData
            withContext(Dispatchers.Main) {
                _savedNewsList = articles
            }
        }
    }
    suspend fun searchNews (searchQuery: String?) {
        if (searchQuery != null) {
            searchNewsWithNewQuery(searchQuery)
        } else {
            searchNewsLoadNextPage()
        }
    }

    private suspend fun searchNewsWithNewQuery (searchQuery: String) {
        val requiredPage = 1
        withContext(Dispatchers.Main) {
            _isLoading.postValue(true)
        }
        withContext(Dispatchers.IO) {
            val searchResult = repo.searchNews(searchQuery = searchQuery, page = requiredPage)
            if (searchResult.isSuccessful) {
                if (searchResult.body() != null) {
                    val articles = searchResult.body()?.articles ?: listOf()
                    withContext(Dispatchers.Main) {
                        _searchNewsPageList.postValue(articles)
                        _searchNewsPage.postValue(requiredPage)
                    }
                } else {
                    // TODO handle empty result
                }
            } else {
                // TODO handle request error
            }
        }
        currentSearchQuery = searchQuery
        withContext(Dispatchers.Main) {
            _isLoading.postValue(false)
        }
    }
    private suspend fun searchNewsLoadNextPage () {
        if (currentSearchQuery != null) {
            val requiredPage = _searchNewsPage.value?.inc() ?: 1
            withContext(Dispatchers.Main) {
                _isLoading.postValue(true)
            }
            withContext(Dispatchers.IO) {
                val searchResult = repo.searchNews(
                    searchQuery = currentSearchQuery!!,
                    page = requiredPage
                )
                if (searchResult.isSuccessful) {
                    if (searchResult.body() != null) {
                        val articles = searchResult.body()?.articles ?: listOf()
                        withContext(Dispatchers.Main) {
                            _searchNewsPageList.postValue(articles)
                            _searchNewsPage.postValue(requiredPage)
                        }
                    } else {
                        // TODO handle empty result
                    }
                } else {
                    // TODO handle request error
                }
            }
            withContext(Dispatchers.Main) {
                _isLoading.postValue(false)
            }
        }
    }

    suspend fun saveAritcle (position: Int) {
        val articleFromCurrentActiveList = getCurrentArticle(position)
        saveArticleFromCurrentActiveList(articleFromCurrentActiveList)
    }
    suspend fun saveArticle (url: String) {
        val articleFromCurrentActiveList = getCurrentArticle(url)
        saveArticleFromCurrentActiveList(articleFromCurrentActiveList)
    }
    private suspend fun saveArticleFromCurrentActiveList(articleFromCurrentActiveList: Article?) {
        withContext(Dispatchers.IO) {
            if (articleFromCurrentActiveList != null) {
                repo.insertOrUpdateArticle(articleFromCurrentActiveList)
                val savedArticles = repo.getAllArticles()
                refreshSavedNews()
            }

        }
    }
    suspend fun deleteArticle (position: Int) {
        val articleFromCurrentActiveList = getCurrentArticle(position)
        deleteArticleFromCurrentActiveList(articleFromCurrentActiveList)
    }
    suspend fun deleteArticle (url: String) {
        val articleFromCurrentActiveList = getCurrentArticle(url)
        deleteArticleFromCurrentActiveList(articleFromCurrentActiveList)
    }
    private suspend fun deleteArticleFromCurrentActiveList(articleFromCurrentActiveList: Article?) {
        withContext(Dispatchers.IO) {
            if (articleFromCurrentActiveList != null) {
                repo.deleteArticle(articleFromCurrentActiveList)
            }
            refreshSavedNews()
        }
    }
    private fun getCurrentArticle (position: Int): Article? {
        return when (currentFragment.value) {
            CurrentFragment.BREAKING_NEWS -> {
                breakingNewsPageList.value?.get(position)
            }
            CurrentFragment.SEARCH_NEWS -> {
                searchNewsPageList.value?.get(position)
            }
            CurrentFragment.SAVED_NEWS -> {
                savedNewsList.value?.get(position)
            }
            else -> {
                null
            }
        }
    }
    private fun getCurrentArticle (url: String): Article? {
        return when (currentFragment.value) {
            CurrentFragment.BREAKING_NEWS -> {
                breakingNewsPageList.value?.first { article ->
                    article.url == url
                }
            }
            CurrentFragment.SEARCH_NEWS -> {
                searchNewsPageList.value?.first { article ->
                    article.url == url
                }
            }
            CurrentFragment.SAVED_NEWS -> {
                savedNewsList.value?.first { article ->
                    article.url == url
                }
            }
            else -> {
                null
            }
        }
    }

    fun navigateToFragment(newFragment: CurrentFragment) {
        _currentFragment.postValue(newFragment)
    }

}
