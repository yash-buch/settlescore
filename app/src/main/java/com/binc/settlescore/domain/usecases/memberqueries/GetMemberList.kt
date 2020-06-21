package com.binc.settlescore.domain.usecases.memberqueries

import com.binc.settlescore.domain.BaseUseCase
import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import javax.inject.Inject

class GetMemberList @Inject constructor(private var repo: Repository) : BaseUseCase<ArrayList<UserInfo>>() {
    override suspend fun doInBackground(): ArrayList<UserInfo> {
        return repo.getMemberList()
    }

    suspend fun getMemberList(): Result<ArrayList<UserInfo>> {
        return executeAsync()
    }

    interface Repository {
        fun getMemberList(): ArrayList<UserInfo>
    }
}