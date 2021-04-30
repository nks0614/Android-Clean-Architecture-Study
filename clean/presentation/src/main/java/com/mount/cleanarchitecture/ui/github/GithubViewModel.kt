package com.mount.cleanarchitecture.ui.github

import com.mount.cleanarchitecture.base.BaseViewModel
import com.mount.cleanarchitecture.ui.item.UserItemNavigator
import com.mount.domain.model.User
import com.mount.domain.usecase.AddBookmarkUserUseCase
import com.mount.domain.usecase.GetAllSearchUserUseCase

class GithubViewModel(
    private val getAllSearchUserUseCase: GetAllSearchUserUseCase,
    private val addBookmarkUserUseCase: AddBookmarkUserUseCase
) : BaseViewModel(), UserItemNavigator {

    override fun onClickBookmark(user: User) {
        TODO("Not yet implemented")
    }
}