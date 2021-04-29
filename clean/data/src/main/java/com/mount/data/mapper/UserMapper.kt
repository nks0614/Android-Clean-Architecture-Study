package com.mount.data.mapper

import com.mount.data.database.UserEntity
import com.mount.data.network.UserData
import com.mount.domain.model.User

fun User.toEntity() : UserEntity =
    UserEntity(
        this.name,
        this.profileImageUrl
    )

fun UserEntity.toModel() : User =
    User(
        this.name,
        this.profileImageUrl,
        true
    )

fun UserData.toModel(isBookmark : Boolean) : User =
    User(
        this.name,
        this.profileImageUrl,
        isBookmark
    )