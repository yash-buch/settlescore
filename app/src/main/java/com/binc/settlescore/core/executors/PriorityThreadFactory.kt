package com.binc.settlescore.core.executors

class PriorityThreadFactory() : ThreadFactory() {
    override fun newThread(r: Runnable?): Thread {
        val thread = super.newThread(r)
        thread.priority = 8
        return thread
    }

}