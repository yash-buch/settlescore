package com.binc.settlescore.repo

import com.binc.settlescore.common.bean.PhoneNumber
import com.binc.settlescore.common.bean.UserInfo

class ManageMembersRepo: BaseRepo() {
    companion object {
        fun getInstance(): ManageMembersRepo {
            return ManageMembersRepo()
        }
    }

    fun getMembersList(): List<UserInfo> {
        return ArrayList()
    }

    fun addMemberToList(userInfo: UserInfo) {

    }

    fun searchUser(phoneNumber: PhoneNumber): UserInfo {
        return UserInfo.createUserInfo("test",PhoneNumber(),"@")
    }
}