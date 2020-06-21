package com.binc.settlescore.presentation.model

import com.binc.settlescore.domain.interactors.UserInfo
import javax.inject.Inject

class MainModel @Inject constructor(var userInfoList: ArrayList<UserInfo>) {
    var userInfoItemList: ArrayList<UserInfoItem> = ArrayList()

    init {
        userInfoList.forEach { userInfoItemList.add(UserInfoItem(it, false)) }
    }

    fun getUserNames(): List<String> {
        val names = ArrayList<String>()
        userInfoList.forEach { names.add(it.name) }
        return names
    }

    fun getUserPhoneNumbers(): List<String> {
        val phoneNumbers = ArrayList<String>()
        userInfoList.forEach { phoneNumbers.add(it.phoneNumber) }
        return phoneNumbers
    }

    fun getUserUPIs(): List<String> {
        val upis = ArrayList<String>()
        userInfoList.forEach { upis.add(it.upi) }
        return upis
    }
}