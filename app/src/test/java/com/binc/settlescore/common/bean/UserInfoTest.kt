package com.binc.settlescore.common.bean

import com.binc.settlescore.common.bean.UserInfo.Companion.createUserInfo
import junit.framework.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserInfoTest {
    val name = "Test"
    val phNumber = "1234567890"
    val upi = "xyz@abc"

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test_createUserInfo() {
        val uInfo = createUserInfo(name, phNumber, upi)
        assertEquals(name, uInfo.mName)
        assertEquals(phNumber, uInfo.mPhoneNumber)
        assertEquals(upi, uInfo.mUPIid)
    }

    @Test
    fun test_validateName() {
        val uInfo = createUserInfo(name, phNumber, upi)
        assertTrue(uInfo.validateName("test"))
        assertFalse(uInfo.validateName(""))
    }

    @Test
    fun test_validatePhoneNumber() {
        val uInfo = createUserInfo(name, phNumber, upi)
        assertFalse(uInfo.validatePhoneNumber("testaaaaaa"))
        assertTrue(uInfo.validatePhoneNumber("1234567890"))
        assertFalse(uInfo.validatePhoneNumber(""))
        assertFalse(uInfo.validatePhoneNumber("abc"))
    }

    @Test
    fun test_validateUPI() {
        val uInfo = createUserInfo(name, phNumber, upi)
        assertTrue(uInfo.validateUPI("test@"))
        assertFalse(uInfo.validateUPI("test"))
        assertFalse(uInfo.validateUPI(""))
    }
}