package com.dev.bayan_ibrahim.news_app.domain.module.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.bayan_ibrahim.news_app.data.local.ArticlesDao
import com.dev.bayan_ibrahim.news_app.databinding.ArticleItemBinding
import com.dev.bayan_ibrahim.news_app.databinding.FragmentBreakingnewsBinding
import com.dev.bayan_ibrahim.news_app.domain.module.Article

class BreakingNewsAdapter: RecyclerView.Adapter<BreakingNewsAdapter.BreakingNewsViewHolder>() {

    inner class BreakingNewsViewHolder (val binding: ArticleItemBinding): RecyclerView.ViewHolder(binding.root)

//    private val differCallback =  object: DiffUtil.ItemCallback<Article>() {
//        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
//            return oldItem.url == newItem.url
//        }
//
//        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
//            return oldItem == newItem
//        }
//    }
//    private val differ = AsyncListDiffer (this, differCallback)

    var articles: List<Article> = listOf()
//        get() = differ.currentList
//        set (value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingNewsViewHolder {
        return BreakingNewsViewHolder(
            ArticleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }

    override fun onBindViewHolder(holder: BreakingNewsViewHolder, position: Int) {
        val article = articles.get(position)
        holder.binding.also {
            it.tvTitle.text = article.title
            it.tvAuthor.text = article.author
            it.tvDate.text = article.publishedAt
            it.tvDescription.text = article.description
            it.tvSource.text = article.source.name
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }

}