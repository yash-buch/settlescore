package com.binc.settlescore.repo

class ManageUserLoginOrSignupRepo: BaseRepo() {
    companion object {
        fun getInstance(): ManageUserLoginOrSignupRepo {
            return ManageUserLoginOrSignupRepo()
        }
    }
}