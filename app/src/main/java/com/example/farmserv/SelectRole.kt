package com.example.farmserv

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.select_role.*

class SelectRole : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_role)
        btn_GetIn.setOnClickListener {
            val intent= Intent(this@SelectRole,Registration::class.java)
            startActivity(intent)
//            finish()
        }


        val rb1:RadioButton=findViewById(R.id.rb_Farmer)
        rb_Farmer.setOnClickListener{
            onRadioButtonClicked(rb1)
        }
        val rb2:RadioButton=findViewById(R.id.rb_Partner)
        rb_Partner.setOnClickListener {
            onRadioButtonClicked(rb2)
        }

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rb_Farmer ->
                    if (checked) {
                        // Pirates are the best
                        rb_Partner.isChecked=false
                    }
                R.id.rb_Partner ->
                    if (checked) {
                        // Ninjas rule
                        rb_Farmer.isChecked=false
                    }
            }
        }
    }


}