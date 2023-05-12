package com.example.farmserv

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.farmserv.databinding.LocationBinding
import kotlinx.android.synthetic.main.location.*
import kotlinx.android.synthetic.main.user_login.*


class Location : AppCompatActivity() {

    lateinit var binding : LocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= LocationBinding.inflate(layoutInflater)
        setContentView(R.layout.location)

        val str = tv_terms.text

        tv_terms.text

        val ss = SpannableString(str)
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                //do Anything you want
                Toast.makeText(this@Location, "Terms of Service", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                /*super.updateDrawState(ds)*/
                ds.isUnderlineText = false
            }
        }

        val clickableSpan2: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                //do Anything you want
                Toast.makeText(this@Location, "Privacy Policy", Toast.LENGTH_SHORT).show()
            }

            override fun updateDrawState(ds: TextPaint) {
                /*super.updateDrawState(ds)*/
                ds.isUnderlineText = false
            }
        }


        ss.setSpan(clickableSpan, 11, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(clickableSpan2, 30, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tv_terms.text = ss
        tv_terms.movementMethod = LinkMovementMethod.getInstance()
        tv_terms.highlightColor = Color.TRANSPARENT



        et_setLocation.setOnFocusChangeListener { view, change ->

            if (!change)
            {
                funValidateLocation()
            }

        }



        btn_setNow.setOnClickListener {
            setNowFun()
//            finish()
        }
        btn_notNow.setOnClickListener {
            val intent = Intent(this@Location, Home::class.java)

            startActivity(intent)
            finish()
        }


    }

    private fun setNowFun() {
        if (funValidateLocation())
        {
            val intent = Intent(this@Location, Home::class.java)
            /*val numberInput= et_mobileNumber.text.toString()
            intent.putExtra("numberInput",numberInput)*/
            startActivity(intent)
            finish()
        }
    }

    private fun funValidateLocation(): Boolean {
        if (et_setLocation.text.toString().isEmpty())
        {et_setLocation.setBackgroundResource(R.drawable.edit_text_red_background)
            validate_setLocation.isVisible = true
            validate_setLocation.text = "*Please enter your correct location"
            return false
        }

        else
        {et_setLocation.setBackgroundResource(R.drawable.edit_text_background)
            validate_setLocation.isVisible = false
            return true
        }
    }


}