package com.example.farmserv
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_protection.view.*
import kotlinx.android.synthetic.main.fragment_seeds.*
import kotlinx.android.synthetic.main.fragment_seeds.view.*
import kotlinx.android.synthetic.main.fragment_seeds.view.rb_gridView
import kotlinx.android.synthetic.main.fragment_seeds.view.rb_listView

class FragmentProtection : Fragment(),ProductViewClick {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var vProtection =inflater.inflate(R.layout.fragment_protection, container, false)


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

        val productProtection=ArrayList<ProductModel>()
        for (i in 2..10) {
            productProtection.add(ProductModel(product[4].img,product[4].name))
            productProtection.add(ProductModel(product[5].img,product[5].name))
        }

        vProtection.rv_protection.adapter = RecyclerProductAdapterListView(vProtection.context,productProtection,this)
        vProtection.rv_protection.layoutManager = LinearLayoutManager(vProtection.context)


        vProtection.rb_listView.setOnClickListener{
            onRadioButtonClicked(rb_listView)
            vProtection.rv_protection.adapter = RecyclerProductAdapterListView(vProtection.context,productProtection,this)
            vProtection.rv_protection.layoutManager = LinearLayoutManager(vProtection.context)
        }
//        val rb2: RadioButton =findViewById(R.id.rb_Partner)
        vProtection.rb_gridView.setOnClickListener {
            onRadioButtonClicked(rb_gridView)
            vProtection.rv_protection.adapter = RecyclerProductAdapter(vProtection.context,productProtection,this)
            vProtection.rv_protection.layoutManager = GridLayoutManager(vProtection.context,2)
        }

        return vProtection
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
