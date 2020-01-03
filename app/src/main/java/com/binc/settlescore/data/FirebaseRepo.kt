package com.binc.settlescore.data

import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import javax.inject.Inject

class FirebaseRepo<K> @Inject constructor(): BaseRepo<K>(), GetMemberList.Repository {
    override fun getMemberList(): List<UserInfo> {
        var list = ArrayList<UserInfo>()
        var mapper: UserInfo.Companion.Mapper = UserInfo.Companion.Mapper.getUserInfoMapper()
        mapper.map("name", "Yash")
            .map("phoneNumber", "1234567890")
            .map("upi", "abc")
            .map("email", "email")
        var uInfo = mapper.constructUserInfo()
        list.add(UserInfo("A","B","C"))
        list.add(uInfo)
        return list
    }
}