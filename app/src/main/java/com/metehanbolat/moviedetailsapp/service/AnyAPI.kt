package com.metehanbolat.moviedetailsapp.service

import com.metehanbolat.moviedetailsapp.model.AnyModel
import retrofit2.Call
import retrofit2.http.GET

interface AnyAPI {

    // GET, POST, UPDATE, DELETE

    @GET("metehanie/JsonFiles/main/ticaretjson.json")
    fun getData(): Call<List<AnyModel>>

}