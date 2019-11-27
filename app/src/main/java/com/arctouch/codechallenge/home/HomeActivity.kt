package com.arctouch.codechallenge.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.home.listener.InfinityRecyclerOnScrollListener
import kotlinx.android.synthetic.main.home_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeActivityViewModel: HomeActivityViewModel by viewModel()

    private val homeAdapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        setupViews()
        setupObservers()
        homeActivityViewModel.getGenres()
    }

    private fun setupViews() {

        recyclerView.adapter = homeAdapter

        recyclerView.addOnScrollListener(object : InfinityRecyclerOnScrollListener() {
            override fun onLoadMore() {
                progressBarInfinityScroll.visibility = View.VISIBLE
                homeActivityViewModel.getMovies()
            }
        })
    }

    private fun setupObservers() {

        homeActivityViewModel.genresLoaded().observe(this, Observer {
            homeActivityViewModel.getMovies()
        })

        homeActivityViewModel.listOfMovies().observe(this, Observer {
            homeAdapter.addMoreMovies(it)
            progressBar.visibility = View.GONE
            progressBarInfinityScroll.visibility = View.GONE
        })
    }
}
