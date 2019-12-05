package com.binc.settlescore.repo

/**
 *  Base class for all the repo implementation
 */
open class BaseRepo {
    companion object {
        const val MANAGE_MEMBER_REPO = 100
        const val MANAGE_PAYMENTS_REPO = 101
        const val MANAGE_HISTORY_REPO = 102
        const val MANAGE_USER_LOGIN_SIGNUP_REPO = 103

        /**
         * API to get @param type of core instance
         * @param repoType type of core
         */
        fun getRepoInstance(repoType: Int): BaseRepo? {
            return when (repoType) {
                MANAGE_MEMBER_REPO -> ManageMembersRepo.getInstance()
                MANAGE_PAYMENTS_REPO -> ManagePaymentsRepo.getInstance()
                MANAGE_HISTORY_REPO -> ManageHistoryRepo.getInstance()
                MANAGE_USER_LOGIN_SIGNUP_REPO -> ManageUserLoginOrSignupRepo.getInstance()
                else -> null
            }
        }
    }
}