package com.binc.settlescore.dagger.memberquerygraph

import com.binc.settlescore.dagger.memberquerygraph.module.ApplicationModule
import com.binc.settlescore.dagger.memberquerygraph.module.MainViewModule
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.presentation.view.MainActivity
import com.binc.settlescore.presentation.viewmodel.ViewModelProviderFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainViewModule::class, ApplicationModule::class, FirebaseMemberQueryRepositoryModule::class])
interface MemberQueryComponent {
    fun getMemberListUseCase(): GetMemberList
    fun getViewModelProviderFactory(): ViewModelProviderFactory

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): MemberQueryComponent
        fun mainViewModule(mainViewModule: MainViewModule): Builder
        fun applicationModule(applicationModule: ApplicationModule): Builder
    }
}