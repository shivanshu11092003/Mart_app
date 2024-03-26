package com.example.kietmart

import Product
import android.telecom.Call
import retrofit2.http.GET
import Data as Data

interface Apiinterface {

    @GET("products")
    fun getProductData(): retrofit2.Call<Data>
}