package com.example.proyectogrupal.ui.home.viewmodel

import com.example.proyectogrupal.data.dto.response.RandomDogResponse

sealed class StateRandomDog {

    data class Success (val data: RandomDogResponse): StateRandomDog()
    data class Error (val message: String): StateRandomDog()
    data object Loading : StateRandomDog()

}