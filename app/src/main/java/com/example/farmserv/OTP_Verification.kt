package com.example.farmserv

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.otp_verification.*
import kotlinx.android.synthetic.main.otp_verification.tv_mobileNumber
import kotlinx.android.synthetic.main.user_login.*

class OTP_Verification : AppCompatActivity() {
    private val CHANNEL_ID= "cahnnel_id_example_01"
    private val notificationId= 101
    var OTP="9999"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.otp_verification)

//        var newOTP: OTP_Verification= OTP_Verification()  //tv_wrongOTP


        tv_mobileNumber.text=intent.getStringExtra("numberInput")

        /*validate_MobileNumber.isVisible = true
        validate_MobileNumber.text = "*Please enter valid phone number"*/


        resendOTP()

        tv_resendOTP.setOnClickListener {
            tv_resendOTP.isVisible=false
            Toast.makeText(this, "OTP has been resent", Toast.LENGTH_SHORT).show()
            resendOTP()
        }
        
        iv_crossButton.setOnClickListener {
            finish()
        }


        et_1.addTextChangedListener(GenericTextWatcher(et_1, et_2))
        et_2.addTextChangedListener(GenericTextWatcher(et_2, et_3))
        et_3.addTextChangedListener(GenericTextWatcher(et_3, et_4))
        et_4.addTextChangedListener(GenericTextWatcher(et_4, null))



        et_1.setOnKeyListener(GenericKeyEvent(et_1, null))
        et_2.setOnKeyListener(GenericKeyEvent(et_2, et_1))
        et_3.setOnKeyListener(GenericKeyEvent(et_3, et_2))
        et_4.setOnKeyListener(GenericKeyEvent(et_4, et_3))



        et_1.doOnTextChanged { text, start, before, count ->
            if (et_1.text.isEmpty())
            { et_1.setBackground(getResources().getDrawable(R.drawable.otp_red_box)) }
            else
            { et_1.setBackground(getResources().getDrawable(R.drawable.otp_edittext_background))}
            tv_wrongOTP.isVisible=false
        }
        et_2.doOnTextChanged { text, start, before, count ->
                if (et_2.text.isEmpty())
                { et_2.setBackground(getResources().getDrawable(R.drawable.otp_red_box)) }
                else
                { et_2.setBackground(getResources().getDrawable(R.drawable.otp_edittext_background))}
                tv_wrongOTP.isVisible=false

        }
        et_3.doOnTextChanged { text, start, before, count ->
                if (et_3.text.isEmpty())
                { et_3.setBackground(getResources().getDrawable(R.drawable.otp_red_box)) }
                else
                { et_3.setBackground(getResources().getDrawable(R.drawable.otp_edittext_background))}
                tv_wrongOTP.isVisible=false

        }
        et_4.doOnTextChanged { text, start, before, count ->
                if (et_4.text.isEmpty())
                { et_4.setBackground(getResources().getDrawable(R.drawable.otp_red_box)) }
                else
                { et_4.setBackground(getResources().getDrawable(R.drawable.otp_edittext_background))}
                tv_wrongOTP.isVisible=false

        }

        btn_otpSubmit.setOnClickListener {
            val getOTP=et_1.text.toString()+et_2.text.toString()+et_3.text.toString()+et_4.text.toString()
            /*if (et_1.text.isEmpty())
            {
                et_1.setBackground(getResources().getDrawable(R.drawable.otp_red_box))

            }
           if (et_2.text.isEmpty())
            {
                et_2.setBackground(getResources().getDrawable(R.drawable.otp_red_box))
            }
             if (et_3.text.isEmpty())
            {
                et_3.setBackground(getResources().getDrawable(R.drawable.otp_red_box))
            }
             if (et_4.text.isEmpty())
            {
                et_4.setBackground(getResources().getDrawable(R.drawable.otp_red_box))
            }*/
            if(OTP!=getOTP)
            {   et_1.setBackground(getResources().getDrawable(R.drawable.otp_red_box))
                et_2.setBackground(getResources().getDrawable(R.drawable.otp_red_box))
                et_3.setBackground(getResources().getDrawable(R.drawable.otp_red_box))
                et_4.setBackground(getResources().getDrawable(R.drawable.otp_red_box))
                tv_wrongOTP.isVisible=true
                Toast.makeText(this, "Incorrect OTP", Toast.LENGTH_SHORT).show()

            }
            if(!et_1.text.isEmpty()&&!et_2.text.isEmpty()&&!et_3.text.isEmpty()&&!et_4.text.isEmpty()&&OTP==getOTP)
            {   et_1.setBackground(getResources().getDrawable(R.drawable.otp_edittext_background))
                et_2.setBackground(getResources().getDrawable(R.drawable.otp_edittext_background))
                et_3.setBackground(getResources().getDrawable(R.drawable.otp_edittext_background))
                et_4.setBackground(getResources().getDrawable(R.drawable.otp_edittext_background))
                tv_wrongOTP.isVisible=false
                val intent= Intent(this@OTP_Verification,SelectRole::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {

            val name ="OTP"
            val descriptionText=OTP
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID,name,importance).apply {
                description=OTP
            }
            val notificationManager : NotificationManager= getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @SuppressLint("MissingPermission")
    private fun sendNotification()
    {
        val builder =NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.icon_farm)
            .setContentTitle("OTP")
            .setContentText("Your current OTP is: "+OTP)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)){
            notify(notificationId, builder.build())
        }
    }


    fun resendOTP()
    {
        OTP=generateOTP()
        sendNotification()

        Toast.makeText(this, OTP, Toast.LENGTH_SHORT).show()
        object : CountDownTimer(11000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {

                tv_timer.setText("00:"+"%02d".format(millisUntilFinished / 1000) )
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                tv_timer.setText("00:00")
                tv_resendOTP.isVisible=true
            }
        }.start()
    }

    fun generateOTP() :String
    {
        val randomPin = (Math.random()*9000).toInt()+1000

        return randomPin.toString()
    }
}