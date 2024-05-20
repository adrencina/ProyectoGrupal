package com.example.proyectogrupal.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel(){
    private val _text = MutableLiveData<String>()
    val text : LiveData<String> = _text

    private val _btnId = MutableLiveData<Int>()
    val btnId: LiveData<Int> = _btnId

    fun updateText(text: String){
        _text.postValue(text)
    }

    fun updateBtn(buttonId: Int){
        _btnId.postValue(buttonId)
    }
}