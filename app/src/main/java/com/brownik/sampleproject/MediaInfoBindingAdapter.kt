package com.brownik.sampleproject

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object MediaInfoBindingAdapter {
    @SuppressLint("CheckResult")
    @BindingAdapter("app:loadImage")
    @JvmStatic
    fun loadImage(targetView: ImageView, path: Uri?) {
        Glide.with(targetView.context)
            .load(path)
            .error(R.drawable.ic_launcher_foreground)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(15)))
            .into(targetView)
    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter("app:makeDuration")
    @JvmStatic
    fun makeDuration(targetView: TextView, duration: Long?) {
        duration?.let {
            val time = it / 1000
            val minute = time / 60
            val second = time % 60
            targetView.text = ("${minute}분 ${second}초")
        }
    }

    @SuppressLint("ResourceAsColor")
    @BindingAdapter("app:changeColor")
    @JvmStatic
    fun changeColor(targetView: TextView, isSelected: Boolean) {
        val colorResId = if (isSelected) R.color.selected else R.color.not_selected
        targetView.setTextColor(targetView.context.getColor(colorResId))
    }
}