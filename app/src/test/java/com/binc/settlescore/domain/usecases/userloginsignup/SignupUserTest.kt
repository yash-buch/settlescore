package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SignupUserTest : SignupUser.Repository {
    override suspend fun signupUser(userInfo: UserInfo): Boolean {
        // do nothing
        return false
    }

    @Test
    fun test_signupUser() {
        val signupUser = SignupUser(UserInfo.DUMMY_USER, this as SignupUser.Repository)
        lateinit var result: Result<Boolean>
        runBlocking { result = signupUser.signupUser() }
        assertNotNull(result)
    }
}