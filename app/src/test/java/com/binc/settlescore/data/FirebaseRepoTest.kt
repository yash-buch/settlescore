package com.binc.settlescore.data

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.binc.settlescore.domain.interactors.UserInfo
import com.google.firebase.FirebaseApp
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FirebaseRepoTest {

    @Before
    fun setup() {
        FirebaseApp.initializeApp(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun test_getMemberList() {
        val repo: FirebaseRepo = FirebaseRepo()
        val list = repo.getMemberList()
        assert (list.size != 0)
    }

    @Test
    fun test_signupUser() {
        val repo: FirebaseRepo = FirebaseRepo()
        runBlocking {
            repo.signupUser(UserInfo.DUMMY_USER)
        }
    }

    @Test
    fun test_loginUser() {
        val repo: FirebaseRepo = FirebaseRepo()
        runBlocking {
            repo.loginUser(UserInfo.DUMMY_USER)
        }
    }
}