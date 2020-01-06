package com.binc.settlescore.dagger.signuplogingraph

import com.binc.settlescore.domain.interactors.UserInfo
import dagger.Module
import dagger.Provides

@Module
class UserInfoModule constructor(userInfo: UserInfo) {
    var userInfo = userInfo

    @Provides
    fun provideUserInfo(): UserInfo {
        return userInfo
    }
}