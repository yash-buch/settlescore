package com.binc.settlescore

import android.app.Application
import com.binc.settlescore.dagger.ApplicationComponent
import com.binc.settlescore.dagger.ApplicationModule
import com.binc.settlescore.dagger.DaggerApplicationComponent
import com.binc.settlescore.dagger.memberquerygraph.MemberQueryComponent
import com.google.firebase.FirebaseApp

class SSApplication : Application() {
    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    var memberQueryComponent: MemberQueryComponent? = null

    companion object {
        val DEBUG: Boolean = true
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }

    fun getAppComponent(): ApplicationComponent {
        return applicationComponent
    }

    //TODO: improve the name of the method
    fun beginMemberQuery(): MemberQueryComponent? {
        memberQueryComponent = memberQueryComponent ?: applicationComponent.getMemberQueryComponent()
        return memberQueryComponent
    }

    fun closeMemberQuery() {
        memberQueryComponent = null
    }

}