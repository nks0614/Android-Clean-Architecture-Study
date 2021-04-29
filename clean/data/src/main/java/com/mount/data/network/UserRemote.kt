package com.mount.data.network

import com.mount.data.database.UserDao
import com.mount.data.util.Constants
import io.reactivex.Single

class UserRemote(
    private val api : UserAPI
) {
    fun getAllUser(name : String) : Single<List<UserData>> =
        api.getAllUser(name, Constants.PAGE, Constants.PER_PAGE).map { it.body()?.items }
}