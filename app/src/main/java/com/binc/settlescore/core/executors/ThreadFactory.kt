package com.binc.settlescore.core.executors

import java.util.concurrent.ThreadFactory

open class ThreadFactory() : ThreadFactory {

    override fun newThread(r: Runnable?): Thread {
        return Thread()
    }
}