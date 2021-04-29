package com.mount.data.network

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserAPI {

    @GET("search/users")
    fun getAllUser(
        @Query("q") name : String,
        @Query("page") page : Int,
        @Query("per_page") perPage : Int
    ) : Single<Response<UserResponse<List<UserData>>>>

}