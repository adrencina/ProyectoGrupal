package com.example.proyectogrupal.ui.home.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectogrupal.data.dto.repository.RandomDogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RandomDogViewModel(private val repository: RandomDogRepository = RandomDogRepository()): ViewModel() {

    private val _data = MutableLiveData<StateRandomDog>()
    val data : LiveData<StateRandomDog> = _data

    fun getRandomDog(){
        CoroutineScope(Dispatchers.IO).launch {
            _data.postValue(StateRandomDog.Loading)
           val response = repository.getRandomDog()
            if (response.isSuccessful){
                response.body()?.let {
                    _data.postValue(StateRandomDog.Success(it))
                } ?: _data.postValue(StateRandomDog.Error("No data"))
            } else{
                _data.postValue(StateRandomDog.Error("Error en el Servicio"))

            }
        }
    }
}