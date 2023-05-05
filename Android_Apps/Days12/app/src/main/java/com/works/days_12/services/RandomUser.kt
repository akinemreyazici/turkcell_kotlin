package com.works.days_12.services

import com.works.days_12.models.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUser
{
    @GET("api/")
    fun allUser(@Query("results") limit : Int) : Call<UserData>
}