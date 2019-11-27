package com.arctouch.codechallenge.di

import com.arctouch.codechallenge.home.repository.MoviesRepository
import com.arctouch.codechallenge.home.repository.MoviesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single { MoviesRepositoryImpl(get()) as MoviesRepository }
}