package com.example.desafiopokedex.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}