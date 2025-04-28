package com.example.androidanimalproject.navigation

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object Home : Routes

    @Serializable
    data object Resister : Routes

    @Serializable
    data class Detail(val index: Int): Routes
}