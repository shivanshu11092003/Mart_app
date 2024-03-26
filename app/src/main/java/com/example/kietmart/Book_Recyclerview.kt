package com.example.kietmart


import Data
import Product
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window

import android.view.WindowManager
import android.widget.Toast


import androidx.appcompat.widget.SearchView


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale


class Book_Recyclerview : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    lateinit var searchView : SearchView
    private var productList = ArrayList<Product>()
    private lateinit var  myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_recyclerview)
        changeStatusBarColor("#0074D9")

        //recycler_view

        recyclerview = findViewById(R.id.recyclerid)

        recyclerview.layoutManager = LinearLayoutManager(this@Book_Recyclerview)
        //Search View
        searchView=findViewById<SearchView>(R.id.Search_view)
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filtertext(newText)
                return true
            }

        })

        getapiData()
    }
    private fun getapiData(){
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apiinterface::class.java)
        val retrofitdata = retrofitBuilder.getProductData()
        retrofitdata.enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                val responseData = response.body()
                if (responseData != null) {
                    productList.addAll(responseData.products)
                    recyclerview.layoutManager = LinearLayoutManager(this@Book_Recyclerview)
                    myAdapter = MyAdapter(productList, this@Book_Recyclerview)
                    recyclerview.adapter = myAdapter

                } else {
                    Log.d("MainActivity", "Response data is null")
                }
            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                Log.d("MainActivity", "on Failure" + t.message)
            }

        })
    }
    private fun filtertext(query : String?){
        val filteredList = ArrayList<Product>()
        if (query != null) {
            for (i in productList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)

                }

            }
            if (filteredList.isEmpty()) {

                Toast.makeText(this@Book_Recyclerview,"No data", Toast.LENGTH_SHORT).show()

            } else {



                myAdapter.setFilteredList(filteredList)


            }

        }

    }






    //status bar
    private fun changeStatusBarColor(color: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = android.graphics.Color.parseColor(color)
        }
    }
}