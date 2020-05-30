package com.example.skytest.movieDetailActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.skytest.R
import com.example.skytest.model.Movies
import kotlinx.android.synthetic.main.item_detail.view.*

class DetailAdapter (val context: Context, private val movies: Movies) : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.backdrops_url.size

    override fun onBindViewHolder(holder: DetailAdapter.ViewHolder, position: Int) = holder.bind(movies)

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movies: Movies){
            Glide.with(context).load(movies.cover_url).into(itemView.detailIv)
        }
    }
}