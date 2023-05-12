package com.example.farmserv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmserv.R.layout.brand_layout
import kotlinx.android.synthetic.main.brand_layout.view.*


class RecyclerBrandAdapter(val context: Context, val arrBrand: ArrayList<ProductModel>) : RecyclerView.Adapter<RecyclerBrandAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBrand = itemView.iv_brand
        val txtBrandName = itemView.tv_brand_name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(brand_layout, parent, false))
    }


    override fun getItemCount(): Int {
        return arrBrand.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgBrand.setImageResource(arrBrand[position].img)
        holder.txtBrandName.text = arrBrand[position].name
    }

}