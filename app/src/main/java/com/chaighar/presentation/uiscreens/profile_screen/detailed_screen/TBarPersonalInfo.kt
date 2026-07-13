package com.chaighar.presentation.uiscreens.profile_screen.detailed_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chaighar.R
import com.chaighar.presentation.theme.IvoryWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TBarPersonalInfo(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Personal Info", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = IvoryWhite),
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.regular_outline_arrow_right),
                contentDescription = "Back",
                modifier = Modifier
                    .padding(start = 10.dp).clickable( onClick = { navController.navigateUp()} )
            )
        }
    )
}