package com.arctouch.codechallenge.home.repository

import com.arctouch.codechallenge.model.Movie
import io.reactivex.Observable

interface MoviesRepository{

    fun getMovies(): Observable<List<Movie>>
}