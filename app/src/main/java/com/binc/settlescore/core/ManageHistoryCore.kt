package com.binc.settlescore.core


/**
 *  Core class to maintain history of payment requests
 */
class ManageHistoryCore : BaseCore() {
    companion object {
        fun getInstance(): ManageHistoryCore {
            return ManageHistoryCore()
        }
    }
}