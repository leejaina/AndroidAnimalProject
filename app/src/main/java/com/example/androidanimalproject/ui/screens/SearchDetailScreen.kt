package com.example.androidanimalproject.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.androidanimalproject.model.Animal
import com.example.androidanimalproject.model.AnimalStatus
import kotlinx.coroutines.sync.Mutex

@Composable
fun SearchDetailScreen(navController: NavController, animal: Animal) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "되돌아가기",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(horizontal = 21.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }
        AsyncImage(
            model = animal.url,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(420.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .height(304.dp),
            shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp)
        ) {
            Column(
            ) {
                Text(text = animal.name)
                Text(text = animal.status.name)
                Text(text = animal.address)
            }
        }
    }
}

@Preview
@Composable
fun SearchDetailScreenPreview() {
    val sampleAnimal = Animal(
        url = "https://example.com/sample.jpg",
        name = "점박이",
        status = AnimalStatus.PROTECTED,
        address = "건국대학교 기숙사"
    )
    val navController= rememberNavController()

    SearchDetailScreen(navController = navController, animal = sampleAnimal)
}