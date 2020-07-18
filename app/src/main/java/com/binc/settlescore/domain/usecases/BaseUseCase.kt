package com.binc.settlescore.domain.usecases

import com.binc.settlescore.domain.interactors.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<K> {

    protected suspend fun execute(): Result<K> = withContext(Dispatchers.Main) {
        return@withContext Result(doInForeground())
    }

    protected abstract suspend fun doInForeground(): K
}