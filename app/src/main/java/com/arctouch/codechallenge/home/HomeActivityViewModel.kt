package com.arctouch.codechallenge.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arctouch.codechallenge.home.interactor.MoviesInteractor
import com.arctouch.codechallenge.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeActivityViewModel constructor(
    private val moviesInteractor: MoviesInteractor
) : ViewModel() {

    private val movies = MutableLiveData<List<Movie>>()

    fun listOfMovies(): LiveData<List<Movie>> = movies

    fun getMovies() {

        moviesInteractor.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    movies.value = result
                }, { error -> })
    }
}