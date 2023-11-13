package com.example.kotlin101


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
//API service permettant de récupérer les données de l'API avec Retrofit
interface ApiService {
    @GET("all")
    suspend fun getAll(): Response<List<Country>>
    object RetrofitApi{
        fun getInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://restcountries.com/v3.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}