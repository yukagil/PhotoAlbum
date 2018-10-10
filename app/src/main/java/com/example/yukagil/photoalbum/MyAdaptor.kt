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
        val holder = MyViewHolder(view)

        view.itemImage.setOnClickListener{ v ->
            val intent = Intent(parent.context, PhotoViewer::class.java)
            intent.putExtra("imageUrl", imageUrls[holder.adapterPosition])
            v.context.startActivity(intent)

        }

        return holder
    }

    override fun getItemCount() = imageUrls.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.with(holder.itemImage.context)
                .load(imageUrls[position])
                .into(holder.itemImage)

        holder.textView.text = position.toString()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.itemText)
        val itemImage: ImageView = view.findViewById(R.id.itemImage)
    }
}