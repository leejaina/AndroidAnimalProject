package com.example.androidanimalproject.data.dto

import androidx.compose.animation.core.AnimationState
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimalResponseDto (
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String,
    @SerialName("state")
    val state: String,
    @SerialName("breed")
    val breed: String,
    @SerialName("address")
    val address: String
)