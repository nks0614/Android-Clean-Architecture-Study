package com.mount.cleanarchitecture.ui.bookmark

import androidx.lifecycle.MutableLiveData
import com.mount.cleanarchitecture.base.BaseViewModel
import com.mount.cleanarchitecture.base.BindingItem
import com.mount.cleanarchitecture.base.Event
import com.mount.cleanarchitecture.extension.headerSort
import com.mount.cleanarchitecture.extension.toRecyclerItemList
import com.mount.cleanarchitecture.ui.item.UserItemNavigator
import com.mount.domain.model.User
import com.mount.domain.usecase.AddBookmarkUserUseCase
import com.mount.domain.usecase.GetAllBookmarkUserUseCase

class BookmarkViewModel(
    private val getAllBookmarkUserUseCase: GetAllBookmarkUserUseCase,
    private val addBookmarkUserUseCase: AddBookmarkUserUseCase
) : BaseViewModel(), UserItemNavigator {

    val inputText = MutableLiveData<String>("")
    val userName = MutableLiveData<String>("")

    val userList = MutableLiveData<ArrayList<BindingItem>>()

    val isLoading = MutableLiveData<Boolean>(false)
    val onErrorEvent = MutableLiveData<Event<String>>()

    fun getAllBookmarkUser(name : String?) {
        isLoading.value = true

        addDisposable(getAllBookmarkUserUseCase.execute(name ?: "")
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
        getAllBookmarkUser(inputText.value!!)
    }

    override fun onClickBookmark(user: User) {
        addDisposable(addBookmarkUserUseCase.execute(user)
            .subscribe({
                getAllBookmarkUser(userName.value!!)
            }, {
                onErrorEvent.value = Event(it.message.toString())
            })
        )
    }
}