package com.binc.settlescore.data

import android.util.Log
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.domain.usecases.userloginsignup.LoginUser
import com.binc.settlescore.domain.usecases.userloginsignup.SignupUser
import javax.inject.Inject

class FirebaseRepo<K> @Inject constructor() : BaseRepo<K>(),
    GetMemberList.Repository,
    SignupUser.Repository,
    LoginUser.Repository {

    override fun getMemberList(): List<UserInfo> {
        var list = ArrayList<UserInfo>()
        var mapper: UserInfo.Companion.Mapper = UserInfo.Companion.Mapper.getUserInfoMapper()
        mapper.map("name", "Yash")
            .map("phoneNumber", "1234567890")
            .map("upi", "abc")
            .map("email", "email")
        var uInfo = mapper.constructUserInfo()
        list.add(UserInfo("A", "B", "C"))
        list.add(uInfo)
        return list
    }

    override fun signupUser(userInfo: UserInfo) {
        Log.d("check", "user signed up")
    }

    override fun loginUser(userInfo: UserInfo) {
        Log.d("check", "user logged up")
    }
}