package com.mount.cleanarchitecture.di

import com.mount.cleanarchitecture.ui.bookmark.BookmarkViewModel
import com.mount.cleanarchitecture.ui.github.GithubViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GithubViewModel(get(), get()) }
    viewModel { BookmarkViewModel(get(), get()) }
}