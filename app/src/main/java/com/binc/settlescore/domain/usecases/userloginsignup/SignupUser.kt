package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.BaseUseCase
import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import javax.inject.Inject

class SignupUser @Inject constructor(private var userInfo: UserInfo, private var repository: Repository) :
    BaseUseCase<Unit>() {


    override suspend fun doInBackground() {
        repository.signupUser(userInfo)
    }

    suspend fun signupUser(): Result<Unit> {
        return executeAsync()
    }

    interface Repository {
        fun signupUser(userInfo: UserInfo)
    }
}