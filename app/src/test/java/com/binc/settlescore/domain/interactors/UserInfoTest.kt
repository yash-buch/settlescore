package com.binc.settlescore.domain.interactors

import com.binc.settlescore.common.exceptions.ParamIncorrectException
import org.junit.Test

class UserInfoTest {

    @Test(expected = ParamIncorrectException::class)
    fun test_createUserInfoWithEmptyParam() {
        UserInfo("", "", "", "")
    }

    @Test(expected = ParamIncorrectException::class)
    fun test_createUserInfoWithWrongParam() {
        UserInfo("@", "a", "", "")
    }

    @Test
    fun test_createUserInfo() {
        UserInfo("a", "1234567890", "", "")
    }

}