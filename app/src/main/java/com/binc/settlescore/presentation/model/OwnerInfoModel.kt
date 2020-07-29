package com.binc.settlescore.presentation.model

import com.binc.settlescore.domain.interactors.OwnerInfo

class OwnerInfoModel constructor(var ownerInfo: OwnerInfo) {
    fun isOwnerVerified(): Boolean {
        return ownerInfo.verifyUser()
    }
}