package com.example.farmserv
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_seeds.*
import kotlinx.android.synthetic.main.fragment_seeds.view.*

class FragmentSeeds : Fragment(),ProductViewClick {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var vSeeds =inflater.inflate(R.layout.fragment_seeds, container, false)


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

        val productSeeds=ArrayList<ProductModel>()
        for (i in 2..10) {
            productSeeds.add(ProductModel(product[2].img,product[2].name))
            productSeeds.add(ProductModel(product[3].img,product[3].name))
        }

        vSeeds.rv_seeds.adapter = RecyclerProductAdapterListView(vSeeds.context,productSeeds,this)
        vSeeds.rv_seeds.layoutManager = LinearLayoutManager(vSeeds.context)


        vSeeds.rb_listView.setOnClickListener{
            onRadioButtonClicked(rb_listView)
            vSeeds.rv_seeds.adapter = RecyclerProductAdapterListView(vSeeds.context,productSeeds,this)
            vSeeds.rv_seeds.layoutManager = LinearLayoutManager(vSeeds.context)
        }
//        val rb2: RadioButton =findViewById(R.id.rb_Partner)
        vSeeds.rb_gridView.setOnClickListener {
            onRadioButtonClicked(rb_gridView)
            vSeeds.rv_seeds.adapter = RecyclerProductAdapter(vSeeds.context,productSeeds,this)
            vSeeds.rv_seeds.layoutManager = GridLayoutManager(vSeeds.context,2)
        }

        val listAdapter =RecyclerProductAdapterListView(vSeeds.context,productSeeds,this)

        /*listAdapter.onItemClick= {
            Toast.makeText(vSeeds.context, "hii", Toast.LENGTH_SHORT).show()
            val intent = Intent( vSeeds.context, ProductDetails::class.java)
            intent.putExtra("","")
            startActivity(intent)
        }*/






//        var view1 = layoutInflater.inflate(R.layout.product_layout,null)



        return vSeeds
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

