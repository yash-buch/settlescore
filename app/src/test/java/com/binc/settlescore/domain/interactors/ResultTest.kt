package com.binc.settlescore.domain.interactors

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ResultTest {

    @Test
    fun test_createResultWithString() {
        val result = Result("test")
        assertEquals("test", result.result)
    }

    @Test
    fun test_createResultWithInt() {
        val result = Result(1)
        assertEquals(1, result.result)
    }
}