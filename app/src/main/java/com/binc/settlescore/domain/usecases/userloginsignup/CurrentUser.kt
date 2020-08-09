package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.BaseAsyncUseCase
import javax.inject.Inject

class CurrentUser @Inject constructor(var repo: Repository) : BaseAsyncUseCase<UserInfo?>() {
    override suspend fun doInBackground(): UserInfo? {
        return repo.getUser()
    }

    suspend fun getInfo(): Result<UserInfo?> {
        return executeAsync()
    }

    interface Repository {
        fun getUser(): UserInfo?
    }
}