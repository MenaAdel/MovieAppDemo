package com.example.mena.movieapp_kotlin_mvvm.data

import com.example.mena.movieapp_kotlin_mvvm.models.Movie
import com.google.gson.annotations.SerializedName

class MoviesResponse {
    @SerializedName("results")
    lateinit var movies: List<Movie>
}