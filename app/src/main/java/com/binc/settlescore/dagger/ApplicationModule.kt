package com.binc.settlescore.dagger

import android.app.Application
import com.binc.settlescore.domain.interactors.Logger
import com.binc.settlescore.infrastructure.AndroidLogger
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule constructor(var app: Application, private val logger: Logger = AndroidLogger()) {

    @Provides
    fun provideApp() : Application {
        return app;
    }

    @Provides
    fun provideAndroidLogger(): Logger {
        return logger
    }
}