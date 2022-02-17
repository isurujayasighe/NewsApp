package com.isuru.kotlinapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isuru.kotlinapp.R
import com.isuru.kotlinapp.repository.model.Article

class NewsAdapter constructor(private var articleList: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvDesc: TextView = itemView.findViewById(R.id.tvDescription)
        val imgView: ImageView = itemView.findViewById(R.id.ivArticleImage)
        val tvSource: TextView = itemView.findViewById(R.id.tvSource)
        val tvPublishAt: TextView = itemView.findViewById(R.id.tvPublishedAt)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsAdapter.ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_layout_article,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsAdapter.ArticleViewHolder, position: Int) {
        val article: Article = articleList[position]
        holder.itemView.apply {
            article.let {
                holder.tvDesc.text = article.description
                Glide.with(this).load(article.urlToImage).into(holder.imgView)
                holder.tvPublishAt.text = article.publishedAt
                holder.tvSource.text = article.source?.name
                holder.tvTitle.text = article.title
            }
        }

    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}