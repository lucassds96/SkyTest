package com.example.skytest.model

import java.io.Serializable

data class Movies(
    val title: String,
    val overview: String,
    val duration: String,
    val release_year: String,
    val cover_url: String,
    val backdrops_url: Array<String>,
    val id: String
): Serializable

