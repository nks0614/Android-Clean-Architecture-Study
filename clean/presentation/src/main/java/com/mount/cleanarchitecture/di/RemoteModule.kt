package com.mount.cleanarchitecture.di

import com.mount.data.network.UserRemote
import org.koin.dsl.module

val remoteModule = module {
    single { UserRemote(get()) }
}