package com.binc.settlescore.domain.interactors

import com.binc.settlescore.common.exceptions.ParamIncorrectException
import javax.inject.Inject

open class UserInfo
@Inject constructor(open var name: String, open var phoneNumber: String, open var upi: String,
                    open var email: String = "") {

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
        return when(true) {
            "" == name -> false
            !isOnlyAlphabets(name) -> false
            else -> true
        }
    }

    private fun isOnlyAlphabets(name: String): Boolean {
        name.decapitalize().forEach { if ((it < 'a') or (it > 'z')) return false }
        return true
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        return when(true) {
            phoneNumber.length == 10 -> true
            !isOnlyDigits(phoneNumber) -> false
            else -> false
        }
    }

    private fun isOnlyDigits(phoneNumber: String): Boolean {
        phoneNumber.forEach { if((it < '0') or (it > '9') ) return false}
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

    fun verifyUser(): Boolean {
        return validateEmail(email) &&
                validateName(name) &&
                validatePhoneNumber(phoneNumber) &&
                validateUPI(upi) &&
                !dummyUser()
    }

    private fun dummyUser(): Boolean {
        return "dummy" == name &&
                "0000000000" == phoneNumber &&
                "dummy" == email &&
                "dummy" == upi
    }

    override fun equals(other: Any?): Boolean {
        if(other !is UserInfo) return false
        var userInfo = other
        if (userInfo.name == this.name
            && userInfo.email == this.email
            && userInfo.upi == this.upi
            && userInfo.phoneNumber == this.phoneNumber)
            return true
        return false
    }

    override fun toString(): String {
        return "userInfo: name > $name \n phone number > $phoneNumber \n" +
                " email > $email \n upi > $upi"
    }

    companion object {
        val DUMMY_USER = UserInfo("name", "1234567890", "upi", "email")
        class Mapper {
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