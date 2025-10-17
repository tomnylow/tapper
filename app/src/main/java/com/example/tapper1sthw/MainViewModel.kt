package com.example.tapper1sthw

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val texts = listOf("клик", "клак", "клок")
    var currentIndex by mutableIntStateOf(0)
    var clickCount by mutableIntStateOf(0)

    fun onButtonClick() {
        clickCount++
        currentIndex = (currentIndex + 1) % texts.size
    }

    val currentText
        get() = texts[currentIndex]
}