package com.example.proyectogrupal.data.dto.service

import com.example.proyectogrupal.data.dto.response.BuscarResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

//metodo por el cual accedemos a nuestro API
//la interfaz es utilizada por retrofic

interface BuscarAPIService {
    @GET
    suspend fun getDogsByBreeds(@Url url:String) : Response<BuscarResponse>
}