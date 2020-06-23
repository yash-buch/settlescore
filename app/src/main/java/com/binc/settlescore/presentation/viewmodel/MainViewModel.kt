package com.binc.settlescore.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.presentation.model.MainModel
import com.binc.settlescore.presentation.view.adapter.MainAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val memberListUC: GetMemberList, val view: MainView, application: Application,
    var mainAdapter: MainAdapter) : AndroidViewModel(application) {

    private val EMPTY_SELECTION_MSG: String = "No items selected"
    private var mainModel: MainModel? = null

    fun onCreate() {
        if (mainModel == null)
            getUpdatedList()
    }

    fun onSeekBtnClicked() {
        //1. get selected items
        //2. make a list
        //3. send list to mainView or show toast
        view.showToast(EMPTY_SELECTION_MSG)
    }

    private fun getUpdatedList() {
        viewModelScope.launch {
            val result = memberListUC.getMemberList()
            mainModel = MainModel(result.result)
            view.updateList(mainModel?.userInfoList)
            mainAdapter.userItemList = mainModel?.userInfoItemList!!
        }
    }

    interface MainView {
        fun updateList(userList: ArrayList<UserInfo>?){}
        fun showToast(msg: String){}
    }
}