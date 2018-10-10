package com.example.yukagil.photoalbum

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        fab.setOnClickListener {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://picsum.photos/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val service = retrofit.create(PicsumService::class.java)
            val call = service.getImages()
            call.enqueue(object : Callback<List<Image>> {
                override fun onFailure(call: Call<List<Image>>, t: Throwable) {
                }

                override fun onResponse(call: Call<List<Image>>, response: Response<List<Image>>) {
                    if (response.isSuccessful) {
                        val list = response.body()
                        list?.apply {
                            recyclerView.adapter = MyAdaptor(this)
                        }

                    } else {
                        // Error Message here
                    }
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
