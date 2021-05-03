package com.mount.cleanarchitecture.ui.github

import androidx.lifecycle.MutableLiveData
import com.mount.cleanarchitecture.base.BaseViewModel
import com.mount.cleanarchitecture.base.BindingItem
import com.mount.cleanarchitecture.base.Event
import com.mount.cleanarchitecture.extension.headerSort
import com.mount.cleanarchitecture.extension.toRecyclerItemList
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

    fun getAllSearchUser(name : String) {
        if(name.isEmpty()) return
        isLoading.value = true
        addDisposable(getAllSearchUserUseCase.execute(name)
            .subscribe({
                userList.value = ArrayList(it.headerSort().toRecyclerItemList(this))
                userName.value = name
                isLoading.value = false
            }, {
                onErrorEvent.value = Event(it.message.toString())
            })
        )
    }

    fun onClickSearch() {
        getAllSearchUser(inputText.value!!)
    }

    override fun onClickBookmark(user: User) {
        addDisposable(addBookmarkUserUseCase.execute(user)
            .subscribe({
                getAllSearchUser(userName.value!!)
            }, {
                onErrorEvent.value = Event(it.message.toString())
            }))
    }
}