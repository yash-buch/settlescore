package com.binc.settlescore.domain.usecases.memberqueries

import com.binc.settlescore.data.BaseRepo
import com.binc.settlescore.data.FirebaseRepo
import com.binc.settlescore.domain.BaseUseCase
import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import javax.inject.Inject

class GetMemberList @Inject constructor(repo: Repository) : BaseUseCase<List<UserInfo>>() {
    val TAG: String = "SS:GetMemberList"
    var repo: Repository = repo
    override suspend fun doInBackground(): List<UserInfo> {
        return repo.getMemberList()
    }

    suspend fun getMemberList(): Result<List<UserInfo>> {
        return executeAsync()
    }

    interface Repository {
        fun getMemberList(): List<UserInfo>
    }
}