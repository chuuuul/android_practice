package com.example.retrofit_practice

import com.example.retrofit_practice.models.SearchResultModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {

    @Headers(
        "X-Naver-Client-Id: ${BuildConfig.Naver_Client_Id}"
        , "X-Naver-Client-Secret: ${BuildConfig.Naver_Client_Secret}"
    )
    @GET("/v1/search/movie.json")
    fun requestMovieList(@Query("query") keyWord: String): Call<SearchResultModel>


}