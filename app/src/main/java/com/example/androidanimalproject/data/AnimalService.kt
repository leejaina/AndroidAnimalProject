package com.example.androidanimalproject.data

import com.example.androidanimalproject.data.dto.AnimalResponseDto
import com.example.androidanimalproject.data.dto.BaseResponse
import retrofit2.http.GET

interface AnimalService {
    @GET("dev/animals")
    suspend fun getAnimals(): BaseResponse<List<AnimalResponseDto>>
}