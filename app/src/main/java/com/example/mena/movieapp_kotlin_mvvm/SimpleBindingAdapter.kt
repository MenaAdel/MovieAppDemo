package com.example.mena.movieapp_kotlin_mvvm

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mena.movieapp_kotlin_mvvm.databinding.MovieItemBinding
import com.example.mena.movieapp_kotlin_mvvm.models.Movie

class SimpleBindingAdapter(private val items: MutableList<Movie>) : RecyclerView.Adapter<SimpleBindingAdapter.AdapterViewHolder>() {

    private lateinit var binding: MovieItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val inflater = LayoutInflater.from(parent.getContext())
        binding = DataBindingUtil.inflate(inflater, R.layout.movie_item, parent, false)

        return AdapterViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val movie = items[position]
        binding.model = movie
        binding.executePendingBindings()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    class AdapterViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    /*interface ItemClickListener<T> {
        fun onItemSelected(item: T)
    }*/
}