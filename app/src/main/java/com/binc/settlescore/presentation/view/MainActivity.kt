package com.binc.settlescore.presentation.view

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.binc.settlescore.R
import com.binc.settlescore.SSApplication
import com.binc.settlescore.dagger.memberquerygraph.MemberQueryComponent
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
        val component : MemberQueryComponent? = (application as SSApplication).beginMemberQuery()
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
        Toast.makeText(this@MainActivity, "show verification dialog", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        (application as SSApplication).closeMemberQuery()
    }
}
