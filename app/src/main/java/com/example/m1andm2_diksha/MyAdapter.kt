package com.example.m1andm2_diksha

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(
    var context: Context,
    var data: ArrayList<ModelClass>
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        // Define click listener for the ViewHolder's View.
        var text1 = view.findViewById<TextView>(R.id.text1)
        var text2 = view.findViewById<TextView>(R.id.text2)
        var textBtn = view.findViewById<TextView>(R.id.text_btn)
        var text_Location = view.findViewById<TextView>(R.id.text_location)
        var image=view.findViewById<ImageView>(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.singlegrid_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        var userData = data[position]

        holder.textBtn.text = userData.text_btn
        holder.text1.text = userData.text1
        holder.text2.text = userData.text2
        holder.text_Location.text = userData.text_location
        Glide.with(context).load(userData.image).into(holder.image);
    }

    override fun getItemCount(): Int {
        return data.size
    }
}