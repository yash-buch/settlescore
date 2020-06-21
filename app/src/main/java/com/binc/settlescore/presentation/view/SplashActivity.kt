package com.binc.settlescore.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.binc.settlescore.R
import com.binc.settlescore.dagger.startupgraph.DaggerSplashComponent
import com.binc.settlescore.dagger.startupgraph.SplashComponent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Simple Splash screen
 */
class SplashActivity : AppCompatActivity() {

    @Inject lateinit var nextIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.hide()
        var component: SplashComponent = DaggerSplashComponent.create()
        component.inject(this)
        startNextActivityWithDelay()
    }

    private fun startNextActivityWithDelay() {
        GlobalScope.launch {
            delay(300)
            if(!isDestroyed) startActivity(nextIntent)
            finish()
        }
    }
}
