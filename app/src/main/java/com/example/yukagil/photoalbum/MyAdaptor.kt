package com.example.yukagil.photoalbum

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

class MyAdaptor : RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {

    private val imageUrls = arrayOf(
            "https://picsum.photos/600/400?image=500",
            "https://picsum.photos/600/400?image=501",
            "https://picsum.photos/600/400?image=502",
            "https://picsum.photos/600/400?image=503",
            "https://picsum.photos/600/400?image=504",
            "https://picsum.photos/600/400?image=505",
            "https://picsum.photos/600/400?image=506",
            "https://picsum.photos/600/400?image=507",
            "https://picsum.photos/600/400?image=508",
            "https://picsum.photos/600/400?image=509",
            "https://picsum.photos/600/400?image=510"
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cell, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount() = imageUrls.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.with(holder.itemCell.context)
                .load(imageUrls[position])
                .into(holder.itemCell)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemCell: ImageView = view.findViewById(R.id.itemCell)
    }
}