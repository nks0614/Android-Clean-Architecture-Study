package com.mount.data.network

import com.google.gson.annotations.SerializedName

data class UserResponse<T> (
    @SerializedName("total_count")
    val count : Int,
    val items : T
)