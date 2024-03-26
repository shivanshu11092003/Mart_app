package com.example.kietmart

import Product
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(var productdata: List<Product>, val context: Activity) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    fun setFilteredList(product:List<Product>){
        this.productdata = product
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview= LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return ViewHolder(itemview)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem=productdata[position]
        holder.bookname.text=currentitem.title
        Picasso.get().load(currentitem.thumbnail).into(holder.imageid)

    }

    override fun getItemCount(): Int {
        return productdata.size

    }

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val bookname = itemview.findViewById<TextView>(R.id.productname)
        val imageid=itemview.findViewById<ShapeableImageView>(R.id.imageID)

    }

}