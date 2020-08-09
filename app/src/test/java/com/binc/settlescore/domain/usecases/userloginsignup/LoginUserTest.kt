package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class LoginUserTest : LoginUser.Repository {
    override suspend fun loginUser(userInfo: UserInfo): Boolean {
        // do nothing
        return false
    }

    @Test
    fun test_getMemberList() {
        val loginUser = LoginUser(this as LoginUser.Repository)
        lateinit var result: Result<Boolean>
        runBlocking { result = loginUser.loginUser(UserInfo.DUMMY_USER) }
        assertNotNull(result)
    }
}