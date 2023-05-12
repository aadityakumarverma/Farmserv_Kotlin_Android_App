package com.example.farmserv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_others.view.*
import kotlinx.android.synthetic.main.fragment_seeds.*
import kotlinx.android.synthetic.main.fragment_seeds.view.*
import kotlinx.android.synthetic.main.fragment_seeds.view.rb_gridView
import kotlinx.android.synthetic.main.fragment_seeds.view.rb_listView


class FragmentOthers : Fragment(),ProductViewClick {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var vOthers =inflater.inflate(R.layout.fragment_others, container, false)


        val product = ArrayList<ProductModel>()

        product.add(ProductModel(R.drawable.productimage1,"NPK Fertilizer and related name will come"))
        product.add(ProductModel(R.drawable.productimage2,"Dr. Earth Final Stop Fungicide"))
        product.add(ProductModel(R.drawable.productimage3,"NPK Fertilizer and related name will come"))
        product.add(ProductModel(R.drawable.productimage4,"Dr. Earth Final Stop Fungicide"))
        product.add(ProductModel(R.drawable.productimage5,"NPK Fertilizer and related name will come"))
        product.add(ProductModel(R.drawable.productimage6,"Dr. Earth Final Stop Fungicide"))
        product.add(ProductModel(R.drawable.productimage7,"NPK Fertilizer and related name will come"))
        product.add(ProductModel(R.drawable.productimage8,"Dr. Earth Final Stop Fungicide"))
        product.add(ProductModel(R.drawable.productimage9,"NPK Fertilizer and related name will come"))
        product.add(ProductModel(R.drawable.productimage10,"Dr. Earth Final Stop Fungicide"))

//        val recyclerAdapter = RecyclerProductAdapter(activity,product)

        val productOthers=ArrayList<ProductModel>()
        for (i in 2..10) {
            productOthers.add(ProductModel(product[8].img,product[8].name))
            productOthers.add(ProductModel(product[9].img,product[9].name))
        }

        vOthers.rv_others.adapter = RecyclerProductAdapterListView(vOthers.context,productOthers,this)
        vOthers.rv_others.layoutManager = LinearLayoutManager(vOthers.context)


        vOthers.rb_listView.setOnClickListener{
            onRadioButtonClicked(rb_listView)
            vOthers.rv_others.adapter = RecyclerProductAdapterListView(vOthers.context,productOthers,this)
            vOthers.rv_others.layoutManager = LinearLayoutManager(vOthers.context)
        }
//        val rb2: RadioButton =findViewById(R.id.rb_Partner)
        vOthers.rb_gridView.setOnClickListener {
            onRadioButtonClicked(rb_gridView)
            vOthers.rv_others.adapter = RecyclerProductAdapter(vOthers.context,productOthers,this)
            vOthers.rv_others.layoutManager = GridLayoutManager(vOthers.context,2)
        }

        return vOthers
    }


    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rb_listView ->
                    if (checked) {
                        // Pirates are the best
                        rb_gridView.isChecked=false
                    }
                R.id.rb_gridView ->
                    if (checked) {
                        // Ninjas rule
                        rb_listView.isChecked=false
                    }
            }
        }
    }

    override fun viewProducts(name:String,type:String,price:Int)
 {
    }

}