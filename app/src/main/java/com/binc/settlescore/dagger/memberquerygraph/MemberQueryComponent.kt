package com.binc.settlescore.dagger.memberquerygraph

import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import dagger.Component

@Component(modules = [FireBaseRepositoryModule::class])
interface MemberQueryComponent {
    fun getMemberListUseCase(): GetMemberList
}