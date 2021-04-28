package com.mount.cleanarchitecture.ui.item

import com.mount.domain.model.User

interface UserItemNavigator {
    fun onClickBookmark(user: User)
}