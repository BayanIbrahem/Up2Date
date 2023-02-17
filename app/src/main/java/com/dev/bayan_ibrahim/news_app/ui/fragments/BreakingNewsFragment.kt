package com.dev.bayan_ibrahim.news_app.ui.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.bayan_ibrahim.news_app.R
import com.dev.bayan_ibrahim.news_app.databinding.FragmentBreakingnewsBinding
import com.dev.bayan_ibrahim.news_app.domain.module.adapters.BreakingNewsAdapter
import com.dev.bayan_ibrahim.news_app.domain.view_model.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class BreakingNewsFragment: Fragment(R.layout.fragment_breakingnews) {
    private lateinit var binding: FragmentBreakingnewsBinding
    private val newsViewModel: NewsViewModel by viewModels()

    private lateinit var breakingNewsAdapter: BreakingNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        //        initBreakingNewsRv()
        //        initViewModelValues()
//        setViewModelObservers()

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBreakingnewsBinding.inflate(inflater, container, false)

        initViewModelValues()
        setViewModelObservers()
        initBreakingNewsRv()

        return binding.root
    }

    private fun initViewModelValues() {
        lifecycleScope.launch {
            newsViewModel.loadNextBreakingNewsPage()
        }
    }
    private fun setViewModelObservers () {
        breakingNewsListObserver()
        loadingObserver()
    }
      private fun breakingNewsListObserver() {
        // breakingNews LiveData Observer:
        newsViewModel.breakingNewsPageList.observe(requireActivity()) { articles ->
            breakingNewsAdapter.articles = articles
            breakingNewsAdapter.notifyDataSetChanged()
            Log.d("breaking news list", "new articles list is: $articles")
        }
    }
      private fun loadingObserver() {
        // reloading Observer:
        newsViewModel.isLoading.observe(requireActivity()) { startLoading ->
            if ( startLoading ) {
                startLoading ()
            } else {
                endLoading ()
            }
        }
    }
        private fun startLoading() {
                                       // TODO not implemented yet
                                       }
        private fun endLoading() {
                                     // TODO not implemented yet
                                     }
    private fun initBreakingNewsRv () {
        breakingNewsAdapter = BreakingNewsAdapter()
        breakingNewsAdapter.articles = newsViewModel.breakingNewsPageList.value ?: listOf()
        binding.rvBreakingNews.adapter = breakingNewsAdapter
        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvBreakingNews.layoutManager = layoutManager
        initBreakingNewsRvListeners()
    }
      private fun initBreakingNewsRvListeners() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.rvBreakingNews.setOnScrollChangeListener {
                _, _, _, _, _->
                val layout = binding.rvBreakingNews.layoutManager as LinearLayoutManager
                val lastVisible = layout.findLastVisibleItemPosition()
                lifecycleScope.launch {
                    newsViewModel.loadNextBreakingNewsPageIfNeeded(lastVisible)
                }
            }
        }
    }
}