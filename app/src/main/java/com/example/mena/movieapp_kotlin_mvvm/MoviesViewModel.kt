package com.example.mena.movieapp_kotlin_mvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.mena.movieapp_kotlin_mvvm.data.MoviesRequests
import com.example.mena.movieapp_kotlin_mvvm.data.RetrofitClient
import com.example.mena.movieapp_kotlin_mvvm.models.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MoviesViewModel : ViewModel() {
    var retrofitClient: RetrofitClient
    var moviesRequest : MoviesRequests
    var disposables:CompositeDisposable
    var moviesData: MutableLiveData<MutableList<Movie>>
    var offset: Int = 1

    init {
        this.retrofitClient = RetrofitClient
        this.disposables = CompositeDisposable()
        this.moviesData = MutableLiveData()
        moviesRequest = MoviesRequests()
    }

    fun fetchMoviesData(){
        val disposable = moviesRequest.fetchMovies(offset ,"777660159186d81259c9dcfa910ad0f1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (response.isSuccessful()) {
                        addMovies(response.body()!!.movies as MutableList<Movie>)
                    } else {
                    }
                }, { throwable ->
                    throwable.printStackTrace()
                })
        disposables.add(disposable)
    }

    private fun addMovies(newModels: MutableList<Movie>) {
        moviesData.value = newModels
    }

    fun getMoviesData(): LiveData<MutableList<Movie>> {
        return moviesData
    }
}