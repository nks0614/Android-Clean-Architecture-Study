package com.mount.data.database

import io.reactivex.Completable
import io.reactivex.Single

class UserCache (private val userDao : UserDao) {
    fun insertUser(entity: UserEntity) : Completable =
        userDao.insertUser(entity)

    fun getAllUser(name : String = "") : Single<List<UserEntity>> =
        if(name.isEmpty()) userDao.getAllUser()
        else userDao.getAllUser(name)

    fun deleteUser(entity: UserEntity) : Completable =
        userDao.deleteUser(entity)

    fun deleteAllUser() : Completable =
        userDao.deleteAllUser()
}