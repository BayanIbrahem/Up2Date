package com.dev.bayan_ibrahim.news_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.dev.bayan_ibrahim.news_app.R
import com.dev.bayan_ibrahim.news_app.databinding.FragmentSavednewsBinding
import com.dev.bayan_ibrahim.news_app.domain.view_model.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedNewsFragment: Fragment(R.layout.fragment_savednews) {
    private lateinit var binding: FragmentSavednewsBinding
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentSavednewsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().title = "Saved News"
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}