package com.binc.settlescore.data

import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import javax.inject.Inject

class LocalRepo @Inject constructor(): BaseRepo<OwnerInfo>(),
    GetOwnerInfo.Repository{

    override fun getOwnerInfo(): OwnerInfo {
        return when(isOwnerInfoAvailable()) {
            true -> buildOwnerInfo()
            false -> buildEmptyOwnerInfo()
        }
    }

    private fun isOwnerInfoAvailable(): Boolean {
        //check the ownerinfo saved in shared preference
        return false
    }

    private fun buildOwnerInfo(): OwnerInfo {
        return OwnerInfo()
    }

    private fun buildEmptyOwnerInfo(): OwnerInfo {
        return OwnerInfo()
    }
}