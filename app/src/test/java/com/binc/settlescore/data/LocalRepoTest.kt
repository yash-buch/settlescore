package com.binc.settlescore.data

import android.content.Context
import android.content.SharedPreferences
import com.binc.settlescore.domain.interactors.OwnerInfo
import org.junit.Test
import org.mockito.Matchers.anyInt
import org.mockito.Matchers.anyString
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class LocalRepoTest {

    private val context: Context by lazy { Mockito.mock(Context::class.java) }

    private val sharedPreferences: SharedPreferences by lazy { Mockito.mock(SharedPreferences::class.java) }

    private val editor: SharedPreferences.Editor by lazy { Mockito.mock(SharedPreferences.Editor::class.java) }

    @Test
    fun test_getOwnerInfo() {
        val repo = LocalRepo(context)
        `when`(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPreferences)
        `when`(sharedPreferences.getString("name", "")).thenReturn("abc")
        `when`(sharedPreferences.getString("phoneNumber", "")).thenReturn("1234567890")
        `when`(sharedPreferences.getString("upi", "")).thenReturn("idk")
        `when`(sharedPreferences.getString("email", "")).thenReturn("xyz@gmail.com")

        var ownerInfo = repo.getOwnerInfo()
        assert(ownerInfo.name == "abc")
        assert(ownerInfo.phoneNumber == "1234567890")
        assert(ownerInfo.upi == "idk")
        assert(ownerInfo.email == "xyz@gmail.com")

        `when`(sharedPreferences.getString("name", "")).thenReturn("")
        `when`(sharedPreferences.getString("phoneNumber", "")).thenReturn("")
        `when`(sharedPreferences.getString("upi", "")).thenReturn("")
        `when`(sharedPreferences.getString("email", "")).thenReturn("")

        ownerInfo = repo.getOwnerInfo()
        assert(ownerInfo.name == "dummy")
        assert(ownerInfo.phoneNumber == "0000000000")
        assert(ownerInfo.upi == "dummy")
        assert(ownerInfo.email == "dummy")
    }

    @Test
    fun test_setOwnerInfo() {
        val repo = LocalRepo(context)
        `when`(context.getSharedPreferences(anyString(), anyInt())).thenReturn(sharedPreferences)
        `when`(sharedPreferences.edit()).thenReturn(editor)
        repo.setOwnerInfo(OwnerInfo("abc", "1234567890", "idk", "xyz@gmail.com"))
        verify(editor).commit()
    }
}