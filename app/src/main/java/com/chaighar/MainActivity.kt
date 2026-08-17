package com.chaighar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.chaighar.presentation.navigation.NavGraph
import com.chaighar.presentation.theme.ChaiGharTheme
import com.chaighar.presentation.uiscreens.detail_screen.DetailedScreen
import com.chaighar.presentation.uiscreens.homescreen.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                NavGraph()
        }
    }
}