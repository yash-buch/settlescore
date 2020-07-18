package com.binc.settlescore.dagger.memberquerygraph

import com.binc.settlescore.dagger.memberquerygraph.module.FirebaseMemberQueryRepositoryModule
import com.binc.settlescore.dagger.memberquerygraph.module.LocalRepositoryModule
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import com.binc.settlescore.presentation.view.MainActivity
import com.binc.settlescore.presentation.viewmodel.ViewModelProviderFactory
import dagger.Subcomponent

@MemberQueryScope
@Subcomponent(modules = [FirebaseMemberQueryRepositoryModule::class
    , LocalRepositoryModule::class])
interface MemberQueryComponent {
    fun getMemberListUseCase(): GetMemberList
    fun getOwnerInfoUseCase(): GetOwnerInfo
    fun getViewModelProviderFactory(): ViewModelProviderFactory

    fun inject(activity: MainActivity)
}