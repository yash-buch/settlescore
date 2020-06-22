package com.binc.settlescore.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binc.settlescore.R
import com.binc.settlescore.dagger.memberquerygraph.DaggerMemberQueryComponent
import com.binc.settlescore.dagger.memberquerygraph.MemberQueryComponent
import com.binc.settlescore.dagger.memberquerygraph.module.ApplicationModule
import com.binc.settlescore.dagger.memberquerygraph.module.MainViewModule
import com.binc.settlescore.presentation.viewmodel.MainViewModel
import com.binc.settlescore.presentation.viewmodel.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainViewModel.MainView {
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private val mainViewModel: MainViewModel by viewModels { viewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val component : MemberQueryComponent = DaggerMemberQueryComponent.builder()
            .mainViewModule(MainViewModule(this))
            .applicationModule(ApplicationModule(this.application))
            .build()
        component.inject(this)

        recycler_view.apply {
            adapter = mainViewModel.mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            var dividerDecor: DividerItemDecoration = DividerItemDecoration(this@MainActivity
                , RecyclerView.VERTICAL)
            addItemDecoration(dividerDecor)
        }

        mainViewModel.onCreate()
    }
}
