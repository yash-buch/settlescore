package com.binc.settlescore.common.bean

import com.binc.settlescore.common.exceptions.ParamIncorrectException
import org.jetbrains.annotations.NotNull

/**
 *  Bean class to hold information related to a particular user
 */
class UserInfo private constructor(@NotNull name: String, @NotNull phNumber: PhoneNumber, @NotNull upi: String) {
    var mName = name
        set(value) {
            if (validateName(value))
                field = value
            else
                throw ParamIncorrectException()
        }
    var mPhoneNumber = phNumber

    var mUPIid = upi
        set(value) {
            if (validateUPI(value))
                field = value
            else
                throw ParamIncorrectException()
        }

    // TODO: username: field

    /**
     *  API to validate @param name
     *  @param name the name of the user
     */
    fun validateName(name: String): Boolean {
        return !name.isNullOrBlank()
    }

    /**
     *  API to validate @param upi
     *  @param upi the upi id of the user
     */
    fun validateUPI(upi: String): Boolean {
        return !upi.isNullOrBlank() and upi.contains('@')
    }

    companion object {
        /**
         *  API to create UserInfo object
         *  @param name
         *  @param phNumber
         *  @param upi
         */
        fun createUserInfo(name: String, phNumber: PhoneNumber, upi: String): UserInfo {
            val userInfo = UserInfo(name, phNumber, upi)
            if (userInfo.validateName(name) and
                userInfo.validateUPI(upi)
            ) return userInfo
            throw ParamIncorrectException()
        }
    }
}