package com.binc.settlescore.domain.usecases.memberqueries

import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetMemberListTest : GetMemberList.Repository {
    override fun getMemberList(): List<UserInfo> {
        val list = ArrayList<UserInfo>()
        list.add(UserInfo.DUMMY_USER)
        return list
    }

    @Test
    fun test_getMemberList() {
        val getMemberList = GetMemberList(this as GetMemberList.Repository)
        lateinit var list: List<UserInfo>
        lateinit var result: Result<List<UserInfo>>
        runBlocking { result = getMemberList.getMemberList() }
        assertNotNull(result)
        list = result.result
        assertNotNull(list)
        assertEquals(list[0], UserInfo.DUMMY_USER)
    }
}