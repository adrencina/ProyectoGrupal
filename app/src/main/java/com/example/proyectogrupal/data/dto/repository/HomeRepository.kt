package com.example.proyectogrupal.data.dto.repository

import com.example.proyectogrupal.data.dto.response.HomeResponse
import com.example.proyectogrupal.data.dto.service.HomeServiseImp
import retrofit2.Response

class HomeRepository(private val servise: HomeServiseImp = HomeServiseImp()) {
     suspend fun getDogs(): Response<HomeResponse> {
        return servise.getDogs()
    }
}