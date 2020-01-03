package com.binc.settlescore.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binc.settlescore.dagger.memberquerygraph.DaggerMemberQueryComponent
import com.binc.settlescore.dagger.memberquerygraph.MemberQueryComponent
import com.binc.settlescore.domain.usecases.memberqueries.GetMemberList
import com.binc.settlescore.presentation.model.MainModel
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var text1: String = "text1"
    var text2: String = "text2"
    var index1: Int = 0
    var index2: Int = 0
    var memberQueryComponent: MemberQueryComponent = DaggerMemberQueryComponent.create()
    var useCase: GetMemberList = memberQueryComponent.getMemberListUseCase()

    fun onClick() {
        viewModelScope.launch {
            Log.d("check","${Thread.currentThread().name}")
            var result = useCase.getMemberList()
            var mainModel = MainModel(result.result)
            var list = when(index1%2) {
                0 -> mainModel.getUserNames()
                1 -> mainModel.getUserPhoneNumbers()
                else -> null
            }
            text1 = list!!.get(0)
            text2 = list!!.get(1)


        }
        Log.d("check","coroutine complete")
    }

    fun getTextView1(): String {
        return text1+index1++
    }

    fun getTextView2(): String {
        return text2+index2++
    }
}