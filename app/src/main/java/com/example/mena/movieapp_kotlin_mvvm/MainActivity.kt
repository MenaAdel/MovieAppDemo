package com.example.mena.movieapp_kotlin_mvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
//import com.example.mena.movieapp_kotlin_mvvm.SimpleBindingAdapter.ItemClickListener
import com.example.mena.movieapp_kotlin_mvvm.models.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()/* , ItemClickListener<String>*/ {
    /*override fun onItemSelected(item: String) {
        showDataInToast()
    }*/

    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter : SimpleBindingAdapter
    private lateinit var moviesData : MutableList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        observeViewModelData()

    }

    private fun initRecyclerView() {
        adapter = SimpleBindingAdapter(moviesData)
        rcl_movie.setAdapter(adapter)
        rcl_movie.setLayoutManager(GridLayoutManager(this ,2))
    }

    fun initViewModel()
    {
        viewModel = ViewModelProviders
                .of(this)
                .get(MoviesViewModel::class.java)
    }

    fun observeViewModelData() {
        viewModel.getMoviesData().observe(this, Observer { t -> bindMoviesData(t!!) })
    }

    /*fun showDataInToast(moviesData : List<Movie>){
        Toast.makeText(this, moviesData.toString(), Toast.LENGTH_SHORT).show()
    }*/

    fun bindMoviesData(moviesData : MutableList<Movie>){
        this.moviesData = moviesData
        initRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchMoviesData()
    }


}
