package ru.borodinskiy.aleksei.oursolarsystem.ui.mars

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MarsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Mars Fragment"
    }
    val text: LiveData<String> = _text
}