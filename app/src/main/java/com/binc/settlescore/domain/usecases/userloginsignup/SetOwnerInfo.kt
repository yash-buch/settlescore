package com.binc.settlescore.domain.usecases.userloginsignup

import com.binc.settlescore.domain.interactors.Logger
import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.domain.interactors.Result
import com.binc.settlescore.domain.usecases.BaseAsyncUseCase
import javax.inject.Inject

class SetOwnerInfo @Inject constructor(private var repo: Repository, logger: Logger)
    : BaseAsyncUseCase<Unit>() {

    lateinit var ownerInfo: OwnerInfo

    override suspend fun doInBackground() {
        repo.setOwnerInfo(ownerInfo)
    }

    suspend fun setOwnerInfo(oInfo: OwnerInfo): Result<Unit> {
        ownerInfo = oInfo
        return executeAsync()
    }

    interface Repository {
        fun setOwnerInfo(ownerInfo: OwnerInfo)
    }
}