package com.arctouch.codechallenge.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.arctouch.codechallenge.R
import kotlinx.android.synthetic.main.home_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val homeActivityViewModel: HomeActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        setupViews()
        setupObservers()
        homeActivityViewModel.getGenres()
    }

    private fun setupViews() {

    }

    private fun setupObservers() {

        homeActivityViewModel.genresLoaded().observe(this, Observer {
            homeActivityViewModel.getMovies()
        })

        homeActivityViewModel.listOfMovies().observe(this, Observer {
            recyclerView.adapter = HomeAdapter(it)
            progressBar.visibility = View.GONE
        })
    }
}
