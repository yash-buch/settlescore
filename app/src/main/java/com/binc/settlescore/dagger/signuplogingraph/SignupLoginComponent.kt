package com.binc.settlescore.dagger.signuplogingraph

import com.binc.settlescore.dagger.module.IntentModule
import com.binc.settlescore.dagger.module.LocalRepositoryModule
import com.binc.settlescore.domain.usecases.userloginsignup.LoginUser
import com.binc.settlescore.domain.usecases.userloginsignup.SignupUser
import com.binc.settlescore.presentation.view.OwnerInfoFragment
import com.binc.settlescore.presentation.view.SignUpActivity
import dagger.Subcomponent

@Subcomponent(modules = [FirebaseLoginSignupRepositoryModule::class, IntentModule::class, LocalRepositoryModule::class])
interface SignupLoginComponent {
    fun inject(signUpActivity: SignUpActivity)
}