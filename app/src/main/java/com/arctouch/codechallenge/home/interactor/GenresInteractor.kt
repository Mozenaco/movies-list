package com.arctouch.codechallenge.home.interactor

import com.arctouch.codechallenge.home.repository.GenresRepository

class GenresInteractor
constructor(private val genresRepository: GenresRepository) {

    fun execute() =  genresRepository.getGenres()
}