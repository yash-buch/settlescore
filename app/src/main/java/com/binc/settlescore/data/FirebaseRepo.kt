package com.binc.settlescore.data

import com.binc.settlescore.SSApplication
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.domain.usecases.userloginsignup.CurrentUser
import com.binc.settlescore.domain.usecases.userloginsignup.LoginUser
import com.binc.settlescore.domain.usecases.userloginsignup.SignupUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

class FirebaseRepo @Inject constructor() : BaseRepo<UserInfo>(),
    GetMemberList.Repository,
    SignupUser.Repository,
    LoginUser.Repository,
    CurrentUser.Repository{

    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun getMemberList(): ArrayList<UserInfo> {
        var list: ArrayList<UserInfo> = ArrayList()
        if (SSApplication.DEBUG)
            list = getDummyUserList()
        return list
    }

    override suspend fun signupUser(userInfo: UserInfo): Boolean {
        auth.createUserWithEmailAndPassword(userInfo.email, userInfo.phoneNumber).await()
        return auth.currentUser != null
    }

    override suspend fun loginUser(userInfo: UserInfo): Boolean {
        auth.signInWithEmailAndPassword(userInfo.email, userInfo.phoneNumber).await()
        return auth.currentUser != null
    }

    private fun getDummyUserList(count: Int = 15): ArrayList<UserInfo> {
        val list = ArrayList<UserInfo>()
        for (index in 0..count) {
            list.add(UserInfo.DUMMY_USER)
        }
        return list
    }

    override fun getUser(): UserInfo? {
        val fbUser = auth.currentUser
        return fbUser?.map
    }

    private val FirebaseUser.map : UserInfo?
        get() {
            val dummy = UserInfo.DUMMY_USER
            return UserInfo(this.displayName ?: dummy.name,
                this.phoneNumber ?: dummy.phoneNumber, dummy.upi, this.email ?: dummy.email)
        }
}