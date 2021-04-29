package com.mount.cleanarchitecture.di

import com.mount.data.datasource.UserDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single { UserDataSource(get(), get()) }
}