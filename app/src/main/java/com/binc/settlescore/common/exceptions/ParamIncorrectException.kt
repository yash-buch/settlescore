package com.binc.settlescore.common.exceptions

class ParamIncorrectException
constructor(override val msg: String) : BaseException() {
    override val message: String?
        get() = "Incorrect parameter exception: $msg"
}