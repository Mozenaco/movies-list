package com.arctouch.codechallenge.home.repository

import com.arctouch.codechallenge.model.Movie
import io.reactivex.Observable

interface MoviesRepository {

    fun getMovies(pageNumber: Int): Observable<List<Movie>>
}