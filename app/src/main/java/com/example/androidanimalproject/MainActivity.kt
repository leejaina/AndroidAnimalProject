package com.example.androidanimalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.core.view.WindowCompat
import com.example.androidanimalproject.model.Animal
import com.example.androidanimalproject.navigation.NavGraph
import com.example.androidanimalproject.ui.theme.AndroidAnimalProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AndroidAnimalProjectTheme {
                val navController = rememberNavController()

                // 테스트용 더미 데이터??
                val animalList = listOf<Animal>()

                NavGraph(navController = navController, animalList = animalList)
            }
        }
    }
}