package com.binc.settlescore.domain.interactors

import javax.inject.Inject

data class OwnerInfo @Inject constructor(var ownerName: String, var ownerPhoneNumber: String
                                         , var ownerUpi: String, var ownerEmail: String = "")
    : UserInfo( ownerName,  ownerPhoneNumber,  ownerUpi,  ownerEmail)