package com.example.mena.movieapp_kotlin_mvvm.Utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun ViewGroup.inflateChild(layoutId: Int): View
        = LayoutInflater.from(context).inflate(layoutId, this, false)
