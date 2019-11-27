package com.arctouch.codechallenge.di

import com.arctouch.codechallenge.home.interactor.MoviesInteractor
import org.koin.dsl.module


val interectorModule = module {

    factory { MoviesInteractor(get()) }
}