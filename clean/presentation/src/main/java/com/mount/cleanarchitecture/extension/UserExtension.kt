package com.mount.cleanarchitecture.extension

import com.mount.cleanarchitecture.R
import com.mount.cleanarchitecture.base.BindingItem
import com.mount.cleanarchitecture.ui.item.UserItemNavigator
import com.mount.cleanarchitecture.ui.item.UserItemViewModel
import com.mount.domain.model.User
import java.util.*
import kotlin.collections.ArrayList

fun UserItemViewModel.toRecyclerItem(navigator : UserItemNavigator) =
    BindingItem(
        viewModel = this,
        navigator = navigator,
        layoutId = R.layout.item_user
    )

fun User.toViewModel(navigator : UserItemNavigator) = UserItemViewModel(this).toRecyclerItem(navigator)

fun List<User>.toRecyclerItemList(navigator: UserItemNavigator) = map { it.toViewModel(navigator) }


fun List<User>.headerSort() : List<User> {
    val userList = ArrayList<User>()

    val linkedList = LinkedList(this.sortedBy {
        it.name.toUpperCase(Locale.ROOT)
    })

    while(!linkedList.isEmpty()) {
        val item : User = linkedList.remove().apply {
            this.isHeaderShow = true
        }
        userList.add(item)

        while(linkedList.peek() != null && item.nameFirst() == linkedList.peek()?.nameFirst()) {
            userList.add(linkedList.remove())
        }
    }
    return userList
}