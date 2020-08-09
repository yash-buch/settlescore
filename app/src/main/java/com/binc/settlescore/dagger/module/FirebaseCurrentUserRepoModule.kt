package com.binc.settlescore.dagger.module

import com.binc.settlescore.data.FirebaseRepo
import com.binc.settlescore.domain.usecases.userloginsignup.CurrentUser
import dagger.Binds
import dagger.Module

@Module
abstract class FirebaseCurrentUserRepoModule {
    @Binds
    abstract fun bindCurrentUserRepository(firebaseRepo: FirebaseRepo): CurrentUser.Repository
}