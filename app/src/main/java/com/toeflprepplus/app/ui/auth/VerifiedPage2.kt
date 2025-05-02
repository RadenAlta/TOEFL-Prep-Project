package com.toeflprepplus.app.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toeflprepplus.app.R
import com.toeflprepplus.app.ui.theme.TOEFLPrepPlusTheme

@Composable
fun VerifiedPage2(
    onFinish: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF7E7D8E)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Success icon
            Icon(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Success",
                tint = Color(0xFF3A57E8),
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Success text
            Text(
                text = "Berhasil!",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description text
            Text(
                text = "Selamat! Akun Anda telah berhasil dibuat.",
                fontSize = 16.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Finish button
            Button(
                onClick = onFinish,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Brush.horizontalGradient(
                        listOf(Color(0xFF3A57E8), Color(0xFF22D1EE))
                    ).toSolidColor()
                )
            ) {
                Text(text = "Selesai", fontSize = 18.sp)
            }
        }
    }
}

// Helper to convert Brush to SolidColor
fun Brush.toSolidColor(): Color {
    return Color(0xFF3A57E8)
}

@Preview(showBackground = true)
@Composable
fun VerifiedPage2Preview() {
    TOEFLPrepPlusTheme {
        VerifiedPage2()
    }
}
