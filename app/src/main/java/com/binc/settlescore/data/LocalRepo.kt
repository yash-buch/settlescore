package com.binc.settlescore.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.binc.settlescore.dagger.annotations.ApplicationContext
import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.domain.usecases.memberqueries.GetOwnerInfo
import com.binc.settlescore.domain.usecases.userloginsignup.SetOwnerInfo
import javax.inject.Inject

open class LocalRepo @Inject constructor(@ApplicationContext var mContext: Context): BaseRepo<OwnerInfo>(),
    GetOwnerInfo.Repository, SetOwnerInfo.Repository{

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
        return OwnerInfo("dummy", "0000000000", "dummy", "dummy")
    }

    override fun setOwnerInfo(ownerInfo: OwnerInfo) {
        val sp: SharedPreferences = mContext.getSharedPreferences(SP_NAME, MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sp.edit()
        editor.putString(KEY_NAME, ownerInfo.name)
        editor.putString(KEY_EMAIL, ownerInfo.email)
        editor.putString(KEY_PHNUM, ownerInfo.phoneNumber)
        editor.putString(KEY_UPI, ownerInfo.upi)
        editor.commit()
    }

    private companion object {
        const val SP_NAME = "owner_info"
        const val KEY_NAME = "name"
        const val KEY_EMAIL = "email"
        const val KEY_PHNUM = "phoneNumber"
        const val KEY_UPI = "upi"
    }
}