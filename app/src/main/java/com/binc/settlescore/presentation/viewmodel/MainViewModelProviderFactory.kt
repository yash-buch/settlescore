package com.binc.settlescore.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import com.binc.settlescore.domain.usecases.userloginsignup.SetOwnerInfo
import com.binc.settlescore.presentation.view.adapter.MainAdapter
import javax.inject.Inject

class MainViewModelProviderFactory @Inject constructor(var memberListUC: GetMemberList, var application: Application
                                                       , var ownerInfoUC: GetOwnerInfo, var mainAdapter: MainAdapter, var setOwnerInfoUC: SetOwnerInfo
)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(memberListUC, application, ownerInfoUC, mainAdapter, setOwnerInfoUC) as T
    }
}