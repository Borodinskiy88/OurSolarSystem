package ru.borodinskiy.aleksei.oursolarsystem.ui.jupiter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JupiterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Jupiter Fragment"
    }
    val text: LiveData<String> = _text
}