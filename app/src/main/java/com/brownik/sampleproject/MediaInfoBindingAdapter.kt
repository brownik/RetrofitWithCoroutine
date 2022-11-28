package com.brownik.sampleproject

import android.annotation.SuppressLint
import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

object MediaInfoBindingAdapter {
    @SuppressLint("CheckResult")
    @BindingAdapter("app:loadImage")
    @JvmStatic
    fun loadImage(targetView: ImageView, path: String?) {
        val uri = "https://photo2.club5678.com/tape/image/${path}?size=s&gifAniYn=y"
        Glide.with(targetView.context)
            .load(uri)
            .error(R.drawable.ic_launcher_foreground)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(15)))
            .into(targetView)
    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter("app:makeDuration")
    @JvmStatic
    fun makeDuration(targetView: TextView, duration: Long?) {
        duration?.let {
            val minute = it / 60
            val second = it % 60
            targetView.text = ("${minute}분 ${second}초")
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    @BindingAdapter("app:changeColor")
    @JvmStatic
    fun changeColor(targetView: TextView, isSelected: Boolean) {
        val colorResId = if (isSelected) R.color.selected else R.color.not_selected
        targetView.setTextColor(targetView.context.getColor(colorResId))
    }
}