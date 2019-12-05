package com.binc.settlescore.common.bean

import junit.framework.Assert
import org.junit.Before
import org.junit.Test

class PhoneNumberTest {

    @Test
    fun test_validatePhoneNumber() {
        val phNumber = PhoneNumber()
        Assert.assertFalse(phNumber.validatePhoneNumber("testaaaaaa"))
        Assert.assertTrue(phNumber.validatePhoneNumber("1234567890"))
        Assert.assertFalse(phNumber.validatePhoneNumber(""))
        Assert.assertFalse(phNumber.validatePhoneNumber("abc"))
    }
}