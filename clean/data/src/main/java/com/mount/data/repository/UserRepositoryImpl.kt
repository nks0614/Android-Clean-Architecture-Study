package com.mount.data.repository

import com.mount.data.datasource.UserDataSource
import com.mount.domain.model.User
import com.mount.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Single

class UserRepositoryImpl(
    private val dataSource : UserDataSource
) : UserRepository {
    override fun getAllSearchUser(name: String): Single<List<User>> {
        return dataSource.getAllSearchUser(name)
    }

    override fun getAllBookmarkUser(name: String): Single<List<User>> {
        return dataSource.getAllBookmarkUser(name)
    }

    override fun addBookmarkUser(user: User): Completable {
        return dataSource.addBookmarkUser(user)
    }
}