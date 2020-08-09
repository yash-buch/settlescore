package com.binc.settlescore.presentation.view

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binc.settlescore.R
import com.binc.settlescore.SSApplication
import com.binc.settlescore.dagger.memberquerygraph.MemberQueryComponent
import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.presentation.viewmodel.MainViewModel
import com.binc.settlescore.presentation.viewmodel.MainViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainViewModel.MainView, OwnerInfoFragment.SaveButtonListener {

    @Inject
    lateinit var mainViewModelProviderFactory: MainViewModelProviderFactory

    private val mainViewModel: MainViewModel by viewModels { mainViewModelProviderFactory }

    private val component: MemberQueryComponent? by lazy {
        (application as SSApplication).beginMemberQuery()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component?.inject(this)

        recycler_view.apply {
            adapter = mainViewModel.mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            val dividerDecor = DividerItemDecoration(this@MainActivity
                , RecyclerView.VERTICAL)
            addItemDecoration(dividerDecor)
        }

        mainViewModel.attachView(this@MainActivity)
        mainViewModel.onCreate()

        val seekBtn = findViewById<Button>(R.id.btn_seek)
        seekBtn.setOnClickListener { mainViewModel.onSeekBtnClicked() }
    }

    override fun showToast(msg: String) {
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showOwnerVerificationDialog() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container_view, component?.getOwnerInfoFragment() as Fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        (application as SSApplication).closeMemberQuery()
        mainViewModel.detachView()
    }

    override fun handleSaveButton(ownerInfo: OwnerInfo) {
        mainViewModel.saveOwnerInfo(ownerInfo)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.remove(component?.getOwnerInfoFragment() as Fragment)
        fragmentTransaction.commit()

    }

    override fun saveError() {
        Toast.makeText(this@MainActivity, "Unverifiable information", Toast.LENGTH_SHORT).show()
    }
}
