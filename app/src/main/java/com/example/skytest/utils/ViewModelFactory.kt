package com.example.skytest.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skytest.repository.HomeRepositoryHelper
import com.example.skytest.ui.home.HomeViewModel

class ViewModelFactory (private val homeRepositoryHelper: HomeRepositoryHelper) :
    ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(homeRepositoryHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}