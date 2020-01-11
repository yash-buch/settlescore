package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SignupUserTest : SignupUser.Repository {
    override fun signupUser(userInfo: UserInfo) {
        // do nothing
    }

    @Test
    fun test_signupUser() {
        val signupUser = SignupUser(UserInfo.DUMMY_USER, this as SignupUser.Repository)
        lateinit var result: Result<Unit>
        runBlocking { result = signupUser.signupUser() }
        TestCase.assertNotNull(result)
    }
}