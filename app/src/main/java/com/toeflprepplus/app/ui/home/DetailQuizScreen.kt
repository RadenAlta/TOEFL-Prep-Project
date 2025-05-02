package com.toeflprepplus.app.ui.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toeflprepplus.app.ui.theme.TOEFLPrepPlusTheme
import kotlinx.coroutines.launch

@Composable
fun DetailQuizScreen(
    quizTitle: String = "Listening Comprehension",
    duration: String = "40 minutes",
    numberOfQuestions: Int = 50,
    points: Int = 100,
    rating: Float = 4.8f,
    onBack: () -> Unit = {},
    onStartQuiz: () -> Unit = {}
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Explanation and tips content
    val explanationText = """
        - 50 questions covering listening comprehension
        - Select the best answer based on the audio
        - Do not write or take notes during the actual test
    """

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        // Back button and title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onBack() },
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Detail Quiz",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Quiz Title
        Text(
            text = quizTitle,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Quiz Info (Duration, Number of Questions, and Rating)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "$numberOfQuestions Questions", fontSize = 16.sp, color = Color.Gray)
            Text(text = "$duration", fontSize = 16.sp, color = Color.Gray)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Rating: ", fontSize = 16.sp, color = Color.Gray)
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating",
                    tint = Color.Yellow,
                    modifier = Modifier.size(16.dp)
                )
                Text(text = "$rating", fontSize = 16.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Quiz Explanation
        Text(
            text = "Brief explanation about this quiz",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = explanationText,
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Start Quiz Button
        Button(
            onClick = {
                coroutineScope.launch {
                    Toast.makeText(
                        context,
                        "Starting Quiz...",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                onStartQuiz()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFF3A57E8), shape = RoundedCornerShape(12.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22D1EE))
        ) {
            Text(text = "Start Quiz", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailQuizScreenPreview() {
    TOEFLPrepPlusTheme {
        DetailQuizScreen()
    }
}
