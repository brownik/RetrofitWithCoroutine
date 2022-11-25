package com.brownik.sampleproject

import com.google.gson.annotations.SerializedName

data class MediaListResponseData(
    @SerializedName("code") var code: String = "",
    @SerializedName("message") var message: String = "",
    @SerializedName("data") var data: List<MediaInfoData> = listOf(),
)