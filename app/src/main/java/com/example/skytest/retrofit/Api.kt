package com.example.skytest.retrofit

import com.example.skytest.model.Movies
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("Movies")
    fun getMovies() : Call <List<Movies>>
}