package com.cespaul.prettyLogger.sample.di.modules

import com.cespaul.prettyLogger.sample.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel() }
}