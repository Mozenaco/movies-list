package com.arctouch.codechallenge.home.interactor

import com.arctouch.codechallenge.home.repository.MoviesRepository

class MoviesInteractor
constructor(private val moviesRepository: MoviesRepository) {

    fun execute(currentPage: Int) =  moviesRepository.getMovies(currentPage)
}