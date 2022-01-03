package com.metehanbolat.moviedetailsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.metehanbolat.moviedetailsapp.model.AnyModel
import com.metehanbolat.moviedetailsapp.service.AnyAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var anyList : ArrayList<AnyModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

    }

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(AnyAPI::class.java)
        val call = service.getData()

        call.enqueue(object : Callback<List<AnyModel>>{
            override fun onResponse(
                call: Call<List<AnyModel>>,
                response: Response<List<AnyModel>>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        anyList = ArrayList(it)
                        for (any in anyList!!){
                            println(any.id)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<AnyModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}