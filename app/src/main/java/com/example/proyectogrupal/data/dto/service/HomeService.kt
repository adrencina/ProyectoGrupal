package com.example.proyectogrupal.data.dto.service

import com.example.proyectogrupal.data.dto.response.HomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET("breeds/image/random/50")
   suspend fun getDogs(): Response<HomeResponse>
}