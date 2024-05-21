package com.example.proyectogrupal.data.dto.repository

import com.example.proyectogrupal.data.dto.response.HomeResponse
import com.example.proyectogrupal.data.dto.service.HomeServiceImp
import retrofit2.Response

class HomeRepository(private val servise: HomeServiceImp = HomeServiceImp()) {
     suspend fun getDogs(): Response<HomeResponse> {
        return servise.getDogs()
    }
}