package com.example.mycars

import com.example.mycars.models.CarsData
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/vehicles/getallmanufacturers?format=json")
    suspend fun getData() : Response<CarsData>
}