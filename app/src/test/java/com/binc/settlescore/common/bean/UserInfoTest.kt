package com.binc.settlescore.common.bean

import com.binc.settlescore.common.bean.UserInfo.Companion.createUserInfo
import junit.framework.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserInfoTest {
    val name = "Test"
    val phNumber: PhoneNumber = PhoneNumber()
    val upi = "xyz@abc"

    @Before
    fun setUp() {
        phNumber.phoneNumber = "1234567890"
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
    fun test_validateUPI() {
        val uInfo = createUserInfo(name, phNumber, upi)
        assertTrue(uInfo.validateUPI("test@"))
        assertFalse(uInfo.validateUPI("test"))
        assertFalse(uInfo.validateUPI(""))
    }
}