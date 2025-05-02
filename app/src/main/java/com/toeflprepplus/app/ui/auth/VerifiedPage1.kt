package com.toeflprepplus.app.ui.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toeflprepplus.app.ui.theme.TOEFLPrepPlusTheme
import kotlinx.coroutines.delay
import java.util.Locale

@Composable
fun VerifiedPage1(
    email: String = "dimas_cakep@gmail.com",
    onBack: () -> Unit = {},
    onNext: () -> Unit = {},
    onResend: () -> Unit = {}
) {
    val context = LocalContext.current
    var code by remember { mutableStateOf(List(4) { "" }) }
    var timer by remember { mutableStateOf(60) } // seconds

    // Countdown logic
    LaunchedEffect(Unit) {
        while (timer > 0) {
            delay(1000L)
            timer -= 1
        }
    }

    val formattedTimer = String.format(Locale.getDefault(), "%02d:%02d", timer / 60, timer % 60)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp)
    ) {
        // Back Button
        Row(verticalAlignment = Alignment.CenterVertically) {
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
                text = "Verifikasi Alamat Email Anda",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Instruction
        Text(
            text = "Kami telah mengirimkan kode 4 digit ke alamat email Anda\n(${email}). Masukkan kode di bawah ini untuk memverifikasi akun Anda.",
            fontSize = 16.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(32.dp))

        // 4-digit input
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in 0 until 4) {
                OutlinedTextField(
                    value = code[i],
                    onValueChange = {
                        if (it.length <= 1 && it.all { c -> c.isDigit() }) {
                            code = code.toMutableList().also { list -> list[i] = it }
                        }
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Text(text = "Tidak menerima kode?", color = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Kirim Ulang",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onResend()
                    timer = 60
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Kode kedaluwarsa dalam $formattedTimer",
            color = Color(0xFF4A148C),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        // Submit button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color(0xFF3A57E8), Color(0xFF22D1EE))
                    )
                )
                .clickable {
                    if (code.all { it.isNotBlank() }) {
                        onNext()
                    } else {
                        Toast.makeText(context, "Masukkan semua 4 digit kode", Toast.LENGTH_SHORT).show()
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Verifikasi dan Buat Akun",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerifiedPage1Preview() {
    TOEFLPrepPlusTheme {
        VerifiedPage1()
    }
}
