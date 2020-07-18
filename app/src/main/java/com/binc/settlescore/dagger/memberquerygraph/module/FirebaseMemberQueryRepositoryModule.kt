package com.binc.settlescore.dagger.memberquerygraph.module

import com.binc.settlescore.data.FirebaseRepo
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import dagger.Module
import dagger.Provides

@Module
class FirebaseMemberQueryRepositoryModule {
    @Provides
    fun provideFireBaseRepository(): GetMemberList.Repository {
        return FirebaseRepo()
    }
}