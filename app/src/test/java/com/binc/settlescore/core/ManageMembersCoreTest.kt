package com.binc.settlescore.core

import com.binc.settlescore.common.bean.PhoneNumber
import com.binc.settlescore.common.bean.UserInfo
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ManageMembersCoreTest {
    lateinit var manageMembersCore: ManageMembersCore

    @Before
    fun setup() {
        manageMembersCore = ManageMembersCore.getInstance()
    }
    @Test
    fun test_getMembersList() {
        var list = manageMembersCore.getMemberList()
        runBlocking {
            var arrList = list.await()
            assertNotNull(arrList)
        }
    }

    @Test
    fun test_addMemberToList() {
        var funCall = manageMembersCore.addMemberToList(UserInfo.createUserInfo(
            "test",
            PhoneNumber(),
            "@"))
        runBlocking { assertEquals(funCall.await(), Unit) }
    }

    @Test
    fun test_searchUser() {
        var phoneNumber = PhoneNumber()
        var funCall = manageMembersCore.searchUser(phoneNumber)
        runBlocking { assertNotNull(funCall.await()) }
    }
}