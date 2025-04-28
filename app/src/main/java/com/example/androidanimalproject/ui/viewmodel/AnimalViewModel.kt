package com.example.androidanimalproject.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidanimalproject.data.AnimalService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

@HiltViewModel
class AnimalViewModel @Inject constructor(
    private val retrofit: Retrofit
) : ViewModel() {
    val animalService = retrofit.create(AnimalService::class.java)

    fun getAnimals() {
        viewModelScope.launch {
            val animals=animalService.getAnimals()
            Log.d("animals", animals.toString())
        }
    }
}