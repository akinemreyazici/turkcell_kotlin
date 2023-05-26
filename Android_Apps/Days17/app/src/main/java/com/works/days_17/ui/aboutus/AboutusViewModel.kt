package com.works.days_17.ui.aboutus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutusViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is About Us Fragment"
    }

    private val _text2 = MutableLiveData<String>().apply {
        value = "Deneme Text"
    }
    val text: LiveData<String> = _text
    val text2 : LiveData<String> = _text2
}