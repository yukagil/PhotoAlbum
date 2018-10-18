package com.example.yukagil.photoalbum

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cell.view.*

class MyAdaptor(val list: List<Image> = emptyList()) : RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cell, parent, false)
        val holder = MyViewHolder(view)

        view.itemImage.setOnClickListener {
            Intent(parent.context, PhotoViewer::class.java).apply {
                putExtra("imageObject", list[holder.adapterPosition])
                parent.context.startActivity(this)
            }
        }

        return holder
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.with(holder.itemImage.context)
                .load("https://picsum.photos/600/400?image=${list[holder.adapterPosition].id}")
                .into(holder.itemImage)

        holder.textView.text = position.toString()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.itemText)
        val itemImage: ImageView = view.findViewById(R.id.itemImage)
    }
}