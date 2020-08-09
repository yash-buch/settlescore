package com.binc.settlescore.dagger.memberquerygraph

import com.binc.settlescore.dagger.memberquerygraph.module.FirebaseMemberQueryRepositoryModule
import com.binc.settlescore.dagger.module.LocalRepositoryModule
import com.binc.settlescore.presentation.view.MainActivity
import com.binc.settlescore.presentation.view.OwnerInfoFragment
import com.binc.settlescore.presentation.viewmodel.MainViewModelProviderFactory
import dagger.Subcomponent

@Subcomponent(modules = [FirebaseMemberQueryRepositoryModule::class
    , LocalRepositoryModule::class])
interface MemberQueryComponent {
    fun getViewModelProviderFactory(): MainViewModelProviderFactory
    fun getOwnerInfoFragment(): OwnerInfoFragment

    fun inject(activity: MainActivity)
}