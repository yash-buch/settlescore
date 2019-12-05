package com.binc.settlescore.core

/**
 *  Core class to handle payment requests
 */
class ManagePaymentsCore : BaseCore() {
    companion object {
        fun getInstance(): ManagePaymentsCore {
            return ManagePaymentsCore()
        }
    }
}