package com.binc.settlescore.core

/**
 *  Base class for all the core implementation
 */
open class BaseCore {
    companion object {
        const val MANAGE_MEMBER_CORE = 100
        const val MANAGE_PAYMENTS_CORE = 101
        const val MANAGE_HISTORY_CORE = 102
        const val MANAGE_USER_LOGIN_SIGNUP_CORE = 103
    }

    fun getCoreInstance(coreType: Int) : BaseCore?{
        return when(coreType) {
            MANAGE_MEMBER_CORE -> ManageMembersCore()
            MANAGE_PAYMENTS_CORE -> ManagePaymentsCore()
            MANAGE_HISTORY_CORE -> ManageHistoryCore()
            MANAGE_USER_LOGIN_SIGNUP_CORE -> ManageUserLoginOrSignupCore()
            else -> null
        }
    }
}