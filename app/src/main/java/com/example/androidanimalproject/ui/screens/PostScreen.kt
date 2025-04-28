package com.example.androidanimalproject.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidanimalproject.model.Animal
import com.example.androidanimalproject.model.AnimalStatus

@Composable
fun PostScreen(onRegister: (Animal) -> Unit) {
    var postScreenUrl by remember { mutableStateOf("") }
    var postScreenName by remember { mutableStateOf("") }
    var postScreenAddress by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp), // 버튼 높이만큼 패딩
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "등록하기",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(24.dp))

            PostInputField(label = "사진 url 입력", value = postScreenUrl) { postScreenUrl = it }
            PostInputField(label = "이름 입력", value = postScreenName) { postScreenName = it }
            PostInputField(label = "주소 입력", value = postScreenAddress) { postScreenAddress = it }
        }

        // 하단 고정 버튼
        RegisterButton(
            onClick = {
                val newAnimal = Animal(
                    name = postScreenName,
                    url = postScreenUrl,
                    address = postScreenAddress,
                    status = AnimalStatus.PROTECTED
                )
                onRegister(newAnimal)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 49.dp) // 바닥에서 띄우기
        )
    }
}

@Composable
fun PostInputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(vertical = 10.dp)
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .width(320.dp)
                .height(44.dp)
                .background(Color(0xFFE7E7E7),
                    RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.CenterStart

        ) {
            BasicTextField(
                value=value,
                onValueChange=onValueChange,
                singleLine = true,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                decorationBox = {innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = "$label",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                    innerTextField()
                }
            )
        }
    }
}

@Composable
fun RegisterButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(320.dp)
            .height(50.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFA938),
            contentColor = Color.Black
        )
    ) {
        Text(
            text = "등록하기",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}




@Preview (showBackground = true)
@Composable
fun PostScreenPreview() {
    PostScreen {}
}

@Preview(showBackground = true)
@Composable
fun RegisterButtonPreview() {
    RegisterButton(
        onClick = {},
        modifier = Modifier
            .width(320.dp)
            .height(50.dp)
    )
}

