package com.example.proyectogrupal.ui.home.viewmodel

import com.example.proyectogrupal.data.dto.response.HomeResponse

sealed class State() {

    data class Success (val info: HomeResponse): State()
    data class Error (val message: String): State()
    data object Loading : State()

}