package com.binc.settlescore.dagger.startupgraph

import com.binc.settlescore.dagger.module.FirebaseCurrentUserRepoModule
import com.binc.settlescore.dagger.module.IntentModule
import com.binc.settlescore.presentation.view.SplashActivity
import com.binc.settlescore.presentation.viewmodel.SplashViewModelProviderFactory
import dagger.Subcomponent

@Subcomponent(modules = [IntentModule::class, FirebaseCurrentUserRepoModule::class])
interface SplashComponent {
    fun getSplashViewModelProviderFactory(): SplashViewModelProviderFactory
    fun inject(activity: SplashActivity)
}