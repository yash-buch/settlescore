package com.binc.settlescore.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.binc.settlescore.R
import com.binc.settlescore.SSApplication
import com.binc.settlescore.dagger.startupgraph.SplashComponent
import com.binc.settlescore.domain.interactors.Logger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Simple Splash screen
 */
class SplashActivity : AppCompatActivity() {

    @Inject lateinit var nextIntent: Intent
    @Inject lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.hide()
        val component: SplashComponent = (application as SSApplication).getAppComponent()
            .getSplashComponent()
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

    override fun onDestroy() {
        super.onDestroy()
        logger.log("SplashActivity", "activity finished")
    }
}
