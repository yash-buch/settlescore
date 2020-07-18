package com.binc.settlescore.dagger.memberquerygraph.module

import com.binc.settlescore.data.LocalRepo
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import dagger.Module
import dagger.Provides

@Module
class LocalRepositoryModule {
    @Provides
    fun provideFireBaseRepository(): GetOwnerInfo.Repository {
        return LocalRepo()
    }
}