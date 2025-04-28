package com.example.androidanimalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.androidanimalproject.ui.navigation.NavGraph
import com.example.androidanimalproject.ui.theme.AndroidAnimalProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 상태바 투명하게 만들기 (선택 사항)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AndroidAnimalProjectTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, animalList = emptyList())
            }
        }
    }
}

