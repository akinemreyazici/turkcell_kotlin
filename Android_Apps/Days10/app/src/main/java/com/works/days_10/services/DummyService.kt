package com.works.days_10.services

import com.works.days_10.models.DummyProducts
import com.works.days_10.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface DummyService {

    @GET("products")
    fun products() : Call<DummyProducts>

    @GET("products/{id}")
    fun singleProduct(@Path("id") id : Int) : Call<Product>

}