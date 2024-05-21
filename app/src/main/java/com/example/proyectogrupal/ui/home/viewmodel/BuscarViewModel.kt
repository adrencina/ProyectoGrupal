package com.example.proyectogrupal.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectogrupal.data.dto.repository.BuscarRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BuscarViewModel(private val repository: BuscarRepository = BuscarRepository()) : ViewModel() {
    private val _data = MutableLiveData<StateBuscar>()
    val data : LiveData<StateBuscar> = _data

    fun getDogsByBreeds(breed: String){
        CoroutineScope(Dispatchers.IO).launch{
            _data.postValue(StateBuscar.Loading)
            val response = repository.getDogsByBreeds("$breed/images")

            if (response.isSuccessful){
                response.body()?.let {//Si no es nulo
                    _data.postValue(StateBuscar.Success(it))
                } ?: _data.postValue(StateBuscar.Error("No data")) //Si es nulo
            }else{
                _data.postValue(StateBuscar.Error("Error Service"))
            }
        }
    }

}