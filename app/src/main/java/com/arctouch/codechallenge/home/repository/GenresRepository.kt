package com.arctouch.codechallenge.home.repository

import com.arctouch.codechallenge.model.Genre
import io.reactivex.Observable

interface GenresRepository{

    fun getGenres(): Observable<List<Genre>>
}