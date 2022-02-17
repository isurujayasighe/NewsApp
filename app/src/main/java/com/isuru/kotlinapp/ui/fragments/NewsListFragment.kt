package com.isuru.kotlinapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.isuru.kotlinapp.databinding.NewsListFragmentBinding
import com.isuru.kotlinapp.repository.model.Article
import com.isuru.kotlinapp.ui.NewsAppViewModel
import com.isuru.kotlinapp.ui.adapters.NewsAdapter
import com.isuru.kotlinapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private lateinit var mBinding: NewsListFragmentBinding

    private val viewModel: NewsAppViewModel by viewModels()

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = NewsListFragmentBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNewsFromApi("us", "business")

        viewModel.breakingNews.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { newsResponse ->
                        setupRecyclerView(newsResponse.articles)
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
                else -> {

                }
            }
        }
    }

    private fun showProgressBar() {
        mBinding.progressCircular.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        mBinding.progressCircular.visibility = View.INVISIBLE
    }

    private fun setupRecyclerView(articleList: List<Article>) {
        newsAdapter = NewsAdapter(articleList)
        mBinding.rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}