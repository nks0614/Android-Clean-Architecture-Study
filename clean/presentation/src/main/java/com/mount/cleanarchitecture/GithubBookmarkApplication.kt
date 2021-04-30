package com.mount.cleanarchitecture

import android.app.Application
import com.mount.cleanarchitecture.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GithubBookmarkApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GithubBookmarkApplication)
            val modules = listOf(
                cacheModule, databaseModule, dataSourceModule, networkModule,
                remoteModule, repositoryModule, useCaseModule, viewModelModule
            )
            modules(modules)
        }
    }
}