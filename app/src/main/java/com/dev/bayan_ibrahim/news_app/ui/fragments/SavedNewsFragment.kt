package com.dev.bayan_ibrahim.news_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dev.bayan_ibrahim.news_app.R
import com.dev.bayan_ibrahim.news_app.databinding.FragmentSavednewsBinding

class SavedNewsFragment: Fragment(R.layout.fragment_savednews) {
    private lateinit var binding: FragmentSavednewsBinding

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