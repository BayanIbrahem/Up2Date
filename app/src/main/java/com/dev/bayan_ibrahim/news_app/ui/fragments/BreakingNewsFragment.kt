package com.dev.bayan_ibrahim.news_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dev.bayan_ibrahim.news_app.R
import com.dev.bayan_ibrahim.news_app.databinding.FragmentBreakingnewsBinding

class BreakingNewsFragment: Fragment(R.layout.fragment_breakingnews) {
    private lateinit var binding: FragmentBreakingnewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentBreakingnewsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().title = "Breaking News"
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}