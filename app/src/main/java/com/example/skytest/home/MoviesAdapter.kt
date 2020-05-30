package com.example.skytest.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skytest.R
import com.example.skytest.model.Movies
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter (val context: Context, private val movies: List<Movies>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var itemClickListener: ItemClickListener? = null

    interface ItemClickListener {
        fun onItemClick(position: Int, movies: Movies)
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) = holder.bind(movies[position])

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movies: Movies){
            Glide.with(context).load(movies.cover_url).into(itemView.movieIv)
            itemView.movieNameTv.text = movies.title
            itemView.movieIv.setOnClickListener { itemClickListener!!.onItemClick(adapterPosition, movies) }
        }
    }
}