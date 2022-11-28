package com.brownik.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.brownik.sampleproject.databinding.ActivityMediaBinding

class MediaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMediaBinding
    private lateinit var mediaInfoViewModel: MediaInfoViewModel
    private val mediaInfoListAdapter: MediaInfoListAdapter by lazy {
        MediaInfoListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMediaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mediaInfoLayer.adapter = mediaInfoListAdapter
        mediaInfoViewModel = ViewModelProvider(
            this,
            MediaInfoViewModelFactory()
        )[MediaInfoViewModel::class.java]
        setMediaInfoLiveData()
        mediaInfoViewModel.updateMediaInfoDataList()
    }

    private fun setMediaInfoLiveData() {
        mediaInfoViewModel.mediaInfoDataList.observe(this@MediaActivity, Observer {
            mediaInfoListAdapter.submitList(it.toMutableList()) // LiveData list 변경에 따른 view 업데이트
        })
    }
}