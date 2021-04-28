package com.mount.domain.usecase

import com.mount.domain.model.User
import com.mount.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddBookmarkUserUseCase(
    private val repository: UserRepository
) {
    fun execute(user: User): Completable =
        repository.addBookmarkUser(user)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}