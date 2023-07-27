package ru.borodinskiy.aleksei.oursolarsystem.ui.neptune

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NeptuneViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Neptune Fragment"
    }
    val text: LiveData<String> = _text
}