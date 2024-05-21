package com.example.proyectogrupal.data.dto.response

import com.google.gson.annotations.SerializedName

data class BuscarResponse(
    @SerializedName("message")
    val message : List<String>?,
    @SerializedName("status")
    val status : String?

)