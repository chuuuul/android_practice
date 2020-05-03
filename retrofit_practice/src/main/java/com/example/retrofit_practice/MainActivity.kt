package com.example.retrofit_practice

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_practice.models.SearchResultModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), Callback<SearchResultModel> {

    private val MOVIE_SEARCH_API_URL = "https://openapi.naver.com"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl(MOVIE_SEARCH_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)
        val call = service.requestMovieList("해리포터")
        call.enqueue(this)


    }

    override fun onResponse(call: Call<SearchResultModel>, response: Response<SearchResultModel>) {
        editText.text = response.body().toString()

        Log.d("chul", "${response.body()}")
    }

    override fun onFailure(call: Call<SearchResultModel>, t: Throwable) {
        Log.d("chul", "$t")
    }

}
