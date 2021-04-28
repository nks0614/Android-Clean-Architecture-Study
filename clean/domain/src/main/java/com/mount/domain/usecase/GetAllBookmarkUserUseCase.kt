package com.mount.domain.usecase

import com.mount.domain.model.User
import com.mount.domain.repository.UserRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetAllBookmarkUserUseCase(
    private val repository: UserRepository
) {
    fun execute(name: String): Single<List<User>> =
        repository.getAllBookmarkUser(name)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            // subscribeOn : observable 의 작업을 시작하는 스레드를 선택할 수 있음
            // observeOn : 이후에 나오는 오퍼레이터, subscribe의 스케쥴러를 변경할 수 있음
            // Schedulers.io : 동기 I/O를 별도로 처리시켜 비동기 효율을 얻기 위한 스케쥴러, API 호출 등 네트워크를 사용한 호출 시 사용됨
            // AndroidSchedulers.mainThread() : UI 스레드에서 동작

}