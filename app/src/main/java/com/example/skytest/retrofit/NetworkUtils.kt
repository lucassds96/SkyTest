package com.example.skytest.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUtils{

    private const val URL_API = "https://sky-exercise.herokuapp.com/api/"

        private fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val apiService: Api = getRetrofitInstance().create(Api::class.java)
}