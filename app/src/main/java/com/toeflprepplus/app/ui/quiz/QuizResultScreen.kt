package com.toeflprepplus.app.ui.quiz

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toeflprepplus.app.ui.theme.TOEFLPrepPlusTheme

@Composable
fun QuizResultScreen(
    score: Int = 29,
    totalQuestions: Int = 140,
    onFinishQuiz: () -> Unit = {},
    onShare: () -> Unit = {}
) {
    val context = LocalContext.current
    val percentage = (score.toFloat() / totalQuestions.toFloat()) * 100
    val feedbackMessage = when {
        percentage >= 90 -> "Excellent! You're almost perfect!"
        percentage >= 75 -> "Great job! Keep practicing!"
        percentage >= 50 -> "Good effort! You can improve with more practice."
        else -> "Don't give up! Keep trying and practice more."
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFEFEFEF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Score Display
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(
                    Brush.horizontalGradient(listOf(Color(0xFF3A57E8), Color(0xFF22D1EE))),
                    shape = RoundedCornerShape(50)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$score/$totalQuestions",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Feedback Message
        Text(
            text = "Your Score",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Congratulations!\n$feedbackMessage",
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Share Button
        Button(
            onClick = {
                onShare()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFF3A57E8), shape = RoundedCornerShape(12.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22D1EE))
        ) {
            Text(text = "Share", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Back to Home Button
        Button(
            onClick = {
                onFinishQuiz()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFF3A57E8), shape = RoundedCornerShape(12.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF22D1EE))
        ) {
            Text(text = "Back to Home", fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuizResultScreenPreview() {
    TOEFLPrepPlusTheme {
        QuizResultScreen()
    }
}
