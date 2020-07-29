package com.binc.settlescore.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.binc.settlescore.dagger.ApplicationContext
import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.domain.interactors.UserInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import javax.inject.Inject

class LocalRepo @Inject constructor(@ApplicationContext var mContext: Context): BaseRepo<OwnerInfo>(),
    GetOwnerInfo.Repository{

    private lateinit var name: String
    private lateinit var phoneNumber: String
    private lateinit var upi: String
    private lateinit var email: String

    override fun getOwnerInfo(): OwnerInfo {
        return when(isOwnerInfoAvailable()) {
            true -> buildOwnerInfo()
            false -> buildEmptyOwnerInfo()
        }
    }

    private fun isOwnerInfoAvailable(): Boolean {
        val sp: SharedPreferences = mContext.getSharedPreferences(SP_NAME, MODE_PRIVATE)
        name = sp.getString(KEY_NAME, "").toString()
        phoneNumber = sp.getString(KEY_PHNUM, "").toString()
        upi = sp.getString(KEY_UPI, "").toString()
        email = sp.getString(KEY_EMAIL, "").toString()
        return name != "" &&
                phoneNumber != "" &&
                upi != "" &&
                email != ""
    }

    private fun buildOwnerInfo(): OwnerInfo {
        return OwnerInfo(name, phoneNumber, upi, email)
    }

    private fun buildEmptyOwnerInfo(): OwnerInfo {
        return OwnerInfo("name", "phone number", "upi", "email")
    }

    private companion object {
        const val SP_NAME = "owner_info"
        const val KEY_NAME = "name"
        const val KEY_EMAIL = "email"
        const val KEY_PHNUM = "phoneNumber"
        const val KEY_UPI = "upi"
    }
}