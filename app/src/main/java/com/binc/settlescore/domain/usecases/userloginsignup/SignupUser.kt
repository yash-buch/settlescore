package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.BaseUseCase
import com.binc.settlescore.domain.interactors.UserInfo
import javax.inject.Inject

class SignupUser @Inject constructor(userInfo: UserInfo, repository: Repository) :
    BaseUseCase<Unit>() {
    var userInfo: UserInfo
    var repository: Repository

    init {
        this.userInfo = userInfo
        this.repository = repository
    }


    override suspend fun doInBackground() {
        repository.signupUser(userInfo)
    }

    interface Repository {
        fun signupUser(userInfo: UserInfo)
    }
}