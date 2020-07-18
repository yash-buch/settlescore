package com.binc.settlescore.domain.usecases

import com.binc.settlescore.domain.interactors.Result

abstract class BaseUseCase<K> {

    protected suspend fun execute(): Result<K> = Result(doInForeground())

    protected abstract suspend fun doInForeground(): K
}