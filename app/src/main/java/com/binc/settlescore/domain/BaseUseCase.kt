package com.binc.settlescore.domain

import android.util.Log
import com.binc.settlescore.domain.interactors.Result
import kotlinx.coroutines.*

abstract class BaseUseCase<K> {

    suspend fun executeAsync(): Result<K> = withContext(Dispatchers.Default) {
        Log.d("check", "${Thread.currentThread().name}")
        return@withContext Result(doInBackground())
    }

    abstract suspend fun doInBackground(): K
}