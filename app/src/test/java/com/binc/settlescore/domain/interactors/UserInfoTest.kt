package com.binc.settlescore.domain.interactors

import com.binc.settlescore.common.exceptions.ParamIncorrectException
import org.junit.Assert.assertEquals
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

    @Test
    fun test_mapper() {
        val dummyUser: UserInfo = UserInfo.DUMMY_USER
        val mapper: UserInfo.Companion.Mapper = UserInfo.Companion.Mapper.getUserInfoMapper()
        mapper.map("name", dummyUser.name)
            .map("phoneNumber", dummyUser.phoneNumber)
            .map("upi", dummyUser.upi)
            .map("email", dummyUser.email)
        assertEquals(dummyUser, mapper.constructUserInfo())

    }

    @Test(expected = ParamIncorrectException::class)
    fun test_mapperWrongKey() {
        val mapper: UserInfo.Companion.Mapper = UserInfo.Companion.Mapper.getUserInfoMapper()
        mapper.map("abc", "don't matter")
    }

    @Test
    fun test_toString() {
        println(UserInfo.DUMMY_USER.toString())
    }

}