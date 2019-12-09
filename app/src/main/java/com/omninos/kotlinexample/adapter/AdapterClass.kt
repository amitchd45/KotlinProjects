package com.omninos.kotlinexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omninos.kotlinexample.R
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterClass(val items:ArrayList<String>,val context:Context,val listener:(Int)->Unit):
    RecyclerView.Adapter<AdapterClass.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv_animal_type.setText(items.get(position))
        holder.tv_animal_type.setOnClickListener {
            listener(position)
        }
    }

    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
         val tv_animal_type=view.tv_animal_type

    }

}