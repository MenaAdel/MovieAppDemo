package com.example.mena.movieapp_kotlin_mvvm.data

class MoviesRequests {

    fun fetchMovies(offset : Int ,api_key : String) =
            RetrofitClient.client
                    .create(EndPoint::class.java)
                    .fetchMovies(api_key ,offset)

}