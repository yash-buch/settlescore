package com.binc.settlescore.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.userloginsignup.CurrentUser
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val currentUserUC: CurrentUser, application: Application)
    : AndroidViewModel(application) {

    fun getCurrentUser(): UserInfo? {
        var userInfo: UserInfo?
        runBlocking {
            userInfo = currentUserUC.getInfo().result
        }
        return userInfo
    }
}