package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class LoginUserTest : LoginUser.Repository {
    override fun loginUser(userInfo: UserInfo) {
        // do nothing
    }

    @Test
    fun test_getMemberList() {
        val loginUser = LoginUser(UserInfo.DUMMY_USER, this as LoginUser.Repository)
        lateinit var result: Result<Unit>
        runBlocking { result = loginUser.loginUser() }
        assertNotNull(result)
    }
}