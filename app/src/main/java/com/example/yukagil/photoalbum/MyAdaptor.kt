package com.example.yukagil.photoalbum

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdaptor : RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cell, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount() = 100

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemCell.text = position.toString()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemCell: TextView = view.findViewById(R.id.itemCell)
    }
}