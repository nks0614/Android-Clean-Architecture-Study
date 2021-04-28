package com.mount.domain.usecase

import com.mount.domain.model.User
import com.mount.domain.repository.UserRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetAllSearchUserUseCase(
    private val repository: UserRepository
) {
    fun execute(name: String): Single<List<User>> =
        repository.getAllSearchUser(name)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}