package com.example.yukagil.photoalbum

import retrofit2.Call
import retrofit2.http.GET

interface PicsumService {
    @GET("list")
    fun getImages(): Call<List<Image>>
}