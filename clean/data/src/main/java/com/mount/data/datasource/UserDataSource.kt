package com.mount.data.datasource

import com.mount.data.database.UserCache
import com.mount.data.mapper.toEntity
import com.mount.data.mapper.toModel
import com.mount.data.network.UserRemote
import com.mount.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

class UserDataSource(
    private val remote : UserRemote,
    private val cache : UserCache
) {

    fun getAllSearchUser(name : String) : Single<List<User>> =
        Single.zip(
            remote.getAllUser(name),
            cache.getAllUser(name),
            { userDataList, userEntityList ->
                userDataList.map { userData ->
                    val isBookmark = userEntityList
                        .map { it.name }
                        .contains(userData.name)
                    userData.toModel(isBookmark)
                }
            }
        )

    fun getAllBookmarkUser(name : String) : Single<List<User>> =
        cache.getAllUser(name).map { userEntityList ->
            userEntityList.map { it.toModel() }
        }

    fun addBookmarkUser(user : User) : Completable =
        if(!user.isBookmark) cache.insertUser(user.toEntity())
        else cache.deleteUser(user.toEntity())

}