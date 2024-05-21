package com.example.proyectogrupal.data.dto.response

import com.google.gson.annotations.SerializedName

data class RandomDogResponse(
    @SerializedName("message") val imgDog : List<String>,
    @SerializedName("status") val status: String
)
