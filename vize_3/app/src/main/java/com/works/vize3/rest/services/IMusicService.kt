package com.works.vize3.rest.services

import com.works.vize3.models.MusicList
import retrofit2.Call
import retrofit2.http.GET

interface IMusicService {
    @GET("v1/f27fbefc-d775-4aee-8d65-30f76f1f7109")
    fun getMusic(): Call<MusicList>
}