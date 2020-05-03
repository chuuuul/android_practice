package com.example.retrofit_practice.models


import com.google.gson.annotations.SerializedName

data class SearchResultModel(
    val display: Int,
    @SerializedName("items")
    val items: List<MovieModel>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)