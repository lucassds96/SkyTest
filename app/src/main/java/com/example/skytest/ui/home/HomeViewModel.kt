package com.example.skytest.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.skytest.model.Movies
import com.example.skytest.retrofit.Api
import com.example.skytest.retrofit.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {

    init {
        getData()
    }

    var showMovies= MutableLiveData <List<Movies>>()
    var showError = MutableLiveData <Throwable>()

    private fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance(URL_API)
        val endpoint = retrofitClient.create(Api::class.java)
        val callback = endpoint.getMovies()

        callback.enqueue(object : Callback<List<Movies>> {
            override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
                showError.value = t
            }

            override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {
                response.body()?.forEach {
                    showMovies.value = response.body()
                }
            }
        })
    }

    companion object {
        const val URL_API = "https://sky-exercise.herokuapp.com/api/"
    }
}