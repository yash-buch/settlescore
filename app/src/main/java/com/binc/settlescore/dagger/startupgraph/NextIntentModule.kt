package com.binc.settlescore.dagger.startupgraph

import android.content.ComponentName
import android.content.Intent
import dagger.Module
import dagger.Provides

@Module
class NextIntentModule {
    @Provides
    fun provideNextIntent(): Intent {
        var nextIntent = Intent()
        nextIntent.setComponent(ComponentName("com.binc.settlescore",
            "com.binc.settlescore.presentation.view.MainActivity"))
        return nextIntent
    }
}