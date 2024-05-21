package com.example.proyectogrupal.data.dto.service

import com.example.proyectogrupal.data.dto.response.BuscarResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class BuscarAPIServiceImp {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breed/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create<BuscarAPIService>()


    suspend fun getDogsByBreeds(url: String) :Response<BuscarResponse>{
        return service.getDogsByBreeds(url)
    }

}