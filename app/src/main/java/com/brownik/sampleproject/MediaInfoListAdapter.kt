package com.brownik.sampleproject

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.brownik.sampleproject.databinding.RecyclerviewMediaInfoBinding

class MediaInfoListAdapter(
    private val onClick: () -> Unit
) :
    ListAdapter<MediaInfoData, MediaInfoListAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder(
        private val binding: RecyclerviewMediaInfoBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(data: MediaInfoData) = with(binding) {
            binding.mediaInfoData = data
        }
    }

    override fun submitList(list: MutableList<MediaInfoData>?) {
        super.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            RecyclerviewMediaInfoBinding.bind(layoutInflater.inflate(R.layout.recyclerview_media_info, parent, false))
        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    object DiffCallback : DiffUtil.ItemCallback<MediaInfoData>() {
        override fun areItemsTheSame(
            oldItem: MediaInfoData,
            newItem: MediaInfoData,
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: MediaInfoData,
            newItem: MediaInfoData,
        ): Boolean {
            return false
        }
    }
}