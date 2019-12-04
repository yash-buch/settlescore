package com.binc.settlescore.common.bean

import com.binc.settlescore.core.exceptions.ParamIncorrectException
import org.jetbrains.annotations.NotNull

/**
 *  Bean class to hold information related to a particular user
 */
class UserInfo private constructor(@NotNull name: String, @NotNull phNumber: String, @NotNull upi: String) {
    var mName = name
        set(value) {
            if (validateName(value))
                mName = value
            else
                throw ParamIncorrectException()
        }
    var mPhoneNumber = phNumber
        set(value) {
            if (validatePhoneNumber(value))
                mPhoneNumber = value
            else
                throw ParamIncorrectException()
        }
    var mUPIid = upi
        set(value) {
            if (validateUPI(value))
                mUPIid = value
            else
                throw ParamIncorrectException()
        }

    // TODO: username: field

    fun validateName(name: String): Boolean {
        return !name?.isNullOrBlank()
    }

    fun validatePhoneNumber(phNumber: String): Boolean {
        var isNumber = true
        for (char in phNumber) {
            if(!char.isDigit()) {
                isNumber = false
                break
            }
        }
        return !phNumber?.isNullOrBlank() and (phNumber.length == 10) and isNumber
    }

    fun validateUPI(upi: String): Boolean {
        return !upi?.isNullOrBlank() and upi.contains('@')
    }

    companion object {
        fun createUserInfo(name: String, phNumber: String, upi: String): UserInfo {
            var userInfo = UserInfo(name, phNumber, upi)
            if(userInfo.validateName(name) and
                    userInfo.validatePhoneNumber(phNumber) and
                    userInfo.validateUPI(upi))
                return userInfo
            throw ParamIncorrectException()
        }
    }
}