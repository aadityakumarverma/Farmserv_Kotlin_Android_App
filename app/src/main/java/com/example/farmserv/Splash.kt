package com.example.farmserv

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.splash.*
import kotlinx.android.synthetic.main.splash.btn_GetStarted
import kotlinx.android.synthetic.main.user_login.*

class Splash : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        farm_serv_logo.setOnClickListener {
            val intent = Intent(this@Splash,SetLanguage::class.java)
            startActivity(intent)
        }


        btn_GetStarted.setOnClickListener {
            val intent = Intent(this@Splash,UserLogin::class.java)
            startActivity(intent)
        }



    }
}