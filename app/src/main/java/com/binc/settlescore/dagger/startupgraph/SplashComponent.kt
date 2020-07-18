package com.binc.settlescore.dagger.startupgraph

import com.binc.settlescore.presentation.view.SplashActivity
import dagger.Subcomponent

@Subcomponent(modules = [NextIntentModule::class])
interface SplashComponent {

    fun inject(activity: SplashActivity)
}