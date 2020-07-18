package com.binc.settlescore.domain.usecases.memberqueries

import com.binc.settlescore.domain.interactors.Logger
import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.BaseAsyncUseCase
import javax.inject.Inject

class GetMemberList @Inject constructor (private var repo: Repository, logger: Logger) : BaseAsyncUseCase<ArrayList<UserInfo>>() {

    init {
        logger.log("GetMemberList", "object created")
    }
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