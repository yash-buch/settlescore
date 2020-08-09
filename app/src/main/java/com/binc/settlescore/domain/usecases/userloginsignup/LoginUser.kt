package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.BaseAsyncUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class LoginUser @Inject constructor(private var repository: Repository) :
    BaseAsyncUseCase<Boolean>() {

    private lateinit var userInfo: UserInfo

    override suspend fun doInBackground(): Boolean {
        val isLoginSuccess = CoroutineScope(EmptyCoroutineContext).async {
        repository.loginUser(userInfo)
        }
        return isLoginSuccess.await()
    }

    suspend fun loginUser(uInfo: UserInfo): Result<Boolean> {
        userInfo = uInfo
        return executeAsync()
    }

    interface Repository {
        suspend fun loginUser(userInfo: UserInfo): Boolean
    }
}