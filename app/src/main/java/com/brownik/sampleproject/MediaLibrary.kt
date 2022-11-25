package com.brownik.sampleproject

import android.util.Log
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MediaLibrary {
    fun getApiMusicList(callback: (List<MediaInfoData>) -> Unit) {

        val list = mutableListOf<MediaInfoData>()
        val filterJson = JSONObject().apply {
            put("searchSlct", "a")
            put("tapeClssCode", "")
            put("memNo", 0)
            put("memSex", "")
            put("updDate", "2022-2-28 10:00:00")
            put("pageNo", 1)
            put("pagePerCnt", 100)
        }
        val bodyJson = JSONObject().apply {
            put("tapeNo", 14301)
            put("tapeHostNo", 22120032)
            put("pageNo", 1)
            put("pagePerCnt", 100)
            put("type", "search")
            put("loginMemNo", 22016928)
            put("filter", filterJson)
            put("randomPlayList", JSONArray())
        }
        val params = bodyJson.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        val call = MediaRetrofitClient.getMediaInfoDataInstance().getMusicInfoData(params)

        /*call.enqueue(object : Callback<MediaListResponseData> {
            override fun onResponse(
                call: Call<MediaListResponseData>,
                response: Response<MediaListResponseData>,
            ) {
                if (response.isSuccessful) {
                    Log.d("qwe123", "isSuccessful")
                    response.body()?.data.let { dataList ->
                        dataList?.forEach { data ->
                            list.add(data.toMusicInfoData())
                        }
                        callback.invoke(list)
                    }
                } else {
                    Log.d("qwe123", "isNotSuccessful")
                }
            }

            override fun onFailure(call: Call<MediaListResponseData>, t: Throwable) {
                Log.d("qwe123", "Fail")
            }
        })*/
    }
}