package com.example.androidanimalproject.model

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview


data class Animal(
    val url : String,
    val name : String,
    val status: AnimalStatus,
    val address: String
)

enum class AnimalStatus {
    PROTECTED, // 보호중
    MISSING,   // 실종신고
    SIGHTED    // 목격신고
}


@Composable
fun StatusBadge(status: AnimalStatus) {
    val (text, color) = when (status) {
        AnimalStatus.PROTECTED -> "보호중" to Color(0xFF66BB6A)
        AnimalStatus.MISSING -> "실종신고" to Color(0xFFE57373)
        AnimalStatus.SIGHTED -> "목격신고" to Color(0xFF64B5F6)
    }

    Box(
        modifier = Modifier
            .background(color, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 12.sp)
    }
}

@Preview
@Composable
fun StatusBadgePreview() {
    Column {
        StatusBadge(status = AnimalStatus.PROTECTED)
        StatusBadge(status = AnimalStatus.MISSING)
        StatusBadge(status = AnimalStatus.SIGHTED)
    }
}
