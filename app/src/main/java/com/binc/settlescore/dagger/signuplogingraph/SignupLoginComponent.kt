package com.binc.settlescore.dagger.signuplogingraph

import com.binc.settlescore.domain.usecases.userloginsignup.LoginUser
import com.binc.settlescore.domain.usecases.userloginsignup.SignupUser
import dagger.Component

@Component(modules = [FirebaseLoginSignupRepositoryModule::class, UserInfoModule::class])
interface SignupLoginComponent {
    fun getSignupUserUseCase(): SignupUser
    fun getLoginUserUseCase(): LoginUser
}