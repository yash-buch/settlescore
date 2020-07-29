package com.binc.settlescore.dagger.memberquerygraph.module

import com.binc.settlescore.data.LocalRepo
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import dagger.Binds
import dagger.Module

@Module
abstract class LocalRepositoryModule {
    @Binds
    abstract fun bindLocalRepository(localRepository: LocalRepo): GetOwnerInfo.Repository
}