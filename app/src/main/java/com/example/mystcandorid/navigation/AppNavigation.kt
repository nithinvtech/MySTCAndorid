package com.example.mystcandorid.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mystcandorid.ui.login.LoginRoute
import com.example.mystcandorid.ui.welcome.WelcomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(
                onLogin = { navController.navigate("login") },
                onLanguageClick = {
                    // Language switch
                },
            )
        }

        composable("login") {
            LoginRoute(
                onBack = { navController.popBackStack() },
                onForgotPassword = {
                    // Password recovery screen.
                },
                onLogin = { line, password ->

                     },
            )
        }
    }
}
