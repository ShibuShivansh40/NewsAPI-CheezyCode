package com.example.newsapi_cheezycode

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=b3ba5c88b56a483cb2ffe343bbd235ae
//https://newsapi.org/v2/everything?q=apple&from=2023-02-15&to=2023-02-15&sortBy=popularity&apiKey=b3ba5c88b56a483cb2ffe343bbd235ae

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "b3ba5c88b56a483cb2ffe343bbd235ae"
// Here we will insert the common domain of the website

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country") country: String, @Query("page") page : Int) : Call<News>
    // Here the country we pass in the country parameter will be sent as the query to website
}

object NewsService{
    val newsInstance: NewsInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}