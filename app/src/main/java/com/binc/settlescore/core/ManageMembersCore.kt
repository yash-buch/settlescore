package com.binc.settlescore.core

import com.binc.settlescore.common.bean.PhoneNumber
import com.binc.settlescore.common.bean.UserInfo
import com.binc.settlescore.repo.BaseRepo
import com.binc.settlescore.repo.ManageMembersRepo
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

/**
 *  Core class to handle queries related to users
 */
class ManageMembersCore private constructor(): BaseCore() {
    private var mManageMembersRepo = BaseRepo.getRepoInstance(BaseRepo.MANAGE_MEMBER_REPO)

    /**
     *  API to get instance of ManageMembersCore
     */
    companion object {
        fun getInstance(): ManageMembersCore {
            return ManageMembersCore()
        }
    }

    /**
     * API to get the list of added users
     */
    fun getMemberList(): Deferred<List<UserInfo>> {
        return GlobalScope.async {
            (mManageMembersRepo as ManageMembersRepo).getMembersList()
        }
    }

    /**
     * API to add user
     * @param userInfo user information to be added
     */
    fun addMemberToList(userInfo: UserInfo): Deferred<Unit> {
        return GlobalScope.async {
            (mManageMembersRepo as ManageMembersRepo).addMemberToList(userInfo)
        }
    }

    /**
     * API to search user
     * @param phNumber phone number of the user to find
     */
    fun searchUser(phNumber: PhoneNumber): Deferred<UserInfo> {
        return GlobalScope.async {
            (mManageMembersRepo as ManageMembersRepo).searchUser(phNumber)
        }
    }
}