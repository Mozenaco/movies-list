package com.arctouch.codechallenge.home.repository

import android.util.Log
import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.model.Movie
import io.reactivex.Observable

class MoviesRepositoryImpl constructor(
    private val api: TmdbApi

) : MoviesRepository {
    override fun getMovies(pageNumber: Int): Observable<List<Movie>> {

        Log.d("TAG","pageNumber: "+pageNumber.toLong())

        return api.upcomingMovies(
            TmdbApi.API_KEY,
            TmdbApi.DEFAULT_LANGUAGE,
            pageNumber.toLong()
        )
            .map {
                it.results.map { movie ->
                    movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
                }
            }
    }
}