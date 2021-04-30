package com.mount.cleanarchitecture.ui.bookmark

import com.mount.cleanarchitecture.base.BaseViewModel
import com.mount.cleanarchitecture.ui.item.UserItemNavigator
import com.mount.domain.model.User
import com.mount.domain.usecase.AddBookmarkUserUseCase
import com.mount.domain.usecase.GetAllBookmarkUserUseCase

class BookmarkViewModel(
    private val getAllBookmarkUserUseCase: GetAllBookmarkUserUseCase,
    private val addBookmarkUserUseCase: AddBookmarkUserUseCase
) : BaseViewModel(), UserItemNavigator {

    override fun onClickBookmark(user: User) {

    }
}