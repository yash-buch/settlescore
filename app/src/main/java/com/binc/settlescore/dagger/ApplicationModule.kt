package com.binc.settlescore.dagger

import android.app.Application
import android.content.Context
import com.binc.settlescore.domain.interactors.Logger
import com.binc.settlescore.infrastructure.AndroidLogger
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule constructor(var app: Application, private val logger: Logger = AndroidLogger()) {

    @Provides
    fun provideApp() : Application = app

    @Provides
    fun provideAndroidLogger(): Logger = logger

    @Provides
    @ApplicationContext
    fun provideApplicationContext(): Context = app.applicationContext
}