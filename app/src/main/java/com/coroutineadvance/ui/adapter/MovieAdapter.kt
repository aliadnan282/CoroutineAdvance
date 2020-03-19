package com.coroutineadvance.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coroutineadvance.databinding.ItemMovieBinding
import com.coroutineadvance.model.MovieModel
import com.coroutineadvance.model.MovieResults

class MovieAdapter(val movieList: List<MovieResults>?) :
    RecyclerView.Adapter<MovieAdapter.MoiveVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoiveVH {
        return MoiveVH(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MoiveVH, position: Int) {
        holder.bind(movieList?.get(position))
    }

    inner class MoiveVH(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: MovieResults?) {
            binding.textview.text = model?.title
            binding.executePendingBindings()
        }

    }
}