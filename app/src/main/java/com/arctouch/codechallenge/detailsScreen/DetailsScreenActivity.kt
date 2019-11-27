package com.arctouch.codechallenge.detailsScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arctouch.codechallenge.R
import com.arctouch.codechallenge.home.HomeAdapter
import com.arctouch.codechallenge.model.Movie
import com.arctouch.codechallenge.util.MovieImageUrlBuilder
import com.arctouch.codechallenge.util.extensions.toDate
import com.arctouch.codechallenge.util.extensions.toDateStringFormated
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.details_screen_activity.*

class DetailsScreenActivity : AppCompatActivity() {

    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_screen_activity)

        movie = intent.getParcelableExtra(HomeAdapter.ViewHolder.ARG_MOVIE)
        setupViews()
    }

    private fun setupViews() {

        movie?.let {
            tvName.text = it.title

            Glide.with(this)
                .load(it.posterPath?.let { MovieImageUrlBuilder().buildPosterUrl(it) })
                .apply(RequestOptions().placeholder(R.drawable.ic_image_placeholder))
                .into(ivPosterImage)

            Glide.with(this)
                .load(it.backdropPath?.let { MovieImageUrlBuilder().buildBackdropUrl(it) })
                .apply(RequestOptions().placeholder(R.drawable.ic_image_placeholder))
                .into(ivBackdropImage)

            tvListOfGenres.text = it.genres?.joinToString(separator = " / ") { it.name }
            tvOverview.text = it.overview

            it.releaseDate?.toDate()?.toDateStringFormated()?.let {
                tvReleaseDate.text = getString(R.string.release_date, it)
            }
        }
    }
}