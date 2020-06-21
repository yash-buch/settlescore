package com.binc.settlescore.presentation

import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.binc.settlescore.presentation.view.MainActivity
import com.binc.settlescore.presentation.view.SplashActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SplashActivityTest {

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun test_createActivity() {
        ActivityScenario.launch(SplashActivity::class.java)
        GlobalScope.launch {
            delay(4000)
            Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java.name))
        }
    }
}