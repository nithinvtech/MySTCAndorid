package com.example.mystcandorid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mystcandorid.navigation.AppNavigation
import com.example.mystcandorid.ui.theme.MystcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MystcTheme {
                AppNavigation()
            }
        }
    }
}
