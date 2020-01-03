package com.binc.settlescore.domain.interactors

import com.binc.settlescore.common.exceptions.ParamIncorrectException
import javax.inject.Inject

class UserInfo
@Inject constructor(name: String, phoneNumber: String, upi: String, email: String = "") {
    var name: String
    var phoneNumber: String
    var upi: String
    var email: String

    init {
        this.name = if (validateName(name)) name
        else throw ParamIncorrectException("name")
        this.phoneNumber = if (validatePhoneNumber(phoneNumber)) phoneNumber
        else throw ParamIncorrectException("phoneNumber")
        this.upi = if (validateUPI(upi)) upi
        else throw ParamIncorrectException("upi")
        this.email = if (validateEmail(email)) email
        else throw ParamIncorrectException("email")
    }

    private fun validateName(name: String): Boolean {
        //TODO("Not implemented")
        return true
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        //TODO("Not implemented")
        return true
    }

    private fun validateUPI(upi: String): Boolean {
        //TODO("Not implemented")
        return true
    }

    private fun validateEmail(email: String): Boolean {
        //TODO("Not implemented")
        return true
    }

    companion object {
        class Mapper constructor() {
            var name = ""
            var phoneNumber = ""
            var upi = ""
            var email = ""

            companion object {
                fun getUserInfoMapper(): Mapper {
                    return Mapper()
                }
            }

            fun map(param: String, value: String): Mapper {
                when(param) {
                    "name" -> {this.name = value
                        return this}
                    "phoneNumber" -> {this.phoneNumber = value
                        return this}
                    "upi" -> {this.upi = value
                        return this}
                    "email" -> {this.email = value
                        return this}
                    else -> throw ParamIncorrectException("")
                }
            }

            fun constructUserInfo(): UserInfo {
                return UserInfo(name, phoneNumber, upi, email)
            }
        }
    }
}