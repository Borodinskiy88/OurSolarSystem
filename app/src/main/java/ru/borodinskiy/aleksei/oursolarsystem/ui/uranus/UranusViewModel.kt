package ru.borodinskiy.aleksei.oursolarsystem.ui.uranus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UranusViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Uranus Fragment"
    }
    val text: LiveData<String> = _text
}