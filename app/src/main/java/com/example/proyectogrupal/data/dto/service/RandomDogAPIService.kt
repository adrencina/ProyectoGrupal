package com.example.proyectogrupal.data.dto.service

import com.example.proyectogrupal.data.dto.response.RandomDogResponse
import retrofit2.Response
import retrofit2.http.GET


interface RandomDogAPIService {
    @GET("image/random/1")
    suspend fun getRandomDog(): Response<RandomDogResponse>
}