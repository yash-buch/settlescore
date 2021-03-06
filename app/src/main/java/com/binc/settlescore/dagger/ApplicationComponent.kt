package com.binc.settlescore.dagger

import com.binc.settlescore.dagger.memberquerygraph.MemberQueryComponent
import com.binc.settlescore.dagger.signuplogingraph.SignupLoginComponent
import com.binc.settlescore.dagger.startupgraph.SplashComponent
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun getSplashComponent(): SplashComponent
    fun getMemberQueryComponent(): MemberQueryComponent
    fun getSignUpLoginComponent(): SignupLoginComponent

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        fun applicationModule(applicationModule: ApplicationModule): Builder
    }
}