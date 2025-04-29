package com.example.androidanimalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidanimalproject.data.AnimalService
import com.example.androidanimalproject.data.dto.AnimalResponseDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimalViewModel @Inject constructor(
    private val animalService: AnimalService
) : ViewModel() {

    private val _animals = MutableStateFlow(emptyList<AnimalResponseDto>())

    init {
        getAnimals()
    }

    fun getAnimals() {
        viewModelScope.launch {
            _animals.value = animalService.getAnimals().data
            animalService
            Log.d("animals", _animals.value.toString())
        }
    }
}
