package com.example.farmserv

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.product_details.*
import kotlinx.android.synthetic.main.product_layout.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(),ProductViewClick{

    var sliderList: ArrayList<SlideModel> = ArrayList()


    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v =inflater.inflate(R.layout.fragment_home, container, false)
        val productView = inflater.inflate(R.layout.product_layout, container,false)


        var count = 0

        productView.tv_quantity.setText("" + count)

        productView.tv_plus.setOnClickListener {
            if (count>-1){
                tv_quantity.setText("" + ++count)}
        }

        productView.tv_minus.setOnClickListener {
            if (count>0){
                tv_quantity.setText("" + --count)}
        }





        v.iv_topDealsArrow.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            startActivity(intent)
        }
        v.iv_seedsArrow.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            intent.putExtra("homeToCategory","seedToCategory")
            startActivity(intent)
        }
        v.iv_protectionArrow.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            intent.putExtra("homeToCategory","protectionToCategory")
            startActivity(intent)
        }
        v.iv_nutritionArrow.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            intent.putExtra("homeToCategory","nutritionToCategory")
            startActivity(intent)
        }
        v.iv_othersArrow.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            intent.putExtra("homeToCategory","otherToCategory")
            startActivity(intent)
        }


        v.iv_seeds.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            intent.putExtra("homeToCategory","seedToCategory")
            startActivity(intent)
        }
        v.iv_protection.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            intent.putExtra("homeToCategory","protectionToCategory")
            startActivity(intent)
        }
        v.iv_nutrition.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            intent.putExtra("homeToCategory","nutritionToCategory")
            startActivity(intent)
        }
        v.iv_others.setOnClickListener {
            val intent = Intent( v.context, Categories::class.java)
            intent.putExtra("homeToCategory","otherToCategory")
            startActivity(intent)
        }

        sliderList.clear()

        sliderList.add(SlideModel(R.drawable.main_banner1))
        sliderList.add(SlideModel(R.drawable.main_banner2))
        sliderList.add(SlideModel(R.drawable.main_banner3))
        sliderList.add(SlideModel(R.drawable.main_banner4))
        sliderList.add(SlideModel(R.drawable.main_banner5))
        sliderList.add(SlideModel(R.drawable.main_banner6))


        v.image_slider.setImageList(sliderList, ScaleTypes.CENTER_CROP)


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

        v.rv_topDeals.adapter = RecyclerProductAdapter(v.context,product,this)
        v.rv_topDeals.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL,false)

        val productSeeds=ArrayList<ProductModel>()
        for (i in 1..10) {
            productSeeds.add(ProductModel(product[2].img,product[2].name))
            productSeeds.add(ProductModel(product[3].img,product[3].name))
        }

        val recyclerAdapterSeeds = RecyclerProductAdapter(v.context,productSeeds,this)
        v.rv_seeds.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL,false)
        v.rv_seeds.adapter = recyclerAdapterSeeds

        val productProtection=ArrayList<ProductModel>()
        for (i in 1..10) {
            productProtection.add(ProductModel(product[4].img,product[4].name))
            productProtection.add(ProductModel(product[5].img,product[5].name))
        }

        val recyclerAdapterProtection = RecyclerProductAdapter(v.context,productProtection,this)
        v.rv_protection.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL,false)
        v.rv_protection.adapter = recyclerAdapterProtection


        val productNutrition=ArrayList<ProductModel>()
        for (i in 1..10) {
            productNutrition.add(ProductModel(product[6].img,product[6].name))
            productNutrition.add(ProductModel(product[7].img,product[7].name))
        }

        val recyclerAdapterNutrition = RecyclerProductAdapter(v.context,productNutrition,this)
        v.rv_nutrition.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL,false)
        v.rv_nutrition.adapter = recyclerAdapterNutrition

        val productOther=ArrayList<ProductModel>()
        for (i in 1..10) {
            productOther.add(ProductModel(product[8].img,product[8].name))
            productOther.add(ProductModel(product[9].img,product[9].name))
        }

        val recyclerAdapterOther = RecyclerProductAdapter(v.context,productOther,this)
        v.rv_other.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL,false)
        v.rv_other.adapter = recyclerAdapterOther


        val brands = ArrayList<ProductModel>()



        brands.add(ProductModel(R.drawable.brands1," "))
        brands.add(ProductModel(R.drawable.brands3," "))
        brands.add(ProductModel(R.drawable.brands5," "))
        brands.add(ProductModel(R.drawable.brands1," "))
        brands.add(ProductModel(R.drawable.brands3," "))
        brands.add(ProductModel(R.drawable.brands5," "))
        brands.add(ProductModel(R.drawable.brands1," "))
        brands.add(ProductModel(R.drawable.brands3," "))
        brands.add(ProductModel(R.drawable.brands5," "))

        val recyclerBrandAdapter = RecyclerBrandAdapter(v.context,brands)

        v.rv_services.layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.HORIZONTAL,false)
        v.rv_services.adapter = recyclerBrandAdapter

        return v
    }


    override fun viewProducts(name: String, type: String, price: Int) {
//        Toast.makeText(requireContext(), "$name $type $price", Toast.LENGTH_SHORT).show()
    }




}
