package com.example.proyectogrupal.data.dto.service

import com.example.proyectogrupal.data.dto.response.HomeResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class HomeServiseImp {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create<HomeServise>()

    suspend fun getDogs(): Response<HomeResponse> {
        val result = service.getDogs()
        return result
    }
}