package com.example.flicker

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val baseUrl="https://www.flickr.com/services/rest/"

object ImageRepository
{
    val flickerApi:AppApi

    init {
        val retrofit =Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        flickerApi=retrofit.create(AppApi::class.java)
    }
}