package com.brownik.sampleproject

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MediaRetrofitApi {
    @POST("api/tape/list")
    suspend fun getMediaInfoData(
        @Body params: RequestBody,
    ): Response<MediaListResponseData>
}