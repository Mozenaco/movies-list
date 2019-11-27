package com.arctouch.codechallenge.home.repository

import com.arctouch.codechallenge.api.TmdbApi
import com.arctouch.codechallenge.model.Genre
import io.reactivex.Observable

class GenresRepositoryImpl constructor(
    private val api: TmdbApi

) : GenresRepository {
    override fun getGenres(): Observable<List<Genre>> {

        return api.genres(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE)
            .map {
                it.genres
            }
    }
}