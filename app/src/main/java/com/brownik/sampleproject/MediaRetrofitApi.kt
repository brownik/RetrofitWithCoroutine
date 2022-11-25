package com.brownik.sampleproject

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MediaRetrofitApi {
    @POST("api/tape/list")
    fun getMusicInfoData(
        @Body params: RequestBody,
    ): Response<MediaListResponseData>
}