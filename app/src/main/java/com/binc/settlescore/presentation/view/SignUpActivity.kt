package com.binc.settlescore.presentation.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.binc.settlescore.R
import com.binc.settlescore.SSApplication
import com.binc.settlescore.dagger.annotations.MainActivityIntent
import com.binc.settlescore.domain.interactors.OwnerInfo
import com.binc.settlescore.domain.usecases.userloginsignup.SetOwnerInfo
import com.binc.settlescore.domain.usecases.userloginsignup.SignupUser
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpActivity : AppCompatActivity(), OwnerInfoFragment.SaveButtonListener {

    @Inject
    lateinit var signUpUser: SignupUser
    @Inject
    lateinit var ownerInfoFragment: OwnerInfoFragment
    @Inject
    lateinit var setOwnerInfo: SetOwnerInfo
    @Inject @field:MainActivityIntent
    lateinit var mainActivityIntent: Intent



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val component = (application as SSApplication).getAppComponent()
            .getSignUpLoginComponent()
        component.inject(this)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container_view, ownerInfoFragment as Fragment)
        fragmentTransaction.commit()
    }

    override fun handleSaveButton(ownerInfo: OwnerInfo) {
        lifecycleScope.launch {
            if(signUpUser.signupUser(ownerInfo).result)
                setOwnerInfo.setOwnerInfo(ownerInfo)
            //TODO("handle else case")
            startActivity(mainActivityIntent)
            finish()
        }
    }

    override fun saveError() {
        Toast.makeText(this@SignUpActivity, "unexpected values", Toast.LENGTH_SHORT).show()
    }
}