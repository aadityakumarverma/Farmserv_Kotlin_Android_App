package com.example.farmserv

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*

class LanguageListAdapter(private val context: Activity, private val title: Array<String>, private val imgid: Array<Int>)
    : ArrayAdapter<String>(context, R.layout.language_list_layout, title) {


    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val view = inflater.inflate(R.layout.language_list_layout, null, true)

        val titleText :TextView = view.findViewById(R.id.tv_languageName)
        val imageView : ImageView = view.findViewById(R.id.iv_languageSymbol)

        titleText.text = title[position]
        imageView.setImageResource(imgid[position])

        return view
    }
}