package com.example.lifecycleexamples

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap

class MyViewModel: ViewModel() {
    val countLiveData = MutableLiveData(0)

    fun doCount() {
        countLiveData.postValue(countLiveData.value!! + 1)
    }

    val content = MutableLiveData("")
    val reversedContent = content.map { it.reversed() }

    val content1 = MutableLiveData("")
    val content2 = MutableLiveData("")
    val condition = MutableLiveData(false)
    val result = condition.switchMap { if (it) content2 else content1 }
}