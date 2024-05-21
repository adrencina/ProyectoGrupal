package com.example.proyectogrupal.data.dto.service

import com.example.proyectogrupal.data.dto.response.HomeResponse
import com.example.proyectogrupal.data.dto.response.RandomDogResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RandomDogServiceImp {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breeds/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create<RandomDogAPIService>()

    suspend fun getRandomDogs(): Response<RandomDogResponse> {
        val result = service.getRandomDog()
        return result
    }

}