package com.example.kietmart

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kietmart.data.Books
import com.google.android.material.imageview.ShapeableImageView

class MyyAdapter(var newsArrayList: ArrayList<Books>, var context: Activity) :
    RecyclerView.Adapter<MyyAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview= LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return ViewHolder(itemview)
        }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentitem=newsArrayList[position]
        holder.bookname.text=currentitem.bookname
        holder.imageid.setImageResource(currentitem.imageid)
    }



    override fun getItemCount(): Int {
        return newsArrayList.size

    }

    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        val bookname = itemview.findViewById<TextView>(R.id.productname)

        val imageid=itemview.findViewById<ShapeableImageView>(R.id.imageID)



    }
}