package com.binc.settlescore.dagger.memberquerygraph.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class ApplicationModule constructor(var app: Application) {

    @Provides
    fun provideApp() : Application {
        return app;
    }
}