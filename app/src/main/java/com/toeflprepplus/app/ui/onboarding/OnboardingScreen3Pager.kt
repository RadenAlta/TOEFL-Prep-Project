package com.toeflprepplus.app.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.toeflprepplus.app.R

@Composable
fun OnboardingScreen3Pager(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.onboarding3),
                contentDescription = "Onboarding Image 3",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Atur jadwal belajar\nsesuai kebutuhan",
                fontSize = 24.sp,
                color = Color.Black,
                lineHeight = 32.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Buat rencana belajar yang fleksibel dan pantau perkembanganmu. Raih skor TOEFL impian dengan strategi yang tepat!",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                navController.navigate("signup")
            }) {
                Text("Sign up")
            }
            OutlinedButton(onClick = {
                navController.navigate("login")
            }) {
                Text("Log in")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}
