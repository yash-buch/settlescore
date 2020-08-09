package com.binc.settlescore.dagger.module

import android.content.ComponentName
import android.content.Intent
import com.binc.settlescore.dagger.annotations.MainActivityIntent
import com.binc.settlescore.dagger.annotations.SignUpActivityIntent
import dagger.Module
import dagger.Provides

@Module
class IntentModule {

    @MainActivityIntent
    @Provides
    fun provideMainActivityIntent(): Intent {
        val intent = Intent()
        intent.component = ComponentName("com.binc.settlescore",
            "com.binc.settlescore.presentation.view.MainActivity")
        return intent
    }


    @Provides
    @SignUpActivityIntent
    fun provideSignUpActivityIntent(): Intent {
        val intent = Intent()
        intent.component = ComponentName("com.binc.settlescore",
            "com.binc.settlescore.presentation.view.SignUpActivity")
        return intent
    }
}