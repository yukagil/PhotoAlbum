package com.example.yukagil.photoalbum

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photo_viewer.*

class PhotoViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_viewer)

        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        val imageUrl = intent.getStringExtra("imageUrl")
        Picasso.with(this)
                .load(imageUrl)
                .into(imageView)
    }
}
