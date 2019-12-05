package com.binc.settlescore.repo

class ManageHistoryRepo: BaseRepo() {
    companion object {
        fun getInstance(): ManageHistoryRepo {
            return ManageHistoryRepo()
        }
    }
}