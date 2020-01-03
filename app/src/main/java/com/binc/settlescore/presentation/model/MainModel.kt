package com.binc.settlescore.presentation.model

import com.binc.settlescore.domain.interactors.UserInfo
import javax.inject.Inject

class MainModel @Inject constructor(userInfoList: List<UserInfo>) {
    var userInfoList = userInfoList

    fun getUserNames(): List<String> {
        var names = ArrayList<String>()
        userInfoList.forEach { names.add(it.name) }
        return names
    }

    fun getUserPhoneNumbers(): List<String> {
        var phoneNumbers = ArrayList<String>()
        userInfoList.forEach { phoneNumbers.add(it.phoneNumber) }
        return phoneNumbers
    }

    fun getUserUPIs(): List<String> {
        var upis = ArrayList<String>()
        userInfoList.forEach { upis.add(it.upi) }
        return upis
    }
}