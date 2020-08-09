package com.binc.settlescore.dagger.module

import com.binc.settlescore.data.LocalRepo
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import com.binc.settlescore.domain.usecases.userloginsignup.SetOwnerInfo
import dagger.Binds
import dagger.Module

@Module
abstract class LocalRepositoryModule {
    @Binds
    abstract fun bindGetOwnerInfoRepository(localRepository: LocalRepo): GetOwnerInfo.Repository

    @Binds
    abstract fun bindSetOwnerInfoRepository(localRepository: LocalRepo): SetOwnerInfo.Repository
}