package com.binc.settlescore.common.bean

import com.binc.settlescore.common.exceptions.ParamIncorrectException

class PhoneNumber {
    var phoneNumber: String = ""
        get() {
            return field
        }
        set(value) {
            if (!validatePhoneNumber(value))
                throw ParamIncorrectException()
        }

    /**
     *  API to validate @param phNumber
     *  @param phNumber the phone number of the user
     */
    fun validatePhoneNumber(phNumber: String): Boolean {
        var isNumber = true
        for (char in phNumber) {
            if (!char.isDigit()) {
                isNumber = false
                break
            }
        }
        return !phNumber.isNullOrBlank() and (phNumber.length == 10) and isNumber
    }
}