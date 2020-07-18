package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.usecases.BaseUseCase
import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.BaseAsyncUseCase
import javax.inject.Inject

class SignupUser @Inject constructor(private var userInfo: UserInfo, private var repository: Repository) :
    BaseAsyncUseCase<Unit>() {


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