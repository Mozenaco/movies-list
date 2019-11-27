package com.arctouch.codechallenge.di

import com.arctouch.codechallenge.home.HomeActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel { HomeActivityViewModel(get()) }
}