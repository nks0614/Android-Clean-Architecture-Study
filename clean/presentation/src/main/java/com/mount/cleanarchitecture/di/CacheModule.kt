package com.mount.cleanarchitecture.di

import com.mount.data.database.UserCache
import org.koin.dsl.module

val cacheModule = module {
    single { UserCache(get()) }
}