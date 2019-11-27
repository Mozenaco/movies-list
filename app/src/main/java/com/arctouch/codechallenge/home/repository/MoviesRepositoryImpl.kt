package com.arctouch.codechallenge.home.repository

import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.model.Movie
import io.reactivex.Observable

class MoviesRepositoryImpl constructor(
    private val api: TmdbApi

) : MoviesRepository {
    override fun getMovies(): Observable<List<Movie>> {

        return api.upcomingMovies(
            TmdbApi.API_KEY,
            TmdbApi.DEFAULT_LANGUAGE,
            1,
            TmdbApi.DEFAULT_REGION
        )
            .map {
                it.results.map { movie ->
                    movie.copy(genres = Cache.genres.filter { movie.genreIds?.contains(it.id) == true })
                }
            }
    }
}