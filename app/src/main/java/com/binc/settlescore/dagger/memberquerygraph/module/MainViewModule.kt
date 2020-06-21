package com.binc.settlescore.dagger.memberquerygraph.module

import com.binc.settlescore.presentation.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainViewModule constructor(var mainView : MainViewModel.MainView){
    @Provides
    fun provideMainViewModelView() : MainViewModel.MainView {
        return mainView
    }
}