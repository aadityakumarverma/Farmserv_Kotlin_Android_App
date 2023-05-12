package com.example.farmserv

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.example.farmserv.databinding.RegistrationBinding
import com.example.farmserv.databinding.UserLoginBinding
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.user_login.*
import kotlinx.android.synthetic.main.user_login.validate_MobileNumber

class UserLogin : AppCompatActivity() {

    lateinit var binding: UserLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= UserLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.user_login)



        val maxMobileLength =10
        et_mobileNumber.filters= arrayOf<InputFilter>(InputFilter.LengthFilter(maxMobileLength))


        iv_backButtonLogin.setOnClickListener {
            finish()
        }

        et_mobileNumber.doOnTextChanged { text, start, before, count ->
            funValidateMobile()
        }

        /*et_mobileNumber.setOnFocusChangeListener { view, change ->

            if (!change)
            {
                funValidateMobile()
            }

        }*/



        btn_GetOTP.setOnClickListener {
            submit()
//            finish()
        }

        /*

        this.onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }
        })

        */


    }



    fun funValidateMobile() :Boolean {
        if (et_mobileNumber.text.toString().isEmpty())
        {et_mobileNumber.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_MobileNumber.isVisible = true
            validate_MobileNumber.text = "*Please enter valid phone number"
            return false
        }
        else if (et_mobileNumber.text.length<10)
        {et_mobileNumber.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_MobileNumber.isVisible = true
            validate_MobileNumber.text = "*Please enter 10 digit phone number"
            return false
        }
        else if (!et_mobileNumber.text.matches(".*[0-9].*".toRegex()))
        {et_mobileNumber.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_MobileNumber.isVisible = true
            validate_MobileNumber.text = "*Please enter valid phone number"
            return false
        }
        else
        {et_mobileNumber.setBackgroundResource(R.drawable.edit_text_background)
            validate_MobileNumber.isVisible = false
            return true
        }
    }

    fun submit()
    {
        if (funValidateMobile())
        {
            val intent = Intent(this@UserLogin, OTP_Verification::class.java)
            val numberInput= et_mobileNumber.text.toString()
            intent.putExtra("numberInput",numberInput)
            startActivity(intent)
        }
    }




}



