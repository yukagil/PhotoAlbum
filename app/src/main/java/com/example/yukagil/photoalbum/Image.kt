package com.example.yukagil.photoalbum

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
        val format: String?,
        val width: Number?,
        val height: Number?,
        val filename: String?,
        val id: Number?,
        val author: String?,
        val author_url: String?,
        val post_url: String?
) : Parcelable