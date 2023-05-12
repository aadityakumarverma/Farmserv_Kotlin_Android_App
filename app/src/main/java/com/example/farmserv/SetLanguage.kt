package com.example.farmserv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.farmserv.databinding.SetLanguageBinding

class SetLanguage : AppCompatActivity() {
    lateinit var binding : SetLanguageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =SetLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var arrLanguage= arrayOf("English", "हिंदी","मराठी","বাংলা","தமிழ்","తెలుగు","ಕನ್ನಡ")
        val arrImageId = arrayOf<Int>(
            R.drawable.cb_lang_bg,R.drawable.cb_lang_bg,R.drawable.cb_lang_bg,
            R.drawable.cb_lang_bg,R.drawable.cb_lang_bg,
            R.drawable.cb_lang_bg,R.drawable.cb_lang_bg)

        val myListAdapter = LanguageListAdapter(this,arrLanguage,arrImageId)
        binding.lvAllLanguages.adapter = myListAdapter

    }
}