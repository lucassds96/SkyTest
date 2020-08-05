package com.example.skytest.repository

import com.example.skytest.model.Movies
import com.example.skytest.retrofit.Api

class HomeRepositoryImpl(private val api: Api): HomeRepositoryHelper {
    override suspend fun getMovies() = api.getMovies()
}

interface HomeRepositoryHelper{
    suspend fun getMovies() : List<Movies>
}