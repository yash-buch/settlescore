package com.binc.settlescore.domain.usecases

import com.binc.settlescore.domain.interactors.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseAsyncUseCase<K> {
    protected suspend fun executeAsync(): Result<K> = withContext(Dispatchers.Default) {
        return@withContext Result(doInBackground())
    }

    protected abstract suspend fun doInBackground(): K
}