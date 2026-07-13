package com.chaighar.presentation.uiscreens.profile_screen.detailed_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chaighar.presentation.theme.ChaiBrown
import com.chaighar.presentation.theme.IvoryWhite

@Composable
fun PersonalInfo(navController: NavController) {
    val address = "Kuri Road,\nShakrial Rawalpindi,\nPunjab - 44001"

    Scaffold(
        topBar = { TBarPersonalInfo(navController = navController) }
    ) { innerPadding ->

        Card(
            modifier = Modifier.padding(innerPadding).padding(16.dp).fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.fillMaxWidth().height(50.dp).background(color = ChaiBrown)
                    , contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Address", style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold, color = IvoryWhite
                    )
                }

                Text(
                    text = address, style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray, modifier = Modifier.padding(vertical = 14.dp).padding(start = 10.dp)
                )
            }
        }
    }
}