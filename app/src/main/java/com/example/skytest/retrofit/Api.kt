package com.example.skytest.retrofit

import com.example.skytest.model.Movies
import retrofit2.http.GET

interface Api {
    @GET("Movies")
    suspend fun getMovies(): List<Movies>
}