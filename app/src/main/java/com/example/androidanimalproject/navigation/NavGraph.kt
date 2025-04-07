package com.example.androidanimalproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidanimalproject.model.Animal
import com.example.androidanimalproject.ui.screens.PostScreen
import com.example.androidanimalproject.ui.screens.SearchScreen

sealed class Screen(val route: String) {
    object Search : Screen("search")
    object Post : Screen("post")
}

@Composable
fun NavGraph(navController: NavHostController, animalList: List<Animal>) {
    NavHost(navController = navController, startDestination = Screen.Search.route) {
        composable(Screen.Search.route) {
            SearchScreen(navController = navController, animal = animalList)
        }
        composable(Screen.Post.route) {
            PostScreen()
        }
    }
}
