package com.brownik.sampleproject

import com.google.gson.annotations.SerializedName

data class MediaInfoData(
    @SerializedName("tapeImgName") val imagePath: String = "",
    @SerializedName("tapeTitle") val title: String = "",
    @SerializedName("chatName") val artist: String = "",
    @SerializedName("tapeTime") val duration: Long = 0,
    @SerializedName("tapeFileName") val mediaPath: String = "",
    val isSelected: Boolean = false
)