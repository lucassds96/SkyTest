package com.example.skytest.movieDetailActivity

import android.content.Intent
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.skytest.R
import com.example.skytest.model.Movies
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbar)
        setHeader()
        getData()
    }

    private fun setHeader() {
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val icon = ContextCompat.getDrawable(this, R.drawable.ic_keyboard_arrow_left_black_24dp)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            icon?.setColorFilter(resources.getColor(R.color.colorAccent, null), PorterDuff.Mode.SRC_IN)
        }
        toolbar?.navigationIcon = icon
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun getData(){
        val detail = intent.extras.getSerializable("details") as Movies
        val idMovie = detail.id

        movieDetailTitleTv.text = detail.title
        movieDetailOverviewTv.text = detail.overview
        movieDetailDurationTv.text = detail.duration
        movieDetailYearTv.text = detail.release_year
        Glide.with(this).load(detail.cover_url).into(movieLogoIv)

        movieLogoIv.setOnClickListener {
            if(idMovie == TrailersEnum.MARVEL.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.MARVEL.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.KONG.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.KONG.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.WAR.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.WAR.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.INTER.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.INTER.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.BEAST.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.BEAST.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.LOGAN.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.LOGAN.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.STAR.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.STAR.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.LITTLEB.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.LITTLEB.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.WICK.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.WICK.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.ROGUE.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.ROGUE.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.WONDER.id_trailer){
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.WONDER.url))
                startActivity(intent)
            }else if (idMovie == TrailersEnum.MUMMY.id_trailer) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TrailersEnum.MUMMY.url))
                startActivity(intent)
            }
        }
    }
}
