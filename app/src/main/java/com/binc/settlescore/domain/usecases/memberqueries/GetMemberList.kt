package com.binc.settlescore.domain.usecases.memberqueries

import com.binc.settlescore.domain.BaseUseCase
import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import javax.inject.Inject

class GetMemberList @Inject constructor(private var repo: Repository) : BaseUseCase<List<UserInfo>>() {
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