package com.example.proyectogrupal.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectogrupal.data.dto.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewmodel(private val repository: HomeRepository = HomeRepository()): ViewModel() {

    private val _data = MutableLiveData<State>()
    val data : LiveData<State> = _data

    fun getDogs(){
        CoroutineScope(Dispatchers.IO).launch {
            _data.postValue(State.Loading)
            val response = repository.getDogs()
            if (response.isSuccessful){
                response.body()?.let {
                    _data.postValue(State.Success(it))
                } ?: _data.postValue(State.Error("No data"))
            } else{
                _data.postValue(State.Error("Error en el Servicio"))

            }
        }
    }
}
