package com.example.skytest.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skytest.model.Movies
import com.example.skytest.repository.HomeRepositoryHelper
import com.example.skytest.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel(private val apiHelper: HomeRepositoryHelper): ViewModel() {

    init {
        movieData()
    }

    private val showMovies = MutableLiveData<Resource<List<Movies>>>()
    var showError = MutableLiveData <Resource<Throwable>>()

    private fun movieData(){
        viewModelScope.launch{
            try {
                val moviewFromApi = apiHelper.getMovies()
                showMovies.postValue(Resource.success(moviewFromApi))
            }catch (e: Exception){
//                showError.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getMovies(): LiveData<Resource<List<Movies>>> {
        return showMovies
    }
}