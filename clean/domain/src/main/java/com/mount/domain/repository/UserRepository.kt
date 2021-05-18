package com.mount.domain.repository

import com.mount.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface UserRepository {
    fun getAllSearchUser(name : String) : Single<List<User>>
    fun getAllBookmarkUser(name : String) : Single<List<User>>
    fun addBookmarkUser(user : User) : Completable
}