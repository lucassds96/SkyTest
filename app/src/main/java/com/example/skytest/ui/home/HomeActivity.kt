package com.example.skytest.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.skytest.R
import com.example.skytest.model.Movies
import com.example.skytest.repository.HomeRepositoryImpl
import com.example.skytest.retrofit.NetworkUtils
import com.example.skytest.ui.movieDetailActivity.MovieDetailActivity
import com.example.skytest.utils.Status
import com.example.skytest.utils.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    lateinit var adapterMovies: MoviesAdapter
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homePb.visibility = View.VISIBLE
        homeViewModel = ViewModelProvider(this, ViewModelFactory(
            HomeRepositoryImpl(NetworkUtils.apiService))).get(HomeViewModel::class.java)
        setObservers()
    }

    private fun setObservers(){
        homeViewModel.run {
            homeViewModel.getMovies().observe(this@HomeActivity, Observer {
                when(it.status){
                    Status.SUCCESS -> { it.data?.let { initMovies(it) }}
                    Status.ERROR -> {errorApi(it.message)}
                }
            })
        }
    }

    private fun errorApi(msg: String?){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    private fun initMovies(movies: List<Movies>){
        homePb.visibility = View.GONE
        adapterMovies = MoviesAdapter(this, movies)
        moviesRv.layoutManager = GridLayoutManager(this, 2)
        moviesRv.adapter = adapterMovies

        adapterMovies.setOnItemClickListener(object: MoviesAdapter.ItemClickListener{
            override fun onItemClick(position: Int, movieDetail: Movies) {
                val intent = Intent(this@HomeActivity, MovieDetailActivity::class.java)
                intent.putExtra("details", movieDetail)
                startActivity(intent)
            }
        })
    }
}
