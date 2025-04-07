package com.example.androidanimalproject.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PostScreen() {
    var imageUrl by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "등록하기",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(24.dp))

        PostInputField(label = "사진 url", value = imageUrl) { imageUrl = it }
        PostInputField(label = "이름", value = name) { name = it }
        PostInputField(label = "주소", value = location) { location = it }

        Spacer(modifier = Modifier.weight(1f))

        RegisterButton(onClick = {
            // 임시로 입력 내용 출력
            Log.d("PostScreen", "URL: $imageUrl, 이름: $name, 주소: $location")
        })
    }
}


@Composable
fun PostInputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 28.dp, vertical = 10.dp)
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .width(320.dp)
                .height(44.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFE7E7E7),
                unfocusedContainerColor = Color(0xFFE7E7E7),
                disabledContainerColor = Color(0xFFE7E7E7)
            ),
            placeholder = {
                Text(
                    text = "$label 입력",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        )
    }
}

@Composable
fun RegisterButton(onClick: () -> Unit) {
    Button (
        onClick = onClick,
        modifier = Modifier
            .width(320.dp)
            .height(50.dp)
            .padding(bottom = 49.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFA938))
    ) {
        Text(
            text = "등록하기",
            fontSize = 18.sp,
            fontFamily = FontFamily.Default, // Pretendard는 커스텀 폰트 등록 시 변경 가능
            color = Color.Black
        )
    }
}


@Preview (showBackground = true)
@Composable
fun PostScreenPreview() {
    PostScreen()
}