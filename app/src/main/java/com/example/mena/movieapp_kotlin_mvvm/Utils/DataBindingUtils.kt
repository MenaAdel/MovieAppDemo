package com.example.mena.movieapp_kotlin_mvvm.Utils

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import com.example.mena.movieapp_kotlin_mvvm.R
import com.squareup.picasso.Picasso

class Utils {
    companion object {
        @JvmStatic @BindingAdapter("imageUrl")
        fun imageUrl(imageView: ImageView, url: String?) {
            Picasso.with(imageView.context)
                    .load(Uri.parse(url))
                    .resize(100, 100)
                    .placeholder(R.drawable.emptystate)
                    .into(imageView)
        }
    }
}