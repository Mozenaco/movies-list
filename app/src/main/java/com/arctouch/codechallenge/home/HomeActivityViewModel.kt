package com.arctouch.codechallenge.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arctouch.codechallenge.data.Cache
import com.arctouch.codechallenge.home.interactor.GenresInteractor
import com.arctouch.codechallenge.home.interactor.MoviesInteractor
import com.arctouch.codechallenge.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeActivityViewModel constructor(
    private val moviesInteractor: MoviesInteractor,
    private val genresInteractor: GenresInteractor
) : ViewModel() {

    private val movies = MutableLiveData<List<Movie>>()
    fun listOfMovies(): LiveData<List<Movie>> = movies

    private val genresLoaded = MutableLiveData<Boolean>()
    fun genresLoaded(): LiveData<Boolean> = genresLoaded

    fun getGenres() {

        genresInteractor.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                Cache.cacheGenres(result)
                genresLoaded.value = true
            }
    }

    fun getMovies() {

        moviesInteractor.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                movies.value = result
            }
    }
}