package com.binc.settlescore.domain.usecases.memberqueries

import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.infrastructure.AndroidLogger
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetOwnerInfoTest {
    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @ExperimentalCoroutinesApi
    @ObsoleteCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun test_getOwnerInfo() {
        val repo: GetOwnerInfo.Repository = object : GetOwnerInfo.Repository {
            override fun getOwnerInfo(): OwnerInfo {
                return OwnerInfo("dummy", "0000000000", "dummy", "dummy")
            }
        }

        val uc = GetOwnerInfo(repo, AndroidLogger())

        runBlocking {
            val result = uc.getOwnerInfo()
            assertNotNull(result.result)
        }
    }
}