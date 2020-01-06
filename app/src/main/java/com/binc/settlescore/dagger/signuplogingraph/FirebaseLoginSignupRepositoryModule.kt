package com.binc.settlescore.dagger.signuplogingraph

import com.binc.settlescore.data.FirebaseRepo
import com.binc.settlescore.domain.usecases.userloginsignup.LoginUser
import com.binc.settlescore.domain.usecases.userloginsignup.SignupUser
import dagger.Module
import dagger.Provides

@Module
class FirebaseLoginSignupRepositoryModule {
    @Provides
    fun provideFireBaseSignupRepository(): SignupUser.Repository {
        return FirebaseRepo<Unit>()
    }

    @Provides
    fun provideFireBaseLoginRepository(): LoginUser.Repository {
        return FirebaseRepo<Unit>()
    }
}