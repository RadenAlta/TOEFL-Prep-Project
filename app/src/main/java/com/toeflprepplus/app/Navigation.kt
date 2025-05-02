package com.toeflprepplus.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.toeflprepplus.app.ui.auth.ForgotPasswordScreen
import com.toeflprepplus.app.ui.auth.ResetPasswordScreen
import com.toeflprepplus.app.ui.auth.VerifiedPage1
import com.toeflprepplus.app.ui.auth.VerifiedPage2
import com.toeflprepplus.app.ui.home.HomeScreen
import com.toeflprepplus.app.ui.login.LoginScreen
import com.toeflprepplus.app.ui.onboarding.OnboardingPagerScreen
import com.toeflprepplus.app.ui.home.DetailQuizScreen
import com.toeflprepplus.app.ui.quiz.QuizResultScreen
import com.toeflprepplus.app.ui.quiz.QuizScreen
import com.toeflprepplus.app.ui.signup.SignUpScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "onboarding") {

        // 🔹 Onboarding Screens
        composable("onboarding") {
            OnboardingPagerScreen(navController)
        }

        // 🔹 Authentication Screens
        composable("signup") {
            SignUpScreen(
                navController = navController,
                onNavigateToLogin = { navController.navigate("login") } // Pass this function here
            )
        }
        composable("login") {
            LoginScreen(
                navController = navController,
                onNavigateToSignUp = { navController.navigate("signup") },
                onNavigateToForgotPassword = { navController.navigate("forgot_password") },
                onGoogleLogin = { /* Add Google login logic */ }
            )
        }
        composable("forgot_password") {
            ForgotPasswordScreen(onBack = { navController.popBackStack() })
        }
        composable("reset_password") {
            ResetPasswordScreen(onBack = { navController.popBackStack() })
        }
        composable("verified1") {
            VerifiedPage1(onNext = { navController.navigate("verified2") })
        }
        composable("verified2") {
            VerifiedPage2(onFinish = { navController.navigate("home") })
        }

        // 🔹 Main Content Screens
        composable("home") {
            HomeScreen(
                onStartListening = { navController.navigate("quiz_listening") },
                onStartStructure = { navController.navigate("quiz_structure") },
                onStartReading = { navController.navigate("quiz_reading") }
            )
        }
        composable("quiz_listening") {
            QuizScreen(onSubmit = { navController.navigate("quiz_result") })
        }
        composable("quiz_structure") {
            QuizScreen(onSubmit = { navController.navigate("quiz_result") })
        }
        composable("quiz_reading") {
            QuizScreen(onSubmit = { navController.navigate("quiz_result") })
        }

        composable("quiz") {
            QuizScreen(
                onSubmit = { navController.navigate("quiz_result") }
            )
        }
        composable("quiz_result") {
            QuizResultScreen(onFinishQuiz = { navController.navigate("home") })
        }
        composable("quiz_detail") {
            DetailQuizScreen(
                onBack = { navController.popBackStack() },
                onStartQuiz = { navController.navigate("quiz") }
            )
        }
    }
}
