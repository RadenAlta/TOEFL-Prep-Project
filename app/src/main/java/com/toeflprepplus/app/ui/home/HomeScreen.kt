package com.toeflprepplus.app.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toeflprepplus.app.ui.theme.TOEFLPrepPlusTheme

@Composable
fun HomeScreen(
    onStartListening: () -> Unit = {},
    onStartStructure: () -> Unit = {},
    onStartReading: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Selamat Datang di TOEFLPrep+",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Pilih bagian tes TOEFL untuk memulai latihan.",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        SectionCard(
            title = "Listening Comprehension",
            description = "50 soal - 40 menit",
            onClick = onStartListening
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionCard(
            title = "Structure & Written Expression",
            description = "40 soal - 25 menit",
            onClick = onStartStructure
        )

        Spacer(modifier = Modifier.height(16.dp))

        SectionCard(
            title = "Reading Comprehension",
            description = "50 soal - 55 menit",
            onClick = onStartReading
        )
    }
}

@Composable
fun SectionCard(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF22D1EE)),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Start Section",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TOEFLPrepPlusTheme {
        HomeScreen()
    }
}
