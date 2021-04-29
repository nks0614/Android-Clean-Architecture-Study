package com.mount.data.network

import com.google.gson.annotations.SerializedName

data class UserData (
    @SerializedName("login")
    val name : String,
    @SerializedName("avatar_url")
    val profileImageUrl : String
)