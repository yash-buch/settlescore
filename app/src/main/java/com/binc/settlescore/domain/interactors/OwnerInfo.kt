package com.binc.settlescore.domain.interactors

import javax.inject.Inject

class OwnerInfo: UserInfo {
    @Inject
    constructor(
        name: String, phoneNumber: String,
        upi: String, email: String
    ) : super(name, phoneNumber, upi, email)
}