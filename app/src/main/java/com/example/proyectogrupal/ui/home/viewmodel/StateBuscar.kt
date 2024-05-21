package com.example.proyectogrupal.ui.home.viewmodel

import com.example.proyectogrupal.data.dto.response.BuscarResponse

sealed class StateBuscar() {
    data class Success(val info: BuscarResponse): StateBuscar()
    data class Error(val message: String): StateBuscar()
    object Loading: StateBuscar()
}