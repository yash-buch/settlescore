package com.binc.settlescore.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.binc.settlescore.R
import com.binc.settlescore.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java) }
    var btn: Button? = null
    var tv1: TextView? = null
    var tv2: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById<Button>(R.id.button)
        tv1 = findViewById<TextView>(R.id.textView)
        tv2 = findViewById<TextView>(R.id.textView2)

        btn?.setOnClickListener {
            mainViewModel.onClick()
        }

        perform()
    }

    fun perform() {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                tv1?.text = mainViewModel.getTextView1()
                tv2?.text = mainViewModel.getTextView2()
                delay(1000)
            }
        }
    }
}
