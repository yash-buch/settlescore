package com.binc.settlescore.core.executors

class OrdinaryThreadFactory() : ThreadFactory() {
    override fun newThread(r: Runnable?): Thread {
        val thread = super.newThread(r)
        thread.priority = 3
        return thread
    }
}