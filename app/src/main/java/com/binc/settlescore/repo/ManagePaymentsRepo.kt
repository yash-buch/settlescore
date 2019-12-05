package com.binc.settlescore.repo

class ManagePaymentsRepo: BaseRepo() {
    companion object {
        fun getInstance(): ManagePaymentsRepo {
            return ManagePaymentsRepo()
        }
    }
}