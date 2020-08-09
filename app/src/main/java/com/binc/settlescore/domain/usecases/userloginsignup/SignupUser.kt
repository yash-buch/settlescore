package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.BaseAsyncUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class SignupUser @Inject constructor(private var repository: Repository) :
    BaseAsyncUseCase<Boolean>() {

    private lateinit var userInfo: UserInfo

    override suspend fun doInBackground(): Boolean {
        val isSignupSuccess = CoroutineScope(EmptyCoroutineContext).async {
            repository.signupUser(userInfo)
        }
        return isSignupSuccess.await()
    }

    suspend fun signupUser(uInfo: UserInfo): Result<Boolean> {
        userInfo = uInfo
        return executeAsync()
    }

    interface Repository {
        suspend fun signupUser(userInfo: UserInfo): Boolean
    }
}