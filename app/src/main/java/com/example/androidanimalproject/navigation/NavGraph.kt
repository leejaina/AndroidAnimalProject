package com.example.androidanimalproject.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidanimalproject.model.Animal
import com.example.androidanimalproject.model.AnimalStatus
import com.example.androidanimalproject.ui.screens.PostScreen
import com.example.androidanimalproject.ui.screens.SearchDetailScreen
import com.example.androidanimalproject.ui.screens.SearchScreen
import kotlinx.serialization.json.Json

sealed class Screen(val route: String) {
    object Search : Screen("search")
    object Post : Screen("post")
    object Detail: Screen("detail/{animal}") {
        fun createRoute(animalJson: String) : String {
            return "detail/${Uri.encode(animalJson)}"
        }
    }
}


@Composable
fun NavGraph(navController: NavHostController, animalList: List<Animal>) {
    val internalAnimalList = remember { mutableStateListOf<Animal>(Animal(
        url = "https://i.pinimg.com/736x/2e/0f/9c/2e0f9c27dc1fe818201505d6c587dfb0.jpg",
        name = "점박이",
        status = AnimalStatus.MISSING,
        address = "kondae"
    )) }

    NavHost(navController = navController, startDestination = Screen.Search.route) {
        composable(Screen.Search.route) {
            SearchScreen(navController = navController, animal = internalAnimalList)
        }
        composable(Screen.Post.route) {
            PostScreen(
                onRegister = { animal ->
                    internalAnimalList.add(animal)
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Detail.route) { backStackEntry ->
            val animalJson=backStackEntry.arguments?.getString("animal")?:""
            val animal= Json.decodeFromString<Animal>(animalJson)
            SearchDetailScreen(animal=animal, navController=navController)
        }
    }
}