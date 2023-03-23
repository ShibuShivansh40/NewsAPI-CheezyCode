package com.example.newsapi_cheezycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var adapter:NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadlines("in" , 1)
        news.enqueue(object: retrofit2.Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("CHEEZYCODE----", "Error in fetching News", t)
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news: News? = response.body()
                if (news != null) {
                    Log.d("CHEEZYCODE", news.toString())
                    adapter = NewsAdapter(this@MainActivity, news.articles)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        })
    }
    //CREATING AN INTERFACE

}


/*
JSON Parsing Using Retrofit : -
Step - 1 : Creating an interface
Step - 2 : Add Objects and functions to Perform GET Function
Step - 3 : Then we will create classes according to the JSON we get
Step - 4 : Define parameter in the data class according to the JSON File you get
Step - 5 : Now import call using Retrofit Library
Step - 6 : Create a RetroFit Object
Step - 7 : Now create a call in AppCompat and create a function
Step - 8 : We will add Internet Permissions Now

RecyclerView to show News : -
Step - 1 : Create a Item Layout with a image view and 2 text views
Step - 2 : Then add a Recycler View in Activity Main
Step - 3 : Create a News Adapter
Step - 4 : Adding all the resources file to the Kotlin File
Step - 5 : The add the adapter to the Main Activity file to Recycler View
Step - 6 : To show images,
    1. Add dependencies of Glide Library
    2.
 */