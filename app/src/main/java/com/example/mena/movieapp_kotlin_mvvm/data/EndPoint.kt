package com.example.mena.movieapp_kotlin_mvvm.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface EndPoint {
    @GET("popular")
    fun fetchMovies(@Query("api_key") api_key: String ,@Query("offset") offset: Int): Single<Response<MoviesResponse>>
}