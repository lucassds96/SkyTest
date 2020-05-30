package com.example.skytest.movieDetailActivity

import android.content.Intent
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.skytest.R
import com.example.skytest.model.Movies
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    lateinit var detailAdapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)
        setHeader()
        getData()
    }

    private fun setDetailsMovie(movies: Movies){
        detailAdapter = DetailAdapter(this, movies)
        detailsRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        detailsRv.adapter = detailAdapter
    }

    private fun setHeader() {
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val icon = ContextCompat.getDrawable(this, R.drawable.ic_keyboard_arrow_left_black_24dp)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            icon?.setColorFilter(resources.getColor(R.color.colorWhite, null), PorterDuff.Mode.SRC_IN)
        }
        toolbar?.navigationIcon = icon
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun getData(){
        val detail = intent.extras.getSerializable("details") as Movies
        val idMovie = detail.id
        setDetailsMovie(detail)
        movieDetailTitleTv.text = detail.title
        movieDetailOverviewTv.text = detail.overview
        movieDetailDurationTv.text = detail.duration
        movieDetailYearTv.text = detail.release_year
        Glide.with(this).load(detail.cover_url).into(movieLogoIv)

        movieLogoIv.setOnClickListener {

            when (idMovie) {
                TrailersEnum.MARVEL.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.MARVEL.url))
                    startActivity(intent)
                }
                TrailersEnum.KONG.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.KONG.url))
                    startActivity(intent)
                }
                TrailersEnum.WAR.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.WAR.url))
                    startActivity(intent)
                }
                TrailersEnum.INTER.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.INTER.url))
                    startActivity(intent)
                }
                TrailersEnum.BEAST.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.BEAST.url))
                    startActivity(intent)
                }
                TrailersEnum.LOGAN.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.LOGAN.url))
                    startActivity(intent)
                }
                TrailersEnum.STAR.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.STAR.url))
                    startActivity(intent)
                }
                TrailersEnum.LITTLEB.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.LITTLEB.url))
                    startActivity(intent)
                }
                TrailersEnum.WICK.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.WICK.url))
                    startActivity(intent)
                }
                TrailersEnum.ROGUE.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.ROGUE.url))
                    startActivity(intent)
                }
                TrailersEnum.WONDER.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.WONDER.url))
                    startActivity(intent)
                }
                TrailersEnum.MUMMY.id_trailer -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.MUMMY.url))
                    startActivity(intent)
                }
            }
        }
    }
}
