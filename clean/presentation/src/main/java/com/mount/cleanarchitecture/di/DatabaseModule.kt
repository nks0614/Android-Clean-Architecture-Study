package com.mount.cleanarchitecture.di

import android.app.Application
import androidx.room.Room
import com.mount.data.database.AppDatabase
import com.mount.data.database.UserDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val daoModule = module {
    fun provideUserDao(database : AppDatabase) : UserDao {
        return database.userDao()
    }

    single { provideUserDao(get()) }
}

val databaseModule = module {
    fun provideDatabase(application : Application) : AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "bookmark")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single { provideDatabase(androidApplication()) }
}