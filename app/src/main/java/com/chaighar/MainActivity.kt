package com.chaighar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.chaighar.presentation.theme.ChaiGharTheme
import com.chaighar.presentation.uiscreens.detail_screen.DetailedScreen
import com.chaighar.presentation.uiscreens.homescreen.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChaiGharTheme {
                DetailedScreen()
//                HomeScreen()
            }
        }
    }
}