package com.brownik.sampleproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

class MediaInfoViewModel : ViewModel() {
    private var _mediaInfoDataList = MutableLiveData<List<MediaInfoData>>()
    val mediaInfoDataList: LiveData<List<MediaInfoData>> = _mediaInfoDataList



    private val _selectedMediaInfoData = MutableLiveData<MediaInfoData>()
    val selectedMediaInfoData: LiveData<MediaInfoData> = _selectedMediaInfoData

    fun updateMediaInfoDataList() {
        fetchMediaInfoDataList()
    }

    fun updateSelectedMediaInfoData() {
        fetchSelectedMediaInfoData()
    }

    private fun fetchMediaInfoDataList() {
        getMediaInfoDataList()
    }

    private fun fetchSelectedMediaInfoData() {

    }

    private val filterJson = JSONObject().apply {
        put("searchSlct", "a")
        put("tapeClssCode", "")
        put("memNo", 0)
        put("memSex", "")
        put("updDate", "2022-2-28 10:00:00")
        put("pageNo", 1)
        put("pagePerCnt", 100)
    }
    private val bodyJson = JSONObject().apply {
        put("tapeNo", 14301)
        put("tapeHostNo", 22120032)
        put("pageNo", 1)
        put("pagePerCnt", 100)
        put("type", "search")
        put("loginMemNo", 22016928)
        put("filter", filterJson)
        put("randomPlayList", JSONArray())
    }
    private val params = bodyJson.toString().toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
    private val mediaRetrofitClient = MediaRetrofitClient.getMediaInfoDataInstance()
    private fun getMediaInfoDataList() =
        CoroutineScope(Dispatchers.IO).launch {
            val response = mediaRetrofitClient.getMediaInfoData(params)
            if (response.isSuccessful) {
                response.body()?.let {
                    _mediaInfoDataList.value = it.data
                }
            } else {
                _mediaInfoDataList.value = emptyList()
                Log.d("qwe123", "Error: ${response.message()}")
            }
        }

    override fun onCleared() {
        super.onCleared()
        getMediaInfoDataList().cancel()
    }
}