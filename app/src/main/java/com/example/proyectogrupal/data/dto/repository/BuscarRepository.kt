package com.example.proyectogrupal.data.dto.repository

import com.example.proyectogrupal.data.dto.response.BuscarResponse
import com.example.proyectogrupal.data.dto.service.BuscarAPIServiceImp
import retrofit2.Response

//
class BuscarRepository(val service: BuscarAPIServiceImp = BuscarAPIServiceImp()) {

    suspend fun getDogsByBreeds(breed: String):Response< BuscarResponse>{
        return service.getDogsByBreeds(breed)
    }
}