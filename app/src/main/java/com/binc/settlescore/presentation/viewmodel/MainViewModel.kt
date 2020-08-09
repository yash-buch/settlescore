package com.binc.settlescore.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import com.binc.settlescore.domain.usecases.userloginsignup.SetOwnerInfo
import com.binc.settlescore.presentation.model.MainModel
import com.binc.settlescore.presentation.model.OwnerInfoModel
import com.binc.settlescore.presentation.view.adapter.MainAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val memberListUC: GetMemberList, application: Application,
    private val getOwnerInfoUC: GetOwnerInfo, var mainAdapter: MainAdapter,
    private val setOwnerInfoUC: SetOwnerInfo
) : AndroidViewModel(application) {

    var view: MainView? = null

    private val EMPTY_SELECTION_MSG: String = "No items selected"
    private var mainModel: MainModel? = null
    private lateinit var ownerInfoModel: OwnerInfoModel

    fun attachView(v: MainView) {
        view = v
    }

    fun detachView() {
        view = null
    }

    fun onCreate() {
        if (mainModel == null)
            getUpdatedList()
    }

    fun onSeekBtnClicked() {
        //1. get selected items
        //2. make a list
        //3. send list to mainView or show toast
        view?.showToast(EMPTY_SELECTION_MSG)
        // if items selected confirm owner verification
        verifyOwnerInfoAndProceed()
    }

    fun saveOwnerInfo(ownerInfo: OwnerInfo) {
        viewModelScope.launch {
            setOwnerInfoUC.setOwnerInfo(ownerInfo)
        }
    }

    private fun verifyOwnerInfoAndProceed() {
        viewModelScope.launch {
            val result = getOwnerInfoUC.getOwnerInfo()
            ownerInfoModel = OwnerInfoModel(result.result)
            if (!ownerInfoModel.isOwnerVerified()) {
                view?.showOwnerVerificationDialog()
            } else {
                view?.showToast("Owner verification already done.")
            }
        }
    }

    private fun getUpdatedList() {
        viewModelScope.launch {
            val result = memberListUC.getMemberList()
            mainModel = MainModel(result.result)
            view?.updateList(mainModel?.userInfoList)
            mainAdapter.userItemList = mainModel?.userInfoItemList!!
        }
    }

    interface MainView {
        fun updateList(userList: ArrayList<UserInfo>?){}
        fun showToast(msg: String){}
        fun showOwnerVerificationDialog(){}
    }
}