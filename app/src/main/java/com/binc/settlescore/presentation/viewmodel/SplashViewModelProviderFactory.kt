package com.binc.settlescore.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.binc.settlescore.domain.usecases.userloginsignup.CurrentUser
import javax.inject.Inject

class SplashViewModelProviderFactory @Inject constructor(var currentUser: CurrentUser, var application: Application)
    : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(currentUser, application) as T
    }
}