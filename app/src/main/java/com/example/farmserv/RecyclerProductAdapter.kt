package com.example.farmserv

import java.util.ArrayList
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_layout.view.*

class RecyclerProductAdapter(val context: Context, val arrProduct: ArrayList<ProductModel>,val click:ProductViewClick) : RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder>(){

    /*var onItemClick : ((ProductModel) -> Unit)? = null*/

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduct = itemView.iv_product
        val txtProductName = itemView.tv_product_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return arrProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrProduct[position].apply {
            holder.imgProduct.setImageResource(img)
            holder.txtProductName.text = name
        }


        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,ProductDetails::class.java))
//            click.viewProducts("Aditya","View",1000)
        }
    }


}