package com.binc.settlescore.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.binc.settlescore.R
import com.binc.settlescore.SSApplication
import com.binc.settlescore.dagger.annotations.MainActivityIntent
import com.binc.settlescore.dagger.annotations.SignUpActivityIntent
import com.binc.settlescore.dagger.startupgraph.SplashComponent
import com.binc.settlescore.domain.interactors.Logger
import com.binc.settlescore.presentation.viewmodel.SplashViewModel
import com.binc.settlescore.presentation.viewmodel.SplashViewModelProviderFactory
import javax.inject.Inject

/**
 * Simple Splash screen
 */
class SplashActivity : AppCompatActivity() {

    @Inject @field:MainActivityIntent lateinit var mainActivityIntent: Intent
    @Inject @field:SignUpActivityIntent lateinit var signUpActivityIntent: Intent
    @Inject lateinit var logger: Logger
    @Inject
    lateinit var splashViewModelProviderFactory: SplashViewModelProviderFactory
    private val splashViewModel: SplashViewModel by viewModels { splashViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.hide()
        val component: SplashComponent = (application as SSApplication).getAppComponent()
            .getSplashComponent()
        component.inject(this)
        validateUserAndBegin()
    }

    private fun validateUserAndBegin() {
        when(splashViewModel.getCurrentUser()) {
            null -> startSignUpFormActivity()
            else -> startMainActivity()
        }
        finish()
    }

    private fun startSignUpFormActivity() = this@SplashActivity.startActivity(signUpActivityIntent)

    private fun startMainActivity() = this@SplashActivity.startActivity(mainActivityIntent)

    override fun onDestroy() {
        super.onDestroy()
        logger.log("SplashActivity", "activity finished")
    }
}
