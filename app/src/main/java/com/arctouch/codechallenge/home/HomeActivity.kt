package com.arctouch.codechallenge.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.base.BaseActivity
import kotlinx.android.synthetic.main.home_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity() {

    private val homeActivityViewModel: HomeActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        setupViews()
        setupObservers()
        homeActivityViewModel.getMovies()
    }

    private fun setupViews() {

    }

    private fun setupObservers() {

        homeActivityViewModel.listOfMovies().observe(this, Observer {
            recyclerView.adapter = HomeAdapter(it)
            progressBar.visibility = View.GONE
        })
    }
}
