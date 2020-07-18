package com.binc.settlescore.infrastructure

import android.util.Log
import com.binc.settlescore.domain.interactors.Logger
import javax.inject.Inject

class AndroidLogger @Inject constructor(): Logger {

    init {
        Log.i("AndroidLogger", "object created")
    }

    override fun log(tag: String, msg: String) {
        Log.v(tag, msg)
    }

    override fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }

    override fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }

    override fun w(tag: String, msg: String) {
        Log.w(tag, msg)
    }

    override fun v(tag: String, msg: String) {
        Log.v(tag, msg)
    }

    protected fun finalize() {
        Log.i("AndroidLogger", "object destroyed")
    }
}