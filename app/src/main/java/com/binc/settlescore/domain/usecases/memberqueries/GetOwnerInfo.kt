package com.binc.settlescore.domain.usecases.memberqueries

import com.binc.settlescore.domain.interactors.Logger
import com.binc.settlescore.domain.usecases.BaseUseCase
import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.domain.interactors.Result
import javax.inject.Inject

class GetOwnerInfo @Inject constructor(private var repo: Repository, logger: Logger): BaseUseCase<OwnerInfo>() {

    init {
        logger.log("GetOwnerInfo", "object created")
    }

    override suspend fun doInForeground(): OwnerInfo {
        return repo.getOwnerInfo()
    }

    suspend fun getOwnerInfo(): Result<OwnerInfo> {
        return execute()
    }

    interface Repository {
        fun getOwnerInfo(): OwnerInfo
    }
}