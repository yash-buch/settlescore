package com.binc.settlescore.common.exceptions

abstract class BaseException: Exception() {
    abstract val msg: String
}