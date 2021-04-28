package com.mount.cleanarchitecture.ui.item

import com.mount.domain.model.User
import java.util.*

class UserItemViewModel(val item: User) {
    val header = item.name.toUpperCase(Locale.ROOT)
}