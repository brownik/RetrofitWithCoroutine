package com.brownik.sampleproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brownik.sampleproject.databinding.RecyclerviewMediaInfoBinding

class MediaInfoListAdapter :
    ListAdapter<MediaInfoData, MediaInfoListAdapter.ViewHolder>(DiffCallback) {

    inner class ViewHolder(
        private val binding: RecyclerviewMediaInfoBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MediaInfoData) = with(binding) {
            mediaInfoData = data
        }
    }

    override fun submitList(list: MutableList<MediaInfoData>?) {
        super.submitList(list?.toList())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            RecyclerviewMediaInfoBinding.bind(layoutInflater.inflate(
                R.layout.recyclerview_media_info,
                parent,
                false)
            )
        return ViewHolder(binding)
    }

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
            return oldItem == newItem
        }
    }
}