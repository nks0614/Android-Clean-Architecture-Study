package com.mount.cleanarchitecture.di

import com.mount.domain.usecase.AddBookmarkUserUseCase
import com.mount.domain.usecase.GetAllBookmarkUserUseCase
import com.mount.domain.usecase.GetAllSearchUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetAllSearchUserUseCase(get()) }
    single { GetAllBookmarkUserUseCase(get()) }
    single { AddBookmarkUserUseCase(get())}

}