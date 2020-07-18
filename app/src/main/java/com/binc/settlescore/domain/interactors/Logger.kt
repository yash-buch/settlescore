package com.binc.settlescore.domain.interactors

interface Logger {
    fun log(tag: String = "SettleScore", msg: String)
    fun d(tag: String = "SettleScore", msg: String)
    fun e(tag: String = "SettleScore", msg: String)
    fun w(tag: String = "SettleScore", msg: String)
    fun v(tag: String = "SettleScore", msg: String)
}