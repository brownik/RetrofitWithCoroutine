package com.brownik.sampleproject

import com.google.gson.annotations.SerializedName

data class MediaInfoData(
    @SerializedName("tapeImgName") val imagePath: String = "",
    @SerializedName("tapeTitle") val title: String = "",
    @SerializedName("chatName") val artist: String = "",
    @SerializedName("tapeTime") val duration: Long = 0,
    @SerializedName("tapeFileName") val mediaPath: String = "",
    val isSelected: Boolean = false
){
    fun toMusicInfoData() = MediaInfoData(
        imagePath = "https://photo2.club5678.com/tape/image/${imagePath}?size=s&gifAniYn=y",
        title = title,
        artist = artist,
        duration = duration,
        mediaPath = "https://photo2.club5678.com/tape/audio/${mediaPath}"
    )
}