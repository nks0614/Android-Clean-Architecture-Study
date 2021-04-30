package com.mount.cleanarchitecture.di

import com.mount.data.repository.UserRepositoryImpl
import com.mount.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    // UserRepository를 요청하면 UserRepositoryImpl를 준다
    single<UserRepository> { UserRepositoryImpl(get()) }
}