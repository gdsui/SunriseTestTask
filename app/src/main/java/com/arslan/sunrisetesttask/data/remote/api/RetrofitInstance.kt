package com.arslan.sunrisetesttask.data.remote.api

import com.arslan.sunrisetesttask.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: TaskApi by lazy {
        retrofit.create(
            TaskApi::class.java)
    }
}