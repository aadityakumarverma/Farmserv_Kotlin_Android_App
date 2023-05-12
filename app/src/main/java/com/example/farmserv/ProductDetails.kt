package com.example.farmserv

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.*
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.image_slider
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.home_flow.*
import kotlinx.android.synthetic.main.product_details.*
import kotlinx.android.synthetic.main.product_details.view.*
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.weight_popup.*
import kotlinx.android.synthetic.main.weight_popup.view.*


@Suppress("DEPRECATION")
class ProductDetails : AppCompatActivity() {

    lateinit var window2: PopupWindow

    var sliderList: ArrayList<SlideModel> = ArrayList()

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val view =layoutInflater.inflate(R.layout.weight_popup,null)
        window2 = PopupWindow(view, 360, 300)

        rating.stepSize=0.5f
        rating.rating=2.5f

        iv_backButtonLogin.setOnClickListener {
            finish()
        }

        rating.setOnRatingBarChangeListener(OnRatingBarChangeListener { ratingBar, rating, fromUser -> // TODO Auto-generated method stub
            Toast.makeText(applicationContext, java.lang.Float.toString(rating), Toast.LENGTH_LONG)
                .show()
        })


        val weight = arrayOf("1 Kg","2 Kg","3 Kg","4 Kg","5 Kg","6 Kg","7 Kg","8 Kg")



        val weightAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, weight)

        tv_weight.setOnClickListener {

            tv_weight.setBackgroundResource(R.drawable.weight_bg2)

            tv_weight.isClickable=false

            val view =layoutInflater.inflate(R.layout.weight_popup,null)
            window2 = PopupWindow(view, 360, 300)
//            window.dismiss()
            window2.contentView= view

            val lv_weight=view.findViewById<ListView>(R.id.lv_weight)
            lv_weight.adapter=weightAdapter


            lv_weight.setOnItemClickListener { parent, view, position, id ->
                tv_weight.text=weight[position]
                tv_weight.isClickable=true
                tv_weight.setBackgroundResource(R.drawable.weight_bg)
                window2.dismiss()

            }

            window2.showAsDropDown(tv_weight)

//            window.isFocusable=true
//            window.isOutsideTouchable= true
//            window.isTouchModal=true
        }

       // val weightArr =


        var count = 0

        tv_quantity.setText("" + count)

        tv_plus.setOnClickListener {
            if (count>-1){
            tv_quantity.setText("" + ++count)}
        }

        tv_minus.setOnClickListener {
            if (count>0){
            tv_quantity.setText("" + --count)}
        }



        /*cb_star2.isClickable=false
        cb_star3.isClickable=false
        cb_star4.isClickable=false
        cb_star5.isClickable=false*/


        sliderList.clear()

        sliderList.add(SlideModel(R.drawable.productimage1))
        sliderList.add(SlideModel(R.drawable.productimage1))
        sliderList.add(SlideModel(R.drawable.productimage1))
        sliderList.add(SlideModel(R.drawable.productimage1))
        sliderList.add(SlideModel(R.drawable.productimage1))
        sliderList.add(SlideModel(R.drawable.productimage1))


        image_slider.setImageList(sliderList, ScaleTypes.CENTER_INSIDE)

//        image_slider.getPagerIndicator().setVisibility(View.INVISIBLE);
        /*val adapter= ViewPagerAdapter()
        dotIndicator.attachTo(image_slider)*/

    }
    override fun onBackPressed() {
        if(window2.isShowing()) {
            tv_weight.isClickable=true
            tv_weight.setBackgroundResource(R.drawable.weight_bg)
            window2.dismiss();
            return;
        }
        super.onBackPressed();

    }
}