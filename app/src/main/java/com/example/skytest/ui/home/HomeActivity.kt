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
import com.example.skytest.ui.movieDetailActivity.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    lateinit var adapterMovies: MoviesAdapter
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homePb.visibility = View.VISIBLE
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setObservers()
    }

    private fun setObservers(){
        homeViewModel.run {
            homeViewModel.showMovies.observe(this@HomeActivity, Observer { initMovies(it) })
            homeViewModel.showError.observe(this@HomeActivity, Observer { errorApi(it) })
        }
    }

    private fun errorApi(msg: Throwable){
        Toast.makeText(this, msg.message, Toast.LENGTH_LONG).show()
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
