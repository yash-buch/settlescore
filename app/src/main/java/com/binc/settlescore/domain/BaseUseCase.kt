package com.binc.settlescore.domain

import com.binc.settlescore.domain.interactors.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

abstract class BaseUseCase<K> {

    protected suspend fun executeAsync(): Result<K> = withContext(Dispatchers.Default) {
        delay(5000)
        return@withContext Result(doInBackground())
    }

    protected abstract suspend fun doInBackground(): K
}