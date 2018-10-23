package com.example.mena.movieapp_kotlin_mvvm.models

import com.google.gson.annotations.SerializedName

class Movie {
    @SerializedName("poster_path") lateinit var posterPath: String

    fun getPosterUrl(): String
    {
        return "http://image.tmdb.org/t/p/w342$posterPath"
    }
}