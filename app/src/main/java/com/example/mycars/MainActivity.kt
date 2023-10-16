package com.example.mycars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycars.models.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvMain : RecyclerView
    lateinit var myAdapter: MyAdapter
     val BASE_URL = "https://vpic.nhtsa.dot.gov/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain= findViewById(R.id.recyclerView)
        rvMain.layoutManager = LinearLayoutManager(this)
        getAllData()
    }

    private fun getAllData() {
        var retrofit = Retrofit.Builder()
            .baseUrl((BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        GlobalScope.launch{
            var retroData = retrofit.getData()
            val data =  retroData.body()?.Results
            println("hello world")
  print(data?.first()?.Mfr_Name)

        }



    }
}
