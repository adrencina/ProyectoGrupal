package com.example.proyectogrupal.data.dto.repository

import com.example.proyectogrupal.data.dto.response.RandomDogResponse
import com.example.proyectogrupal.data.dto.service.RandomDogServiceImp
import retrofit2.Response

class RandomDogRepository(private val servise: RandomDogServiceImp = RandomDogServiceImp()) {
    suspend fun getRandomDog(): Response<RandomDogResponse> {
        return servise.getRandomDogs()
    }
}