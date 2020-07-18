package com.binc.settlescore.data

import android.util.Log
import com.binc.settlescore.SSApplication
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.domain.usecases.userloginsignup.LoginUser
import com.binc.settlescore.domain.usecases.userloginsignup.SignupUser
import javax.inject.Inject

class FirebaseRepo @Inject constructor() : BaseRepo<UserInfo>(),
    GetMemberList.Repository,
    SignupUser.Repository,
    LoginUser.Repository {

    override fun getMemberList(): ArrayList<UserInfo> {
        var list: ArrayList<UserInfo> = ArrayList()
        if (SSApplication.DEBUG)
            list = getDummyUserList(15)
        return list
    }

    override fun signupUser(userInfo: UserInfo) {
        Log.d("check", "user signed up")
    }

    override fun loginUser(userInfo: UserInfo) {
        Log.d("check", "user logged up")
    }

    private fun getDummyUserList(count: Int) : ArrayList<UserInfo> {
        val list = ArrayList<UserInfo>()
        for(index in 0..count) {
            list.add(UserInfo.DUMMY_USER)
        }
        return list
    }
}