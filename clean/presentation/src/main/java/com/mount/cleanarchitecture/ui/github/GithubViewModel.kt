package com.mount.cleanarchitecture.ui.github

import androidx.lifecycle.MutableLiveData
import com.mount.cleanarchitecture.base.BaseViewModel
import com.mount.cleanarchitecture.base.BindingItem
import com.mount.cleanarchitecture.base.Event
import com.mount.cleanarchitecture.ui.item.UserItemNavigator
import com.mount.domain.model.User
import com.mount.domain.usecase.AddBookmarkUserUseCase
import com.mount.domain.usecase.GetAllSearchUserUseCase

class GithubViewModel(
    private val getAllSearchUserUseCase: GetAllSearchUserUseCase,
    private val addBookmarkUserUseCase: AddBookmarkUserUseCase
) : BaseViewModel(), UserItemNavigator {

    val inputText = MutableLiveData<String>("")
    val userName = MutableLiveData<String>("")

    val userList = MutableLiveData<ArrayList<BindingItem>>()

    val isLoading = MutableLiveData<Boolean>(false)
    val onErrorEvent = MutableLiveData<Event<String>>()

    override fun onClickBookmark(user: User) {
        TODO("Not yet implemented")
    }
}