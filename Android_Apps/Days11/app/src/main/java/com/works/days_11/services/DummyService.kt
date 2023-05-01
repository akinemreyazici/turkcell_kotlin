package com.works.days_11.services


import com.works.days_11.models.JWTData
import com.works.days_11.models.JWTUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DummyService {

    @POST("/auth/login")
    fun login(@Body jwtUser: JWTUser): Call<JWTData> // Sadece JWTData değilde Call ile beklemeliyiz ki mainde enqueue fonksiyonunda kullanabilelim.

}