package com.example.androidanimalproject.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.androidanimalproject.model.Animal
import com.example.androidanimalproject.model.AnimalStatus
import com.example.androidanimalproject.model.StatusBadge
import androidx.navigation.NavController


@Composable
fun SearchScreen (navController: NavController, animal: List<Animal>) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("조회하기")
        }
        Spacer(Modifier.height(20.dp))
        LazyColumn (
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            items (animal.size) { index ->
                AnimalItemCard(animal[index], onClick = {})
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        AddButton()
    }
}

//동물 프로필 카드
@Composable
fun AnimalItemCard(animal: Animal, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row (modifier = Modifier.padding(12.dp)) {
            Image(
                painter = rememberAsyncImagePainter(animal.url),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column (modifier = Modifier.weight(1f)) {
                Text(
                    text = animal.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                StatusBadge(status = animal.status)
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "location",
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = animal.address,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

//우측 하단 추가 버튼
@Composable
fun AddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = Color(0xFFFFA938),
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "추가",
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview
@Composable
fun AddButtonPreview() {
    AddButton(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun AnimalItemCardPreview() {
    val sampleAnimal = Animal(
        url = "https://example.com/sample.jpg",
        name = "점박이",
        status = AnimalStatus.PROTECTED,
        address = "건국대학교 기숙사"
    )

    AnimalItemCard(animal = sampleAnimal, onClick = {})
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreviewDummy() {
    val dummyList = listOf(
        Animal("https://picsum.photos/130", "점박이", AnimalStatus.PROTECTED, "서울"),
        Animal("https://picsum.photos/130", "재인이", AnimalStatus.MISSING, "부산")
    )
    LazyColumn {
        items(dummyList.size) { index ->
            AnimalItemCard(animal = dummyList[index], onClick = {})
        }
    }
}
