package com.toeflprepplus.app.ui.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toeflprepplus.app.ui.theme.TOEFLPrepPlusTheme

@Composable
fun ResetPasswordScreen(
    onBack: () -> Unit = {},
    onSubmit: (String) -> Unit = {}
) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onBack() },
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Atur Ulang Kata Sandi",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // New Password
        Text(
            text = "Kata Sandi Baru",
            fontSize = 16.sp,
            color = Color(0xFF4A148C),
            modifier = Modifier.align(Alignment.Start)
        )
        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Confirm Password
        Text(
            text = "Konfirmasi Kata Sandi Baru",
            fontSize = 16.sp,
            color = Color(0xFF4A148C),
            modifier = Modifier.align(Alignment.Start)
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Gradient Button (Box)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF3A57E8), Color(0xFF22D1EE))
                    ),
                    shape = RoundedCornerShape(12.dp)
                )
                .clickable {
                    if (newPassword == confirmPassword && newPassword.isNotEmpty()) {
                        onSubmit(newPassword)
                        Toast.makeText(
                            context,
                            "Kata sandi berhasil diubah",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Kata sandi tidak sama atau kosong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Kirim",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordScreenPreview() {
    TOEFLPrepPlusTheme {
        ResetPasswordScreen()
    }
}
