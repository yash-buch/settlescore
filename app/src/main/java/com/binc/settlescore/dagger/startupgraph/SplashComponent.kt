package com.binc.settlescore.dagger.startupgraph

import com.binc.settlescore.presentation.view.SplashActivity
import dagger.Component

@Component(modules = [NextIntentModule::class])
interface SplashComponent {

    fun inject(activity: SplashActivity)
}