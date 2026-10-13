package com.example.mystcandorid.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mystcandorid.ui.screens.LoginScreen
import com.example.mystcandorid.ui.screens.WelcomeScreen

private const val WELCOME = "welcome"
private const val LOGIN = "login"

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = WELCOME) {
        composable(WELCOME) {
            WelcomeScreen(onLogin = { navController.navigate(LOGIN) })
        }
        composable(LOGIN) {
            LoginScreen(onBack = { navController.popBackStack() })
        }
    }
}
