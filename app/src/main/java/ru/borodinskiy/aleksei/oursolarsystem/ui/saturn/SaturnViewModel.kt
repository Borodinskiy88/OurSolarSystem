package ru.borodinskiy.aleksei.oursolarsystem.ui.saturn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SaturnViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Saturn Fragment"
    }
    val text: LiveData<String> = _text
}