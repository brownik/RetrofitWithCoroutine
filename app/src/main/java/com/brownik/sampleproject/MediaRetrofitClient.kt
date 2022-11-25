package com.brownik.sampleproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MediaRetrofitClient {
    private const val baseUrl = "https://liveapi.club5678.com"

    fun getMediaInfoDataInstance(): MediaRetrofitApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MediaRetrofitApi::class.java)
    }
}